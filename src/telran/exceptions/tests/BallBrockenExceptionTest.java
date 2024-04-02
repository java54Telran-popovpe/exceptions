package telran.exceptions.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.exceptions.BallBrokenFlow;

class BallBrockenExceptionTest {

	private static final int N_FLOORS = 100;
	private static final int NUMBER_OF_TESTS = 1000;

	@Test
	void test() {
		for ( int i = 0; i < NUMBER_OF_TESTS ; i++ ) {
			BallBrokenFlow bbf = new BallBrokenFlow(N_FLOORS);
			assertEquals(bbf.getBrokenFlow(), getMinBrockenFloor(bbf));
			assertEquals(bbf.getBrokenFlow(), getMinBrockenFloorWithExceptioWrapper(bbf));
		}
	}

	
	private Integer getMinBrockenFloorWithExceptioWrapper(BallBrokenFlow bbf) {
		// TODO Auto-generated method stub
		int leftBound = 1;
		int rightBound = N_FLOORS;
		int foundFloor = -1;
		while( leftBound <= rightBound && foundFloor == -1) {
			int middle = (leftBound + rightBound) >>> 1;
			if ( checkFloor(bbf, middle) ) {
				if ( !checkFloor(bbf,middle - 1)) {
					foundFloor = middle;
				} else {
					rightBound = middle - 1;
				}
			} else {
				leftBound = middle + 1;
			}
		}
		return foundFloor;
	}
	private boolean checkFloor( BallBrokenFlow bbf, int  floor) {
		boolean result = false;
		try {
			bbf.checkFloor(floor);
		}
		catch (Exception e) {
			result = true;
		}
		return result;
	}
	
	private Integer getMinBrockenFloor(BallBrokenFlow bbf) {
		// TODO Auto-generated method stub
		int leftBound = 1;
		int rightBound = N_FLOORS;
		int foundFloor = -1;
		while( leftBound <= rightBound && foundFloor == -1) {
			int middle = (leftBound + rightBound) >>> 1;
			try {
				bbf.checkFloor(middle);
				leftBound = middle + 1;
			}
			catch (Exception e) {
				try {
					bbf.checkFloor(middle - 1);
					foundFloor = middle;
				}
				catch (Exception e1) {
					rightBound = middle - 1;
				}	
			}
		}
		return foundFloor;
	}
}
