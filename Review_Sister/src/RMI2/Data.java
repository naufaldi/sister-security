/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author cynux
 */
public class Data extends UnicastRemoteObject implements DataInterface{
    public Data() throws RemoteException{
        
    }

    @Override
    public void FirstMethod(String nama) throws RemoteException {
        System.out.println(nama+" Has Been Connectted");
    }

    @Override
    public String SecondMethod(String nama) throws RemoteException {
        return "Assalamu'aikum Human "+nama+" For Connecting with us";
    }
    
}
