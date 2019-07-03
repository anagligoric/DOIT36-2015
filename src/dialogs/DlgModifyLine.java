package dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import shapes.line.Line;
import shapes.point.Point;
import utilities.ColorChooserButton;

import java.awt.GridBagLayout;

import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JTextField;

public class DlgModifyLine extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private ColorChooserButton btnColor;
	private Color chosenColor;
	private Line line;
	private JRadioButton rdbtnMoveBy;
	
	public Line getLine() {
		return this.line;
	}

	/**
	 * Create the dialog.
	 */
	public DlgModifyLine(Line ln) {
		Point startPoint = new Point(ln.getpStart().getX(), ln.getpStart().getY());
		Point endPoint = new Point(ln.getpEnd().getX(), ln.getpEnd().getY());

		line = new Line(startPoint, endPoint, ln.getClrBorderColor());
		chosenColor = ln.getClrBorderColor();
		setTitle("Modify point");
		setModal(true);
		setBounds(100, 100, 472, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		
		contentPanel.setLayout(gbl_contentPanel);
		{
			rdbtnMoveBy = new JRadioButton("Move by");
			rdbtnMoveBy.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(rdbtnMoveBy.isSelected()){
						txtX.setEditable(true);
						txtY.setEditable(true);
					}
					else{
						txtX.setEditable(false);
						txtY.setEditable(false);
					}
				}
			});
			rdbtnMoveBy.setFont(new Font("Tahoma", Font.PLAIN, 14));
			rdbtnMoveBy.setBackground(Color.LIGHT_GRAY);
			GridBagConstraints gbc_rdbtnMoveBy = new GridBagConstraints();
			gbc_rdbtnMoveBy.insets = new Insets(0, 0, 5, 5);
			gbc_rdbtnMoveBy.gridx = 2;
			gbc_rdbtnMoveBy.gridy = 1;
			contentPanel.add(rdbtnMoveBy, gbc_rdbtnMoveBy);
		}
		{
			JLabel lblMovePointBy = new JLabel("Move line by:");
			lblMovePointBy.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblMovePointBy = new GridBagConstraints();
			gbc_lblMovePointBy.anchor = GridBagConstraints.EAST;
			gbc_lblMovePointBy.insets = new Insets(0, 0, 5, 5);
			gbc_lblMovePointBy.gridx = 1;
			gbc_lblMovePointBy.gridy = 4;
			contentPanel.add(lblMovePointBy, gbc_lblMovePointBy);
		}
		{
			txtX = new JTextField();
			txtX.setEditable(false);
			txtX.setColumns(10);
			GridBagConstraints gbc_txtByX = new GridBagConstraints();
			gbc_txtByX.insets = new Insets(0, 0, 5, 5);
			gbc_txtByX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtByX.gridx = 2;
			gbc_txtByX.gridy = 4;
			contentPanel.add(txtX, gbc_txtByX);
		}
		{
			JLabel lblXAxis = new JLabel("X axis");
			lblXAxis.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblXAxis = new GridBagConstraints();
			gbc_lblXAxis.insets = new Insets(0, 0, 5, 5);
			gbc_lblXAxis.gridx = 3;
			gbc_lblXAxis.gridy = 4;
			contentPanel.add(lblXAxis, gbc_lblXAxis);
		}
		{
			txtY = new JTextField();
			txtY.setEditable(false);
			txtY.setColumns(10);
			GridBagConstraints gbc_txtByY = new GridBagConstraints();
			gbc_txtByY.insets = new Insets(0, 0, 5, 5);
			gbc_txtByY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtByY.gridx = 2;
			gbc_txtByY.gridy = 5;
			contentPanel.add(txtY, gbc_txtByY);
		}
		{
			JLabel lblYAxis = new JLabel("Y axis");
			lblYAxis.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblYAxis = new GridBagConstraints();
			gbc_lblYAxis.insets = new Insets(0, 0, 5, 5);
			gbc_lblYAxis.gridx = 3;
			gbc_lblYAxis.gridy = 5;
			contentPanel.add(lblYAxis, gbc_lblYAxis);
		}
		{
			JLabel lblChooseColor = new JLabel("Choose color:");
			lblChooseColor.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblChooseColor = new GridBagConstraints();
			gbc_lblChooseColor.anchor = GridBagConstraints.EAST;
			gbc_lblChooseColor.insets = new Insets(0, 0, 5, 5);
			gbc_lblChooseColor.gridx = 1;
			gbc_lblChooseColor.gridy = 6;
			contentPanel.add(lblChooseColor, gbc_lblChooseColor);
		}
		{
			btnColor = new ColorChooserButton(chosenColor);
			btnColor.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_button = new GridBagConstraints();
			gbc_button.fill = GridBagConstraints.BOTH;
			gbc_button.insets = new Insets(0, 0, 5, 5);
			gbc_button.gridx = 2;
			gbc_button.gridy = 6;
			contentPanel.add(btnColor, gbc_button);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.LIGHT_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
				okButton.addActionListener(new ActionListener() {
				
					public void actionPerformed(ActionEvent e) {
						if((rdbtnMoveBy.isSelected()) && (txtX.getText().isEmpty() || txtY.getText().isEmpty())) {
							JOptionPane.showMessageDialog(null, "Can't pass empty fields!", "Error",
									JOptionPane.ERROR_MESSAGE);
						}else {
							try {
								if(rdbtnMoveBy.isSelected()) {
									line.moveBy(Integer.parseInt(txtX.getText().toString()), Integer.parseInt(txtY.getText().toString()));
								}
								line.setClrBorderColor(btnColor.getSelectedColor());
								setVisible(false);
							}catch(NumberFormatException ex) {
								JOptionPane.showMessageDialog(null, "Invalid arguments. Try again!","Error",
										JOptionPane.ERROR_MESSAGE);

							}
						}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
