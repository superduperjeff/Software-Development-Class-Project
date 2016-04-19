import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;

class listListener implements ActionListener
   {
	private JMenuBar menuBar;
	private JToolBar toolBar;
	private JCheckBoxMenuItem showLeftList;
	JPanel ontologyPanel;
	private JMenuItem midnightTheme;
	private JMenuItem skyTheme;
	private JMenuItem greenTheme;
	private JMenuItem fireTheme;
	private JMenuItem swampTheme;
	private JMenuItem defaultTheme;
	private Color defaultColor;
	
      public void actionPerformed(ActionEvent e)
      {
    	  System.out.println("Midnight");
    	  
    	  if(e.getSource()==midnightTheme) {
    		Color midnight = new Color(23,17,79);
    		menuBar.setBackground(midnight);
    		toolBar.setBackground(midnight);
    		for(int i = 0; i < menuBar.getComponentCount(); i++) {
    			if(menuBar.getComponent(i) instanceof JMenuItem) {
    				menuBar.getComponent(i).setForeground(Color.WHITE);
    			}
    		}
    		for(int i = 0; i < toolBar.getComponentCount(); i++) {
    				toolBar.getComponent(i).setForeground(Color.WHITE);
    				toolBar.getComponent(i).setBackground(midnight);
    		}
//    		contents.revalidate();
//    		contents.repaint();
    	  }
    	  if(e.getSource()==skyTheme) {
    		Color sky = new Color(75,165,255);
    		menuBar.setBackground(sky);
      		toolBar.setBackground(sky);
      		for(int i = 0; i < menuBar.getComponentCount(); i++) {
      			if(menuBar.getComponent(i) instanceof JMenuItem) {
      				menuBar.getComponent(i).setForeground(Color.WHITE);
      			}
      		}
      		for(int i = 0; i < toolBar.getComponentCount(); i++) {
      				toolBar.getComponent(i).setForeground(Color.WHITE);
      				toolBar.getComponent(i).setBackground(sky);
      		}
    	  }
    	  if(e.getSource()==greenTheme) {
    		Color spring = new Color(110, 226, 83);
    		menuBar.setBackground(spring);
      		toolBar.setBackground(spring);
      		for(int i = 0; i < menuBar.getComponentCount(); i++) {
      			if(menuBar.getComponent(i) instanceof JMenuItem) {
      				menuBar.getComponent(i).setForeground(Color.DARK_GRAY);
      			}
      		}
      		for(int i = 0; i < toolBar.getComponentCount(); i++) {
      				toolBar.getComponent(i).setForeground(Color.DARK_GRAY);
      				toolBar.getComponent(i).setBackground(spring);
      		}
    	  }
    	  if(e.getSource()==fireTheme) {
    		Color fire = new Color(255, 60, 25);
    		menuBar.setBackground(fire);
      		toolBar.setBackground(fire);
      		for(int i = 0; i < menuBar.getComponentCount(); i++) {
      			if(menuBar.getComponent(i) instanceof JMenuItem) {
      				menuBar.getComponent(i).setForeground(Color.WHITE);
      			}
      		}
      		for(int i = 0; i < toolBar.getComponentCount(); i++) {
      				toolBar.getComponent(i).setForeground(Color.WHITE);
      				toolBar.getComponent(i).setBackground(fire);
      		}
    	  }
    	  if(e.getSource()==swampTheme) {
    		Color swamp = new Color(15, 85, 40);
    		menuBar.setBackground(swamp);
      		toolBar.setBackground(swamp);
      		for(int i = 0; i < menuBar.getComponentCount(); i++) {
      			if(menuBar.getComponent(i) instanceof JMenuItem) {
      				menuBar.getComponent(i).setForeground(Color.WHITE);
      			}
      		}
      		for(int i = 0; i < toolBar.getComponentCount(); i++) {
      				toolBar.getComponent(i).setForeground(Color.WHITE);
      				toolBar.getComponent(i).setBackground(swamp);
      		}
    	  }
    	  if(e.getSource()==defaultTheme) {
      		menuBar.setBackground(defaultColor);
        	toolBar.setBackground(defaultColor);
        		for(int i = 0; i < menuBar.getComponentCount(); i++) {
        			if(menuBar.getComponent(i) instanceof JMenuItem) {
        				menuBar.getComponent(i).setForeground(Color.black);
        			}
        		}
        		for(int i = 0; i < toolBar.getComponentCount(); i++) {
        				toolBar.getComponent(i).setForeground(Color.black);
        				toolBar.getComponent(i).setBackground(defaultColor);
        		}
      	  }
         
         if (showLeftList.isSelected()){
         ontologyPanel.setVisible(true);       
         }
         else{
        	 ontologyPanel.setVisible(false);    
         }
   }
   }