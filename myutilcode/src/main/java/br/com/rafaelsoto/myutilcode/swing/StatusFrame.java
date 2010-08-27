package br.com.rafaelsoto.myutilcode.swing;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 *
 * @author Rafael Soto
 * 
 */
public class StatusFrame {

	
	private static StatusFrame instancia = null;
	
	private JDialog dlg = null;
	private JProgressBar dpb = null;
	private JLabel lbl = null;
	
	public static StatusFrame getInstancia()
	{
		if(instancia == null)
		{
			instancia  = new StatusFrame();
		}
		
		return instancia;
	}
	
	

	public void  initProgress(String title)
	{
			if(dlg == null){
		    dlg = new JDialog(new JFrame(),title, true);
		    dpb = new JProgressBar(0, 100);
		    dlg.add(BorderLayout.CENTER, dpb);
		    lbl = new JLabel("Iniciando...");
		    dlg.add(BorderLayout.NORTH, lbl);
		    dlg.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		    dlg.setSize(500, 75);
		    dlg.setLocation(getCenter(500, 75));
		    
		    Thread t = new Thread(new Runnable() {
			      public void run() {
			        dlg.setVisible(true);
			      }
			    });
			    t.start();
			}
	}
	
    public void setPercent(int percent)
    {
    	dpb.setValue(percent);
    }
    
    public void setText(String text)
    {
    	lbl.setText(text);
    }
	
	
    private Point getCenter(int alturaFrame, int larguraFrame) {

        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        Point center = new Point((tela.width - larguraFrame) / 2, (tela.height - alturaFrame) / 2);
        return center;
    }



	public void incPercent(int i) {
		
		dpb.setValue(dpb.getValue() + i);
		
	}
}