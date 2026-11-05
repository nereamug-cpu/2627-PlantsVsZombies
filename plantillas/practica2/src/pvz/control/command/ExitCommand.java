package pvz.control.command;
import pvz.view.Messages;

public class ExitCommand extends Command{
	public ExitCommand() {
		this.name = Messages.COMMAND_EXIT_NAME;
		this.shortcut = Messages.COMMAND_EXIT_SHORTCUT;
		this.details = Messages.COMMAND_EXIT_DETAILS;
		this.help = Messages.COMMAND_EXIT_HELP;
	}
	
	@Override
	public Command create(String[] c) {
		// comprobamos que String[] c no tiene más que un elemento, el propio comando
		if (c.length != 1) {
			return null;
		}
		return this;
	}
	
	@Override
	public void execute(GameModel gm, GameView gv) {
		// ...
	}
}
