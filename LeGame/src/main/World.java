package main;

public class World {

	private WorldSettings settings;
	byte[][] tile;

	public World(WorldSettings setting) {
		this.settings = setting;
		tile = new byte[settings.getSize().width][settings.getSize().height];
	}

}
