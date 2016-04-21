import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.MenuBar;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;
import javax.swing.text.JTextComponent;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.TabSet;
import javax.swing.text.TabStop;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

import java.awt.print.PrinterException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.*;

import java.text.MessageFormat;
























import javax.xml.transform.Source;








import javax.xml.transform.Source;
import javax.xml.transform.Source;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

































import com.inet.jortho.FileUserDictionary;
import com.inet.jortho.SpellChecker;
import com.sun.java.swing.plaf.windows.resources.windows;

/**
   The TextEditor class is a simple text editor.
*/

public class TextEditor extends JFrame
{
   /**
	 * 
	 */
		private static final long serialVersionUID = 1L;
	 /**
	 	 * 
	 	 */

// The following are fields for the menu system.
   // First, the menu bar
   private JMenuBar menuBar;
   private JToolBar toolBar;
   JPanel contents;
   
   //save name
   private String name = "new document";
   private File recentDirectory = null;
   
   // The menus
   private JMenu fileMenu;
   private JMenu viewMenu;
   private JMenu textMenu;
   private JMenu imageMenu;
   private JMenu webMenu;
   private JMenu SpellCheckMenu;
   private JMenu themeMenu;
   
   private JButton BOLD;
   private JButton ITALIC;
   private JButton UNDERLINE;
   private JButton TABLE;
   private JButton SEARCH;
   private JButton SIZE;
   private JButton SIZEUP;
   private JButton ALright;
   private JButton ALleft;
   private JButton ALcenter;
   private JComboBox<String> COLORCHG;

   private Highlighter highlighter;
   private HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.yellow);
   
   private	JPopupMenu	popupMenu;
   private JPanel		topPanel;
   private JLabel label = new JLabel();
   private JLabel webLabel = new JLabel();
   private JLabel webTextLabel = new JLabel();
   private JLabel imageLabel = new JLabel();
   private ImageIcon image;
   private boolean wrapped=false;
   // The menu items
   private JMenuItem newItem;
   private JMenuItem newOntology;
   private JMenuItem openItem;
   private JMenuItem openList;
   private JMenuItem printItem;
   private JMenuItem saveItem;
   private JMenuItem saveAsItem;
   private JMenuItem exitItem;
   private JMenuItem imageOpenItem;
   private JMenuItem imageToolsItem;
   private JMenuItem webOpenItem;
  
   private JMenuItem webToolsItem;
   private JMenuItem webTextItem;

   //Edit Menu items
   private JMenuItem editMenu;
   private JMenuItem cutItem;
   private JMenuItem pasteItem;
   private JMenuItem copyItem;
   private JMenuItem wordCount;	
   
   //Theme Menu Items
   private JMenuItem midnightTheme;
   private JMenuItem skyTheme;
   private JMenuItem greenTheme;
   private JMenuItem fireTheme;
   private JMenuItem swampTheme;
   private JMenuItem defaultTheme;
   private Color defaultColor;
 
   // Different font sizes
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
   
   //Alignment
   private JMenuItem alignmentItem;
   private JMenuItem leftAlign;
   private JMenuItem centerAlign;
   private JMenuItem rightAlign;
   
   // The radio button menu items
   private JMenuItem monoItem;
   private JMenuItem serifItem;
   private JMenuItem sansSerifItem;
   private JMenuItem timesNewRomanItem;
   private JMenuItem arialItem;
   private JMenuItem snapITCItem;
   private JMenuItem helveticaItem;
   private JMenuItem comicSansMSItem;
   private JMenuItem fontItem;
   
   //Color Items
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
   
   //Spell Check Menu
   private JMenuItem SpellCheck;
   private JCheckBoxMenuItem RedUnderline;

   // The checkbox menu items
   private JMenuItem italicItem;
   private JMenuItem boldItem;
   private JMenuItem underlineItem;
   private JCheckBoxMenuItem showLeftList;
   private JCheckBoxMenuItem showAnnotations;
   private JCheckBoxMenuItem wordWrap;
   private JMenuItem indentItem;
   
   BufferedImage buffImg;
   ImageIcon icon = new ImageIcon();
   String filename;     // To hold the file name
   private static JTextPane editorText;// To display the text
   private JTree leftList;
   
   // Map that contains all of the opened ontologies, the key is the name of the root node
   HashMap<String, String> openedOntologies = new HashMap<String, String>();
  
   JScrollPane scrollPane ;
   JPanel noWrapPanel;
   JPanel ontologyPanel; // panel for ontologies
   /**
      Constructor
   */

   public TextEditor()
   {
      // Set the title.
      setTitle("Text Editor");
this.setPreferredSize(new Dimension(800,800));
      // Specify what happens when the close
      // button is clicked.
     
	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	
      // Create the text area.
      editorText = new JTextPane();
      
      //Create ODF Document
      //OdfTextDocument odt  = OdfTextDocument.newTextDocument();
      

      // Create a scroll pane and add the text area to it.
      noWrapPanel = new JPanel( new BorderLayout() );
      noWrapPanel.add( editorText );
      scrollPane = new JScrollPane( noWrapPanel );
      
      // scrollPane = new JScrollPane(editorText);
       contents= new JPanel();
       contents.setOpaque(true);
       contents.setLayout(new BorderLayout());
       contents.add(scrollPane, BorderLayout.CENTER);
       
       // Add ontology pane to the content pane
       ontologyPanel = new JPanel();
       ontologyPanel.setLayout(new BoxLayout(ontologyPanel, BoxLayout.Y_AXIS));
       ontologyPanel.setBackground(Color.LIGHT_GRAY);
       contents.add(ontologyPanel, BorderLayout.WEST);

      // Add the scroll pane to the content pane.
      add(contents);
      

      // Build the menu bar.
      buildMenuBar();
      buildToolBar();
      contents.add(toolBar, BorderLayout.PAGE_START);
      
      
    
      // Pack and display the window.
      pack();
      setVisible(true);
      
   }

public void wordWrap(){
	if (wrapped == true){        
        scrollPane.setViewportView(editorText);
       
    }else {
    	scrollPane.setViewportView(noWrapPanel);
        noWrapPanel.add(editorText); 
   
    }
}
   /**
    * Apply an annotation to the selected text
    */
   

