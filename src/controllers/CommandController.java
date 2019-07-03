package controllers;


import app.MainFrame;
import dialogs.DlgModifyCircle;
import dialogs.DlgModifyHexagon;
import dialogs.DlgModifyLine;
import dialogs.DlgModifyPoint;
import dialogs.DlgModifyRectangle;
import dialogs.DlgModifySquare;
import models.CommandModel;
import models.ShapeModel;
import shapes.point.Point;
import shapes.Command;
import shapes.Shape;
import shapes.circle.*;
import shapes.line.*;
import shapes.point.*;
import shapes.rectangle.*;
import shapes.square.*;
import shapes.hexagon.*;

public class CommandController {
	@SuppressWarnings("unused")
	private CommandModel model = new CommandModel();
	@SuppressWarnings("unused")
	private MainFrame frame;
	
	public CommandController(CommandModel model, MainFrame frame) {
		this.model = model;
		this.frame = frame;
		//this.log = log;
	}
	
	public Command generateAddCommand(Shape shape, ShapeModel shapeModel)
	{
		if(shape instanceof Point) return new AddPoint(shapeModel, (Point)shape);
		else if(shape instanceof Line) return new AddLine(shapeModel, (Line)shape);
		else if(shape instanceof Circle) return new AddCircle(shapeModel, (Circle)shape);
		else if(shape instanceof Rectangle) return new AddRectangle(shapeModel, (Rectangle)shape);
		else if(shape instanceof Square) return new AddSquare(shapeModel, (Square)shape);
		else if(shape instanceof HexagonAdapter) return new AddHexagonAdapter(shapeModel, (HexagonAdapter)shape);
		return null;
	
	}
	
	public Command generateRemoveCommand(Shape shape, ShapeModel shapeModel)
	{
			if(shape instanceof Point) return new RemovePoint(shapeModel, (Point)shape);
			else if(shape instanceof Line) return new RemoveLine(shapeModel, (Line)shape);
			else if(shape instanceof Circle) return new RemoveCircle(shapeModel, (Circle)shape);
			else if(shape instanceof Rectangle) return new RemoveRectangle(shapeModel, (Rectangle)shape);
			else if(shape instanceof Square) return new RemoveSquare(shapeModel, (Square)shape);
			else if(shape instanceof HexagonAdapter) return new RemoveHexagonAdapter(shapeModel, (HexagonAdapter)shape);
			return null;
	
	}
	
	public Command generateUpdateCommand(Shape shape, ShapeModel shapeModel)
	{
		if(shape instanceof Point) 
			{
			DlgModifyPoint modifyPoint = new DlgModifyPoint((Point) shape);
			System.out.println("Generateupdate:" + shape.toString());
			modifyPoint.setVisible(true);
			if (modifyPoint.getPoint() != null) {
				System.out.println("Generateupdate after dlg:" + shape.toString());

				System.out.println("new point:" + modifyPoint.getPoint().toString());
				return new UpdatePoint((Point) shape, modifyPoint.getPoint());		
			}
			}
		else if(shape instanceof Line) {
			DlgModifyLine modifyLine = new DlgModifyLine((Line) shape);
			modifyLine.setVisible(true);
			if(modifyLine.getLine() != null) {
				return new UpdateLine((Line)shape, modifyLine.getLine());		
		}
		}
		else if(shape instanceof Circle) {
			DlgModifyCircle modifyCircle = new DlgModifyCircle((Circle) shape);
			System.out.println("Generateupdate:" + shape.toString());

			modifyCircle.setVisible(true);
			if(modifyCircle.getCircle() != null) {
				System.out.println("new point:" + modifyCircle.getCircle().toString());

				return new UpdateCircle((Circle)shape, modifyCircle.getCircle());
		}
		}
		else if(shape instanceof Rectangle && !(shape instanceof Square)) {
			DlgModifyRectangle modifyRectangle = new DlgModifyRectangle((Rectangle) shape);
			modifyRectangle.setVisible(true);
			if(modifyRectangle.getRectangle() != null) {
				return new UpdateRectangle((Rectangle)shape, modifyRectangle.getRectangle());
			}		
		}
		else if(shape instanceof Square) {
			DlgModifySquare modifySquare = new DlgModifySquare((Square) shape);
			modifySquare.setVisible(true);
			  if(modifySquare.getSquare() != null) { return new UpdateSquare((Square)shape,
					  modifySquare.getSquare()); }	 	
		}
		else if(shape instanceof HexagonAdapter) {
			DlgModifyHexagon modifyHexagon = new DlgModifyHexagon((HexagonAdapter) shape);	
			modifyHexagon.setVisible(true);
					  if(modifyHexagon.getHexagon() != null) { return new
					  UpdateHexagonAdapter((HexagonAdapter)shape, modifyHexagon.getHexagon()); }
					 }
		return null;
	}
	
	
}

	

