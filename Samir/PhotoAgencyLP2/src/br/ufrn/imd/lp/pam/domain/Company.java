package br.ufrn.imd.lp.pam.domain;

public class Company extends Contact {

	private String cnpj;
	private String address;
	private Person owner;

	public Company(String name, String email) {
		super(name, email);
	}
	public Company(String name, String phone, String email, Person owner) {
		super(name, phone, email);
		this.owner = owner;
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

	public Person getOwner() { return owner; }

	public void setOwner(Person owner) { this.owner = owner; }


}
