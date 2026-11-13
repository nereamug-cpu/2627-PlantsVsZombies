package pvz.control.command;


import java.util.List;
import pvz.logic.GameModel;
import pvz.view.GameView; 
import pvz.view.Messages;
import pvz.logic.gameobjects.Plant;
import pvz.logic.gameobjects.factories.PlantFactory;

public class ListPlantsCommand extends Command{
	
	public ListPlantsCommand() {
		super (//invoca a la constructora de Command (superclase)
			Messages.COMMAND_LIST_PLANTS_NAME,
			Messages.COMMAND_LIST_PLANTS_SHORTCUT,
			Messages.COMMAND_LIST_PLANTS_DETAILS,
			Messages.COMMAND_LIST_PLANTS_HELP
		);
	}
	
	@Override
	public Command create(String[] c) {
		// comprobamos que la cadena String[] c no tenga más que un elemento, el propio comando
		if (c.length != 1) {
			return null;
		}
		return this;
	}

	@Override
	public void execute(GameModel gm, GameView gv) {//muestra descripción de las plantas pero no avanza ciclo
		List<Plant> plants = PlantFactory.getAvailablePlants();
		
		String plantDescriptions = "";
		
		for (int i = 0; i < plants.size(); i++) {
			if (!plantDescriptions.isEmpty()) {
				plantDescriptions += Messages.LINE_SEPARATOR;
			}
			
			plantDescriptions += plants.get(i).getDescription();
		}
		
		gv.showMessage(plantDescriptions);
		
		/*
		List<String> plantDescriptions = new ArrayList<>();
		List<Plant> plants = PlantFactory.getAvailablePlants();
		
		for (int i = 0; i < plants.size(); i++) {
			String description = plants.get(i).getDescription();
			plantDescriptions.add(description);
		}
		
		gv.showMessage(String.join(Messages.LINE_SEPARATOR, plantDescriptions));
		
		
		List<String> plantsDescription = new ArrayList<>();
 
        // Obtenemos las descripciones de las plantas registradas en la factoría
        for (Plant plant : PlantFactory.getAvailablePlants()) {
            plantsDescription.add(plant.getDescription());
        }
        
        // Muestra la lista formateada
        gv.showMessage(String.join(Messages.LINE_SEPARATOR, plantsDescription));
    	*/
    }	
	
}

