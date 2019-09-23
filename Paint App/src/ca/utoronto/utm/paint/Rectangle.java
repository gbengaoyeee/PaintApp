package ca.utoronto.utm.paint;

import java.awt.Color;

public class Rectangle extends Shapes {
	private int width, height, x, y;

	public Rectangle(Color color, int thickness, int x, int y, int width, int height) {
		super(color, thickness, x, y);
		this.width = width;
		this.height = height;
	}

	public int getXnum() {
		return this.x;
	}

	public int getYnum() {
		return this.y;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public void setXnum(int x) {
		this.x = x;
	}

	public void setYnum(int y) {
		this.y = y;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;

	}
}
