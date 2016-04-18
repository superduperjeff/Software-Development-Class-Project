import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

class NewListener implements ActionListener
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
	   String filename;
	   String name;
	   HashMap<String, String> openedOntologies;
	   private static JTextPane editorText;
	   Element newItem = doc.createElement("item");
	   private JMenuItem newOntology;
	   
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
   