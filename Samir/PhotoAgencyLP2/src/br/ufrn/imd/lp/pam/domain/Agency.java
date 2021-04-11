package br.ufrn.imd.lp.pam.domain;

import java.util.ArrayList;

public class Agency extends Contact {

	private FinancialHistory financialHistory;
	private Balance lastBalance;
	private ArrayList<Photographer> photographers;
	private ArrayList<PhotoPack> photoPacks;

	public Agency(String name, String phone) {
		super(name, phone);
		this.financialHistory = new FinancialHistory();
		this.photographers = new ArrayList<Photographer>();
		this.photoPacks = new ArrayList<PhotoPack>();
	}

	public Agency() {
		this.financialHistory = new FinancialHistory();
		this.photographers = new ArrayList<Photographer>();
		this.photoPacks = new ArrayList<PhotoPack>();
	}

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

	public ArrayList<PhotoPack> getPhotoPacks() {
		return photoPacks;
	}

	public void setPhotoPacks(ArrayList<PhotoPack> photoPacks) {
		this.photoPacks = photoPacks;
	}

}
