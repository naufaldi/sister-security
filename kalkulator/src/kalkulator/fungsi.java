/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalkulator;

import java.rmi.*;

public interface fungsi extends Remote {

    public int tambah(int a, int b) throws RemoteException;

    public int kurang(int a, int b) throws RemoteException;

    public int kali(int a, int b) throws RemoteException;

    public int bagi(int a, int b) throws RemoteException;
}
