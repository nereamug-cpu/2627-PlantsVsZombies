package pvz.logic.gameobjects.factories;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class PlantFactory {
	private static final List<Plant> AVAILABLE_PLANTS = Arrays.asList(
		// ...
	);
	
	public static Plant spawnPlant(String plantname, GameWorld game, Position position) {
		// ...
	}
	
	public static List<Plant> getAvailablePlants() {
		return Collections.unmodificableList(AVAILABLE_PLANTS);
	}
	
	// ...
}
