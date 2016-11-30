/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prak2_datastream;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 *
 * @author cynux
 */
public class OutputStreamDemo {
    public static void main(String[] args) {
        try {
            //get the output stream representation standart output
            OutputStream  output = System.out;
            
            //create  an output Stream Writer
            OutputStreamWriter writer = new OutputStreamWriter(output);
            
            //write the standart  output using a writer 
            writer.write("Hello World");
            
            //flush and close the writer  to ensure it  is written
            writer.flush();
            writer.close();
        }catch(IOException ie){
            
        }
    }
    
}
