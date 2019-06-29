package views;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.GridBagConstraints;
import javax.swing.DefaultComboBoxModel;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JButton;

public class ShapesView extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JButton btnInnerColor, btnBorderColor;

	public ShapesView() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0,0, 0, 0, 0, 0, 0, 0,0,0,0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JComboBox<String> cmbShapes = new JComboBox<String>();
		cmbShapes.setModel(new DefaultComboBoxModel<String>(new String[] {"Point", "Line", "Square", "Rectangle", "Circle", "Hexagon"}));
		GridBagConstraints gbc_cmbShapes = new GridBagConstraints();
		gbc_cmbShapes.insets = new Insets(0, 0, 0, 5);
		gbc_cmbShapes.anchor = GridBagConstraints.WEST;
		gbc_cmbShapes.gridx = 6;
		gbc_cmbShapes.gridy = 0;
		add(cmbShapes, gbc_cmbShapes);
		
		JLabel lblInnerColor = new JLabel("Inner color:");
		GridBagConstraints gbc_lblInnerColor = new GridBagConstraints();
		gbc_lblInnerColor.insets = new Insets(0, 0, 0, 5);
		gbc_lblInnerColor.gridx = 7;
		gbc_lblInnerColor.gridy = 0;
		add(lblInnerColor, gbc_lblInnerColor);
		
		btnInnerColor = new JButton("");
		GridBagConstraints gbc_btnInnerColor = new GridBagConstraints();
		gbc_btnInnerColor.fill = GridBagConstraints.BOTH;
		gbc_btnInnerColor.insets = new Insets(0, 0, 0, 5);
		gbc_btnInnerColor.gridx = 8;
		gbc_btnInnerColor.gridy = 0;
		add(btnInnerColor, gbc_btnInnerColor);
		
		btnInnerColor.setBackground(Color.BLACK);
		
		JLabel lblBorderColor = new JLabel("Border color:");
		GridBagConstraints gbc_lblBorderColor = new GridBagConstraints();
		gbc_lblBorderColor.fill = GridBagConstraints.BOTH;
		gbc_lblBorderColor.insets = new Insets(0, 0, 0, 5);
		gbc_lblBorderColor.gridx = 9;
		gbc_lblBorderColor.gridy = 0;
		add(lblBorderColor, gbc_lblBorderColor);
		
		btnBorderColor = new JButton("");
		GridBagConstraints gbc_btnBorderColor = new GridBagConstraints();
		gbc_btnBorderColor.fill = GridBagConstraints.BOTH;
		gbc_btnBorderColor.gridx = 10;
		gbc_btnBorderColor.gridy = 0;
		add(btnBorderColor, gbc_btnBorderColor);
		btnBorderColor.setBackground(Color.WHITE);
	}

}
