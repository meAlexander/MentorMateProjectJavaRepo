package createGrid;

import java.io.BufferedReader;

public class CreateGridCommand {
	protected BufferedReader buffReader;
	protected int width;
	protected int height;
	
	public CreateGridCommand(int width, int height, BufferedReader buffReader) {
		this.width = width;
		this.height = height;
		this.buffReader = buffReader;
	}
	
	public CreateGridCommand(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public int[][] createGrid(){
		return new int[width][height];
	}
}