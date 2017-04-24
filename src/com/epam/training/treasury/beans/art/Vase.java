package com.epam.training.treasury.beans.art;

import com.epam.training.treasury.beans.Treasure;

public class Vase extends Art {
	private double volume;
	private boolean picture;

	public Vase() {
		super();
	}

	public Vase(double volume, boolean picture) {
		super();
		this.volume = volume;
		this.picture = picture;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
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
		result = prime * result + (picture ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(volume);
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
		Vase other = (Vase) obj;
		if (picture != other.picture)
			return false;
		if (Double.doubleToLongBits(volume) != Double.doubleToLongBits(other.volume))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vase [" + super.toString() + ", volume=" + volume + ", picture=" + picture + "]" + "\n";
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
