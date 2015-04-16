package com.domain;

import java.util.ArrayList;

public class Decorators extends IceCreamDecorators{
	protected IceCream icecream;
	public static ArrayList<Decorator> ordered = new ArrayList<Decorator>();
	public static ArrayList<Decorator> decoratorList = new ArrayList<Decorator>();
	public Decorators(IceCream icecream, Decorator dec) {
		// TODO Auto-generated constructor stub
		this.icecream = icecream;
		this.selectDecorator(dec);
	}
	public Decorators(IceCream icecream, Boolean clear) {
		// TODO Auto-generated constructor stub
		this.icecream = icecream;
		if(clear){
			ordered.clear();
		}
	}
	public Decorators(IceCream icecream) {
		// TODO Auto-generated constructor stub
		this(icecream, false);
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		String decorationsDescription = "";
		for(int i=0;i<ordered.size();i++){
			decorationsDescription = decorationsDescription + " with " + ordered.get(i).description;
		}
		return icecream.getDescription() + decorationsDescription;
	}
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		double decorationscost = 0;
		for(int i=0;i<ordered.size();i++){
			decorationscost = decorationscost + ordered.get(i).cost;
		}
		return icecream.cost() + decorationscost;
	}

	private void selectDecorator(Decorator dec){
		//ordered[ordered.length] = dec;
		ordered.add(dec);
	}
	
	public static void addDecorator(String s, double c){
		//decoratorList[decoratorList.length] = dec;
		decoratorList.add(new Decorator(s, c));
	}
}
