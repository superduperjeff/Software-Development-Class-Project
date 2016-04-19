import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class exitListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
    	 System.out.println("exit"); // to make sure which part this is in
         System.exit(0);
      }
   }