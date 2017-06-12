package com.s2jo.khx.model.lsk;

import java.util.HashMap;
import java.util.List;


// model ?�� (DAO)?�� ?��?��?��?��?�� ?��?��

public interface InterKhxDAO {

	List<String> getImgfilenameList();	// ?��미�? ?��?���? �??��?���?
		
	List<TrainviewVO> trainList();	// 기차 ?��?�� ?���? �??��?���?

} // end of public interface InterBoardDAO ----
