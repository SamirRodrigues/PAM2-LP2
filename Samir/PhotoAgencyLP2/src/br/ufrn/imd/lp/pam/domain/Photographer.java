package br.ufrn.imd.lp.pam.domain;

import java.util.ArrayList;

public class Photographer extends Contact {



	private String cpf;
	private ArrayList<Tour> tours;
	private ArrayList<Order> orders;

	public Photographer(String name, String phone) {
		super(name, phone);
		this.tours = new ArrayList<Tour>();
		this.orders = new ArrayList<Order>();
	}

	public ArrayList<Tour> getTours() {
		return tours;
	}

	public void setTours(ArrayList<Tour> tours) {
		this.tours = tours;
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

	public String getCpf() { return cpf; }

	public void setCpf(String cpf) { this.cpf = cpf; }
}
