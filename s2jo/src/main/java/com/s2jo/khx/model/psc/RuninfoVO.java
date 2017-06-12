package com.s2jo.khx.model.psc;

public class RuninfoVO {

	private String runinfoseq; 		// ?š´?–‰? •ë³? ?‹œ???Š¤
	private String trainno;			// ?—´ì°¨ë²ˆ?˜¸
	private String departure;		// ì¶œë°œì§?
	private String departuretime;	// ì¶œë°œ?‹œê°?
	private String arrival;			// ?„ì°©ì?
	private String arrivaltime;		//
	
	private String traintype;			// ê¸°ì°¨ì¢…ë¥˜ (1: ktx, 2: 3: )
	private String perminuterate;		// ë¶„ë‹¹?š´?„ 
		
	public RuninfoVO()
	{	// ê¸°ë³¸ ?ƒ?„±?
		
	}
	
	public RuninfoVO(String runinfoseq, String trainno, String departure, String departuretime, String arrival,
			String arrivaltime, String traintype, String perminuterate) {
		this.runinfoseq = runinfoseq;
		this.trainno = trainno;
		this.departure = departure;
		this.departuretime = departuretime;
		this.arrival = arrival;
		this.arrivaltime = arrivaltime;
		this.traintype = traintype;
		this.perminuterate = perminuterate;
	}





	public String getRuninfoseq() {
		return runinfoseq;
	}

	public void setRuninfoseq(String runinfoseq) {
		this.runinfoseq = runinfoseq;
	}

	public String getTrainno() {
		return trainno;
	}

	public void setTrainno(String trainno) {
		this.trainno = trainno;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDeparturetime() {
		return departuretime;
	}

	public void setDeparturetime(String departuretime) {
		this.departuretime = departuretime;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getArrivaltime() {
		return arrivaltime;
	}

	public void setArrivaltime(String arrivaltime) {
		this.arrivaltime = arrivaltime;
	}

	public String getTraintype() {
		return traintype;
	}

	public void setTraintype(String traintype) {
		this.traintype = traintype;
	}

	public String getPerminuterate() {
		return perminuterate;
	}

	public void setPerminuterate(String perminuterate) {
		this.perminuterate = perminuterate;
	}

	
	
	
}
