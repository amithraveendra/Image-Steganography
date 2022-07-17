import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.event.ActionListener;




public class ImagePanel extends JFrame 
{
    Container container = getContentPane();
     JPanel panel = new JPanel();
     JLabel pic = new JLabel();
    
     ImagePanel(){
    
     setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        /*try
        {
            Steganography st = new Steganography();
            st.Stego();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }*/
    }
     
    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        panel.setBounds(50, 50, 1000, 1000);
        pic.setBounds(50,50,1000,1000);
        try
        {
        BufferedImage img = ImageIO.read(new File("Output.png"));
   //"C:/Users/HETAL/Downloads/pic_1.jpg"
       pic = new JLabel(new ImageIcon(img));
        panel.add(pic);
    }
        catch(IOException e){}
        


    }
    public void addComponentsToContainer() {
        container.add(panel);
        
    }
}
     
     /*
  try 
  {
   JFrame f = new JFrame("Add an Image to a JPanel");
   JPanel panel = new JPanel();
   panel.setBounds(50, 50, 1000, 1000);
   
   BufferedImage img = ImageIO.read(new File(str));
   //"C:/Users/HETAL/Downloads/pic_1.jpg"
   JLabel pic = new JLabel(new ImageIcon(img));
   panel.add(pic);

   f.add(panel);
   f.setSize(500, 500);
   f.setLayout(null);
   f.setVisible(true);
  } 
  catch (IOException e) {}
  /* try
   {
       ;
   }
   catch (Exception e)
   {
       
   }
  
   */             
  


 //public static void main(String args[]) 
 //{
 // new ImagePanel();
 //}