/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lati.cis236.tipcalculator;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author carsont
 */
public class TipCalculatorFrame extends JFrame{
    private static final long serialVersionUID = -8504971114550565790L;

	//default constructor
	public TipCalculatorFrame()
    {
	//set parameters for entire frame 
        setTitle("Tip Calculator");
        setSize(250, 200);
        centerWindow(this);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //declare panel object (contains components)
        JPanel panel = new TipCalculatorPanel();
        
        //add panel to this frame
        this.add(panel);
    }

    private void centerWindow(Window w)
    {
    	//center form on screen
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        setLocation((d.width-w.getWidth())/2, (d.height-w.getHeight())/2);
    }
}