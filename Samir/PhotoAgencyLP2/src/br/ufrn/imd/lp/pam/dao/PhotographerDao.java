package br.ufrn.imd.lp.pam.dao;

import java.util.ArrayList;
import br.ufrn.imd.lp.pam.domain.Contact;
import br.ufrn.imd.lp.pam.domain.Photographer;

public class PhotographerDao {

	private Database database;
	
	public PhotographerDao() {
		this.database = Database.getInstance();
	}
	
	public void add(Photographer photographer) {
		this.database.getContacts().add(photographer);
	}
	
	public void remove(Photographer photographer) {
		this.database.getContacts().remove(photographer);
	}
	
	public ArrayList<Photographer> list(){
		ArrayList<Photographer> photographers = new ArrayList<Photographer>();
		for(Contact c: this.database.getContacts()) {
			if(c instanceof Photographer){
				photographers.add((Photographer)c);
			}
		}
		
		return photographers;
	}

	public ArrayList<Photographer> listAgencyPhotographers(){
		ArrayList<Photographer> photographers = new ArrayList<Photographer>();
		for(Photographer c: this.database.getAgency().getPhotographers())
		{
			photographers.add(c);
		}

		return photographers;
	}
	
	public void update(Photographer photographer) {
		
		for(Contact c: this.database.getContacts()) {
			if((c instanceof Photographer) && (c.getName().equals(photographer.getName()))) {
				c = photographer;
				return;
			}
		}
		//lancar excecao de dado nao encontrado	 
	}
	
	public Photographer findByName(String name) {
		
		for(Contact c: database.getContacts()) {
			if((c instanceof Photographer) && (c.getName().equals(name))) {
				return (Photographer)c;
			}
		}
		return null;
	}
	public Photographer findByNameAgency(String name) {

		for(Photographer c: database.getAgency().getPhotographers()) {
			if((c.getName().equals(name))) {
				return c;
			}
		}
		return null;
	}
		
}