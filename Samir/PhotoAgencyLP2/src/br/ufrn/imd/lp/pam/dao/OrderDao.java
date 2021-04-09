package br.ufrn.imd.lp.pam.dao;

import java.util.ArrayList;

import br.ufrn.imd.lp.pam.domain.Order;
import br.ufrn.imd.lp.pam.domain.Tour;

public class OrderDao {

	private Database database;

	public OrderDao() {
		this.database = Database.getInstance();
	}

	public Order findOrder(String tourName, String photographerName, String orderId) {

		TourDao td = new TourDao();
		Tour tour = td.findTour(tourName, photographerName);

		if (tour != null) {
			for (Order order : tour.getOrders()) {
				if (order.getOrderId().equals(orderId)) {
					return order;
				}
			}
		} else {
			// lançar exceção dado não encontrado
		}

		return null;
	}

	public void addOrder(Order order) {

		TourDao td = new TourDao();
		Tour tour = td.findTour(order.getTour().getName(), order.getPhotographer().getName());
		if (tour != null) {
			tour.getOrders().add(order);
		} else {
			// lançar exceção dado não encontrado
		}
	}

	public void removeOrder(Order order) {

		TourDao td = new TourDao();
		Tour tour = td.findTour(order.getTour().getName(), order.getPhotographer().getName());
		if (tour != null) {
			tour.getOrders().remove(order);
		} else {
			// lançar exceção dado não encontrado
		}
	}

	public ArrayList<Order> listOrdersByTour(String tourName, String photographerName) {

		TourDao td = new TourDao();
		Tour tour = td.findTour(tourName, photographerName);
		if (tour != null) {
			return tour.getOrders();
		} else {
			// lançar exceção dado não encontrado
			return null;
		}
	}

	public void updateOrder(Order ord) {

		TourDao td = new TourDao();
		Tour tour = td.findTour(ord.getTour().getName(), ord.getPhotographer().getName());

		if (tour == null) {
			// lançar exceção dado não encontrado
		} else {
			for (Order order : tour.getOrders()) {
				if (order.getOrderId().equals(ord.getOrderId())) {
					order = ord;
					return;
				}
			}
		}
		// lançar exceção dado não encontrado
	}

}
