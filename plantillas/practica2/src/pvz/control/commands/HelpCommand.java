package pvz.control.commands;

import pvz.logic.GameModel; 
import pvz.view.GameView; 
import pvz.view.Messages;

public class HelpCommand extends Command {
	
	public HelpCommand() {
		super (
			Messages.COMMAND_HELP_NAME,
			Messages.COMMAND_HELP_SHORTCUT,
			Messages.COMMAND_HELP_DETAILS,
			Messages.COMMAND_HELP_HELP
		);
	  }
	@Override
	public void execute(GameModel gm, GameView gv) {
		gv.showMessage(Messages.HELP);//muestra el texto de ayuda para el jugador
	}
	
	/*
	@Override
	public Command create(String[] c) {
		if (c.length != 1) {
			return null;
		}
		return this;
	}
*/
}
