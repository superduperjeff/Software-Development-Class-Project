
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;





public class OntologyTreeMouseListener implements MouseListener, ActionListener {
JTree tree;					// the selected JTree
TextEditor main; 			// the TextEditor
JButton close;				// button on pop-up menu that closes the selected ontology
JButton dictionary;
JButton add;				// button on pop-up menu that brings up an ontology item creation window
JButton apply;				// button on pop-up menu that applies the annotation of the selected ontology
JPopupMenu popup;			// the pop-up menu that appears when user right-clicks an ontology item
OntologyItem selectedItem;	// the selected item
JFrame addItemWindow;
JFrame editDictionaryWindow;
JFrame changeColorWindow;
JPanel addItemPanel;
JPanel centerPanel;
JPanel bottomPanel;
JPanel dPanel;
JPanel centerDPanel;
JPanel bDPanel;
JPanel changeColorPanel;
JTextArea dictionaryText;
JTextField itemName;
JTextField itemValue;
JTextField itemDict;
JComboBox itemColor;
JComboBox itemColorChange;
JComboBox itemAnnotation;
JButton addItemButton;
JButton cancelAddButton;
JButton cancelDButton;
JButton dButton;
JButton dictionaryEdit;
JButton deleteItem;
JButton changeValue;
JButton changeColor;

int x;
int y;
int selRow;

	public OntologyTreeMouseListener(JTree _tree, TextEditor _main) {
		// TODO Auto-generated constructor stub
		tree=_tree;
		main=_main;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		x = e.getX();
		y = e.getY();
		selRow = tree.getRowForLocation(x, y);
        TreePath selPath = tree.getPathForLocation(x, y);
        DefaultMutableTreeNode obj = (DefaultMutableTreeNode)selPath.getLastPathComponent();
        selectedItem =(OntologyItem) obj.getUserObject();
        
		 if (SwingUtilities.isRightMouseButton(e)) {
				popup = new JPopupMenu();
				popup.setLayout(new GridLayout(0, 1));
				
				// Show pop-up menu options if root node is right-clicked
				if(obj.isRoot()) {
					// Close Ontology button creation
					close = new JButton("Close Ontology");
					close.addActionListener(this);
					popup.add(close);
					// Add New Item button creation
					add = new JButton("Add New Item");
					add.addActionListener(this);
					popup.add(add);
					// Add new Annotate Dictionary Button
					dictionary = new JButton("Annotate Dictionary");
					dictionary.addActionListener(this);
					popup.add(dictionary);
					popup.show(tree, x, y);
					
				}
				
				// Show popup menu options if an ontology item is right-clicked
				else {
					apply = new JButton("Apply Annotation");
					apply.addActionListener(this);   
					
					dictionaryEdit = new JButton("Edit Dictionary");
					dictionaryEdit.addActionListener(this);  
					
					deleteItem = new JButton("Delete Ontology Item");
					deleteItem.addActionListener(this);
					
					changeValue = new JButton("Change Tag");
					changeValue.addActionListener(this);  
					
					changeColor = new JButton("Change Color");
					changeColor.addActionListener(this);  
				 					
					popup.add(dictionaryEdit);
					popup.add(changeValue);
					popup.add(changeColor);
					popup.add(deleteItem);
					popup.add(apply);
					popup.add(new JLabel("Name: "+selectedItem.getName()));
					popup.add(new JLabel("Color: "+selectedItem.getColorName()));
					popup.add(new JLabel("Tag: "+selectedItem.getValue()));
					popup.add(new JLabel("Annotation: "+selectedItem.isAnnotation()));
					popup.show(tree, x, y);
				
				}
		 }
		 
		 else {
		  
	         if(selRow != -1) {
	             if(e.getClickCount() == 1) {
	            	// System.out.println("Single Click");
	               //  mySingleClick(selRow, selPath);
	             }
	             else if(e.getClickCount() == 2) {
	            	// System.out.println("Double Click");
	            	 main.applyAnnotation(selectedItem.getValue(),selectedItem.getColor());
	                
	             }
	         }	
		 }
	}
	
	/**
	 * Creates the JFrame for holding the JPanel for adding a new ontology item.
	 */
	private void buildAddOntologyItemWindow() {
		addItemWindow = new JFrame("Add New Ontology Item");
		addItemWindow.setResizable(false);
		addItemWindow.setContentPane(this.makeAddItemPanel());
		addItemWindow.pack();
		addItemWindow.setVisible(true);
	}
	
