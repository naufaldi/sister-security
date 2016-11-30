/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author cynux
 */
public class Client {
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException, IOException {
        DataInterface data = (DataInterface) Naming.lookup("rmi://localhost:1099/data");
        System.out.println("Client connect to server");
        
        BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
        System.out.println(" Enter Your Name ");
        String nama = in.readLine();
        
        data.FirstMethod(nama);
        System.out.println(data.SecondMethod(nama));
    }
    
}
