package pvz.control;
import pvz.logic.Game;
import pvz.view.*;
import pvz.control.command.*;

public class Controller {
	private final Game game;
	private final GameView view;
	
	public Controller(Game game) {
		this.game = game;
		this.view = new GamePrinter(game);
	}
	
	public void run() {
		while (!game.hasGameFinished() && !game.playerQuits()) {
			   // 2. Ask for user action
			    String[] words = view.getPrompt();
			    Command command = Command.parse(words);
			    if (command != null) {
			        // 3-4. Game Action & Update. Draw if required
			        command.execute(game, view);
			    } else {
			        view.showError(Messages.UNKNOWN_COMMAND);
			    }
			}
	}
}
