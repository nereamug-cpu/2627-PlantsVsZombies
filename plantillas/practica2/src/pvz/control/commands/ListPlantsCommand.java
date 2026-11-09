package pvz.control.commands;

import pvz.logic.GameModel; //le he quitado los * para importar lo mínimo ecesario
import pvz.view.GameView; 
import pvz.view.Messages;

public class ListPlantsCommand extends Command{
	public ListPlantsCommand() {
		super (//invoca a la constructora de Command (superclase)
			Messages.COMMAND_LIST_PLANTS_NAME,
			Messages.COMMAND_LIST_PLANTS_SHORTCUT,
			Messages.COMMAND_LIST_PLANTS_DETAILS,
			Messages.COMMAND_LIST_PLANTS_HELP
		);
	}
	/*
	@Override
	public Command create(String[] c) {
		// comprobamos que la cadena String[] c no tenga más que un elemento, el propio comando
		if (c.length != 1 ) {
			return null;
		}
		return this;
	}
	*/
	@Override
	public void execute(GameModel gm, GameView gv) {//muestra descripción de las plantas pero no avanza ciclo
		gv.showMessage(Messages.LIST);
	}
}
