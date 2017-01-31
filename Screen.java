import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author Drew
 */

//sets up the screen
public class Screen implements ActionListener
{

    JFrame screenFrame;
    JMenuBar menuBar;
    JMenu create, resetAll, aboutUs;
    JMenuItem createMicrowaveA, createMicrowaveB, createMicrowaveC, createMicrowaveD, aboutUsItem, resetAllItem;
    
    ArrayList<CookingFunctions> microwaves;

    public Screen()
    {
        //create the screen frame
        screenFrame = new JFrame();

        //create the menu bar
        menuBar = new JMenuBar();

        //create the menus
        create = new JMenu("Create");
        resetAll = new JMenu("Reset All");
        aboutUs = new JMenu("About Us");

        //create the menu items
        createMicrowaveA = new JMenuItem("Microwave A");
        createMicrowaveB = new JMenuItem("Microwave B");
        createMicrowaveC = new JMenuItem("Microwave C");
        createMicrowaveD = new JMenuItem("Microwave D");
        aboutUsItem = new JMenuItem("Drew Stefanik");
        resetAllItem = new JMenuItem("Reset All");

        //add action listeners to the menu items
        createMicrowaveA.addActionListener(this);
        createMicrowaveB.addActionListener(this);
        createMicrowaveC.addActionListener(this);
        createMicrowaveD.addActionListener(this);
        resetAllItem.addActionListener(this);

        //add menu items to menus
        create.add(createMicrowaveA);
        create.add(createMicrowaveB);
        create.add(createMicrowaveC);
        create.add(createMicrowaveD);
        aboutUs.add(aboutUsItem);
        resetAll.add(resetAllItem);

        //add menus to menu bars
        menuBar.add(create);
        menuBar.add(resetAll);
        menuBar.add(aboutUs);

        //set up the screen frame
        screenFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screenFrame.setJMenuBar(menuBar);

        screenFrame.pack();
        screenFrame.setSize(300, 100);
        screenFrame.setVisible(true);

        microwaves = new ArrayList();
    }

    //handles the menu buttons
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        //see which menu item sent the event
        Object item = ae.getSource();

        //create microwave objects if those buttons are pressed
        //check how many of that type of microwave exists
        //add a new microwave to the arraylist and increment the count
        if (item == createMicrowaveA)
        {
            if (MicrowaveA.currentDevices >= 2)
            {
                JOptionPane.showMessageDialog(new JFrame(), "Can only create two of each type of microwave", "Too Many Microwaves", 0);
            } else
            {
                MicrowaveA mA = new MicrowaveA();
                MicrowaveA.currentDevices += 1;
                microwaves.add(mA);
            }
        }
        else if (item == createMicrowaveB)
        {
            if (MicrowaveB.currentDevices >= 2)
            {
                JOptionPane.showMessageDialog(new JFrame(), "Can only create two of each type of microwave", "Too Many Microwaves", 0);
            } else
            {
                MicrowaveB mB = new MicrowaveB();
                MicrowaveB.currentDevices += 1;
                microwaves.add(mB);
            }
        }
        else if (item == createMicrowaveC)
        {
            if (MicrowaveC.currentDevices >= 2)
            {
                JOptionPane.showMessageDialog(new JFrame(), "Can only create two of each type of microwave", "Too Many Microwaves", 0);
            } else
            {
                MicrowaveC mC = new MicrowaveC();
                MicrowaveC.currentDevices += 1;
                microwaves.add(mC);
            }
        }
        else if (item == createMicrowaveD)
        {
            if (MicrowaveD.currentDevices >= 2)
            {
                JOptionPane.showMessageDialog(new JFrame(), "Can only create two of each type of microwave", "Too Many Microwaves", 0);
            } else
            {
                MicrowaveD mD = new MicrowaveD();
                MicrowaveD.currentDevices += 1;
                microwaves.add(mD);
            }
        } //reset all active microwaves
        else if(item == resetAllItem)
        {
            for(CookingFunctions cF: microwaves)
            {
                cF.reset();
            }
        }
    }
}
