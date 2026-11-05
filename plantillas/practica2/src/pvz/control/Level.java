package pvz.control;

public enum Level {
	
	//valores fijos del enumerado (tipos de niveles)
	EASY(3, 0.1),
	HARD(5, 0.2),
	INSANE(10, 0.3);
	
	//PRIVADAS

		private int numberOfZombies;
		
		private double zombieFrequency;
		
		//CONSTRUCTORA

		private Level(int numberOfZombies, double zombieFrequency) {
			this.numberOfZombies = numberOfZombies;
			this.zombieFrequency = zombieFrequency;
		}
	
	
	public static Level valueOfIgnoreCase(String inputString) {
		for (Level level : Level.values()) {
			if (level.name().equalsIgnoreCase(inputString)) {
				return level;
			}
		}
		return null;
	}
	
	public static String all(String separator) {
		StringBuilder buffer = new StringBuilder();
		int levelCount = 0;
		for (Level level : Level.values()) {
			if (levelCount > 0) {
				buffer.append(separator);
			}
			buffer.append(level.name());
			levelCount++;
		}
		return buffer.toString();
	}

}
