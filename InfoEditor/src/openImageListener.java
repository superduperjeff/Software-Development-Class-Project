import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

class OpenImageListener implements ActionListener 
   {
	private File recentDirectory = null;
	String filename;
	
	
	
	
      public void actionPerformed(ActionEvent e)
      {
         int chooserStatus;

         JFileChooser chooser = null;
         if(recentDirectory != null) {
   		  chooser = new JFileChooser(recentDirectory);
   	  }
   	  else {
   		  chooser = new JFileChooser(recentDirectory);
   	  }
         
         chooser.setFileFilter(new FileNameExtensionFilter("Image jpg, gif or png ", "jpg", "png", "gif"));
         chooserStatus = chooser.showOpenDialog(null);
         
         if (chooserStatus == JFileChooser.APPROVE_OPTION)
         {
            // Get a reference to the selected file.
            File selectedFile = chooser.getSelectedFile();

            // Get the path of the selected file.
            filename = selectedFile.getPath();

            // Open the file.
            try {
				if (!openImageFile(filename))
				{
				   JOptionPane.showMessageDialog(null, 
				                    "Error reading " +
				                    filename, "Error",
				                    JOptionPane.ERROR_MESSAGE);
				}
			} catch (HeadlessException e1) {
				
				e1.printStackTrace();
			}
            recentDirectory = chooser.getCurrentDirectory();
         }
      }
      
   }