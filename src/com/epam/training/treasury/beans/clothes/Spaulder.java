package com.epam.training.treasury.beans.clothes;

import com.epam.training.treasury.beans.Treasure;

public class Spaulder extends Body{
	private double shoulderGirth;
	
	public Spaulder() {
		super();
	}
	
	public Spaulder(double shoulderGirth) {
		super();
		this.shoulderGirth = shoulderGirth;
	}

	public double getShoulderGirth() {
		return shoulderGirth;
	}

	public void setShoulderGirth(double shoulderGirth) {
		this.shoulderGirth = shoulderGirth;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(shoulderGirth);
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
		Spaulder other = (Spaulder) obj;
		if (Double.doubleToLongBits(shoulderGirth) != Double.doubleToLongBits(other.shoulderGirth))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Spaulder [" + super.toString() + ", bodyGirth=" + shoulderGirth + "]" + "\n";
	}
	
	@Override
	public int compare(Treasure o1, Treasure o2) {
		Double one = ((Clothes) o1).getPrice();
		Double two = ((Clothes) o2).getPrice();
		if (one > two) {
			return 1;
		} else if (one < two) {
			return -1;
		} else {
			return 0;
		}
	}
}

