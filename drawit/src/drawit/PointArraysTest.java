package drawit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PointArraysTest {

	@Test
	void test() {
		IntPoint point1 = new IntPoint(1,2);
		IntPoint point2 = new IntPoint(2,4);
		IntPoint point3 = new IntPoint(3,2);
		IntPoint point4 = new IntPoint(4,5);
		
		IntPoint[] pointArray= new IntPoint[4];
		
		pointArray[0] = point1;
		pointArray[1] = point2;
		pointArray[2] = point3;
		pointArray[3] = point4;
		
		IntPoint[] pointArray2 = PointArrays.copy(pointArray);
		
		assert pointArray[0].getX() == 1;
		assert pointArray2[0].getX() == 1;
		
		
		
		
		
		
		
		
		

	}

}
