package pvz.control.command;
import pvz.logic.*;
import pvz.view.*;

public class ListZombiesCommand extends Command{
	public ListZombiesCommand() {
		this.name = Messages.COMMAND_LIST_ZOMBIES_NAME;
		this.shortcut = Messages.COMMAND_LIST_ZOMBIES_SHORTCUT;
		this.details = Messages.COMMAND_LIST_ZOMBIES_DETAILS;
		this.help = Messages.COMMAND_LIST_ZOMBIES_HELP;
	}
	
	@Override
	public Command create(String[] c) {
		// comprobamos que la cadena String[] c no tenga más que un elemento, el propio comando
		if (c.length != 1) {
			return null;
		}
		return this;
	}
	
	@Override
	public void execute(GameModel gm, GameView gv) {
		//...
	}
}
