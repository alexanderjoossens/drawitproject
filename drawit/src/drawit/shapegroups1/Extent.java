package drawit.shapegroups1;

import drawit.IntPoint;		

// moet er wel overal this. voor bij laatste methods? nog vragen in forum (reminder)

public class Extent {
	
	private final int left;
	private final int top;
	private final int right;
	private final int bottom;

	/**
	 * 
	 * @param left
	 * @param top
	 * @param right
	 * @param bottom
	 */
	public Extent(int left, int top, int right, int bottom) {
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
	}

	/**
	 * Returns whether this extent, considered as a closed set of points 
	 * (i.e. including its edges and its vertices), contains the given point.
	 * @param point
	 * @return
	 */
	public boolean contains(IntPoint point) {
		return this.contains(point);
	}
	
	/**
	 * Returns the Y coordinate of the edge parallel to the X axis with the largest Y coordinate.
	 * @return
	 */
	public int getBottom() {
		return this.bottom;
	}
	
	public IntPoint getBottomRight() {
		IntPoint bottomright = new IntPoint(this.getRight(), this.getBottom());
		return bottomright;
	}
	
	/**
	 * Returns the distance between the edges that are parallel to the X axis.
	 * @return
	 */
	public int getHeight() {
		return this.getTop()-this.getBottom();
	}
	
	/**
	 * Returns the X coordinate of the edge parallel to the Y axis with the smallest X coordinate.
	 * @return
	 */
	public int getLeft() {
		return this.left;
	}
	
	/**
	 * Returns the X coordinate of the edge parallel to the Y axis with the largest X coordinate.
	 * @return
	 */
	public int getRight() {
		return this.right;
	}
	
	/**
	 * Returns the Y coordinate of the edge parallel to the X axis with the smallest Y coordinate.
	 * @return
	 */
	public int getTop() {
		return this.top;
	}
	
	public IntPoint getTopLeft() {
		IntPoint topleft = new IntPoint(this.getLeft(), this.getTop());
		return topleft;
	}
	
	/**
	 * Returns the distance between the edges that are parallel to the Y axis.
	 * @return
	 */
	public int getWidth() {
		return this.getRight()-this.getLeft();
	}
	
	public static Extent ofLeftTopRightBottom(int left, int top, int right, int bottom) {
		Extent newRectangle = new Extent(left, top, right, bottom);
		return newRectangle;
	}
	
	public static Extent ofLeftTopWidthHeight(int left, int top, int width, int height) {
		int right = left+width;
		int bottom = top-height;
		Extent newRectangle = new Extent(left, top, right, bottom);
		return newRectangle;
	}
	
	/**
	 * Returns an object that has the given bottom coordinate and the same left, top, and right coordinate as this object.
	 * @param newBottom
	 * @return
	 */
	public Extent withBottom(int newBottom) {
		Extent newextent = new Extent(this.getLeft(), this.getTop(), this.getRight(), newBottom);
		return newextent;
	}
	
	/**
	 * Returns an object that has the given height and the same left, top, and right coordinate as this object.
	 * @param NewHeight
	 * @return
	 */
	public Extent withHeight(int NewHeight) {
		int newBottom = top-NewHeight;
		Extent newextent = new Extent(this.getLeft(), this.getTop(), this.getRight(), newBottom);
		return newextent;
	}
	
	/**
	 * Returns an object that has the given left coordinate and the same right, top, and bottom coordinate as this object.
	 * @param newLeft
	 * @return
	 */
	public Extent withLeft(int newLeft) {
		Extent newextent = new Extent(newLeft, this.getTop(), this.getRight(), this.getBottom());
		return newextent;
	}
	
	/**
	 * Returns an object that has the given right coordinate and the same left, top, and bottom coordinate as this object.
	 * @param newRight
	 * @return
	 */
	public Extent withRight(int newRight) {
		Extent newextent = new Extent(this.getLeft(), this.getTop(), newRight, this.getBottom());
		return newextent;
	}
	
	/**
	 * Returns an object that has the given top coordinate and the same left, right, and bottom coordinate as this object.
	 * @param newTop
	 * @return
	 */
	public Extent withTop(int newTop) {
		Extent newextent = new Extent(this.getLeft(), newTop, this.getRight(), this.getBottom());
		return newextent;
	}
	
	/**
	 * Returns an object that has the given width and the same left, top, and bottom coordinate as this object.
	 * @param newWidth
	 * @return
	 */
	public Extent withWidth(int newWidth) {
		int newRight = left+newWidth;
		Extent newextent = new Extent(this.getLeft(), this.getTop(), newRight, this.getBottom());
		return newextent;
	}
	
}