	/**
	 * Creates the JFrame for holding the JPanel for editing an ontology item dictionary
	 */
	private void buildDictionaryEditWindow() {
		editDictionaryWindow = new JFrame("Edit Dictionary");
		editDictionaryWindow.setResizable(true);
		editDictionaryWindow.setContentPane(this.editDictionaryPanel());
		editDictionaryWindow.pack();
		editDictionaryWindow.setVisible(true);
	}
	/**
	 * Creates the JFrame for holding the JPanel for editing an ontology item color
	 */
	private void buildChangeColorItemWindow(OntologyItem _item) {
		changeColorWindow = new JFrame("Change Color of Ontology Item");
		changeColorWindow.setResizable(false);
		changeColorWindow.setContentPane(this.makeChangeColorPanel(_item));
		changeColorWindow.pack();
		changeColorWindow.setVisible(true);
	}
	/**
	 * Method that creates the "Add Ontology Item" panel that allows the user to enter the necessary information 
	 * create the XL file.
	 * @return JPanel addItemPanel 
	 */
	private JPanel makeAddItemPanel() {
		addItemPanel = new JPanel();
		addItemPanel.setLayout(new BorderLayout());
		addItemPanel.setPreferredSize(new Dimension(200, 250));
		Border empty = BorderFactory.createEmptyBorder(10, 10, 0, 10);
		addItemPanel.setBorder(empty);
		
		centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		addItemPanel.add(centerPanel, BorderLayout.CENTER);
		
		JLabel itemNameLabel = new JLabel("Name");
		itemNameLabel.setHorizontalAlignment(JLabel.CENTER);
		itemName = new JTextField(10);
		JLabel itemValueLabel = new JLabel("Value");
		itemValueLabel.setHorizontalAlignment(JLabel.CENTER);
		itemValue = new JTextField(10);
		JLabel itemColorLabel = new JLabel("Color");
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
		
		bottomPanel = new JPanel();
		addItemPanel.add(bottomPanel, BorderLayout.PAGE_END);
		addItemButton = new JButton("Add");
		addItemButton.addActionListener(this);
		cancelAddButton = new JButton("Cancel");
		cancelAddButton.addActionListener(this);
		bottomPanel.add(addItemButton);
		bottomPanel.add(cancelAddButton);
		
		return addItemPanel;
	}
	/**
	 * Method that creates the "Change Ontology Item Color" panel that allows the user to change the color of an ontology item
	 * @return JPanel addItemPanel 
	 */
	private JPanel makeChangeColorPanel(OntologyItem _item) {
		changeColorPanel = new JPanel();
		changeColorPanel.setLayout(new BorderLayout());
		changeColorPanel.setPreferredSize(new Dimension(200, 100));
		Border empty = BorderFactory.createEmptyBorder(10, 10, 0, 10);
		changeColorPanel.setBorder(empty);
		
		centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		changeColorPanel.add(centerPanel, BorderLayout.CENTER);

		
		JLabel itemColorLabel = new JLabel("Color");
		itemColorLabel.setHorizontalAlignment(JLabel.CENTER);
		String colors[] = {"black", "blue", "cyan", "gray", "green", "magenta", "orange",
				"pink", "red", "yellow"};
		itemColorChange = new JComboBox(colors);
		itemColorChange.addActionListener(this);
		centerPanel.add(itemColorChange);
		changeColorPanel.add(centerPanel);
		 	
		return changeColorPanel;
	}
	/**
	 * Creates the panel for editing an ontology item dictionary.
	 * @return JPanel dPanel that houses a JTextField that is editable
	 */
	private JPanel editDictionaryPanel() {
		dPanel = new JPanel();
		dPanel.setLayout(new BorderLayout());
		dPanel.setPreferredSize(new Dimension(500, 500));
		Border empty = BorderFactory.createEmptyBorder(10, 10, 0, 10);
		dPanel.setBorder(empty);
		
		centerDPanel = new JPanel();
		//centerDPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		dPanel.add(centerDPanel, BorderLayout.CENTER);
		
		dictionaryText = new JTextArea();
		dictionaryText.setEditable(true);
		dictionaryText.setLineWrap(true);
		dictionaryText.setPreferredSize(new Dimension(450, 400));
		
		centerDPanel.add(dictionaryText);
		dictionaryText.setText(selectedItem.getDictionary());
		
		
		bDPanel = new JPanel();
		dPanel.add(bDPanel, BorderLayout.PAGE_END);
		dButton = new JButton("Add to Dictionary");
		dButton.addActionListener(this);
		cancelDButton = new JButton("Cancel");
		cancelDButton.addActionListener(this);
		bDPanel.add(dButton);
		bDPanel.add(cancelDButton);
		
		return dPanel;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		// if the apply button is selected on a right-click
		// applies the selected annotation to the selected text in TextEditor
		if(e.getSource() == apply) {
		    Component c = (Component) e.getSource();
		    main.applyAnnotation(selectedItem.getValue(),selectedItem.getColor());
		    popup.setEnabled(false);
		}
		// if the dictionary button is selected on a right-click, the entire TextEditor is scanned and 
		// annotated with the appropriate ontology based on the ontology items' dictionaries
		else if(e.getSource() == dictionary) {
			
			popup.setEnabled(false);
			popup.setVisible(false);
			
			traverseDictionaries(tree);
		}
		     
		
		// if the close button is selected on a right-click
		// removes the JTree selected from the TextEditor
		else if(e.getSource() == close) {
			main.ontologyPanel.remove(tree);
			main.openedOntologies.remove(tree.getModel().getRoot().toString());
			main.contents.revalidate();
			main.contents.repaint();
			popup.setEnabled(false);
			popup.setVisible(false);
		}
		// if the "Add New Item" button is selected the Add Ontology Item Window opens
		else if(e.getSource() == add) {
			buildAddOntologyItemWindow();
		}
		// closes the Add Ontology Item Window 
		else if(e.getSource() == cancelAddButton) {
			addItemWindow.dispose();
		}
		else if(e.getSource() == addItemButton) {
			// Check to see if all fields were entered
			if(itemName.getText().equals("") || itemValue.getText().equals(""))
				JOptionPane.showMessageDialog(addItemPanel, "Must enter something in all fields!");
			
				// Take all of the user input and create a new ontology item from them
				String newName = itemName.getText();
				String newValue = itemValue.getText();
				String newColor = (String) itemColor.getSelectedItem().toString();
				String newDict = itemDict.getText();
				
				String newAnnotation = (String) itemAnnotation.getSelectedItem().toString();
				if(newAnnotation.equals("no")) 
					newAnnotation = "false";
				else
					newAnnotation = "true";
				
				addNewItemToXML(newName, newValue, newColor, newAnnotation, newDict);
				addItemWindow.dispose();
				
				// Remove all opened ontologies
				main.ontologyPanel.removeAll();
				updateOntologies();
				
				main.revalidate();
				main.repaint();
		}
		// If the "Edit Dictionary" button is pressed on a right-click on an ontology item
		else if(e.getSource() == dictionaryEdit) {
			buildDictionaryEditWindow();
		}
		// If the cancel button is pressed in the edit dictionary window
		else if(e.getSource() == cancelDButton) {
			editDictionaryWindow.dispose();
		}
		// If the "Add to Dictionary" button is pressed
		else if(e.getSource() == dButton) {
			editItemDictionary(dictionaryText.getText());
			editDictionaryWindow.dispose();
			main.ontologyPanel.removeAll();
			updateOntologies();
		}
		// If the "Delete Ontology Item" button is pressed on a right-click
		else if(e.getSource() == deleteItem) {
			int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete "+selectedItem.getName(), "Delete Ontology Item", JOptionPane.YES_NO_OPTION);
	        if (reply == JOptionPane.YES_OPTION) {
	          deleteItemFromXML();
	          main.ontologyPanel.removeAll();
	          updateOntologies();
	        }
		}
		// If the "Change Tag" button is pressed on a right-click
		else if(e.getSource() == changeValue) {
			deleteItemFromXML();
			selectedItem.setValue(JOptionPane.showInputDialog("Enter a new tag:"));
			addNewItemToXML(selectedItem.getName(), selectedItem.getValue(), selectedItem.getColorName(), selectedItem.getValue(), selectedItem.getDictionary());
			main.ontologyPanel.removeAll();
	        updateOntologies();
		}
		// If the "Change Color" button is pressed on a right-click
		else if(e.getSource() == changeColor) {
			buildChangeColorItemWindow(selectedItem);
		}
		// If a color selection is clicked on the change color window
		else if(e.getSource() == itemColorChange) {
			String selectedColor = (String) itemColorChange.getSelectedItem();
			deleteItemFromXML();
			selectedItem.setColor(selectedColor);
			selectedItem.setColorName(selectedColor);
			addNewItemToXML(selectedItem.getName(), selectedItem.getValue(), selectedItem.getColorName(), selectedItem.getValue(), selectedItem.getDictionary());
			main.ontologyPanel.removeAll();
	        updateOntologies();
			changeColorWindow.dispose();
		}
	}
	
