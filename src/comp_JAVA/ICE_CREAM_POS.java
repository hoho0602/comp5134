package comp_JAVA;

import com.domain.Decorator;
import com.domain.Decorators;
import com.domain.Flavor;
import com.domain.FlavoredIceCream;
import com.domain.IceCream;
import com.ui.main.*;
import com.ui.button.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

public class ICE_CREAM_POS {
	public static JPopupMenu popupmenu = new JPopupMenu();
	static private MainWindow window;
	private static IceCream icecream;
	private static IceCream decoratedIcecream;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ActionListener al = new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  JTextField flavor = new JTextField();
		  		JTextField v = new JTextField();
		  		final JComponent[] inputs = new JComponent[] {
		  				new JLabel("flavor"),
		  				flavor,
		  				new JLabel("value"),
		  				v
		  		};
		  		int dialogResult = JOptionPane.showConfirmDialog(null, inputs, "My custom dialog", JOptionPane.PLAIN_MESSAGE);
		  		if(dialogResult == 0) {
		  		  System.out.println("Yes option");
		  		  try{
		  			  double d = Double.parseDouble(v.getText());
		  			  FlavoredIceCream.addFlavor(flavor.getText(), d); 
		  			  updateFlavorButton();
		  		  }catch (NumberFormatException evt) {
		  			 System.out.println("Not a number");
		  		  }
		  		
		  		} else {
		  		  System.out.println("No Option");
		  		} 
		      }
		    };
		    
	    ActionListener al2 = new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  JTextField decorator = new JTextField();
			  		JTextField v = new JTextField();
			  		final JComponent[] inputs = new JComponent[] {
			  				new JLabel("decorator"),
			  				decorator,
			  				new JLabel("value"),
			  				v
			  		};
			  		int dialogResult = JOptionPane.showConfirmDialog(null, inputs, "My custom dialog", JOptionPane.PLAIN_MESSAGE);
			  		if(dialogResult == 0) {
			  		  System.out.println("Yes option");
			  		  try{
			  			  double d = Double.parseDouble(v.getText());
			  			  Decorators.addDecorator(decorator.getText(), d);
			  			  updateDecoratorButton();
			  		  }catch (NumberFormatException evt){
			  			 System.out.println("Not a number");
			  		  }
			  		
			  		} else {
			  		  System.out.println("No Option");
			  		}  
		      }
		    };
		    
		    
		 window = new MainWindow();
		SystemAdministratorButton sysAdm = new SystemAdministratorButton("sys");
		//sysAdm.setBounds(0, 50 , 100, 100);
		
		window.pan4.add(sysAdm);
		sysAdm.setVisible(true);
		window.setVisible(true);
		
		NewIceCreamButton newicecream = new NewIceCreamButton("New Ice Cream");
		window.setVisible(true);
		window.pan3.add(newicecream, BorderLayout.NORTH);
		
		
		JMenuItem item1, item2;
		item1 = new JMenuItem("Add flvor");
        item2 = new JMenuItem("Add Decorator");
        popupmenu.add(item1);
        popupmenu.addSeparator();
        popupmenu.add(item2);
        popupmenu.setLabel("demo");
		window.pan4.add(popupmenu);
		//popupmenu.setVisible(false);
		item1.addActionListener(al);
		item2.addActionListener(al2);
		
		sysAdm.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				open();
			  }
			});
		
		newicecream.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				//popupmenu.setVisible(true);
				 // Decorators.decoratorList = new ArrayList<Decorator>();
				icecream = new FlavoredIceCream();
				decoratedIcecream = new Decorators(icecream,true);
				//Decorators.decoratorList.clear();
				updateDesAndTotal();
			  }
			});
		
		
		FlavoredIceCream.addFlavor("Chocolate", 20);
		updateFlavorButton();
		FlavoredIceCream.addFlavor("Vanilla", 20);
		updateFlavorButton();
		
		Decorators.addDecorator("M&M", 5);
		updateDecoratorButton();
		Decorators.addDecorator("Strawberry", 4);
		updateDecoratorButton();
		
	}
	
	private static void open(){
		popupmenu.setVisible(true);
		popupmenu.show(window, 20, 20);
	}
	
	private static void updateFlavorButton(){
		Flavor f = FlavoredIceCream.flavorList.get(FlavoredIceCream.flavorList.size()-1);
		IceCreamFlavorButton b = new IceCreamFlavorButton(f.description+",$"+f.cost);
		
		window.pan1.add(b);
		b.setVisible(true);
		window.validate();
		//window.pan1.validate();;
		//b.invalidate();;
		//b.setVisible(true);
		b.setActionCommand(String.valueOf(FlavoredIceCream.flavorList.size()-1));
		b.addActionListener(FlavorButListener);
	}
	
	static ActionListener FlavorButListener = new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	    	  if(icecream == null){
	    		  return;
	    	  }
	    	  int i = Integer.parseInt(e.getActionCommand());
	    	  
	    	  icecream = new FlavoredIceCream(FlavoredIceCream.flavorList.get(i));
	    	  decoratedIcecream = new Decorators(icecream);
	    	  updateDesAndTotal();
	      }
	    };
	
	private static void updateDecoratorButton(){
		Decorator f = Decorators.decoratorList.get(Decorators.decoratorList.size()-1);
		DecoratorButton b = new DecoratorButton(f.description+",$"+f.cost);
		
		window.pan2.add(b);
		b.setVisible(true);
		window.validate();
		b.setActionCommand(String.valueOf(Decorators.decoratorList.size()-1));
		b.addActionListener(DecoratorButListener);
	}
	
	static ActionListener DecoratorButListener = new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	    	  if(icecream == null){
	    		  return;
	    	  }
	    	  int i = Integer.parseInt(e.getActionCommand());
	    	  
	    	  //icecream = new FlavoredIceCream(FlavoredIceCream.flavorList.get(i));
	    	  decoratedIcecream = new Decorators(icecream, Decorators.decoratorList.get(i));
	    	  
	    	  updateDesAndTotal();
	      }
	    };
	
	private static void updateDesAndTotal(){
		double a = decoratedIcecream.cost();
		window.total.setText(String.valueOf(a));
		
		window.des.setText(decoratedIcecream.getDescription());
	}

}