public void applyAnnotation(String value,Color c, int start, int end){
	
	   StyledDocument doc = editorText.getStyledDocument();
	   
	    if (start == end) { // No selection, cursor position.
	        return;
	    }
	    if (start > end) { // Backwards selection?
	        int life = start;
	        start = end;
	        end = life;
	    }
	   
	    Style style = editorText.addStyle("annotated", null);
	    StyleConstants.setForeground(style, c);
	    doc.setCharacterAttributes(start, end - start, style, false);
	    try {
	    	doc.insertString(end, "</"+value+">",null);
			doc.insertString(start, "<"+value+">",null);
			
		} catch (BadLocationException e) {
			
			e.printStackTrace();
		}
	    StyleConstants.setForeground(style, Color.black);
}

   public void applyAnnotation(String value,Color c){
	
	   StyledDocument doc = editorText.getStyledDocument();
	    int start = editorText.getSelectionStart();
	    int end = editorText.getSelectionEnd();
	   
	    if (start == end) { // No selection, cursor position.
	        return;
	    }
	    if (start > end) { // Backwards selection?
	        int life = start;
	        start = end;
	        end = life;
	    }
	   
	    Style style = editorText.addStyle("annotated", null);
	    StyleConstants.setForeground(style, c);
	    doc.setCharacterAttributes(start, end - start, style, false);
	    try {
	    	doc.insertString(end, "</"+value+">",null);
			doc.insertString(start, "<"+value+">",null);
			
		} catch (BadLocationException e) {
			
			e.printStackTrace();
		}
	    StyleConstants.setForeground(style, Color.black);
   }
   public void hideAnnotations(boolean hide){
	   String text =editorText.getText();
	   Pattern pattern = Pattern.compile("<.*?>");
	 

	// search for a match within a string
	   Matcher matcher = pattern.matcher(text);
	    // check all occurance
	    while (matcher.find()) {
	      
	      setInvisible(matcher.start(),matcher.end(),hide);
	      
	    }
   }
   /*
    * Set selected text invisible
    */
   public void setInvisible(int start,int end,boolean hide){
	   
	   
	    if(hide){
	    	StyledDocument doc = editorText.getStyledDocument();
	 	   Style regular = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
	    	 Style invisible = editorText.getStyledDocument().addStyle("invisible", regular);
	 	    StyleConstants.setFontSize(invisible, 0);
	 	    StyleConstants.setForeground(invisible, editorText.getBackground());
	    doc.setCharacterAttributes(start, end - start, invisible, false);
	    }
	    else{	  
	    	System.out.println("show it");
	    	StyledDocument doc = editorText.getStyledDocument();
		 	   Style plain = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
		 	  StyleConstants.setFontSize(plain, 12);
		 	    StyleConstants.setForeground(plain, editorText.getForeground());
	    	doc.setCharacterAttributes(start, end - start, plain, false);	
	    }
   }
   /**
      The buildMenuBar method creates a menu bar and
      calls the createFileMenu method to create the
      file menu.
   */

   private void buildMenuBar()
   {
      // Build the file and font menus.
      buildFileMenu();
      buildEditMenu();
      buildFontMenu();
      buildViewMenu();
      buildImageMenu();
      buildWebMenu();
      buildSpellCheckMenu();
    
      // Create the menu bar.
      menuBar = new JMenuBar();
           
      // Add the file and font menus to the menu bar.
      menuBar.add(fileMenu);
      menuBar.add(editMenu);
      menuBar.add(textMenu);
      menuBar.add(viewMenu);
      menuBar.add(imageMenu);
      menuBar.add(webMenu);
      menuBar.add(SpellCheckMenu);
      
      // Set the menu bar for this frame.
      setJMenuBar(menuBar);
      defaultColor = menuBar.getBackground();
     
   }
   

   private void buildToolBar()
   {
	   // Create the tool bar.
	   toolBar = new JToolBar();
	   toolBar.setLocation(0,0);
	   
	   Icon tableIcon = new ImageIcon("./resources/tableicon.png");
	   Icon searchIcon = new ImageIcon("./resources/searchicon.png");
	   Icon SIZEicon = new ImageIcon("./resources/uppercase1.png");
	   Icon UNDERLINEicon = new ImageIcon("./resources/underline4.png");
	   Icon SIZEUPicon = new ImageIcon("./resources/uppercase2.png");
	   Icon ALrightIcon = new ImageIcon("./resources/align5.png");
	   Icon ALleftIcon = new ImageIcon("./resources/align6.png");
	   Icon ALcenterIcon = new ImageIcon("./resources/align4.png");
	   

      // Add the buttons to menuBar2
	   BOLD = new JButton("B");
	   BOLD.setToolTipText("Bold");
	   BOLD.addActionListener(new FontListener());
	   BOLD.addActionListener(new StyledEditorKit.BoldAction());
	   
	   ITALIC = new JButton("I");
	   ITALIC.setToolTipText("Italic");
	   ITALIC.addActionListener(new FontListener());
	   ITALIC.addActionListener(new StyledEditorKit.ItalicAction());
	   
	   UNDERLINE = new JButton("U");
	   UNDERLINE.setToolTipText("Underline");
	   UNDERLINE.addActionListener(new FontListener()); 
	   UNDERLINE.addActionListener(new StyledEditorKit.UnderlineAction());
	   
	   TABLE = new JButton();
	   TABLE.setIcon(tableIcon);
	   TABLE.setToolTipText("Create a table");
	   TABLE.addActionListener(new FontListener());
	   
	   SEARCH = new JButton();
	   SEARCH.setIcon(searchIcon);
	   SEARCH.setToolTipText("Search");
	   SEARCH.addActionListener(new FontListener());
	   
	   SIZE = new JButton();
	   SIZE.setIcon(SIZEicon);
	   SIZE.setToolTipText("Size");
	   SIZE.addActionListener(new FontListener());
	   
	   SIZEUP = new JButton();
	   SIZEUP.setIcon(SIZEUPicon);
	   SIZEUP.setToolTipText("Size Up");
	   SIZEUP.addActionListener(new FontListener());
	   
	   ALleft = new JButton();
	   ALleft.setToolTipText("Align Left");
	   ALleft.setIcon(ALleftIcon);
	   ALleft.addActionListener(new FontListener());
	   
	   ALcenter = new JButton();
	   ALcenter.setToolTipText("Align Center");
	   ALcenter.setIcon(ALcenterIcon);
	   ALcenter.addActionListener(new FontListener());
	   
	   ALright = new JButton();
	   ALright.setToolTipText("Align Right");
	   ALright.setIcon(ALrightIcon);
	   ALright.addActionListener(new FontListener());
	   
	   COLORCHG = new JComboBox<String>();
	   COLORCHG.addItem("Black");
	   COLORCHG.addItem("Blue");
	   COLORCHG.addItem("Green");
	   COLORCHG.addItem("Yellow");
	   COLORCHG.addItem("Orange");
	   COLORCHG.addItem("Cyan");
	   COLORCHG.addItem("Pink");
	   COLORCHG.addItem("Gray");
	   COLORCHG.addItem("Magenta");
	   COLORCHG.addActionListener(new FontListener());
	   

	   
	   

	   toolBar.add(BOLD);
	   toolBar.add(ITALIC);
	   toolBar.add(UNDERLINE);
	   toolBar.add(TABLE);
	   toolBar.add(SEARCH);
	   toolBar.add(SIZE);
	   toolBar.add(SIZEUP);
	   toolBar.add(COLORCHG);
	   toolBar.add(ALleft);
	   toolBar.add(ALcenter);
	   toolBar.add(ALright);
   }

   private void buildViewMenu(){
	      // Create the Italic menu item.
	      showLeftList = new JCheckBoxMenuItem("Show Ontology");
	      showLeftList.setMnemonic(KeyEvent.VK_S);
	      showLeftList.setSelected(true);
	      showLeftList.addActionListener(new ListListener());
	      
	      wordWrap = new JCheckBoxMenuItem("Word Wrap");
	      wordWrap.setMnemonic(KeyEvent.VK_W);
	      wordWrap.setSelected(false);
	      wordWrap.addActionListener(new TextFormatListener());
	      
	      showAnnotations = new JCheckBoxMenuItem("Show Annotations");
	      showAnnotations.setMnemonic(KeyEvent.VK_S);
	      showAnnotations.setSelected(true);
	      showAnnotations.addActionListener(new TextFormatListener());
	      
	      wordCount = new JMenuItem("Word Count");
	      wordCount.setMnemonic(KeyEvent.VK_S);
	      wordCountPopupListener popup = new wordCountPopupListener(contents);
	      wordCount.addActionListener(popup);

	      //Create Theme menu options
	      themeMenu = new JMenu("Change Theme");
	      themeMenu.setMnemonic(KeyEvent.VK_C);
	      
	      midnightTheme = new JMenuItem("Midnight");
	      midnightTheme.setMnemonic(KeyEvent.VK_M);
	      listListener colorTheme = new listListener();
	      midnightTheme.addActionListener(colorTheme);
	      
	      skyTheme  = new JMenuItem("Sky");
	      skyTheme.setMnemonic(KeyEvent.VK_S);
	      skyTheme.addActionListener(new ListListener());
	      
	      greenTheme = new JMenuItem("Spring");
	      greenTheme.setMnemonic(KeyEvent.VK_S);
	      greenTheme.addActionListener(new ListListener());
	      
	      fireTheme = new JMenuItem("Fire");
	      fireTheme.setMnemonic(KeyEvent.VK_F);
	      fireTheme.addActionListener(new ListListener());

	      swampTheme = new JMenuItem("Swamp");
	      swampTheme.setMnemonic(KeyEvent.VK_S);
	      swampTheme.addActionListener(new ListListener());
	      
	      defaultTheme = new JMenuItem("Default");
	      defaultTheme.setMnemonic(KeyEvent.VK_D);
	      defaultTheme.addActionListener(new ListListener());

	      
	      themeMenu.add(midnightTheme);
	      themeMenu.add(skyTheme);
	      themeMenu.add(greenTheme);
	      themeMenu.add(fireTheme);
	      themeMenu.add(swampTheme);
	      themeMenu.add(defaultTheme);
	      
	      // Create a menu for the items we just created.
	      viewMenu = new JMenu("View");
	      viewMenu.setMnemonic(KeyEvent.VK_V);
	      viewMenu.add(wordCount);
	      viewMenu.add(showLeftList);
	      viewMenu.add(wordWrap);
	      viewMenu.add(showAnnotations);
	      viewMenu.add(themeMenu);
   }
   /**
      The buildFileMenu method creates the file menu
      and populates it with its menu items.
   */

   private void buildFileMenu()
   {
	   addWindowListener(new WindowHandler());
	   
      // Create the New menu item.
      newItem = new JMenuItem("New");
      newItem.setMnemonic(KeyEvent.VK_N);
      newItem.addActionListener(new NewListener());
      
      // Create the New Ontology menu item.
      newOntology = new JMenuItem("New Ontology");
      newOntology.setMnemonic(KeyEvent.VK_N);
      newOntology.addActionListener(new NewListener());

      // Create the Open menu item.
      openItem = new JMenuItem("Open File");
      openItem.setAccelerator(KeyStroke.getKeyStroke('O', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));    //help from StackOverflow
      openItem.setMnemonic(KeyEvent.VK_O);
      openItem.addActionListener(new OpenListener());

      // Create the Open menu item.
      openList = new JMenuItem("Open Ontology");
      openList.setAccelerator(KeyStroke.getKeyStroke('O', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
      openList.setMnemonic(KeyEvent.VK_O);
      openList.addActionListener(new OpenListListener());
      
      // Create the Print menu item.
      printItem = new JMenuItem("Print");
      printItem.setAccelerator(KeyStroke.getKeyStroke('P', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
      printItem.setMnemonic(KeyEvent.VK_P);
      printItem.addActionListener(new PrintListener());
      
      // Create the Save menu item.
      saveItem = new JMenuItem("Save");
      saveItem.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
      saveItem.setMnemonic(KeyEvent.VK_S);
      saveItem.addActionListener(new SaveListener());

      // Create the Save As menu item.
      saveAsItem = new JMenuItem("Save As");
      saveAsItem.setAccelerator(KeyStroke.getKeyStroke("F12"));
      saveAsItem.setMnemonic(KeyEvent.VK_F12);
      saveAsItem.addActionListener(new SaveListener());

      // Create the Exit menu item.
      exitItem = new JMenuItem("Exit");
      exitItem.setAccelerator(KeyStroke.getKeyStroke('E', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
      exitItem.setMnemonic(KeyEvent.VK_E);
      exitListener closeProgram = new exitListener();
      exitItem.addActionListener(closeProgram);

      // Create a menu for the items we just created.
      fileMenu = new JMenu("File");
      fileMenu.setMnemonic(KeyEvent.VK_F);

      // Add the items and some separator bars to the menu.
      fileMenu.add(newItem);
      fileMenu.add(newOntology);
      fileMenu.add(openItem);
      fileMenu.add(openList);
      fileMenu.add(printItem);
      fileMenu.addSeparator();// Separator bar
      fileMenu.add(saveItem);
      fileMenu.add(saveAsItem);
      fileMenu.addSeparator();// Separator bar
      fileMenu.add(exitItem);
   }

   /**
      The buildFontMenu method creates the font menu
         and populates it with its menu items.
   */
   


   private void buildFontMenu()
   {

	   fontItem = new JMenu("Font");
	   fontItem.setMnemonic(KeyEvent.VK_F);
      // Create the Monospaced menu item.
      monoItem = new JMenuItem("Monospaced");
      monoItem.setMnemonic(KeyEvent.VK_M);
      monoItem.addActionListener(new FontListener());
      monoItem.addActionListener(new StyledEditorKit.FontFamilyAction("Monospaced", "Monospaced")); //Arland
      // Create the Serif menu item.
      serifItem = new JMenuItem("Serif");
      serifItem.setMnemonic(KeyEvent.VK_S);
      serifItem.addActionListener(new FontListener());
      serifItem.addActionListener(new StyledEditorKit.FontFamilyAction("Serif", "Serif")); //Arland
      // Create the SansSerif menu item.
      sansSerifItem = new JMenuItem("SansSerif");
      sansSerifItem.setMnemonic(KeyEvent.VK_S);
      sansSerifItem.addActionListener(new FontListener());
      sansSerifItem.addActionListener(new StyledEditorKit.FontFamilyAction("SansSerif", "SansSerif")); //Arland
      // Create the Comic Sans MS menu item.
      comicSansMSItem = new JMenuItem("Comic Sans MS");
      comicSansMSItem.setMnemonic(KeyEvent.VK_C);
      comicSansMSItem.addActionListener(new FontListener());
      comicSansMSItem.addActionListener(new StyledEditorKit.FontFamilyAction("Comic Sans MS", "Comic Sans MS")); //Arland
      // Create the Times New Roman menu item.
      timesNewRomanItem = new JMenuItem("Times New Roman");
      timesNewRomanItem.setMnemonic(KeyEvent.VK_T);
      timesNewRomanItem.addActionListener(new FontListener());
      timesNewRomanItem.addActionListener(new StyledEditorKit.FontFamilyAction("Times New Roman", "Times New Roman")); //Arland
      // Create the Helvetica menu item.
      helveticaItem = new JMenuItem("Helvetica");
      helveticaItem.setMnemonic(KeyEvent.VK_H);
      helveticaItem.addActionListener(new FontListener());
      helveticaItem.addActionListener(new StyledEditorKit.FontFamilyAction("Helvetica", "Helvetica")); //Arland
      // Create the Arial menu item.
      arialItem = new JMenuItem("Arial");
      arialItem.setMnemonic(KeyEvent.VK_A);
      arialItem.addActionListener(new FontListener());
      arialItem.addActionListener(new StyledEditorKit.FontFamilyAction("Arial", "Arial")); //Arland
      // Create the Snap ITC menu item.
      snapITCItem = new JMenuItem("Snap ITC");
      snapITCItem.setMnemonic(KeyEvent.VK_S);
      snapITCItem.addActionListener(new FontListener());
      snapITCItem.addActionListener(new StyledEditorKit.FontFamilyAction("Snap ITC", "Snap ITC")); //Arland
      
      // Group the menu items.
      fontItem.add(arialItem);
      fontItem.add(comicSansMSItem);
      fontItem.add(helveticaItem);
      fontItem.add(monoItem);
      fontItem.add(sansSerifItem);
      fontItem.add(serifItem);
      fontItem.add(snapITCItem);
      fontItem.add(timesNewRomanItem);

      // Create the Italic menu item.
      italicItem = new JMenuItem("Italic");
      italicItem.setMnemonic(KeyEvent.VK_I);
      italicItem.addActionListener(new FontListener());
      italicItem.addActionListener(new StyledEditorKit.ItalicAction()); //added by Sean and Arland

      // Create the Bold menu item.
      boldItem = new JMenuItem("Bold");
      boldItem.setMnemonic(KeyEvent.VK_B);
      boldItem.addActionListener(new FontListener());
      boldItem.addActionListener(new StyledEditorKit.BoldAction()); //added by Sean and Arland
      
      // Create the Underline menu item
      underlineItem = new JMenuItem("Underline"); //added by Sean and Arland
      underlineItem.setMnemonic(KeyEvent.VK_U);
      underlineItem.addActionListener(new FontListener()); //added by Sean and Arland
      underlineItem.addActionListener(new StyledEditorKit.UnderlineAction()); //added by Sean and Arland
      
      // Create the Indent menu items
      indentItem = new JMenuItem("Indent");
      indentItem.setMnemonic(KeyEvent.VK_I);
      indentItem.addActionListener(new FontListener());
      
      
      // Create the Size menu items
      sizeItem = new JMenu("Size");   
      sizeItem.setMnemonic(KeyEvent.VK_S);
      size8 = new JMenuItem("8");
      size8.addActionListener((new StyledEditorKit.FontSizeAction("8", 8))); //added by Sean and Arland
      size9 = new JMenuItem("9");
      size9.addActionListener((new StyledEditorKit.FontSizeAction("9", 9))); //added by Sean and Arland
      size10 = new JMenuItem("10");
      size10.addActionListener((new StyledEditorKit.FontSizeAction("10", 10))); //added by Sean and Arland
      size11 = new JMenuItem("11");
      size11.addActionListener((new StyledEditorKit.FontSizeAction("11", 11))); //added by Sean and Arland
      size12 = new JMenuItem("12");
      size12.addActionListener((new StyledEditorKit.FontSizeAction("12", 12))); //added by Sean and Arland
      size24 = new JMenuItem("24");
      size24.addActionListener((new StyledEditorKit.FontSizeAction("24", 24))); //added by Sean and Arland
      size36 = new JMenuItem("36");
      size36.addActionListener((new StyledEditorKit.FontSizeAction("36", 36))); 
      size72 = new JMenuItem("72");
      size72.addActionListener((new StyledEditorKit.FontSizeAction("72", 72))); 
      size96 = new JMenuItem("96");
      size96.addActionListener((new StyledEditorKit.FontSizeAction("96", 96)));
      
      sizeItem.add(size8);
      sizeItem.add(size9);
      sizeItem.add(size10);
      sizeItem.add(size11);
      sizeItem.add(size12);
      sizeItem.add(size24);
      sizeItem.add(size36); 
      sizeItem.add(size72);
      sizeItem.add(size96);
      
      //Alignment Menu
      alignmentItem = new JMenu("Alignment"); 
      alignmentItem.setMnemonic(KeyEvent.VK_A);
      
      leftAlign = new JMenuItem("Left"); 
      leftAlign.setMnemonic(KeyEvent.VK_L);
      leftAlign.addActionListener(new FontListener());
      
      centerAlign = new JMenuItem("Center");
      centerAlign.setMnemonic(KeyEvent.VK_C);
      centerAlign.addActionListener(new FontListener());
      
      rightAlign = new JMenuItem("Right"); 
      rightAlign.setMnemonic(KeyEvent.VK_R);
      rightAlign.addActionListener(new FontListener());
      
      alignmentItem.add(leftAlign);
      alignmentItem.add(centerAlign);
      alignmentItem.add(rightAlign);
      
      //Color Menu
      
      colorItem = new JMenu("Color");
      colorItem.setMnemonic(KeyEvent.VK_C);
      
      blackItem = new JMenuItem("Black");
      blackItem.setMnemonic(KeyEvent.VK_B);
      blackItem.addActionListener(new FontListener());
      
      blueItem = new JMenuItem("Blue"); 
      blueItem.setMnemonic(KeyEvent.VK_B);
      blueItem.addActionListener(new FontListener());
      
      redItem = new JMenuItem("Red");
      redItem.setMnemonic(KeyEvent.VK_R);
      redItem.addActionListener(new FontListener());
      
      orangeItem = new JMenuItem("Orange");
      orangeItem.setMnemonic(KeyEvent.VK_O);
      orangeItem.addActionListener(new FontListener());
      
      pinkItem = new JMenuItem("Pink");
      pinkItem.setMnemonic(KeyEvent.VK_P);
      pinkItem.addActionListener(new FontListener());
      
      cyanItem = new JMenuItem("Cyan");
      cyanItem.setMnemonic(KeyEvent.VK_C);
      cyanItem.addActionListener(new FontListener());
      
      yellowItem = new JMenuItem("Yellow");
      yellowItem.setMnemonic(KeyEvent.VK_Y);
      yellowItem.addActionListener(new FontListener());
      
      grayItem = new JMenuItem("Gray");
      grayItem.setMnemonic(KeyEvent.VK_G);
      grayItem.addActionListener(new FontListener());
      
      greenItem = new JMenuItem("Green");
      greenItem.setMnemonic(KeyEvent.VK_G);
      greenItem.addActionListener(new FontListener());
      
      magentaItem = new JMenuItem("Magenta");
      magentaItem.setMnemonic(KeyEvent.VK_M);
      magentaItem.addActionListener(new FontListener());
      
      colorItem.add(blackItem);
      colorItem.add(blueItem);
      colorItem.add(greenItem);
      colorItem.add(redItem);
      colorItem.add(orangeItem);
      colorItem.add(pinkItem);
      colorItem.add(magentaItem);
      colorItem.add(cyanItem);
      colorItem.add(yellowItem);
      colorItem.add(grayItem);
      
      // Create a menu for the items we just created.
      textMenu = new JMenu("Text");
      textMenu.setMnemonic(KeyEvent.VK_T);

      // Add the items and some separator bars to the menu.
      textMenu.add(fontItem);
      textMenu.addSeparator();// Separator bar
      textMenu.add(sizeItem);
      textMenu.addSeparator();
      textMenu.add(colorItem);
      textMenu.addSeparator();
      textMenu.add(alignmentItem); 
      textMenu.addSeparator();
      textMenu.add(italicItem);
      textMenu.add(boldItem);
      textMenu.add(underlineItem); //added by Sean and Arland
      textMenu.addSeparator();
      textMenu.add(indentItem);
      
   }
   
 //*****************************************************************************
   public void buildEditMenu () {

       editMenu = new JMenu("Edit");
       editMenu.setMnemonic(KeyEvent.VK_E);

       cutItem = new JMenuItem(new DefaultEditorKit.CutAction());
       cutItem.setText("Cut");
       cutItem.setMnemonic(KeyEvent.VK_C);
       editMenu.add(cutItem);

       copyItem = new JMenuItem(new DefaultEditorKit.CopyAction());
       copyItem.setText("Copy");
       copyItem.setMnemonic(KeyEvent.VK_C);
       editMenu.add(copyItem);

       pasteItem = new JMenuItem(new DefaultEditorKit.PasteAction());
       pasteItem.setText("Paste");
       pasteItem.setMnemonic(KeyEvent.VK_P);
       editMenu.add(pasteItem);
       
   }
//*****************************************************************************
   private void buildImageMenu()
   {
      // Create the New menu item.
      imageOpenItem = new JMenuItem("Open Image File");
      imageOpenItem.setMnemonic('O');
      imageOpenItem.addActionListener(new OpenImageListener());

      // Create the Open menu item.
      imageToolsItem = new JMenuItem("Select Part of Image");
      imageToolsItem.setMnemonic(KeyEvent.VK_S);
      
      imageToolsItem.addActionListener(new OpenToolsListener());

      // Create a menu for the items we just created.
      imageMenu = new JMenu("Image");
      imageMenu.setMnemonic(KeyEvent.VK_I);

      // Add the items and some separator bars to the menu.
      imageMenu.add(imageOpenItem);
      imageMenu.add(imageToolsItem);
      
   }

   
   private void buildWebMenu()
   {
      // Create the New menu item.
      webOpenItem = new JMenuItem("Import Picture from Web");
      webOpenItem.setMnemonic(KeyEvent.VK_I);
      webOpenItem.addActionListener(new WebListener());

      // Create the Open menu item.
      
      webTextItem = new JMenuItem("Sample Text from Website");
      webTextItem.setMnemonic(KeyEvent.VK_S);
     webTextItem.addActionListener(new WebListener());

      // Create a menu for the items we just created.
      webMenu = new JMenu("Web Imports");
      webMenu.setMnemonic(KeyEvent.VK_W);

      // Add the items and some separator bars to the menu.
      webMenu.add(webOpenItem);
      webMenu.add(webTextItem);
      
   }
   
   /**
      Private inner class that handles the event that
      is generated when the user selects New from 
      the file menu.
   */
      
   private class WebListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
          {
             if (e.getActionCommand().equals("Import Picture from Web")){
             openURLImage();
            }
             if (e.getActionCommand().equals("Sample Text from Website")){
                 openURLText();
                }
      }}
   
   
   /**
    * Private inner class that handles creating a new file or a new ontology XML file.
    * @author Ben
    *
    */
   private class NewListener implements ActionListener
   {
	   //private JFrame numItemsWindow;
	   private JFrame newOntologyWindow;
	   //private JPanel numItemsPanel;
	   private JPanel newOntologyPanel;
	   //private JComboBox ontologyDropDownList;
	   //private JButton confirmNumItems;
	   //private JButton cancelNumItems;
	   JTextField ontologyName;
	   JTextField itemName;
	   JTextField itemValue;
	   JTextField itemDict;
	   JComboBox itemColor;
	   JComboBox itemAnnotation;
	   JButton confirmOntologyButton;
	   JButton cancelOntologyButton;
	   
      public void actionPerformed(ActionEvent e)
      {
    	  // erases the text if any to create a blank text editor
    	  if(e.getSource() == newItem) {
    		  editorText.setText("");
    		  filename = null;
    		  name = "new document";
    	  }
    	  else if(e.getSource() == newOntology) {
    		  // Bring up the New Ontology Window
    		  buildNewOntologyWindow();
    	  }
    	  else if(e.getSource() == cancelOntologyButton) {
    		  // Close out of the New Ontology Window
    		  newOntologyWindow.dispose();
    	  }
    	  else if(e.getSource() == confirmOntologyButton) {
    		  // Bring up directory to choose where to save the new Ontology XML file.
    		  // Displays an error message if all of the fields are not filled out
    		  if(ontologyName.getText().equals("") || itemName.getText().equals("") || itemValue.getText().equals("")) 
    			  JOptionPane.showMessageDialog(newOntologyPanel, "Must enter something in all fields!");
    		  else { 
    			  newOntologyWindow.dispose();
    			  String XMLFileName = saveNewXMLFile();
    			  openedOntologies.put(ontologyName.getText(), XMLFileName);
    			  updateOntologies();
    		  }
    	  }
      }
     
      // Left the code for a future option where multiple items can be created if the user chooses. May implement later on.
      /*
      private void buildNumItemsWindow() {
    	  numItemsWindow = new JFrame("Select Number of Items");
    	  numItemsWindow.setContentPane(this.makeNumItemsPanel());
    	  numItemsWindow.pack();
    	  numItemsWindow.setVisible(true);
      }
      
      private JPanel makeNumItemsPanel() {
		  String[] numberOfItemsList = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		  numItemsPanel = new JPanel();
		  numItemsPanel.setLayout(new BorderLayout());
		  numItemsPanel.setPreferredSize(new Dimension(300, 100));
		  
		  JPanel centerPanel = new JPanel();
		  JLabel lbl = new JLabel("Enter the Number of Ontology Items: ");
		  ontologyDropDownList = new JComboBox(numberOfItemsList);
		  centerPanel.add(lbl, BorderLayout.LINE_START);
		  centerPanel.add(ontologyDropDownList, BorderLayout.LINE_END);
		  
		  JPanel bottomPanel = new JPanel();
		  confirmNumItems = new JButton("Next");
		  confirmNumItems.addActionListener(this);
		  bottomPanel.add(confirmNumItems, BorderLayout.PAGE_END);
		  
		  cancelNumItems = new JButton("Cancel");
		  cancelNumItems.addActionListener(this);
		  bottomPanel.add(cancelNumItems, BorderLayout.PAGE_END);
		  
		  numItemsPanel.add(centerPanel, BorderLayout.CENTER);
		  numItemsPanel.add(bottomPanel, BorderLayout.PAGE_END);
		  
		  return numItemsPanel;
      }
      */
      
      /**
       * Private method that creates the New Ontology Window.
       */
      private void buildNewOntologyWindow() {
    	  newOntologyWindow = new JFrame("Create New Ontology");
    	  newOntologyWindow.setContentPane(this.makeNewOntologyPanel());
    	  newOntologyWindow.setResizable(false);
    	  newOntologyWindow.pack();
    	  newOntologyWindow.setVisible(true);
      }
      
      /**
       * Method that creates the JPanel for the New Ontology Window.
       * @return JPanel newOntology Panel
       */
      private JPanel makeNewOntologyPanel() {
    	  newOntologyPanel = new JPanel();
    	  newOntologyPanel.setLayout(new BorderLayout());
    	  newOntologyPanel.setPreferredSize(new Dimension(350, 300));
    	  newOntologyPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    	  
    	  JPanel topPanel = new JPanel();
    	  JLabel label = new JLabel("Name of Ontology: ");
    	  ontologyName = new JTextField(15);
    	  ontologyName.setPreferredSize(new Dimension(50, 25));
    	  topPanel.add(label);
    	  topPanel.add(ontologyName);
    	  
    	  JPanel centerPanel = new JPanel();
  		  centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
  		  
  		  JLabel itemNameLabel = new JLabel("Name of First Item");
  		  itemNameLabel.setHorizontalAlignment(JLabel.CENTER);
  		  itemName = new JTextField(10);
  		  itemName.setPreferredSize(new Dimension(50, 25));
  		  
  		  JLabel itemValueLabel = new JLabel("Value of First Item");
  		  itemValueLabel.setHorizontalAlignment(JLabel.CENTER);
  		  itemValue = new JTextField(10);
  		  itemValue.setPreferredSize(new Dimension(50, 25));
  		  
  		  JLabel itemColorLabel = new JLabel("Color of First Item");
  		  itemColorLabel.setHorizontalAlignment(JLabel.CENTER);
  		  String colors[] = {"black", "blue", "cyan", "gray", "green", "magenta", "orange",
  			  	"pink", "red", "yellow"};
  		  itemColor = new JComboBox(colors);
  		  
  		  JLabel itemAnnotationLabel = new JLabel("Annotation?");
  		  itemAnnotationLabel.setHorizontalAlignment(JLabel.CENTER);
  		  String annotation[] = {"Yes", "No"};
  		  itemAnnotation = new JComboBox(annotation);
  		  
  		JLabel itemDictLabel = new JLabel("Dictionary");
		itemDictLabel.setHorizontalAlignment(JLabel.CENTER);
		itemDict = new JTextField(10);
		itemDict.setPreferredSize(new Dimension(50, 25));
  		
  		  centerPanel.add(itemNameLabel);
  		  centerPanel.add(itemName);
  		  centerPanel.add(itemValueLabel);
  		  centerPanel.add(itemValue);
  		  centerPanel.add(itemColorLabel);
  		  centerPanel.add(itemColor);
  		  centerPanel.add(itemAnnotationLabel);
  		  centerPanel.add(itemAnnotation);
  		  centerPanel.add(itemDictLabel);
		  centerPanel.add(itemDict);
  		  
  		  JPanel bottomPanel = new JPanel();
  		  confirmOntologyButton = new JButton("Next");
  		  confirmOntologyButton.addActionListener(this);
  		  cancelOntologyButton = new JButton("Cancel");
  		  cancelOntologyButton.addActionListener(this);
  		  bottomPanel.add(confirmOntologyButton);
  		  bottomPanel.add(cancelOntologyButton);
  		  
    	  newOntologyPanel.add(topPanel, BorderLayout.PAGE_START);
    	  newOntologyPanel.add(centerPanel, BorderLayout.CENTER);
    	  newOntologyPanel.add(bottomPanel, BorderLayout.PAGE_END);
    	  
    	  return newOntologyPanel;
      }
      
      /**
       * Method that displays a JFileChooser to allow the user to choose where to save the new XML file.
       * It then creates, writes, then saves the XML file with the information provided by the user.
       * @return String XMLFileName the file path name for the new XML file.
       */
      private String saveNewXMLFile() {
    	  JFileChooser chooser = new JFileChooser(System.getenv("user.home"));
    	  chooser.setSelectedFile(new File(ontologyName.getText().toLowerCase()+".xml"));
    	  String XMLFileName = "";
    	  int chooserStatus = chooser.showSaveDialog(null);
    	  if (chooserStatus == JFileChooser.APPROVE_OPTION) {
    		  File selectedFile = chooser.getSelectedFile();

    		  try {
    			  XMLFileName = selectedFile.getCanonicalPath();
    			  if (!XMLFileName.endsWith(".xml")) {
    				  selectedFile = new File(XMLFileName + ".xml");
    			  }
    			  String annotation = itemAnnotation.getSelectedItem().toString();
    			  if(annotation.equals("no"))
    				  annotation = "false";
    			  else
    				  annotation = "true";
    			  writeXMLFile(XMLFileName, ontologyName.getText(), itemName.getText(), itemValue.getText(), 
    					  itemColor.getSelectedItem().toString(), annotation, itemDict.getText());
    		  } catch (IOException | ParserConfigurationException | TransformerException error) {
    			  System.out.println("Error creating the XML file");
    		  }
    	  }
    	  return XMLFileName;
      }
      
      /**
       * Method that writes to a new XML file.
       * @param fileName the file path name of the file
       * @param ontologyName the root name of the XML file
       * @param itemName the first item name of the file
       * @param itemValue the first item value of the file
       * @param itemColor the first item color of the file
       * @param annotation true/false on whether you are able to annotate with this item
       * @throws ParserConfigurationException
       * @throws TransformerException
       */
      private void writeXMLFile(String fileName, String ontologyName, String itemName, String itemValue, 
    		  String itemColor, String annotation, String newDict) throws ParserConfigurationException, TransformerException {
    	  
    	  DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		  DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
  	 
		  // root element
		  Document doc = docBuilder.newDocument();
		  Element rootElement = doc.createElement("Ontology");
		  rootElement.setAttribute("name", ontologyName);
		  doc.appendChild(rootElement);
		  
		  // Add the new ontology item with the attributes given in the parameter
		  Element newItem = doc.createElement("item");
		  newItem.setAttribute("name", itemName);
		  newItem.setAttribute("value", itemValue);
		  newItem.setAttribute("color", itemColor);
		  newItem.setAttribute("annotation", annotation);
		  newItem.setAttribute("word", newDict);
		  doc.getDocumentElement().appendChild(newItem);
 	
		
		  // write the content into the xml file
		  TransformerFactory transformerFactory = TransformerFactory.newInstance();
		  Transformer transformer = transformerFactory.newTransformer();
		  DOMSource source = new DOMSource(doc);
		  StreamResult result = new StreamResult(new File(fileName));
		  transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
		  transformer.transform(source, result);
		  
      }
      
      /**
  	 * Private method that reopens all of the previously opened ontologies in the order
  	// they were opened in, thus showing any updates to the ontologies.
  	 */
  	private void updateOntologies() {
  		OpenListListener openOntology = new OpenListListener();
  		ArrayList<String> ontologyFiles = new ArrayList<String>();
  		ontologyFiles.addAll(openedOntologies.values());
  		Iterator<String> it = ontologyFiles.iterator();
  		while(it.hasNext()) {
  			openOntology.openList((String) it.next());
  		}
  	}
   }
   
   public class OpenListListener implements ActionListener
   {
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
          
          chooserStatus = chooser.showOpenDialog(null);
          if (chooserStatus == JFileChooser.APPROVE_OPTION)
          {
             // Get a reference to the selected file.
             File selectedFile = chooser.getSelectedFile();

             // Get the path of the selected file.
             filename = selectedFile.getPath();

             // Open the file.
             if (!openList(filename))
             {
                JOptionPane.showMessageDialog(null, 
                                 "Error reading " +
                                 filename, "Error",
                                 JOptionPane.ERROR_MESSAGE);
             }
             
             recentDirectory = chooser.getCurrentDirectory();
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

      public boolean openList(String filename)
      
      {
         JTreeBuilder tree= new JTreeBuilder();
         try {
			leftList = tree.build(filename);
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return false;
		}
         // Add ontology to ontology panel
         String treeRoot = leftList.getModel().getRoot().toString(); // String name of the root node
         openedOntologies.put(treeRoot, filename); // Place the filename into the HashMap 
         leftList.setAlignmentX(LEFT_ALIGNMENT);
         leftList.setMinimumSize(new Dimension(200, 200));
         leftList.setBackground(Color.LIGHT_GRAY);
         leftList.addMouseListener(new OntologyTreeMouseListener(leftList,TextEditor.this));
         ontologyPanel.add(leftList);
         
       contents.updateUI();
       return true;
      }
   }
   /**
      Private inner class that handles the event that
      is generated when the user selects Open from
      the file menu.
   */

   private class OpenListener implements ActionListener
   {
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

   //********************************************************************************************************************
   /**
   Private inner class that handles the event that
   is generated when the user selects Image File from
   the Image menu.
*/
   private class PrintListener implements ActionListener 
   {
     
	public void actionPerformed(ActionEvent e)
      { 
		 PrintingTask task = new PrintingTask(null, null, true);
	            task.execute();
	        ;
	}
      }
   
   private class PrintingTask extends SwingWorker<Object, Object> {
	    private final MessageFormat headerFormat;
	    private final MessageFormat footerFormat;
	    private final boolean interactive;
	    private volatile boolean complete = false;
	    private volatile String message;
	        
	    public PrintingTask(MessageFormat header, MessageFormat footer,
	                        boolean interactive) {
	        this.headerFormat = null;
	        this.footerFormat = null;
	        this.interactive = true;
	    }
	        
	    @Override
	    protected Object doInBackground() {
	        try {
	            complete = editorText.print(headerFormat, footerFormat,
	                    true, null, null, interactive);
	            message = "Printing " + (complete ? "complete" : "canceled");
	        } catch (PrinterException ex) {
	            message = "Sorry, a printer error occurred";
	        } catch (SecurityException ex) {
	            message =
	                "Sorry, cannot access the printer due to security reasons";
	        }
	        return null;
	    }
	        
	    @Override
	    protected void done() {
	        message(!complete, message);
	    }
	}
   
   private void message(boolean error, String msg) {
       int type = (error ? JOptionPane.ERROR_MESSAGE :
                           JOptionPane.INFORMATION_MESSAGE);
       JOptionPane.showMessageDialog(this, msg, "Printing", type);
   }
   
   
   private class OpenImageListener implements ActionListener 
   {
	   
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
      
      
   private class OpenToolsListener implements ActionListener 
   {
	   
      public void actionPerformed(ActionEvent e)
      {
         
    	  if (e.getActionCommand() == "Select Part of Image") {
    		  System.out.println("Here I am ");
    		  //Image imageB = image.getImage();
    		  //BufferedImage buffered = (BufferedImage) imageB;
    		  System.out.println("buffimg="+buffImg);
    		  Subimages test = new Subimages(buffImg);
    	        JFrame f = new JFrame();
    	        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	        f.getContentPane().add(new JScrollPane(test));
    	        f.setSize(400,400);
    	        f.setLocation(200,200);
    	        f.setVisible(true);
    	        test.createSubimage();

    	  }
   }
   }
/******************************************************************************
 * 
 * 
 */
      
     /* public void popUpMenu()
  	{
  		
  		// Create some menu items for the popup
  		//JMenuItem menuImageNew = new JMenuItem( "New" );
  		//JMenuItem menuImageOpen = new JMenuItem( "Open..." );
  		//JMenuItem menuImageSave = new JMenuItem( "Save" );
  		JMenuItem menuImageDelete = new JMenuItem( "Delete" );
  		JMenuItem menuImageExit = new JMenuItem( "Exit" );

  		// Create a popup menu
  		popupMenu = new JPopupMenu( "Image Menu" );
  		//popupMenu.add( menuImageNew );
  		//popupMenu.add( menuImageOpen );
  		//popupMenu.add( menuImageSave );
  		popupMenu.add( menuImageDelete );
  		popupMenu.add( menuImageExit );

  		
  		// Action and mouse listener support
  		enableEvents( AWTEvent.MOUSE_EVENT_MASK );
  		//menuImageNew.addActionListener( this );
  		//menuImageOpen.addActionListener( this );
  		//menuImageSave.addActionListener( this );
  		menuImageDelete.addActionListener(new ImageMenuListener()); 

  		menuImageExit.addActionListener( new ImageMenuListener());
  		
  	}*/
     
      public class Subimages extends JPanel {
    	    Rectangle clip = new Rectangle(50,50,250,250);
    	    Point origin = new Point();
    	    BufferedImage imageB;
    	 
    	    public Subimages(BufferedImage imageB) {
    	        this.imageB = imageB;
    	    }
    	 
    	    protected void paintComponent(Graphics g) {
    	        super.paintComponent(g);
    	        System.out.println(imageB);
    	        System.out.println(getWidth());
    	        System.out.println(origin);
    	        origin.x = (getWidth() - imageB.getWidth())/2;
    	        origin.y = (getHeight() - imageB.getHeight())/2;
    	        g.drawImage(imageB, origin.x, origin.y, this);
    	        Graphics2D g2 = (Graphics2D)g;
    	        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
    	                            RenderingHints.VALUE_ANTIALIAS_ON);
    	        g2.setPaint(Color.red);
    	        g2.draw(clip);
    	    }
    	 
    	   /* public Dimension getPreferredSize() {
    	        return new Dimension(imageB.getWidth(), imageB.getHeight());
    	    }*/
    	 
    	    private void createSubimage() {
    	        // Wait for gui to settle down.
    	        new Thread(new Runnable() {
    	            public void run() {
    	                try {
    	                    Thread.sleep(1000);
    	                } catch(InterruptedException e) {
    	                    System.out.println("wait interrupted");
    	                }
    	                int x = clip.x - origin.x;
    	                int y = clip.y - origin.y;
    	                int w = clip.width;
    	                int h = clip.height;
    	                System.out.print(x);
    	                System.out.print(y);
    	                System.out.print(w);
    	                System.out.print(h);
    	                System.out.print(imageB);
    	                
    	                BufferedImage subimage = imageB.getSubimage(x, y, w, h);
    	                BufferedImage copy = GraphicsEnvironment.getLocalGraphicsEnvironment().
    	                                     getDefaultScreenDevice().
    	                                     getDefaultConfiguration().
    	                                     createCompatibleImage(w, h);
    	                System.out.println("copy type = " + copy.getType());
    	                Graphics2D g2 = copy.createGraphics();
    	                g2.drawImage(subimage, 0, 0, null);
    	                g2.dispose();
    	                JOptionPane.showMessageDialog(null, new ImageIcon(copy), "", -1);
    	            }
    	        }).start();
    	    }

      private class ImageMenuListener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            if (e.getActionCommand().equals("Delete")){
            //editorText.insertIcon(g);
            
            editorText.remove(imageLabel);
            //editorText.repaint();
            popupMenu.setVisible(false); 
            //repaint();
            }
            else if (e.getActionCommand().equals("Exit")){
            	popupMenu.setVisible(false);  
                repaint();

                }
            
      }
      }}
  	
      /**
         The openImageFile method opens the file specified by
         filename and reads its contents into the text
         area. The method returns true if the file was
         opened and read successfully, or false if an
         error occurred.
         @param filename The name of the file to open.
       */      


      private boolean openImageFile(String filename)
      {
         boolean success=true;
         
         //new ImageIcon(myBufferedImage);
         
         File img = new File(filename);

          buffImg = new BufferedImage(240, 240, BufferedImage.TYPE_INT_ARGB);

         try { buffImg = ImageIO.read(img ); } catch (IOException e) { }
         //System.Out.Println(buffImg.getType()); //Prints 0 instead of 2
         
         image = new ImageIcon(filename);
         icon = new ImageIcon(image.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT));
         editorText.insertIcon(icon);
         editorText.setEditable(true); 
         editorText.setFocusable(true);
         imageLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				if(arg0.getModifiers()==4)  //16 for left, 8 for middle and 4 for right click
				{	
									
					//popUpMenu();
					//editorText.add(popupMenu);
					//popupMenu.setVisible( true );
				    
			}}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				
			}
         }); 
         
         return success;
      }
   
