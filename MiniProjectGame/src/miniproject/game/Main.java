package miniproject.game;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import miniproject.moveableobjects.Player;
import miniproject.gameloop.GameLoop;
import miniproject.system.GameWindow;
import miniproject.system.SpriteSheet;

public class Main {
	
	static SpriteSheet image = new SpriteSheet();
	public static int width = 1200;
	public static int height = 720;

	public static void main(String[] args) {
		GameWindow frame = new GameWindow("MiniProject v1.0", width, height);
		frame.addKeyListener(new Player());
		frame.add(new GameLoop(width, height));
		frame.setVisible(true);
	}

}
