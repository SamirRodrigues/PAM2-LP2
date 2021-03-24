package br.ufrn.imd.lp.pam.domain;

import java.util.ArrayList;

public class Agency extends Contact {

	private FinancialHistory financialHistory;
	private Balance lastBalance;
	private ArrayList<Photographer> photographers;
	private ArrayList<Tour> tours;

	public Agency(String name, String phone) {
		super(name, phone);
		this.financialHistory = new FinancialHistory();
		this.photographers = new ArrayList<Photographer>();
		this.tours = new ArrayList<Tour>();
	}
	
	public Agency() {}

	public void addBalance(Balance balance) {

		this.financialHistory.addBalance(balance);
		this.lastBalance = balance;
	}

	public FinancialHistory getFinancialHistory() {
		return financialHistory;
	}

	public void setFinancialHistory(FinancialHistory financialHistory) {
		this.financialHistory = financialHistory;
	}

	public Balance getLastBalance() {
		return lastBalance;
	}

	public void setLastBalance(Balance lastBalance) {
		this.lastBalance = lastBalance;
	}

	public ArrayList<Photographer> getPhotographer() {
		return photographers;
	}

	public void setPhotographer(ArrayList<Photographer> photographers) {
		this.photographers = photographers;
	}

	public ArrayList<Tour> getTours() {
		return tours;
	}

	public void setTours(ArrayList<Tour> tours) {
		this.tours = tours;
	}

}
