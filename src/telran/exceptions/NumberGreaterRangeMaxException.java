package telran.exceptions;

@SuppressWarnings("serial")
public class NumberGreaterRangeMaxException extends Exception {
	public NumberGreaterRangeMaxException( int max, int number ) {
		super( String.format("Number(%d) greater then range max(%d)", number, max));
	}

}
