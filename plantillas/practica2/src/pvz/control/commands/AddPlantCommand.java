package pvz.control.commands;
import java.util.Scanner;

import pvz.logic.*;
import pvz.view.*;

public class AddPlantCommand extends Command{
	private String plantName;
	private int col;
	private int row;
	
	public AddPlantCommand() {
		this.name = Messages.COMMAND_ADD_PLANT_NAME;
		this.shortcut = Messages.COMMAND_ADD_PLANT_SHORTCUT;
		this.details = Messages.COMMAND_ADD_PLANT_DETAILS;
		this.help = Messages.COMMAND_ADD_PLANT_HELP;
	}
	
	private AddPlantCommand(String pN, int c, int r) {
		// llamamos primero a la constructora sin parámetros para inicializar los atributos de Command
		this();
		this.plantName = pN;
		this.col = c;
		this.row = r;
	}
	
	
	@Override
	public Command create(String[] c) {
		// Si no tiene cuatro elementos la cadena de caracteres entonces no es AddPlantCommand
		if (c.length != 4) {
			return null;
		}
		
		// guardamos el nombre de la planta a añadir
		String pN = c[1];
		
		// leemos la columna y la fila desde la cadena de caracteres
		Scanner colScanner = new Scanner(c[2]);
		Scanner rowScanner = new Scanner(c[3]);
		
		// comprobamos que ambas son números
		if (!colScanner.hasNextInt() || rowScanner.hasNextInt()) {
			colScanner.close();
			rowScanner.close();
			return null;
		}
		
		// creamos variables de tipo int que almacenan los valores de columna y fila leídos en String[] c
		int new_col = colScanner.nextInt();
		int new_row = rowScanner.nextInt();
		
		colScanner.close();
		rowScanner.close();
		
		return new AddPlantCommand(pN, new_col, new_row);
		
	}
	
	@Override
	public void execute(GameModel gm, GameView gv) {
		//...
	}
}
