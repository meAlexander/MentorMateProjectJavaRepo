package getInput;

import java.io.BufferedReader;
import java.io.IOException;

import exceptions.ZeroOneException;

public class GetValuesInputForGrid {
	private int[][] grid2D;
	private BufferedReader buffReader;

	public GetValuesInputForGrid(int[][] grid2D, BufferedReader buffReader) {
		this.grid2D = grid2D;
		this.buffReader = buffReader;
	}

	public void initializeGrid() throws IOException, ZeroOneException {
		// fill in a grid
		for (int row = 0; row < grid2D.length; row++) {
			for (int col = 0; col < grid2D[row].length; col++) {
				System.out.println("Please enter value of grid at row [" + row + "] col[" + col + "]");
				int value = Integer.parseInt(buffReader.readLine());
				
				// check if the value is 0 or 1
				if (value == 0 || value == 1) {
					grid2D[row][col] = value;
				}else {
					throw new ZeroOneException();
				}
			}
		}
	}

	public void printGrid() {
		// print each row and column
		for (int row = 0; row < grid2D.length; row++) {
			for (int col = 0; col < grid2D[row].length; col++) {
				System.out.print(grid2D[row][col] + "  ");
			}
			System.out.println();
		}
	}

	public int[][] getInitializedGrid() {
		return grid2D;
	}
}