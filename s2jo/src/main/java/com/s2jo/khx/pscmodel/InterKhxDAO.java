package com.s2jo.khx.pscmodel;

import java.util.HashMap;
import java.util.List;


// model ?�� (DAO)?�� ?��?��?��?��?�� ?��?��

public interface InterKhxDAO {

	List<String> getImgfilenameList();	// ?��미�? ?��?���? �??��?���?
		
	List<TrainviewVO> trainList();	// 기차 ?��?�� ?���? �??��?���?

} // end of public interface InterBoardDAO ----
