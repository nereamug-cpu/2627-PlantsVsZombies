package pvz.control.command;
import java.util.Scanner;


import pvz.logic.*;
import pvz.view.*;

public class AddPlantCheatCommand extends Command{
	private int col;
	private int row;
	
	public AddPlantCheatCommand() {
		super(
				Messages.COMMAND_CATCH_NAME,
				Messages.COMMAND_CATCH_SHORTCUT,
				Messages.COMMAND_CATCH_DETAILS,
				Messages.COMMAND_CATCH_HELP
		);
	}
	
	private AddPlantCheatCommand(int c, int r) {
		this();
		this.col = c;
		this.row = r;
	}
	
	
	@Override
	public Command create(String[] c) {
		// comprobamos que String[] c tenga 3 elementos, los que necesita CatchCommand
		if (c.length != 3) {
			return null;
		}
		
		// leemos la columna y la fila de String[] c
		Scanner colScanner = new Scanner(c[1]);
		Scanner rowScanner = new Scanner(c[2]);
		
		// comprobamos que ambas sean números enteros
		if (!colScanner.hasNextInt() || !rowScanner.hasNextInt()) {
			colScanner.close();
			rowScanner.close();
			return null;
		}
		
		// creamos variables y almacenamos los valores enteros
		int new_col = colScanner.nextInt();
		int new_row = rowScanner.nextInt();
		
		colScanner.close();
		rowScanner.close();
		
		return new AddPlantCheatCommand(new_col, new_row);
	}
	
	@Override
	public void execute(GameModel gm, GameView gv) {
		// ...
	}
}
