package xyz.gutugutu3030.processing;

import java.awt.Insets;
import java.util.ArrayList;

import processing.core.PApplet;

public class DemoFrame extends javax.swing.JFrame {
	Processing apa;
	public DemoFrame() {
		initComponents();
	}
	void initComponents() {
		apa = new Processing();
		apa.init();
		while (apa.width <= PApplet.DEFAULT_WIDTH || apa.height <= PApplet.DEFAULT_HEIGHT);
		Insets insets = getInsets();
		setSize(apa.width + insets.left + insets.right, apa.height + insets.top + insets.bottom);
		setResizable(false);
		add(apa);
	}
	public void setText(String str){
		apa.setText(str);
	}
}

class Processing extends PApplet {
	ArrayList<String> str;

	public void setup() {
		size(640, 480);
		textSize(24);
		str = new ArrayList<String>();
	}

	public void draw() {
		background(0);
		fill(255);
		text(str.size(),100,100);
		for (int i = 0, n = min(str.size(), height / 30); i < n; i++) {
			text(str.get(i), 0, i * 30+30);
		}
	}

	public void setText(String str) {
		this.str.add(str);
	}
}
