package entities;

import java.io.Serializable;

public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Double price;
	private Integer quantity;
	private Double suned;
	
	public Product(String name, Double price, Integer quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public Double getSuned() {
		return suned;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void total(double price, int quantity) {
		suned = price * quantity;
	}

	@Override
	public String toString() {
		return name  +","+ suned +"\n";
	}
	
}
