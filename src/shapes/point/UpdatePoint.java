package shapes.point;

import shapes.Command;

public class UpdatePoint implements Command {
	
	private Point oldState = new Point();
	private Point original;
	private Point newState;
	//private LoggerView log;

	public UpdatePoint(Point original, Point newState) {//, LoggerView log) {
		this.original = original;
		this.newState = newState;
		//this.log = log;
	}	
	
	@Override
	public void execute() {
		oldState.setX(original.getX());
		oldState.setY(original.getY());
		oldState.setClrBorderColor(original.getClrBorderColor());
		
		original.setX(newState.getX());
		original.setY(newState.getY());
		original.setClrBorderColor(newState.getClrBorderColor());
		
		//log.getModel().addElement("Update: " + original.toString()+ " to "+ newState.toString());

	}

	@Override
	public void unexecute() {

		original.setX(oldState.getX());
		original.setY(oldState.getY());
		original.setClrBorderColor(oldState.getClrBorderColor());
		
	//	log.getModel().addElement("Undo Update: " + original.toString()+ " to "+ newState.toString());

		
	}

}
