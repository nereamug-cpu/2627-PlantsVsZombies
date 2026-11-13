package pvz.control.command;
import pvz.logic.GameModel;
import pvz.logic.gameobjects.factories.ZombieFactory;
import pvz.logic.gameobjects.Zombies;
import java.util.List;
import pvz.view.*;

public class ListZombiesCommand extends Command{
	public ListZombiesCommand() {
		super(
			Messages.COMMAND_LIST_ZOMBIES_NAME,
			Messages.COMMAND_LIST_ZOMBIES_SHORTCUT,
			Messages.COMMAND_LIST_ZOMBIES_DETAILS,
			Messages.COMMAND_LIST_ZOMBIES_HELP
		);
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
	public void execute(GameModel gm, GameView gv) {//muestra descripción de las plantas pero no avanza ciclo
		List<Zombies> zombies = ZombieFactory.getAvailableZombies();
		
		String zombiesDescriptions = "";
		
		for (int i = 0; i < zombies.size(); i++) {
			if (!zombiesDescriptions.isEmpty()) {
				zombiesDescriptions += Messages.LINE_SEPARATOR;
			}
			
			zombiesDescriptions += zombies.get(i).getDescription();
		}
		
		gv.showMessage(zombiesDescriptions);
	}
}
