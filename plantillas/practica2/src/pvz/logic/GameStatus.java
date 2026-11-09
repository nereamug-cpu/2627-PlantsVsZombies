package pvz.logic;

import pvz.utils.Position;

public interface GameStatus {
	int getCycles();
	int getCoins();
	int getRemainingZombies();
	
	//...
	String positionToString(Position p);
}
