/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asistensi;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.List;
import javax.swing.JOptionPane;
import asistensi.SerializationCrud_CS;
import asistensi.olah_app_crud_CS;
/**
 *
 * @author cynux
 */
public class server_crud {
    public static final int SERVICE_PORT=7;
    public static final int BUFSIZE=4096;
    private DatagramSocket socket;
    private DatagramSocket s2;
    InetAddress addr;
    public static final String hostname="localhost";
    SerializationCrud_CS sc=new SerializationCrud_CS();
    public server_crud(){
        try{
            this.addr = InetAddress.getByName(hostname);
            socket=new DatagramSocket(SERVICE_PORT);
            s2=new DatagramSocket();
            JOptionPane.showMessageDialog(null,"Server Active on port "+socket.getLocalPort());
            //socket.setSoTimeout(20000);
            //data();    
        }catch(Exception e){
            System.err.println("Unable to bind port");
        }
    }
    public void serviceClients(){
        byte[] buffer=new byte[BUFSIZE];
        for (;;) {
            try{
                DatagramPacket packet2=new DatagramPacket(buffer,BUFSIZE);
                socket.receive(packet2);
                //socket.send(packet2);
                System.out.println("Packet Receive From "+packet2.getAddress()+" : "+packet2.getPort()+" of length "+packet2.getLength());
                System.out.println("Details : "+packet2.getAddress());
                    
                    ByteArrayInputStream bin=new ByteArrayInputStream(packet2.getData(),0, packet2.getLength());
                    ObjectInput oi=new ObjectInputStream(bin);
                    
                    List<olah_app_crud_CS> la=(List<olah_app_crud_CS>)oi.readObject();
                    sc.serialize(la);
                    JOptionPane.showMessageDialog(null,"Tersimpan Ke Server");
                    
            }catch(Exception ioe){
                System.out.println("Error "+ioe);
            }
        }
    }
    public void data(){
        ByteArrayOutputStream bout1;
        ObjectOutput oo1;
        DatagramPacket packet1;
        boolean timeout=true;
        while(timeout){
            try{
                List<olah_app_crud_CS> l=sc.deserialize();
                bout1=new ByteArrayOutputStream();
                oo1=new ObjectOutputStream(bout1);
                oo1.writeObject(l);
                byte[] barray=bout1.toByteArray();
                packet1=new DatagramPacket(barray,barray.length,addr,6);
                try{
                    s2.send(packet1);
                    timeout=false; 
                    
                }catch(InterruptedIOException ioe){
                    timeout=true;
                }
                
            }catch(Exception e){
                System.out.println("Gagal load server");
            }
        }
    }
    public static void main(String[] args) {
        server_crud server=new server_crud();
        //server.data();
        server.serviceClients();
    }
}
