package com.epam.training.treasury.beans.clothes;

public abstract class Leg extends Clothes{
	private boolean legProtection;

	public Leg() {
		super();
	}
	
	public Leg(boolean legProtection) {
		super();
		this.legProtection = legProtection;
	}

	public boolean isLegProtection() {
		return legProtection;
	}

	public void setLegProtection(boolean legProtection) {
		this.legProtection = legProtection;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (legProtection ? 1231 : 1237);
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
		Leg other = (Leg) obj;
		if (legProtection != other.legProtection)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + ", legProtection=" + legProtection;
	}

}
