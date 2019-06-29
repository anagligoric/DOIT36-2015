package views;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;

import javax.swing.JPanel;

import models.ShapeModel;
import shapes.Shape;

public class DrawingView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ShapeModel model;

	/**
	 * Create the panel.
	 */
	public DrawingView() {
		setBackground(Color.WHITE);
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (model != null) {

			Iterator<Shape> it = model.getShapes().iterator();
			while (it.hasNext()) {
				it.next().draw(g);
			}	
		}
		
		
	}

	public ShapeModel getModel() {
		return model;
	}

	public void setModel(ShapeModel model) {
		this.model = model;
	}

}
