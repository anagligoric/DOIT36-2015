package views;

import javax.swing.JPanel;

import utilities.ColorChooserButton;

import java.awt.GridBagLayout;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.GridBagConstraints;
import javax.swing.DefaultComboBoxModel;
import java.awt.Insets;
import javax.swing.JLabel;

public class ShapesView extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private ColorChooserButton btnInnerColor, btnBorderColor;
	private JComboBox<String> cmbShapes;

	public ShapesView() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0,0, 0, 0, 0, 0, 0, 0,0,0,0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		cmbShapes = new JComboBox<String>();
		cmbShapes.setModel(new DefaultComboBoxModel<String>(new String[] {"Point", "Line", "Square", "Rectangle", 
				"Circle", "Hexagon"}));
		GridBagConstraints gbc_cmbShapes = new GridBagConstraints();
		gbc_cmbShapes.insets = new Insets(0, 0, 0, 5);
		gbc_cmbShapes.anchor = GridBagConstraints.WEST;
		gbc_cmbShapes.gridx = 3;
		gbc_cmbShapes.gridy = 0;
		add(cmbShapes, gbc_cmbShapes);
		
		JLabel lblInnerColor = new JLabel("Inner color:");
		GridBagConstraints gbc_lblInnerColor = new GridBagConstraints();
		gbc_lblInnerColor.insets = new Insets(0, 0, 0, 5);
		gbc_lblInnerColor.gridx = 4;
		gbc_lblInnerColor.gridy = 0;
		add(lblInnerColor, gbc_lblInnerColor);
		
		btnInnerColor = new ColorChooserButton(Color.WHITE);
		GridBagConstraints gbc_btnInnerColor = new GridBagConstraints();
		gbc_btnInnerColor.fill = GridBagConstraints.BOTH;
		gbc_btnInnerColor.insets = new Insets(0, 0, 0, 5);
		gbc_btnInnerColor.gridx = 5;
		gbc_btnInnerColor.gridy = 0;
		add(btnInnerColor, gbc_btnInnerColor);
				
		JLabel lblBorderColor = new JLabel("Border color:");
		GridBagConstraints gbc_lblBorderColor = new GridBagConstraints();
		gbc_lblBorderColor.fill = GridBagConstraints.BOTH;
		gbc_lblBorderColor.insets = new Insets(0, 0, 0, 5);
		gbc_lblBorderColor.gridx = 6;
		gbc_lblBorderColor.gridy = 0;
		add(lblBorderColor, gbc_lblBorderColor);
		
		btnBorderColor = new ColorChooserButton(Color.BLACK);
		GridBagConstraints gbc_btnBorderColor = new GridBagConstraints();
		gbc_btnBorderColor.fill = GridBagConstraints.BOTH;
		gbc_btnBorderColor.anchor = GridBagConstraints.WEST;

		gbc_btnBorderColor.gridx = 7;
		gbc_btnBorderColor.gridy = 0;
		add(btnBorderColor, gbc_btnBorderColor);
	}

	public ColorChooserButton getBtnInnerColor() {
		return btnInnerColor;
	}

	public void setBtnInnerColor(ColorChooserButton btnInnerColor) {
		this.btnInnerColor = btnInnerColor;
	}

	public ColorChooserButton getBtnBorderColor() {
		return btnBorderColor;
	}

	public void setBtnBorderColor(ColorChooserButton btnBorderColor) {
		this.btnBorderColor = btnBorderColor;
	}

	public JComboBox<String> getCmbShapes() {
		return cmbShapes;
	}

	public void setCmbShapes(JComboBox<String> cmbShapes) {
		this.cmbShapes = cmbShapes;
	}
	
	

}
