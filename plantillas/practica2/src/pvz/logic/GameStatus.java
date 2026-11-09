package pvz.logic;
//GameStatus ahora tiene solo los métodos relacionados con la VISTA, lectura
import pvz.utils.Position;

public interface GameStatus {
	int getCycles();//ciclos actuales para mostrarlos
	int getCoins();//soles disponibles
	int getRemainingZombies();//zombies que quedan por salir
	String positionToString(Position p); //contenido de la casilla
	boolean playerWins(); //si ha eliminado a todos los zombies
	boolean playerQuits(); //sii ha salido con exit
	boolean hasGameFinished();//si partida terminada
}
