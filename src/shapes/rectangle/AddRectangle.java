package shapes.rectangle;

import models.ShapeModel;
import shapes.Command;
//import view.LoggerView;

public class AddRectangle implements Command{
	private ShapeModel model;
	private Rectangle rectangle;

	
	public AddRectangle(ShapeModel model, Rectangle rectangle) {//, LoggerView log) {
		this.model = model;
		this.rectangle = rectangle;
		//this.log = log;

	}
	

	@Override
	public boolean execute() {
		this.model.add(rectangle);
		return true;

		
	}

	@Override
	public boolean unexecute() {
		this.model.remove(rectangle);
		return true;

		
	}
	@Override
	public String toString() {
		return "Add: " + rectangle.toString();
	}

}
