package shapes.point;

import models.ShapeModel;
import shapes.Command;

public class AddPoint implements Command {

	private ShapeModel model;
	private Point point;
	//private LoggerView log;
	
	public AddPoint(ShapeModel model, Point point)//, LoggerView log)
	{
		this.model = model;
		this.point = point;
		//this.log = log;
	}
	
	@Override
	public boolean execute() {
		this.model.add(point);
		return true;
	}

	@Override
	public boolean unexecute() {
		this.model.remove(point);
		return true;

	}
	
	@Override
	public String toString() {
		return "Add: " + point.toString();
	}

}
