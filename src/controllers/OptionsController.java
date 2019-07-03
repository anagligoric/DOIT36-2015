package controllers;

import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.JOptionPane;
import app.MainFrame;
import shapes.Command;
import shapes.Select;
import shapes.Shape;
import zcommand.BringToBack;
import zcommand.BringToFront;
import zcommand.SendToBack;
import zcommand.SendToFront;

public class OptionsController {

	private MainFrame frame;
	private int isClickedInsideShape = 0;

	public OptionsController(MainFrame frame) {
		this.frame = frame;
	}

	public void select(MouseEvent e) {
		isClickedInsideShape = 0;
		if (frame.getView().getModel().getShapes().size() == 0) {
			JOptionPane.showMessageDialog(null, "There is not shapes which can be selected", "Warning",
					JOptionPane.WARNING_MESSAGE);
		} else {
			for (int i = frame.getView().getModel().getShapes().size() - 1; i >= 0; i--) {
				if (frame.getView().getModel().getShape(i).contains(e.getX(), e.getY())) {
					isClickedInsideShape = 1;
					if (frame.getView().getModel().getShape(i).isSelected()) {
						// frame.getView().getModel().getShape(i).setSelected(false);
						Command cmd = new Select(frame.getView().getModel(), frame.getView().getModel().getShape(i));
						cmd.unexecute();
						frame.getLoggerController().logCommand(cmd);
					} else {
						// frame.getView().getModel().getShape(i).setSelected(true);
						Command cmd = new Select(frame.getView().getModel(), frame.getView().getModel().getShape(i));
						cmd.execute();
						frame.getLoggerController().logCommand(cmd);
					}

					frame.getView().getModel().notifyAllObservers();
					frame.getView().repaint();
					break;

				}
			}
			if (isClickedInsideShape == 0 && frame.getView().getModel().getSelectedShapes().size() > 0) {
				deselect();
			}
		}

	}

	public void deselect(Shape s) {
		Command cmd = new Select(frame.getView().getModel(), s);
		cmd.unexecute();
		frame.getLoggerController().logCommand(cmd);
		frame.getView().getModel().notifyAllObservers();
		frame.getView().repaint();
	}

	public void deselect() {

		Iterator<Shape> it = frame.getView().getModel().getShapes().iterator();
		while (it.hasNext()) {
			
				Command cmd = new Select(frame.getView().getModel(), it.next());
				cmd.unexecute();
				frame.getLoggerController().logCommand(cmd);
				

		}
		
		  frame.getView().getModel().notifyAllObservers(); 
		  frame.getView().repaint();
		 

	}

	public void deleteAll() {

		for (int i = frame.getView().getModel().getShapes().size() - 1; i >= 0; i--) {
			Command cmd = frame.getCommandController()
					.generateRemoveCommand(frame.getView().getModel().getShapes().get(i), frame.getView().getModel());
			if (cmd.execute()) {
				frame.getLoggerController().logCommand(cmd);
				frame.getView().getModel().getUndoStack().offerLast(cmd);
				frame.getView().getModel().notifyAllObservers();
			}
		}
		frame.getView().repaint();
	}

	public void delete() {
		// TODO Auto-generated method stub
		for (int i = frame.getView().getModel().getShapes().size() - 1; i >= 0; i--) {

			if (frame.getView().getModel().getShapes().get(i).isSelected()) {
				Command cmd = frame.getCommandController().generateRemoveCommand(
						frame.getView().getModel().getShapes().get(i), frame.getView().getModel());
				if (cmd.execute()) {
					frame.getLoggerController().logCommand(cmd);
					frame.getView().getModel().getUndoStack().offerLast(cmd);
				}

			}

		}
		frame.getView().repaint();
	}

	public void delete(Shape shape) {

		for (int i = frame.getView().getModel().getShapes().size() - 1; i >= 0; i--) {

			if (frame.getView().getModel().getShapes().get(i).equals(shape)) {
				Command cmd = frame.getCommandController().generateRemoveCommand(
						frame.getView().getModel().getShapes().get(i), frame.getView().getModel());
				if (cmd.execute()) {
					frame.getLoggerController().logCommand(cmd);
					frame.getView().getModel().getUndoStack().offerLast(cmd);
					frame.getView().getModel().notifyAllObservers();
				}

			}

		}
		frame.getView().repaint();
	}

	public void modify() {
		// TODO Auto-generated method stub
		// frame.getView().getModel().countSelectedShapes();

		// TODO implement update
		for (int i = frame.getView().getModel().getShapes().size() - 1; i >= 0; i--) {

			if (frame.getView().getModel().getShapes().get(i).isSelected()) {
				Command cmd = frame.getCommandController().generateUpdateCommand(
						frame.getView().getModel().getShapes().get(i), frame.getView().getModel());
				System.out.println(cmd.toString());
				frame.getLoggerController().logCommand(cmd);

				if (cmd.execute()) {
					frame.getView().getModel().getUndoStack().offerLast(cmd);
					frame.getView().getModel().notifyAllObservers();

				}

			}

			frame.getView().repaint();

		}

	}

	public void bringToFront() {
		// TODO Auto-generated method stub
		BringToFront cmd = new BringToFront(frame.getView().getModel());
		if (cmd.execute()) {
			frame.getLoggerController().logCommand(cmd);
			frame.getView().getModel().getUndoStack().offerLast(cmd);
			frame.getView().getModel().notifyAllObservers();

		}
		frame.getView().repaint();

	}

	public void sendToFront() {
		SendToFront cmd = new SendToFront(frame.getView().getModel());// , frame.getLogView());
		if (cmd.execute()) {
			frame.getLoggerController().logCommand(cmd);
			frame.getView().getModel().getUndoStack().offerLast(cmd);
			frame.getView().getModel().notifyAllObservers();

		}

		frame.getView().repaint();

	}

	public void bringToBack() {
		// TODO Auto-generated method stub
		BringToBack cmd = new BringToBack(frame.getView().getModel());
		if (cmd.execute()) {
			frame.getLoggerController().logCommand(cmd);
			frame.getView().getModel().getUndoStack().offerLast(cmd);
			frame.getView().getModel().notifyAllObservers();

		}
		frame.getView().repaint();

	}

	public void sendToBack() {
		SendToBack cmd = new SendToBack(frame.getView().getModel());// , frame.getLogView());
		if (cmd.execute()) {
			frame.getLoggerController().logCommand(cmd);
			frame.getView().getModel().getUndoStack().offerLast(cmd);
			frame.getView().getModel().notifyAllObservers();

		}

		frame.getView().repaint();

	}

	public void undo() {
		// TODO Auto-generated method stub
		if (!frame.getView().getModel().getUndoStack().isEmpty()) {
			Command previousCommand = frame.getView().getModel().getUndoStack().pollLast();
			// previousCommand.unexecute();
			if (previousCommand.unexecute()) {
				frame.getLoggerController().logCommand("Undo: ", previousCommand);

				frame.getView().getModel().getRedoStack().offerLast(previousCommand);
				frame.getView().getModel().notifyAllObservers();

			}
			frame.repaint();
		}
	}

	public void redo() {
		// TODO Auto-generated method stub
		if (!frame.getView().getModel().getRedoStack().isEmpty()) {
			Command previousCommand = frame.getView().getModel().getRedoStack().pollLast();
			frame.getView().getModel().getUndoStack().offerLast(previousCommand);
			if (previousCommand.execute()) {
				frame.getLoggerController().logCommand("Redo: ", previousCommand);
				frame.getView().getModel().notifyAllObservers();

			}
			frame.repaint();
		}
	}

}
