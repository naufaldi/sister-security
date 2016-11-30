/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import com.sun.org.apache.xerces.internal.util.URI;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author cynux
 */
public class Client {
    public static void main(String[] args) throws NotBoundException, RemoteException, MalformedURLException {
        DataInterface data = (DataInterface) Naming.lookup("rmi://localhost:1099/data");
        System.out.println("Client connect to server");
        
        data.FirstMethod();
        data.SecondMethod();
        System.out.println("Finish");
    }
    
}
