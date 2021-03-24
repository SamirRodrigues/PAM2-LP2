package br.ufrn.imd.lp.pam.domain;

import java.util.ArrayList;

public class Agency extends Contact {

	private FinancialHistory financialHistory;
	private Balance lastBalance;
	private ArrayList<Photographer> photographers;

	public Agency(String name, String phone) {
		super(name, phone);
		this.financialHistory = new FinancialHistory();
		this.photographers = new ArrayList<Photographer>();
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

	public ArrayList<Photographer> getPhotographers() {
		return photographers;
	}

	public void setPhotographers(ArrayList<Photographer> photographers) {
		this.photographers = photographers;
	}

}
