package logogui;

import javax.swing.JTextArea;

public class Log {
	private static Log instance;
	private JTextArea logZone;
	public static Log getInstance() {
		if (instance == null)
			instance = new Log();
		return instance;
	}
	public void setLogZone(JTextArea zone) {
		logZone = zone;
	}
	public static void append(String s) {
		getInstance().getLogZone().append(s);
	}
	public static void appendnl(String s) {
		getInstance().getLogZone().append(s + "\n");
	}
	public JTextArea getLogZone() {
		return logZone;
	}
}
