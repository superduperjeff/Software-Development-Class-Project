import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextPane;

import com.inet.jortho.SpellChecker;

class SpellCheckListener implements ActionListener
   {
	private static JTextPane editorText;
      public void actionPerformed(ActionEvent e){
    	  SpellChecker.enableShortKey(editorText, true);
	      SpellChecker.showSpellCheckerDialog(editorText, null);
      }
   }