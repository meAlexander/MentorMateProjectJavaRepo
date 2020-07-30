package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import exceptions.CoordinateBoundaryException;
import exceptions.GridBoundaryException;
import exceptions.ZeroOneException;
import game.GenerationZeroGame;
import getGrid.GetGridCommand;
import getInput.GetValuesInputForTheGame;
import getInput.GetValuesInputForGrid;

public class Main {
	public static void main(String[] args) {
		BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

		GetGridCommand grid;
		GetValuesInputForGrid valuesForGrid;
		GetValuesInputForTheGame valuesForGame;
		GenerationZeroGame game;

		try {
			grid = new GetGridCommand(buffReader);

			valuesForGrid = new GetValuesInputForGrid(grid.getGrid(), buffReader);
			valuesForGrid.initializeGrid();
			valuesForGrid.printGrid();

			valuesForGame = new GetValuesInputForTheGame(grid.getGrid(), buffReader);

			game = new GenerationZeroGame(valuesForGrid.getInitializedGrid(), valuesForGame.getInput());
			game.action();
			game.showResult();

		} catch (NumberFormatException | IOException ex) {
			System.out.println("Input must be a number.");
		} catch (ZeroOneException e) {
			System.out.println(e.getMessage());
		} catch (CoordinateBoundaryException e) {
			System.out.println(e.getMessage());
		} catch (GridBoundaryException e) {
			System.out.println(e.getMessage());
		}
	}
}