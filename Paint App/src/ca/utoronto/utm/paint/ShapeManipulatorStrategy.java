package ca.utoronto.utm.paint;
 
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public abstract class ShapeManipulatorStrategy implements MouseMotionListener, MouseListener {
	private PaintPanel pPanel;

	public ShapeManipulatorStrategy(PaintPanel pp) {
		this.pPanel = pp;
	}
	
	public PaintPanel getPaintPanel(){
		return this.pPanel;  
	}
}
