package dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shapes.point.Point;
import shapes.square.Square;

import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgAddSquare extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtSideLength;
	private boolean answer;
	private Square square;
	
	
	public boolean getAnswer() {
		return answer;
	}
	public Square getSquare() {
		return square;
	}

	/**
	 * Create the dialog.
	 */
	public DlgAddSquare(int x, int y, Color borderColor, Color innerColor) {
		setTitle("Add square");
		setModal(true);
		setBounds(100, 100, 450, 165);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblSquareSideLength = new JLabel("Square side length:");
			lblSquareSideLength.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblSquareSideLength.setBackground(Color.LIGHT_GRAY);
			GridBagConstraints gbc_lblSquareSideLength = new GridBagConstraints();
			gbc_lblSquareSideLength.insets = new Insets(0, 0, 5, 5);
			gbc_lblSquareSideLength.anchor = GridBagConstraints.EAST;
			gbc_lblSquareSideLength.gridx = 0;
			gbc_lblSquareSideLength.gridy = 1;
			contentPanel.add(lblSquareSideLength, gbc_lblSquareSideLength);
		}
		{
			txtSideLength = new JTextField();
			GridBagConstraints gbc_txtSideLength = new GridBagConstraints();
			gbc_txtSideLength.insets = new Insets(0, 0, 5, 0);
			gbc_txtSideLength.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtSideLength.gridx = 1;
			gbc_txtSideLength.gridy = 1;
			contentPanel.add(txtSideLength, gbc_txtSideLength);
			txtSideLength.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.LIGHT_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							if(Integer.parseInt(txtSideLength.getText()) <= 0) {
								JOptionPane.showMessageDialog(null, "Square side length can not be negative", "Error", JOptionPane.ERROR_MESSAGE);
							}else {
								try {
									answer = true;
									square = new Square(new Point(x, y), Integer.parseInt(txtSideLength.getText().toString()), borderColor, innerColor);
									setVisible(false);
								}catch(NumberFormatException ex) {
									JOptionPane.showMessageDialog(null, "Invalid arguments. Try again!", "Error", JOptionPane.ERROR_MESSAGE);

								}
							}
						}catch(NumberFormatException ex) {
							JOptionPane.showMessageDialog(null, "Invalid arguments. Try again!", "Error", JOptionPane.ERROR_MESSAGE);

						}
						
					}
				});
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						answer = false;
						dispose();
					}
				});
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
