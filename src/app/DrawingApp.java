package app;

import controllers.OptionsController;
import controllers.CommandController;
import controllers.DrawingController;
import controllers.LoggerController;
import models.CommandModel;
import models.ShapeModel;
import shapes.observer.ButtonObserver;

public class DrawingApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShapeModel model = new ShapeModel();
		MainFrame frame = new MainFrame();
		frame.getView().setModel(model);
		DrawingController controller = new DrawingController(model, frame);
		CommandModel commandModel = new CommandModel();
		CommandController commandController = new CommandController(commandModel, frame);
		frame.setCommandController(commandController);
		frame.setDrawingController(controller);
		OptionsController optionsController = new OptionsController(frame);
		frame.setOptionsController(optionsController);
		ButtonObserver buttonObserver = new ButtonObserver(frame.getOptionsView());
		model.addObserver(buttonObserver);
		LoggerController logerController = new LoggerController();
		logerController.setView(frame.getLoggerView());
		frame.setLoggerController(logerController);
	}

}
