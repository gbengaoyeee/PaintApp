package ca.utoronto.utm.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/

class PaintPanel extends JPanel implements Observer, MouseMotionListener, MouseListener {
	private int i = 0;
	private PaintModel model; // slight departure from MVC, because of the way
								// painting works
	private View view; // So we can talk to our parent or other components of
						// the view
	private Point prevPoint, currenPoint;
	private Color currentColor; // set the color to dram
	private int strokeThickness;


	private String mode; // modifies how we interpret input (could be better?)

	private Circle circle; // the circle we are building
	private Square square;
	private Rectangle rectangle;

	public PaintPanel(PaintModel model, View view) {


		this.setBackground(Color.blue);
		this.setPreferredSize(new Dimension(300, 300));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
<<<<<<< HEAD



		this.mode="Squiggle"; // bad code here?


		
		this.mode="Circle"; // bad code here? no
		this.mode="Rectangle";
		this.mode="Square";
		this.mode="Polyline";
		
=======

		this.mode = "Circle"; // bad code here? no
>>>>>>> branch 'master' of https://cslinux.utm.utoronto.ca/git/repo_JustTryingToSurvive.git

		this.model = model;
		this.model.addObserver(this);
		this.currentColor = Color.white;
		this.strokeThickness = 1;
		this.view = view;


	}

	/**
	 * View aspect of this
	 */
	public void paintComponent(Graphics g) {
		// Use g to draw on the JPanel, lookup java.awt.Graphics in
		// the javadoc to see more of what this can do for you!!

		super.paintComponent(g); // paint background
		Graphics2D g2d = (Graphics2D) g; // lets use the advanced api
		// setBackground (Color.blue);
		// Origin is at the top left of the window 50 over, 75 down
		g2d.setColor(Color.white);

		g2d.drawString("i=" + i, 50, 75);
		i = i + 1;

		// Draw Lines
		ArrayList<Point> points = this.model.getPoints();
		for (int i = 0; i < points.size() - 1; i++) {
			if (points.get(i).getDraw()) {
				Point p1 = points.get(i);
				Point p2 = points.get(i + 1);
				g2d.setColor(this.currentColor);
				p1.display(g2d);
				g2d.setStroke(new BasicStroke(p1.getThickness()));
				g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
			}


		}

		// Draw Circles
		ArrayList<Circle> circles = this.model.getCircles();
		for (Circle c : this.model.getCircles()) {
			int radius = c.getRadius();
<<<<<<< HEAD

			g2d.drawOval(x+radius, y+radius, x-radius, x-radius);

			setLineStyle(mode, g2d);
=======
			int x = c.getCentre().getX() - (radius / 2);
			int y = c.getCentre().getY() - (radius / 2);
			c.display(g2d);
			g2d.setStroke(new BasicStroke(c.getThickness()));
>>>>>>> branch 'master' of https://cslinux.utm.utoronto.ca/git/repo_JustTryingToSurvive.git
			g2d.drawOval(x, y, radius, radius);

		}

		// Draw Rectangles
		ArrayList<Rectangle> rectangles = this.model.getRectangles();
		for (Rectangle r : this.model.getRectangles()) {
			int x = r.getXnum();
			int y = r.getYnum();
			int width = r.getWidth();
			int height = r.getHeight();
			r.display(g2d);
			g2d.setStroke(new BasicStroke(r.getThickness()));
			g2d.drawRect(x, y, width, height);

		}

		// Draw Squares
		ArrayList<Square> squares = this.model.getSquares();
		for (Square s : this.model.getSquares()) {
			int x = s.getXnum();
			int y = s.getYnum();
			int width = s.getWidth();
			int height = s.getWidth();
			g2d.setStroke(new BasicStroke(s.getThickness()));
			s.display(g2d);
			g2d.drawRect(x, y, width, width);

		}


		g2d.dispose();
	}

	@Override
	public void update(Observable o, Object arg) {
		// Not exactly how MVC works, but similar.
		this.repaint(); // Schedule a call to paintComponent
	}

