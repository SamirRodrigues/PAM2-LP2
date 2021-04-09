package br.ufrn.imd.lp.pam.domain;

public class Company extends Contact {

	private String cnpj;
	private String address;

	public Company(String name, String email) {
		super(name, email);
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
