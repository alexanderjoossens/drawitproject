package drawit.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import drawit.DoubleVector;
import drawit.IntPoint;
import drawit.RoundedPolygon;

public class RoundedPolygonTest {

	@Test
	void test() {
		// contains_Test
		RoundedPolygon poly1 = new RoundedPolygon();
		RoundedPolygon poly3 = new RoundedPolygon();
		RoundedPolygon poly5 = new RoundedPolygon();

		IntPoint point1 = new IntPoint(2, 0);
		IntPoint point2 = new IntPoint(2, 2);
		IntPoint point3 = new IntPoint(0, 2);
		IntPoint point4 = new IntPoint(0, 0);

		IntPoint point5 = new IntPoint(100, 200);
		IntPoint point6 = new IntPoint(2, 3);
		IntPoint point7 = new IntPoint(100, 1);
		
		IntPoint point8 = new IntPoint(1, 1);
		IntPoint point9 = new IntPoint(2, 0);
		IntPoint point10 = new IntPoint(1, 0);
		IntPoint point11 = new IntPoint(2, 1);
		IntPoint point16 = new IntPoint(0, 1);
		
		IntPoint point17 = new IntPoint(0, 0);
		IntPoint point18 = new IntPoint(2, 2);
		IntPoint point19 = new IntPoint(4, 0);
		IntPoint point20 = new IntPoint(2, 0);
		IntPoint point33 = new IntPoint(100, 50);


		IntPoint[] pointArray = new IntPoint[4];

		pointArray[0] = point1;
		pointArray[1] = point2;
		pointArray[2] = point3;
		pointArray[3] = point4;
		poly1.setRadius(10);
		poly1.setVertices(pointArray);
		
		IntPoint[] pointArray3 = new IntPoint[4];

		pointArray3[0] = point17;
		pointArray3[1] = point18;
		pointArray3[2] = point19;
		pointArray3[3] = point20;
		
		poly3.setRadius(10);
		poly3.setVertices(pointArray3);

		// getRadius&getVertices_Test
		assert poly1.getRadius() == 10;
		IntPoint[] vertices = poly1.getVertices();
		assert vertices[0] == point1;
		assert vertices[1] == point2;
		assert vertices[2] == point3;
		assert vertices[3] == point4;

		
		// contains_Test
		assert poly1.contains(point5) == false;
		assert poly1.contains(point6) == false;
		assert poly1.contains(point7) == false;
		assert poly1.contains(point8) == true;
		assert poly1.contains(point9) == true;
		assert poly1.contains(point10) == true;
		assert poly1.contains(point11) == true;
		assert poly3.contains(point3) == false;
		assert poly5.contains(point33) == false;
		
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

		RoundedPolygon poly4 = new RoundedPolygon();
		IntPoint point21 = new IntPoint(1, 1);
		IntPoint point22 = new IntPoint(1, 4);
		IntPoint point23 = new IntPoint(5, 2);
		IntPoint point24 = new IntPoint(9, 4);
		IntPoint point25 = new IntPoint(9, 1);
		IntPoint point31 = new IntPoint(2, 3);
		IntPoint point32 = new IntPoint(4, 3);
		IntPoint[] pointArray4 = new IntPoint[5];
		
		pointArray4[0] = point21;
		pointArray4[1] = point22;
		pointArray4[2] = point23;
		pointArray4[3] = point24;
		pointArray4[4] = point25;
		poly4.setRadius(10);
		poly4.setVertices(pointArray4);
		assert poly4.contains(point31);
		assert !(poly4.contains(point32));
	}

}
