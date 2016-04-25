import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.TabSet;
import javax.swing.text.TabStop;


public class Alignment {

	public static JTextPane setAlignment(String align, JTextPane editorText){
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset;
        if(align.equals("left")){
       	 
       	 TabStop[] tab = new TabStop[1];
       	 tab[0] = new TabStop(0, TabStop.ALIGN_LEFT, TabStop.LEAD_NONE);

       	 TabSet tabset = new TabSet(tab);
       	 //StyleContext sc = StyleContext.getDefaultStyleContext();
       	 /*AttributeSet*/ aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.TabSet, tabset);
       	 editorText.setParagraphAttributes(aset, false);
       	 if (!editorText.getSelectedText().equals(null))

   			editorText.replaceSelection("\t" + editorText.getSelectedText());

        }

        if(align.equals("center")){
       	 
       	 TabStop[] tab = new TabStop[1];
       	 tab[0] = new TabStop((contents.getWidth()/2), TabStop.ALIGN_CENTER, TabStop.LEAD_NONE);
       	 TabSet tabset = new TabSet(tab);
       	 
       	// /*StyleContext*/ sc = StyleContext.getDefaultStyleContext();
       	 /*AttributeSet*/ aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.TabSet, tabset);
       	 editorText.setParagraphAttributes(aset, false);
       	 if (!editorText.getSelectedText().equals(null))
   		 	 editorText.replaceSelection(editorText.getSelectedText().substring(1));

       		 editorText.replaceSelection("\t" + editorText.getSelectedText());
       	 
       	 /*StyledDocument doc = editorText.getStyledDocument();
       	 SimpleAttributeSet center = new SimpleAttributeSet();
       	 StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
       	 doc.setParagraphAttributes(0, doc.getLength(), center, false);*/
       	 
        }

        
        if(align.equals("right")){
       	 
       	 TabStop[] tab = new TabStop[1];
       	 tab[0] = new TabStop(contents.getWidth(), TabStop.ALIGN_RIGHT, TabStop.LEAD_NONE);
       	 TabSet tabset = new TabSet(tab);
       	 
       //	 /*StyleContext*/ sc = StyleContext.getDefaultStyleContext();
       	 /*AttributeSet*/ aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.TabSet, tabset);
       	 editorText.setParagraphAttributes(aset, false);
       	 if (!editorText.getSelectedText().equals(null))
       		 editorText.replaceSelection("\t" + editorText.getSelectedText());
       	 
       	 /*StyledDocument doc = editorText.getStyledDocument();
       	 SimpleAttributeSet right = new SimpleAttributeSet();
       	 StyleConstants.setAlignment(right, StyleConstants.ALIGN_RIGHT);
       	 doc.setParagraphAttributes(0, doc.getLength(), right, false);*/
       	 
        }
        
        return editorText;
	}
}
