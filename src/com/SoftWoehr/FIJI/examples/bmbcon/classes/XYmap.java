//\ XYmap.java ... class to get mouse parameters from a 'map'\
//\ Published by B M B con. See accompanying readme.1st file\
//\ Author: Roelf Toxopeus email: postbus@bmbcon2.demon.nl \
//\ Last modified: 1 Feb 2001 rt \

import java.awt.*;
import java.awt.event.*;

public class XYmap extends Frame implements MouseMotionListener {
	public int x;
	public int y;

	public XYmap() {
		super();
		addMouseMotionListener(this);
		setSize(200, 200);
		show();
	}
	
	public void mouseDragged(MouseEvent evt) {
	}

	public void mouseMoved(MouseEvent evt) {
		x = evt.getX();
		y = evt.getY();
	}

	public static void main(String args[]) {
		new XYmap();
	}
}
