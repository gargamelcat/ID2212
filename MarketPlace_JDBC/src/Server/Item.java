package Server;

import java.io.Serializable;

public class Item implements Serializable{

	String name = null;
	int price = 0;
	
	public Item(String name, int price){
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
