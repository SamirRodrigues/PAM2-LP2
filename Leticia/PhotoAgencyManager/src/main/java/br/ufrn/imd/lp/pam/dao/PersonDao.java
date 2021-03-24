package br.ufrn.imd.lp.pam.dao;

import java.util.ArrayList;

import br.ufrn.imd.lp.pam.domain.Person;

public class PersonDao {

	private Database database;
	
	public PersonDao() {
		this.database = Database.getInstance();
	}
	
	public void add(Person person) {
		this.database.getContacts().add(person);
	}
	
	public void remove(Person person) {
		this.database.getContacts().remove(person);
	}
	
	public ArrayList<Person> list(){
		return this.database.getContacts();
	}
	
	public void update(Person person) {
		for(Person p: this.database.getContacts()) {
			if(p.getName().equals(person.getName())) {
				p = person;
				return;
			}
		}
		//lancar excecao de dado nao encontrado	 
	}
		
}
