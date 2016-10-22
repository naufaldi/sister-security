/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author LAB_TI
 */
public class DayTimeServer {

    public static final int SERVICE_PORT = 13;

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(SERVICE_PORT);
            System.out.println("Daytime service started");
            for (;;) {
                Socket nextClient = ss.accept();

                System.out.println("Received request from "
                        + nextClient.getInetAddress() + " : "
                        + nextClient.getPort());
                //proses nulis
                OutputStream os = nextClient.getOutputStream();
                PrintStream ps = new PrintStream(os);
                //nulis ke user
                ps.print(new java.util.Date());
                os.flush();
                os.close();
                nextClient.close();
            }
        } catch (BindException be) {
            System.out.println("Error " + be);
        }catch (IOException ioe) {
            System.out.println("Error " + ioe);
        }
    }

}
