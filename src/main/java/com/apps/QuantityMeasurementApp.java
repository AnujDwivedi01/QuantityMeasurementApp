
package com.apps;

public class QuantityMeasurementApp {

	public static void demonstrateFeetEquality() {
		Quantity f1 = new Quantity(1.0, Unit.FEET);
		Quantity f2 = new Quantity(1.0, Unit.FEET);

		System.out.println("Feet Equal: " + f1.equals(f2));
	}

	public static void demonstrateInchesEquality() {
		Quantity i1 = new Quantity(1.0, Unit.INCH);
		Quantity i2 = new Quantity(1.0, Unit.INCH);

		System.out.println("Inches Equal: " + i1.equals(i2));
	}

	public static void main(String[] args) {
		demonstrateFeetEquality();
		demonstrateInchesEquality();
	}

}
