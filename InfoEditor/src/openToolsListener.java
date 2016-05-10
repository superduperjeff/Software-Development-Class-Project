import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

class openToolsListener implements ActionListener {
	BufferedImage buffImg;
	private static JTextPane editorText;
	private JLabel imageLabel;
	private JPopupMenu popupMenu;

	public openToolsListener(JTextPane editorText1, BufferedImage buffImg1,
			JLabel imageLabel1, JPopupMenu popupMenu1) {
		editorText = editorText1;
		buffImg = buffImg1;
		imageLabel = imageLabel1;
		popupMenu = popupMenu1;
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand() == "Select Part of Image") {
			System.out.println("Here I am ");
			// Image imageB = image.getImage();
			// BufferedImage buffered = (BufferedImage) imageB;
			System.out.println("buffimg=" + buffImg);
			Subimages test = new Subimages(buffImg);
			JFrame f = new JFrame();
			f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			f.getContentPane().add(new JScrollPane(test));
			f.setSize(400, 400);
			f.setLocation(200, 200);
			f.setVisible(true);
			test.createSubimage();

		}
	}

	public class Subimages extends JPanel {
		Rectangle clip = new Rectangle(50, 50, 250, 250);
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
			origin.x = (getWidth() - imageB.getWidth()) / 2;
			origin.y = (getHeight() - imageB.getHeight()) / 2;
			g.drawImage(imageB, origin.x, origin.y, this);
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setPaint(Color.red);
			g2.draw(clip);
		}

		/*
		 * public Dimension getPreferredSize() { return new
		 * Dimension(imageB.getWidth(), imageB.getHeight()); }
		 */

		private void createSubimage() {
			// Wait for gui to settle down.
			new Thread(new Runnable() {
				public void run() {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
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
					BufferedImage copy = GraphicsEnvironment
							.getLocalGraphicsEnvironment()
							.getDefaultScreenDevice().getDefaultConfiguration()
							.createCompatibleImage(w, h);
					System.out.println("copy type = " + copy.getType());
					Graphics2D g2 = copy.createGraphics();
					g2.drawImage(subimage, 0, 0, null);
					g2.dispose();
					JOptionPane.showMessageDialog(null, new ImageIcon(copy),
							"", -1);
				}
			}).start();
		}

		private class ImageMenuListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Delete")) {
					// editorText.insertIcon(g);

					editorText.remove(imageLabel);
					// editorText.repaint();
					popupMenu.setVisible(false);
					// repaint();
				} else if (e.getActionCommand().equals("Exit")) {
					popupMenu.setVisible(false);
					repaint();

				}

			}
		}
	}

}