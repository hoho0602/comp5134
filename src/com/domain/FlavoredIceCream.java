package com.domain;

import java.util.ArrayList;

public class FlavoredIceCream extends IceCream{

	public static ArrayList<Flavor> flavorList = new ArrayList<Flavor>();
	public double cost;
	public FlavoredIceCream(Flavor flavor) {
		// TODO Auto-generated constructor stub
		description = flavor.description + "Ice Cream";
		cost = flavor.cost;	
	}
	
	public FlavoredIceCream() {
		// TODO Auto-generated constructor stub
		description = "Ice Cream";
		cost = 0;	
	}
	
	
	public static void addFlavor(String s, double c){
		//flavorList[flavorList.length] = new Flavor(s,c);
		flavorList.add(new Flavor(s, c));
	}
	
	public double cost() { return cost;}
}
