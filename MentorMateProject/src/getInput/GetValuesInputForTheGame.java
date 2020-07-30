package getInput;

import java.io.BufferedReader;
import java.io.IOException;

import exceptions.CoordinateBoundaryException;

public class GetValuesInputForTheGame {
	private int[][] grid;
	private BufferedReader buffReader;

	public GetValuesInputForTheGame(int[][] grid, BufferedReader buffReader) {
		this.buffReader = buffReader;
		this.grid = grid;
	}

	public int[] getInput() throws IOException, CoordinateBoundaryException {
		System.out.println("\nEnter cell coordinates.\nEnter width:");
		int width;

		// check if the entered coordinate is within the grid boundary
		if ((width = Integer.parseInt(buffReader.readLine())) >= grid[0].length) {
			throw new CoordinateBoundaryException();
		}

		System.out.println("Enter height:");
		int height;

		// check if the entered coordinate is within the grid boundary
		if ((height = Integer.parseInt(buffReader.readLine())) >= grid.length) {
			throw new CoordinateBoundaryException();
		}

		System.out.println("Enter number N(how many times the cell will change its color to the opposite color):");
		int n = Integer.parseInt(buffReader.readLine());

		int[] input = { width, height, n };

		return input;
	}
}