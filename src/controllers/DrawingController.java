package controllers;

import java.awt.event.MouseEvent;

import app.MainFrame;
import models.ShapeModel;
import shapes.Command;
import shapes.Shape;
import shapes.point.Point;

public class DrawingController {
	private MainFrame frame;
	private ShapeModel model;
	
	public DrawingController(ShapeModel model, MainFrame frame ) {
		this.frame = frame;
		this.model = model;
	}
	
	public void draw(Shape shape) {
		Command cmd = frame.getCommandController().generateAddCommand(shape, model);
		cmd.execute();
    	frame.getView();

	}
	public void mousePressed(MouseEvent e) {
		//Command cmd = frame.getCommandController().generateAddCommand(shape, model);
		//cmd.execute();
		//model.getUndoStack().offerLast(cmd);
		model.add(new Point(e.getX(), e.getY()));
	}

}
