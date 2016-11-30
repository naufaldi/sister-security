/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author cynux
 */
public class Server {
    public static void main(String[] args)  throws RemoteException, NotBoundException{
        Registry registry = LocateRegistry.createRegistry(1099);
        
        data data1 =  new data();
        registry.rebind("data",data1);
        
        System.out.println("Server is running");
    }
    
}
