package telran.exceptions.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.exceptions.NumberGreaterRangeMaxException;
import telran.exceptions.NumberLessRangeMinException;
import telran.exceptions.RangeExceptions;
import telran.exceptions.RangeExceptionsProcessor;

class RangeExeptionsProcessorTest {

	private static final int MIN = 10;
	private static final int MAX = 20;
	private static final int N_RANGE_NUMBERS = 10;
	private static final int RANGE_NUMBERS = 15;
	private static final int N_GREATE_MAX_NUMBER = 30;
	private static final int N_LESS_MIN_NUMBER = 3;
	private static final int RANGE_GREATER_NUMBER = 25;
	private static final int RANGE_LESS_NUMBER = 8;
	

	@Test
	void test() throws NumberGreaterRangeMaxException, NumberLessRangeMinException {
		RangeExceptions rangeExceptions = RangeExceptions.getRangeException(MIN, MAX);
		RangeExceptionsProcessor rangeExceptionsProcessor = new RangeExceptionsProcessor(rangeExceptions);
		processNumbers(rangeExceptionsProcessor, N_RANGE_NUMBERS, RANGE_NUMBERS);
		processNumbers(rangeExceptionsProcessor, N_GREATE_MAX_NUMBER, RANGE_GREATER_NUMBER);
		processNumbers(rangeExceptionsProcessor, N_LESS_MIN_NUMBER, RANGE_LESS_NUMBER);
		assertEquals(N_RANGE_NUMBERS, rangeExceptionsProcessor.getCounterRange());
		assertEquals(N_GREATE_MAX_NUMBER, rangeExceptionsProcessor.getCounterGreaterMax());
		assertEquals(N_LESS_MIN_NUMBER, rangeExceptionsProcessor.getCounterLessMin());
		
	}

	private void processNumbers(RangeExceptionsProcessor rangeExceptionsProcessor, int nNumbers, int number) {
		for ( int i  = 0; i < nNumbers; i++ ) {
			rangeExceptionsProcessor.numberProcessor(number);
		}
	}

}
