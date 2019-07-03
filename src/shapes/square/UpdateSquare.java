package shapes.square;

import shapes.Command;
import shapes.point.Point;
//import view.LoggerView;

public class UpdateSquare implements Command {

	private Square oldState = new Square(new Point(0,0), 0);
	private Square original;
	private Square newState;
	//private LoggerView log;

	
	public UpdateSquare(Square original, Square newState) {//, LoggerView log) {
		this.original = original;
		this.newState = newState;
		//this.log = log;

	}
	
	@Override
	public boolean execute() {
		oldState.getUpperLeft().setX(original.getUpperLeft().getX());
		oldState.getUpperLeft().setY(original.getUpperLeft().getY());
		oldState.setSideLength(original.getSideLength());
		oldState.setClrBorderColor(original.getClrBorderColor());
		oldState.setClrInnerColor(original.getClrInnerColor());
		
		original.getUpperLeft().setX(newState.getUpperLeft().getX());
		original.getUpperLeft().setY(newState.getUpperLeft().getY());
		original.setSideLength(newState.getSideLength());
		original.setClrBorderColor(newState.getClrBorderColor());
		original.setClrInnerColor(newState.getClrInnerColor());
		
		return true;

	}

	@Override
	public boolean unexecute() {
		original.getUpperLeft().setX(oldState.getUpperLeft().getX());
		original.getUpperLeft().setY(oldState.getUpperLeft().getY());
		original.setSideLength(oldState.getSideLength());
		original.setClrBorderColor(oldState.getClrBorderColor());
		original.setClrInnerColor(oldState.getClrInnerColor());
		
		return true;

		
	}
	public String toString() {
		return "Update: " + original.toString()+ " to "+ newState.toString();
	}
}
