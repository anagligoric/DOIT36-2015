package views;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class FileOptionsView extends JPanel{
	private JButton btnSaveLog, btnImportLog, btnSaveDrawing, btnImportDrawing, btnLogNextLine;
	public FileOptionsView() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		btnSaveLog = new JButton("Save log");
		GridBagConstraints gbc_btnSaveLog = new GridBagConstraints();
		gbc_btnSaveLog.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSaveLog.insets = new Insets(0, 0, 5, 0);
		gbc_btnSaveLog.gridx = 13;
		gbc_btnSaveLog.gridy = 1;
		add(btnSaveLog, gbc_btnSaveLog);
		
		btnImportLog = new JButton("Import log");
		GridBagConstraints gbc_btnImportLog = new GridBagConstraints();
		gbc_btnImportLog.insets = new Insets(0, 0, 5, 0);
		gbc_btnImportLog.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnImportLog.gridx = 13;
		gbc_btnImportLog.gridy = 2;
		add(btnImportLog, gbc_btnImportLog);
		
		btnSaveDrawing = new JButton("Save drawing");
		GridBagConstraints gbc_btnSaveDrawing = new GridBagConstraints();
		gbc_btnSaveDrawing.insets = new Insets(0, 0, 5, 0);
		gbc_btnSaveDrawing.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSaveDrawing.gridx = 13;
		gbc_btnSaveDrawing.gridy = 3;
		add(btnSaveDrawing, gbc_btnSaveDrawing);
		
		btnImportDrawing = new JButton("Import drawing");
		GridBagConstraints gbc_btnImportDrawing = new GridBagConstraints();
		gbc_btnImportDrawing.insets = new Insets(0, 0, 5, 0);
		gbc_btnImportDrawing.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnImportDrawing.gridx = 13;
		gbc_btnImportDrawing.gridy = 4;
		add(btnImportDrawing, gbc_btnImportDrawing);
		
		btnLogNextLine = new JButton("Log next line");
		GridBagConstraints gbc_btnLogNextLine = new GridBagConstraints();
		gbc_btnLogNextLine.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLogNextLine.gridx = 13;
		gbc_btnLogNextLine.gridy = 5;
		add(btnLogNextLine, gbc_btnLogNextLine);
	}

	
	public JButton getBtnSaveLog() {
		return btnSaveLog;
	}


	public void setBtnSaveLog(JButton btnSaveLog) {
		this.btnSaveLog = btnSaveLog;
	}


	public JButton getBtnImportLog() {
		return btnImportLog;
	}


	public void setBtnImportLog(JButton btnImportLog) {
		this.btnImportLog = btnImportLog;
	}


	public JButton getBtnSaveDrawing() {
		return btnSaveDrawing;
	}


	public void setBtnSaveDrawing(JButton btnSaveDrawing) {
		this.btnSaveDrawing = btnSaveDrawing;
	}


	public JButton getBtnImportDrawing() {
		return btnImportDrawing;
	}


	public void setBtnImportDrawing(JButton btnImportDrawing) {
		this.btnImportDrawing = btnImportDrawing;
	}


	public JButton getBtnLogNextLine() {
		return btnLogNextLine;
	}


	public void setBtnLogNextLine(JButton btnLogNextLine) {
		this.btnLogNextLine = btnLogNextLine;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
