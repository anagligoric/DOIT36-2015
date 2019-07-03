package controllers;

import java.util.ArrayList;

import shapes.Command;
import views.LoggerView;

public class LoggerController {
	LoggerView view;

	
	public LoggerView getView() {
		return view;
	}

	public void setView(LoggerView view) {
		this.view = view;
	}

	public void logCommand(Command cmd) {
		view.getLogs().addElement(cmd.toString());
		//System.out.println(cmd.toString());
	}
	
	// for UNDO and REDO
	public void logCommand(String option, Command cmd) {
		view.getLogs().addElement(option + cmd.toString());
	}
	
}
