import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;

class openImageListener implements ActionListener {
	/**
	 * Private inner class that handles the event that is generated when the
	 * user selects Image File from the Image menu.
	 */

	private File recentDirectory = null;
	String filename;
	private static JTextPane editorText;
	BufferedImage buffImg;
	ImageIcon icon;
	private JLabel imageLabel;
	private ImageIcon image;

	public openImageListener(JTextPane editorText1, BufferedImage buffImg1,
			ImageIcon icon1, JLabel imageLabel1, ImageIcon image1) {
		editorText = editorText1;
		buffImg = buffImg1;
		icon = icon1;
		imageLabel = imageLabel1;
		image = image1;
	}

	public void actionPerformed(ActionEvent e) {
		int chooserStatus;

		JFileChooser chooser = null;
		if (recentDirectory != null) {
			chooser = new JFileChooser(recentDirectory);
		} else {
			chooser = new JFileChooser(recentDirectory);
		}

		chooser.setFileFilter(new FileNameExtensionFilter(
				"Image jpg, gif or png ", "jpg", "png", "gif"));
		chooserStatus = chooser.showOpenDialog(null);

		if (chooserStatus == JFileChooser.APPROVE_OPTION) {
			// Get a reference to the selected file.
			File selectedFile = chooser.getSelectedFile();

			// Get the path of the selected file.
			filename = selectedFile.getPath();

			// Open the file.
			try {
				if (!openImageFile(filename)) {
					JOptionPane.showMessageDialog(null, "Error reading "
							+ filename, "Error", JOptionPane.ERROR_MESSAGE);
				}
			} catch (HeadlessException e1) {

				e1.printStackTrace();
			}
			recentDirectory = chooser.getCurrentDirectory();
		}
	}

	private boolean openImageFile(String filename) {
		/**
		 * The openImageFile method opens the file specified by filename and
		 * reads its contents into the text area. The method returns true if the
		 * file was opened and read successfully, or false if an error occurred.
		 * 
		 * @param filename
		 *            The name of the file to open.
		 */

		boolean success = true;

		// new ImageIcon(myBufferedImage);

		File img = new File(filename);

		buffImg = new BufferedImage(240, 240, BufferedImage.TYPE_INT_ARGB);

		try {
			buffImg = ImageIO.read(img);
		} catch (IOException e) {
		}
		// System.Out.Println(buffImg.getType()); //Prints 0 instead of 2

		image = new ImageIcon(filename);
		icon = new ImageIcon(image.getImage().getScaledInstance(500, 500,
				Image.SCALE_DEFAULT));
		editorText.insertIcon(icon);
		editorText.setEditable(true);
		editorText.setFocusable(true);
		imageLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				if (arg0.getModifiers() == 4) // 16 for left, 8 for middle and 4
					// for right click
				{

					// popUpMenu();
					// editorText.add(popupMenu);
					// popupMenu.setVisible( true );

				}
			}

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

}