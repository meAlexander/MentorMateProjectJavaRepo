package game;

import createGrid.CreateGridCommand;

public class GenerationZeroGame {
	private int[][] nextGenerationGrid;
	private int[][] currentGenerationGrid;
	private int[] neighbourCells;
	private int[] input;
	private int countCells;
	private int nextGenerationCellResult;
	static int currentCell;

	public GenerationZeroGame(int[][] currentGenerationGrid, int[] input) {
		this.currentGenerationGrid = currentGenerationGrid;
		this.input = input;
		currentCell = currentGenerationGrid[input[0]][input[1]];
	}

	public void action() {
		createNextGenerationGrid();
		
		int row, col, n;
		for (n = 0; n < input[2]; n++) {
			for (row = 0; row < currentGenerationGrid.length; row++) {
				for (col = 0; col < currentGenerationGrid[row].length; col++) {
					int cellValue = currentGenerationGrid[row][col];

					// check if the cell is located at first row, first column
					if (row == 0 && col == 0) {
						neighbourCells = new int[3];
						neighbourCells[0] = currentGenerationGrid[row][col + 1];
						neighbourCells[1] = currentGenerationGrid[row + 1][col];
						neighbourCells[2] = currentGenerationGrid[row + 1][col + 1];

						// check if the cell is located at first row, last column
					} else if (row == 0 && col == currentGenerationGrid[row].length - 1) {
						neighbourCells = new int[3];
						neighbourCells[0] = currentGenerationGrid[row][currentGenerationGrid[row].length - 2];
						neighbourCells[1] = currentGenerationGrid[row + 1][currentGenerationGrid[row].length - 1];
						neighbourCells[2] = currentGenerationGrid[row + 1][currentGenerationGrid[row].length - 2];

						// check if the cell is located at last row, first column
					} else if (row == currentGenerationGrid.length - 1 && col == 0) {
						neighbourCells = new int[3];
						neighbourCells[0] = currentGenerationGrid[currentGenerationGrid.length - 1][col + 1];
						neighbourCells[1] = currentGenerationGrid[currentGenerationGrid.length - 2][col];
						neighbourCells[2] = currentGenerationGrid[currentGenerationGrid.length - 2][col + 1];

						// check if the cell is located at last row, last column
					} else if (row == currentGenerationGrid.length - 1
							&& col == currentGenerationGrid[row].length - 1) {
						neighbourCells = new int[3];
						neighbourCells[0] = currentGenerationGrid[currentGenerationGrid.length
								- 1][currentGenerationGrid[row].length - 2];
						neighbourCells[1] = currentGenerationGrid[currentGenerationGrid.length
								- 2][currentGenerationGrid[row].length - 1];
						neighbourCells[2] = currentGenerationGrid[currentGenerationGrid.length
								- 2][currentGenerationGrid[row].length - 2];

						// check if the cell is located at first row
					} else if (row == 0) {
						neighbourCells = new int[5];
						neighbourCells[0] = currentGenerationGrid[row][col + 1];
						neighbourCells[1] = currentGenerationGrid[row][col - 1];
						neighbourCells[2] = currentGenerationGrid[row + 1][col];
						neighbourCells[3] = currentGenerationGrid[row + 1][col + 1];
						neighbourCells[4] = currentGenerationGrid[row + 1][col - 1];

						// check if the cell is located at last row
					} else if (row == currentGenerationGrid.length - 1) {
						neighbourCells = new int[5];
						neighbourCells[0] = currentGenerationGrid[row][col + 1];
						neighbourCells[1] = currentGenerationGrid[row][col - 1];
						neighbourCells[2] = currentGenerationGrid[row - 1][col];
						neighbourCells[3] = currentGenerationGrid[row - 1][col + 1];
						neighbourCells[4] = currentGenerationGrid[row - 1][col - 1];

						// check if the cell is located at first column
					} else if (col == 0) {
						neighbourCells = new int[5];
						neighbourCells[0] = currentGenerationGrid[row - 1][col];
						neighbourCells[1] = currentGenerationGrid[row - 1][col + 1];
						neighbourCells[2] = currentGenerationGrid[row][col + 1];
						neighbourCells[3] = currentGenerationGrid[row + 1][col];
						neighbourCells[4] = currentGenerationGrid[row + 1][col + 1];

						// check if the cell is located at last column
					} else if (col == currentGenerationGrid[row].length - 1) {
						neighbourCells = new int[5];
						neighbourCells[0] = currentGenerationGrid[row - 1][col];
						neighbourCells[1] = currentGenerationGrid[row - 1][col - 1];
						neighbourCells[2] = currentGenerationGrid[row][col - 1];
						neighbourCells[3] = currentGenerationGrid[row + 1][col];
						neighbourCells[4] = currentGenerationGrid[row + 1][col - 1];

						// last option if the cell is surrounded by 8 cells
					} else {
						neighbourCells = new int[8];
						neighbourCells[0] = currentGenerationGrid[row][col + 1];
						neighbourCells[1] = currentGenerationGrid[row][col - 1];
						neighbourCells[2] = currentGenerationGrid[row - 1][col];
						neighbourCells[3] = currentGenerationGrid[row - 1][col + 1];
						neighbourCells[4] = currentGenerationGrid[row - 1][col - 1];
						neighbourCells[5] = currentGenerationGrid[row + 1][col];
						neighbourCells[6] = currentGenerationGrid[row + 1][col + 1];
						neighbourCells[7] = currentGenerationGrid[row + 1][col - 1];
					}
					checkSurroundedCells(cellValue, row, col);
				}
			}

			// print each new generation
//			for (int row1 = 0; row1 < nextGenerationGrid.length; row1++) {
//				for (int col1 = 0; col1 < nextGenerationGrid[row1].length; col1++) {
//					System.out.print(nextGenerationGrid[row1][col1] + "  ");
//				}
//				System.out.println();
//			}

			calculation();

			// set current generation with the next generation we created
			currentGenerationGrid = nextGenerationGrid;

			// create grid for next generation
			createNextGenerationGrid();
		}
	}

