package com.epam.training.treasury.beans;

import java.util.Comparator;

public abstract class Treasure implements Cloneable, Comparator<Treasure> {
	private int id;

	public Treasure() {
	}
	
	public Treasure(int id) {
		this.id = id;
	}

	public Treasure clone() throws CloneNotSupportedException{
		Treasure obj = (Treasure)super.clone();
        return obj;
    }
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Treasure other = (Treasure) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Treasure [id=" + id + "]";
	}
	
	

}
