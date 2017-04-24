package com.epam.training.treasury.beans.art;

import com.epam.training.treasury.beans.Treasure;

public class Picture extends Masterpiece {
	private int quality;
	private String paintType;

	public Picture() {
		super();
	}

	public Picture(int quality, String paintType) {
		super();
		this.quality = quality;
		this.paintType = paintType;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public String getPaintType() {
		return paintType;
	}

	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((paintType == null) ? 0 : paintType.hashCode());
		result = prime * result + quality;
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
		Picture other = (Picture) obj;
		if (paintType == null) {
			if (other.paintType != null)
				return false;
		} else if (!paintType.equals(other.paintType))
			return false;
		if (quality != other.quality)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Picture [" + super.toString() + ", quality=" + quality + ", paintType=" + paintType + "]" + "\n";
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
