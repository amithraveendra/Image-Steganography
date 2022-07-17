// Java program to use JFileChooser to restrict
// the type of files shown to the user
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
class filechooser2 extends JFrame implements ActionListener {
    // Jlabel to show the files user selects
    static JLabel l;
    /*JFrame f = new JFrame("file chooser");

        // set the size of the frame
        f.setSize(400, 400);

        // set the frame's visibility
        f.setVisible(true);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
*/      
        Container container = getContentPane();
        JButton button1 = new JButton("save");
        JButton button2 = new JButton("open");


       
    // a default constructor
    filechooser2()
    {
        
    setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }
    
    public void setLocationAndSize() {
        button1.setBounds(50, 150, 100, 30);
        button2.setBounds(50, 220, 100, 30);
        


    }
    
    public void addComponentsToContainer() {
        container.add(button1);
        container.add(button2);
    }

    public void addActionEvent() {
        button1.addActionListener(this);
        button2.addActionListener(this);
        
    }

     
    

    /*public static void main(String args[])
    {
        // frame to contains GUI elements
        JFrame f = new JFrame("file chooser");

        // set the size of the frame
        f.setSize(400, 400);

        // set the frame's visibility
        f.setVisible(true);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // button to open save dialog
        JButton button1 = new JButton("save");

        // button to open open dialog
        JButton button2 = new JButton("open");

        // make an object of the class filechooser
        filechooser f1 = new filechooser();

        // add action listener to the button to capture user
        // response on buttons
        button1.addActionListener(f1);
        button2.addActionListener(f1);

        // make a panel to add the buttons and labels
        JPanel p = new JPanel();

        // add buttons to the frame
        p.add(button1);
        p.add(button2);

        // set the label to its initial value
        l = new JLabel("no file selected");

        // add panel to the frame
        p.add(l);
        f.add(p);

        f.show();
    } */
    public void actionPerformed(ActionEvent evt)
    {
        // if the user presses the save button show the save dialog
        String com = evt.getActionCommand();

        if (com.equals("save")) {
            // create an object of JFileChooser class
            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

            // restrict the user to select files of all types
            j.setAcceptAllFileFilterUsed(false);

            // set a title for the dialog
            j.setDialogTitle("Select a .png file");

            // only allow files of .txt extension
            FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .png files", "png");
            j.addChoosableFileFilter(restrict);

            // invoke the showsSaveDialog function to show the save dialog
            int r = j.showSaveDialog(null);

            // if the user selects a file
            if (r == JFileChooser.APPROVE_OPTION)

            {
                // set the label to the path of the selected file
                l.setText(j.getSelectedFile().getAbsolutePath());
            }
            // if the user cancelled the operation
            else
                l.setText("the user cancelled the operation");
        }
        // if the user presses the open dialog show the open dialog

        else {
            // create an object of JFileChooser class
            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            // restrict the user to select files of all types
            j.setAcceptAllFileFilterUsed(false);

            // set a title for the dialog
            j.setDialogTitle("Select a .png file");

            // only allow files of .txt extension
            FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .png files", "png");
            j.addChoosableFileFilter(restrict);

            // invoke the showsOpenDialog function to show the save dialog
            int r = j.showOpenDialog(null);
            String path=j.getSelectedFile().getAbsolutePath();

            // if the user selects a file
            if (r == JFileChooser.APPROVE_OPTION) {
                // set the label to the path of the selected file
                //l.setText(j.getSelectedFile().getAbsolutePath());
               // System.out.println("I'm Here!!");
                    String imag=j.getSelectedFile().getAbsolutePath();
                    //System.out.println("I'm Here!!");
                    try
                    {
                        //ImagePanel(imag);
                    BufferedImage img = ImageIO.read(new File(imag));
                    }
                    catch (IOException ioe)
                    {
                        ioe.printStackTrace();
                    }
                    File f1 = new File(imag);
                    BufferedImage pho = null;
                                try{
                               pho = ImageIO.read(f1);
                              //f1 = new File(str);
                                ImageIO.write(pho, "png", new File("C:/Users/Amith R/Stego/output.png"));
      //return 25;
                                }catch(IOException e){
                                      System.out.println("Error: "+e);}
                    

                    ImagePanel fi = new ImagePanel();
                     fi.setSize(500, 500);
                                 fi.setLayout(null);
                                 fi.setVisible(true);
                    
            }
            // if the user cancelled the operation
            else
                l.setText("the user cancelled the operation");
        }
    }
       
 
}