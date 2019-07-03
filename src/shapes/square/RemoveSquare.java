package shapes.square;

import models.ShapeModel;
import shapes.Command;
//import view.LoggerView;

public class RemoveSquare implements Command {

	private ShapeModel model;
	private Square square;
	//private LoggerView log;

	
	public RemoveSquare(ShapeModel model, Square square) {//, LoggerView log) {
		this.model = model;
		this.square = square;
		///this.log = log;

	}
	@Override
	public boolean execute() {
		this.model.remove(square);
		return true;

	}

	@Override
	public boolean unexecute() {
		this.model.add(square);
		return true;

	}
	public String toString() {
		return "Remove: " + square.toString();
	}
}
