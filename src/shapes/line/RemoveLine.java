package shapes.line;

import models.ShapeModel;
import shapes.Command;
//import view.LoggerView;

public class RemoveLine implements Command {
	
	private ShapeModel model;
	private Line line;
	//private LoggerView log;


	public RemoveLine(ShapeModel model, Line line) {//, LoggerView log) {
		this.model=model;
		this.line = line;
		//this.log = log;

	}
	
	@Override
	public boolean execute() {
		this.model.remove(line);
		return true;

	}

	@Override
	public boolean unexecute() {
		this.model.add(line);
		return true;

	}
	
	public String toString() {
		return "Remove: " + line.toString();
	}

}