	/**
	 * Controller aspect of this
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	// MouseMotionListener below
	@Override
	public void mouseMoved(MouseEvent e) {
		if (this.mode == "Squiggle") {

		} else if (this.mode == "Circle") {

		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
<<<<<<< HEAD
		if(this.mode=="Squiggle"){
			this.model.addPoint(new Point(e.getX(), e.getY()));


			
		} else if(this.mode=="Circle"){
			

			if(this.circle != null){
				int radius =e.getX()-this.circle.getCentre().getX();
				this.circle.setRadius(radius);
				this.model.addCircle(this.circle);
				repaint();
			}

		} else if (this.mode == "Rectangle"){ //code below doesnt allow you to draw rectangle for some reason
//			Point start = new Point(e.getX(), e.getY());
//			this.rectangle=new Rectangle(start, new Point(0,0));
//			this.rectangle.setStart(start);

			
		} else if(this.mode=="Circle"){
			
		} else if (this.mode == "Rectangle"){ 
=======
		if (this.mode == "Squiggle") {
			this.model.addPoint(new Point(this.currentColor, this.strokeThickness, e.getX(), e.getY()));
			repaint();
		} else if (this.mode == "Circle") {

			if (this.circle != null) {
				if (e.getX() < prevPoint.getX()) {
					int radius = e.getX() - this.circle.getCentre().getX();
					this.circle.setRadius(-radius * 2);
					this.model.addCircle(this.circle);
					repaint();
				} else {
					int radius = e.getX() - this.circle.getCentre().getX();
					this.circle.setRadius(radius * 2);
					this.model.addCircle(this.circle);
					repaint();
				}

			}

		} else if (this.mode == "Rectangle") {
>>>>>>> branch 'master' of https://cslinux.utm.utoronto.ca/git/repo_JustTryingToSurvive.git
			int miniX = Math.min(e.getX(), prevPoint.getX());
<<<<<<< HEAD
            int miniY = Math.min(e.getY(), prevPoint.getY());
            int maxiX = Math.max(e.getX(), prevPoint.getX());
            int maxiY = Math.max(e.getY(), prevPoint.getY());

=======
			int miniY = Math.min(e.getY(), prevPoint.getY());
			int maxiX = Math.max(e.getX(), prevPoint.getX());
			int maxiY = Math.max(e.getY(), prevPoint.getY());
>>>>>>> branch 'master' of https://cslinux.utm.utoronto.ca/git/repo_JustTryingToSurvive.git

			this.rectangle.setXnum(miniX);
			this.rectangle.setYnum(miniY);
			this.rectangle.setWidth(maxiX - miniX);
			this.rectangle.setHeight(maxiY - miniY);
			this.model.addRectangle(this.rectangle);
			repaint();

		} else if (this.mode == "Square") {
			int miniX = Math.min(e.getX(), prevPoint.getX());
			int miniY = Math.min(e.getY(), prevPoint.getY());
			int maxiX = Math.max(e.getX(), prevPoint.getX());
			int maxiY = Math.max(e.getY(), prevPoint.getY());

<<<<<<< HEAD

		} else if (this.mode == "Rectangle") { // code below doesnt allow you to
												// draw rectangle for some
												// reason
			// Point start = new Point(e.getX(), e.getY());
			// this.rectangle=new Rectangle(start, new Point(0,0));
			// this.rectangle.setStart(start);
		} else if (this.mode == "Polyline") {
			this.model.addPoint(new Point(e.getX(), e.getX()));

            this.square.setXnum(miniX);
            this.square.setYnum(miniY);
            this.square.setWidth(maxiX - miniX);
            this.square.setHeigth(maxiX - miniX);
            this.model.addSquare(this.square);
            repaint();
=======
			this.square.setXnum(miniX);
			this.square.setYnum(miniY);
			this.square.setWidth(maxiX - miniX);
			this.square.setHeight(maxiX - miniX);
			this.model.addSquare(this.square);
			repaint();

>>>>>>> branch 'master' of https://cslinux.utm.utoronto.ca/git/repo_JustTryingToSurvive.git

<<<<<<< HEAD
		
		} else if(this.mode=="Polyline"){
//			this.model.addPoint(new Point(e.getX(), e.getY()));
			

=======
>>>>>>> branch 'master' of https://cslinux.utm.utoronto.ca/git/repo_JustTryingToSurvive.git
		}
	}

	// MouseListener below
	@Override
	public void mouseClicked(MouseEvent e) {
		if (this.mode == "Squiggle") {

		} else if (this.mode == "Circle") {

		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
<<<<<<< HEAD
		if(this.mode=="Squiggle"){
			
		} else if(this.mode=="Circle"){
			// Problematic notion of radius and center!!


			Point centre = new Point(e.getX(), e.getY());
=======
		prevPoint = new Point(this.currentColor, this.strokeThickness, e.getX(), e.getY());

		if (this.mode == "Squiggle") {

		} else if (this.mode == "Circle") {
			// Problematic notion of radius and centre!!

>>>>>>> branch 'master' of https://cslinux.utm.utoronto.ca/git/repo_JustTryingToSurvive.git
			int radius = 0;
<<<<<<< HEAD

			this.circle = new Circle(centre, radius);

		} else if (this.mode == "Rectangle") {
			Point start = new Point(e.getX(), e.getY());
			this.rectangle = new Rectangle(start, new Point(0, 0));
			this.rectangle.setStart(start);

		} else if (this.mode == "Square") {
			Point start = new Point(e.getX(), e.getY());
			this.square = new Square(start, new Point(0, 0));
			this.square.setStart(start);

		} else if (this.mode == "Polyline") {


		}


			this.circle=new Circle(centre, radius);
			
		} else if (this.mode == "Rectangle"){
			prevPoint = new Point(e.getX(), e.getY());
			this.rectangle=new Rectangle(e.getX(), e.getY(), 0, 0);
			
		} else if (this.mode == "Square"){
			prevPoint = new Point(e.getX(), e.getY());
			this.square=new Square(e.getX(), e.getY(), 0, 0);
			
		} else if(this.mode=="Polyline"){
			
//			this.model.addPoint(new Point(e.getX(), e.getY()));
				
			}		

=======

			this.circle = new Circle(this.currentColor, this.strokeThickness, prevPoint, radius);

		} else if (this.mode == "Rectangle") {
			this.rectangle = new Rectangle(this.currentColor, this.strokeThickness, e.getX(), e.getY(), 0, 0);

		} else if (this.mode == "Square") {
			this.square = new Square(this.currentColor, this.strokeThickness, e.getX(), e.getY(), 0, 0);


		}
	}

	public void setColor(Color co) {
		System.out.println("setting color");
		this.currentColor = co;

	}

	public void setThickness(int th) {
		System.out.println("setting thcikness");
		this.strokeThickness = th;
>>>>>>> branch 'master' of https://cslinux.utm.utoronto.ca/git/repo_JustTryingToSurvive.git
	}

	@Override
	public void mouseReleased(MouseEvent e) {
<<<<<<< HEAD
		if(this.mode=="Squiggle"){		
						
		} else if(this.mode=="Circle"){
			if(this.circle!=null){
				// Problematic notion of radius and center!!


				int radius = Math.abs(this.circle.getCentre().getX()-e.getX());

				
				int radius = Math.abs(this.circle.getCentre().getX()-e.getX());

				this.circle.setRadius(radius);
=======
		if (this.mode == "Squiggle") {
			Point d = new Point(this.currentColor, this.strokeThickness, e.getX(), e.getY());
			d.setDraw(false);
			this.model.addPoint(d);

		} else if (this.mode == "Circle") {
			if (e.getX() < prevPoint.getX()) {
				int radius = e.getX() - this.circle.getCentre().getX();
				this.circle.setRadius(-radius * 2);

>>>>>>> branch 'master' of https://cslinux.utm.utoronto.ca/git/repo_JustTryingToSurvive.git
				this.model.addCircle(this.circle);
				this.circle = null;
			} else {
				int radius = e.getX() - this.circle.getCentre().getX();
				this.circle.setRadius(radius * 2);
				this.model.addCircle(this.circle);
				this.circle = null;
			}

		} else if (this.mode == "Rectangle") { // not working properly
			if (this.rectangle != null) {
				int miniX = Math.min(e.getX(), prevPoint.getX());
				int miniY = Math.min(e.getY(), prevPoint.getY());
				int maxiX = Math.max(e.getX(), prevPoint.getX());
				int maxiY = Math.max(e.getY(), prevPoint.getY());

				this.rectangle.setXnum(miniX);
				this.rectangle.setYnum(miniY);
				this.rectangle.setWidth(maxiX - miniX);
				this.rectangle.setHeight(maxiY - miniY);
				this.model.addRectangle(this.rectangle);
			} else if (this.mode == "Square") {
				if (this.square != null) {
					int miniX = Math.min(e.getX(), prevPoint.getX());
					int miniY = Math.min(e.getY(), prevPoint.getY());
					int maxiX = Math.max(e.getX(), prevPoint.getX());
					int maxiY = Math.max(e.getY(), prevPoint.getY());

					this.square.setXnum(miniX);
					this.square.setYnum(miniY);
					this.square.setWidth(maxiX - miniX);
					this.square.setHeight(maxiX - miniX);
					this.model.addSquare(this.square);
				}


			}
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (this.mode == "Squiggle") {

		} else if (this.mode == "Circle") {

		} else if (this.mode == "Rectangle") {

		} else if (this.mode == "Square") {


		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (this.mode == "Squiggle") {

		} else if (this.mode == "Circle") {

		} else if (this.mode == "Rectangle") {

		} else if (this.mode == "Square") {


		}
	}
<<<<<<< HEAD

}}
=======
}
>>>>>>> branch 'master' of https://cslinux.utm.utoronto.ca/git/repo_JustTryingToSurvive.git
