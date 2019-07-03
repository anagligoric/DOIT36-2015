package shapes.point;

import models.ShapeModel;
import shapes.Command;
//import views.LoggerView;

public class RemovePoint implements Command {


	private ShapeModel model;
	private Point point;
	//private LoggerView log;
	
	public RemovePoint(ShapeModel model, Point point)//, LoggerView log)
	{
		this.model = model;
		this.point = point;
		//this.log = log;
	}
	@Override
	public boolean execute() {
		this.model.remove(point);
		return true;
		}

	@Override
	public boolean unexecute() {
		this.model.add(point);
		return true;

		
	}
	public String toString() {
		return "Remove: " + point.toString();
	}

}
