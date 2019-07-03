package shapes;

import models.ShapeModel;

public class Select implements Command{
	
	private ShapeModel shapeModel;
	private Shape shape;
	private String cmd = "";

	public Select(ShapeModel shapeModel, Shape shape) {
		this.shapeModel = shapeModel;
		this.shape = shape;
	}
	@Override
	public boolean execute() {
		// TODO Auto-generated method stub
		shape.setSelected(true);
		cmd = "Select: ";
		return true;
	}

	@Override
	public boolean unexecute() {
		// TODO Auto-generated method stub
		shape.setSelected(false);
		cmd = "Deselect: ";

		return true;	}
	
	public String toString() {
		return cmd + shape.toString();
	}

}
