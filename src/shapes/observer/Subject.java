package shapes.observer;


public interface Subject {
	void notifyAllObservers();
	void addObserver(Observer observer);	
	void deleteObserver(Observer observer);	

}
