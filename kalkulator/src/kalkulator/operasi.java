/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalkulator;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class operasi extends UnicastRemoteObject implements fungsi {

    int hasil;

    public operasi() throws RemoteException {

    }

    @Override
    public int tambah(int a, int b) throws RemoteException {
        hasil = a + b;
        return hasil;
    }

    @Override
    public int kurang(int a, int b) throws RemoteException {
        hasil = a - b;
        return hasil;
    }

    @Override
    public int kali(int a, int b) throws RemoteException {
        hasil = a * b;
        return hasil;
    }

    @Override
    public int bagi(int a, int b) throws RemoteException {
        hasil = a / b;
        return hasil;
    }

}
