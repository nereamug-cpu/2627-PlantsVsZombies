package pvz.logic;
//GameModel ahora tiene solo los métodos relacionados con los COMANDOS
import pvz.utils.Position;

public interface GameModel {
	void reset();//reinicia la partida con la misma semilla
	void update();//ejecuta para avanzar un cicllo
	void quit();//se pone a true para que el while de Controller pare
	boolean addGameObject(String plantType, Position p);//intenta añadir planta descontando soles si la casilla es válida y vacía
	int getCoins();//soles actuales
	boolean isInsideBoard(Position p);//si casilla válida dentro del tablero
	boolean isEmpty(Position p); //si casilla vacía
	boolean checkGameObject(String plantType);//si nombre de planta correcto
	boolean hasGameFinished();
    boolean playerQuits();
}
