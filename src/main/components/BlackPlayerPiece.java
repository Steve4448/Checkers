package main.components;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;

public class BlackPlayerPiece extends PlayerPiece {

	private static final java.awt.Color BLACK_INSIDE_CIRCLE = new java.awt.Color(237, 0, 0);
	private static final java.awt.Color BLACK_INSIDE_CIRCLE_BORDER = new java.awt.Color(200, 0, 0);
	private static final java.awt.Color BLACK_OUTSIDE_CIRCLE = new java.awt.Color(220, 0, 0);
	private static final java.awt.Color BLACK_OUTSIDE_CIRCLE_BORDER = new java.awt.Color(170, 0, 0);
	private static final float[] RADIAL_GRADIENT_DIST = {0.0f, 0.3f, 0.4f, 0.7f, 0.9f, 1f};
	private static final java.awt.Color[] RADIAL_GRADIENT_COLORS = new java.awt.Color[]{BLACK_INSIDE_CIRCLE, BLACK_INSIDE_CIRCLE_BORDER, BLACK_INSIDE_CIRCLE_BORDER, BLACK_OUTSIDE_CIRCLE, BLACK_OUTSIDE_CIRCLE_BORDER, BLACK_OUTSIDE_CIRCLE_BORDER};

	public BlackPlayerPiece() {
		super(-1, Color.BLACK);
	}
	
	public BlackPlayerPiece(int id) {
		super(id, Color.BLACK);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		float radius = getWidth();
		RadialGradientPaint p = new RadialGradientPaint(new Point2D.Float(getWidth() / 2, getHeight() / 2), radius, RADIAL_GRADIENT_DIST, RADIAL_GRADIENT_COLORS);
		g2.setPaint(p);
		g2.fillOval(4, 4, getWidth() - 8, getHeight() - 8);
		if(isKing())
			paintCrown(g2);
	}
}
