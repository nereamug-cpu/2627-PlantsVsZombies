package pvz.logic;
//GameModel ahora tiene solo los métodos relacionados con los COMANDOS
import utils.Position;

public interface GameModel {
	void reset();//reinicia la partida con la misma semilla
	void update();//ejecuta para avanzar un cicllo
	void quit();//se pone a true para que el while de Controller pare
	void addGameObject(String plantType, Position position);//intenta añadir planta descontando soles si la casilla es válida y vacía
	void generateCoins(int amount);//aumenta soles del jugador
	int getCoins();//soles actuales
	boolean isInsideBoard(Position position);//si casilla válida dentro del tablero
	boolean isEmpty(Position position); //si casilla vacía
	boolean checkGameObject(String plantType);//si nombre de planta correcto
}
