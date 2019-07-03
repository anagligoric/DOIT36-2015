package dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import shapes.point.Point;
import shapes.rectangle.Rectangle;

public class DlgAddRectangle extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtHeight, txtWidth;
	private boolean answer;
	private Rectangle rectangle;
	
	public Rectangle getRectangle() {
		return this.rectangle;
	}
	public boolean getAnswer() {
		return this.answer;
	}

	/**
	 * Create the dialog.
	 */
	public DlgAddRectangle(int x, int y, Color borderColor, Color innerColor) {
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
			JLabel lblRecHeight = new JLabel("Rectangle height:");
			lblRecHeight.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblRecHeight.setBackground(Color.LIGHT_GRAY);
			GridBagConstraints gbc_lblRecHeight = new GridBagConstraints();
			gbc_lblRecHeight.insets = new Insets(0, 0, 5, 5);
			gbc_lblRecHeight.anchor = GridBagConstraints.EAST;
			gbc_lblRecHeight.gridx = 0;
			gbc_lblRecHeight.gridy = 1;
			contentPanel.add(lblRecHeight, gbc_lblRecHeight);
		}
		{
			txtHeight = new JTextField();
			GridBagConstraints gbc_txtHeight= new GridBagConstraints();
			gbc_txtHeight.insets = new Insets(0, 0, 5, 0);
			gbc_txtHeight.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtHeight.gridx = 1;
			gbc_txtHeight.gridy = 1;
			contentPanel.add(txtHeight, gbc_txtHeight);
			txtHeight.setColumns(10);
		}
		{
			JLabel lblRecWidth = new JLabel("Rectangle width:");
			lblRecWidth.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblRecWidth.setBackground(Color.LIGHT_GRAY);
			GridBagConstraints gbc_lblRecWidth = new GridBagConstraints();
			gbc_lblRecWidth.insets = new Insets(0, 0, 5, 5);
			gbc_lblRecWidth.anchor = GridBagConstraints.EAST;
			gbc_lblRecWidth.gridx = 0;
			gbc_lblRecWidth.gridy = 2;
			contentPanel.add(lblRecWidth, gbc_lblRecWidth);
		}
		{
			txtWidth = new JTextField();
			GridBagConstraints gbc_txtWidth= new GridBagConstraints();
			gbc_txtWidth.insets = new Insets(0, 0, 5, 0);
			gbc_txtWidth.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtWidth.gridx = 1;
			gbc_txtWidth.gridy = 2;
			contentPanel.add(txtWidth, gbc_txtWidth);
			txtWidth.setColumns(10);
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
							if((Integer.parseInt(txtHeight.getText()) <= 0) || (Integer.parseInt(txtWidth.getText()) <= 0)) {
								JOptionPane.showMessageDialog(null, "Rectangle sides length can not be negative", "Error", JOptionPane.ERROR_MESSAGE);
							}else {
								try {
									answer = true;
									rectangle = new Rectangle(new Point(x, y), Integer.parseInt(txtHeight.getText().toString()), Integer.parseInt(txtWidth.getText().toString()), borderColor, innerColor);
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
