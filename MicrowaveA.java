import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Drew
 */

//microwaveA class
public class MicrowaveA extends Microwave
{

    final static int maxDevices = 2;
    static int currentDevices = 0;

    private JTextField minutesInput, secondsInput, powerInput;

    public MicrowaveA()
    {
        //set colors and fonts
        backgroundColor = new Color(42, 28, 45);
        foregroundColor = new Color(205, 170, 105);
        identifierFont = new Font("Bookman Old Style", Font.BOLD + Font.ITALIC, 24);
        label1Font = new Font("Bookman Old Style", Font.BOLD, 20);
        label2Font = new Font("Bookman Old Style", Font.ITALIC, 16);
        outputFont = new Font("Bookman Old Style", Font.PLAIN, 24);
        buttonFont = new Font("Bookman Old Style", Font.BOLD, 16);

        //create the microwave frame
        microwaveFrame = new JFrame();
        microwaveFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        microwaveFrame.setLayout(new BorderLayout());

        //create identifier panel
        identifierPanel = new JPanel();
        identifierPanel.setLayout(new GridLayout(1, 1));
        identifierPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        identifierPanel.setBackground(backgroundColor);

        //create identifier label
        identifierLabel = new JLabel("Agitated Annie", SwingConstants.CENTER);
        identifierLabel.setFont(identifierFont);
        identifierLabel.setForeground(foregroundColor);
        identifierPanel.add(identifierLabel);

        //create display panel
        displayPanel = new JPanel();
        displayPanel.setLayout(new GridLayout(2, 2));
        displayPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        displayPanel.setBackground(backgroundColor);

        //add labels
        timeLabel = new JLabel("Current Time", SwingConstants.CENTER);
        timeLabel.setFont(label1Font);
        timeLabel.setForeground(foregroundColor);
        displayPanel.add(timeLabel);

        powerLabel = new JLabel("Current Power", SwingConstants.CENTER);
        powerLabel.setFont(label1Font);
        powerLabel.setForeground(foregroundColor);
        displayPanel.add(powerLabel);

        //add output labels
        timeDisplay = new JLabel("00:00", SwingConstants.CENTER);
        timeDisplay.setFont(outputFont);
        timeDisplay.setForeground(foregroundColor);
        displayPanel.add(timeDisplay);

        powerDisplay = new JLabel("100%", SwingConstants.CENTER);
        powerDisplay.setFont(outputFont);
        powerDisplay.setForeground(foregroundColor);
        displayPanel.add(powerDisplay);

        //create time panel
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 3));
        inputPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        inputPanel.setBackground(backgroundColor);

        //add function labels
        setTime = new JLabel("Set Cooking Time", SwingConstants.RIGHT);
        setTime.setFont(label1Font);
        setTime.setForeground(foregroundColor);
        inputPanel.add(setTime);

        inputPanel.add(new JLabel(""));

        setPower = new JLabel("Set Power Level", SwingConstants.RIGHT);
        setPower.setFont(label1Font);
        setPower.setForeground(foregroundColor);
        inputPanel.add(setPower);

        //add more labels
        minutesInputLabel = new JLabel("Minutes", SwingConstants.CENTER);
        minutesInputLabel.setFont(label2Font);
        minutesInputLabel.setForeground(foregroundColor);
        inputPanel.add(minutesInputLabel);

        secondsInputLabel = new JLabel("Seconds", SwingConstants.CENTER);
        secondsInputLabel.setFont(label2Font);
        secondsInputLabel.setForeground(foregroundColor);
        inputPanel.add(secondsInputLabel);

        powerInputLabel = new JLabel("Power", SwingConstants.CENTER);
        powerInputLabel.setFont(label2Font);
        powerInputLabel.setForeground(foregroundColor);
        inputPanel.add(powerInputLabel);

        //add input fields
        minutesInput = new JTextField("");
        minutesInput.setBorder(BorderFactory.createLineBorder(foregroundColor));
        minutesInput.setBackground(backgroundColor);
        minutesInput.setFont(buttonFont);
        minutesInput.setForeground(foregroundColor);
        inputPanel.add(minutesInput);

        secondsInput = new JTextField("");
        secondsInput.setBorder(BorderFactory.createLineBorder(foregroundColor));
        secondsInput.setBackground(backgroundColor);
        secondsInput.setFont(buttonFont);
        secondsInput.setForeground(foregroundColor);
        inputPanel.add(secondsInput);

        powerInput = new JTextField("");
        powerInput.setBorder(BorderFactory.createLineBorder(foregroundColor));
        powerInput.setBackground(backgroundColor);
        powerInput.setFont(buttonFont);
        powerInput.setForeground(foregroundColor);
        inputPanel.add(powerInput);

        //add buttons
        inputPanel.add(new JLabel(""));

        timeButton = new JButton("Set Time");
        timeButton.setFont(buttonFont);
        timeButton.setForeground(backgroundColor);
        timeButton.setBackground(foregroundColor);
        inputPanel.add(timeButton);
        timeButton.addActionListener(this);

        powerButton = new JButton("Set Power");
        powerButton.setFont(buttonFont);
        powerButton.setForeground(backgroundColor);
        powerButton.setBackground(foregroundColor);
        inputPanel.add(powerButton);
        powerButton.addActionListener(this);

        //add the panels to the frame
        microwaveFrame.add(identifierPanel, BorderLayout.NORTH);
        microwaveFrame.add(displayPanel, BorderLayout.WEST);
        microwaveFrame.add(inputPanel, BorderLayout.CENTER);

        microwaveFrame.pack();
        microwaveFrame.setVisible(true);

    }

    //handles the input buttons
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        //see which button sent the event
        Object button = ae.getSource();

        //if the time button was pressed
        if (button == timeButton)
        {
            //get information from the gui
            String minutesText = minutesInput.getText();
            String secondsText = secondsInput.getText();

            //parse minute input
            try
            {
                cookMinutes = Integer.parseInt(minutesText);
            } catch (NumberFormatException e)
            {
                cookMinutes = -1;
            }

            //parse second input
            try
            {
                cookSeconds = Integer.parseInt(secondsText);
            } catch (NumberFormatException e)
            {
                cookSeconds = -1;
            }

            //if the input is invalid, return
            if ((cookMinutes < 0 || cookMinutes > 59) || (cookSeconds < 0 || cookSeconds > 59))
            {
                minutesInput.setText("INVALID");
                secondsInput.setText("INPUT");

                return;
            }

            String minutesTextFinal = Integer.toString(cookMinutes);
            String secondsTextFinal = Integer.toString(cookSeconds);

            //add correct formating to minutes and seconds that are < 10
            if (Integer.parseInt(minutesText) < 10)
            {
                minutesText = "0" + minutesText;
            }

            if (Integer.parseInt(secondsText) < 10)
            {
                secondsText = "0" + secondsText;
            }

            //set the time and clear the input boxes
            timeDisplay.setText(minutesText + ":" + secondsText);
            minutesInput.setText("");
            secondsInput.setText("");
        } //if the power button was pressed
        else if (button == powerButton)
        {
            //get information from the gui
            String powerText = powerInput.getText();

            //parse power input
            try
            {
                powerPercent = Integer.parseInt(powerText);
            } catch (NumberFormatException e)
            {
                powerPercent = -1;
            }

            //if the input is invalid, return
            if ((powerPercent < 0 || powerPercent > 100) || (powerPercent % 10 != 0))
            {
                powerInput.setText("INVALID INPUT");

                return;
            }

            //set the power and clear the input boxes
            powerDisplay.setText(Integer.toString(powerPercent) + "%");
            powerInput.setText("");
        }
    }

    @Override
    public void reset()
    {
        //reset the display labels and input fields
        timeDisplay.setText("00:00");
        minutesInput.setText("");
        secondsInput.setText("");
        powerDisplay.setText("100%");
        powerInput.setText("");
    }
}
