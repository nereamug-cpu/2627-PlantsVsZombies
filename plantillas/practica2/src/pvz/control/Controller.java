package pvz.control;

import pvz.control.commands.Command;//necesario para comunicarse con parse()
import pvz.logic.Game;
import pvz.view.GamePrinter;
import pvz.view.GameView;
import pvz.view.Messages;
//import pvz.utils.Position; //no necesario ya

/**
 * Input/output coordinator of the game (the C in MVC).
 *
 * <p>Owns the game loop: reads a line from stdin, parses it into a
 * command, validates parameters (plant type, position), delegates
 * state changes to {@link Game}, and triggers a board reprint via
 * {@link tp1.pvz.view.GameView>} when the cycle advances. It holds no game
 * state of its own; the source of truth is always {@link Game}.
 */
public class Controller {

	//no cambian durante toda la aprtida
	private final Game game;
	private final GameView view;

	//constructora. une game con la vista gameprinter
	public Controller(Game game) {
		this.game = game;
		this.view = new GamePrinter(game);
	}

	/**
	 * Runs the game logic.
	 */
	public void run() {
		view.showGame(); //la vista muestra el estado inicial del tablero y del juego
		while (!game.hasGameFinished() && !game.playerQuits()) { //se ejecuta mientras la partida no termine			
			//tiene que leer al player
			String[] words = view.getPrompt();//declarado en game view, lee una alínea y la devuelve separada por espacios
			Command command = Command.parse(words); //ahora es el parse() quien busca el comando que coincida con el del player
										
			//ahora solo
			if (command != null) command.execute(game, view);//si es válido, se ejecuta
			else view.showError(Messages.UNKNOWN_COMMAND);//si no, se muestra en pantalla el error correspondiente
			
		}
		view.showEndMessage();//muestra Game over y el motivo
	}
}