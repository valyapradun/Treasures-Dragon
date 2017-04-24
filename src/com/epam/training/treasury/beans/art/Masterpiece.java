package com.epam.training.treasury.beans.art;

public abstract class Masterpiece extends Art {
	private int year;
	private String master;

	public Masterpiece() {
		super();
	}

	public Masterpiece(int year, String master) {
		super();
		this.year = year;
		this.master = master;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((master == null) ? 0 : master.hashCode());
		result = prime * result + year;
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
		Masterpiece other = (Masterpiece) obj;
		if (master == null) {
			if (other.master != null)
				return false;
		} else if (!master.equals(other.master))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + ", year=" + year + ", master=" + master;
	}

}
