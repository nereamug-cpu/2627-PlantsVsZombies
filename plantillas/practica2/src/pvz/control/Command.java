package pvz.control;
import java.util.List;
import java.util.Arrays;

public abstract class Command {

	  protected static final List<Command> AVAILABLE_COMMANDS = Arrays.asList(
	      new AddPlantCommand(),
	      new AddZombieCommand(),
	      new ListPlantsCommand(),
	      new ListZombiesCommand(),
	      new ResetCommand(),
	      new HelpCommand(),
	      new ExitCommand(),
	      new CheatPlantCommand(),
	      new CatchCommand()
	      //...
	  );
	  
	  //...
	  protected String name = "";
	  protected String shortcut = "";
	  protected String details = "";
	  protected String help = "";
	  //...


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

	  public boolean matchCommand(String c) {
		  return getName().equalsIgnoreCase(c) || getShortcut().equalsIgnoreCase(c);
	  }
	  
	  public abstract Command create(String[] c);
	  
	  public abstract void execute(GameModel gm, GameView gv);
	  
	  
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
