package com.epam.training.treasury.beans.clothes;

import com.epam.training.treasury.beans.Treasure;

public class Pants extends Leg{
	private double legGirth;
	
	public Pants() {
		super();
	}

	public Pants(double legGirth) {
		super();
		this.legGirth = legGirth;
	}

	public double getLegGirth() {
		return legGirth;
	}

	public void setLegGirth(double legGirth) {
		this.legGirth = legGirth;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(legGirth);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Pants other = (Pants) obj;
		if (Double.doubleToLongBits(legGirth) != Double.doubleToLongBits(other.legGirth))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pants [" + super.toString() + ", legGirth=" + legGirth + "]" + "\n";
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
