import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import com.inet.jortho.SpellChecker;

class redLineListener implements ActionListener
{
	private JCheckBoxMenuItem RedUnderline;
	private static JTextPane editorText;

	public redLineListener(JCheckBoxMenuItem RedUnderline1, JTextPane editorText1){
		RedUnderline = RedUnderline1;
		editorText = editorText1;
	}
	public void actionPerformed(ActionEvent e){
		if (RedUnderline.isSelected() == true){
			System.out.println("true");
			SpellChecker.enableAutoSpell(editorText, true);
		}else{
			System.out.println("falase");
			SpellChecker.enableAutoSpell(editorText, false);
		}
	}
}
