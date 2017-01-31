import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

//microwaveB class
public class MicrowaveB extends Microwave
{

    final static int maxDevices = 2;
    static int currentDevices = 0;

    private JComboBox minutesInput, secondsInput, powerInput;

    public MicrowaveB()
    {
        //set colors and fonts
        backgroundColor = new Color(127, 21, 24);
        foregroundColor = new Color(183, 157, 112);
        identifierFont = new Font("Impact", Font.BOLD + Font.ITALIC, 24);
        label1Font = new Font("Impact", Font.BOLD, 20);
        label2Font = new Font("Impact", Font.ITALIC, 16);
        outputFont = new Font("Impact", Font.PLAIN, 24);
        buttonFont = new Font("Impact", Font.BOLD, 16);

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
        identifierLabel = new JLabel("Berserk Betty", SwingConstants.CENTER);
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

        //add input comboboxes
        minutesInput = new JComboBox();
        for (int i = 0; i < 60; i++)
        {
            minutesInput.addItem(Integer.toString(i));
        }
        minutesInput.setBorder(BorderFactory.createLineBorder(foregroundColor));
        minutesInput.setBackground(backgroundColor);
        minutesInput.setFont(buttonFont);
        minutesInput.setForeground(foregroundColor);
        inputPanel.add(minutesInput);

        secondsInput = new JComboBox();
        for (int i = 0; i < 60; i++)
        {
            secondsInput.addItem(Integer.toString(i));
        }
        secondsInput.setBorder(BorderFactory.createLineBorder(foregroundColor));
        secondsInput.setBackground(backgroundColor);
        secondsInput.setFont(buttonFont);
        secondsInput.setForeground(foregroundColor);
        inputPanel.add(secondsInput);

        powerInput = new JComboBox();
        for (int i = 0; i < 11; i++)
        {
            powerInput.addItem(Integer.toString(i * 10));
        }
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
            String minutesText = (String) minutesInput.getSelectedItem();
            String secondsText = (String) secondsInput.getSelectedItem();

            //add correct formating to minutes and seconds that are < 10
            if (Integer.parseInt(minutesText) < 10)
            {
                minutesText = "0" + minutesText;
            }

            if (Integer.parseInt(secondsText) < 10)
            {
                secondsText = "0" + secondsText;
            }

            //set the time
            timeDisplay.setText(minutesText + ":" + secondsText);

        } //if the power button was pressed
        else if (button == powerButton)
        {
            //get information from the gui
            String powerText = (String) powerInput.getSelectedItem();

            //set the power
            powerDisplay.setText(powerText + "%");
        }
    }

    @Override
    public void reset()
    {
        //reset the display labels and input fields
        timeDisplay.setText("00:00");
        powerDisplay.setText("100%");
    }
}
