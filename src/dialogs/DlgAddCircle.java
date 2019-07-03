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

import shapes.circle.Circle;
import shapes.point.Point;

public class DlgAddCircle extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtRadius;
	private boolean answer;
	private Circle circle;
	public boolean getAnswer() {
		return this.answer;
	}
	public Circle getCircle() {
		return circle;
	}
	/**
	 * Create the dialog.
	 */
	public DlgAddCircle(int x, int y, Color borderColor, Color innerColor) {
		setTitle("Add circle");
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
			JLabel lblCircleRadius = new JLabel("Circle radius:");
			lblCircleRadius.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblCircleRadius.setBackground(Color.LIGHT_GRAY);
			GridBagConstraints gbc_lblCircleRadius = new GridBagConstraints();
			gbc_lblCircleRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblCircleRadius.anchor = GridBagConstraints.EAST;
			gbc_lblCircleRadius.gridx = 0;
			gbc_lblCircleRadius.gridy = 1;
			contentPanel.add(lblCircleRadius, gbc_lblCircleRadius);
		}
		{
			txtRadius = new JTextField();
			GridBagConstraints gbc_txtRadius = new GridBagConstraints();
			gbc_txtRadius.insets = new Insets(0, 0, 5, 0);
			gbc_txtRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtRadius.gridx = 1;
			gbc_txtRadius.gridy = 1;
			contentPanel.add(txtRadius, gbc_txtRadius);
			txtRadius.setColumns(10);
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
							if(Integer.parseInt(txtRadius.getText().toString()) <= 0) {
								JOptionPane.showMessageDialog(null, "Circle radius length can not be negative", "Error", JOptionPane.ERROR_MESSAGE);
							}else {
								try {
									answer = true;
									circle = new Circle(new Point(x, y), Integer.parseInt(txtRadius.getText().toString()), borderColor, innerColor);
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
