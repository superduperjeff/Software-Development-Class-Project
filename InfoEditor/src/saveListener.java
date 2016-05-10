import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

class saveListener implements ActionListener {

	/**
	 * Private inner class that handles the event that is generated when the
	 * user selects Save or Save As from the file menu.
	 */
	private File recentDirectory = null;
	String filename;
	String name;
	private static JTextPane editorText;

	public saveListener(JTextPane editorText1) {
		editorText = editorText1;
	}

	public void actionPerformed(ActionEvent e) {
		int chooserStatus;

		// If the user selected Save As, or the contents
		// of the editor have not been saved, use a file
		// chooser to get the file name. Otherwise, save
		// the file under the current file name.

		if (e.getActionCommand() == "Save As" || filename == null) {

			JFileChooser chooser = null;

			if (recentDirectory != null) {
				chooser = new JFileChooser(recentDirectory);
			} else {
				chooser = new JFileChooser(recentDirectory);
			}

			chooserStatus = chooser.showSaveDialog(null);
			if (chooserStatus == JFileChooser.APPROVE_OPTION) {
				// Get a reference to the selected file.
				File selectedFile = chooser.getSelectedFile();

				// Get the path of the selected file.
				filename = selectedFile.getPath();
			}
			recentDirectory = chooser.getCurrentDirectory();
		}

		if (!saveFile(filename)) {
			JOptionPane.showMessageDialog(null, "Error saving " + filename
					+ " file", "Error", JOptionPane.ERROR_MESSAGE);
		}

		name = filename;
	}

	/**
	 * The saveFile method saves the contents of the text area to a file. The
	 * method returns true if the file was saved successfully, or false if an
	 * error occurred.
	 * 
	 * @param filename
	 *            The name of the file.
	 * @return true if successful, false otherwise.
	 */

	boolean saveFile(String filename) {
		boolean success;
		String editorString;
		FileWriter fwriter;
		PrintWriter outputFile;
		// File sFile = new File(filename + ".odt");
		File outFile = new File(filename + ".odt");

		if (filename == null) {
			return false;
		}
		try {
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
		} catch (IOException e) {
			// Something went wrong.
			success = false;
		}

		// Return our status.
		return success;
	}
}