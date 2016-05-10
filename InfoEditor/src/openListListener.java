import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTree;

class openListListener implements ActionListener {
	private File recentDirectory = null;
	String filename;
	private JTree leftList;
	JPanel contents;
	HashMap<String, String> openedOntologies;
	JPanel ontologyPanel;

	public openListListener(JPanel ontologyPanel1, JPanel contents1) {
		ontologyPanel = ontologyPanel1;
		contents = contents1;
	}

	public void actionPerformed(ActionEvent e) {

		int chooserStatus;

		JFileChooser chooser = null;

		if (recentDirectory != null) {
			chooser = new JFileChooser(recentDirectory);
		} else {
			chooser = new JFileChooser(recentDirectory);
		}

		chooserStatus = chooser.showOpenDialog(null);
		if (chooserStatus == JFileChooser.APPROVE_OPTION) {
			// Get a reference to the selected file.
			File selectedFile = chooser.getSelectedFile();

			// Get the path of the selected file.
			filename = selectedFile.getPath();

			// Open the file.
			if (!openList(filename)) {
				JOptionPane.showMessageDialog(null,
						"Error reading " + filename, "Error",
						JOptionPane.ERROR_MESSAGE);
			}

			recentDirectory = chooser.getCurrentDirectory();
		}
	}

	/**
	 * The openFile method opens the file specified by filename and reads its
	 * contents into the text area. The method returns true if the file was
	 * opened and read successfully, or false if an error occurred.
	 * 
	 * @param filename
	 *            The name of the file to open.
	 */

	public boolean openList(String filename)

	{
		JTreeBuilder tree = new JTreeBuilder();
		try {
			leftList = tree.build(filename);
		} catch (Exception e) {

			e.printStackTrace();

			return false;
		}
		// Add ontology to ontology panel
		String treeRoot = leftList.getModel().getRoot().toString(); // String
		// name of
		// the root
		// node
		openedOntologies.put(treeRoot, filename); // Place the filename into the
		// HashMap
		leftList.setAlignmentX(LEFT_ALIGNMENT);
		leftList.setMinimumSize(new Dimension(200, 200));
		leftList.setBackground(Color.LIGHT_GRAY);
		leftList.addMouseListener(new OntologyTreeMouseListener(leftList,
				TextEditor.this));
		ontologyPanel.add(leftList);

		contents.updateUI();
		return true;
	}
}