package shapes.point;

import java.awt.Color;
import java.awt.Graphics;

import shapes.Moveable;
import shapes.Shape;

public class Point extends Shape implements Moveable{
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	private int x;
	private int y;


	public Point()
	{

	}
	
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public Point(int x, int y, String color){
		this(x, y);
		setStrBorderColor(color);
	}	
	
	public Point(int x, int y, Color color)
	{
		this(x,y);
		setClrBorderColor(color);
	}

	public String toString()
	{
		return "Point: (" + this.x + "," + this.y + "); color:"  + getClrBorderColor().getRGB();			
	}


	public boolean equals(Object obj)
	{
		if(obj instanceof Point){
			Point passed=(Point)obj;
			if(this.x==passed.getX() && this.y==passed.getY())
				return true;
			else
				return false;
		}
		else
			return false;
	}

	@Override
	public int compareTo(Object obj) {
		// TODO Auto-generated method stub
		Point zero= new Point(0,0);
		Point other  = (Point) obj;
		return (int) (this.distance(zero) - other.distance(zero));
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(getClrBorderColor());
		g.drawLine(x-2, y, x+2, y);
		g.drawLine(x, y-2, x, y+2);
		if(isSelected()) selected(g);
	}

	@Override
	public void selected(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLUE);
		g.drawRect(x-3, y-3, 6, 6);
	}

	public double distance(Point t2)
	{
		double dx = x - t2.getX();
		double dy = y - t2.y;
		return Math.sqrt(dx*dx + dy*dy);
		
	}
	@Override
	public boolean contains(int x, int y) {
		// TODO Auto-generated method stub
		if(new Point(x, y).distance(this)<=2)
			return true;
		else
			return false;
	}

	@Override
	public void moveTo(int x, int y) {
		// TODO Auto-generated method stub
		setX(x);
		setY(y);
	}

	@Override
	public void moveBy(int x, int y) {
		// TODO Auto-generated method stub
		this.x += x;
		this.y += y;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y=y;
	}

}
