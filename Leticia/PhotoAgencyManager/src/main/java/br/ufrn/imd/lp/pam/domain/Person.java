package br.ufrn.imd.lp.pam.domain;

import java.util.ArrayList;

public class Person extends Contact {

	private String cpf;
	private ArrayList<Order> orders;

	public Person(String name, String phone) {
		super(name, phone);
		this.orders = new ArrayList<Order>();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
}
