package drawit.shapegroups1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import drawit.IntPoint;
import drawit.IntVector;
import drawit.RoundedPolygon;

import logicalcollections.LogicalList;
import logicalcollections.LogicalSet;

public class LeafShapeGroup extends ShapeGroup {
//	 * @invar | subgroups == null || subgroups.stream().allMatch(g -> g != null && g.parent == this)

	/**
	 * @invar | (shape != null) != (subgroups != null)
	 * @invar | subgroups == null || LogicalList.distinct(subgroups)
	 * @invar | parent == null || parent.subgroups != null && parent.subgroups.contains(this)
	 * @invar | !getAncestors().contains(this)
	 */
	RoundedPolygon shape;
	
	/**
	 * Initializes this object to represent a leaf shape group that directly contains the given shape.
	 * 
	 * @throws IllegalArgumentException if {@code shape} is null
	 *    | shape == null
	 * @throws IllegalArgumentException if {@code shape} has less than three vertices
	 *    | shape.getVertices().length < 3
	 * @mutates | this
	 * @post | getShape() == shape
	 * @post | getParentGroup() == null
	 * @post | getOriginalExtent().getLeft() == Arrays.stream(shape.getVertices()).mapToInt(p -> p.getX()).min().getAsInt()
	 * @post | getOriginalExtent().getTop() == Arrays.stream(shape.getVertices()).mapToInt(p -> p.getY()).min().getAsInt()
	 * @post | getOriginalExtent().getRight() == Arrays.stream(shape.getVertices()).mapToInt(p -> p.getX()).max().getAsInt()
	 * @post | getOriginalExtent().getBottom() == Arrays.stream(shape.getVertices()).mapToInt(p -> p.getY()).max().getAsInt()
	 * @post | getExtent().equals(getOriginalExtent())
	 */
	public LeafShapeGroup(RoundedPolygon shape) {
		if (shape == null)
			throw new IllegalArgumentException("shape is null");
		if (shape.getVertices().length < 3)
			throw new IllegalArgumentException("shape has less than three vertices");
		
		this.shape = shape;
		
		IntPoint[] vertices = shape.getVertices();
		int left = Integer.MAX_VALUE;
		int top = Integer.MAX_VALUE;
		int right = Integer.MIN_VALUE;
		int bottom = Integer.MIN_VALUE;
		for (int i = 0; i < vertices.length; i++) {
			IntPoint vertex = vertices[i];
			left = Math.min(left, vertex.getX());
			top = Math.min(top, vertex.getY());
			right = Math.max(right, vertex.getX());
			bottom = Math.max(bottom, vertex.getY());
		}
		originalExtent = Extent.ofLeftTopRightBottom(left, top, right, bottom);
		currentExtent = originalExtent;
	}
	
	
	/**
	 * Returns the shape directly contained by this shape group, or {@code null} if this
	 * is a non-leaf shape group.
	 * 
	 * @immutable
	 */
	public RoundedPolygon getShape() { return shape; }
	
	
	
//	public void bringToFront() {
//		if (parent == null)
//			throw new UnsupportedOperationException("no parent");
//		
//		parent.subgroups.remove(this);
//		parent.subgroups.add(0, this);
//	}
//	
//	/**
//	 * Moves this shape group to the back of its parent's list of subgroups.
//	 * 
//	 * @throws UnsupportedOperationException if this shape group has no parent
//	 *    | getParentGroup() == null
//	 * @mutates_properties | getParentGroup().getSubgroups()
//	 * @post | getParentGroup().getSubgroups().equals(
//	 *       |     LogicalList.plus(LogicalList.minus(old(getParentGroup().getSubgroups()), this), this))
//	 */
//	public void sendToBack() {
//		if (parent == null)
//			throw new UnsupportedOperationException("no parent");
//		
//		parent.subgroups.remove(this);
//		parent.subgroups.add(this);
//	}
	
	
	
	/**
	 * Returns a textual representation of a sequence of drawing commands for drawing
	 * the shapes contained directly or indirectly by this shape group, expressed in this
	 * shape group's outer coordinate system.
	 * 
	 * For the syntax of the drawing commands, see {@code RoundedPolygon.getDrawingCommands()}.
	 * 
	 * @post | result != null
	 */
	public String getDrawingCommands() {
		StringBuilder builder = new StringBuilder();
		
		double xscale = currentExtent.getWidth() * 1.0 / originalExtent.getWidth();
		double yscale = currentExtent.getHeight() * 1.0 / originalExtent.getHeight();
		builder.append("pushTranslate " + currentExtent.getLeft() + " " + currentExtent.getTop() + "\n");
		builder.append("pushScale " + xscale + " " + yscale + "\n");
		builder.append("pushTranslate " + -originalExtent.getLeft() + " " + -originalExtent.getTop() + "\n");
		

		builder.append(shape.getDrawingCommands());

		builder.append("popTransform popTransform popTransform\n");
		return builder.toString();
	}
	
}
	