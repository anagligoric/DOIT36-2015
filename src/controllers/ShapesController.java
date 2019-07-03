package controllers;

import java.awt.event.MouseEvent;

import app.MainFrame;
import dialogs.DlgAddCircle;
import dialogs.DlgAddHexagon;
import dialogs.DlgAddRectangle;
import dialogs.DlgAddSquare;
import shapes.Shape;
import shapes.line.Line;
import shapes.point.Point;
import views.ShapesView;

public class ShapesController {

	public Point getStart() {
		return start;
	}


	//private ShapesView shapesView;
	private Shape shape;
	private MainFrame frame;
	private boolean clicked = false;
	private Point start;
	private boolean draw;


	public Shape getShape(MouseEvent e)
	{
		String shapeName = frame.getShapesView().getCmbShapes().getSelectedItem().toString();
		System.out.print(shapeName);
		switch(shapeName)
		{
		case "Point": 
			draw = true;

			shape =  new Point(e.getX(), e.getY(), frame.getShapesView().getBtnBorderColor().getSelectedColor());
			break;

		case "Line": {
			draw = true;

			if(!clicked) {
				start = new Point(e.getX(), e.getY());
				shape=start;
				clicked = true;
			}
			else {
				shape = new Line(start, new Point(e.getX(), e.getY()), frame.getShapesView().getBtnBorderColor().getSelectedColor());
				frame.getView().getModel().remove(start);
				clicked = false;
			}

		};break;


		case "Rectangle": 
		{

			DlgAddRectangle dlgAddRectangle = new DlgAddRectangle(e.getX(), e.getY(), frame.getShapesView().getBtnBorderColor().getSelectedColor(),
					frame.getShapesView().getBtnInnerColor().getSelectedColor());
			dlgAddRectangle.setVisible(true);
			if(dlgAddRectangle.getAnswer()) {
				draw = true;

				shape = dlgAddRectangle.getRectangle();
			}else {
				draw = false;
			}
		}
		;break;




		case "Square": { 
			DlgAddSquare dlgAddSquare= new DlgAddSquare(e.getX(),
					e.getY(), frame.getShapesView().getBtnBorderColor().getSelectedColor(),
					frame.getShapesView().getBtnInnerColor().getSelectedColor());
			dlgAddSquare.setVisible(true);
			if(dlgAddSquare.getAnswer()) { 
				draw = true;

				shape = 
						dlgAddSquare.getSquare(); 
			}else {
				draw = false;

				System.out.print(dlgAddSquare.getAnswer()); 
			}
		};
		break;

		case "Circle":{
			DlgAddCircle dlgAddCircle= new DlgAddCircle(e.getX(),
					e.getY(), frame.getShapesView().getBtnBorderColor().getSelectedColor(),
					frame.getShapesView().getBtnInnerColor().getSelectedColor());
			dlgAddCircle.setVisible(true);
			if(dlgAddCircle.getAnswer()) { 
				draw = true;

				shape = dlgAddCircle.getCircle(); 
			}else {
				draw = false;

				System.out.print(dlgAddCircle.getAnswer()); 
			}
		};
		break;

		case "Hexagon":{


			DlgAddHexagon dlgAddHexagon= new DlgAddHexagon(e.getX(),
					e.getY(), frame.getShapesView().getBtnBorderColor().getSelectedColor(),
					frame.getShapesView().getBtnInnerColor().getSelectedColor());
			dlgAddHexagon.setVisible(true);
			if(dlgAddHexagon.getAnswer()) { 
				draw = true;

				shape = 
						dlgAddHexagon.getHexagon(); 
			}else {
				draw = false;

				System.out.print(dlgAddHexagon.getAnswer()); 
			}
		};
		break;
		}
		return shape;

	}


	public boolean isDraw() {
		return draw;
	}


	public void setDraw(boolean draw) {
		this.draw = draw;
	}


	public MainFrame getFrame() {
		return frame;
	}


	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}


	public ShapesView getShapesView() {
		return frame.getShapesView();
	}


	



}
