package telran.exceptions.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.exceptions.NumberGreaterRangeMaxException;
import telran.exceptions.NumberLessRangeMinException;
import telran.exceptions.RangeExceptions;

class RangeExceptionTests {

	@Test
	void constructorTest() throws NumberGreaterRangeMaxException, NumberLessRangeMinException {
		RangeExceptions range = RangeExceptions.getRangeException(3, 30);
		assertThrowsExactly(IllegalArgumentException.class, ()-> RangeExceptions.getRangeException(30, 3) );
		range.checkNumber(5);
		assertThrowsExactly(NumberGreaterRangeMaxException.class, () -> range.checkNumber(35));
		assertThrowsExactly(NumberLessRangeMinException.class, () -> range.checkNumber(2));
	}

}
