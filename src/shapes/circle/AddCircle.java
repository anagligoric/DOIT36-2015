package shapes.circle;

import models.ShapeModel;
import shapes.Command;
//import view.LoggerView;

public class AddCircle implements Command{

	private ShapeModel model;
	private Circle circle;
	//private LoggerView log;

	
	public AddCircle(ShapeModel model, Circle circle) {//, LoggerView log) {
		this.model = model;
		this.circle = circle;
		//this.log = log;

	}
	@Override
	public boolean execute() {
		this.model.add(circle);
		return true;
	}

	@Override
	public boolean unexecute() {
		this.model.remove(circle);
		return true;

	}
	@Override
	public String toString() {
		return "Add: " + circle.toString();
	}
}
