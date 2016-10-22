/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tugas;

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
 * @author WhiteHat
 */
public class multiclient_client {
        public static final int SERVICE_PORT = 13;

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(SERVICE_PORT);
            System.out.println("Daytime service started");
            for (;;) {
                Socket nextClient = ss.accept();

                System.out.println("Received request from : \n "
                        + "Alamat \t : " + nextClient.getInetAddress() + " : "
                        + "Port   \t : " + nextClient.getPort());

                
                
                
                BufferedReader br = new BufferedReader(new InputStreamReader(nextClient.getInputStream()));
                 String data = br.readLine();
                
                 
                 System.out.println("Result \t : " + data);
//nextClient.close();
               
                
                
                
                
                OutputStream os = nextClient.getOutputStream();
                PrintStream ps = new PrintStream(os);
                if (data.equalsIgnoreCase("assalamu'alaikum")) {
                    ps.println("Wa'alaykumsalam");//Perlu Println biar datanya kebanya jangan print
                } else {
                    ps.println(data + " juga");//Perlu Println biar datanya kebanya jangan print
                }

                
                
                
                os.flush();
                os.close();
                nextClient.close();
            }
        } catch (BindException be) {
            System.out.println("Error " + be);
        } catch (IOException ioe) {
            System.out.println("Error " + ioe);
        }
    }
}
