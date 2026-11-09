package pvz.logic;

import pvz.utils.Position;

public interface GameModel {
	void reset();
	void update();
	void quit();
	//...
	
	void addPlant(String plantType, Position position);
}
