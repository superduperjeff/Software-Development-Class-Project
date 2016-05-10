import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

class textFormatListener implements ActionListener {
	private JCheckBoxMenuItem showAnnotations;
	private JCheckBoxMenuItem wordWrap;
	private boolean wrapped;
	private static JTextPane editorText;
	JScrollPane scrollPane;
	JPanel noWrapPanel;

	public textFormatListener(JTextPane editorText1,
			JCheckBoxMenuItem showAnnotations1, JCheckBoxMenuItem wordWrap1,
			boolean wrapped1, JPanel noWrapPanel1, JScrollPane scrollPane1) {
		editorText = editorText1;
		showAnnotations = showAnnotations1;
		wordWrap = wordWrap1;
		wrapped = wrapped1;
		scrollPane = scrollPane1;
		noWrapPanel = noWrapPanel1;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Word Wrap")) {
			if (wordWrap.isSelected())
				wrapped = true;
			else {
				wrapped = false;
			}
			wordWrap();
		} else if (e.getActionCommand().equals("Show Annotations")) {

			if (showAnnotations.isSelected()) {
				System.out.println("Show Annotations");
				hideAnnotations(false);
			} else {

				hideAnnotations(true);
				System.out.println("Hide Annotations");
			}

		}
	}

	public void wordWrap() {
		if (wrapped == true) {
			scrollPane.setViewportView(editorText);

		} else {
			scrollPane.setViewportView(noWrapPanel);
			noWrapPanel.add(editorText);

		}
	}

	public void hideAnnotations(boolean hide) {
		String text = editorText.getText();
		Pattern pattern = Pattern.compile("<.*?>");

		// search for a match within a string
		Matcher matcher = pattern.matcher(text);
		// check all occurance
		while (matcher.find()) {

			setInvisible(matcher.start(), matcher.end(), hide);

		}
	}

	public void setInvisible(int start, int end, boolean hide) {

		if (hide) {
			StyledDocument doc = editorText.getStyledDocument();
			Style regular = StyleContext.getDefaultStyleContext().getStyle(
					StyleContext.DEFAULT_STYLE);
			Style invisible = editorText.getStyledDocument().addStyle(
					"invisible", regular);
			StyleConstants.setFontSize(invisible, 0);
			StyleConstants.setForeground(invisible, editorText.getBackground());
			doc.setCharacterAttributes(start, end - start, invisible, false);
		} else {
			System.out.println("show it");
			StyledDocument doc = editorText.getStyledDocument();
			Style plain = StyleContext.getDefaultStyleContext().getStyle(
					StyleContext.DEFAULT_STYLE);
			StyleConstants.setFontSize(plain, 12);
			StyleConstants.setForeground(plain, editorText.getForeground());
			doc.setCharacterAttributes(start, end - start, plain, false);
		}
	}
}