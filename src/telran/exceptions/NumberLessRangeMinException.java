package telran.exceptions;

@SuppressWarnings("serial")
public class NumberLessRangeMinException extends Exception {
	public NumberLessRangeMinException( int max, int number ) {
		super( String.format("Number(%d) less then range min(%d)", number, max));
	}

}
