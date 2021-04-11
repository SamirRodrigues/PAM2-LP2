package br.ufrn.imd.lp.pam.dao;

import java.util.ArrayList;

import br.ufrn.imd.lp.pam.domain.Order;
import br.ufrn.imd.lp.pam.domain.Tour;
import br.ufrn.imd.lp.pam.exception.DataNotFoundException;

public class OrderDao {

	private Database database;

	public OrderDao() {
		this.database = Database.getInstance();
	}

	public Order findOrder(String tourName, String photographerName, String orderId) throws DataNotFoundException {

		TourDao td = new TourDao();
		Tour tour = td.findTour(tourName, photographerName);

		for (Order order : tour.getOrders()) {
			if (order.getOrderId().equals(orderId)) {
				return order;
			}
		}

		throw new DataNotFoundException("Order not found");
	}

	public void addOrder(Order order) throws DataNotFoundException {

		TourDao td = new TourDao();
		Tour tour = td.findTour(order.getTour().getName(), order.getPhotographer().getName());
		tour.getOrders().add(order);

	}

	public void removeOrder(Order order) throws DataNotFoundException {

		TourDao td = new TourDao();
		Tour tour = td.findTour(order.getTour().getName(), order.getPhotographer().getName());
		tour.getOrders().remove(order);

	}

	public ArrayList<Order> listOrdersByTour(String tourName, String photographerName) throws DataNotFoundException {

		TourDao td = new TourDao();
		Tour tour = td.findTour(tourName, photographerName);
		return tour.getOrders();
	}

	public void updateOrder(Order ord) throws DataNotFoundException {

		TourDao td = new TourDao();
		Tour tour = td.findTour(ord.getTour().getName(), ord.getPhotographer().getName());

		for (Order order : tour.getOrders()) {
			if (order.getOrderId().equals(ord.getOrderId())) {
				order = ord;
				return;
			}
		}
		throw new DataNotFoundException("Order not found for update");
	}

}
