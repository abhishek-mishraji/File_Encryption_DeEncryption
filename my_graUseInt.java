
// Import necessary Java classes
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

// Declare a public class named my_graUseInt that extends JFrame and implements ActionListener
public class my_graUseInt extends JFrame implements ActionListener {
    // Declare private variables to be used in the class
    private JRadioButton encOpt, decOpt; // Radio buttons to select between encrypting and decrypting
    private JPasswordField pasFie; // Password field for user to input password
    private JTextField selFilPat; // Text field to show the file path that has been selected
    private JButton selCha, sub, can; // Buttons to select a file, submit the chosen options, or cancel
    private File selFil; // The file that has been selected by the user
    private JCheckBox shoPas; // Checkbox to show or hide the password

    // Declare a constructor method for the class
    my_graUseInt() {
        // Set the properties of the JFrame
        setTitle("Encryption & Decryption");
        setSize(500, 220);
        setResizable(true);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));
        getContentPane().setBackground(new Color(28, 37, 46));

        // Create a JPanel for the radio buttons to select between encrypting and
        // decrypting
        JPanel optPan = new JPanel(new FlowLayout());
        // ********************************************

        // ********************************************

        encOpt = new JRadioButton("Encrypt"); // Create a JRadioButton for encrypting
        encOpt.setFont(new Font("Cascadia Code", Font.PLAIN, 18));
        encOpt.setForeground(Color.WHITE);
        encOpt.setBackground(new Color(28, 37, 46));
        decOpt = new JRadioButton("Decrypt"); // Create a JRadioButton for decrypting
        decOpt.setFont(new Font("Cascadia Code", Font.PLAIN, 18));
        decOpt.setForeground(Color.WHITE);
        decOpt.setBackground(new Color(28, 37, 46));
        ButtonGroup optGro = new ButtonGroup(); // Create a ButtonGroup to group the radio buttons
        optGro.add(encOpt);
        optGro.add(decOpt);
        optPan.add(encOpt); // Add the "Encrypt" JRadioButton to the JPanel
        optPan.add(decOpt); // Add the "Decrypt" JRadioButton to the JPanel
        optPan.setBackground(new Color(28, 37, 46));
        add(optPan);

        // Create a JPanel for the password field
        JPanel pasPan = new JPanel(new FlowLayout());
        JLabel pasLab = new JLabel("Password "); // Create a JLabel for the password field
        pasLab.setFont(new Font("Cascadia Code", Font.PLAIN, 18));
        pasLab.setForeground(Color.WHITE);
        pasFie = new JPasswordField(20); // Create a JPasswordField for the user to input their password
        pasFie.setBackground(new Color(204, 238, 241));
        pasFie.setEchoChar('●'); // Set the password field to display bullets instead of characters
        pasPan.add(pasLab); // Add the JLabel for the password field to the JPanel

        // Add password field to the password panel
        pasPan.add(pasFie);

        // Create a "Show Password" checkbox
        shoPas = new JCheckBox("Show Password");

        // Set the font for the "Show Password" checkbox
        shoPas.setFont(new Font("Arial", Font.PLAIN, 18));

        // Set the foreground color of the "Show Password" checkbox to white
        shoPas.setForeground(Color.WHITE);

        // Set the background color of the "Show Password" checkbox
        shoPas.setBackground(new Color(28, 37, 46));

        // Add an ActionListener to the "Show Password" checkbox
        shoPas.addActionListener(this);

        // Add the "Show Password" checkbox to the password panel
        pasPan.add(shoPas);

        // Set the background color of the password panel
        pasPan.setBackground(new Color(28, 37, 46));

        // Add the password panel to the main panel
        add(pasPan);

        // Creating a new JPanel and setting its layout as FlowLayout
        JPanel filPan = new JPanel(new FlowLayout());

        // Creating a new JLabel and setting its text to "File"
        JLabel filLab = new JLabel("File ");

        // Setting the font of the label to Cascadia Code with size 18 and foreground
        // color to white
        filLab.setFont(new Font("Cascadia Code", Font.PLAIN, 18));
        filLab.setForeground(Color.WHITE);

        // Creating a new JTextField with a width of 20 characters and setting its
        // background color
        selFilPat = new JTextField(20);
        selFilPat.setBackground(new Color(204, 238, 241));

        // Making the text field not editable
        selFilPat.setEditable(false);

        // Creating a new JButton with text "Select" and setting its font
        selCha = new JButton("Select");
        selCha.setFont(new Font("Arial", Font.PLAIN, 18));

        // Adding an action listener to the button
        selCha.addActionListener(this);

        // Adding the label, text field, and button to the panel
        filPan.add(filLab);
        filPan.add(selFilPat);
        filPan.add(selCha);

        // Setting the background color of the panel
        filPan.setBackground(new Color(28, 37, 46));

        // Adding the panel to the parent container
        add(filPan);

        JPanel subCanPan = new JPanel(new FlowLayout()); // create a new JPanel with FlowLayout and assign it to
                                                         // subCanPan variable
        sub = new JButton("Submit"); // create a new JButton with "Submit" label and assign it to sub variable
        sub.setFont(new Font("Arial", Font.PLAIN, 18)); // set the font of sub button to Arial plain 18
        sub.addActionListener(this); // add an action listener to sub button and set it to this class
        can = new JButton("Cancel"); // create a new JButton with "Cancel" label and assign it to can variable
        can.setFont(new Font("Arial", Font.PLAIN, 18)); // set the font of can button to Arial plain 18
        can.addActionListener(this); // add an action listener to can button and set it to this class
        subCanPan.add(sub); // add sub button to subCanPan JPanel
        subCanPan.add(can); // add can button to subCanPan JPanel
        subCanPan.setBackground(new Color(28, 37, 46)); // set the background color of subCanPan to a custom color
        add(subCanPan); // add subCanPan to the parent container

        setVisible(true); // set the visibility of the parent container to true

    }

    public void actionPerformed(ActionEvent e) {
        // Check if the "Select" button is clicked
        if (e.getSource() == selCha) {
            // Open a file chooser dialog box
            JFileChooser filCho = new JFileChooser();
            int retVal = filCho.showOpenDialog(this);
            // If a file is selected, update the selected file path and button text
            if (retVal == JFileChooser.APPROVE_OPTION) {
                selFil = filCho.getSelectedFile();
                selFilPat.setText(selFil.getAbsolutePath());
                selCha.setText("Change");
            }
            // If no file is selected and there was no previous file selected, show an error
            // message
            else if (retVal != JFileChooser.APPROVE_OPTION && selFil == null) {
                JLabel mes = new JLabel("File Not Selected");
                mes.setFont(new Font("Arial", Font.BOLD, 16));
                JOptionPane.showMessageDialog(this, mes, "Message", JOptionPane.WARNING_MESSAGE);
            }
        }
        // Check if the "Submit" button is clicked
        else if (e.getSource() == sub) {
            // Check if a file is selected
            if (selFil != null) {
                // Check if a password is entered
                if (!(new String(pasFie.getPassword())).isEmpty()) {
                    // Check if an encryption or decryption option is selected
                    if (encOpt.isSelected() || decOpt.isSelected()) {
                        // Check if the encryption option is selected
                        if (encOpt.isSelected()) {
                            try {
                                // Call the encryption function and show a success message
                                my_encDec.encFil(selFil, new String(pasFie.getPassword()));
                                JLabel mes = new JLabel("Encryption done!");
                                mes.setFont(new Font("Arial", Font.BOLD, 16));
                                JOptionPane.showMessageDialog(this, mes);
                            }
                            // If there was an error during encryption, show an error message
                            catch (Exception ex) {
                                JLabel mes = new JLabel("Error! Try Again");
                                mes.setFont(new Font("Arial", Font.BOLD, 16));
                                JOptionPane.showMessageDialog(this, mes, "Message", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        // Check if the decryption option is selected
                        else if (decOpt.isSelected()) {
                            try {
                                // Call the decryption function and show a success message
                                my_encDec.encFil(selFil, new String(pasFie.getPassword()));
                                JLabel mes = new JLabel("Decryption done!");
                                mes.setFont(new Font("Arial", Font.BOLD, 16));
                                JOptionPane.showMessageDialog(this, mes);
                            }
                            // If there was an error during decryption, show an error message
                            catch (Exception ex) {
                                JLabel mes = new JLabel("Error! Try Again");
                                mes.setFont(new Font("Arial", Font.BOLD, 16));
                                JOptionPane.showMessageDialog(this, mes, "Message", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                    // If no encryption or decryption option is selected, show an error message
                    else {
                        JLabel mes = new JLabel("Please Select an Option (Encrypt or Decrypt)");
                        mes.setFont(new Font("Arial", Font.BOLD, 16));
                        JOptionPane.showMessageDialog(this, mes);
                    }
                }
                // If no password is entered, show an error message
                else {
                    JLabel mes = new JLabel("Please Enter Password");
                    mes.setFont(new Font("Arial", Font.BOLD, 16));
                    JOptionPane.showMessageDialog(this, mes);
                }
            }
            // If no file is selected, show an error message
            else {
                JLabel mes = new JLabel("Please Select a File");
                mes.setFont(new Font("Arial", Font.BOLD, 16));
                JOptionPane.showMessageDialog(this, mes);
            }
        } // If the source of the event is the show password checkbox
        else if (e.getSource() == shoPas) {
            // If the checkbox is selected, set the echo char of the password field to 0
            // (show password)
            // Else, set the echo char to the default bullet character (hide password)("\
            // -- \ u" -- represent unicode char)
            pasFie.setEchoChar(shoPas.isSelected() ? '\u0000' : '●');
        }
        // Else if the source of the event is the cancel button
        else if (e.getSource() == can) {
            // Dispose of the window and exit the program with status code 1
            dispose();
            System.exit(1);
        }
    }

    // The main method creates a new instance of the my_graUseInt class
    public static void main(String[] args) {
        new back_image();
        new my_graUseInt();
    }
}