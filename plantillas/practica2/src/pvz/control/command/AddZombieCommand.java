package pvz.control.command;
import java.util.Scanner;
import utils.Position;
import pvz.logic.*;
import pvz.view.*;

public class AddZombieCommand extends Command {
	private String zombieName;
	private int row;
	private int col;
	
	public AddZombieCommand() {
		super(
				Messages.COMMAND_ADD_ZOMBIE_NAME,
				Messages.COMMAND_ADD_ZOMBIE_SHORTCUT,
				Messages.COMMAND_ADD_ZOMBIE_DETAILS,
				Messages.COMMAND_ADD_ZOMBIE_HELP
		);
	}
	
	private AddZombieCommand(String zN, int c, int r) {
		// llamamos primero a la constructora sin parámetros para inicializar los atributos de Command
		this();
		this.zombieName = zN;
		this.col = c;
		this.row = r;
	}
	
	@Override
	public Command create(String[] c) {
		// Comprobamos que la cadena de caracteres tiene 4 elementos
		if (c.length != 4) {
			return null;
		}
		
		String zN = c[1];
		
		// leemos la columna y la fila de la cadena de caracteres
		Scanner colScanner = new Scanner(c[2]);
		Scanner rowScanner = new Scanner(c[3]);
		
		if (!colScanner.hasNextInt() || !rowScanner.hasNextInt()) {
			colScanner.close();
			rowScanner.close();
			return null;
		}
		
		// creamos variables de tipo int que almacenan los valores de columna y fila leídos en String[] c
		int new_col = colScanner.nextInt();
		int new_row = rowScanner.nextInt();
		
		colScanner.close();
		rowScanner.close();
		
		return new AddZombieCommand(zN, new_col, new_row);
	}
	
	@Override
	public void execute(GameModel gm, GameView gv) {
		Position pos = new Position(row, col);
		
		// si los parámetros están mal escritos
		if (!gm.validZombieName(this.zombieName)) {
			gv.showError(Messages.INVALID_GAME_OBJECT);
		}
		// casilla mal
		else if (!gm.isInsideBoard(pos) || !gm.isEmpty(pos)) {
			gv.showError(Messages.INVALID_POSITION);
		}
		else {
			if (gm.addGameObjectForFree(this.zombieName, pos)) {
				gm.update();
				gv.showGame();
			}
		}
	}
}
