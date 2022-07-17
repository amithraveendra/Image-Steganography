// Java program to show JRadioButton Example.
// in java. Importing different Package.
import java.nio.charset.Charset;
import java.math.BigInteger;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedOutputStream;
import java.io.FileReader;
import java.io.File;
import java.io.InputStream;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import java.io.*;


class Demo extends JFrame {

    // Declaration of object of JRadioButton class.
    JRadioButton jRadioButton1;

    // Declaration of object of JRadioButton class.
    JRadioButton jRadioButton2;

    // Declaration of object of JButton class.
    JButton jButton;

    // Declaration of object of ButtonGroup class.
    ButtonGroup G1;

    // Declaration of object of text and JLabel class.
    JLabel L1,L2;
    static text f2;
    Demo f1;
    

    // Constructor of Demo class.
    public Demo()
    {

        // Setting layout as null of JFrame.
        this.setLayout(null);
  
        // Initialization of object of "JRadioButton" class.
        jRadioButton1 = new JRadioButton();

        // Initialization of object of "JRadioButton" class.
        jRadioButton2 = new JRadioButton();

        // Initialization of object of "JButton" class.
        jButton = new JButton("Click");

        // Initialization of object of "ButtonGroup" class.
        G1 = new ButtonGroup();

        // Initialization of object of " JLabel" class.
        L1 = new JLabel("OPERATION");

        // setText(...) function is used to set text of radio button.
        // Setting text of "jRadioButton2".
        jRadioButton1.setText("ENCRYPTION");

        // Setting text of "jRadioButton4".
        jRadioButton2.setText("DECRYPTION");

        // Setting Bounds of "jRadioButton2".
        jRadioButton1.setBounds(120, 30, 120, 50);

        // Setting Bounds of "jRadioButton4".
        jRadioButton2.setBounds(250, 30, 130, 50);

        // Setting Bounds of "jButton".
        jButton.setBounds(125, 90, 80, 30);

        // Setting Bounds of JLabel "L1".
        L1.setBounds(20, 30, 150, 50);

        // "this" keyword in java refers to current object.
        // Adding "jRadioButton2" on JFrame.
        this.add(jRadioButton1);

        // Adding "jRadioButton4" on JFrame.
        this.add(jRadioButton2);

        // Adding "jButton" on JFrame.
        this.add(jButton);

        // Adding JLabel "L1" on JFrame.
        this.add(L1);
        //this.add(L2);

        // Adding "jRadioButton1" and "jRadioButton3" in a Button Group "G1".
        G1.add(jRadioButton1);
        G1.add(jRadioButton2);

        // Adding Listener to JButton.
        jButton.addActionListener(new ActionListener() {
            // Anonymous class.

            public void actionPerformed(ActionEvent e)
            {
                // Override Method

                // Declaration of String class Objects.
                String qual = " ";
             
                // If condition to check if jRadioButton2 is selected
                if (jRadioButton1.isSelected()) {

                    qual = "ENCRYPTION";
                    JOptionPane.showMessageDialog(Demo.this, qual);
                    text f2=new text();
                    f2.setTitle("TEXT INFORMATION PAGE");
                    f2.setVisible(true);
                    f2.setSize(500,500);
                    f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    f2.setResizable(false);
                    //FileReader code = new FileReader("filename.txt");
        /*BufferedReader in = new BufferedReader(code);
        String s = "";
        String g = "";
        while((s=in.readLine())!=null)
            g+=s;
        
        Convert c = new Convert();
        ImageProcess impro = new ImageProcess();
        byte [] txtBytes = c.txtToByte(g);
        BufferedImage img = impro.fetchImage();
        impro.hideText(img,txtBytes);*/
                }
                else if (jRadioButton2.isSelected()) {

                    qual = "DECRYPTION";
                    LoginFrame frame1=new LoginFrame();
                    frame1.setTitle("Login Form");
                    frame1.setVisible(true);
                    frame1.setBounds(10,10,370,600);
                    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame1.setResizable(false);
                }
                else {

                 qual  = "NO Button selected";
                }

            }
        });
}
    // Driver code.
    public static void main(String args[])
    { // Creating object of demo class.
        Demo f1 = new Demo();
        // Setting Bounds of JFrame.
        f1.setBounds(100, 100, 400, 200);
        // Setting Title of frame.
        f1.setTitle("SELECTION");
    // Setting Visible status of frame as true
    f1.setVisible(true);
    }
}