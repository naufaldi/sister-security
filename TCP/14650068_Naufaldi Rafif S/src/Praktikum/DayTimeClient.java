/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author LAB_TI
 */
public class DayTimeClient {
    public static final int SERVICE_PORT = 13;
    public static void main(String[] args) {
        try{
            String hostname ="localhost";
            Socket daytime = new Socket(hostname, SERVICE_PORT);
            System.out.println("COnnection Established");
            
            daytime.setSoTimeout(2000);
            BufferedReader br = new BufferedReader(new InputStreamReader(daytime.getInputStream()));
            System.out.println("Result \t : " + br.readLine() );
            
            daytime.close();
        }catch(IOException ioe){
            System.out.println("Error " +ioe);
        }
    }
}
