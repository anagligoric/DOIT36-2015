package strategy.open;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.DefaultListModel;

import app.*;
import models.ShapeModel;

public class OpenLog implements OpenStrategy {

	@Override
	public void open(ShapeModel drawingModel, MainFrame drawingFrame, File file)  {
		String line = null;
		 try {
	    
			 	drawingFrame.getLoggerView().getLogs().clear();

	            FileReader fileReader = new FileReader(file);

	            BufferedReader bufferedReader = new BufferedReader(fileReader);
	            drawingFrame.getDrawingController().makeNewDrawing();

	            
	            while((line = bufferedReader.readLine()) != null) {
	            	System.out.println(line);
	            	
	            	drawingFrame.getLoggerView().getFileBuffer().addElement(line);

	            }   


	            bufferedReader.close();         
	        }
	        catch(FileNotFoundException ex) {
	            System.out.println("Unable to open file '" + file + "'");                
	        }
	        catch(IOException ex) {
	            System.out.println("Error reading file '" + file + "'");                  
	            ex.printStackTrace();
	        }
		
	}


}