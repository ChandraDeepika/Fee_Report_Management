import java.awt.*;
import javax.swing.*;

// Class definition for the Welcome screen
class Welcome implements Runnable{
	
  JFrame frame;
  JLabel label1,label2,background;
  Thread thread;
  Login login;
  ImageIcon img;

  // Constructor
  Welcome()
  {
    // Initialization of the attributes
    img=new ImageIcon("youtubr.jpg");
    thread=new Thread(this);
    frame=new JFrame("Welcome");
    frame.getContentPane().setLayout(null);
    frame.getContentPane().setBackground(Color.DARK_GRAY);
  
    // Create and configure labels for displaying text
    label1=new JLabel("College Fee Receipt Software ");
    label1.setBounds(250,300,1000,70);
    label1.setFont(new Font("Arial",Font.BOLD,60));
    label1.setForeground(Color.white);

    label2=new JLabel("  -By G.Chandra Deepika");
    label2.setFont(new Font("Arial",Font.BOLD,35));
    label2.setBounds(400,400,800,40);
    label2.setForeground(Color.orange);

    // Create and configure a label for displaying background image
    background=new JLabel("",img,JLabel.CENTER);
    background.setBounds(0,0,1200,760);

    // Add labels to the frame
    frame.getContentPane().add(label1);
    frame.getContentPane().add(label2);
    frame.getContentPane().add(background);

    // Set frame size and visibility
    frame.setSize(1366,768);
    frame.setVisible(true);

    // Start a new thread to run the Welcome screen
    thread.start();
  }

  
  // Method to run the Welcome screen
  public void run(){
    int x=1;
    // Display the Welcome screen for 5 seconds
    while(x<=5)
    {
      try{
        Thread.sleep(1000); // Pause for 1 second
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
    x++;
    }
  // After 5 seconds, hide the Welcome screen and display the Login screen
  frame.setVisible(false);
  login=new Login();
  
  }

  // Main method to start the application
  public static void main(String args[])
  {
    new Welcome(); // Create an instance of the Welcome screen
  }
}
