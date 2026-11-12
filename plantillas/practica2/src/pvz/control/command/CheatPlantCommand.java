package pvz.control.command;
import java.util.Scanner;


import pvz.logic.*;
import pvz.view.*;
import utils.Position;

public class CheatPlantCommand extends Command{
	private String plantName;
	private int col;
	private int row;
	
	public CheatPlantCommand() {
		super (
				Messages.COMMAND_CHEAT_PLANT_NAME,
				Messages.COMMAND_CHEAT_PLANT_SHORTCUT,
				Messages.COMMAND_CHEAT_PLANT_DETAILS,
				Messages.COMMAND_CHEAT_PLANT_HELP
		);
	}
	
	private CheatPlantCommand(String pN, int c, int r) {
		this();
		this.plantName = pN;
		this.col = c;
		this.row = r;
	}
	
	
	@Override
	public Command create(String[] c) {
		// comprobamos que String[] c tenga cuatro parámetros, los que necesita CheatPlantCommand
		if (c.length != 4) {
			return null;
		}
		
		String pN = c[1];
		// leemos la columna y la fila de String[] c
		Scanner colScanner = new Scanner(c[2]);
		Scanner rowScanner = new Scanner(c[3]);
		
		// comprobamos que ambas son números
		if (!colScanner.hasNextInt() || !rowScanner.hasNextInt()) {
			colScanner.close();
			rowScanner.close();
			return null;
		}
		
		// creamos variables en las que guardamos los valores enteros
		int new_col = colScanner.nextInt();
		int new_row = rowScanner.nextInt();
		
		colScanner.close();
		rowScanner.close();
		
		return new CheatPlantCommand(pN, new_col, new_row);
	}
	
	
	@Override
	public void execute(GameModel gm, GameView gv) {
		Position pos = new Position(row, col);
		//si los parámetros están mal escritos
		if (!gm.checkGameObject(this.plantName)) gv.showError(Messages.INVALID_GAME_OBJECT);
		//casilla mal
		else if (!gm.isInsideBoard(pos) || !gm.isEmpty(pos)) gv.showError(Messages.INVALID_POSITION);
		else {
            if (gm.addGameObjectForFree(plantName, pos)) {
				gm.update();
                gv.showGame();
            }
            else {
            	gv.showError(Messages.NOT_ENOUGH_COINS);
            }
		}
	}
}
