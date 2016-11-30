/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author cynux
 */
public class data  extends UnicastRemoteObject implements DataInterface{
    
    public data() throws RemoteException{
        
    }

    @Override
    public void FirstMethod() throws RemoteException {
        System.out.println("Running First Method");
    }

    @Override
    public void SecondMethod() throws RemoteException {
        System.out.println("Running Second Method ");
    }
    
}
