package miniproject.MoveableObjects;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import miniproject.game.Main;
import miniproject.gameloop.GameLoop;
import miniproject.system.Vector2F;

public class Player implements KeyListener {
	
	Vector2F pos;
	private int width = 42;
	private int height = 42;
	private static boolean up, down, left, right;
	
	private float maxSpeed = 3F;
	private float slowDown = .095F;
	
	private float speedUp = 0;
	private float speedDown = 0;
	private float speedRight = 0;
	private float speedLeft = 0;
	
	private float fixDt = 47f/60F;
	
	private boolean mapMove = false;
	
	public Player() {// put player in middle of screen
		pos = new Vector2F(Main.width / 2 - width / 2, Main.height / 2 - height / 2);
	}

	public void init() {
		
	}

	public void tick(double deltaTime) {
		
		float moveAmountU = (float)(speedUp * fixDt);
		float moveAmountD = (float)(speedDown * fixDt);
		float moveAmountR = (float)(speedRight * fixDt);
		float moveAmountL = (float)(speedLeft * fixDt);
		
		if(!mapMove) {
			
			if(up) {
				
				if(speedUp < maxSpeed) {
					speedUp += slowDown;
					} else { speedUp = maxSpeed; }
				
				pos.yPos-=moveAmountU;
				
			} else {
				if(speedUp != 0) {
					speedUp -= slowDown;
						if(speedUp <0) { 
							speedUp = 0; }
					}
				
				pos.yPos-=moveAmountU;
			}
			
			
			if(down) {
				
				if(speedDown < maxSpeed) {
					speedDown += slowDown;
					} else { speedDown = maxSpeed; }
				
				pos.yPos+=moveAmountD;
				
			} else {
				if(speedDown != 0) {
					speedDown -= slowDown;
						if(speedDown <0) { 
							speedDown = 0; }
					}
				
				pos.yPos+=moveAmountD;
			}
			
			
			if(right) {
				
				if(speedRight < maxSpeed) {
					speedRight += slowDown;
					} else { speedRight = maxSpeed; }
				
				pos.xPos+=moveAmountR;
				
			} else {
				if(speedRight != 0) {
					speedRight -= slowDown;
						if(speedRight <0) { 
							speedRight = 0; }
					}
				
				pos.xPos+=moveAmountR;
			}
			
			
			if(left) {
				
				if(speedLeft < maxSpeed) {
					speedLeft += slowDown;
					} else { speedLeft = maxSpeed; }
				
				pos.xPos-=moveAmountL;
				
			} else {
				if(speedLeft != 0) {
					speedLeft -= slowDown;
						if(speedLeft <0) { 
							speedLeft = 0; }
					}
				
				pos.xPos-=moveAmountL;
			}
		
		/* IF MAPMOVE IS TRUE */
			
		} else {
			
			if(up) {
				
				if(speedUp < maxSpeed) {
					speedUp += slowDown;
					} else { speedUp = maxSpeed; }
				
				GameLoop.map.yPos-=moveAmountU;
				
			} else {
				if(speedUp != 0) {
					speedUp -= slowDown;
						if(speedUp <0) { 
							speedUp = 0; }
					}
				
				GameLoop.map.yPos-=moveAmountU;
			}
			
			
			if(down) {
				
				if(speedDown < maxSpeed) {
					speedDown += slowDown;
					} else { speedDown = maxSpeed; }
				
				GameLoop.map.yPos+=moveAmountD;
				
			} else {
				if(speedDown != 0) {
					speedDown -= slowDown;
						if(speedDown <0) { 
							speedDown = 0; }
					}
				
				GameLoop.map.yPos+=moveAmountD;
			}
			
			
			if(right) {
				
				if(speedRight < maxSpeed) {
					speedRight += slowDown;
					} else { speedRight = maxSpeed; }
				
				GameLoop.map.xPos+=moveAmountR;
				
			} else {
				if(speedRight != 0) {
					speedRight -= slowDown;
						if(speedRight <0) { 
							speedRight = 0; }
					}
				
				GameLoop.map.xPos+=moveAmountR;
			}
			
			
			if(left) {
				
				if(speedLeft < maxSpeed) {
					speedLeft += slowDown;
					} else { speedLeft = maxSpeed; }
				
				GameLoop.map.xPos-=moveAmountL;
				
			} else {
				if(speedLeft != 0) {
					speedLeft -= slowDown;
						if(speedLeft <0) { 
							speedLeft = 0; }
					}
			}
			
				GameLoop.map.xPos-=moveAmountL;
		}
		
	}

	public void render(Graphics2D g) {
		g.fillRect((int)pos.xPos, (int)pos.yPos, width, height);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_W) {
			up = true;
		}
		if(key == KeyEvent.VK_S) {
			down = true;
		}
		if(key == KeyEvent.VK_D) {
			right = true;
		}
		if(key == KeyEvent.VK_A) {
			left = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_W) {
			up = false;
		}
		if(key == KeyEvent.VK_S) {
			down = false;
		}
		if(key == KeyEvent.VK_D) {
			right = false;
		}
		if(key == KeyEvent.VK_A) {
			left = false;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
