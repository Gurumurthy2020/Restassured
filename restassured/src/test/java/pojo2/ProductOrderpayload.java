package pojo2;

import java.util.List;

public class ProductOrderpayload {
	

	private String orderid;

	private Customer customer;

	private List<Items> items;
	
	public ProductOrderpayload(String orderid, Customer customer, List<Items> items) {
		this.orderid = orderid;
		this.customer = customer;
		this.items = items;
	}
	
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}
	
}
