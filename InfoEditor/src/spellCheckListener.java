import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JTextPane;

import com.inet.jortho.SpellChecker;

class spellCheckListener implements ActionListener
{
	private static JTextPane editorText;

	public spellCheckListener(JTextPane editorText1){
		editorText = editorText1;
	}
	public void actionPerformed(ActionEvent e){
		SpellChecker.enableShortKey(editorText, true);
		SpellChecker.showSpellCheckerDialog(editorText, null);
	}
}
