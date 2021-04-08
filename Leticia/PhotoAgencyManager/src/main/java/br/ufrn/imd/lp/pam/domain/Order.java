package br.ufrn.imd.lp.pam.domain;

import java.util.Date;
import java.util.UUID;

public class Order {

	private String orderId;
	private Person client;
	private Photographer photographer;
	private PhotoPack photoPack;
	private OrderStatus orderStatus;
	private Date requestDate;
	private Date deliveryDate;
	private Tour tour;

	public Order(Person client, Photographer photographer, Tour tour, PhotoPack photoPack) {
		this.client = client;
		this.photographer = photographer;
		this.tour = tour;
		this.orderStatus = OrderStatus.CUSTOMER_CHOOSING_PHOTOS;
		this.requestDate = new Date();
		this.orderId = createId();
	}

	private String createId() {

		String uuid = UUID.randomUUID().toString().substring(25);

		return uuid;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

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
