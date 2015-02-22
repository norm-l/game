package miniproject.gamestate;

import java.awt.Graphics2D;
import java.util.Stack;

import miniproject.gamestates.GameLevelLoader;

public class GameStateManager {
	
	public static Stack<GameState> states; // push on top of stacks

	public GameStateManager() {
		states = new Stack<GameState>();
		states.push(new GameLevelLoader(this));
	}
	
	public void tick(double deltaTime) {
		states.peek().tick(deltaTime);
	}
	
	public void render(Graphics2D g) {
		states.peek().render(g);
	}

	public void init() {
		states.peek().init();
	}

}
