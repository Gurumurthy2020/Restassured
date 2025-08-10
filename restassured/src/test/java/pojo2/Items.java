package pojo2;

public class Items {
	
	
	

	private String productId;
	private String name;
	private String quantity;
	
	public Items(String productId, String name, String quantity) {
		this.productId = productId;
		this.name = name;
		this.quantity = quantity;
	}
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

}
