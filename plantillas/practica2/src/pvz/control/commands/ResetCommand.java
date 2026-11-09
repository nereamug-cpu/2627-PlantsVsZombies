package pvz.control.commands;
//import java.util.Scanner; es sin Scanner, igual que AddPlants
import pvz.logic.GameModel; 
import pvz.view.GameView; 
import pvz.view.Messages;

//propuesta: es más corto así

public class ResetCommand extends Command {
	
	public ResetCommand() {
	super (
			Messages.COMMAND_RESET_NAME, 
			Messages.COMMAND_RESET_SHORTCUT, 
			Messages.COMMAND_RESET_DETAILS, 
			Messages.COMMAND_RESET_HELP
	);
	}
	
	@Override
	public void execute(GameModel gm, GameView gv) {
		gm.reset();//reinica estado del juego, listas y contadores
		gv.showGame();//muestra tablero inicial ya reiniciado
	}
}