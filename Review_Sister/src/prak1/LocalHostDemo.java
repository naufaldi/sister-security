/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prak1;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author cynux
 */
public class LocalHostDemo {
    public static void main(String[] args) throws UnknownHostException {
        System.out.println("Looking up localhost");
        InetAddress inetadress = InetAddress.getLocalHost();
        System.out.println("Nama "+inetadress.getHostName());
        System.out.println("Ip Adress "+ inetadress.getHostAddress());
        System.out.println(inetadress);
        
    }
}
