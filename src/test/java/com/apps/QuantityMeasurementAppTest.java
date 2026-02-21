
package com.apps;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

	// FEET TESTS (converted from UC1)
	@Test
	public void testQuantity_Feet_SameValue() {
		Quantity q1 = new Quantity(1.0, Unit.FEET);
		Quantity q2 = new Quantity(1.0, Unit.FEET);
		assertTrue(q1.equals(q2));
	}

	@Test
	public void testQuantity_Feet_DifferentValue() {
		Quantity q1 = new Quantity(1.0, Unit.FEET);
		Quantity q2 = new Quantity(2.0, Unit.FEET);
		assertFalse(q1.equals(q2));
	}

	@Test
	public void testQuantity_Feet_NullComparison() {
		Quantity q1 = new Quantity(1.0, Unit.FEET);
		assertFalse(q1.equals(null));
	}

	@Test
	public void testQuantity_Feet_DifferentClass() {
		Quantity q1 = new Quantity(1.0, Unit.FEET);
		String other = "NotQuantity";
		assertFalse(q1.equals(other));
	}

	@Test
	public void testQuantity_Feet_SameReference() {
		Quantity q1 = new Quantity(1.0, Unit.FEET);
		assertTrue(q1.equals(q1));
	}

	// INCH TESTS (converted from UC2)
	@Test
	public void testQuantity_Inch_SameValue() {
		Quantity q1 = new Quantity(1.0, Unit.INCH);
		Quantity q2 = new Quantity(1.0, Unit.INCH);
		assertTrue(q1.equals(q2));
	}

	@Test
	public void testQuantity_Inch_DifferentValue() {
		Quantity q1 = new Quantity(1.0, Unit.INCH);
		Quantity q2 = new Quantity(2.0, Unit.INCH);
		assertFalse(q1.equals(q2));
	}

	@Test
	public void testQuantity_Inch_NullComparison() {
		Quantity q1 = new Quantity(1.0, Unit.INCH);
		assertFalse(q1.equals(null));
	}

	@Test
	public void testQuantity_Inch_DifferentClass() {
		Quantity q1 = new Quantity(1.0, Unit.INCH);
		String other = "NotQuantity";
		assertFalse(q1.equals(other));
	}

	@Test
	public void testQuantity_Inch_SameReference() {
		Quantity q1 = new Quantity(1.0, Unit.INCH);
		assertTrue(q1.equals(q1));
	}

	// test for UC3

	@Test
	public void testQuantity_SameValueSameUnit() {
		Quantity q1 = new Quantity(1.0, Unit.FEET);
		Quantity q2 = new Quantity(1.0, Unit.FEET);
		assertTrue(q1.equals(q2));
	}

	@Test
	public void testQuantity_DifferentValue() {
		Quantity q1 = new Quantity(1.0, Unit.FEET);
		Quantity q2 = new Quantity(2.0, Unit.FEET);
		assertFalse(q1.equals(q2));
	}

	@Test
	public void testQuantity_NullComparison() {
		Quantity q1 = new Quantity(1.0, Unit.FEET);
		assertFalse(q1.equals(null));
	}

	@Test
	public void testQuantity_DifferentClass() {
		Quantity q1 = new Quantity(1.0, Unit.FEET);
		String other = "NotQuantity";
		assertFalse(q1.equals(other));
	}

	@Test
	public void testQuantity_SameReference() {
		Quantity q1 = new Quantity(1.0, Unit.FEET);
		assertTrue(q1.equals(q1));
	}

}