	/**
	 * Method that adds the new ontology item to the selected Ontology Tree. It first
	 * reads in the XML file, parses it, adds the new element, then rewrites the
	 * XML file with the new changes.
	 * @param name is the name of the ontology item
	 * @param value is the string that is shown when using the ontology to annotate
	 * @param color is the color the annotated word is changed to
	 * @param annotation boolean that determines if you can annotate with this item
	 * @param newDict 
	 */
	private void addNewItemToXML(String name, String value, String color, String annotation, String newDict) {
		
		// Load in XML file and parse it
		String filepath = main.openedOntologies.get(tree.getModel().getRoot().toString());
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		try {
			docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filepath);
			
			// Add the new ontology item with the attributes given in the parameter
			Element newItem = doc.createElement("item");
			newItem.setAttribute("name", name);
			newItem.setAttribute("value", value);
			newItem.setAttribute("color", color);
			newItem.setAttribute("annotation", annotation);
			newItem.setAttribute("word", newDict);
			doc.getDocumentElement().appendChild(newItem);
	
			
			// write the content into the xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filepath));
			transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
			transformer.transform(source, result);
			
		} catch (ParserConfigurationException | SAXException | IOException
				| TransformerException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * Deletes the selected ontology item from the ontology XML file and re-writes the XML file with the changes
	 */
	private void deleteItemFromXML() {
		
		OntologyItem currentItem;
		
		// Load in XML file and parse it
		String filepath = main.openedOntologies.get(tree.getModel().getRoot().toString());
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		try {
			docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filepath);
			
			// Remove selected node from the JTree
			Node item = doc.getElementsByTagName("item").item(selRow-1);
			item.getParentNode().removeChild(item);
			
			// write the content back into the xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filepath));
			transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
			transformer.transform(source, result);
			
		} catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * Private method that reopens all of the previously opened ontologies in the order
	// they were opened in, thus showing any updates to the ontologies
	 */
	private void updateOntologies() {
		TextEditor.OpenListListener openOntology = main.new OpenListListener();
		ArrayList<String> ontologyFiles = new ArrayList<String>();
		ontologyFiles.addAll(main.openedOntologies.values());
		Iterator<String> it = ontologyFiles.iterator();
		while(it.hasNext()) {
			openOntology.openList((String) it.next());
		}
	}
	
	/**
	 * Helper method that takes a JTree and calls the walk() method to traverse the JTree
	 * @param tree JTree to be traversed
	 */
	public void traverseDictionaries(JTree tree) { 
		TreeModel model = tree.getModel(); 
		if (model != null) { 
			DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot(); 
			walk(model, root); 
		}
	}
	
	/**
	 * Traverses each node of the JTree and scans each ontology item's dictionary and applies the appropriate
	 * annotation to any words matching the dictionary words in the TextEditor.
	 * @param model the JTree TreeModel
	 * @param root the root of the JTree
	 */
	protected void walk(TreeModel model, DefaultMutableTreeNode root) { 
		int cc = root.getChildCount();
		for(int i = 0; i < cc; i++) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) root.getChildAt(i); 
			OntologyItem currentItem = (OntologyItem) node.getUserObject();
			if(currentItem.getDictionary() != null) {
				StringTokenizer st = new StringTokenizer(currentItem.getDictionary());
				while (st.hasMoreTokens()) {
		        
					String str = st.nextToken();
					String text = TextEditor.getTextEdit().getText();
					String patternString = str;
		     
					Pattern pattern = Pattern.compile(patternString);
					Matcher matcher = pattern.matcher(text);
					while(matcher.find()) {
						main.applyAnnotation(currentItem.getValue(), currentItem.getColor(),matcher.start(),matcher.end());
					}
				}
			} 
		}
	}
	
	/**
	 * Method that loads in the ontology item's dictionary and overwrites it with the passed in String 
	 * and saved to the XML file.
	 * @param dictionary the string containing all of the associated words of the ontology item
	 */
	private void editItemDictionary(String dictionary) {
		// Load in XML file and parse it
		String filepath = main.openedOntologies.get(tree.getModel().getRoot().toString());
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		try {
			docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filepath);
				
			Node item = doc.getElementsByTagName("item").item(selRow-1);
			NamedNodeMap attr = item.getAttributes();
			Node nodeAttr = attr.getNamedItem("word");
			nodeAttr.setTextContent(dictionary);
					
			// write the content into the xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filepath));
			transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
			transformer.transform(source, result);
					
					
		} catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
			e.printStackTrace();
		}	
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
