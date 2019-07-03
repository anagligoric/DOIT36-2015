package shapes.square;

import java.awt.Color;
import java.awt.Graphics;

import shapes.FilledShape;
import shapes.Moveable;
import shapes.line.Line;
import shapes.point.Point;

public class Square extends FilledShape implements Moveable{
	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	protected Point upperLeft;
	protected int sideLength;
	

	public Square() {

	}

	public Square(Point upperLeft, int sideLength) {
		this.upperLeft = upperLeft;
		this.sideLength = sideLength;
	}

	public Square(Point upperLeft, int sideLength, String color) {
		this(upperLeft, sideLength);
		setStrBorderColor(color);
	}
	public Square(Point upperLeft, int sideLength, Color borderColor, Color clrInnerColor) {
		this(upperLeft, sideLength);
		setClrBorderColor(borderColor);
		setClrInnerColor(clrInnerColor);
	}
	public Square(Point upperLeft, int sideLength, String borderColor, String clrInnerColor) {
		this(upperLeft, sideLength);
		setStrBorderColor(borderColor);
		setStrInnerColor(clrInnerColor);
	}
	public Line diagonal(){
		return new Line(upperLeft, new Point(upperLeft.getX() + sideLength,upperLeft.getY() + sideLength));
	}

	public Point center(){
		return diagonal().midpoint();
	}
	public String toString() {
		return "Square: (" + this.upperLeft.getX() + "," + this.upperLeft.getY() + "); lengthSide:" + this.sideLength + "; outer color:" + getClrBorderColor().getRGB() + "; inside color:" + Integer.toString(getClrInnerColor().getRGB());
	}

	public boolean equals(Object obj) {
		if (obj instanceof Square) {
			Square passed = (Square) obj;
			if (this.upperLeft.equals(passed.upperLeft) && this.sideLength == passed.sideLength)
				return true;
			else
				return false;
		} else
			return false;
	}
	
	public void moveTo(int x, int y) {
		upperLeft.setX(x);
		upperLeft.setY(y);
	}

	public void moveBy(int x, int y) {
		upperLeft.setX(upperLeft.getX() + x);
		upperLeft.setY(upperLeft.getY() + y);
	}

	public int perimeter() {
		return 4*sideLength;
	}

	public int area() {
		return sideLength * sideLength;
	}
	public boolean contains(int x, int y) {
		if(this.getUpperLeft().getX()<=x 
				&& x<=(this.getUpperLeft().getX() + sideLength)
				&& this.getUpperLeft().getY()<=y 
				&& y<=(this.getUpperLeft().getY() + sideLength))
			return true;
		else 
			return false;
	}
	public void selected(Graphics g) {
		
		g.setColor(Color.BLUE);
		new Line(getUpperLeft(), new Point(getUpperLeft().getX()+sideLength, getUpperLeft().getY())).selected(g);
		new Line(getUpperLeft(), new Point(getUpperLeft().getX(), getUpperLeft().getY()+sideLength)).selected(g);
		new Line(new Point(getUpperLeft().getX()+sideLength, getUpperLeft().getY()), diagonal().getpEnd()).selected(g);
		new Line(new Point(getUpperLeft().getX(), getUpperLeft().getY()+sideLength), diagonal().getpEnd()).selected(g);

	}
	public void draw(Graphics g){
		g.setColor(getClrBorderColor());
		g.drawRect(upperLeft.getX(), upperLeft.getY(), sideLength, sideLength);
		this.fill(g);
		if(isSelected()) selected(g);
	}
	public void fill(Graphics g){
		g.setColor(getClrInnerColor());
		g.fillRect(upperLeft.getX()+1, upperLeft.getY()+1, sideLength-1, sideLength-1);
	}
	public int compareTo(Object o) {
		if(o instanceof Square){
			Square passed  = (Square) o;
			return this.area() - passed.area();
		}
		else 
			return 0;
	}

	public Point getUpperLeft() {
		return upperLeft;
	}

	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}

	public int getSideLength() {
		return sideLength;
	}

	public void setSideLength(int sideLength) {
		this.sideLength = sideLength;
	}


}
