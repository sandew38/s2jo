package com.s2jo.khx.jsbmodel;

public class TraininfoVO {
	
	private String traintype;			// ê¸°ì°¨ì¢…ë¥˜ (1: ktx, 2: 3: )
	private String trainno;				// ?—´ì°¨ë²ˆ?˜¸
	private String perminuterate;		// ë¶„ë‹¹?š´?„ 
	
	RuninfoVO RuninfoVO;
	
	public TraininfoVO()
	{	// ê¸°ë³¸ ?ƒ?„±?
		
	}
	
	public TraininfoVO(String traintype, String trainno, String perminuterate) {
		super();
		this.traintype = traintype;
		this.trainno = trainno;
		this.perminuterate = perminuterate;
	}

	public String getTraintype() {
		return traintype;
	}

	public void setTraintype(String traintype) {
		this.traintype = traintype;
	}

	public String getTrainno() {
		return trainno;
	}

	public void setTrainno(String trainno) {
		this.trainno = trainno;
	}

	public String getPerminuterate() {
		return perminuterate;
	}

	public void setPerminuterate(String perminuterate) {
		this.perminuterate = perminuterate;
	}
	
	
	
	
}
