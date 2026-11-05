package pvz.control.command;
import java.util.Scanner;


import pvz.control.Level;
import pvz.logic.*;
import pvz.view.*;

public class ResetCommand extends Command{
	private Level level;
	private long seed;
	
	
	public ResetCommand() {
		this.name = Messages.COMMAND_RESET_NAME;
		this.shortcut = Messages.COMMAND_RESET_SHORTCUT;
		this.details = Messages.COMMAND_RESET_DETAILS;
		this.help = Messages.COMMAND_RESET_HELP;
	}
	
	private ResetCommand(Level l, long s) {
		// llamamos primero a la constructora sin parámetros para inicializar los atributos de Command
		this();
		this.level = l;
		this.seed = s;
	}
	
	@Override
	public Command create(String[] c) {
		// si no tiene más parámetros que el propio comando entonces no le damos valor a level ni a seed
		if (c.length != 1) {
			return this;
		}
		
		// Si no tiene 3 elementos no es un comando de tipo ResetCommand
		if (c.length != 3) {
			return null;
		}
		
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
		
		return new ResetCommand(l, new_seed);
	}
	
	@Override
	public void execute(GameModel gm, GameView gv) {
		//...
	}
}
