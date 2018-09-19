/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lati.cis236.tipcalculator;

/**
 *
 * @author jeffrey.herold
 */
public class TipCalculations {

    //static method to calculate future value
    public static double calculateTipAmount(double bill, double tipRate)
    {   
        //initialize return value
        double tipAmount = 0;
        
        tipAmount = (tipRate/100) * bill;
        
        //return final answer
        return tipAmount;
    }
}
