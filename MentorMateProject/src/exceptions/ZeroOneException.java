package exceptions;

@SuppressWarnings("serial")
public class ZeroOneException extends Exception {
	
	@Override
	public String getMessage() {
		return "The values of grid must be only 1s or 0s";
	}
}