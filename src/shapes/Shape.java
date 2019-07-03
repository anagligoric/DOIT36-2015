package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public abstract class Shape implements Serializable, Comparable<Object>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String strBorderColor = "black";
	private Color clrBorderColor = Color.BLACK; 
	private boolean selected;

	public Shape() {

	}
	
	public Shape(String strBorderColor){
		this.strBorderColor = strBorderColor;
	}
	
	public Shape(Color clrBorderColor){
		this.clrBorderColor = clrBorderColor;
	}
	public abstract void draw(Graphics g);
	public abstract void selected(Graphics g);
	public abstract boolean contains(int x, int y);

	public String getStrBorderColor() {
		return strBorderColor;
	}

	public void setStrBorderColor(String strBorderColor) {
		this.strBorderColor = strBorderColor;
	}

	public Color getClrBorderColor() {
		return clrBorderColor;
	}

	public void setClrBorderColor(Color clrBorderColor) {
		this.clrBorderColor = clrBorderColor;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}



}
