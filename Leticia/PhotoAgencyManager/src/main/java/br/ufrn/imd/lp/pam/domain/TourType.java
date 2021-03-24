package br.ufrn.imd.lp.pam.domain;

public enum TourType {

	TRAIL("Trail"),
	TOUR("Tour");
	
	private String info;
	
	TourType(String info) {
		this.info = info;
	}

	public String getInfo() {
		return info;
	}
}
