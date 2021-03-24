package br.ufrn.imd.lp.pam.dao;

import java.util.ArrayList;

import br.ufrn.imd.lp.pam.domain.Person;

public class PersonDao {

	private Database database;
	
	public PersonDao() {
		this.database = Database.getInstance();
	}
	
	public void addPerson(Person person) {
		this.database.getPeople().add(person);
	}
	
	public void removePerson(Person person) {
		this.database.getPeople().remove(person);
	}
	
	public ArrayList<Person> listPeople(){
		return this.database.getPeople();
	}
	
	public void updatePerson(Person person) {
		for(Person p: this.database.getPeople()) {
			if(p.getName().equals(person.getName())) {
				p = person;
				return;
			}
		}
		//lancar excecao de dado nao encontrado	 
	}
		
}
