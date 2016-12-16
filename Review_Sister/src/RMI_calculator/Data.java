/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_calculator;

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
    public void FirstMethod(String name) throws RemoteException {
        System.out.println(name+" Has Been Connectted");
        System.out.println("Pilih Perkalian : \n"
                + "1. Second Method untuk penambahan\n"
                + "2. Third Method untuk Pengurangan\n"
                + "");
    }

    @Override
    public Double SecondMethod(Double angka1, Double angka2) throws RemoteException {
        Double hasil;
        hasil = angka1+angka2;
        return hasil;
    }

    @Override
    public Double ThirdMethod(Double angka1, Double angka2) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Double FourthMethod(Double angka1, Double angka2) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Double FiveMethod(Double angka1, Double angka2) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
