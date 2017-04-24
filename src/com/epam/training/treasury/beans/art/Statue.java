package com.epam.training.treasury.beans.art;

import com.epam.training.treasury.beans.Treasure;

public class Statue extends Masterpiece {
	private double weight;
	private double size;

	public Statue() {
		super();
	}

	public Statue(double weight, double size) {
		super();
		this.weight = weight;
		this.size = size;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(size);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Statue other = (Statue) obj;
		if (Double.doubleToLongBits(size) != Double.doubleToLongBits(other.size))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Statue [" + super.toString() + ", weight=" + weight + ", size=" + size + "]" + "\n";
	}

	@Override
	public int compare(Treasure o1, Treasure o2) {
		Double one = ((Art) o1).getPrice();
		Double two = ((Art) o2).getPrice();
		if (one > two) {
			return 1;
		} else if (one < two) {
			return -1;
		} else {
			return 0;
		}
	}

}
