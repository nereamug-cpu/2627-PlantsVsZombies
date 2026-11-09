package pvz.control.commands;

import pvz.logic.GameModel; 
import pvz.view.GameView; 
import pvz.view.Messages;

public class NoneCommand extends Command {
	public NoneCommand() {
		super (
				Messages.COMMAND_UPDATE_NAME, 
				Messages.COMMAND_UPDATE_SHORTCUT, 
				Messages.COMMAND_UPDATE_DETAILS, 
				Messages.COMMAND_UPDATE_HELP
		);
	}
	
	@Override
	public void execute(GameModel gm, GameView gv) {
		gm.update();//avanza un ciclo
		gv.showGame();//muestra tablero
	}

	@Override
	public boolean matchCommand(String c) {
		return super.matchCommand(c) || c.isEmpty();
	}
}
