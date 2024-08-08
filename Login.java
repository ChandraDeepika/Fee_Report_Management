import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Class definition for the Login screen
class Login implements ActionListener
{
    // Attributes for the Login screen
    JFrame frame;
    JLabel label1,label2,label3;
    JTextField textField1;
    JPasswordField passwordField;
    JButton Login,Cancel;
    fees F; // Instance of fees class
    ForgotPassword FP;

    // Constructor to initialize the Login screen
    public Login() {
    // Create the frame for the Login screen
    frame=new JFrame("Login");
    frame.getContentPane().setLayout(null);  // Using null layout for precise positioning
    frame.getContentPane().setBackground(Color.black); // Set background color

    // Create and configure labels for the Login screen
    label3=new JLabel("Login ");
    label3.setForeground(Color.white);
    label3.setBounds(700,150,200,70);    // Set position and size
    label3.setFont(new Font("Courier new",Font.BOLD,40));

    
    label1=new JLabel("User Name");
    label1.setForeground(Color.yellow);
    label1.setBounds(450,350,200,30);
    label1.setFont(new Font("Courier new",Font.BOLD,20));

    label2=new JLabel("Password");
    label2.setForeground(Color.yellow);
    label2.setBounds(450,400,200,30);
    label2.setFont(new Font("Courier new",Font.BOLD,20));

    // Create and configure text fields for user input
    textField1=new JTextField(10);
    textField1.setForeground(Color.blue);
    textField1.addActionListener(this);  // Add action listener for handling events
    textField1.setBounds(650,350,200,30);


    passwordField=new JPasswordField(10);
    passwordField.setForeground(Color.blue);
    passwordField.setEchoChar('*');  // Mask the password
    passwordField.addActionListener(this);
    passwordField.setBounds(650,400,200,30);

    // Create and configure buttons for Login and Cancel actions
    Login=new JButton("Login");
    Login.setForeground(Color.BLACK);
    Login.addActionListener(this);
    Login.setBounds(650,470,80,30);

    //  Forgot password
    Cancel=new JButton("Cancel");
    Cancel.setForeground(Color.BLACK);
    Cancel.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            frame.setVisible(false);
            FP = new ForgotPassword();
        }
    });
    Cancel.setBounds(780,470,80,30);

    
    
/* */
    JLabel forgotPasswordLabel = new JLabel("Forgot Password?");
    forgotPasswordLabel.setForeground(Color.white);
    forgotPasswordLabel.setBounds(650, 500, 450, 100);
    forgotPasswordLabel.setFont(new Font("Courier new", Font.BOLD, 20));
    frame.getContentPane().add(forgotPasswordLabel);


    // Add components to the frame
    frame.getContentPane().add(label1);
    frame.getContentPane().add(label2);
    frame.getContentPane().add(textField1);
    frame.getContentPane().add(passwordField);
    frame.getContentPane().add(Login);
    frame.getContentPane().add(Cancel);
    frame.getContentPane().add(label3);

    // Set frame size and visibility
    frame.setSize(1366,768);
    frame.setVisible(true);
}

    // Method to handle action events
    public void actionPerformed(ActionEvent e){
    // Check if the Login button is clicked
    if(e.getSource()==Login)
    {
        // Validate user input
        if(textField1.getText().length()==0||passwordField.getText().length()==0) {
        // Display error message if fields are empty
            JOptionPane.showMessageDialog(null,"Fields are empty");
        }

        else if(textField1.getText().equals("ChandraDeepika") && passwordField.getText().equals("admin"))
        {
            // If credentials are valid, hide the Login screen and display fees screen
            frame.setVisible(false);
            F=new fees();
        }

        else
        {
            // If credentials are invalid, display error message
            JOptionPane.showMessageDialog(null,"Invalid User Name or Password");
        }
    }


    // Check if the Cancel button is clicked
    if(e.getSource()==Cancel)
    {
        frame.setVisible(false);
        System.exit(0);
    }
    }

    // Method to validate user input
    private boolean validateInput() {
        if (textField1.getText().isEmpty() || passwordField.getPassword().length == 0) {
            // Display error message if fields are empty
            JOptionPane.showMessageDialog(null, "Fields are empty");
            return false;
        }
        return true;
    }

    // Method to clear input fields
    private void clearFields() {
        textField1.setText("");
        passwordField.setText("");
    }
    


}

// Class definition for the Help screen
class Help extends JFrame implements ActionListener {
    // Attributes for the Help screen
    JLabel label1;
    JButton OK;

    // Constructor to initialize the Help screen
    public Help() {
        // Create the frame for the Help screen
        super("Help");
        setLayout(null);
        setBackground(Color.black);

        // Create and configure labels for the Help screen
        label1=new JLabel("Enter User Name as 'ChandraDeepika' and Password as 'admin' to login.");
        label1.setForeground(Color.white);
        label1.setBounds(450,350,400,50);
        label1.setFont(new Font("Courier new",Font.BOLD,20));

        // Create and configure buttons for OK action
        OK=new JButton("OK");
        OK.setForeground(Color.BLACK);
        OK.addActionListener(this);
        OK.setBounds(650,450,80,30);

        // Add components to the frame
        add(label1);
        add(OK);

        // Set frame size and visibility
        setSize(1366,768);
        setVisible(true);
    }

    // Method to handle action events
    public void actionPerformed(ActionEvent e) {
        // Check if the OK button is clicked
        if (e.getSource() == OK) {
            // Hide the Help screen
            setVisible(false);
            // Show the Login screen
            new Login();
        }
    }
}





