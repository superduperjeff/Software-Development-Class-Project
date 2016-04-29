/**
      Private inner class that handles the event that
      is generated when the user selects New from 
      the file menu.
*/

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.BadLocationException;

class webListener implements ActionListener{
	
	private JLabel webLabel = new JLabel();	
	private static JTextPane editorText;// To display the text

	public webListener(JTextPane editorText1){
		editorText = editorText1;
	}
	
 	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("Import Picture from Web")){
			openURLImage();
		}
		if (e.getActionCommand().equals("Sample Text from Website")){
			openURLText();
		}
	}


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
					System.out.println("image" + image);
					System.out.println("imageIcon" + imageIcon);
					webLabel = new JLabel(new ImageIcon(imageIcon.getImage().getScaledInstance(700, 500, Image.SCALE_DEFAULT)));
					System.out.println("webLable" + webLabel);

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


}
