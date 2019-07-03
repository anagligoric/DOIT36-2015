package shapes.square;

import models.ShapeModel;
import shapes.Command;
//import view.LoggerView;

public class AddSquare implements Command {

	private ShapeModel model;
	private Square square;
	//private LoggerView log;

	
	public AddSquare(ShapeModel model, Square square) {//, LoggerView log) {
		this.model = model;
		this.square = square;
		//this.log = log;

	}
	@Override
	public boolean execute() {
		this.model.add(square);
		return true;

	}

	@Override
	public boolean unexecute() {
		this.model.remove(square);
		return true;

		
	}
	@Override
	public String toString() {
		return "Add: " + square.toString();
	}
}
