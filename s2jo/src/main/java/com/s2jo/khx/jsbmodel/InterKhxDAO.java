package com.s2jo.khx.jsbmodel;

import java.util.HashMap;
import java.util.List;


// model ?¨ (DAO)? ?Έ?°??΄?€ ??±

public interface InterKhxDAO {

	List<String> getImgfilenameList();	// ?΄λ―Έμ? ??Όλͺ? κ°?? Έ?€κΈ?
		
	List<TrainviewVO> trainList();	// κΈ°μ°¨ ?΄? ? λ³? κ°?? Έ?€κΈ?

} // end of public interface InterBoardDAO ----
