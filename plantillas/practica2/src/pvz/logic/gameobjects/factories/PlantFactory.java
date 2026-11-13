package pvz.logic.gameobjects.factories;

import java.util.Arrays;

import java.util.Collections;
import java.util.List;
import pvz.logic.GameWorld;
import pvz.logic.gameobjects.*;

import utils.Position;

public class PlantFactory {
	//lista con una plantilla de cada planta disponible en el juego
	private static final List<Plant> AVAILABLE_PLANTS = Arrays.asList(
		new Sunflower(), //primer param=tablero, segundo=posición. paso null pq list no necesita esa info
	    new Peashooter(),
	    new CherryBomb(),
	    new WallNut()
	);
	
	//crea y devuelve nueva instancia de la planta segun el nombre de planta que escribe el jugador
	public static Plant spawnPlant(String plantName, GameWorld game, Position position) {
		boolean found = false;
		int pos = 0;
		Plant p = null;
		
		while (!found && pos < AVAILABLE_PLANTS.size()) {
			p = AVAILABLE_PLANTS.get(pos);
			if (p.getName().equalsIgnoreCase(plantName) || p.getSymbol().equalsIgnoreCase(plantName)) {
				found = true;
			}
			pos++;
		}
		
		if(!found) {
			p = null;
		}
		else {
			p = p.copy(position, game);
		}
		
		return p;
	}
	
	//devuelve la lista no modificable de las plantas disponibles . lo usa listplantscommans
	public static List<Plant> getAvailablePlants() {
		return Collections.unmodifiableList(AVAILABLE_PLANTS);
	}
	
	
	
	public static boolean validPlantName(String plantName) {
		if (plantName == null) return false;
		Plant plant = null;
		int pos = 0;
		boolean found = false;
		while (!found && pos < AVAILABLE_PLANTS.size()) {
			plant = AVAILABLE_PLANTS.get(pos);
			if (plant.getName().equalsIgnoreCase(plantName) || plant.getSymbol().equalsIgnoreCase(plantName)) {
				found = true;;
			}
			pos++;
		}
		return found;
	}
	

}
