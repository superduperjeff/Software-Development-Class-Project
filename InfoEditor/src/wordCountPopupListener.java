import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

  class wordCountPopupListener implements ActionListener{
	JPanel contents;  
	  
	public wordCountPopupListener(JPanel main){
		contents = main;
	}
	  public void actionPerformed(ActionEvent e){
		  
		  JOptionPane.showMessageDialog(contents, "Word Count: " + "\n" + "Character Count: ");
		  
	   }
   }
