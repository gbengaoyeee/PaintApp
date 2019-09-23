package ca.utoronto.utm.paint;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.*;

/**
<<<<<<< HEAD
 * This is the top level View+Controller, it contains other aspects of the
 * View+Controller.
 *
=======
 * This is the top level View+Controller, it contains other aspects of the View+Controller.
 * @author arnold
 * 
>>>>>>> refs/remotes/origin/Bug2
 */
public class View extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private PaintModel model;

	// The components that make this up
	private PaintPanel paintPanel;
	private ShapeChooserPanel shapeChooserPanel;

	public View(PaintModel model) {
		super("Paint"); // set the title and do other JFrame init

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(createMenuBar());

		Container c = this.getContentPane();
		// c.add(new JButton("North"),BorderLayout.NORTH);
		// c.add(new JButton("South"),BorderLayout.SOUTH);
		// c.add(new JButton("East"),BorderLayout.EAST);
		this.shapeChooserPanel = new ShapeChooserPanel(this);
		c.add(this.shapeChooserPanel, BorderLayout.WEST);

		this.model = model;

		this.paintPanel = new PaintPanel(model, this);
		c.add(this.paintPanel, BorderLayout.CENTER);

		this.pack();
		// this.setSize(200,200);
		this.setVisible(true);
	}

	public PaintPanel getPaintPanel() {
		return paintPanel;
	}

	public ShapeChooserPanel getShapeChooserPanel() {
		return shapeChooserPanel;
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu, menu1, menu2, menu3;
		JMenuItem menuItem, menuColorItem;

		menu = new JMenu("File");
		// a group of JMenuItems
		menuItem = new JMenuItem("New");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		menuItem = new JMenuItem("Open");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		menuItem = new JMenuItem("Save");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		menu.addSeparator();// -------------
		menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		menuBar.add(menu);

		menu1 = new JMenu("Edit");
		// a group of JMenuItems
		menuItem = new JMenuItem("Cut");
		menuItem.addActionListener(this);
		menu1.add(menuItem);
		menuItem = new JMenuItem("Copy");
		menuItem.addActionListener(this);
		menu1.add(menuItem);
		menuItem = new JMenuItem("Paste");
		menuItem.addActionListener(this);
		menu1.add(menuItem);
		menu.addSeparator();// -------------
		menuItem = new JMenuItem("Undo");
		menuItem.addActionListener(this);
		menu1.add(menuItem);
		menuItem = new JMenuItem("Redo");
		menuItem.addActionListener(this);
		menu1.add(menuItem);
		menuBar.add(menu1);

		menu2 = new JMenu("Line Style");
		// a group of JMenuItems
		menuItem = new JMenuItem("1/4 pt");
		menuItem.addActionListener(this);
		menu2.add(menuItem);
		menuItem = new JMenuItem("1/2 pt");
		menuItem.addActionListener(this);
		menu2.add(menuItem);
		menuItem = new JMenuItem("1 pt");
		menuItem.addActionListener(this);
		menu2.add(menuItem);
		menuItem = new JMenuItem("1 1/2 pt");
		menuItem.addActionListener(this);
		menu2.add(menuItem);
		menuItem = new JMenuItem("2 pt");
		menuItem.addActionListener(this);
		menu2.add(menuItem);
		menuItem = new JMenuItem("2 1/2 pt");
		menuItem.addActionListener(this);
		menu2.add(menuItem);
		menuItem = new JMenuItem("3 pt");
		menuItem.addActionListener(this);
		menu2.add(menuItem);
		menuItem = new JMenuItem("3 1/2 pt");
		menuItem.addActionListener(this);
		menu2.add(menuItem);
		menuItem = new JMenuItem("4 pt");
		menuItem.addActionListener(this);
		menu2.add(menuItem);
		menuItem = new JMenuItem("4 1/2 pt");
		menuItem.addActionListener(this);
		menu2.add(menuItem);
		menuItem = new JMenuItem("5 pt");
		menuItem.addActionListener(this);
		menu2.add(menuItem);

		menu2.addSeparator();// -------------

		menuItem = new JMenuItem("dashed");
		menuItem.addActionListener(this);
		menu2.add(menuItem);
		menuItem = new JMenuItem("straight");
		menuItem.addActionListener(this);
		menu2.add(menuItem);
		menuBar.add(menu2);

		menu3 = new JMenu("Color");
		// a group of JMenu for color
		menuColorItem = new JMenuItem("black");
		menuColorItem.addActionListener(this);
		menu3.add(menuColorItem);
		menuColorItem = new JMenuItem("pink");
		menuColorItem.addActionListener(this);
		menu3.add(menuColorItem);
		menuColorItem = new JMenuItem("red");
		menuColorItem.addActionListener(this);
		menu3.add(menuColorItem);
		menuColorItem = new JMenuItem("white");
		menuColorItem.addActionListener(this);
		menu3.add(menuColorItem);
		menuColorItem = new JMenuItem("green");
		menuColorItem.addActionListener(this);
		menu3.add(menuColorItem);
		menuBar.add(menu3);
		return menuBar;
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
	    if (e.getActionCommand() == "Exit") {
	    	System.exit(0);
	    }
		else if (e.getActionCommand() == "1/4 pt") {
			this.paintPanel.setThickness(1);

		} else if (e.getActionCommand() == "1/2 pt") {
			this.paintPanel.setThickness(2);

		} else if (e.getActionCommand() == "1 pt") {
			this.paintPanel.setThickness(3);

		} else if (e.getActionCommand() == "1 1/2 pt") {
			this.paintPanel.setThickness(4);

		} else if (e.getActionCommand() == "2 pt") {
			this.paintPanel.setThickness(5);

		} else if (e.getActionCommand() == "2 1/2 pt") {
			this.paintPanel.setThickness(6);

		} else if (e.getActionCommand() == "3 pt") {
			this.paintPanel.setThickness(7);

		} else if (e.getActionCommand() == "3 1/2 pt") {
			this.paintPanel.setThickness(8);

		} else if (e.getActionCommand() == "4 pt") {
			this.paintPanel.setThickness(9);

		} else if (e.getActionCommand() == "4 1/2 pt") {
			this.paintPanel.setThickness(10);

		} else if (e.getActionCommand() == "5 pt") {
			this.paintPanel.setThickness(11);

		} else if (e.getActionCommand() == "black") {
			this.paintPanel.setColor(Color.black);
		}

		else if (e.getActionCommand() == "pink") {
			this.paintPanel.setColor(Color.pink.darker());

		} else if (e.getActionCommand() == "red") {
			this.paintPanel.setColor(Color.red);

		} else if (e.getActionCommand() == "white") {
			this.paintPanel.setColor(Color.white);

		} else if (e.getActionCommand() == "green") {
			this.paintPanel.setColor(Color.green);
		}
	}
}
