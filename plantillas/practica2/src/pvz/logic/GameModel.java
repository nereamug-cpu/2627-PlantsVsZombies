package pvz.logic;
import utils.Position;

import pvz.control.Level;

public interface GameModel {
	void reset();//reinicia la partida con la misma semilla
	void reset(Level level, long seed);
	void update();//ejecuta para avanzar un cicllo
	void quit();//se pone a true para que el while de Controller pare
	boolean addGameObject(String objectName, Position p);//intenta añadir planta descontando soles si la casilla es válida y vacía
	boolean addGameObjectForFree(String objectName, Position p);
	int getCoins();//soles actuales
	boolean isInsideBoard(Position p);//si casilla válida dentro del tablero
	boolean isEmpty(Position p); //si casilla vacía
	boolean validPlantName(String plantType);//si nombre de planta correcto
	boolean validZombieName(String zombieName);////si nombre del zombie correcto
	boolean hasGameFinished();
    boolean playerQuits();
}
