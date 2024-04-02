package telran.exceptions;

public class RangeExceptions {
	private int min;
	private int max;
	private RangeExceptions( int min, int max ) {
		
		this.min = min;
		this.max = max;
	}
	public static RangeExceptions getRangeException( int min, int max ) {
		if ( max <= min ) {
			throw new IllegalArgumentException(String.format("max (%d) less or equal min(%d)", max, min));
		}
		return new RangeExceptions( min, max );
		
	}
	
	public void checkNumber( int number ) throws NumberGreaterRangeMaxException, NumberLessRangeMinException {
		if ( number > max ) {
			throw new NumberGreaterRangeMaxException(max, number);
		}
		if ( number < min ) {
			throw new NumberLessRangeMinException(min, number);
		}
	}

}
