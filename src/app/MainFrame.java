package app;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.CommandController;
import controllers.DrawingController;
import controllers.FileOptionsController;
import controllers.LoggerController;
import controllers.OptionsController;
import controllers.ShapesController;
import views.DrawingView;
import views.FileOptionsView;
import views.LoggerView;
import views.OptionsView;
import views.ShapesView;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean select;

	private JPanel contentPane;
	private DrawingView view = new DrawingView();
	private DrawingController drawingController;
	private ShapesView shapesView = new ShapesView();
	private OptionsView optionsView = new OptionsView();
	private FileOptionsView fileOptionsView = new FileOptionsView();
	private OptionsController optionsController = new OptionsController(this);
	private ShapesController shapesController = new ShapesController();
	private FileOptionsController fileOptionsController = new FileOptionsController(this);
	private LoggerController loggerController = new LoggerController();
	private LoggerView loggerView = new LoggerView();
	private CommandController commandController;

	/**
	 * Create the frame.
	 */
	public MainFrame() {

		shapesController.setFrame(this);
		select = false;
		setTitle("Ana Gligoric IT36/2015");
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
		getContentPane().add(loggerView, BorderLayout.SOUTH);

		setSize(1200, 550);
		fileOptionsController.setFileOptionsView(fileOptionsView);
		setVisible(true);

		// this.fileOptionsController.setLoggerView(loggerView);

		view.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (!select) {
						drawingController.mousePressed(e, shapesController.getShape(e));
						repaint();
					
					
					// }

				} else {
					optionsController.select(e);
				}
			}
		});
		optionsView.getTglbtnSelect().addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent ie) {
				if (ie.getStateChange() == ItemEvent.SELECTED) {
					select = true;

				} else if (ie.getStateChange() == ItemEvent.DESELECTED) {

					optionsController.deselect();
					select = false;

				}

			}

		});

		
		  shapesView.getCmbShapes().addActionListener( new ActionListener() {
		  
		  @Override public void actionPerformed(ActionEvent arg0) { if(select) { select
		  = false; optionsView.getTglbtnSelect().setSelected(false); } } });
		 

		optionsView.getBtnDelete().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				optionsController.delete();

			}

		});

		optionsView.getBtnDeleteAll().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				optionsController.deleteAll();
			}

		});

		optionsView.getBtnModify().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				optionsController.modify();

			}

		});

		optionsView.getBtnBringToBack().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				optionsController.bringToBack();
			}
		});
		optionsView.getBtnBringToFront().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				optionsController.bringToFront();
			}
		});
		optionsView.getBtnSendToBack().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				optionsController.sendToBack();
			}
		});
		optionsView.getBtnSendToFront().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				optionsController.sendToFront();
			}
		});

		optionsView.getBtnUndo().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				optionsController.undo();

			}
		});
		optionsView.getBtnRedo().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				optionsController.redo();

			}
		});
		fileOptionsView.getBtnSaveDrawing().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				fileOptionsController.saveDrawing();
			}

		});
		fileOptionsView.getBtnImportDrawing().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				fileOptionsController.openDrawing();
			}

		});
		fileOptionsView.getBtnSaveLog().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				fileOptionsController.saveLog();
			}

		});
		fileOptionsView.getBtnImportLog().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				fileOptionsController.importLog();

			}

		});
		fileOptionsView.getBtnLogNextLine().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				fileOptionsController.logNextLine();
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

	public ShapesController getShapesController() {
		return shapesController;
	}

	public void setShapesController(ShapesController shapesController) {
		this.shapesController = shapesController;
	}

	public FileOptionsController getFileOptionsController() {
		return fileOptionsController;
	}

	public void setFileOptionsController(FileOptionsController fileOptionsController) {
		this.fileOptionsController = fileOptionsController;
	}

	public LoggerController getLoggerController() {
		return loggerController;
	}

	public void setLoggerController(LoggerController loggerController) {
		this.loggerController = loggerController;
	}

	public LoggerView getLoggerView() {
		return loggerView;
	}

	public void setLoggerView(LoggerView loggerView) {
		this.loggerView = loggerView;
	}

}
