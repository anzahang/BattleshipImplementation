
/**
 * By: Mark Mu
 * Gives AI a brain.
 *
 * Installation:
 * Just call class.
 * Made easily portable.
 *
 * Steps:
 * - AI shoots a random tile,
 * - If ship tile, fire at surrounding tiles
 *      - Once second ship tile is hit and ship hasn't sunken
 *          - Fire at tiles in that direction until ship has sunken
 * - If empty tile, save tile
 *      - Don't shoot saved empty tiles, keep shooting until found ship tile
 *          - Fire at tiles in that direction until ship has sunken
 * - Return to shooting random tiles that haven't been marked at missed or ship tile
 */

import java.util.*;

public class RivalAILogic {

	// Constants (10x10 board already determined in project initiation)
	static int size = 10;
	int[][] coordinates = new int[size][size];

	public void AIlogic() {
		// Goes in all directions once ship is hit
		boolean AImove = false;

		int x = 0, y = 0;
		while (!AImove) {
			Random random = new Random();
			int direction = random.nextInt(4);
			if (direction == 0)
				x = 1; // Right
			if (direction == 1)
				x = -1; // Left
			if (direction == 2)
				y = 1; // Up
			if (direction == 3)
				y = -1; // Down

			// Saved coordinates for futher use
			int xSaved = 0;
			int ySaved = 0;
			String lastMove;

			// If water, AI missed
			if (coordinates[xSaved + y][ySaved + x] == '.') {
				coordinates[xSaved + y][ySaved + x] = 'X';
				lastMove = "miss";
				AImove = true;
			} else if (coordinates[xSaved + y][ySaved + x] == 'X')
				AImove = false;
			else if (coordinates[xSaved + y][ySaved + x] == 'S')
				AImove = false;
			// If ship, AI hit
			else {
				coordinates[xSaved + y][ySaved + x] = 'S';
				lastMove = "hit";
				AImove = true;
			}
		}
	}

	public void AIturn() {
		// Randomly choose locations to fire at
		boolean AImove = false;
		while (!AImove) {
			int x = (int) (Math.random() * size);
			int y = (int) (Math.random() * size);

			// Basically sees whether it's water or a ship tile
			if (coordinates[x][y] == '.') {
				coordinates[x][y] = 'X';
				AImove = true;
			} else if (coordinates[x][y] == 'X')
				AImove = false;
			else if (coordinates[x][y] == 'S')
				AImove = false;
			else { // Must be a hit
				coordinates[x][y] = 'S';
				AImove = true;
			}
		}
	}

}