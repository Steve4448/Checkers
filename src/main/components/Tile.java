package main.components;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Tile extends JPanel {

	public boolean isValidTile = false;
	public boolean isMoveable = false;
	public static final Color VALID_MOVE_COLOR = new Color(45, 150, 45);
	public static final Color VALID_MOVE_COLOR_OTHER = new Color(20, 75, 20);
	private final int id;
	
	public Tile() {
		this.id = -1;
	}
	
	public Tile(int id) {
		this.id = id;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(isMoveable) {
			g.setColor(Board.myTurn() ? VALID_MOVE_COLOR : VALID_MOVE_COLOR_OTHER);
			g.fillRect(0, 0, getWidth(), getHeight());
		}
	}

	public void setMoveable(boolean isMoveable) {
		this.isMoveable = isMoveable;
		repaint();
	}

	public boolean isMoveable() {
		return isMoveable;
	}

	public void setValidTile(boolean isValidTile) {
		this.isValidTile = isValidTile;
	}

	public boolean isValidTile() {
		return isValidTile;
	}
	
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return getClass().getName() + "[id=" + id + ", isValidTile=" + isValidTile + ", isMoveable=" + isMoveable + "]";
	}
}
