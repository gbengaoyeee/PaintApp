package ca.utoronto.utm.paint;

import java.awt.Color;

public class Point extends Shapes {
	private int x, y;
	private boolean draw;

	Point(Color color, int thickness, int x, int y) {
		super(color, thickness, x, y);
		this.x = x;
		this.y = y;
		this.draw = true;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setDraw(boolean g) {
		this.draw = g;
	}

	public boolean getDraw() {
		return this.draw;
	}

}
