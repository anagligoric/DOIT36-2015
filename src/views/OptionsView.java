package views;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JToggleButton;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;

public class OptionsView extends JPanel{
	/**
	 * 
	 */
	private JToggleButton tglbtnSelect;
	private JButton btnModify, btnDelete, btnBringToFront, btnBringToBack, btnSendToFront, btnSendToBack,
		btnUndo, btnRedo, btnDeleteAll;
	private static final long serialVersionUID = 1L;

	public OptionsView() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		tglbtnSelect = new JToggleButton("Select");
		GridBagConstraints gbc_tglbtnSelect = new GridBagConstraints();
		gbc_tglbtnSelect.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnSelect.fill = GridBagConstraints.BOTH;
		gbc_tglbtnSelect.gridx = 0;
		gbc_tglbtnSelect.gridy = 1;
		add(tglbtnSelect, gbc_tglbtnSelect);
		
		btnModify = new JButton("Modify");
		btnModify.setEnabled(false);
		GridBagConstraints gbc_btnModify = new GridBagConstraints();
		gbc_btnModify.insets = new Insets(0, 0, 5, 0);
		gbc_btnModify.fill = GridBagConstraints.BOTH;
		gbc_btnModify.gridx = 0;
		gbc_btnModify.gridy = 2;
		add(btnModify, gbc_btnModify);
		
		btnDelete = new JButton("Delete");
		btnDelete.setEnabled(false);
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 5, 0);
		gbc_btnDelete.fill = GridBagConstraints.BOTH;
		gbc_btnDelete.gridx = 0;
		gbc_btnDelete.gridy = 3;
		add(btnDelete, gbc_btnDelete);
		
		btnBringToFront = new JButton("Bring to front");
		btnBringToFront.setEnabled(false);
		GridBagConstraints gbc_btnBringToFront = new GridBagConstraints();
		gbc_btnBringToFront.insets = new Insets(0, 0, 5, 0);
		gbc_btnBringToFront.fill = GridBagConstraints.BOTH;
		gbc_btnBringToFront.gridx = 0;
		gbc_btnBringToFront.gridy = 5;
		add(btnBringToFront, gbc_btnBringToFront);
		
		btnSendToFront = new JButton("Send to front");
		btnSendToFront.setEnabled(false);
		GridBagConstraints gbc_btnSendToFront = new GridBagConstraints();
		gbc_btnSendToFront.insets = new Insets(0, 0, 5, 0);
		gbc_btnSendToFront.fill = GridBagConstraints.BOTH;
		gbc_btnSendToFront.gridx = 0;
		gbc_btnSendToFront.gridy = 6;
		add(btnSendToFront, gbc_btnSendToFront);
		
		btnBringToBack = new JButton("Bring to back");
		btnBringToBack.setEnabled(false);
		GridBagConstraints gbc_btnBringToBack = new GridBagConstraints();
		gbc_btnBringToBack.insets = new Insets(0, 0, 5, 0);
		gbc_btnBringToBack.fill = GridBagConstraints.BOTH;
		gbc_btnBringToBack.gridx = 0;
		gbc_btnBringToBack.gridy = 7;
		add(btnBringToBack, gbc_btnBringToBack);
		
		btnSendToBack = new JButton("Send to back");
		btnSendToBack.setEnabled(false);
		GridBagConstraints gbc_btnSendToBack = new GridBagConstraints();
		gbc_btnSendToBack.fill = GridBagConstraints.BOTH;
		gbc_btnSendToBack.insets = new Insets(0, 0, 5, 0);
		gbc_btnSendToBack.gridx = 0;
		gbc_btnSendToBack.gridy = 8;
		add(btnSendToBack, gbc_btnSendToBack);
		
		btnUndo = new JButton("Undo");
		btnUndo.setEnabled(false);

		GridBagConstraints gbc_btnUndo = new GridBagConstraints();
		gbc_btnUndo.fill = GridBagConstraints.BOTH;
		gbc_btnUndo.insets = new Insets(0, 0, 5, 0);
		gbc_btnUndo.gridx = 0;
		gbc_btnUndo.gridy = 9;
		add(btnUndo, gbc_btnUndo);
		
		btnRedo = new JButton("Redo");
		btnRedo.setEnabled(false);

		GridBagConstraints gbc_btnRedo = new GridBagConstraints();
		gbc_btnRedo.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRedo.insets = new Insets(0, 0, 5, 0);
		gbc_btnRedo.gridx = 0;
		gbc_btnRedo.gridy = 10;
		add(btnRedo, gbc_btnRedo);
		
		btnDeleteAll = new JButton("Delete All");
		GridBagConstraints gbc_btnDeleteAll = new GridBagConstraints();
		gbc_btnDeleteAll.fill = GridBagConstraints.BOTH;
		gbc_btnDeleteAll.gridx = 0;
		gbc_btnDeleteAll.gridy = 11;
		add(btnDeleteAll, gbc_btnDeleteAll);
	}

	public JToggleButton getTglbtnSelect() {
		return tglbtnSelect;
	}

	public void setTglbtnSelect(JToggleButton tglbtnSelect) {
		this.tglbtnSelect = tglbtnSelect;
	}

	public JButton getBtnModify() {
		return btnModify;
	}

	public void setBtnModify(JButton btnModify) {
		this.btnModify = btnModify;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public JButton getBtnBringToFront() {
		return btnBringToFront;
	}

	public void setBtnBringToFront(JButton btnBringToFront) {
		this.btnBringToFront = btnBringToFront;
	}

	public JButton getBtnBringToBack() {
		return btnBringToBack;
	}

	public void setBtnBringToBack(JButton btnBringToBack) {
		this.btnBringToBack = btnBringToBack;
	}

	public JButton getBtnSendToFront() {
		return btnSendToFront;
	}

	public void setBtnSendToFront(JButton btnSendToFront) {
		this.btnSendToFront = btnSendToFront;
	}

	public JButton getBtnSendToBack() {
		return btnSendToBack;
	}

	public void setBtnSendToBack(JButton btnSendToBack) {
		this.btnSendToBack = btnSendToBack;
	}

	public JButton getBtnUndo() {
		return btnUndo;
	}

	public void setBtnUndo(JButton btnUndo) {
		this.btnUndo = btnUndo;
	}

	public JButton getBtnRedo() {
		return btnRedo;
	}

	public void setBtnRedo(JButton btnRedo) {
		this.btnRedo = btnRedo;
	}

	public JButton getBtnDeleteAll() {
		return btnDeleteAll;
	}

	public void setBtnDeleteAll(JButton btnDeleteAll) {
		this.btnDeleteAll = btnDeleteAll;
	}
	
	

}
