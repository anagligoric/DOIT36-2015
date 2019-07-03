package models;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

import shapes.Command;
import shapes.Shape;
import shapes.observer.Observer;
import shapes.observer.Subject;

public class ShapeModel implements Subject{

	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private Deque<Command> redoStack = new LinkedList<>();
	private Deque<Command> undoStack = new LinkedList<>();
	private ArrayList<Shape> selectedShapes = new ArrayList<>();
	ArrayList<Observer> observerList = new ArrayList<>();


	public void add(Shape s) {
		shapes.add(s);
	}

	public boolean remove(Shape s) {
		return shapes.remove(s);
	}

	public int getShapeIndex(Shape s) {
		return shapes.indexOf(s);
	}

	public Shape getShape(int index) {
		return shapes.get(index);
	}

	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public ArrayList<Shape> getSelectedShapes() { 
		
		selectedShapes.clear(); 
		for(int i = shapes.size() - 1; i >= 0; i--) { 
			if (shapes.get(i).isSelected()) {

				selectedShapes.add(shapes.get(i)); 
			}
		} 
		return selectedShapes; 
	}

	
	  public void removeAllShapes() { shapes.clear(); redoStack.clear();
	  undoStack.clear(); }
	 

	public int countSelectedShapes() { selectedShapes.clear(); for (int i =
			shapes.size() - 1; i >= 0; i--) { if (shapes.get(i).isSelected()) {
				selectedShapes.add(shapes.get(i)); } }

	return selectedShapes.size(); }
	
	

	@Override
	public void notifyAllObservers() {
		// TODO Auto-generated method stub
		for (Observer observer : observerList) {
			countSelectedShapes();
			System.out.println(getUndoStack().size());
			observer.update(selectedShapes.size(), getUndoStack().size(), getRedoStack().size());		
		}
	}

	@Override
	public void addObserver(Observer observer) {
		// TODO Auto-generated method stub
		observerList.add(observer);

	}

	@Override
	public void deleteObserver(Observer observer) {
		// TODO Auto-generated method stub
		observerList.remove(observer);

	}
	
	
	  public Deque<Command> getRedoStack() { return redoStack; }
	  
	  public Deque<Command> getUndoStack() { return undoStack; }
 
	
	 
	 

}
