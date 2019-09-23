
package ca.utoronto.utm.paint;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
 
/**
* A Shape is a Subject (so can be observed)
* it has a position and a color (all of which can be modified).
*/

public abstract class Shapes extends Observable  {

	private int x,y; // position of the shape
	private Color color;
	private int thickness;
	
	/**
	 * Initialize a new Shape with specified Color and position
	 *
	 * @param c
	 *            the desired color
	 * @param x
	 *            the desired x coordinate
	 * @param y
	 *            the desired x coordinate
	 */
	public Shapes(Color c,int thickness, int x, int y){
		this.color = c;
		this.thickness = thickness;
		this.x = x;
		this.y = y;
		setPosition(this.x,this.y);
		setColor(this.color);
		setThickness(this.thickness);
	} 

	/**
	* Set the position of this and then notify our observers
	*
	* @param x the new x coordinate
	* @param y the new x coordinate
	*/
	public void setPosition(int x, int y){
		this.x=x; this.y=y;
		notifyObservers();
	}

	/**
	* Set the x coordinate of this and notify our observers
	*
	* @param x the new x coordinate
	*/
	public void setX(int x){ setPosition(x,this.y); }

	/**
	* Set the y coordinate of this and notify our observers
	*
	* @param y the new y coordinate
	*/
	public void setY(int y){ setPosition(this.x,y); }

	/**
	* Set the Color of this and notify our observers
	*
	* @param c the new Color
	*/
	public void setColor(Color c){
		this.color=c;
		notifyObservers();
	}
	
	/**
	* Set the thickness of this and notify our observers
	*
	* @param thickness the new stroke thickness
	*/
	public void setThickness(int thickness){
		this.thickness=thickness;
		notifyObservers();
	}
	public int getThickness(){
		return this.thickness;
	}

	/**
	* @return the x coordinate of this
	*/
	public int getX(){ return this.x; }

	/**
	* @return the y coordinate of this
	*/
	public int getY(){ return this.y; }

	/**
	* @return the Color of this
	*/
	public Color getColor(){ return this.color; }
	
//	/**
//	* @return the thickness of this
//	*/
//	public int getThickness(){ return this.thickness; }

	/**
	* @return a String representation of this
	*/
	public String toString(){
		String s="Color:"+this.color+" ("+x+","+y+")";

		return(s);
	}

	/**
	* display this using the given pen
	*
	* @param g the pen we use to display this
	*/
	public void display(Graphics g){
		g.setColor(this.color);
	}
}


