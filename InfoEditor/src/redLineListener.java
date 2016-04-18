import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JTextPane;

import com.inet.jortho.SpellChecker;

class RedLineListener implements ActionListener
   {
	private JCheckBoxMenuItem RedUnderline;
	private static JTextPane editorText;
      public void actionPerformed(ActionEvent e){
	      	if (RedUnderline.isSelected() == true){
	      		SpellChecker.enableAutoSpell(editorText, true);
	      	}else{
	      		SpellChecker.enableAutoSpell(editorText, false);
	      	}
      }
   }