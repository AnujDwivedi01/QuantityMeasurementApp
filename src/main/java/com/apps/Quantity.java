package com.apps;

public class Quantity {

	private final double value;
	private final Unit unit;

	public Quantity(double value, Unit unit) {
		this.value = value;
		this.unit = unit;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null || getClass() != obj.getClass())
			return false;

		Quantity other = (Quantity) obj;

		return Double.compare(this.value, other.value) == 0 && this.unit == other.unit;
	}

}