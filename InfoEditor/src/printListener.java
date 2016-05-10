import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.text.MessageFormat;

import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.SwingWorker;

class printListener implements ActionListener {

	private static JTextPane editorText;

	public printListener(JTextPane editorText1) {
		editorText = editorText1;
	}

	public void actionPerformed(ActionEvent e) {
		PrintingTask task = new PrintingTask(null, null, true);
		task.execute();
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
				complete = editorText.print(headerFormat, footerFormat, true,
						null, null, interactive);
				message = "Printing " + (complete ? "complete" : "canceled.");
			} catch (PrinterException ex) {
				message = "Sorry, a printer error occurred";
			} catch (SecurityException ex) {
				message = "Sorry, cannot access the printer due to security reasons";
			}
			return null;
		}

		@Override
		protected void done() {
			message(!complete, message);
		}
	}

	private void message(boolean error, String msg) {
		int type = (error ? JOptionPane.ERROR_MESSAGE
				: JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, msg, "Printing", type);
	}

}