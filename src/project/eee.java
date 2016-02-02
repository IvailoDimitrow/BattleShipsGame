package project;

import java.util.Random;
import java.util.Scanner;

public class eee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = new int[5][5];
		for (int row = 0; row < 5; row++) {
			for (int column = 0; column < 5; column++) {
				board[row][column] = -1;
			}
		}
		
		Scanner input = new Scanner(System.in);
		int[] shoot = new int[2];
		int destroyedShips = 0;
		int[][] ships = new int[3][2];
		Random random = new Random();
		for (int ship = 0; ship < 3; ship++) {
			ships[ship][0] = random.nextInt(5);
			ships[ship][1] = random.nextInt(5);
			for (int last = 0; last < ship; last++) {
				if ((ships[ship][0] == ships[last][0])
						&& (ships[ship][1] == ships[last][1]))
					do {
						ships[ship][0] = random.nextInt(5);
						ships[ship][1] = random.nextInt(5);
					} while ((ships[ship][0] == ships[last][0])
							&& (ships[ship][1] == ships[last][1]));
			}

		}
		
		do {
			
			for (int row = 0; row < 5; row++) {
				System.out.print((row + 1) + "");
				for (int column = 0; column < 5; column++) {
					if (board[row][column] == -1) {
						System.out.print(" " + "~");
					}
				}
				System.out.println();
			}
			
			System.out.print("Row: ");
			shoot[0] = input.nextInt();
			shoot[0]--;

			System.out.print("Column: ");
			shoot[1] = input.nextInt();
			shoot[1]--;

			for (int ship = 0; ship < ships.length; ship++) {
				if (shoot[0] == ships[ship][0] && shoot[1] == ships[ship][1]) {
					System.out.println("you hit a ship");
					destroyedShips += 1;
				}
			}
		} while (destroyedShips != 3);

	}

}
