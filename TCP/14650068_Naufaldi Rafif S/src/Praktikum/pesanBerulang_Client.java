/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum;

import static Praktikum.DayTimeClient.SERVICE_PORT;
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
public class pesanBerulang_Client {

    public static final int SERVICE_PORT = 13;

    public static void main(String[] args) {
        try {
             for(;;){
            String hostname = "localhost";
            Socket daytime = new Socket(hostname, SERVICE_PORT); //Membuat Koneksi
            System.out.println("COnnection Established");
            
            daytime.setSoTimeout(2000);
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String kata = br.readLine();
            System.out.println("Data yang diinputkan : " + kata);

            //proses nulis
            OutputStream os = daytime.getOutputStream();
            PrintStream ps = new PrintStream(os);
            //nulis ke server
            ps.print(kata);
            os.flush();
            os.close();
            daytime.close();
             }
        } catch (IOException ioe) {
            System.out.println("Error " + ioe);
        }
    }
}
