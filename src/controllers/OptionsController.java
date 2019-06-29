package controllers;

import app.MainFrame;
import shapes.Command;
import views.OptionsView;

public class OptionsController {
	
	@SuppressWarnings("unused")
	private OptionsView optionsView;
	private MainFrame frame;
	
	public OptionsController(MainFrame frame) {
		this.optionsView = frame.getOptionsView();
		this.frame=frame;
	}
		public void handleDeleteAll() {
		
			for (int i = frame.getView().getModel().getShapes().size() - 1; i >= 0; i--) {
				Command cmd = frame.getCommandController().generateRemoveCommand(frame.getView().getModel().getShapes().get(i), frame.getView().getModel());
				cmd.execute();
				//frame.getView().getModel().getUndoStack().offerLast(cmd);
	
					
			}
		frame.getView().repaint();
	}

}
