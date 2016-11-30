/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prak2_datastream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author cynux
 */
public class FileOutputStreamDemo {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String destination = "~/cobaan.txt";
        OutputStream output =  new FileOutputStream(destination);
        System.out.println("Openned "+destination+" for writing" );
        
        String data = "Try to write data";
        for (int i = 0; i< data.length(); i++ ){
        output.write((byte) data.charAt(i));
        
        }
        
        output.close();
        System.out.println("Output Stream close");
        
    }   
    
}
