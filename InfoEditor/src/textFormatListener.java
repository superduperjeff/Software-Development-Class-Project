import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;

class TextFormatListener implements ActionListener
{
	private JCheckBoxMenuItem showAnnotations;
	private JCheckBoxMenuItem wordWrap;
   public void actionPerformed(ActionEvent e)
   {
      if(e.getActionCommand().equals("Word Wrap")){
      if (wordWrap.isSelected())
        wrapped=true;
      else {
    	  wrapped=false;
      }
      wordWrap();
      }
      else if(e.getActionCommand().equals("Show Annotations")){
    	 
    	  if (showAnnotations.isSelected()){
    		  System.out.println("Show Annotations");    		 
    	       hideAnnotations(false);
    	  }
    	  else{
    		 
    		  hideAnnotations(true); 
    		  System.out.println("Hide Annotations");
    	  }
    	     
      }
   }
}