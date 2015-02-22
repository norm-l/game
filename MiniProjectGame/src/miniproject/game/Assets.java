package miniproject.game;

import java.awt.image.BufferedImage;

import miniproject.system.SpriteSheet;
import miniproject.system.loadImageFrom;

public class Assets {
	
	SpriteSheet blocks = new SpriteSheet();
	
	public static BufferedImage stone_1;
	
	public void init() {
		blocks.setSpriteSheet(loadImageFrom.LoadImageFrom(Main.class, "spritesheet.png"));
		
		stone_1 = blocks.getTile(0, 0, 16, 16); //tile 0 0, 16x16
	}
	
	public static BufferedImage getStone_1() {
		return stone_1;
	}

}
