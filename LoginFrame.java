import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginFrame extends JFrame implements ActionListener {
    public String p;

    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");


    LoginFrame(String k)  {
        p=k;
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        
        //return;

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);


    }

    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = null;
        Statement stmt = null;
     ResultSet rs = null;
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/steganography","root","sairam");
        if (e.getSource() == loginButton) {
            
            String userText;
            String pwdText;
            stmt = conn.createStatement() ;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT count(*) as userCount FROM user where name = '"+userText+"' and password = '"+pwdText+"'");
            if (rs.next()==true) {
                if (rs.getInt("userCount") > 0)
                {
                JOptionPane.showMessageDialog(this, "Login Successful");
                 
                 ImageProcess ip = new ImageProcess();
                 System.out.println("Text is: " + p);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
           
        }
    }
}
        catch(Exception ee) {
            System.out.print("Do not connect to DB - Error:"+ee);
        }
            

        
        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
       //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }


        }
    }

}
