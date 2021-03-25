package br.ufrn.imd.lp.pam.dao;

import java.util.ArrayList;

import br.ufrn.imd.lp.pam.domain.Company;
import br.ufrn.imd.lp.pam.domain.Contact;

public class CompanyDao {

	private Database database;

	public CompanyDao() {
		this.database = Database.getInstance();
	}

	public void add(Company company) {
		this.database.getContacts().add(company);
	}

	public void remove(Company company) {
		this.database.getContacts().remove(company);
	}

	public ArrayList<Company> list() {
		ArrayList<Company> companies = new ArrayList<Company>();
		for (Contact c : this.database.getContacts()) {
			if (c instanceof Company) {
				companies.add((Company) c);
			}
		}

		return companies;
	}

	public void update(Company company) {

		for (Contact c : this.database.getContacts()) {
			if ((c instanceof Company) && (c.getName().equals(company.getName()))) {
				c = company;
				return;
			}
		}
		// lancar excecao de dado nao encontrado
	}

	public Company findByName(String name) {

		for (Contact c : database.getContacts()) {
			if ((c instanceof Company) && (c.getName().equals(name))) {
				return (Company) c;
			}
		}
		return null;
	}

}