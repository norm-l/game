package miniproject.game;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import miniproject.MoveableObjects.Player;
import miniproject.gameloop.GameLoop;
import miniproject.system.GameWindow;
import miniproject.system.SpriteSheet;

public class Main {
	
	static SpriteSheet image = new SpriteSheet();
	public static GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	public static int width = gd.getDisplayMode().getWidth();
	public static int height = gd.getDisplayMode().getHeight();

	public static void main(String[] args) {
		GameWindow frame = new GameWindow("MiniProject v1.0", 1920, 1080);
		frame.addKeyListener(new Player());
		frame.add(new GameLoop(1920, 1080));
		frame.setVisible(true);
	}

}
