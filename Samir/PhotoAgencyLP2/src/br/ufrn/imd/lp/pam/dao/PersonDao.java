package br.ufrn.imd.lp.pam.dao;

import java.util.ArrayList;

import br.ufrn.imd.lp.pam.domain.Contact;
import br.ufrn.imd.lp.pam.domain.Person;
import br.ufrn.imd.lp.pam.exception.DataNotFoundException;

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

	public ArrayList<Person> list() {
		ArrayList<Person> people = new ArrayList<Person>();
		for (Contact c : this.database.getContacts()) {
			if (c instanceof Person) {
				people.add((Person) c);
			}
		}

		return people;
	}

	public void update(Person person) throws DataNotFoundException {

		for (Contact c : this.database.getContacts()) {
			if ((c instanceof Person) && (c.getName().equals(person.getName()))) {
				c = person;
				return;
			}
		}
		throw new DataNotFoundException("Person not found");
	}

	public Person findByName(String name) throws DataNotFoundException {

		for (Contact c : database.getContacts()) {
			if ((c instanceof Person) && (c.getName().equals(name))) {
				return (Person) c;
			}
		}
		throw new DataNotFoundException("Person not found");	
	}

}