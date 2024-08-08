import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ForgotPassword extends JFrame implements ActionListener {
    // Attributes for the ForgotPassword screen
    private JFrame frame;
    private JLabel label1, label2, label3, label4;
    private JTextField textField1, textField2, textField3,textfield4;
    private JButton Submit, Cancel;
    private String username = "ChandraDeepika";
    private int answer1 = 51015, answer2 = 9328, answer3 = 5;
    private int userAnswer1, userAnswer2, userAnswer3;
    private boolean isAuthenticated = false;

    // Constructor to initialize the ForgotPassword screen
    public ForgotPassword() {

        
        // Create the frame for the ForgotPassword screen
        super("Forgot Password");
        setLayout(null);
        setBackground(new Color(211, 211, 211));


        // Create and configure the title label
        JLabel titleLabel = new JLabel("Forgot Password", SwingConstants.CENTER);
        // Create and configure the title labelJLabel titleLabel = new JLabel("Forgot Password", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(Color.orange);
        titleLabel.setOpaque(true);
        //titleLabel.setBackground(Color.WHITE);
        titleLabel.setBounds(0, 0, 1366, 100);

        // Create and configure labels for the ForgotPassword screen
        label1 = new JLabel("Enter your User Name:");
        label1.setForeground(Color.BLACK);
        label1.setBounds(300, 200, 700, 30);
        label1.setFont(new Font("Arial", Font.BOLD, 17));

        label2 = new JLabel("What is your employee ID number?");
        label2.setForeground(Color.BLACK);
        label2.setBounds(300, 250, 700, 30);
        label2.setFont(new Font("Arial", Font.BOLD, 17));

        label3 = new JLabel("What is the last four digits of your office phone number?");
        label3.setForeground(Color.BLACK);
        label3.setBounds(300, 300, 1000, 30);
        label3.setFont(new Font("Arial", Font.BOLD, 17));

        
        label4 = new JLabel("How many years have you been in your current administrative position?\r\n" );
        label4.setForeground(Color.BLACK);
        label4.setBounds(300, 350, 1000, 30);
        label4.setFont(new Font("Arial", Font.BOLD, 17));
        
        
        textField1 = new JTextField(10);
        textField1.setForeground(Color.blue);
        textField1.setBounds(650, 200, 200, 30);

        textField2 = new JTextField(10);
        textField2.setForeground(Color.blue);
        textField2.setBounds(650, 400, 200, 30);

        textField3 = new JTextField(10);
        textField3.setForeground(Color.blue);
        textField3.setBounds(650, 450, 200, 30);

        textfield4 = new JTextField(10);
        textfield4.setForeground(Color.blue);
        textfield4.setBounds(650, 450, 200, 30);

        // Create and configure buttons for Submit and Cancel actions
        Submit = new JButton("Submit");
        Submit.setForeground(Color.BLACK);
        Submit.addActionListener(this);
        Submit.setBounds(650, 220, 80, 30);

        Cancel = new JButton("Cancel");
        Cancel.setForeground(Color.BLACK);
        Cancel.addActionListener(this);

        // Set frame size and visibility
        setSize(1366, 768);
        setVisible(true);
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridx = 0;
        constraints.gridx = 0;
        add(titleLabel,constraints);

        // Add components to the frame
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(label1, constraints);

        constraints.gridx = 1;
        add(textField1, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        add(label2, constraints);

        constraints.gridx = 1;
        add(textField2, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        add(label3, constraints);

        constraints.gridx = 1;
        add(textField3, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        add(label4, constraints);

        constraints.gridx = 1;
        add(textfield4, constraints);

        constraints.gridx = 1;
        constraints.gridy = 5;
        add(Submit,constraints);

        constraints.gridx = 2;
        constraints.gridy = 5;
        add(Cancel,constraints);


        //constraints.gridx = 0;
    }

    // Method to handle action events
    public void actionPerformed(ActionEvent e) {
        // Check if the Submit button is clicked
        if (e.getSource() == Submit) {
            // Validate user input
            if (textField1.getText().equals(username)) {
                userAnswer1 = Integer.parseInt(textField2.getText());
                userAnswer2 = Integer.parseInt(textField3.getText());
                userAnswer3 = Integer.parseInt(textfield4.getText());
                
                // Check if user answers match the correct answers
                if (userAnswer1 == answer1 && userAnswer2 == answer2 && userAnswer3 ==  answer3 ) {
                    isAuthenticated = true;
                }

                else {
                    JOptionPane.showMessageDialog(null, "Incorrect answers. Please try again.");
                    isAuthenticated = false;
                }

                // If user is authenticated, hide the ForgotPassword screen and display the Login screen
                if (isAuthenticated) {
                    setVisible(false);
                    new ResetPassword(username);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect username. Please try again.");
            }
        }

        // Check if the Cancel button is clicked
        if (e.getSource() == Cancel) {
            setVisible(false);
            new Login();
        }
    }
}

// Class definition for the ResetPassword screen
class ResetPassword extends JFrame implements ActionListener {
    // Attributes for the ResetPassword screen
    JLabel label1, label2;
    JPasswordField passwordField1, passwordField2;
    JButton Submit, Cancel;
    String username;

    // Constructor to initialize the ResetPassword screen
    public ResetPassword(String username) {
        // Create the frame for the ResetPassword screen
        super("Reset Password");
        setLayout(null);
        setBackground(Color.black);

        JLabel titleLabel2 = new JLabel("Reset Password", SwingConstants.CENTER);
        // Create and configure the title labelJLabel titleLabel = new JLabel("Forgot Password", SwingConstants.CENTER);
        titleLabel2.setFont(new Font("Arial", Font.BOLD, 33));
        titleLabel2.setForeground(Color.orange);
        titleLabel2.setOpaque(true);
        titleLabel2.setBackground(Color.WHITE);
        titleLabel2.setBounds(0, 0, 1366, 100);

        add(titleLabel2);

        // Create and configure labels for the ResetPassword screen
        label1 = new JLabel("Enter your new Password:");
        label1.setForeground(Color.BLACK);
        label1.setBounds(300, 250, 400, 30);
        label1.setFont(new Font("Courier new", Font.BOLD, 20));

        label2 = new JLabel("Confirm your new Password:");
        label2.setForeground(Color.BLACK);
        label2.setBounds(300, 300, 400, 30);
        label2.setFont(new Font("Courier new", Font.BOLD, 20));

        // Create and configure password fields for user input
        passwordField1 = new JPasswordField(10);
        passwordField1.setForeground(Color.blue);
        passwordField1.setBounds(650, 250, 200, 30);

        passwordField2 = new JPasswordField(10);
        passwordField2.setForeground(Color.blue);
        passwordField2.setBounds(650, 300, 200, 30);

        // Create and configure buttons for Submit and Cancel actions
        Submit = new JButton("Submit");
        Submit.setForeground(Color.BLACK);
        Submit.addActionListener(this);
        Submit.setBounds(650, 350, 80, 30);

        Cancel = new JButton("Cancel");
        Cancel.setForeground(Color.BLACK);
        Cancel.addActionListener(this);
        Cancel.setBounds(780, 350, 80, 30);

        // Add components to the frame
        add(label1);
        add(label2);
        add(passwordField1);
        add(passwordField2);
        add(Submit);
        add(Cancel);

        // Set frame size and visibility
        setSize(1366, 768);
        setVisible(true);

        this.username = username;
    }

    // Method to handle action events
    public void actionPerformed(ActionEvent e) {
        // Check if the Submit button is clicked
        if (e.getSource() == Submit) {
            // Validate user input
            if (passwordField1.getPassword().length > 0 && passwordField2.getPassword().length > 0) {
                if (new String(passwordField1.getPassword()).equals(new String(passwordField2.getPassword()))) {
                    // Update user password in the database
                    updatePasswordInDatabase(username, new String(passwordField1.getPassword()));

                    // Display success message
                    JOptionPane.showMessageDialog(null, "Password reset successful. Please login with your new password.");

                    // Hide the ResetPassword screen and display the Login screen
                    setVisible(false);
                    new Login();
                } else {
                    JOptionPane.showMessageDialog(null, "Passwords do not match. Please try again.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Password fields cannot be empty. Please try again.");
            }
        }

        // Check if the Cancel button is clicked
        if (e.getSource() == Cancel) {
            setVisible(false);
            new Login();
        }
    }

    // Method to update user password in the database
    private void updatePasswordInDatabase(String username, String newPassword) {
        // TODO: Implement database update logic here
    }
}
