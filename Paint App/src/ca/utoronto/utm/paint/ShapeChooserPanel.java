package ca.utoronto.utm.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/

class ShapeChooserPanel extends JPanel implements ActionListener {
	private View view; // So we can talk to our parent or other components of
						// the view
	String[] buttonLabels = { "Circle", "Rectangle", "Square", "Squiggle", "Polyline" };
	JButton[] buttons = new JButton[buttonLabels.length];  
	public ShapeChooserPanel(View view) {
		this.view = view;

		
	ImageIcon[] images = { new ImageIcon("circle.png"), new ImageIcon("rectangle.png"), new ImageIcon("square.png"),
				new ImageIcon("squiggle.png"), new ImageIcon("polyline.png") };
		this.setLayout(new GridLayout(buttonLabels.length, 1));
		for (int i = 0; i < images.length; i++) {
			JButton button = new JButton(images[i]);
			button.setActionCommand(buttonLabels[i]);
			button.setToolTipText(buttonLabels[i]);
			this.add(button);
			button.addActionListener(this);
			buttons[i]=button;

		} 
	} 

	/**
	 * Controller aspect of this
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.view.getPaintPanel().setMode(e.getActionCommand());

		JButton buttonPressed = (JButton) e.getSource();

		// lets user know which mode they're in by disabling button
		if (buttonPressed.isSelected() != true) {
			buttonPressed.setEnabled(false);
		}
		for (JButton tempButton : buttons) {
			if (buttonPressed != tempButton) {
				tempButton.setEnabled(true);
			}
		}
		System.out.println(e.getActionCommand());
	}

}
