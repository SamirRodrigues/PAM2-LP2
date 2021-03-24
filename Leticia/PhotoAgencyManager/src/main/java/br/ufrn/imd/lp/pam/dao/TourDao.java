package br.ufrn.imd.lp.pam.dao;

import br.ufrn.imd.lp.pam.domain.Order;
import br.ufrn.imd.lp.pam.domain.Photographer;
import br.ufrn.imd.lp.pam.domain.Tour;

public class TourDao {

	private Database database;
	Tour tour = new Tour();
	
	public TourDao() {
		this.database = Database.getInstance();
	}
	
	public Tour findTour(String tourName, String photographerName) {
		
		for(Photographer p : this.database.getAgency().getPhotographers()) {
			if(p.getName().equals(photographerName)) {
				for(Tour t : p.getTours()) {
					if(t.getName().equals(tourName)) {
						return t;
					}
				}
			}
		}
		//lançar exceção dado não encontrado
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
