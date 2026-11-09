package pvz.control.command;
import pvz.logic.*;
import pvz.logic.gameobjects.factories.PlantFactory;
import pvz.view.*;
import pvz.logic.gameobjects.*;
import java.util.List;

public class ListPlantsCommand extends Command{
	public ListPlantsCommand() {
		this.name = Messages.COMMAND_LIST_PLANTS_NAME;
		this.shortcut = Messages.COMMAND_LIST_PLANTS_SHORTCUT;
		this.details = Messages.COMMAND_LIST_PLANTS_DETAILS;
		this.help = Messages.COMMAND_LIST_PLANTS_HELP;
	}
	
	@Override
	public Command create(String[] c) {
		// comprobamos que la cadena String[] c no tenga más que un elemento, el propio comando
		if (c.length != 1 ) {
			return null;
		}
		return this;
	}
	
	@Override
	public void execute(GameModel gm, GameView gv) {
		List<Plant> plantas = PlantFactory.getAvailablePlants();
		for (int i = 0; i < plantas.size(); i++) {
			
		}
	}
	
	
}
