package br.ufrn.imd.lp.pam.dao;

import java.util.ArrayList;
import br.ufrn.imd.lp.pam.domain.Agency;
import br.ufrn.imd.lp.pam.domain.Person;

public class Database {

	private static Database database;
	
	private Agency agency;
	private ArrayList<Person> people;

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
	
	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	public ArrayList<Person> getPeople() {
		return people;
	}

	public void setPeople(ArrayList<Person> people) {
		this.people = people;
	}
	
}
