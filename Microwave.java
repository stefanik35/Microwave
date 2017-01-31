/********************************************************************
Class:     CSCI 470 (Grad)
Program:   Microwave.java
Author:    Drew Stefanik
Z-number:  z1753912

Purpose:   creates various microwave UI's

Execution: java Microwave

*********************************************************************/

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//abstract microwave class
//contains main function to create the screen
public abstract class Microwave implements ActionListener, CookingFunctions
{
    //declare common variables
    int cookSeconds;
    int cookMinutes;
    int powerPercent;

    JFrame microwaveFrame;
    JPanel inputPanel, identifierPanel, displayPanel;
    JLabel timeDisplay1, powerDisplay1;
    JLabel identifierLabel;
    JLabel timeLabel, powerLabel, timeDisplay, powerDisplay;
    JLabel setTime, setPower, minutesInputLabel, secondsInputLabel, powerInputLabel;
    JButton timeButton, powerButton;

    Color backgroundColor, foregroundColor;
    Font identifierFont, label1Font, label2Font, outputFont, buttonFont;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //create the screen
        Screen s = new Screen();
    }
}
