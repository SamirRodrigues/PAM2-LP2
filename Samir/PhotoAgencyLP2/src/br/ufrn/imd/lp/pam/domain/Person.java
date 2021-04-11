package br.ufrn.imd.lp.pam.domain;

public class Person extends Contact {

	private String cpf;

	public Person(String name, String phone) {
		super(name, phone);
	}

	public Person(String name, String phone, String email) { super(name, phone, email); }

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