	//
	private void checkSurroundedCells(int value, int row, int col) {
		countCells = 0;

		// green cell
		if (value == 1) {
			// count green surrounded cells
			for (int i = 0; i < neighbourCells.length; i++) {
				if (neighbourCells[i] == 1) {
					countCells++;
				}
			}

			// check if surrounding red cells(0) are 0,1,4,5,7,8
			// and change cell value for next generation in red(0)
			if (countCells == 0 || countCells == 1 || countCells == 4 || countCells == 5 || countCells == 7
					|| countCells == 8) {
				value = 0;
			}

			// red cell
		} else if (value == 0) {
			// count green surrounded cells
			for (int i = 0; i < neighbourCells.length; i++) {
				if (neighbourCells[i] == 1) {
					countCells++;
				}
			}

			// check if surrounding green cells(1) are 3 or 6
			// and change cell value for next generation in green(1)
			if (countCells == 3 || countCells == 6) {
				value = 1;
			}
		}
		fillInNextGenerationGrid(value, row, col);
	}

	// fill in next generation grid based on previous generation
	private void fillInNextGenerationGrid(int value, int row, int col) {
		nextGenerationGrid[row][col] = value;
	}

	// create a new 2DGrid and initialize nextGenerationGrid with the new 2DGrid
	protected void createNextGenerationGrid() {
		CreateGridCommand nextGeneration = new CreateGridCommand(currentGenerationGrid.length,
				currentGenerationGrid[0].length);
		nextGenerationGrid = nextGeneration.createGrid();
	}

	// calculate how many times cell become green or red
	private void calculation() {
		// check how many times red cell become green cell
		if (currentCell == 0) {
			if (nextGenerationGrid[input[1]][input[0]] == 1) {
				nextGenerationCellResult++;
			}
			// check how many times green cell become red cell
		} else if (currentCell == 1) {
			if (nextGenerationGrid[input[1]][input[0]] == 0) {
				nextGenerationCellResult++;
			}
		}
	}

	// result of calculation
	public void showResult() {
		System.out.println("Value changed: " + nextGenerationCellResult);
	}
}