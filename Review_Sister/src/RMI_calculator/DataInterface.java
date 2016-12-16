/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_calculator;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author cynux
 */
public interface DataInterface extends Remote{
    public void FirstMethod(String name) throws RemoteException;
    public Double SecondMethod(Double angka1,Double angka2) throws RemoteException;
    public Double ThirdMethod(Double angka1,Double angka2) throws RemoteException;
     public Double FourthMethod(Double angka1,Double angka2) throws RemoteException;
    public Double FiveMethod(Double angka1,Double angka2) throws RemoteException;
    
}
 