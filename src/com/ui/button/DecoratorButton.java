package com.ui.button;

import java.awt.Dimension;

import javax.swing.JButton;

public class DecoratorButton extends JButton{
	public int id;
	public DecoratorButton(String a) {
		super(a);
		// TODO Auto-generated constructor stub
		this.setPreferredSize(new Dimension(100, 100));
		//this.setSize(100, 100);
	}
}
