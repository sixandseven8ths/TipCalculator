/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lati.cis236.tipcalculator;

import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author carsont
 */
public class TipCalculatorPanel extends JPanel implements ActionListener, ChangeListener {
    private static final long serialVersionUID = 1953994644457624024L;
	
    private JTextField  billTextField, rateTextField, finalBillTextField;
    private JLabel      billLabel, rateLabel, finalBillLabel;
    private JButton     calculateButton, exitButton;
    private JSlider     rateSlider;
            
	
    public TipCalculatorPanel()
    {
        // display panel
	JPanel displayPanel = new JPanel();
	displayPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        //rate slider
        rateSlider = new JSlider(0,50,0); //(low range, high range, default value)
        rateSlider.setMajorTickSpacing(10); 
        rateSlider.setMinorTickSpacing(1);
        rateSlider.setPaintTicks(true); //shows tick markings
        rateSlider.setPaintLabels(true); //shows numbers below ticks
        rateSlider.addChangeListener(this); //calls stateChanged event (coded below) when value changes
        displayPanel.add(rateSlider);
		
	// bill label
	billLabel = new JLabel("Bill Total:");
	displayPanel.add(billLabel);
		
	// bill text field
	billTextField = new JTextField(10);
	displayPanel.add(billTextField);
		
	// rate label
	rateLabel = new JLabel("Tip Amount:");
	displayPanel.add(rateLabel);
		
	// rate text field
	rateTextField = new JTextField(10);
	displayPanel.add(rateTextField);
		
		
	// final bill label
	finalBillLabel = new JLabel("Final Bill:");
	displayPanel.add(finalBillLabel);
		
	// final bill text field
	finalBillTextField = new JTextField(10);
	finalBillTextField.setEditable(false);
	finalBillTextField.setFocusable(false);
	displayPanel.add(finalBillTextField);
		
	// button panel
	JPanel buttonPanel = new JPanel();
	buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
	// calculate button
	//calculateButton = new JButton("Calculate");
	//calculateButton.addActionListener(this);
	//buttonPanel.add(calculateButton);
	
	// exit button
	exitButton = new JButton("Exit");
	exitButton.addActionListener(this);
	buttonPanel.add(exitButton);
	
	// add panels to main panel
	this.setLayout(new BorderLayout());
	this.add(displayPanel, BorderLayout.CENTER);
	this.add(buttonPanel, BorderLayout.SOUTH);
    }    
        
    public void actionPerformed(ActionEvent e)
    {
	//get which component caused the action
	Object source = e.getSource();
	
	//react accordingly
	if (source == exitButton)
	{
            System.exit(0);
	}
	else if (source == calculateButton)
	{
            //get values from the screen
            double bill = Double.parseDouble(billTextField.getText());
            double tipRate = Double.parseDouble(rateTextField.getText());
            
			
            //calculate the tip value 
            double tipAmount = TipCalculations.calculateTipAmount(tipRate, bill);
			
            //format and display the answer
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            finalBillTextField.setText(currency.format(tipAmount));
	}
    }
        public void stateChanged(ChangeEvent e)
        {
            // get the component that caused the action
            Object changed = e.getSource();
            
            if (changed == rateSlider)
            {
                //get values from the screen
                double mealAmount = Double.parseDouble(this.billTextField.getText());
                double tipPercent = this.rateSlider.getValue();
                
                //calculate the tip amount and total
                double tipAmount = TipCalculations.calculateTipAmount(mealAmount, tipPercent);
                
                //format and display the total meal
                NumberFormat currency = NumberFormat.getCurrencyInstance();
                double totalAmount = mealAmount + tipAmount;
                this.rateTextField.setText(currency.format(tipAmount));
                this.finalBillTextField.setText(currency.format(totalAmount));
            }
            
        }
}
