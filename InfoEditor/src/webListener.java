import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 class WebListener implements ActionListener{
      public void actionPerformed(ActionEvent e)
          {
             if (e.getActionCommand().equals("Import Picture from Web")){
             openURLImage();
            }
             if (e.getActionCommand().equals("Sample Text from Website")){
                 openURLText();
                }
      }
      
 }
   