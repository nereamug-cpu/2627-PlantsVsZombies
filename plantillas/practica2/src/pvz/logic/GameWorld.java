package pvz.logic;
//GameWorld ahora tiene solo los métodos relacionados con OBJETOS. plntas y zombies

import pvz.utils.Position;
import pvz.logic.gameobjects.GameItem;

public interface GameWorld {
	public static final int NUM_ROWS = 4;
	public static final int NUM_COLS = 8;
	
	boolean isEmpty(Position posicion);//si casilla vacía
	boolean isInsideBoard(Position position);//si posición válida dentro del tablero
	GameItem getGameItemInPosition(Position position);//para cosultar qué hay en la casilla

//estas hay que quitarlas de GameWorld:	
	//void addGameObject(String plantType, Position position);//va en Model pq se usan por las órdenes del player
	//void attackZombie(Position p, int damage);//lo hace GameItem
	//void attackPlant(Position p, int damage);//lo hace GameItem
	//Position newZombiePosition(int row);//no necesario pq World ya tiene NUM_COLS = 8, ZombiesManager ñuede hacer directamente new Position(row, GameWorld.NUM_COLS)
	//boolean checkGameObject(String plantType);//va en Model pq se usan por las órdenes del player
	//String positionToString(Position p);//va en Status pq es la vista (GamePrinter) la que da el formato a las celdas
	//void generateCoins(int amount);//va en Model pq modifica el saldo del jugador

}
