package pvz.logic;

public interface GameModel {
	void reset();
	void update();
	void quit();
	public void generateCoins(int amount);
	//...
}