//****************************************************************
   /* Open URL Method
    * 
    */
  
   public void openURLImage() {
       EventQueue.invokeLater(new Runnable() {
           @Override
           public void run() {
               try {
                   UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
               } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
               }
                      
               try {

                   //String path = "http://www.naddervalleyclassics.co.uk/images/extra/f500-2.jpg"; 
            	   //String path = "http://www.berkshirewoodenboat.net";  

            	   Scanner scanner = new Scanner(System.in);
                   String path = JOptionPane.showInputDialog("Open image in separate web page then paste URL here:");
                		  
                   System.out.println("Get Image from " + path);
                   URL url = new URL(path);
                   BufferedImage image = ImageIO.read(url);
                   System.out.println("Load image into frame...");
                   ImageIcon imageIcon = new ImageIcon(image);
                   webLabel = new JLabel(new ImageIcon(imageIcon.getImage().getScaledInstance(700, 500, Image.SCALE_DEFAULT)));
                   editorText.insertComponent(webLabel);
                   editorText.setEditable(true); 
                   editorText.setFocusable(true);
                } catch (Exception exp) {
                   exp.printStackTrace();
               }
           }
       });
   }

   public void openURLText() {
       EventQueue.invokeLater(new Runnable() {
           @Override
           public void run() {
               try {
                   UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
               } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
               }
               //String url_open ="http://berkshirewoodenboat.net";
               try {
            	    //URL myURL = new URL("http://cnn.com/");
            	    Scanner scanner = new Scanner(System.in);
             	    String path = JOptionPane.showInputDialog("Enter web address to view text from in the format 'URL:' ");
             	    URL myURL = new URL("http://"+path+"/");
             	  
            	    URLConnection myURLConnection = myURL.openConnection();
            	    myURLConnection.connect();
            	       
            	    BufferedReader in = new BufferedReader(new InputStreamReader(
                            myURLConnection.getInputStream()));
            	    
            	    //JTextArea textarea1 = new JTextArea();
            	    String line = "Z";//initialize it to something
            	    line = in.readLine();
            	    while( line != null)
            	    {
            	    	 String next = line.replaceAll("<[^>]*>", "");
            	    	 
            	    	   try {
            	    	     		editorText.getStyledDocument().insertString(editorText.getCaretPosition(), next+"\n", null);
            	    	 
            	    		} catch (BadLocationException e) {
            	    	 
            	    			e.printStackTrace();
            	    	 
            	    			}
            	    	
            	    	   line = in.readLine();
            	     }	    
            	    in.close();
            	    
            	    editorText.setCaretPosition(0);
            	    
                        }
            	catch (MalformedURLException e) { 
            	    // new URL() failed
            	    // ...
            	} 
            	catch (IOException e) {   
            	    // openConnection() failed
            	    // ...
            	}
               
              }
       });
   }
   
   
   public void drawTable(int x, int y) {
	   JTable table = new JTable(x,y);
	   editorText.insertComponent(table);
   }
   
   /**
      Private inner class that handles the event that
      is generated when the user selects Save or Save
      As from the file menu.
   */

   private class SaveListener implements ActionListener
   {
	  
      public void actionPerformed(ActionEvent e)
      {
         int chooserStatus;

         // If the user selected Save As, or the contents 
         // of the editor have not been saved, use a file
         // chooser to get the file name. Otherwise, save
         // the file under the current file name.

         if (e.getActionCommand() == "Save As" || 
             filename == null)
         {
        	 
            JFileChooser chooser = null;
            
            if(recentDirectory != null) {
      		  chooser = new JFileChooser(recentDirectory);
      	  }
      	  else {
      		  chooser = new JFileChooser(recentDirectory);
      	  }
            
            chooserStatus = chooser.showSaveDialog(null);
            if (chooserStatus == JFileChooser.APPROVE_OPTION)
            {
               // Get a reference to the selected file.
               File selectedFile =
                             chooser.getSelectedFile();

               // Get the path of the selected file.
               filename = selectedFile.getPath();
            }
            recentDirectory = chooser.getCurrentDirectory();
         }

         if (!saveFile(filename))
         {
            JOptionPane.showMessageDialog(null,
                               "Error saving " +
                               filename+" file", 
                               "Error",
                               JOptionPane.ERROR_MESSAGE);
         }
         
         name = filename;
      }

      /**
         The saveFile method saves the contents of the
         text area to a file. The method returns true if
         the file was saved successfully, or false if an
         error occurred.
         @param filename The name of the file.
         @return true if successful, false otherwise.
      */

      private boolean saveFile(String filename)
      {
         boolean success;
         String editorString;
         FileWriter fwriter;
         PrintWriter outputFile;
         //File sFile = new File(filename + ".odt");
         File outFile = new File(filename + ".odt");
         
       
         if (filename==null)
         {
        	 return false;
         }
         try
         {
            fwriter = new FileWriter(filename);
            outputFile = new PrintWriter(fwriter);

            // Write the contents of the text area
            // to the file.
            editorString = editorText.getText();
            outputFile.print(editorString);

            // Close the file.
            outputFile.close();

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


   /**
   Private inner class that handles the event that
   is generated when the user selects an item from
   the font menu.
*/

private class TextFormatListener implements ActionListener
{
   public void actionPerformed(ActionEvent e)
   {
      if(e.getActionCommand().equals("Word Wrap")){
      if (wordWrap.isSelected())
        wrapped=true;
      else {
    	  wrapped=false;
      }
      wordWrap();
      }
      else if(e.getActionCommand().equals("Show Annotations")){
    	 
    	  if (showAnnotations.isSelected()){
    		  System.out.println("Show Annotations");    		 
    	       hideAnnotations(false);
    	  }
    	  else{
    		 
    		  hideAnnotations(true); 
    		  System.out.println("Hide Annotations");
    	  }
    	     
      }
   }
}

   /**
      Private inner class that handles the event that
      is generated when the user selects an item from
      the font menu.
   */

   private class FontListener implements ActionListener
   {
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
         }
         if(e.getSource() == size36){
             fontSize = 36;
          }
        if(e.getSource() == size72){
        	 fontSize = 72;
        }
        if(e.getSource() == size96){
        	 fontSize = 96; 
       }
         StyleContext sc = StyleContext.getDefaultStyleContext();
         AttributeSet aset;
         if(e.getSource() == leftAlign){
        	 
        	 TabStop[] tab = new TabStop[1];
        	 tab[0] = new TabStop(0, TabStop.ALIGN_LEFT, TabStop.LEAD_NONE);

        	 TabSet tabset = new TabSet(tab);
        	 //StyleContext sc = StyleContext.getDefaultStyleContext();
        	 /*AttributeSet*/ aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.TabSet, tabset);
        	 editorText.setParagraphAttributes(aset, false);
        	 if (!editorText.getSelectedText().equals(null))

    			editorText.replaceSelection("\t" + editorText.getSelectedText());

         }
        	 
        	 if(e.getSource() == ALleft){
            	 
            	 TabStop[] tab = new TabStop[1];
            	 tab[0] = new TabStop(0, TabStop.ALIGN_LEFT, TabStop.LEAD_NONE);
            	 TabSet tabset = new TabSet(tab);
            	 
            	// /*StyleContext*/ sc = StyleContext.getDefaultStyleContext();
            	 /*AttributeSet*/ aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.TabSet, tabset);
            	 editorText.setParagraphAttributes(aset, false);
            	 if (!editorText.getSelectedText().equals(null))
            		 // This sets a tabstop and then tabs to it. Find a way to fix this
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
         
         	if(e.getSource() == ALcenter){
        	 TabStop[] tab = new TabStop[1];
        	 tab[0] = new TabStop((contents.getWidth()/2), TabStop.ALIGN_CENTER, TabStop.LEAD_NONE);
        	 TabSet tabset = new TabSet(tab);
        	 
        	// /*StyleContext*/ sc = StyleContext.getDefaultStyleContext();
        	 /*AttributeSet*/ aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.TabSet, tabset);
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
         
         	if(e.getSource() == ALright){
        	 
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
   private class ListListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
    	  
    	  
    	  if(e.getSource()==midnightTheme) {
    		Color midnight = new Color(23,17,79);
    		menuBar.setBackground(midnight);
    		toolBar.setBackground(midnight);
    		for(int i = 0; i < menuBar.getComponentCount(); i++) {
    			if(menuBar.getComponent(i) instanceof JMenuItem) {
    				menuBar.getComponent(i).setForeground(Color.WHITE);
    			}
    		}
    		for(int i = 0; i < toolBar.getComponentCount(); i++) {
    				toolBar.getComponent(i).setForeground(Color.WHITE);
    				toolBar.getComponent(i).setBackground(midnight);
    		}
//    		contents.revalidate();
//    		contents.repaint();
    	  }
    	  if(e.getSource()==skyTheme) {
    		Color sky = new Color(75,165,255);
    		menuBar.setBackground(sky);
      		toolBar.setBackground(sky);
      		for(int i = 0; i < menuBar.getComponentCount(); i++) {
      			if(menuBar.getComponent(i) instanceof JMenuItem) {
      				menuBar.getComponent(i).setForeground(Color.WHITE);
      			}
      		}
      		for(int i = 0; i < toolBar.getComponentCount(); i++) {
      				toolBar.getComponent(i).setForeground(Color.WHITE);
      				toolBar.getComponent(i).setBackground(sky);
      		}
    	  }
    	  if(e.getSource()==greenTheme) {
    		Color spring = new Color(110, 226, 83);
    		menuBar.setBackground(spring);
      		toolBar.setBackground(spring);
      		for(int i = 0; i < menuBar.getComponentCount(); i++) {
      			if(menuBar.getComponent(i) instanceof JMenuItem) {
      				menuBar.getComponent(i).setForeground(Color.DARK_GRAY);
      			}
      		}
      		for(int i = 0; i < toolBar.getComponentCount(); i++) {
      				toolBar.getComponent(i).setForeground(Color.DARK_GRAY);
      				toolBar.getComponent(i).setBackground(spring);
      		}
    	  }
    	  if(e.getSource()==fireTheme) {
    		Color fire = new Color(255, 60, 25);
    		menuBar.setBackground(fire);
      		toolBar.setBackground(fire);
      		for(int i = 0; i < menuBar.getComponentCount(); i++) {
      			if(menuBar.getComponent(i) instanceof JMenuItem) {
      				menuBar.getComponent(i).setForeground(Color.WHITE);
      			}
      		}
      		for(int i = 0; i < toolBar.getComponentCount(); i++) {
      				toolBar.getComponent(i).setForeground(Color.WHITE);
      				toolBar.getComponent(i).setBackground(fire);
      		}
    	  }
    	  if(e.getSource()==swampTheme) {
    		Color swamp = new Color(15, 85, 40);
    		menuBar.setBackground(swamp);
      		toolBar.setBackground(swamp);
      		for(int i = 0; i < menuBar.getComponentCount(); i++) {
      			if(menuBar.getComponent(i) instanceof JMenuItem) {
      				menuBar.getComponent(i).setForeground(Color.WHITE);
      			}
      		}
      		for(int i = 0; i < toolBar.getComponentCount(); i++) {
      				toolBar.getComponent(i).setForeground(Color.WHITE);
      				toolBar.getComponent(i).setBackground(swamp);
      		}
    	  }
    	  if(e.getSource()==defaultTheme) {
      		menuBar.setBackground(defaultColor);
        	toolBar.setBackground(defaultColor);
        		for(int i = 0; i < menuBar.getComponentCount(); i++) {
        			if(menuBar.getComponent(i) instanceof JMenuItem) {
        				menuBar.getComponent(i).setForeground(Color.black);
        			}
        		}
        		for(int i = 0; i < toolBar.getComponentCount(); i++) {
        				toolBar.getComponent(i).setForeground(Color.black);
        				toolBar.getComponent(i).setBackground(defaultColor);
        		}
      	  }
         
         if (showLeftList.isSelected()){
         ontologyPanel.setVisible(true);       
         }
         else{
        	 ontologyPanel.setVisible(false);    
         }
   }
   }
   
   public class SpellCheckListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e){
    	  SpellChecker.enableShortKey(editorText, true);
	      SpellChecker.showSpellCheckerDialog(editorText, null);
      }
   }
   
   public class RedLineListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e){
	      	if (RedUnderline.isSelected() == true){
	      		SpellChecker.enableAutoSpell(editorText, true);
	      	}else{
	      		SpellChecker.enableAutoSpell(editorText, false);
	      	}
      }
   }
   
   public static JTextPane getTextEdit(){
	return editorText;   
   }
   
   private void buildSpellCheckMenu(){
	   {
		// Create user dictionary in the current working directory of your application
	        SpellChecker.setUserDictionaryProvider( new FileUserDictionary() );
		  
	        SpellChecker.registerDictionaries(this.getClass().getResource("/dictionary/dictionaries.cnf"), "en");
		   
	        SpellChecker.register(editorText);
		   
		   // Create a menu for SpellCheck.
		      SpellCheckMenu = new JMenu("Spell Check");
		      SpellCheckMenu.setMnemonic(KeyEvent.VK_S);
		   
		      // Create the New menu item.
		      SpellCheck = new JMenuItem("Check Documents Spelling");
		      SpellCheck.setMnemonic(KeyEvent.VK_C);
		      SpellCheck.addActionListener(new SpellCheckListener());

		      // Create the underline menu item.
		      RedUnderline = new JCheckBoxMenuItem("Underline Misspelled Words");
		      RedUnderline.setMnemonic(KeyEvent.VK_U);
		      RedUnderline.setSelected(true);		      
		      RedUnderline.addActionListener(new RedLineListener());


		      // Add the items.
		      SpellCheckMenu.add(SpellCheck);
		      SpellCheckMenu.add(RedUnderline);
		   }
   }
   
  
   private class WindowHandler implements WindowListener {

		@Override
		public void windowActivated(WindowEvent e) {
		
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
		
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			
			if(editorText.getText().equals("")){
				System.exit(0);
			}
			
			else{
				int result=JOptionPane.showConfirmDialog(null, "Do you want to save changes to "+name+"?");
				if(result==JOptionPane.YES_OPTION){
					int chooserStatus;

			         // If the user selected Save As, or the contents 
			         // of the editor have not been saved, use a file
			         // chooser to get the file name. Otherwise, save
			         // the file under the current file name.

			         if (filename == null)
			         {
			            JFileChooser chooser = null;
			            
			            if(recentDirectory != null) {
			        		  chooser = new JFileChooser(recentDirectory);
			        	  }
			        	  else {
			        		  chooser = new JFileChooser(recentDirectory);
			        	  }
			            chooserStatus = chooser.showSaveDialog(null);
			            if (chooserStatus == JFileChooser.APPROVE_OPTION)
			            {
			               // Get a reference to the selected file.
			               File selectedFile =
			                             chooser.getSelectedFile();

			               // Get the path of the selected file.
			               filename = selectedFile.getPath();
			            }
			         
			         }
			        
			         SaveListener save = new SaveListener(); 
			         if (!save.saveFile(filename))
			         {
			            JOptionPane.showMessageDialog(null,
			                               "Error saving " +
			                               filename+" file", 
			                               "Error",
			                               JOptionPane.ERROR_MESSAGE);
			         }
			         
			         
			       System.exit(0);
			      }
				
				if(result==JOptionPane.NO_OPTION){
					 System.exit(0);
				}
		
		
			}
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			
			
		}

		@Override
		public void windowOpened(WindowEvent e) {
			
			
		}
		   
	   }
   
   /**
   main method
    */
   public static void main(String[] args)
   {
      TextEditor te = new TextEditor();
   }
   
}