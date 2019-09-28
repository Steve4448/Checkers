package main.components;

import java.awt.Graphics;
import javax.swing.JPanel;

public class PlayerPiece extends JPanel {

	public static final java.awt.Color SELECTED_BACKGROUND = new java.awt.Color(100, 100, 100);

	public static enum Color {
		WHITE,
		BLACK
	}

	private final int id;
	public final Color currentColor;
	public boolean selected = false;
	public boolean king = false;
	private Tile tile;
	
	public static final float[] KING_POLYGON_X = new float[] {0.35f, 0.65f, 0.8f, 0.6f, 0.5f, 0.4f, 0.2f};
	public static final float[] KING_POLYGON_Y = new float[] {0.725f, 0.725f, 0.4f, 0.5f, 0.3f, 0.5f, 0.4f};

	public PlayerPiece(int id, Color currentColor) {
		this.id = id;
		this.currentColor = currentColor;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(isSelected()) {
			g.setColor(SELECTED_BACKGROUND);
			g.fillRect(0, 0, getWidth(), getHeight());
		}
	}

	public Color getColor() {
		return currentColor;
	}
	
	public void paintCrown(Graphics g) {
		int[] KING_POLYGON_X_SCALED = new int[KING_POLYGON_X.length];
		int[] KING_POLYGON_Y_SCALED = new int[KING_POLYGON_Y.length];
		for(int i = 0; i < KING_POLYGON_X_SCALED.length; i++) {
			KING_POLYGON_X_SCALED[i] = (int)(getWidth() * KING_POLYGON_X[i]);
			KING_POLYGON_Y_SCALED[i] = (int)(getHeight() * KING_POLYGON_Y[i]);
		}
		g.setColor(java.awt.Color.BLACK);
		g.fillPolygon(KING_POLYGON_X_SCALED, KING_POLYGON_Y_SCALED, KING_POLYGON_X.length);
		g.fillOval((int)(getWidth() * 0.75f) - (getWidth() / 10) / 2, (int)(getHeight() * 0.4f) - (getHeight() / 10) / 2, getWidth() / 10, getHeight() / 10);
		g.fillOval((int)(getWidth() * 0.245f) - (getWidth() / 10) / 2, (int)(getHeight() * 0.4f) - (getHeight() / 10) / 2, getWidth() / 10, getHeight() / 10);
		g.fillOval((int)(getWidth() * 0.5f) - (getWidth() / 10) / 2, (int)(getHeight() * 0.3f) - (getHeight() / 10) / 2, getWidth() / 10, getHeight() / 10);
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
		repaint();
	}

	public boolean isSelected() {
		return selected;
	}
	
	public void setKing() {
		king = true;
		repaint();
	}
	
	public boolean isKing() {
		return king;
	}
	
	public void setTile(Tile tile) {
		this.tile = tile;
	}
	
	public Tile getTile() {
		return tile;
	}
	
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return getClass().getName() + "[id=" + id + ", color=" + getColor() +", king=" + king + "]";
	}
}
