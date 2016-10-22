/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum;

import static Praktikum.DayTimeServer.SERVICE_PORT;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author LAB_TI
 */
public class pesanBerulang_Server {
 public static final int SERVICE_PORT = 13;
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(SERVICE_PORT);
            System.out.println(" service started");
            for (;;) {
                Socket nextClient = ss.accept();

                System.out.println("Received request from : \n "
                        + "Alamat \t : "+nextClient.getInetAddress() + " : "
                        + "Port   \t : "+nextClient.getPort());
               
                
                BufferedReader br = new BufferedReader(new InputStreamReader(nextClient.getInputStream()));
                System.out.println("Result \t : " + br.readLine());
                nextClient.close();
            }
        } catch (BindException be) {
            System.out.println("Error " + be);
        } catch (IOException ioe) {
            System.out.println("Error " + ioe);
        }
    }
}

