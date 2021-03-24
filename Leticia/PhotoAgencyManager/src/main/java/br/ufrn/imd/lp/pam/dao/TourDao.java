package br.ufrn.imd.lp.pam.dao;

import br.ufrn.imd.lp.pam.domain.Order;
import br.ufrn.imd.lp.pam.domain.Tour;

public class TourDao {

	private Database database;
	Tour tour = new Tour();
	
	public TourDao() {
		this.database = Database.getInstance();
	}
	
	public Tour findByName(String name) {
		
		for(Tour t : database.getAgency().getTours()) {
			if(t.getName().equals(name)) {
				return t;
			}
		}
		
		return null;
	}
	
	public double salesAmount() {

		double total = 0;
		for (Order o : tour.getOrders()) {
			total += o.getPhotoPack().getValue();
		}

		return total;
	}
}
