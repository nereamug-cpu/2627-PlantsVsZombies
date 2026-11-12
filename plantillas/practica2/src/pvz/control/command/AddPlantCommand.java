package pvz.control.command;
//import java.util.Scanner;//está Integer.parseInt()
import pvz.logic.GameModel; 
import pvz.view.GameView; 
import pvz.view.Messages;
import utils.Position;

public class AddPlantCommand extends Command{//extends por la herencia de la superclase
	private String plantName;
	private int col;
	private int row;
	
	//constructora sin parámetros . se usa para registrarlo en AVAILABlE_COMANDS
	public AddPlantCommand() {
		super (//invoca a la constructora de Command (superclase)
				Messages.COMMAND_ADD_PLANT_NAME,
				Messages.COMMAND_ADD_PLANT_SHORTCUT,
				Messages.COMMAND_ADD_PLANT_DETAILS,
				Messages.COMMAND_ADD_PLANT_HELP
		);
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
	//pq enunciado: *En el caso de que los argumentos introducidos por el usuario no sean válidos para el comando, 
	//el método* *create(String[])* *devolverá un comando con un mensaje de error*

	@Override //pq sobreescribimos el método create heredado de Command
	public Command create(String[] c) { 
		Command create = null;
		// Si c no tiene cuatro elementos 
		if (c.length == 4 && c != null) { //me acabo de acordar, era solo un return por método, no?
			String plantName = c[1];
			//try-catch para convertir texto de col, row a enteros
			//en try código que puede fallar, en catch(tipo de error) solución al error
			try {
				int col = Integer.parseInt(c[2]);
				int row = Integer.parseInt(c[3]);
				create = new AddPlantCommand(plantName, col, row);
			} catch (NumberFormatException e) {
				create = null;
			}
		}		
		return create;
	}
	
	@Override
	public void execute(GameModel gm, GameView gv) {
		Position pos = new Position(row, col);
		//si los parámetros están mal escritos
		if (!gm.checkGameObject(this.plantName)) gv.showError(Messages.INVALID_GAME_OBJECT);
		//casilla mal
		else if (!gm.isInsideBoard(pos) || !gm.isEmpty(pos)) gv.showError(Messages.INVALID_POSITION);
		else {
			if (gm.addGameObject(this.plantName, pos)) {
                gm.update();
                gv.showGame();
            } else  gv.showError(Messages.NOT_ENOUGH_COINS);
		}	
	}
}