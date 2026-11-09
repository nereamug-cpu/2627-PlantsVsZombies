package pvz.control.commands;

import java.util.Arrays;
import java.util.List;
import pvz.logic.GameModel;
import pvz.view.GameView;//printer y messages le dan igual, no?

public abstract class Command {
	
	//tienen la info de cada comando
	protected final String name;
	protected final String shortcut;
	protected final String details;
	protected final String help;

	protected static final List<Command> AVAILABLE_COMMANDS = Arrays.asList(
	    new AddPlantCommand(),
	    //new AddZombieCommand(), comentos los de la 2.2 por si falla en las pruebas
	    new ListPlantsCommand(),
	    //new ListZombiesCommand(),
	    new ResetCommand(),
	    new HelpCommand(),
	    new ExitCommand(),
	    new NoneCommand()
	    //new CheatPlantCommand(),
	    //new CatchCommand()
	  );
	  
	  //constructora
	  public Command(String name, String shortcut, String details, String help) { 
		  this.name = name; 
		  this.shortcut = shortcut; 
		  this.details = details; 
		  this.help = help; 
	  }
	  
	  public static Command parse(String[] commandWords) { 
		boolean ok = false;
	    int pos = 0;
	    while (!ok && pos < AVAILABLE_COMMANDS.size()) {
	    	Command command = AVAILABLE_COMMANDS.get(pos);
	    	if (command.matchCommand(commandWords[0])) {
	    		ok = true;
	    	}
	    	else {
	    		pos++;
	    	}
	    }
	    if (ok) {
	    	return AVAILABLE_COMMANDS.get(pos).create(commandWords);
	    }
	    else {
	    	return null;
	    }
	  }

	  
	  //prpuesta parse() más corto comprobando entrada nula:
	  public static Command parse(String[] commandWords) {//analiza la entrada del player y vdevuelve el comando correspondiente		
		  Command com = null;
		  if (commandWords == null || commandWords.length == 0 || commandWords[0].isEmpty())  
			  com = new NoneCommand();//por si entrada vacía o nula (enter por ej)
		  else {
			  int i = 0;
			  while (com == null && i < AVAILABLE_COMMANDS.size()) {
				  Command command = AVAILABLE_COMMANDS.get(i);
				//si la primera palabra (commandWords[0])coincide con el nombre del comando i:
				  if (command.matchCommand(commandWords[0])) com = command.create(commandWords); //com == null es falsa y para el bucle
				  i++;
			  }
		  }
		  return  com;//devuelve null si recorre la lista y no encuentra coincidencia
	  }
	  
	  
	  public boolean matchCommand(String c) {//comprueba si la palabra introdcida coincide con el name o shortcut del comando
		  return name.equalsIgnoreCase(c) || shortcut.equalsIgnoreCase(c);//no hacen falta getters, no?
	  }
	  
	  public Command create(String[] words) {//para no tener que implementar create en todos los comandos, no?
		  return this;
	  }
	  
	  public abstract void execute(GameModel gm, GameView gv);//ejecuta la acción del comando
	  
	  
	  protected String getName() {
		  return name;
	  }
	  
	  protected String getShortcut() {
		  return shortcut;
	  }
	  
	  public String getDetails() {
		  return details;
	  }
	  
	  public String getHelp() {
		  return help;
	  }
}
