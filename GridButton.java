
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class GridButton extends JButton {
	public int x = 0;
	public int y = 0;

	// declare grid with coordinates x and y with colour
	public GridButton(int x, int y) {
		super("");
		this.x = x;
		this.y = y;
		this.setBorder(new LineBorder(Color.DARK_GRAY));
		this.setBackground(Color.darkGray);

		// firing mechanic
		GridButton btn = this;
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BattleShipLogic.getInstance().fire(btn.x, btn.y);
			}
		});
	}

	// setting colours for the current status of the battle field
	public void setStatus(GridStatus gridStatus) {

		if (gridStatus == GridStatus.PartOfShip) {
			this.setBackground(Color.blue);
		} else if (gridStatus == GridStatus.Hit) {
			this.setBackground(Color.red);
		} else if (gridStatus == GridStatus.Sunk) {
			this.setBackground(Color.black);
		} else if (gridStatus == GridStatus.Miss) {
			this.setBackground(Color.cyan);
		} else {
			this.setBackground(Color.darkGray);
		}
	}
}