package shapes.circle;

import models.ShapeModel;
import shapes.Command;
//import view.LoggerView;

public class RemoveCircle implements Command {

	private ShapeModel model;
	private Circle circle;
//	private LoggerView log;

	
	public RemoveCircle(ShapeModel model, Circle circle) {//, LoggerView log) {
		this.model =model;
		this.circle=circle;
	//	this.log = log;

	}
	@Override
	public boolean execute() {
		this.model.remove(circle);
		return true;

	}

	@Override
	public boolean unexecute() {
		this.model.add(circle);
		return true;

	}

}
