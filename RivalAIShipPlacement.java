package com.company;

/**
 * By: Mark Mu
 * Automatically places ships for AI
 *
 * Installation:
 * Call class with method (ex. RivalAIShipPlacement.randomizeAIShipPlacement())
 * or only call method (ex. randomizeAIShipPlacement())
 * Then read file created when ran
 * Made easily portable
 *
 * Steps:
 * - Determine sizes for ships based on i value
 * - Choose between vertical or horizontal
 * - Generate ships, fill ship tiles with 'S' and empty tiles with '.'
 * - Writes to file for reading & print to console
 * - Access file called "shipCoordinates.txt"
 */

import java.util.*;
import java.io.*;

public class RivalAIShipPlacement {
    // Constant, size has been determined by project details
    static int size = 10;

    static void randomizeAIShipPlacement() throws FileNotFoundException {
        Random random = new Random();
        int[][] coordinates = new int[size][size];

        for (int i = 5; i > 0; i--) { // i value determines ship size
            // The point we use, to place and rotate the ship
            int x = random.nextInt(coordinates.length);
            int y = random.nextInt(coordinates.length);

            boolean vertical = random.nextBoolean();

            // If vertical or horizontal
            if (vertical) {
                if (y + i > size) {
                    y -= i;
                }
            } else if (x + i > size) {
                x -= i;
            }

            boolean freeTile = true;
            // Check if free space
            if (vertical) {
                for (int m = y; m < y + i; m++) {
                    // neighbor is found
                    if (coordinates[m][x] != 0) {
                        freeTile = false;
                        break;
                    }
                }
            }
            else {
                for (int n = x; n < x + i; n++) {
                    // Neighbor is found
                    if (coordinates[y][n] != 0) {
                        freeTile = false;
                        break;
                    }
                }
            }

            // If nothing is available, retry
            if (!freeTile) {
                i++;
                continue;
            }

            // Fill adjacent tiles
            if (vertical) {
                for (int m = Math.max(0, x - 1); m < Math.min(size, x + 2); m++) {
                    for (int n = Math.max(0, y - 1); n < Math.min(size, y + i + 1); n++) {
                        coordinates[n][m] = 9;
                    }
                }
            } else {
                for (int m = Math.max(0, y - 1); m < Math.min(size, y + 2); m++) {
                    for (int n = Math.max(0, x - 1); n < Math.min(size, x + i + 1); n++) {
                        coordinates[m][n] = 9;
                    }
                }
            }
            // Fill ship tiles
            for (int j = 0; j < i; j++) {
                coordinates[y][x] = i;
                if (vertical) {
                    y++;
                } else {
                    x++;
                }
            }
        }
        // Build the map :D
        char[][] map = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = coordinates[i][j] == 0 || coordinates[i][j] == 9 ? '.' : 'S';
            }
        }
        // Print map to console
        Arrays.stream(map)
                .forEach(m -> System.out.println(Arrays.toString(m).replace(",", "")));

        // Print map into file
        PrintWriter writer = new PrintWriter("shipCoordinates.txt"); // File name can be changed
        writer.println(Arrays.deepToString(map)); // Add .replace("[target]", "[replacement]")
                                                    // if you want to remove unwanted symbols
        writer.close();
    }

    // Not necessary
    public static void main(String[] args) throws FileNotFoundException {
        randomizeAIShipPlacement(); // Demonstrate my automatic ship placement algorithm in console
    }
}