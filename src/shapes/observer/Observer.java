package shapes.observer;

public interface Observer {
	public void update(int numberOfSelectedShapes, int numberOfUndo, int numberOfRedo);
}
