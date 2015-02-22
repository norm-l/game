package miniproject.generator;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import miniproject.moveableobjects.Player;
import miniproject.game.Main;
import miniproject.generator.Block.BlockType;
import miniproject.system.Vector2F;
import miniproject.system.loadImageFrom;

public class Map {
	
	TileManager tiles = new TileManager();
	Player player = new Player(); //create the player

	public Map() {
		
	}
	
	public void init() {
		player.init(); //initialise the player
		BufferedImage map = null;
		
		try {
			map = loadImageFrom.LoadImageFrom(Main.class, "map.png");
		}catch(Exception e) {
			
		}
		
		for(int x = 0; x < 100; x++) {
			for(int y = 0; y < 100; y++) {
				
				int col = map.getRGB(x, y);
				
				switch(col & 0xFFFFFF) {
				case 0x808080:
						tiles.blocks.add(new Block(new Vector2F(x*48, y*48), BlockType.STONE_1));
					break;
				}
			}
			
		}
	}
	
	public void tick(double deltaTime) {
		tiles.tick(deltaTime);
		player.tick(deltaTime); //tick the player
	}
	
	public void render(Graphics2D g) {
		tiles.render(g);
		player.render(g); //render the player
	}

}
