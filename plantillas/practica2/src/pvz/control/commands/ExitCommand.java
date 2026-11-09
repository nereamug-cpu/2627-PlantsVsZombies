package pvz.control.commands;

import pvz.logic.GameModel; 
import pvz.view.GameView;
import pvz.view.Messages;

public class ExitCommand extends Command{
	
	public ExitCommand() {
		super (
			Messages.COMMAND_EXIT_NAME,
			Messages.COMMAND_EXIT_SHORTCUT,
			Messages.COMMAND_EXIT_DETAILS,
			Messages.COMMAND_EXIT_HELP
		);
	}

	@Override
	public void execute(GameModel gm, GameView gv) {//meto gv tb. polimorfismo
		gm.quit();//jugador sale
	}
}
