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

import shapes.point.Point;
import shapes.square.Square;
import utilities.ColorChooserButton;

import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;

public class DlgModifySquare extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtSideLength;
	private JTextField txtY;
	private JTextField txtByX;
	private JTextField txtByY;
	private final ButtonGroup btnGroupOptions = new ButtonGroup();
	private ColorChooserButton btnBorderColor, btnInnerColor;
	private Color chosenBorderColor, chosenInnerColor;
	private Square square;
	private JRadioButton rdbtnMoveBy, rdbtnMoveTo;

	public Square getSquare() {
		return this.square;
	}

	/**
	 * Create the dialog.
	 */
	public DlgModifySquare(Square sq) {
		Point upperLeft = new Point(sq.getUpperLeft().getX(), sq.getUpperLeft().getY());
		square = new Square(upperLeft, sq.getSideLength(), sq.getClrBorderColor(), sq.getClrInnerColor());
		chosenBorderColor = sq.getClrBorderColor();
		chosenInnerColor = sq.getClrInnerColor();
		setTitle("Modify square");
		setModal(true);
		setBounds(100, 100, 472, 317);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };


		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblOption = new JLabel("Choose an option:");
			lblOption.setForeground(Color.BLACK);
			lblOption.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblOption.setEnabled(false);
			GridBagConstraints gbc_lblOption = new GridBagConstraints();
			gbc_lblOption.insets = new Insets(0, 0, 5, 5);
			gbc_lblOption.gridx = 1;
			gbc_lblOption.gridy = 0;
			contentPanel.add(lblOption, gbc_lblOption);
		}
		{
			rdbtnMoveTo = new JRadioButton("Move to");
			rdbtnMoveTo.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if (rdbtnMoveTo.isSelected()) {
						txtX.setEditable(true);
						txtY.setEditable(true);
					} else {
						txtX.setEditable(false);
						txtY.setEditable(false);
					}
				}
			});
			btnGroupOptions.add(rdbtnMoveTo);
			rdbtnMoveTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			rdbtnMoveTo.setBackground(Color.LIGHT_GRAY);
			GridBagConstraints gbc_rdbtnMoveTo = new GridBagConstraints();
			gbc_rdbtnMoveTo.insets = new Insets(0, 0, 5, 5);
			gbc_rdbtnMoveTo.gridx = 2;
			gbc_rdbtnMoveTo.gridy = 0;
			contentPanel.add(rdbtnMoveTo, gbc_rdbtnMoveTo);
		}
		{
			rdbtnMoveBy = new JRadioButton("Move by");
			rdbtnMoveBy.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if (rdbtnMoveBy.isSelected()) {
						txtByX.setEditable(true);
						txtByY.setEditable(true);
					} else {
						txtByX.setEditable(false);
						txtByY.setEditable(false);
					}
				}
			});
			btnGroupOptions.add(rdbtnMoveBy);
			rdbtnMoveBy.setFont(new Font("Tahoma", Font.PLAIN, 14));
			rdbtnMoveBy.setBackground(Color.LIGHT_GRAY);
			GridBagConstraints gbc_rdbtnMoveBy = new GridBagConstraints();
			gbc_rdbtnMoveBy.insets = new Insets(0, 0, 5, 5);
			gbc_rdbtnMoveBy.gridx = 3;
			gbc_rdbtnMoveBy.gridy = 0;
			contentPanel.add(rdbtnMoveBy, gbc_rdbtnMoveBy);
		}
		{
			JLabel lblCoordinateX = new JLabel("Coordinate X:");
			lblCoordinateX.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblCoordinateX = new GridBagConstraints();
			gbc_lblCoordinateX.anchor = GridBagConstraints.EAST;
			gbc_lblCoordinateX.insets = new Insets(0, 0, 5, 5);
			gbc_lblCoordinateX.gridx = 1;
			gbc_lblCoordinateX.gridy = 2;
			contentPanel.add(lblCoordinateX, gbc_lblCoordinateX);
		}
		{
			txtX = new JTextField();
			txtX.setEditable(false);
			txtX.setColumns(10);
			GridBagConstraints gbc_txtX = new GridBagConstraints();
			gbc_txtX.insets = new Insets(0, 0, 5, 5);
			gbc_txtX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtX.gridx = 2;
			gbc_txtX.gridy = 2;
			contentPanel.add(txtX, gbc_txtX);
		}
		{
			JLabel lblCoordinateY = new JLabel("Coordinate Y:");
			lblCoordinateY.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblCoordinateY = new GridBagConstraints();
			gbc_lblCoordinateY.anchor = GridBagConstraints.EAST;
			gbc_lblCoordinateY.insets = new Insets(0, 0, 5, 5);
			gbc_lblCoordinateY.gridx = 1;
			gbc_lblCoordinateY.gridy = 3;
			contentPanel.add(lblCoordinateY, gbc_lblCoordinateY);
		}
		{
			txtY = new JTextField();
			txtY.setEditable(false);
			txtY.setColumns(10);
			GridBagConstraints gbc_txtY = new GridBagConstraints();
			gbc_txtY.insets = new Insets(0, 0, 5, 5);
			gbc_txtY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtY.gridx = 2;
			gbc_txtY.gridy = 3;
			contentPanel.add(txtY, gbc_txtY);
		}
		{
			JLabel lblMovePointBy = new JLabel("Move point by:");
			lblMovePointBy.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblMovePointBy = new GridBagConstraints();
			gbc_lblMovePointBy.anchor = GridBagConstraints.EAST;
			gbc_lblMovePointBy.insets = new Insets(0, 0, 5, 5);
			gbc_lblMovePointBy.gridx = 1;
			gbc_lblMovePointBy.gridy = 4;
			contentPanel.add(lblMovePointBy, gbc_lblMovePointBy);
		}
		{
			txtByX = new JTextField();
			txtByX.setEditable(false);
			txtByX.setColumns(10);
			GridBagConstraints gbc_txtByX = new GridBagConstraints();
			gbc_txtByX.insets = new Insets(0, 0, 5, 5);
			gbc_txtByX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtByX.gridx = 2;
			gbc_txtByX.gridy = 4;
			contentPanel.add(txtByX, gbc_txtByX);
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
			txtByY = new JTextField();
			txtByY.setEditable(false);
			txtByY.setColumns(10);
			GridBagConstraints gbc_txtByY = new GridBagConstraints();
			gbc_txtByY.insets = new Insets(0, 0, 5, 5);
			gbc_txtByY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtByY.gridx = 2;
			gbc_txtByY.gridy = 5;
			contentPanel.add(txtByY, gbc_txtByY);
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
			JLabel lblSideLength = new JLabel("Side length:");
			lblSideLength.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblSideLength = new GridBagConstraints();
			gbc_lblSideLength.anchor = GridBagConstraints.EAST;
			gbc_lblSideLength.insets = new Insets(0, 0, 5, 5);
			gbc_lblSideLength.gridx = 1;
			gbc_lblSideLength.gridy = 6;
			contentPanel.add(lblSideLength, gbc_lblSideLength);
		}
		{
			txtSideLength = new JTextField();
			txtSideLength.setColumns(10);
			GridBagConstraints gbc_txtSideLength = new GridBagConstraints();
			gbc_txtSideLength.insets = new Insets(0, 0, 5, 5);
			gbc_txtSideLength.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtSideLength.gridx = 2;
			gbc_txtSideLength.gridy = 6;
			contentPanel.add(txtSideLength, gbc_txtSideLength);
		}
		{
			JLabel lblChooseColor = new JLabel("Choose border color:");
			lblChooseColor.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblChooseColor = new GridBagConstraints();
			gbc_lblChooseColor.anchor = GridBagConstraints.EAST;
			gbc_lblChooseColor.insets = new Insets(0, 0, 5, 5);
			gbc_lblChooseColor.gridx = 1;
			gbc_lblChooseColor.gridy = 7;
			contentPanel.add(lblChooseColor, gbc_lblChooseColor);
		}
		{
			btnBorderColor = new ColorChooserButton(chosenBorderColor);
			btnBorderColor.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_button = new GridBagConstraints();
			gbc_button.fill = GridBagConstraints.BOTH;
			gbc_button.insets = new Insets(0, 0, 5, 5);
			gbc_button.gridx = 2;
			gbc_button.gridy = 7;
			contentPanel.add(btnBorderColor, gbc_button);
		}
		{
			JLabel lblChooseInnerColor = new JLabel("Choose inner color:");
			lblChooseInnerColor.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblChooseInnerColor = new GridBagConstraints();
			gbc_lblChooseInnerColor.anchor = GridBagConstraints.EAST;
			gbc_lblChooseInnerColor.insets = new Insets(0, 0, 5, 5);
			gbc_lblChooseInnerColor.gridx = 1;
			gbc_lblChooseInnerColor.gridy = 8;
			contentPanel.add(lblChooseInnerColor, gbc_lblChooseInnerColor);
		}
		{
			btnInnerColor = new ColorChooserButton(chosenInnerColor);
			btnInnerColor.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_button = new GridBagConstraints();
			gbc_button.fill = GridBagConstraints.BOTH;
			gbc_button.insets = new Insets(0, 0, 5, 5);
			gbc_button.gridx = 2;
			gbc_button.gridy = 8;
			contentPanel.add(btnInnerColor, gbc_button);
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
						if(Integer.parseInt(txtSideLength.getText().toString()) <= 0)	{
							JOptionPane.showMessageDialog(null, "Side length can not be negative", "Error", JOptionPane.ERROR_MESSAGE);;
						}else {
							try {
								if (rdbtnMoveTo.isSelected()) {
									square.moveTo(Integer.parseInt(txtX.getText()), Integer.parseInt(txtY.getText()));
								}
								if (rdbtnMoveBy.isSelected()) {
									square.moveBy(Integer.parseInt(txtByX.getText()),
											Integer.parseInt(txtByY.getText()));
								}
								square.setSideLength(Integer.parseInt(txtSideLength.getText().toString()));
								System.out.println(sq.getSideLength());
								square.setClrBorderColor(btnBorderColor.getSelectedColor());
								square.setClrInnerColor(btnInnerColor.getSelectedColor());

								setVisible(false);
							} catch (NumberFormatException ex) {
								JOptionPane.showMessageDialog(null, "Invalid arguments. Try again!", "Error",
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

			txtX.setText(Integer.toString(sq.getUpperLeft().getX()));
			txtY.setText(Integer.toString(sq.getUpperLeft().getY()));
			txtSideLength.setText(Integer.toString(sq.getSideLength()));
		}
	}

}
