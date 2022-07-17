// Java Program to create a
// blank label and add text to it.
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.IOException;
import java.io.FileWriter;
class text extends JFrame implements ActionListener{
    /*static JFrame f;
    static JLabel l,l1;*/
    //public JTextField t;
    //static JButton b;
     Container cont = getContentPane();
     JLabel l = new JLabel();
     JLabel l1 = new JLabel("ENTER TEXT");
     JTextField t= new JTextField();
     JButton b=new JButton("SUBMIT");
     Font font=new Font("ARIAL",Font.ITALIC,30);
     
     text() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }
    
    
    public void setLayoutManager() {
        cont.setLayout(null);
    }
     
     public void setLocationAndSize() {
         l.setText("IMAGE STEGANOGRAPHY");
        l.setBounds(50,50, 400, 20);
        l1.setBounds(50, 150, 100, 30);
        t.setBounds(150, 150, 150, 30);
        b.setBounds(100, 250, 150, 30);
        l.setFont(font);

    }
     
    
    public void addComponentsToContainer() {
        cont.add(l);
        cont.add(l1);
        cont.add(b);
        cont.add(t);
    }
    
    
    public void addActionEvent() {
        b.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.equals("SUBMIT")) {
            // set the text of the label to the text of the field
            //l.setText(t.getText());
            //t.getText() will give you what text you want to encrypt
            try{
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write(t.getText());
            
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
            //new filechooser();
            }
            catch (IOException h) {
            System.out.println("An error occurred.");
            h.printStackTrace();
             }
            // set the text of field to blank
            t.setText("  ");
            filechooser2 fc = new filechooser2();
            //JFrame f = new JFrame("file chooser");

		// set the size of the frame
		fc.setSize(400, 400);

		// set the frame's visibility
		fc.setVisible(true);

		fc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }

}