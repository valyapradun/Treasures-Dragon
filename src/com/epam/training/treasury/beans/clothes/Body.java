package com.epam.training.treasury.beans.clothes;

public abstract class Body extends Clothes{
	private double bodyProtection;
	
	public Body() {
		super();
	}

	public Body(double bodyProtection) {
		super();
		this.bodyProtection = bodyProtection;
	}

	public double getBodyProtection() {
		return bodyProtection;
	}

	public void setBodyProtection(double bodyProtection) {
		this.bodyProtection = bodyProtection;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(bodyProtection);
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
		Body other = (Body) obj;
		if (Double.doubleToLongBits(bodyProtection) != Double.doubleToLongBits(other.bodyProtection))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + ", bodyProtection=" + bodyProtection;
	}
	
	

}
