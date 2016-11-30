/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI2;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author cynux
 */
public interface DataInterface extends Remote{
        public void FirstMethod(String nama) throws RemoteException;
        public String SecondMethod(String nama ) throws RemoteException;
}
