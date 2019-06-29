package app;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.CommandController;
import controllers.DrawingController;
import controllers.OptionsController;
import views.DrawingView;
import views.FileOptionsView;
import views.OptionsView;
import views.ShapesView;

public class MainFrame extends JFrame {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DrawingView view = new DrawingView();
	private DrawingController drawingController;
	private ShapesView shapesView = new ShapesView();
	private OptionsView optionsView = new OptionsView();
	private FileOptionsView fileOptionsView = new FileOptionsView();
	private OptionsController optionsController = new OptionsController(this); 


	private CommandController commandController;


	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		getContentPane().add(view, BorderLayout.CENTER);
		getContentPane().add(shapesView, BorderLayout.NORTH);
		getContentPane().add(optionsView, BorderLayout.WEST);
		getContentPane().add(fileOptionsView, BorderLayout.EAST);
		setSize(1200,550);

		setVisible(true);
		
		view.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				//if(!selectionMode){
				drawingController.mousePressed(arg0);
				repaint();
				//}
				/*else {
					toolsController.handleSelection(arg0);
				}*/
			//}
			}
		});
		optionsView.getBtnDeleteAll().addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				optionsController.handleDeleteAll();	
			}
			
		});

	
	}

	public DrawingView getView() {
		return view;
	}

	public void setView(DrawingView view) {
		this.view = view;
	}

	public DrawingController getDrawingController() {
		return drawingController;
	}

	public void setDrawingController(DrawingController drawingController) {
		this.drawingController = drawingController;
	}

	public ShapesView getShapesView() {
		return shapesView;
	}

	public void setShapesView(ShapesView shapesView) {
		this.shapesView = shapesView;
	}

	public OptionsView getOptionsView() {
		return optionsView;
	}

	public void setOptionsView(OptionsView optionsView) {
		this.optionsView = optionsView;
	}

	public FileOptionsView getFileOptionsView() {
		return fileOptionsView;
	}

	public void setFileOptionsView(FileOptionsView fileOptionsView) {
		this.fileOptionsView = fileOptionsView;
	}

	public CommandController getCommandController() {
		return commandController;
	}

	public void setCommandController(CommandController commandController) {
		this.commandController = commandController;
	}

	public OptionsController getOptionsController() {
		return optionsController;
	}

	public void setOptionsController(OptionsController optionsController) {
		this.optionsController = optionsController;
	}
	
	

}
