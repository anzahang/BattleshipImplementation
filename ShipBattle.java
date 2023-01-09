
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;

import java.util.Timer;
import java.util.TimerTask;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

public class ShipBattle implements BattleShipController {

	private JFrame frame;
	BattleField myField;
	BattleField rivalField;
	GuiState state = GuiState.setting;
	JButton btnShipPlacement = null;
	JButton btnToss = null;
	JButton btnTimer = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShipBattle window = new ShipBattle();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		GameSound();

	}

	// Imports audio for game
	public static void GameSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		// Scanner to scan for audio file
		Scanner input = new Scanner(System.in);

		// Files the audio
		File file = new File("Battleship Sound.wav");

		// Gets audio from file
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);

		// Gets the whole clip of the audio file
		Clip audio = AudioSystem.getClip();

		// Opens the file to stream audio
		audio.open(audioStream);

		// Sets volume
		FloatControl gainControl = (FloatControl) audio.getControl(FloatControl.Type.MASTER_GAIN);

		// Reduces volume by amount of decibels
		gainControl.setValue(6.0f);

		// Plays audio
		audio.start();

		// Loops audio
		audio.loop(2);
	}

	/**
	 * Create the application.
	 */
	public ShipBattle() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		BorderLayout borderLayout = (BorderLayout) frame.getContentPane().getLayout();
		frame.setBounds(100, 100, 900, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panelAction = new JPanel();
		frame.getContentPane().add(panelAction, BorderLayout.NORTH);
		BattleShipLogic battleShipLogic = BattleShipLogic.getInstance(this);

		JPanel panelBattleField = new JPanel();
		panelBattleField.setBorder(new EmptyBorder(20, 40, 40, 40));
		frame.getContentPane().add(panelBattleField, BorderLayout.CENTER);
		panelBattleField.setLayout(new GridLayout(0, 2, 20, 20));

		myField = new BattleField();
		myField.setEnabled(false);
		rivalField = new BattleField();
		rivalField.setEnabled(false);
		panelBattleField.add(myField);
		panelBattleField.add(rivalField);

		btnShipPlacement = new JButton("Ship Placement");
		btnToss = new JButton("Toss");
		btnTimer = new JButton("00:00");
		panelAction.add(btnShipPlacement);
		panelAction.add(btnToss);
		panelAction.add(btnTimer);

		// action listener for when Ship Placement is clicked
		btnShipPlacement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BattleShipLogic backend = BattleShipLogic.getInstance();
				backend.reset();
				placeShips();
				try {
					backend.placeRivalShips();

				} catch (InvalidShipPlacementException expt) {
					// this exception is never thrown because it is AI ship placement
					JOptionPane.showMessageDialog(frame, "Stupid AI!");
				}
			}

		});

		btnToss.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnToss.setEnabled(false);
				battleShipLogic.toss();
				setState(GuiState.play);

				Timer GameTime = new Timer();
				GameTime.schedule(new Time(), 0, 1000);

			}
		});

		setState(GuiState.setting);

	}

	// Class for counting down of game timer
	class Time extends TimerTask {

		// Seconds of timer start
		int countdown = 300;

		// Runs the timer
		public void run() {

			// Stops timer when game finishes
			if (btnTimer.getText().equals("--:--")) {
				return;
			}
			// Counts down timer by one second
			countdown = countdown - 1;

			// Formatting of timer
			String time = String.format("%02d:%02d", countdown / 60, countdown % 60);

			// Sets text for timer to JButton
			btnTimer.setText(time);

			// Ends game when timer hits 00:00
			if (time.equals("00:00")) {
				gameFinished(1);
			}

		}
	}

	private void placeShips() {
		DlgPlaceShip dialog = new DlgPlaceShip();
		dialog.show(true);

	}

	// determine which part of the game the program is at
	public void setState(GuiState state) {
		if (state == GuiState.setting) {
			btnShipPlacement.setEnabled(true);
			btnToss.setEnabled(false);
			rivalField.setEnabled(false);
		} else if (state == GuiState.toss) {
			btnShipPlacement.setEnabled(false);
			btnToss.setEnabled(true);
			rivalField.setEnabled(false);
		} else if (state == GuiState.finish) {
			btnShipPlacement.setEnabled(true);
			btnToss.setEnabled(false);
			rivalField.setEnabled(false);
		} else if (state == GuiState.play) {
			btnShipPlacement.setEnabled(false);
			btnToss.setEnabled(false);
			rivalField.setEnabled(true);
		}
	}

	// constant updates of the player grid
	@Override
	public void updateMyField(GridStatus[][] gridData) {
		myField.displayGrid(gridData, true);
	}

	// constant updates of the AI grid
	@Override
	public void updateRivalField(GridStatus[][] gridData) {
		rivalField.displayGrid(gridData, false);
	}

	// determine who wins
	@Override
	public void gameFinished(int who) {
		if (who == 0) {
			JOptionPane.showMessageDialog(frame, "You Win!");
			btnTimer.setText("--:--");
		}
		if (who == 1) {
			JOptionPane.showMessageDialog(frame, "Ran out of Time!");
		} else {
			JOptionPane.showMessageDialog(frame, "Win!");
			btnTimer.setText("--:--");
		}

		this.setState(GuiState.finish);
	}

}