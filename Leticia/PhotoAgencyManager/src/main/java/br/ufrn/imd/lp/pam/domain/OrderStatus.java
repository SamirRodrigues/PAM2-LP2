package br.ufrn.imd.lp.pam.domain;

public enum OrderStatus {

	CUSTOMER_CHOOSING_PHOTOS("Customer Choosing Photos"),
	SELECTED_PHOTOS("Selected Photos"),
	PAID("Paid"),
	EDITED("Edited"),
	DELIVERED("Delivered");

	private String info;

	OrderStatus(String info) {
		this.info = info;
	}

	public String getInfo() {
		return info;
	}
}
