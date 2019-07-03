package controllers;

import java.awt.event.MouseEvent;

import app.MainFrame;
import models.ShapeModel;
import shapes.Command;
import shapes.Shape;

public class DrawingController {
	private MainFrame frame;
	private ShapeModel model;

	public DrawingController(ShapeModel model, MainFrame frame ) {
		this.frame = frame;
		this.model = model;
	}


	public void draw(Shape shape) { 
		Command cmd = frame.getCommandController().generateAddCommand(shape, model); 
		if(cmd.execute()) {
			frame.getView().getModel().remove(frame.getShapesController().getStart());

			frame.getLoggerController().logCommand(cmd);

			frame.getView().repaint();	  
		}
		
		
	}

	public void mousePressed(MouseEvent e, Shape shape) {

		Command cmd = frame.getCommandController().generateAddCommand(shape, model);
		
		if(frame.getShapesController().isDraw()) {
			if(cmd.execute()) {
				
				frame.getLoggerController().logCommand(cmd);
				model.getUndoStack().offerLast(cmd);	

				frame.getView().getModel().notifyAllObservers();

			}
		}
		

	}

	public void makeNewDrawing() {
		// TODO Auto-generated method stub
		model.removeAllShapes();
		frame.getView().repaint();
	}
}
