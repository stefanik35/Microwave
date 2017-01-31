import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Drew
 */

//microwaveC class
public class MicrowaveC extends Microwave
{

    final static int maxDevices = 2;
    static int currentDevices = 0;

    private JRadioButton minutesInput, secondsInput;
    private ButtonGroup timeButtons;

    public MicrowaveC()
    {
        //set colors and fonts
        backgroundColor = new Color(46, 50, 104);
        foregroundColor = new Color(153, 149, 121);
        identifierFont = new Font("Papyrus", Font.BOLD + Font.ITALIC, 24);
        label1Font = new Font("Papyrus", Font.BOLD, 20);
        label2Font = new Font("Papyrus", Font.ITALIC, 16);
        outputFont = new Font("Papyrus", Font.PLAIN, 24);
        buttonFont = new Font("Papyrus", Font.BOLD, 16);

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
        identifierLabel = new JLabel("Crazed Connie", SwingConstants.CENTER);
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

        //add input radio buttons
        minutesInput = new JRadioButton();
        minutesInput.setBackground(backgroundColor);
        minutesInput.setActionCommand("minutes");

        secondsInput = new JRadioButton();
        secondsInput.setActionCommand("seconds");
        secondsInput.setBackground(backgroundColor);

        //group the radio buttons
        timeButtons = new ButtonGroup();
        minutesInput.setSelected(true);
        timeButtons.add(minutesInput);
        timeButtons.add(secondsInput);

        //add the radio buttons to the panel
        inputPanel.add(minutesInput);
        inputPanel.add(secondsInput);

        inputPanel.add(new JLabel(""));

        //add buttons
        inputPanel.add(new JLabel(""));

        timeButton = new JButton("Time +");
        timeButton.setFont(buttonFont);
        timeButton.setForeground(backgroundColor);
        timeButton.setBackground(foregroundColor);
        inputPanel.add(timeButton);
        timeButton.addActionListener(this);

        powerButton = new JButton("Power -");
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
            Integer minutesText = Integer.parseInt(timeDisplay.getText().substring(0, 2));
            Integer secondsText = Integer.parseInt(timeDisplay.getText().substring(3, 5));

            if (timeButtons.getSelection().getActionCommand().equals("minutes"))
            {
                //increment the minutes
                minutesText++;

                //reset the minutes to 0 if it is > 59
                if (minutesText > 59)
                {
                    minutesText = 0;
                }
            } else
            {
                //increment the seconds
                secondsText++;

                //reset the seconds to 0 if it is > 59
                if (secondsText > 59)
                {
                    secondsText = 0;
                }

            }

            String minutesTextFinal = Integer.toString(minutesText);
            String secondsTextFinal = Integer.toString(secondsText);

            //add correct formating to minutes and seconds that are < 10
            if (minutesText < 10)
            {
                minutesTextFinal = "0" + minutesTextFinal;
            }

            if (secondsText < 10)
            {
                secondsTextFinal = "0" + secondsTextFinal;
            }

            //set the time
            timeDisplay.setText(minutesTextFinal + ":" + secondsTextFinal);

        } //if the power button was pressed
        else if (button == powerButton)
        {
            //get information from the gui
            Integer powerText = Integer.parseInt(powerDisplay.getText().substring(0, powerDisplay.getText().length() - 1));

            //decrement the power level
            powerText -= 10;

            //reset the power to 100 if it is negative
            if (powerText < 0)
            {
                powerText = 100;
            }

            //set the power
            powerDisplay.setText(Integer.toString(powerText) + "%");
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
