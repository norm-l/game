package miniproject.gamestates;

import java.awt.Graphics2D;

import miniproject.game.Main;
import miniproject.gamestate.GameState;
import miniproject.gamestate.GameStateManager;
import miniproject.generator.Map;
import miniproject.system.SpriteSheet;
import miniproject.system.loadImageFrom;

public class GameLevelLoader extends GameState{
	
	Map map;

	public GameLevelLoader(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		map = new Map();
		map.init();
	}

	@Override
	public void tick(double deltaTime) {
		map.tick(deltaTime);
	}

	@Override
	public void render(Graphics2D g) {
		map.render(g);
	}

}
