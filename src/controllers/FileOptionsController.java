package controllers;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import app.MainFrame;
import strategy.open.LogDecoder;
import strategy.open.OpenDrawing;
import strategy.open.OpenLog;
import strategy.open.OpenManager;
import strategy.save.SaveDrawing;
import strategy.save.SaveLog;
import strategy.save.SaveManager;
import views.FileOptionsView;
import views.LoggerView;

public class FileOptionsController {
	private MainFrame frame;
	private FileOptionsView fileOptionsView;
	private SaveManager saveManager;
	private OpenManager openManager;
	private LogDecoder decodingLog = new LogDecoder();
	private int tempLog;

	public FileOptionsController(MainFrame frame) {
		this.frame = frame;
	}

	public void saveDrawing() {
		// TODO Auto-generated method stub
		saveManager = new SaveManager(new SaveDrawing());
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("ser", "jpg", "jpeg", "png");
		chooser.setFileFilter(filter);
		int answer = chooser.showSaveDialog(fileOptionsView.getBtnSaveDrawing());

		if (answer == JFileChooser.APPROVE_OPTION) {

			File file = chooser.getSelectedFile();

			String path = file.getAbsolutePath();
			System.out.println(path);
			saveManager = new SaveManager(new SaveDrawing());
			saveManager.save(frame, file);
		}

	}

	public void openDrawing() {
		JFileChooser chooser = new JFileChooser();
		int answer = chooser.showOpenDialog(frame.getFileOptionsView().getBtnSaveDrawing());
		if (answer == JFileChooser.OPEN_DIALOG) {

			
			  if(!frame.getLoggerView().getLogs().isEmpty()) {
			  frame.getLoggerView().getLogs().clear(); this.tempLog = 0; }
			  
			 
			File file = chooser.getSelectedFile();

			String path = file.getAbsolutePath();
			System.out.println(path);
			openManager = new OpenManager(new OpenDrawing());
			openManager.open(frame.getView().getModel(), frame, file);
			frame.repaint();

		} else if (answer == JFileChooser.CANCEL_OPTION) {

		} else if (answer == JFileChooser.ERROR_OPTION) {

		}

	}

	public void saveLog() {
		// TODO Auto-generated method stub
		if (frame.getLoggerView().getLogs().isEmpty()) {
			System.out.println("Log is empty");
			return;
		}

		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "text");
		chooser.setFileFilter(filter);
		int answer = chooser.showSaveDialog(fileOptionsView.getBtnSaveLog());
		if (answer == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			String path = file.getAbsolutePath();
			System.out.println(path);
			saveManager = new SaveManager(new SaveLog());
			saveManager.save(frame, file);

		} else if (answer == JFileChooser.CANCEL_OPTION) {
			return;
		} else if (answer == JFileChooser.ERROR_OPTION) {
			System.out.println("Error while saving log");

		}
	}

	public void importLog() {

		JFileChooser chooser = new JFileChooser();
		int answer = chooser.showOpenDialog(frame.getFileOptionsView().getBtnSaveDrawing());
		if (answer == JFileChooser.OPEN_DIALOG) {
			
			System.out.println(frame.getLoggerView().getLogs());
			/* if (!frame.getLoggerView().getLogs().isEmpty()) { */
				frame.getLoggerView().getLogs().clear();
				System.out.println("gg" + frame.getLoggerView().getLogs());

				 //frame.getLoggerView().getLstLogger().setModel(frame.getLoggerView().getLogs());
				 this.tempLog = 0;
		//	}			
				 frame.getLoggerView().getLogs().clear();


			File file = chooser.getSelectedFile();

			String path = file.getAbsolutePath();
			System.out.println(path);
			openManager = new OpenManager(new OpenLog());
			openManager.open(frame.getView().getModel(), frame, file);


		} else if (answer == JFileChooser.CANCEL_OPTION) {

		} else if (answer == JFileChooser.ERROR_OPTION) {

		}

	}

	public void logNextLine() {

		if (tempLog < frame.getLoggerView().getFileBuffer().getSize()) {

			decodingLog.lineLogDecoding(frame, frame.getView().getModel(), tempLog);
			tempLog++;
		}

	}

	public FileOptionsView getFileOptionsView() {
		return fileOptionsView;
	}

	public void setFileOptionsView(FileOptionsView fileOptionsView) {
		this.fileOptionsView = fileOptionsView;
	}

	public LoggerView getLoggerView() {
		return frame.getLoggerView();
	}

	/*
	 * public void setLoggerView(LoggerView loggerView) { this.loggerView =
	 * loggerView; }
	 */

}
