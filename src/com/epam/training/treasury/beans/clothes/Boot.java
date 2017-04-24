package com.epam.training.treasury.beans.clothes;

import com.epam.training.treasury.beans.Treasure;

public class Boot extends Leg {
	private double footGirth;

	public Boot() {
		super();
	}
	
	public Boot(double footGirth) {
		super();
		this.footGirth = footGirth;
	}

	public double getFootGirth() {
		return footGirth;
	}

	public void setFootGirth(double footGirth) {
		this.footGirth = footGirth;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(footGirth);
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
		Boot other = (Boot) obj;
		if (Double.doubleToLongBits(footGirth) != Double.doubleToLongBits(other.footGirth))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Boot [" + super.toString() + ", footGirth=" + footGirth + "]" + "\n";
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
