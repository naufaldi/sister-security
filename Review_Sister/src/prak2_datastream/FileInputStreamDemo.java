/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prak2_datastream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author cynux
 */
public class FileInputStreamDemo {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //create input file and reading from spesific file
        InputStream fileInput = new FileInputStream("~/document.txt");
        
        //read the first bite of data
        int data = fileInput.read();
        
        //reapet untul end of  file reached
           while(data != -1){
               //convert byte to char  and send it to  standart output
               System.out.println((char)data);
               //read next byte
               data = fileInput.read();
               
           }
           //close  the file input stream
           fileInput.close();
           
    }
}
