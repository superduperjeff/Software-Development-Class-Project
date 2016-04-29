import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.TabSet;
import javax.swing.text.TabStop;
import javax.swing.text.Highlighter.HighlightPainter;

class fontListener implements ActionListener
   {
	JPanel contents;
	   private JButton ALright;
	   private JButton ALleft;
	   private JButton ALcenter;
	   private JButton BOLD;
	   private JButton ITALIC;
	   private JButton UNDERLINE;
	   private JButton TABLE;
	   private JButton SEARCH;
	   private JButton SIZE;
	   private JButton SIZEUP;
	private static JTextPane editorText;
	private Highlighter highlighter;
	private HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.yellow);
	private JMenuItem sizeItem;
	
	   private JMenuItem size8;
	   private JMenuItem size9;
	   private JMenuItem size10;
	   private JMenuItem size11;
	   private JMenuItem size12;
	   private JMenuItem size24;
	   private JMenuItem size36;
	   private JMenuItem size72;
	   private JMenuItem size96;
	   
	   private JMenuItem alignmentItem;
	   private JMenuItem leftAlign;
	   private JMenuItem centerAlign;
	   private JMenuItem rightAlign;
	   
	   private JMenuItem monoItem;
	   private JMenuItem serifItem;
	   private JMenuItem sansSerifItem;
	   private JMenuItem timesNewRomanItem;
	   private JMenuItem arialItem;
	   private JMenuItem snapITCItem;
	   private JMenuItem helveticaItem;
	   private JMenuItem comicSansMSItem;
	   private JMenuItem fontItem;
	   
	   private JMenuItem colorItem;
	   private JMenuItem blackItem;
	   private JMenuItem blueItem;
	   private JMenuItem redItem;
	   private JMenuItem yellowItem;
	   private JMenuItem orangeItem;
	   private JMenuItem cyanItem;
	   private JMenuItem pinkItem;
	   private JMenuItem grayItem;
	   private JMenuItem greenItem;
	   private JMenuItem magentaItem;
	   
	   private JMenuItem italicItem;
	   private JMenuItem boldItem;
	   private JMenuItem underlineItem;
	   private JCheckBoxMenuItem showLeftList;
	   private JCheckBoxMenuItem showAnnotations;
	   private JCheckBoxMenuItem wordWrap;
	   private JMenuItem indentItem;
      public void actionPerformed(ActionEvent e)
      {
    	  
    	  if(e.getSource()== SEARCH) {
    		  highlighter = editorText.getHighlighter();
    		  JOptionPane search = new JOptionPane();
    		  String searchFor = search.showInputDialog("Enter what you would like to search for:");
    		  String currentText = editorText.getText();
    		  boolean searchMore =  true;
    		  if(currentText.contains(searchFor)) {
    			  int startSelect = currentText.indexOf(searchFor);
    			  int endSelect = startSelect + searchFor.length();
    			  
    			  try {
					highlighter.addHighlight(startSelect, endSelect, painter);
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
    			  
    			while(searchMore == true) {
    			int selectedOption = JOptionPane.showOptionDialog(null, "", "Search", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
    			if(selectedOption==JOptionPane.OK_OPTION) {
    				
    				if(currentText.substring(endSelect, currentText.length()).contains(searchFor)) {
    					selectedOption = JOptionPane.showOptionDialog(null, "", "Search", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
    					searchMore = true;
    					String restOf = currentText.substring(endSelect, currentText.length());
    					try {
    						startSelect = restOf.indexOf(searchFor);
    						endSelect = restOf.indexOf(searchFor) + searchFor.length();
							highlighter.addHighlight(startSelect, endSelect, painter);
							searchMore = false;
							highlighter.removeAllHighlights();
						} catch (BadLocationException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
    				} else {
    					highlighter.removeAllHighlights();
    					searchMore = false;
    				}
    			
    				
    			} else {
    				highlighter.removeAllHighlights();
    			}
    		}
    		  } else {
    			  JOptionPane.showMessageDialog(null, searchFor + " was not found!");
    		  }
    	  }
    	  
    	 if(e.getSource() == TABLE) {
    		 JTextField f1 = new JTextField();
    		 JTextField f2 = new JTextField();
    		 Object[] fields = {
    			"Enter amount of rows:", f1,
    			"Enter amount of columns:", f2
    			
    		 };
    		 
    		 
    		 JOptionPane.showConfirmDialog(null, fields, "Create new Table", JOptionPane.OK_CANCEL_OPTION);
    		 drawTable(Integer.parseInt(f1.getText()), Integer.parseInt(f2.getText()));
    		 
    	 }
    	 
         // Get the current font.
         Font textFont = editorText.getFont();

         // Retrieve the font name and size.
         String fontName = textFont.getName();
         int fontSize = textFont.getSize();
        

         // Start with plain style.
         int fontStyle = Font.PLAIN;
         
         if(e.getSource() == SIZE){
        	 fontSize = (fontSize - 2);
         }
         if(e.getSource()== SIZEUP){
        	 fontSize = (fontSize + 2);
         }

         
         // Determine which size font is selected.
         if(e.getSource() == size8){
        	 fontSize = 8;
         }
         if(e.getSource() == size9){
        	 fontSize = 9;
         }
         if(e.getSource() == size10){
        	 fontSize = 10;
         }
         if(e.getSource() == size11){
        	 fontSize = 11;
         }
         if(e.getSource() == size12){
        	 fontSize = 12;
         }
         if(e.getSource() == size24){
        	 fontSize = 24; 
         if(e.getSource() == size36){
             fontSize = 36;
          }
        if(e.getSource() == size72){
        	 fontSize = 72;
        }
        if(e.getSource() == size96){
        	 fontSize = 96; 
       }
         }
         
         
         if(e.getSource() == leftAlign){
        	 
        	 TabStop[] tab = new TabStop[1];
        	 tab[0] = new TabStop(0, TabStop.ALIGN_LEFT, TabStop.LEAD_NONE);
        	 TabSet tabset = new TabSet(tab);
        	 StyleContext sc = StyleContext.getDefaultStyleContext();
        	 AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.TabSet, tabset);
        	 editorText.setParagraphAttributes(aset, false);
        	 if (!editorText.getSelectedText().equals(null))
    			 editorText.replaceSelection("\t" + editorText.getSelectedText());
        	 
         }
        	 
        	 if(e.getSource() == ALleft){
            	 
            	 TabStop[] tab = new TabStop[1];
            	 tab[0] = new TabStop(0, TabStop.ALIGN_LEFT, TabStop.LEAD_NONE);
            	 TabSet tabset = new TabSet(tab);
            	 
            	 StyleContext sc = StyleContext.getDefaultStyleContext();
            	 AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.TabSet, tabset);
            	 editorText.setParagraphAttributes(aset, false);
            	 if (!editorText.getSelectedText().equals(null))
            			 editorText.replaceSelection("\t" + editorText.getSelectedText());
        	 
        	 /*StyledDocument doc = editorText.getStyledDocument();
        	 SimpleAttributeSet left = new SimpleAttributeSet();
        	 StyleConstants.setAlignment(left, StyleConstants.ALIGN_LEFT);
        	 doc.setParagraphAttributes(0, doc.getLength(), left, false);*/
        	 
         }
         
         if(e.getSource() == centerAlign){
        	 
        	 TabStop[] tab = new TabStop[1];
        	 tab[0] = new TabStop((contents.getWidth()/2), TabStop.ALIGN_CENTER, TabStop.LEAD_NONE);
        	 TabSet tabset = new TabSet(tab);
        	 
        	 StyleContext sc = StyleContext.getDefaultStyleContext();
        	 AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.TabSet, tabset);
        	 editorText.setParagraphAttributes(aset, false);
        	 if (!editorText.getSelectedText().equals(null))
        		 editorText.replaceSelection("\t" + editorText.getSelectedText());
        	 
        	 /*StyledDocument doc = editorText.getStyledDocument();
        	 SimpleAttributeSet center = new SimpleAttributeSet();
        	 StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        	 doc.setParagraphAttributes(0, doc.getLength(), center, false);*/
        	 
         }
         
         	if(e.getSource() == ALcenter){
        	 TabStop[] tab = new TabStop[1];
        	 tab[0] = new TabStop((contents.getWidth()/2), TabStop.ALIGN_CENTER, TabStop.LEAD_NONE);
        	 TabSet tabset = new TabSet(tab);
        	 
        	 StyleContext sc = StyleContext.getDefaultStyleContext();
        	 AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.TabSet, tabset);
        	 editorText.setParagraphAttributes(aset, false);
        	 if (!editorText.getSelectedText().equals(null))
        		 editorText.replaceSelection("\t" + editorText.getSelectedText());
        	 
        	 /*StyledDocument doc = editorText.getStyledDocument();
        	 SimpleAttributeSet center = new SimpleAttributeSet();
        	 StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        	 doc.setParagraphAttributes(0, doc.getLength(), center, false);*/
        	 
         }
         
         if(e.getSource() == rightAlign){
        	 
        	 TabStop[] tab = new TabStop[1];
        	 tab[0] = new TabStop(contents.getWidth(), TabStop.ALIGN_RIGHT, TabStop.LEAD_NONE);
        	 TabSet tabset = new TabSet(tab);
        	 
        	 StyleContext sc = StyleContext.getDefaultStyleContext();
        	 AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.TabSet, tabset);
        	 editorText.setParagraphAttributes(aset, false);
        	 if (!editorText.getSelectedText().equals(null))
        		 editorText.replaceSelection("\t" + editorText.getSelectedText());
        	 
        	 /*StyledDocument doc = editorText.getStyledDocument();
        	 SimpleAttributeSet right = new SimpleAttributeSet();
        	 StyleConstants.setAlignment(right, StyleConstants.ALIGN_RIGHT);
        	 doc.setParagraphAttributes(0, doc.getLength(), right, false);*/
        	 
         }
         
         	if(e.getSource() == ALright){
        	 
        	 TabStop[] tab = new TabStop[1];
        	 tab[0] = new TabStop(contents.getWidth(), TabStop.ALIGN_RIGHT, TabStop.LEAD_NONE);
        	 TabSet tabset = new TabSet(tab);
        	 
        	 StyleContext sc = StyleContext.getDefaultStyleContext();
        	 AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.TabSet, tabset);
        	 editorText.setParagraphAttributes(aset, false);
        	 if (!editorText.getSelectedText().equals(null))
        		 editorText.replaceSelection("\t" + editorText.getSelectedText());
        	 
        	 /*StyledDocument doc = editorText.getStyledDocument();
        	 SimpleAttributeSet right = new SimpleAttributeSet();
        	 StyleConstants.setAlignment(right, StyleConstants.ALIGN_RIGHT);
        	 doc.setParagraphAttributes(0, doc.getLength(), right, false);*/
        	 
         }
         
         @SuppressWarnings("unchecked")
		JComboBox<String> COLORCHG = (JComboBox<String>) e.getSource();

         Object selected = COLORCHG.getSelectedItem();
         
         if(selected.toString().equalsIgnoreCase("black"))
        	 editorText.setForeground(Color.BLACK);
     	editorText.setSelectedTextColor(Color.BLACK);
     	
          if(selected.toString().equalsIgnoreCase("blue"))
        	  editorText.setForeground(Color.BLUE);
      	editorText.setSelectedTextColor(Color.BLUE);
      	
        if(selected.toString().equalsIgnoreCase("red"))
      	  editorText.setForeground(Color.RED);
    	editorText.setSelectedTextColor(Color.RED);
    	
        if(selected.toString().equalsIgnoreCase("orange"))
      	  editorText.setForeground(Color.ORANGE);
    	editorText.setSelectedTextColor(Color.ORANGE);
    	
        if(selected.toString().equalsIgnoreCase("cyan"))
      	  editorText.setForeground(Color.CYAN);
    	editorText.setSelectedTextColor(Color.CYAN);
    	
        if(selected.toString().equalsIgnoreCase("magenta"))
      	  editorText.setForeground(Color.MAGENTA);
    	editorText.setSelectedTextColor(Color.MAGENTA);
    	
        if(selected.toString().equalsIgnoreCase("green"))
      	  editorText.setForeground(Color.GREEN);
    	editorText.setSelectedTextColor(Color.GREEN);
    	
        if(selected.toString().equalsIgnoreCase("gray"))
      	  editorText.setForeground(Color.GRAY);
    	editorText.setSelectedTextColor(Color.GRAY);
    	
        if(selected.toString().equalsIgnoreCase("pink"))
      	  editorText.setForeground(Color.PINK);
    	editorText.setSelectedTextColor(Color.PINK);
    	
    	if(selected.toString().equalsIgnoreCase("yellow"))
        	  editorText.setForeground(Color.YELLOW);
      	editorText.setSelectedTextColor(Color.YELLOW);
    	
        
      	
      	
         
         // Determine which font is selected.
         if (monoItem.isSelected())
            fontName = "Monospaced";
         else if (serifItem.isSelected())
            fontName = "Serif";
         else if (sansSerifItem.isSelected())
            fontName = "SansSerif";
         else if (timesNewRomanItem.isSelected())
        	 fontName = "Times New Roman";
         else if (comicSansMSItem.isSelected())
        	 fontName = "Comic Sans MS";
         else if (helveticaItem.isSelected())
        	 fontName = "Helvetica";
         else if (arialItem.isSelected())
        	 fontName = "Arial";
         else if (snapITCItem.isSelected())
        	 fontName = "Snap ITC";
         // Determine whether italic is selected.
         if (italicItem.isSelected())
            fontStyle += Font.ITALIC;

         // Determine whether bold is selected.
         if (boldItem.isSelected())
            fontStyle += Font.BOLD;
         
         if (underlineItem.isSelected())
         {
         //Help from StackOverFlow
        //added by Sean and Arland
        	 
         Map<TextAttribute, Integer> font = new HashMap<TextAttribute, Integer>();
         font.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
         
         }
         
         if (e.getSource() == indentItem)
         {
        	 if (editorText.getSelectedText().length() > 0)
        		 editorText.replaceSelection("\t" + editorText.getSelectedText());
         }
         
         if (e.getSource()== BOLD)
         {
        	 fontStyle += Font.BOLD;
         }
         if (e.getSource()== ITALIC)
         {
        	 fontStyle += Font.ITALIC;
         }
         if (e.getSource()== UNDERLINE)
         {
        	 fontStyle += Font.HANGING_BASELINE;
         }
         
         // Setting text to change color.
         
         if (e.getSource()==blackItem)
         {
        	editorText.setForeground(Color.BLACK);
        	editorText.setSelectedTextColor(Color.BLACK);
         }
         if(e.getSource() == "Black"){
        	 editorText.setForeground(Color.BLACK);
         	editorText.setSelectedTextColor(Color.BLACK);
         }
         
         if (e.getSource()==blueItem)
         {
        	editorText.setForeground(Color.BLUE);
        	editorText.setSelectedTextColor(Color.BLUE);
         }
         if (e.getSource()== "Blue")
         {
        	editorText.setForeground(Color.BLUE);
        	editorText.setSelectedTextColor(Color.BLUE);
         }
         
         if (e.getSource()==redItem)
         {
        	editorText.setForeground(Color.RED);
         	editorText.setSelectedTextColor(Color.RED);
        	 
         } 
         if (e.getSource()== "Red")
         {
        	editorText.setForeground(Color.RED);
         	editorText.setSelectedTextColor(Color.RED);
        	 
         } 
         
         if (e.getSource()==yellowItem)
         {
        	editorText.setForeground(Color.YELLOW);
         	editorText.setSelectedTextColor(Color.YELLOW);
         } 
         if (e.getSource()== "Yellow")
         {
        	editorText.setForeground(Color.YELLOW);
         	editorText.setSelectedTextColor(Color.YELLOW);
         } 
         
         if (e.getSource()==cyanItem)
         {
        	editorText.setForeground(Color.CYAN);
         	editorText.setSelectedTextColor(Color.CYAN);
         }
         if (e.getSource()== "Cyan")
         {
        	editorText.setForeground(Color.CYAN);
         	editorText.setSelectedTextColor(Color.CYAN);
         }
         
         if (e.getSource()==orangeItem)
         {
        	editorText.setForeground(Color.ORANGE);
         	editorText.setSelectedTextColor(Color.ORANGE);
         }
         if (e.getSource()== "Orange")
         {
        	editorText.setForeground(Color.ORANGE);
         	editorText.setSelectedTextColor(Color.ORANGE);
         }
         
         if (e.getSource()==pinkItem)
         {
        	editorText.setForeground(Color.PINK);
         	editorText.setSelectedTextColor(Color.PINK);
         }
         if (e.getSource()== "Pink")
         {
        	editorText.setForeground(Color.PINK);
         	editorText.setSelectedTextColor(Color.PINK);
         }
         
         if (e.getSource()==greenItem)
         {
        	editorText.setForeground(Color.GREEN);
         	editorText.setSelectedTextColor(Color.GREEN);
         }
         
         if (e.getSource()== "Green")
         {
        	editorText.setForeground(Color.GREEN);
         	editorText.setSelectedTextColor(Color.GREEN);
         }
        	 
         if (e.getSource()==grayItem)
         {
        	editorText.setForeground(Color.GRAY);
         	editorText.setSelectedTextColor(Color.GRAY);
         }
         if (e.getSource()== "Gray")
         {
        	editorText.setForeground(Color.GRAY);
         	editorText.setSelectedTextColor(Color.GRAY);
         }
         
         if (e.getSource()==magentaItem)
         {
        	editorText.setForeground(Color.MAGENTA);
         	editorText.setSelectedTextColor(Color.MAGENTA);
         }
         
         if (e.getSource()== "Magenta")
         {
        	editorText.setForeground(Color.MAGENTA);
         	editorText.setSelectedTextColor(Color.MAGENTA);
         }
        	 
         // Set the font as selected.
         editorText.setFont(new Font(fontName, 
                                fontStyle, fontSize));
      }
   }
