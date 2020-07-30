package exceptions;

@SuppressWarnings("serial")
public class GridBoundaryException extends Exception {
	
	@Override
	public String getMessage() {
		return "Grid boundary must be less than 1000.";
	}
}