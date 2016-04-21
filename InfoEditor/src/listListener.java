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
	private Color defaultColor;

	public listListener(JMenuBar menubar1,JToolBar toolBar1 ,JPanel panel, JCheckBoxMenuItem uShowLeftList ) 
	{
		menuBar = menubar1;
		toolBar = toolBar1; 
		ontologyPanel = panel;
		showLeftList = uShowLeftList;
	}

	public void actionPerformed(ActionEvent e)
	{
		System.out.println("command" + e.getActionCommand());

		if(e.getActionCommand().equals("Midnight")) 
		{
			System.out.println("Midnight");
			Color midnight = new Color(23,17,79);
			menuBar.setBackground(midnight);
			toolBar.setBackground(midnight);

			for(int i = 0; i < menuBar.getComponentCount(); i++) 
			{
				if(menuBar.getComponent(i) instanceof JMenuItem) 
				{
					menuBar.getComponent(i).setForeground(Color.WHITE);
				}
			}
			for(int i = 0; i < toolBar.getComponentCount(); i++) 
			{
				toolBar.getComponent(i).setForeground(Color.WHITE);
				toolBar.getComponent(i).setBackground(midnight);
			}
			//    		contents.revalidate();
			//    		contents.repaint();
		}

		if(e.getActionCommand().equals("Sky")) 
		{
			System.out.println("Sky");
			Color sky = new Color(75,165,255);
			menuBar.setBackground(sky);
			toolBar.setBackground(sky);

			for(int i = 0; i < menuBar.getComponentCount(); i++) 
			{
				if(menuBar.getComponent(i) instanceof JMenuItem) 
				{
					menuBar.getComponent(i).setForeground(Color.WHITE);
				}
			}
			for(int i = 0; i < toolBar.getComponentCount(); i++)
			{
				toolBar.getComponent(i).setForeground(Color.WHITE);
				toolBar.getComponent(i).setBackground(sky);
			}
		}
		if(e.getActionCommand().equals("Spring")) 
		{
			System.out.println("Green");
			Color spring = new Color(110, 226, 83);
			menuBar.setBackground(spring);
			toolBar.setBackground(spring);

			for(int i = 0; i < menuBar.getComponentCount(); i++) 
			{
				if(menuBar.getComponent(i) instanceof JMenuItem) 
				{
					menuBar.getComponent(i).setForeground(Color.DARK_GRAY);
				}
			}
			for(int i = 0; i < toolBar.getComponentCount(); i++) 
			{
				toolBar.getComponent(i).setForeground(Color.DARK_GRAY);
				toolBar.getComponent(i).setBackground(spring);
			}
		}

		if(e.getActionCommand().equals("Fire")) 
		{
			System.out.println("Fire");
			Color fire = new Color(255, 60, 25);
			menuBar.setBackground(fire);
			toolBar.setBackground(fire);

			for(int i = 0; i < menuBar.getComponentCount(); i++) 
			{
				if(menuBar.getComponent(i) instanceof JMenuItem) 
				{
					menuBar.getComponent(i).setForeground(Color.WHITE);
				}
			}
			for(int i = 0; i < toolBar.getComponentCount(); i++) 
			{
				toolBar.getComponent(i).setForeground(Color.WHITE);
				toolBar.getComponent(i).setBackground(fire);
			}
		}

		if(e.getActionCommand().equals("Swamp")) 
		{
			System.out.println("swamp");
			Color swamp = new Color(15, 85, 40);
			menuBar.setBackground(swamp);
			toolBar.setBackground(swamp);

			for(int i = 0; i < menuBar.getComponentCount(); i++) 
			{
				if(menuBar.getComponent(i) instanceof JMenuItem) 
				{
					menuBar.getComponent(i).setForeground(Color.WHITE);
				}
			}

			for(int i = 0; i < toolBar.getComponentCount(); i++) 
			{
				toolBar.getComponent(i).setForeground(Color.WHITE);
				toolBar.getComponent(i).setBackground(swamp);
			}
		}

		if(e.getActionCommand().equals("Default")) 
		{
			System.out.println("default");
			menuBar.setBackground(defaultColor);
			toolBar.setBackground(defaultColor);

			for(int i = 0; i < menuBar.getComponentCount(); i++) 
			{
				if(menuBar.getComponent(i) instanceof JMenuItem) 
				{
					menuBar.getComponent(i).setForeground(Color.black);
				}
			}
			for(int i = 0; i < toolBar.getComponentCount(); i++) 
			{
				toolBar.getComponent(i).setForeground(Color.black);
				toolBar.getComponent(i).setBackground(defaultColor);
			}
		}
		
		if(e.getActionCommand().equals("Show Ontology"))
		{
			if (showLeftList.isSelected())
			{
				System.out.println("true");
				ontologyPanel.setVisible(true);       
			}
			else
			{
				System.out.println("false");
				ontologyPanel.setVisible(false);    
			}
		}
	}
}
