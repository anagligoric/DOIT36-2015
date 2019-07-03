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

import hexagon.Hexagon;
import shapes.hexagon.HexagonAdapter;


public class DlgAddHexagon extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtR;
	private boolean answer;
	private HexagonAdapter hexagon;
	
	public boolean getAnswer() {
		return this.answer;
	}
	public HexagonAdapter getHexagon() {
		return hexagon;
	}

	/**
	 * Create the dialog.
	 */
	public DlgAddHexagon(int x, int y, Color borderColor, Color innerColor) {
		setTitle("Add hexagon");
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
			JLabel lblHexagonRadius = new JLabel("Hexagon radius:");
			lblHexagonRadius.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblHexagonRadius.setBackground(Color.LIGHT_GRAY);
			GridBagConstraints gbc_lblHexagonRadius = new GridBagConstraints();
			gbc_lblHexagonRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblHexagonRadius.anchor = GridBagConstraints.EAST;
			gbc_lblHexagonRadius.gridx = 0;
			gbc_lblHexagonRadius.gridy = 1;
			contentPanel.add(lblHexagonRadius, gbc_lblHexagonRadius);
		}
		{
			txtR = new JTextField();
			GridBagConstraints gbc_txtR= new GridBagConstraints();
			gbc_txtR.insets = new Insets(0, 0, 5, 0);
			gbc_txtR.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtR.gridx = 1;
			gbc_txtR.gridy = 1;
			contentPanel.add(txtR, gbc_txtR);
			txtR.setColumns(10);
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
						try {if(Integer.parseInt(txtR.getText()) <= 0) {
							JOptionPane.showMessageDialog(null, "Hexagon radius length can not be negative", "Error", JOptionPane.ERROR_MESSAGE);
						}else {
							try {
								answer = true;
								hexagon = new HexagonAdapter(new Hexagon(x, y, Integer.parseInt(txtR.getText().toString())), borderColor, innerColor);
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
