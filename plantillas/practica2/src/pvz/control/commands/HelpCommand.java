package pvz.control.commands;

import java.util.ArrayList;
import java.util.List;
import pvz.logic.GameModel; 
import pvz.view.GameView; 
import pvz.view.Messages;

public class HelpCommand extends Command {
	
	public HelpCommand() {
		super (
			Messages.COMMAND_HELP_NAME,
			Messages.COMMAND_HELP_SHORTCUT,
			Messages.COMMAND_HELP_DETAILS,
			Messages.COMMAND_HELP_HELP
		);
	  }
	
	@Override
	public void execute(GameModel gm, GameView gv) { 
		List<String> lines = new ArrayList<>();//creo la lista vacía para guardar las líneas de ayuda
        lines.add(Messages.HELP_AVAILABLE_COMMANDS);//añade la primera línea. 'título'
        // Recorremos los comandos para construir la ayuda dinámica
        for (int i = 0; i < AVAILABLE_COMMANDS.size(); i++) {
        	Command command = AVAILABLE_COMMANDS.get(i);
        	//construye el texto descriptivo con +
            String line = command.getDetails() + Messages.HELP_DETAILS_COMMAND_HELP_SEPARATOR + command.getHelp();
            //guarda la línea construida en lines
            lines.add(line);
        }
        gv.showMessage(String.join(Messages.LINE_SEPARATOR, lines));//une todas las lineas creadas y las manda a gv que las muestra
	}

}
