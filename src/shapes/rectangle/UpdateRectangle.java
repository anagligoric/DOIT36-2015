package shapes.rectangle;

import shapes.Command;
import shapes.circle.Circle;
import shapes.point.Point;
//import view.LoggerView;

public class UpdateRectangle implements Command {
	
	private Rectangle oldState = new Rectangle(new Point(0,0), 0, 0);
	private Rectangle original;
	private Rectangle newState;
	//private LoggerView log;

	
	public UpdateRectangle(Rectangle original, Rectangle newState) {
		this.original = original;
		this.newState = newState;

	}

	@Override
	public boolean execute() {
		oldState.getUpperLeft().setX(original.getUpperLeft().getX());
		oldState.getUpperLeft().setY(original.getUpperLeft().getY());
		oldState.setSideLength(original.getSideLength());
		oldState.setWidth(original.getWidth());
		oldState.setClrBorderColor(original.getClrBorderColor());
		oldState.setClrInnerColor(original.getClrInnerColor());
		
		original.getUpperLeft().setX(newState.getUpperLeft().getX());
		original.getUpperLeft().setY(newState.getUpperLeft().getY());
		original.setSideLength(newState.getSideLength());
		original.setWidth(newState.getWidth());
		original.setClrBorderColor(newState.getClrBorderColor());
		original.setClrInnerColor(newState.getClrInnerColor());
		
		return true;

		
	}

	@Override
	public boolean unexecute() {
		original.getUpperLeft().setX(oldState.getUpperLeft().getX());
		original.getUpperLeft().setY(oldState.getUpperLeft().getY());
		original.setSideLength(oldState.getSideLength());
		original.setWidth(oldState.getWidth());
		original.setClrBorderColor(oldState.getClrBorderColor());
		original.setClrInnerColor(oldState.getClrInnerColor());
		
		return true;

		
		
	}
	public String toString() {
		return "Update: " + original.toString()+ " to "+ newState.toString();
	}

}
