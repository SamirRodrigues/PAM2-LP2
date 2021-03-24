package br.ufrn.imd.lp.pam.domain;

public class Phone {

	private String ddd;
	private String number;
	private String type; // telephone, cell phone

	public Phone(String ddd, String number) {
		this.ddd = ddd;
		this.number = number;
		this.type = "Cell phone";
	}

	public Phone(String ddd, String number, String type) {
		this.ddd = ddd;
		this.number = number;
		this.type = type;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
