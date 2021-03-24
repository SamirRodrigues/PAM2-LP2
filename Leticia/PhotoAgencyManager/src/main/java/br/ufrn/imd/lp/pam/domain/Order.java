package br.ufrn.imd.lp.pam.domain;

import java.util.Date;

public class Order {

	private Person client;
	private Photographer photographer;
	private PhotoPack photoPack;
	private OrderStatus orderStatus;
	private Date requestDate;
	private Date deliveryDate;
	private Tour tour;

	public Person getClient() {
		return client;
	}

	public void setClient(Person client) {
		this.client = client;
	}

	public Photographer getPhotographer() {
		return photographer;
	}

	public void setPhotographer(Photographer photographer) {
		this.photographer = photographer;
	}

	public PhotoPack getPhotoPack() {
		return photoPack;
	}

	public void setPhotoPack(PhotoPack photoPack) {
		this.photoPack = photoPack;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Tour getTour() {
		return tour;
	}

	public void setTour(Tour tour) {
		this.tour = tour;
	}

}
