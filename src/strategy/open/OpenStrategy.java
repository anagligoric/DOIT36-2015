package strategy.open;

import java.io.File;

import app.MainFrame;
import models.ShapeModel;

public interface OpenStrategy {
	
	public void open(ShapeModel model, MainFrame frame, File file);
	
}
