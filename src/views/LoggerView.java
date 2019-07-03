package views;


import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class LoggerView extends JPanel {
	private JScrollPane scrollPane;
	
	private DefaultListModel<String> dlm = new DefaultListModel<String>();
	private JList<String> lstLogger = new JList<String>();
	private DefaultListModel<String> fileBuffer  = new DefaultListModel<String>();



	/**
	 * 
	 */
	public LoggerView() {
		setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		

		lstLogger.setModel(dlm);
	    scrollPane.setViewportView(lstLogger);



	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public DefaultListModel<String> getLogs() {
		return dlm;
	}

	public JList<String> getLstLogger() {
		return lstLogger;
	}

	public void setLstLogger(JList<String> lstLogger) {
		this.lstLogger = lstLogger;
	}

	public DefaultListModel<String> getFileBuffer() {
		return fileBuffer;
	}

	public void setFileBuffer(DefaultListModel<String> fileBuffer) {
		this.fileBuffer = fileBuffer;
	}
	
	


}