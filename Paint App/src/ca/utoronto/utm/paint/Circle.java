package ca.utoronto.utm.paint;

import java.awt.Color;

public class Circle extends Shapes {
	private Point centre;
	private int radius;

	public Circle(Color tempColor, int thickness, Point centre, int radius) {
		super(tempColor, thickness, centre.getX(), centre.getY());

		this.centre = centre;
		this.radius = radius;
	}

	public Point getCentre() {
		return centre;
	}

	public void setCentre(Point centre) {
		this.centre = centre;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

}
