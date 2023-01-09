
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class DlgPlaceShip extends JDialog {
	// declare Application Window to prompt user for ship coordinates
	private JPanel contentPane;
	// declare TextFields for x and y coordinates of all ship types
	private JTextField textFieldCarrierX;
	private JTextField textFieldCarrierY;
	private JTextField textFieldBattleshipX;
	private JTextField textFieldBattleshipY;
	private JTextField textFieldCruiserX;
	private JTextField textFieldCruiserY;
	private JTextField textFieldSubmarineX;
	private JTextField textFieldSubmarineY;
	private JTextField textFieldDestroyerX;
	private JTextField textFieldDestroyerY;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public DlgPlaceShip() {

		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Setting dimensions for Application Window
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// declare Carrier input prompts
		JLabel lblCarrier = new JLabel("Carrier");
		lblCarrier.setBounds(10, 34, 46, 14);
		contentPane.add(lblCarrier);

		textFieldCarrierX = new JTextField();
		textFieldCarrierX.setText("0");
		textFieldCarrierX.setBounds(77, 31, 32, 20);
		contentPane.add(textFieldCarrierX);
		textFieldCarrierX.setColumns(10);

		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.setBounds(77, 6, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblY = new JLabel("Y");
		lblY.setBounds(140, 6, 46, 14);
		contentPane.add(lblY);

		textFieldCarrierY = new JTextField();
		textFieldCarrierY.setText("0");
		textFieldCarrierY.setColumns(10);
		textFieldCarrierY.setBounds(140, 31, 32, 20);
		contentPane.add(textFieldCarrierY);

		JComboBox comboBoxCarrierOrientation = new JComboBox();
		comboBoxCarrierOrientation.setModel(new DefaultComboBoxModel(Orientation.values()));
		comboBoxCarrierOrientation.setBounds(209, 30, 94, 22);
		contentPane.add(comboBoxCarrierOrientation);

		JLabel lblNewLabel_1 = new JLabel("Orientation");
		lblNewLabel_1.setBounds(209, 6, 59, 14);
		contentPane.add(lblNewLabel_1);

		// declare BattleShip input Prompts
		JLabel lblBattleship = new JLabel("BattleShip");
		lblBattleship.setBounds(10, 68, 57, 14);
		contentPane.add(lblBattleship);

		textFieldBattleshipX = new JTextField();
		textFieldBattleshipX.setText("0");
		textFieldBattleshipX.setColumns(10);
		textFieldBattleshipX.setBounds(77, 65, 32, 20);
		contentPane.add(textFieldBattleshipX);

		textFieldBattleshipY = new JTextField();
		textFieldBattleshipY.setText("0");
		textFieldBattleshipY.setColumns(10);
		textFieldBattleshipY.setBounds(140, 65, 32, 20);
		contentPane.add(textFieldBattleshipY);

		JComboBox comboBoxBattleshipOrientation = new JComboBox();
		comboBoxBattleshipOrientation.setModel(new DefaultComboBoxModel(Orientation.values()));
		comboBoxBattleshipOrientation.setBounds(209, 64, 94, 22);
		contentPane.add(comboBoxBattleshipOrientation);

		// delcare Cruiser input prompts
		JLabel lblCruiser = new JLabel("Cruiser");
		lblCruiser.setBounds(10, 107, 46, 14);
		contentPane.add(lblCruiser);

		textFieldCruiserX = new JTextField();
		textFieldCruiserX.setText("0");
		textFieldCruiserX.setColumns(10);
		textFieldCruiserX.setBounds(77, 104, 32, 20);
		contentPane.add(textFieldCruiserX);

		textFieldCruiserY = new JTextField();
		textFieldCruiserY.setText("0");
		textFieldCruiserY.setColumns(10);
		textFieldCruiserY.setBounds(140, 104, 32, 20);
		contentPane.add(textFieldCruiserY);

		JComboBox comboBoxCruiserOrientation = new JComboBox();
		comboBoxCruiserOrientation.setModel(new DefaultComboBoxModel(Orientation.values()));
		comboBoxCruiserOrientation.setBounds(209, 103, 94, 22);
		contentPane.add(comboBoxCruiserOrientation);

		// delcare submarine input prompts
		JLabel lblSubmarine = new JLabel("Submarine");
		lblSubmarine.setBounds(10, 149, 57, 14);
		contentPane.add(lblSubmarine);

		textFieldSubmarineX = new JTextField();
		textFieldSubmarineX.setText("0");
		textFieldSubmarineX.setColumns(10);
		textFieldSubmarineX.setBounds(77, 146, 32, 20);
		contentPane.add(textFieldSubmarineX);

		textFieldSubmarineY = new JTextField();
		textFieldSubmarineY.setText("0");
		textFieldSubmarineY.setColumns(10);
		textFieldSubmarineY.setBounds(140, 146, 32, 20);
		contentPane.add(textFieldSubmarineY);

		JComboBox comboBoxSubmarineOrientation = new JComboBox();
		comboBoxSubmarineOrientation.setModel(new DefaultComboBoxModel(Orientation.values()));
		comboBoxSubmarineOrientation.setBounds(209, 145, 94, 22);
		contentPane.add(comboBoxSubmarineOrientation);

		// declare destroyer input prompts
		JLabel lblD = new JLabel("Destroyer");
		lblD.setBounds(10, 193, 57, 14);
		contentPane.add(lblD);

		textFieldDestroyerX = new JTextField();
		textFieldDestroyerX.setText("0");
		textFieldDestroyerX.setColumns(10);
		textFieldDestroyerX.setBounds(77, 190, 32, 20);
		contentPane.add(textFieldDestroyerX);

		textFieldDestroyerY = new JTextField();
		textFieldDestroyerY.setText("0");
		textFieldDestroyerY.setColumns(10);
		textFieldDestroyerY.setBounds(140, 190, 32, 20);
		contentPane.add(textFieldDestroyerY);

		JComboBox comboBoxDestroyerOrientation = new JComboBox();
		comboBoxDestroyerOrientation.setModel(new DefaultComboBoxModel(Orientation.values()));
		comboBoxDestroyerOrientation.setBounds(209, 189, 94, 22);
		contentPane.add(comboBoxDestroyerOrientation);

		// when user clicks apply button, program will save changes to the data system
		JButton btnApply = new JButton("Apply");
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<ShipPlacement> ships = new ArrayList<>();
				ShipPlacement ship = new ShipPlacement(ShipTypes.Carrier,
						Integer.parseInt(textFieldCarrierX.getText()) - 1,
						Integer.parseInt(textFieldCarrierY.getText()) - 1,
						(Orientation) comboBoxCarrierOrientation.getSelectedItem());
				ships.add(ship);

				ship = new ShipPlacement(ShipTypes.BattleShip, Integer.parseInt(textFieldBattleshipX.getText()) - 1,
						Integer.parseInt(textFieldBattleshipY.getText()) - 1,
						(Orientation) comboBoxBattleshipOrientation.getSelectedItem());
				ships.add(ship);

				ship = new ShipPlacement(ShipTypes.Cruiser, Integer.parseInt(textFieldCruiserX.getText()) - 1,
						Integer.parseInt(textFieldCruiserY.getText()) - 1,
						(Orientation) comboBoxCruiserOrientation.getSelectedItem());
				ships.add(ship);

				ship = new ShipPlacement(ShipTypes.Submarine, Integer.parseInt(textFieldSubmarineX.getText()) - 1,
						Integer.parseInt(textFieldSubmarineY.getText()) - 1,
						(Orientation) comboBoxSubmarineOrientation.getSelectedItem());
				ships.add(ship);

				ship = new ShipPlacement(ShipTypes.Destroyer, Integer.parseInt(textFieldDestroyerX.getText()) - 1,
						Integer.parseInt(textFieldDestroyerY.getText()) - 1,
						(Orientation) comboBoxDestroyerOrientation.getSelectedItem());
				ships.add(ship);
				// testing data for invalid ship placements and throws InvalidShipPlacement
				// Exception
				try {
					BattleShipLogic.getInstance().setShipPlacements(ships);
					DlgPlaceShip.this.show(false);
					BattleShipLogic.getInstance().getGuiController().setState(GuiState.toss);
				} catch (InvalidShipPlacementException excp) {
					// catch the Ship Placement throw and display optionpane to reprompt for input
					JOptionPane.showMessageDialog(DlgPlaceShip.this, "Invalid Ship Placement");
				}

			}
		});
		// initialize Application Window
		btnApply.setBounds(335, 227, 89, 23);
		contentPane.add(btnApply);
	}
}