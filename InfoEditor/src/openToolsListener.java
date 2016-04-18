import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

class OpenToolsListener implements ActionListener 
   {
	   
      public void actionPerformed(ActionEvent e)
      {
         
    	  if (e.getActionCommand() == "Select Part of Image") {
    		  System.out.println("Here I am ");
    		  //Image imageB = image.getImage();
    		  //BufferedImage buffered = (BufferedImage) imageB;
    		  System.out.println("buffimg="+buffImg);
    		  Subimages test = new Subimages(buffImg);
    	        JFrame f = new JFrame();
    	        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	        f.getContentPane().add(new JScrollPane(test));
    	        f.setSize(400,400);
    	        f.setLocation(200,200);
    	        f.setVisible(true);
    	        test.createSubimage();

    	  }
   }
   }