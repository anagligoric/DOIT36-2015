package shapes.line;

import models.ShapeModel;
import shapes.Command;
//import view.LoggerView;

public class AddLine implements Command{
	
	private ShapeModel model;
	private Line line;
	//private LoggerView log;

	
	public AddLine(ShapeModel model, Line line) {//, LoggerView log) {
		this.model = model;
		this.line = line;
		//this.log = log;

	}

	@Override
	public boolean execute() {
		this.model.add(line);
		return true;

	}

	@Override
	public boolean unexecute() {
		this.model.remove(line);
		return true;

		
	}
	@Override
	public String toString() {
		return "Add: " + line.toString();
	}

}
