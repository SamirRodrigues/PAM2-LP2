package br.ufrn.imd.lp.pam.domain;

import java.util.ArrayList;
import java.util.Date;

public class Tour {

	private String name;
	private Date date;
	private Company company;
	private Photographer photographer;
	private ArrayList<Order> orders;
	private ArrayList<Person> clients;
	private TourType tourType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Photographer getPhotographer() {
		return photographer;
	}

	public void setPhotographer(Photographer photographer) {
		this.photographer = photographer;
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

	public ArrayList<Person> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Person> clients) {
		this.clients = clients;
	}

	public TourType getTourType() {
		return tourType;
	}
}
