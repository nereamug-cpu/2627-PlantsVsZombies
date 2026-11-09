package pvz.logic;
//GameWorld ahora tiene solo los métodos relacionados con OBJETOS. plntas y zombies

import pvz.utils.Position;
import pvz.logic.gameobjects.GameItem;

public interface GameWorld {
	int NUM_ROWS = 4;//las variables declaradas en una interface son ya public static final, no hace falta ponerlo
	int NUM_COLS = 8;
	
	boolean isEmpty(Position p);//si casilla vacía
	boolean isInsideBoard(Position p);//si posición válida dentro del tablero
	GameItem getGameItemInPosition(Position p);//para cosultar qué hay en la casilla
	void addSuncoins(int amount);
}
