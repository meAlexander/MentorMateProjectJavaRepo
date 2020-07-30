package exceptions;

@SuppressWarnings("serial")
public class CoordinateBoundaryException extends Exception {
	
	@Override
	public String getMessage() {
		return "The entered coordinate is outside the boundary of existing grid.";
	}
}