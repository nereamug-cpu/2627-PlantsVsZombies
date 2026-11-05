package pvz.logic;

import pvz.utils.Position;
import pvz.logic.gameobjects.GameItem;

public interface GameWorld {
	public static final int NUM_ROWS = 4;
	public static final int NUM_COLS = 8;
	
	boolean isEmpty(Position posicion);
	boolean isInsideBoard(Position position);
	
	void addGameObject(String plantType, Position position);
	void attackZombie(Position p, int damage);
	void attackPlant(Position p, int damage);
	
	static Position newZombiePosition(int row);
	
	boolean checkGameObject(String plantType);
	String positionToString(Position p);
	
	void generateCoins(int amount);
	//...
	GameItem getGameIconInPosition(Position position);
}
