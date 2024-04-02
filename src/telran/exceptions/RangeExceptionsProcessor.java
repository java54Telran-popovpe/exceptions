package telran.exceptions;

public class RangeExceptionsProcessor {
	private RangeExceptions rangeExceptions;
	private int counterGreaterMax; //how many numbers have been greater than max range
	private int counterLessMin; //how many numbers 
	private int counterRange;
	public RangeExceptionsProcessor( RangeExceptions rangeExceptions ) {
		this.rangeExceptions = rangeExceptions;
	}
	public void numberProcessor( int number ) {
		try {
			rangeExceptions.checkNumber(number);
			counterRange++;
		} catch (NumberGreaterRangeMaxException e) {
			counterGreaterMax++;
		} catch (NumberLessRangeMinException e) {
			counterLessMin++;
		}
	}
	public RangeExceptions getRangeExceptions() {
		return rangeExceptions;
	}
	public void setRangeExceptions(RangeExceptions rangeExceptions) {
		this.rangeExceptions = rangeExceptions;
	}
	public int getCounterGreaterMax() {
		return counterGreaterMax;
	}

	public int getCounterLessMin() {
		return counterLessMin;
	}

	public int getCounterRange() {
		return counterRange;
	}

	
 }
