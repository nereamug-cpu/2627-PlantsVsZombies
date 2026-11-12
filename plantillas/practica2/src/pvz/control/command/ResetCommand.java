package pvz.control.command;
import java.util.Scanner;

import pvz.control.Level;
//import java.util.Scanner; es sin Scanner, igual que AddPlants
import pvz.logic.GameModel; 
import pvz.view.GameView; 
import pvz.view.Messages;

//propuesta: es más corto así

public class ResetCommand extends Command {
	private Level level;
	private long seed;
	
	boolean resetAll;
	
	public ResetCommand() {
	super (
			Messages.COMMAND_RESET_NAME, 
			Messages.COMMAND_RESET_SHORTCUT, 
			Messages.COMMAND_RESET_DETAILS, 
			Messages.COMMAND_RESET_HELP
	);
	this.resetAll = false;
	}
	
	public ResetCommand(Level level, long seed) {
		this();
		this.seed = seed;
		this.level = level;
		this.resetAll = true;
	}
	
	@Override
	public Command create(String[] c) {
		Command command = null;
		if (c == null || (c.length != 1 && c.length != 3)) {
			command =  null;
		}
		
		if (c.length == 1) {
			command = new ResetCommand();
		}
		else if (c.length == 3) {
			Level l = Level.valueOfIgnoreCase(c[1]);
			if (l == null) {
				return null;
			}
			
			// leemos seed se la cadena de String[] c
			Scanner seedScanner = new Scanner(c[2]);
			if (!seedScanner.hasNextLong()) {
				seedScanner.close();
				return null;
			}
			
			// creamos una variable de tipo long que almacene seed
			long new_seed = seedScanner.nextLong();
			seedScanner.close();
			
			command =  new ResetCommand(l, new_seed);
		}
		return command;
	}
	
	@Override
	public void execute(GameModel gm, GameView gv) {
		if (resetAll) {
			gm.reset(level, seed);
		}
		else {
			gm.reset();//reinica estado del juego, listas y contadores
		}
		
		gv.showGame();//muestra tablero inicial ya reiniciado
	}
}