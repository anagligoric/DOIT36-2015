package shapes.hexagon;

import models.ShapeModel;
import shapes.Command;
//import view.LoggerView;

public class RemoveHexagonAdapter implements Command {

	private ShapeModel model;
	private HexagonAdapter hexagon;
	//private LoggerView log;

	
	public RemoveHexagonAdapter(ShapeModel model, HexagonAdapter hexagon) {//, LoggerView log) {
		this.model = model;
		this.hexagon = hexagon;
		//this.log = log;

	}
	
	public boolean execute() {
		this.model.remove(hexagon);
		return true;

		
	}

	@Override
	public boolean unexecute() {
		this.model.add(hexagon);
		return true;

		
	}
	public String toString() {
		return "Remove: " + hexagon.toString();
	}
}
