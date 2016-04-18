import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PrintListener implements ActionListener 
   {
     
	public void actionPerformed(ActionEvent e)
      { 
		 PrintingTask task = new PrintingTask(null, null, true);
	            task.execute();
	        ;
	}
      }