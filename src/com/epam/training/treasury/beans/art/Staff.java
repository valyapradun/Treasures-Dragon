package com.epam.training.treasury.beans.art;

import com.epam.training.treasury.beans.Treasure;

public class Staff extends Art {
	private double length;
	private String tipType;

	public Staff() {
		super();
	}

	public Staff(double length, String tipType) {
		super();
		this.length = length;
		this.tipType = tipType;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public String getTipType() {
		return tipType;
	}

	public void setTipType(String tipType) {
		this.tipType = tipType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(length);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((tipType == null) ? 0 : tipType.hashCode());
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
		Staff other = (Staff) obj;
		if (Double.doubleToLongBits(length) != Double.doubleToLongBits(other.length))
			return false;
		if (tipType == null) {
			if (other.tipType != null)
				return false;
		} else if (!tipType.equals(other.tipType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Staff [" + super.toString() + ", length=" + length + ", tipType=" + tipType + "]" + "\n";
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
