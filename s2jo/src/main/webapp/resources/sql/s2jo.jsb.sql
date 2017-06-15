show user;

select *
from tab;

select *
from final_member;

 insert into final_member(userid, name,pwd,email,birthday)
values('asd','asd','asd123!@#','wltmdqo12@naver.com',sysdate); 
--추천게시판
create table final_recommendBoard
(seq           number                not null   -- 글번호
,userid        varchar2(20)          not null   -- 사용자ID
,name          Nvarchar2(20)         not null   -- 글쓴이
,subject       Nvarchar2(200)        not null   -- 글제목
,content       Nvarchar2(2000)       not null   -- 글내용    -- clob
,pw            varchar2(20)          not null   -- 글암호
,readCount     number default 0      not null   -- 글조회수
,regDate       date default sysdate  not null   -- 글쓴시간
,status        number(1) default 1   not null   -- 글삭제여부  1:사용가능한글,  0:삭제된글 
,commentCount  number default 0      not null   -- 댓글수
,groupno       number                not null   -- 답변글쓰기에 있어서 그룹번호
                                                -- 원글(부모글)과 답변글은 동일한 groupno 를 가진다. 
                                                -- 답변글이 아닌 원글(부모글)인 경우 groupno 의 값은 groupno 컬럼의 최대값(max)+1 로 한다.  
                                                
,fk_seq        number default 0      not null   -- fk_seq 컬럼은 절대로 foreign key가 아니다.
                                                -- fk_seq 컬럼은 자신의 글(답변글)에 있어서 
                                                -- 원글(부모글)이 누구인지에 대한 정보값이다.
                                                -- 답변글쓰기에 있어서 답변글이라면 fk_seq 컬럼의 값은 
                                                -- 원글(부모글)의 seq 컬럼의 값을 가지게 되며,
                                                -- 답변글이 아닌 원글일 경우 0 을 가지도록 한다.
                                                
,depthno       number default 0       not null  -- 답변글쓰기에 있어서 답변글 이라면                                                
                                                -- 원글(부모글)의 depthno + 1 을 가지게 되며,
                                                -- 답변글이 아닌 원글일 경우 0 을 가지도록 한다.

, fileName     varchar2(255)     -- WAS(톰캣)에 저장될 파일명(20161121324325454354353333432.png)
, orgFilename  varchar2(255)     -- 진짜 파일명(강아지.png)   // 사용자가 파일을 업로드 하거나 파일을 다운로드 할때 사용되어지는 파일명
, fileSize     number            -- 파일크기

,constraint  PK_final_recommendBoard_seq primary key(seq)
,constraint  FK_final_recommendBoard_userid foreign key(userid) 
                                       references final_member(userid)
,constraint  CK_final_recommendBoard_status check( status in(0,1) )
);
--drop table final_recommendBoard purge;

create sequence final_recommendBoard_Seq
start with 1
increment by 1
nomaxvalue 
nominvalue
nocycle
nocache;

select *
from final_recommendBoard;

delete from final_recommendBoard;
commit;



create table final_recommendComment
(seq        number               not null   -- 댓글번호
,userid     varchar2(20)         not null   -- 사용자ID
,name       varchar2(20)         not null   -- 성명
,content    varchar2(1000)       not null   -- 댓글내용
,regDate    date default sysdate not null   -- 작성일자
,parentSeq  number               not null   -- 원게시물 글번호
,status     number(1) default 1  not null   -- 글삭제여부
                                            -- 1 : 사용가능한 글,  0 : 삭제된 글
                                            -- 댓글은 원글이 삭제되면 자동적으로 삭제되어야 한다.
,constraint PK_final_recComment_seq primary key(seq)
,constraint FK_final_recComment_userid foreign key(userid)
                                        references final_member(userid)
,constraint FK_final_recComment_parentSeq foreign key(parentSeq) 
                                           references final_recommendBoard(seq)
,constraint CK_final_recComment_status check( status in(1,0) ) 
);


create sequence final_recComment_Seq
start with 1
increment by 1
nomaxvalue 
nominvalue
nocycle
nocache;


--함께해요게시판
create table final_togetherBoard
(seq           number                not null   -- 글번호
,userid        varchar2(20)          not null   -- 사용자ID
,name          Nvarchar2(20)         not null   -- 글쓴이
,subject       Nvarchar2(200)        not null   -- 글제목
,content       Nvarchar2(2000)       not null   -- 글내용    -- clob
,pw            varchar2(20)          not null   -- 글암호
,readCount     number default 0      not null   -- 글조회수
,regDate       date default sysdate  not null   -- 글쓴시간
,status        number(1) default 1   not null   -- 글삭제여부  1:사용가능한글,  0:삭제된글 
,commentCount  number default 0      not null   -- 댓글수
,groupno       number                not null   -- 답변글쓰기에 있어서 그룹번호
                                                -- 원글(부모글)과 답변글은 동일한 groupno 를 가진다. 
                                                -- 답변글이 아닌 원글(부모글)인 경우 groupno 의 값은 groupno 컬럼의 최대값(max)+1 로 한다.  
                                                
,fk_seq        number default 0      not null   -- fk_seq 컬럼은 절대로 foreign key가 아니다.
                                                -- fk_seq 컬럼은 자신의 글(답변글)에 있어서 
                                                -- 원글(부모글)이 누구인지에 대한 정보값이다.
                                                -- 답변글쓰기에 있어서 답변글이라면 fk_seq 컬럼의 값은 
                                                -- 원글(부모글)의 seq 컬럼의 값을 가지게 되며,
                                                -- 답변글이 아닌 원글일 경우 0 을 가지도록 한다.
                                                
,depthno       number default 0       not null  -- 답변글쓰기에 있어서 답변글 이라면                                                
                                                -- 원글(부모글)의 depthno + 1 을 가지게 되며,
                                                -- 답변글이 아닌 원글일 경우 0 을 가지도록 한다.

, fileName     varchar2(255)     -- WAS(톰캣)에 저장될 파일명(20161121324325454354353333432.png)
, orgFilename  varchar2(255)     -- 진짜 파일명(강아지.png)   // 사용자가 파일을 업로드 하거나 파일을 다운로드 할때 사용되어지는 파일명
, fileSize     number            -- 파일크기

,constraint  PK_final_togetherBoard_seq primary key(seq)
,constraint  FK_final_togetherBoard_userid foreign key(userid) 
                                       references final_member(userid)
,constraint  CK_final_togetherBoard_status check( status in(0,1) )
);
--drop table final_recommendBoard purge;

