package com.epam.training.treasury.beans.clothes;

import com.epam.training.treasury.beans.Treasure;

public class Helmet extends Clothes {
	private double headProtection;
	private double headGirth;

	public Helmet() {
		super();
	}

	public Helmet(double headProtection, double headGirth) {
		super();
		this.headProtection = headProtection;
		this.headGirth = headGirth;
	}

	public double getHeadProtection() {
		return headProtection;
	}

	public void setHeadProtection(double headProtection) {
		this.headProtection = headProtection;
	}

	public double getHeadGirth() {
		return headGirth;
	}

	public void setHeadGirth(double headGirth) {
		this.headGirth = headGirth;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(headGirth);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(headProtection);
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
		Helmet other = (Helmet) obj;
		if (Double.doubleToLongBits(headGirth) != Double.doubleToLongBits(other.headGirth))
			return false;
		if (Double.doubleToLongBits(headProtection) != Double.doubleToLongBits(other.headProtection))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Helmet [" + super.toString() + ", headProtection=" + headProtection + ", headGirth=" + headGirth + "]"
				+ "\n";
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
