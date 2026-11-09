package pvz.logic.gameobjects.factories;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import pvz.logic.GameWorld;
import pvz.logic.gameobjects.Peashooter;
import pvz.logic.gameobjects.Plant;
import pvz.logic.gameobjects.Sunflower;
import pvz.utils.Position;

public class PlantFactory {
	//lista con una plantilla de cada planta disponible en el juego
	private static final List<Plant> AVAILABLE_PLANTS = Arrays.asList(
		new Sunflower(null, null), //primer param=tablero, segundo=posición. paso null pq list no necesita esa info
	    new Peashooter(null, null)
	);
	
	//crea y devuelve nueva instancia de la planta segun el nombre de planta que escribe el jugador
	public static Plant spawnPlant(String plantName, GameWorld game, Position position) {
		Plant plant = null;
        if (plantName != null) {
            if (plantName.equalsIgnoreCase("sunflower") || plantName.equalsIgnoreCase("s"))
            	plant = new Sunflower(game, position);
            else if (plantName.equalsIgnoreCase("peashooter") || plantName.equalsIgnoreCase("p"))
            	plant = new Peashooter(game, position);
        }
        return plant;
	}
	
	//devuelve la lista no modificable de las plantas disponibles . lo usa listplantscommans
	public static List<Plant> getAvailablePlants() {
		return Collections.unmodifiableList(AVAILABLE_PLANTS);
	}

}
