package shapes.rectangle;

import models.ShapeModel;
import shapes.Command;
//import view.LoggerView;

public class RemoveRectangle implements Command {

	private ShapeModel model;
	private Rectangle rectangle;
	//private LoggerView log;

	
	public RemoveRectangle(ShapeModel model, Rectangle rectangle) {//, LoggerView log) {
		this.model = model;
		this.rectangle = rectangle;
		//this.log = log;

	
	}
	@Override
	public boolean execute() {
		this.model.remove(rectangle);
		return true;

		
	}

	@Override
	public boolean unexecute() {
		this.model.add(rectangle);
		return true;

	}
	public String toString() {
		return "Remove: " + rectangle.toString();
	}
}
