package miniproject.system;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class MPGameLoop extends JPanel implements Runnable{
	
	private Thread thread; // the loop
	private boolean running; // is it running?
	
	private int fps;
	private int tps;
	
	private int width;
	private int height;
	
	public Graphics2D graphics2D;
	private BufferedImage img;
	
	public static double currentFPS = 120D;

	public MPGameLoop(int width, int height) {
		this.width = width;
		this.height = height;
		
		setPreferredSize(new Dimension(width, height));
		setFocusable(false);
		requestFocus();
	}
	
	@Override
	public void addNotify() {
		super.addNotify();
		
		if(thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	@Override
	public void run() {
		
		/*INIT*/
		init(); // Initialise objects
		
		long lastTime = System.nanoTime(); // returns time in most precise format of nanoseconds
		double nsPerTick = 1000000000D / currentFPS;
		int frames = 0;
		int ticks = 0;
		long lastTimer = System.currentTimeMillis(); // returns current time in milliseconds
		double deltaTime = 0; // speed up the game if it's slow
		
		while(running) {
			long now = System.nanoTime();
			deltaTime += (now - lastTime) / nsPerTick;
			lastTime = now;
			boolean shouldRender = false;
			
			while(deltaTime >= 1) {
				ticks++;
				tick(deltaTime); // update the game with this
				deltaTime -= 1;
				shouldRender = true;
			}
			
			if(shouldRender == true) {
				frames++;
				render(); // render everything that is drawn
			}
			
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer += 1000;
				tps = frames;
				fps = ticks;
				frames = 0;
				ticks = 0;
			}
		}
	}
	
	public void init() {
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		graphics2D = (Graphics2D) img.getGraphics();
		running = true;
	}
	public void tick(double deltaTime) {
		
	}
	public void render() {
		graphics2D.clearRect(0, 0, width, height);
	}
	
	public void clear() {
		Graphics g2 = getGraphics();
		if(img != null) {
			g2.drawImage(img, 0, 0, null);
		}
		g2.dispose();
	}

}
