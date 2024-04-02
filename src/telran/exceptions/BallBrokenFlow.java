package telran.exceptions;

import java.util.Random;

public class BallBrokenFlow {
	private int brokenFloor;
	@SuppressWarnings("unused")
	private int nFloors;
	public BallBrokenFlow( int nFloors ) {
		this.nFloors = nFloors;
		brokenFloor = new Random().nextInt(1, nFloors + 1);
		
	}
	
	public int getBrokenFlow() {
		return brokenFloor;
	}
	
	public void checkFloor( int floor ) throws Exception {
		if ( floor >= brokenFloor )
			throw new Exception();
	}
	public boolean checkFloorWithoutException( int floor ) {
		return floor >= brokenFloor;
	}
	
}
