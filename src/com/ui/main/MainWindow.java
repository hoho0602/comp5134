package com.ui.main;

import javax.swing.*;

import java.awt.*;

public class MainWindow extends JFrame {
	 public JPanel pan1 = new JPanel();
	 public JPanel pan2 = new JPanel();
	 public JPanel pan3 = new JPanel();
	 public JPanel pan4 = new JPanel();
	 public JLabel total;
	 public JTextArea des;
	 
	public MainWindow() {
	super("Main Window");
   this.setSize(900, 800);
   //this.setPreferredSize(new Dimension(900, 600));
   // this.setLocation(100, 100);
	this.setLayout(new BorderLayout(5,5));
    
    
   
    pan1.setLayout(new BoxLayout(pan1, BoxLayout.PAGE_AXIS));
   // pan1.setSize(600/3,100);
    pan1.setPreferredSize(new Dimension(600/3,100));
    
    pan2.setLayout(new BoxLayout(pan2, BoxLayout.PAGE_AXIS));
    //pan2.setSize(600/3,100);
    pan2.setPreferredSize(new Dimension(600/3,100));
    
    pan3.setLayout(new BorderLayout());
   // pan3.setSize(600/3,100);
    pan3.setPreferredSize(new Dimension(600/3,100));
    
    pan4.setLayout(new BorderLayout());
    //pan4.setSize(300,100);
    pan4.setPreferredSize(new Dimension(300,100));
   
    
    this.add(pan1, BorderLayout.WEST);
    this.add(pan2, BorderLayout.CENTER);
    this.add(pan3, BorderLayout.EAST);
    this.add(pan4, BorderLayout.SOUTH);
    
    JLabel txt1 = new JLabel("Flavor");
    pan1.add(txt1);
    
    JLabel txt2 = new JLabel("Decorator");
    pan2.add(txt2);
    
    //this.invalidate();
    //this.setVisible(true);
    JPanel p5 = new JPanel();
    JLabel t1 = new JLabel("Total:");
    total = new JLabel();
    p5.add(t1);
    p5.add(total);
    
   
    des = new JTextArea();
    des.setSize(100,70);
    des.setEditable(false);
    des.setLineWrap(true);
    JPanel p6 = new JPanel();
    p6.setLayout(new BoxLayout(p6, BoxLayout.PAGE_AXIS));
   
    p6.add(des);
    p6.add(p5);
    pan3.add(p6, BorderLayout.SOUTH);
    
	}
}
