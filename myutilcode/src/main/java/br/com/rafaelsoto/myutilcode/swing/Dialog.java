package br.com.rafaelsoto.myutilcode.swing;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 * Implements a dialogs GUI swing based
 * @author Rafael Soto
 *
 */
public class Dialog {
	
	/**
	 * Show a input text dialog with password mask
	 * @param title The dialog title
	 * @param content The question to ask for user
	 * @return 
	 */
	public static String showPasswordDialog(String title, String content)
	{
		JLabel label = new JLabel(title);
		JPasswordField jpf = new JPasswordField();
		JOptionPane.showConfirmDialog(null,
		new Object[]{label, jpf}, content,
		JOptionPane.OK_OPTION); 
		
		return new String(jpf.getPassword());
	}
	
	/**
	 * Show a openfile component to get a user selected file
	 * @return
	 */
	public static File showOpenFileDialog()
	{
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		chooser.showSaveDialog(null);
		
		return chooser.getSelectedFile();
	}
	
	/**
	 * Simple message dialog
	 * @param message
	 */
	public static void showMessageDialog(String message)
	{
		JOptionPane.showMessageDialog(null, message);
	}
	
	/**
	 * Warn message dialog
	 * @param title
	 * @param message
	 */
	public static void showMessageDialog(String title, String message)
	{
		JOptionPane.showMessageDialog(null, message,title,JOptionPane.WARNING_MESSAGE);
	}
}
