package miniproject.system;

//Vector tutorial for future reference: http://www.mathsisfun.com/algebra/vectors.html

public class Vector2F {
	
	public float xPos;
	public float yPos;
	
	public static float worldxPos;
	public static float worldyPos;

	public Vector2F() {
		this.xPos = 0.0f;
		this.yPos = 0.0f;
	}
	
	public Vector2F(float xPos, float yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public static Vector2F zero() { // setting to 0
		return new Vector2F(0,0);
	}
	
	public void normalize() { // normalising vector
		double length = Math.sqrt(xPos * xPos + yPos * yPos);
		
		if(length != 0.0) {
			float s = 1.0f / (float)length;
			xPos = xPos * s;
			yPos = yPos * s;
		}
	}
	
	public boolean equals(Vector2F v) { // check if they are the same
		return (this.xPos == v.xPos && this.yPos == v.yPos);
	}
	
	public Vector2F copy(Vector2F v) { // copy
		xPos = v.xPos;
		yPos = v.yPos;
		return new Vector2F(xPos, yPos);
	}
	
	public Vector2F add(Vector2F v) { // adding a vector
		xPos = xPos + v.xPos;
		yPos = yPos + v.yPos;
		return new Vector2F(xPos, yPos);
	}
	
	public Vector2F getScreenLocation() { // getter for screen location
		return new Vector2F(xPos, yPos);
	}
	
	public Vector2F getWorldLocation() { // getter for world location
		return new Vector2F(xPos, yPos);
	}
	
	public static void setWorldVariables(float wX, float wY) { // setting world variables
		worldxPos = wX;
		worldyPos = wY;
	}
	
	public static double getDistanceOnScreen(Vector2F v1, Vector2F v2) { // on screen not in world
		float vector1 = v1.xPos - v2.xPos;
		float vector2 = v2.yPos - v2.yPos;
		return Math.sqrt(vector1 * vector1 + vector2 * vector2);
	}
	
	public double getDistanceBetweenWorldVectors(Vector2F v) { // get distance in the world location
		float dX = Math.abs(getWorldLocation().xPos - v.getWorldLocation().xPos);
		float dY = Math.abs(getWorldLocation().yPos - v.getWorldLocation().yPos);
		return Math.abs(dX * dX - dY * dY);
	}

}
