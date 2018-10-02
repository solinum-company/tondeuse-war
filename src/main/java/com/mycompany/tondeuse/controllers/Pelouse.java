package com.mycompany.tondeuse.controllers;

/*************************************************************************************************************
*
* @author khalil
* 
* 
**************************************************************************************************************/
import java.util.ArrayList;
import java.util.List;
import static com.google.common.collect.Lists.newArrayList;
import static java.lang.Integer.parseInt;
import static org.apache.commons.lang.StringUtils.split;



public class Pelouse {
	private final int height;
	private final int width;
	private final List<Tondeuse> tondeuses;

	public Pelouse(int width, int height, List<Tondeuse> tondeuses) {
		this.height = height;
		this.width = width;
		this.tondeuses = tondeuses;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public List<Tondeuse> getTondeuses() {
		return tondeuses;
	}

	public static Pelouse readConfig(String config) throws Exception  {
	
		String[] lines = split(config, '\n');
		String[] xy = split(lines[0], ' ');
		int width = parseInt(xy[0]);
		int height = parseInt(xy[1]);
		int nbtondeuses = (lines.length - 1) / 2;
		List<Tondeuse> tondeuses = newArrayList();
		for (int i = 0; i < nbtondeuses; i++) {
			tondeuses.add(Tondeuse.readConfig(lines[(2 * i) + 1], lines[(2 * i) + 2], width, height));
		}
		return new Pelouse(width, height, tondeuses);
		
	}

	public List<String> move() {
		List<String>result=new ArrayList<>();
		for (Tondeuse tondeuse : tondeuses) {
			tondeuse.moveT();
			result.add(tondeuse.getX() + "  " + tondeuse.getY() + "  " + tondeuse.getDirection().name().charAt(0));
		}
		return result;
	}
}
