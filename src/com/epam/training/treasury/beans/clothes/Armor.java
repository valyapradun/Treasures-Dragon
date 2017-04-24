package com.epam.training.treasury.beans.clothes;

import com.epam.training.treasury.beans.Treasure;

public class Armor extends Body{
	private double bodyGirth;
	private boolean picture;
	
	public Armor() {
		super();
	}
	
	public Armor(double bodyGirth, boolean picture) {
		super();
		this.bodyGirth = bodyGirth;
		this.picture = picture;
	}
	
	public double getBodyGirth() {
		return bodyGirth;
	}

	public void setBodyGirth(double bodyGirth) {
		this.bodyGirth = bodyGirth;
	}

	public boolean isPicture() {
		return picture;
	}

	public void setPicture(boolean picture) {
		this.picture = picture;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(bodyGirth);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (picture ? 1231 : 1237);
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
		Armor other = (Armor) obj;
		if (Double.doubleToLongBits(bodyGirth) != Double.doubleToLongBits(other.bodyGirth))
			return false;
		if (picture != other.picture)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Armor [" + super.toString() + ", bodyGirth=" + bodyGirth + ", picture=" + picture + "]" + "\n";
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
