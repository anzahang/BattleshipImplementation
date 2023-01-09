import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;

/**
 * 
 * @author Andrew Zhang
 *
 */
public class BattleField extends JPanel {

	/**
	 * Create the panel.
	 */
	// declare 2D array of class type buttons
	GridButton[][] buttons = new GridButton[10][10];

	// generating the buttons for the battle field
	public BattleField() {
		setLayout(new GridLayout(10, 10, 5, 5));
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				// saving buttons to class type and 2D array
				GridButton btn = new GridButton(i, j);
				buttons[i][j] = btn;
				this.add(btn);
			}
		}
	}

	// display the grid buttons array onto Application Window
	public void displayGrid(GridStatus[][] gridData, boolean displayShip) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				GridButton btn = buttons[i][j];
				if (displayShip || gridData[i][j] != GridStatus.PartOfShip)
					btn.setStatus(gridData[i][j]);
				else
					btn.setStatus(GridStatus.Default);
			}
		}
	}

	// enable viewing of the grid
	@Override
	public void setEnabled(boolean enable) {
		super.setEnabled(enable);

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				buttons[i][j].setEnabled(enable);
			}
		}
	}

}