package Server;

import java.io.Serializable;

public  class Trader implements Serializable{

	private static final long serialVersionUID = 1L;
	
	String name = null;

	public Trader(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
