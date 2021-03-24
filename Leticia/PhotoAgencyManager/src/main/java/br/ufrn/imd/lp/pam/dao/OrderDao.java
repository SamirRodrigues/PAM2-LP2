package br.ufrn.imd.lp.pam.dao;

import java.util.ArrayList;

import br.ufrn.imd.lp.pam.domain.Order;
import br.ufrn.imd.lp.pam.domain.Tour;

public class OrderDao {

	private Database database;

	public OrderDao() {
		this.database = Database.getInstance();
	}

	public void addOrder(String name, Order order) {

		TourDao td = new TourDao();
		Tour tour = td.findByName(name);
		if (tour != null) {
			tour.getOrders().add(order);
		}
		else {
			//lançar exceção dado não encontrado
		}
	}
	
	public void removeOrder(String name, Order order) {

		TourDao td = new TourDao();
		Tour tour = td.findByName(name);
		if (tour != null) {
			tour.getOrders().remove(order);
		}
		else {
			//lançar exceção dado não encontrado
		}
	}
	
	public ArrayList<Order> listOrdersByTour(String name) {

		TourDao td = new TourDao();
		Tour tour = td.findByName(name);
		if (tour != null) {
			return tour.getOrders();
		}
		else {
			//lançar exceção dado não encontrado
			return null;
		}
	}

}
