package getGrid;

import java.io.BufferedReader;
import java.io.IOException;

import createGrid.CreateGridCommand;
import exceptions.GridBoundaryException;

public class GetGridCommand {
	private BufferedReader buffReader;
	private int width;
	private int height;
	
	public GetGridCommand(BufferedReader buffReader) throws IOException, GridBoundaryException {
		this.buffReader = buffReader;
		setWidth();
		setHeight();
	}

	public int[][] getGrid() {
		CreateGridCommand createGridCommand = new CreateGridCommand(width, height, buffReader);
		int[][] grid = createGridCommand.createGrid();
		
		return grid;
	}
	
	private void setHeight() throws IOException, GridBoundaryException {
		System.out.println("Please enter height of grid");
		if ((height = Integer.parseInt(buffReader.readLine())) >= 1000){
			throw new GridBoundaryException();
		}
	}

	private void setWidth() throws IOException, GridBoundaryException {
		System.out.println("Please enter width of grid");
		if((width = Integer.parseInt(buffReader.readLine())) >= 1000) {
			throw new GridBoundaryException();
		}
	}
}