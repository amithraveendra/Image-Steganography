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


class Steganography  {
    public static void main(String [] args) 
    //Steganography()
    throws Exception{
        //JFrame f = new JFrame("file chooser");
        /*filechooser fc2 = new filechooser();
         int x = fc2.abc();
        // set the size of the frame
        fc2.setSize(400, 400);

        // set the frame's visibility
        fc2.setVisible(true);

        fc2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /* Demo f1 = new Demo();
        // Setting Bounds of JFrame.
        f1.setBounds(100, 100, 400, 200);
        // Setting Title of frame.
        f1.setTitle("SELECTION");
    // Setting Visible status of frame as true
    f1.setVisible(true);*/
        System.out.flush();
        FileReader code = new FileReader("filename.txt");
        BufferedReader in = new BufferedReader(code);
        String s = "";
        String g = "";
        while((s=in.readLine())!=null)
            g+=s;
        
        Convert c = new Convert();
        ImageProcess impro = new ImageProcess();
        byte [] txtBytes = c.txtToByte(g);
        BufferedImage img = impro.fetchImage();
        impro.hideText(img,txtBytes);
        //c.conToBinary(g);
    }
}

class Convert{
    //Module to Convert Binary to String
    void conToString(StringBuilder binary){
        try{
        BigInteger val = new BigInteger(""+binary, 2);
        byte [] imageInByte = val.toByteArray();
        String hi = new String(imageInByte);
        System.out.println(hi);
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    //Module to Convert String to Binary
    void conToBinary(String s){
        byte [] arr = s.getBytes(Charset.forName("UTF-8"));
        StringBuilder binary = new StringBuilder();
        for (byte b : arr){
            int val = b;
            for (int i = 0; i < 8; i++){
                binary.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
        }
        System.out.println("'" + s + "' to binary: " + binary);
        conToString(binary);
    }
    
     byte[] txtToByte(String s){
        byte [] arr = s.getBytes(Charset.forName("UTF-8"));
        return arr;
    }
    
    void conToBinary(byte [] barr){
        StringBuilder binary = new StringBuilder();
        for (byte b : barr){
            int val = b;
            for (int i = 0; i < 8; i++){
                binary.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
        }
        System.out.println(" to binary: " + binary);
        conToString(binary);
    }
}


class ImageProcess {
    public String k;
    BufferedImage fetchImage() throws Exception{
        
        File f = new File("output.png");
        BufferedImage img = ImageIO.read(f);
        return img;
    }
    
    void hideText(BufferedImage img , byte [] txt) throws Exception{
        
        int i = 0;
        int j = 0;
        for(byte b : txt){
            for(int k=7;k>=0;k--){
                Color c = new Color(img.getRGB(j,i));//RGB is an inbuilt function
                byte blue = (byte)c.getBlue();
                //System.out.println("Blue : "+c.getBlue());
                int red = c.getRed();
                int green = c.getGreen();
                //System.out.println("Red Green Blue : " + red + " "+ green + " "+blue);
                //System.out.println("Sum : "+ (red+green+(int)blue));
                int bitVal = (b >>> k) & 1;  
                blue = (byte)((blue & 0xFE)| bitVal);
                //System.out.println("New Blue: " + (int)(blue & 0xFF) +" "+ blue);
                //System.out.println(j+" "+i);
                Color newColor = new Color(red,green,(blue & 0xFF));
                img.setRGB(j,i,newColor.getRGB());
                j++;
            }
            i++;
        }
        
        System.out.println("Text Hidden");
        createImgWithMsg(img);
        System.out.println("Decode? Y or N");
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        char data = (char)obj.read();
        
        
        
        switch(data){
            case 'Y':
            case 'y':
                {
                     k = revealMsg(txt.length,0);
                     //k = revealMsg(txt.length,0);
                    LoginFrame frame=new LoginFrame(k);
                   frame.setTitle("Login Form");
                   frame.setVisible(true);
                    frame.setBounds(10,10,370,600);
                  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                   frame.setResizable(false);
                     //System.out.println("Text is in stego: " + k);
                }
                break;
            default:
                    System.out.println("Program is now ending");
                break;
        }
    
    }
    
    void createImgWithMsg(BufferedImage img){
        try{
            File ouptut = new File("new2.png");
            ImageIO.write(img, "png", ouptut);
        }
        catch(Exception ex)
        {}
    }
    
    BufferedImage newImageFetch(){
        File f = new File("new2.png");
        BufferedImage img = null;
        try{
            img = ImageIO.read(f);
        }
        catch(Exception ex)
        {}
        return img;
    }
    
    String revealMsg(int msgLen , int offset){
        BufferedImage img = newImageFetch();
        byte [] msgBytes = extractHiddenBytes(img,msgLen,offset);
        if(msgBytes == null)
            return null;
        String msg = new String(msgBytes);
        return (msg);
    }
    
    byte[] extractHiddenBytes(BufferedImage img , int size , int offset){
        
        int i = 0;
        int j = 0;
        byte [] hiddenBytes = new byte[size];
        
        for(int l=0;l<size;l++){
            for(int k=0 ; k<8 ; k++){
                Color c = new Color(img.getRGB(j,i));
                byte blue = (byte)c.getBlue();
                //System.out.println("Blue : "+c.getBlue()+" "+blue);
                int red = c.getRed();
                int green = c.getGreen();
                //System.out.println("blue : "+blue);
                //System.out.println("Hidden byte<<1: "+(hiddenBytes[l]<<1));
                //System.out.println("blue&1 : "+(blue&1));
                //System.out.println("(hiddenBytes[l]<<1)|(blue&1) : "+ ((hiddenBytes[l]<<1)|(blue&1)));
                hiddenBytes[l] = (byte) ((hiddenBytes[l]<<1)|(blue&1));
                //System.out.println("Hidden byte"+ l +" : "+hiddenBytes[l]);
                //System.out.println(j+" "+i);
                j++;
            }
            i++;
        }
        return hiddenBytes;
        
    }
}