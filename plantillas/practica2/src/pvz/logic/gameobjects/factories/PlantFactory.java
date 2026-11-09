package pvz.logic.gameobjects.factories;

import java.util.Arrays;
import pvz.logic.*;
import pvz.utils.*;
import pvz.logic.gameobjects.*;
import java.util.List;

import java.util.Collections;

public class PlantFactory {
	private static final List<Plant> AVAILABLE_PLANTS = Arrays.asList(
		/*
		new Sunflower(),
		new Peashooter(),
		new CherryBomb(),
		new WallNut()
		*/
	);
	
	public static Plant spawnPlant(String plantName, GameWorld game, Position position) {
		boolean found = false;
		int pos = 0;
		Plant p = null;
		
		while (!found && pos < AVAILABLE_PLANTS.size()) {
			p = AVAILABLE_PLANTS.get(pos);
			if (p.verifyName(plantName)) {
				found = true;
			}
			else {
				pos++;
			}
		}
		
		return p.add(game, position);
	}
	
	public static List<Plant> getAvailablePlants() {
		return Collections.unmodifiableList(AVAILABLE_PLANTS);
	}
	
	// ...
}
