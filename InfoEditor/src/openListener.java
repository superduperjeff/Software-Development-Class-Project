import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

class OpenListener implements ActionListener
   {
	private File recentDirectory = null;
	String filename;
	String name;
	private static JTextPane editorText;
	
      public void actionPerformed(ActionEvent e)
      {
       
    	  int chooserStatus;
    	  JFileChooser chooser = new JFileChooser();
    	  chooser.setCurrentDirectory(new File(System.getProperty("user.home") + "\\Desktop"));
    	  recentDirectory = chooser.getCurrentDirectory();
    	  
    	  if(recentDirectory != null) {
    		  chooser = new JFileChooser(recentDirectory);
    	  }
    	  else {
    		  chooser = new JFileChooser(recentDirectory);
    	  }
         chooserStatus = chooser.showOpenDialog(null);
         if (chooserStatus == JFileChooser.APPROVE_OPTION)
         {
            // Get a reference to the selected file.
        	
        	
            File selectedFile = chooser.getSelectedFile();
         
            // Get the path of the selected file.
            filename = selectedFile.getPath();

            // Open the file.
            if (!openFile(filename))
            {
               JOptionPane.showMessageDialog(null, 
                                "Error reading " +
                                filename, "Error",
                                JOptionPane.ERROR_MESSAGE);
              
            }
            
            recentDirectory = chooser.getCurrentDirectory();
            
            name = filename;
         }
      }
      /**
         The openFile method opens the file specified by
         filename and reads its contents into the text
         area. The method returns true if the file was
         opened and read successfully, or false if an
         error occurred.
         @param filename The name of the file to open.
      */

      private boolean openFile(String filename)
      {
         boolean success;
         String inputLine, editorString = "";
         FileReader freader;
         BufferedReader inputFile;

         try
         {
            // Open the file.
            freader = new FileReader(filename);
            inputFile = new BufferedReader(freader);

            // Read the file contents into the editor.
            inputLine = inputFile.readLine();
            while (inputLine != null)
            {
               editorString = editorString +
                              inputLine + "\n";
               inputLine = inputFile.readLine();
            }
            editorText.setText(editorString);

            // Close the file.
            inputFile.close();  

            // Indicate that everything went OK.
            success = true;
         }
         catch (IOException e)
         {
            // Something went wrong.
            success = false;
         }

         // Return our status.
         return success;
      }
   }