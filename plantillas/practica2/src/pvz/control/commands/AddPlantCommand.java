package pvz.control.commands;
//import java.util.Scanner;//no lo recomienda pq está Integer.parseInt()
import pvz.logic.GameModel; 
import pvz.view.GameView; 
import pvz.view.Messages; 
import pvz.utils.Position;

public class AddPlantCommand extends Command{//extends por la herencia de la superclase
	private String plantName;
	private int col;
	private int row;
	private boolean errorParams;//si hay error de parámetros
	
	//constructora sin parámetros . se usa para registrarlo en AVAILABlE_COMANDS
	public AddPlantCommand() {
		super (//invoca a la constructora de Command (superclase)
				Messages.COMMAND_ADD_PLANT_NAME,
				Messages.COMMAND_ADD_PLANT_SHORTCUT,
				Messages.COMMAND_ADD_PLANT_DETAILS,
				Messages.COMMAND_ADD_PLANT_HELP
		);
		this.errorParams = false;
	}
	
	//constructora con parámetros
	private AddPlantCommand(String pN, int c, int r) {
		// llamamos primero a la constructora sin parámetros para inicializar los atributos de Command
		this();
		this.plantName = pN;
		this.col = c;
		this.row = r;
	}
	
	//propuesta create sin scanner. 
	//enunciado: *En el caso de que los argumentos introducidos por el usuario no sean válidos para el comando, 
	//el método* *create(String[])* *devolverá un comando con un mensaje de error*
	//Además, create no puede devolver null (parse del Controller tb devolvería null)->unknown command

	@Override //pq sobreescribimos el método create heredado de Command
	public Command create(String[] c) {
		// Si no tiene cuatro elementos la cadena de caracteres entonces no es AddPlantCommand
		if (c.length != 4) {  
			AddPlantCommand cmdError = new AddPlantCommand(); // Marca la bandera de error a true para recordarlo durante la ejecucion 
			cmdError.errorParams = true; // Devuelve la instancia con el fallo marcado 
			return cmdError; 
		}
		//try-catch para convertir texto de col, row a enteros
		//en try código que puede fallar, en catch(tipo de error) solución al error
		try {
			String plantName = c[1];
			int col = Integer.parseInt(c[2]);
			int row = Integer.parseInt(c[3]);
			return new AddPlantCommand(plantName, col, row);
		} catch (NumberFormatException e){//esto de dónde sale exactamente? SEGUIR POR AQUÍ.
			AddPlantCommand cmdError = new AddPlantCommand();
			cmdError.errorParams = true;
			return cmdError;
		}
	
	}
	
	/*ANTERIOR:
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
	*/
	
	@Override
	public void execute(GameModel gm, GameView gv) {
		//...
	}
}
