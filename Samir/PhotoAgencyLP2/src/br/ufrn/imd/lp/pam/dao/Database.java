package br.ufrn.imd.lp.pam.dao;

import java.util.ArrayList;

import br.ufrn.imd.lp.pam.domain.Agency;
import br.ufrn.imd.lp.pam.domain.Contact;

public class Database {

	private static Database database;
	
	private Agency agency;
	private ArrayList<Contact> contacts;

	private Database() {
		this.agency = new Agency();
	}
	
	public static Database getInstance() {
		
		if(database == null) {
			database = new Database();
		}
		return database;
	}

	public Agency getAgency() {
		return agency;
	}
	
	public void setAgency(Agency agency) {	this.agency = agency;	}

	public ArrayList<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(ArrayList<Contact> contacts) {
		this.contacts = contacts;
	}
	
}
