/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prak1;

/**
 *
 * @author cynux
 */
import java.io.IOException;
import java.net.InetAddress;
public class inAdress {
    public static void main(String[] args) {
        try {
            System.out.println("Get Hostname from Current IP ");
            String ip = "192.168.1.1";
            System.out.println("Hostname from IP "+ip+ " : "+ InetAddress.getByName(ip).getHostName());
            System.out.println("Get Host Name from current name");
            String host = "localhost";
            System.out.println("Host / IP : "+ InetAddress.getByName(host).getHostAddress());
            System.out.println("Host / IP : "+ InetAddress.getByName(host));
            
            System.out.println(" Cek Koneksi");
            InetAddress aa = InetAddress.getByName(host);
            
            if(aa.isReachable(3000)){
                System.out.println(aa+" is reachable");
            } else {
                System.out.println(aa+" is UnReachable");
            }
        }catch(IOException ie){
            
        }
    }
}