create sequence final_togetherBoard_Seq
start with 1
increment by 1
nomaxvalue 
nominvalue
nocycle
nocache;



create table final_togetherComment
(seq        number               not null   -- 댓글번호
,userid     varchar2(20)         not null   -- 사용자ID
,name       varchar2(20)         not null   -- 성명
,content    varchar2(1000)       not null   -- 댓글내용
,regDate    date default sysdate not null   -- 작성일자
,parentSeq  number               not null   -- 원게시물 글번호
,status     number(1) default 1  not null   -- 글삭제여부
                                            -- 1 : 사용가능한 글,  0 : 삭제된 글
                                            -- 댓글은 원글이 삭제되면 자동적으로 삭제되어야 한다.
,constraint PK_final_togeComment_seq primary key(seq)
,constraint FK_final_togeComment_userid foreign key(userid)
                                        references final_member(userid)
,constraint FK_final_togeComment_parentSeq foreign key(parentSeq) 
                                           references final_recommendBoard(seq)
,constraint CK_final_togeComment_status check( status in(1,0) ) 
);


create sequence final_togeComment_Seq
start with 1
increment by 1
nomaxvalue 
nominvalue
nocycle
nocache;


--위험해요게시판
create table final_worryingBoard
(seq           number                not null   -- 글번호
,userid        varchar2(20)          not null   -- 사용자ID
,name          Nvarchar2(20)         not null   -- 글쓴이
,subject       Nvarchar2(200)        not null   -- 글제목
,content       Nvarchar2(2000)       not null   -- 글내용    -- clob
,pw            varchar2(20)          not null   -- 글암호
,readCount     number default 0      not null   -- 글조회수
,regDate       date default sysdate  not null   -- 글쓴시간
,status        number(1) default 1   not null   -- 글삭제여부  1:사용가능한글,  0:삭제된글 
,commentCount  number default 0      not null   -- 댓글수
,groupno       number                not null   -- 답변글쓰기에 있어서 그룹번호
                                                -- 원글(부모글)과 답변글은 동일한 groupno 를 가진다. 
                                                -- 답변글이 아닌 원글(부모글)인 경우 groupno 의 값은 groupno 컬럼의 최대값(max)+1 로 한다.  
                                                
,fk_seq        number default 0      not null   -- fk_seq 컬럼은 절대로 foreign key가 아니다.
                                                -- fk_seq 컬럼은 자신의 글(답변글)에 있어서 
                                                -- 원글(부모글)이 누구인지에 대한 정보값이다.
                                                -- 답변글쓰기에 있어서 답변글이라면 fk_seq 컬럼의 값은 
                                                -- 원글(부모글)의 seq 컬럼의 값을 가지게 되며,
                                                -- 답변글이 아닌 원글일 경우 0 을 가지도록 한다.
                                                
,depthno       number default 0       not null  -- 답변글쓰기에 있어서 답변글 이라면                                                
                                                -- 원글(부모글)의 depthno + 1 을 가지게 되며,
                                                -- 답변글이 아닌 원글일 경우 0 을 가지도록 한다.

, fileName     varchar2(255)     -- WAS(톰캣)에 저장될 파일명(20161121324325454354353333432.png)
, orgFilename  varchar2(255)     -- 진짜 파일명(강아지.png)   // 사용자가 파일을 업로드 하거나 파일을 다운로드 할때 사용되어지는 파일명
, fileSize     number            -- 파일크기

,constraint  PK_final_worryingBoard_seq primary key(seq)
,constraint  FK_final_worryingBoard_userid foreign key(userid) 
                                       references final_member(userid)
,constraint  CK_final_worryingBoard_status check( status in(0,1) )
);
--drop table final_recommendBoard purge;

create sequence final_worryingBoard_Seq
start with 1
increment by 1
nomaxvalue 
nominvalue
nocycle
nocache;



create table final_worryingComment
(seq        number               not null   -- 댓글번호
,userid     varchar2(20)         not null   -- 사용자ID
,name       varchar2(20)         not null   -- 성명
,content    varchar2(1000)       not null   -- 댓글내용
,regDate    date default sysdate not null   -- 작성일자
,parentSeq  number               not null   -- 원게시물 글번호
,status     number(1) default 1  not null   -- 글삭제여부
                                            -- 1 : 사용가능한 글,  0 : 삭제된 글
                                            -- 댓글은 원글이 삭제되면 자동적으로 삭제되어야 한다.
,constraint PK_final_worComment_seq primary key(seq)
,constraint FK_final_worComment_userid foreign key(userid)
                                        references final_member(userid)
,constraint FK_final_worComment_parentSeq foreign key(parentSeq) 
                                           references final_recommendBoard(seq)
,constraint CK_final_worComment_status check( status in(1,0) ) 
);


create sequence final_worComment_Seq
start with 1
increment by 1
nomaxvalue 
nominvalue
nocycle
nocache;


