package drawit.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import drawit.DoubleVector;

public class DoubleVectorTest {

	@Test
	void test() {
		DoubleVector vector1 = new DoubleVector(2.5, 2.5);
		DoubleVector vector2 = new DoubleVector(2, 3);
		DoubleVector vector3 = vector1.plus(vector2);
		DoubleVector vector4 = new DoubleVector(-1, -2);
		DoubleVector vector5 = new DoubleVector(0, -2);
		DoubleVector vector6 = vector3.plus(vector4);
		DoubleVector vector7 = vector5.scale(0.5);





		// getX getY test
		assert vector1.getX() == 2.5 && vector1.getY() == 2.5;
		assert vector1.asAngle() == Math.PI / 4;
		
		// crossProduct_Test
		double product = vector1.crossProduct(vector2);
		assert product == 2.5;
		
		// dotProduct_Test
		product = vector1.dotProduct(vector2);
		assert product == 12.5;
		
		// getSize_Test
		double size = vector1.getSize();
		assert size == Math.sqrt(2.5 * 2.5 * 2);
		size = vector5.getSize();
		assert size == 2.0;

		// plus_Test
		assert vector3.getX() == 4.5 && vector3.getY() == 5.5;
		assert vector6.getX() == 3.5 && vector6.getY() == 3.5;
		
		// scale_test
		vector2 = vector3.scale(2);
		assert vector2.getX() == 9 && vector2.getY() == 11;
		vector2 = vector4.scale(-2);
		assert vector2.getX() == 2 && vector2.getY() == 4;
		assert vector7.getSize() == 1.0;


	}
}
