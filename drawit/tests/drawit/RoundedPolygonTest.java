package drawit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RoundedPolygonTest {

	@Test
	void test() {
		// contains_Test
		RoundedPolygon poly1 = new RoundedPolygon();
		IntPoint point1 = new IntPoint(2, 0);
		IntPoint point2 = new IntPoint(2, 2);
		IntPoint point3 = new IntPoint(0, 2);
		IntPoint point4 = new IntPoint(0, 0);

		IntPoint point5 = new IntPoint(-1, 0);
		IntPoint point6 = new IntPoint(2, 3);
		IntPoint point7 = new IntPoint(-1, 1);
		
		IntPoint point8 = new IntPoint(1, 1);
		IntPoint point9 = new IntPoint(2, 0);
		IntPoint point10 = new IntPoint(1, 0);
		IntPoint point11 = new IntPoint(2, 1);
		IntPoint point16 = new IntPoint(0, 1);


		IntPoint[] pointArray = new IntPoint[4];

		pointArray[0] = point1;
		pointArray[1] = point2;
		pointArray[2] = point3;
		pointArray[3] = point4;
		poly1.setRadius(10);
		poly1.setVertices(pointArray);
		
		// getRadius&getVertices_Test
		assert poly1.getRadius() == 10;
		assert poly1.getVertices() == pointArray;
		
		// contains_Test
		assert poly1.contains(point5) == false;
		assert poly1.contains(point6) == false;
		assert poly1.contains(point7) == false;
		assert poly1.contains(point8) == true;
		assert poly1.contains(point9) == true;
		assert poly1.contains(point10) == true;
		assert poly1.contains(point11) == true;
		
		// insert_Test
		poly1.insert(0, point10);
		assert poly1.getVertices().length == 5;
		assert poly1.getVertices()[0] == point10;

		poly1.insert(4, point16);
		assert poly1.getVertices().length == 6;
		assert poly1.getVertices()[4] == point16;
		assert poly1.getVertices()[5] == point4;

		// remove_Test
		poly1.remove(0);
		assert poly1.getVertices().length == 5;
		assert poly1.getVertices()[0] == point1;

		poly1.remove(3);
		assert poly1.getVertices().length == 4;
		assert poly1.getVertices()[3] == point4;
		
		// update_Test
		poly1.update(0, point10);
		assert poly1.getVertices().length == 4;
		assert poly1.getVertices()[0] == point10;

		poly1.update(3, point16);
		assert poly1.getVertices().length == 4;
		assert poly1.getVertices()[3] == point16;
		
		// normalize_Test
		DoubleVector vector1 = new DoubleVector(2,0);
		DoubleVector vector2 = RoundedPolygon.normalize(vector1);
		
		assert (vector2.getSize() < 1.01 && vector2.getSize() > 0.99);
				
		
		// getDrawingCommands_Test
		RoundedPolygon poly2 = new RoundedPolygon();
		IntPoint point12 = new IntPoint(0, 0);
		IntPoint point13 = new IntPoint(10, 0);
		IntPoint point14 = new IntPoint(10, 10);
		IntPoint point15 = new IntPoint(0, 10);
		IntPoint[] pointArray2 = new IntPoint[4];

		pointArray2[0] = point12;
		pointArray2[1] = point13;
		pointArray2[2] = point14;
		pointArray2[3] = point15;
		poly2.setRadius(10);
		poly2.setVertices(pointArray2);
		
		assertEquals("line 0.0 5.0 0.0 5.0\n" + 
				"line 5.0 0.0 5.0 0.0\n" + 
				"arc 5.0 5.0 5.0 3.141592653589793 1.5707963267948966\n" + 
				"line 5.0 0.0 5.0 0.0\n" + 
				"line 10.0 5.0 10.0 5.0\n" + 
				"arc 5.0 5.0 5.0 -1.5707963267948966 1.5707963267948966\n" + 
				"line 10.0 5.0 10.0 5.0\n" + 
				"line 5.0 10.0 5.0 10.0\n" + 
				"arc 5.0 5.0 5.0 0.0 1.5707963267948966\n" + 
				"line 5.0 10.0 5.0 10.0\n" + 
				"line 0.0 5.0 0.0 5.0\n" + 
				"arc 5.0 5.0 5.0 1.5707963267948966 1.5707963267948966\n", poly2.getDrawingCommands());
		
		assertEquals("line 0.5 0.5 0.5000000000000001 0.4999999999999999\n" + 
				"line 1.5 1.0 1.316227766016838 0.6324555320336758\n" + 
				"arc 0.8603796100280632 0.8603796100280633 0.5096537321044141 -2.3561944901923444 1.892546881191538\n" + 
				"line 1.5 1.0 1.5 1.0\n" + 
				"line 1.0 2.0 0.8819660112501051 2.0\n" + 
				"arc 0.8819660112501051 1.3090169943749475 0.6909830056250524 -0.4636476090008061 2.0344439357957027\n" + 
				"line 1.0 2.0 1.0 2.0\n" + 
				"line 0.0 1.5 0.0 1.0\n" + 
				"arc 1.0 1.0 1.0 1.5707963267948966 1.5707963267948966\n" + 
				"line 0.0 1.5 0.0 1.7071067811865475\n" + 
				"line 0.5 0.5 0.5 0.5\n" + 
				"arc 1.707106781186547 1.7071067811865475 1.707106781186547 3.141592653589793 0.7853981633974483\n" + 
				"",poly1.getDrawingCommands());
	}

}
