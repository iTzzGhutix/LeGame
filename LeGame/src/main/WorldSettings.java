package main;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WorldSettings {

	private WorldType type;
	private List<Point> path = new ArrayList<Point>();
	private Dimension size;

	public WorldSettings(WorldType t, Dimension s, Point... points) {
		for (Point p : points) {
			addToPath(p);
		}
		type = t;
		size = s;
	}

	public WorldSettings(WorldType t, Dimension s, List<Point> points) {
		addAllToPath(points);
		type = t;
		size = s;
	}

	private void addToPath(Point p) {
		path.add(p);
	}

	private void addAllToPath(Collection<Point> points) {
		path.addAll(points);
	}

	public WorldType getType() {
		return type;
	}

	public Dimension getSize() {
		return size;
	}

}
