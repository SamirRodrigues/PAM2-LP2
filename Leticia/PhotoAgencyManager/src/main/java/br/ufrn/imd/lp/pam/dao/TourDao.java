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

		for (Photographer p : this.database.getAgency().getPhotographers()) {
			if (p.getName().equals(photographerName)) {
				for (Tour t : p.getTours()) {
					if (t.getName().equals(tourName)) {
						return t;
					}
				}
			}
		}
		// lançar exceção dado não encontrado
		return null;
	}

	public void addTour(Tour tour) {

		for (Photographer p : this.database.getAgency().getPhotographers()) {
			if (p.getName().equals(tour.getPhotographer().getName())) {
				p.getTours().add(tour);
				return;
			}
		}
	}

	public void updateTour(Tour tour) {

		Tour t = findTour(tour.getName(), tour.getPhotographer().getName());
		if (t != null) {
			removeTour(t);
			addTour(tour);
		}
	}

	public void removeTour(Tour tour) {

		for (Photographer p : this.database.getAgency().getPhotographers()) {
			if (p.getName().equals(tour.getPhotographer().getName())) {
				p.getTours().remove(tour);
				return;
			}
		}
	}
	
	public void listTourByPhotographer(String namePhotographer) {
		
		
	}

	public double salesAmount() {

		double total = 0;
		for (Order o : tour.getOrders()) {
			total += o.getPhotoPack().getValue();
		}

		return total;
	}
}
