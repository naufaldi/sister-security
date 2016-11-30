/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prak2_datastream;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javafx.scene.layout.Border;
import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author cynux
 */
public class ImageInputDemo {
    public static void main(String[] args) throws IOException {
        Image image = null;
        try {
            //yout may try  both of thus techniq
            
            //read from file 
            File imageResource = new File("~/Pictures/screnshot.jpg");
            image = ImageIO.read(imageResource);
            
            //read from input stream
            InputStream is = new BufferedInputStream (new FileInputStream("~/Pictures/screnshot.jpg"));
            image = ImageIO.read(is);
            
        }catch(IIOException ie) {
            
        }
        JFrame frame = new JFrame();
        JLabel label = new JLabel(new ImageIcon(image));
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        
    }
}
