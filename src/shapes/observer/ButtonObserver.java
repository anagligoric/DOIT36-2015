package shapes.observer;

import views.OptionsView;
import views.ShapesView;

public class ButtonObserver implements Observer{
	
	private OptionsView optionsView;
	
	public ButtonObserver(OptionsView optionsView) {
		// TODO Auto-generated constructor stub
		this.optionsView = optionsView;
	}

	@Override
	public void update(int numberOfSelectedShapes, int numberOfUndo, int numberOfRedo) {
		// TODO Auto-generated method stub
	
		if(numberOfSelectedShapes > 0) {
			optionsView.getBtnBringToBack().setEnabled(true);
			optionsView.getBtnBringToFront().setEnabled(true);
			optionsView.getBtnDelete().setEnabled(true);
			optionsView.getBtnSendToBack().setEnabled(true);
			optionsView.getBtnSendToFront().setEnabled(true);
		} else {
			optionsView.getBtnBringToBack().setEnabled(false);
			optionsView.getBtnBringToFront().setEnabled(false);
			optionsView.getBtnDelete().setEnabled(false);
			optionsView.getBtnModify().setEnabled(false);
			optionsView.getBtnSendToBack().setEnabled(false);
			optionsView.getBtnSendToFront().setEnabled(false);
		}
		if(numberOfSelectedShapes == 1){
			optionsView.getBtnModify().setEnabled(true);

		}
		if(numberOfUndo > 0) {
			optionsView.getBtnUndo().setEnabled(true);

		}else {
			optionsView.getBtnUndo().setEnabled(false);
		}
		if(numberOfRedo > 0) {
			optionsView.getBtnRedo().setEnabled(true);

		}else {
			optionsView.getBtnRedo().setEnabled(false);

		}
		
		
	}

}
