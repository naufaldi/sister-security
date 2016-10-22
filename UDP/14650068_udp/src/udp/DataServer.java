/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp;

/**
 *
 * @author cynux
 */
import java.io.*;
import java.net.*;
import java.util.Vector;

public class DataServer {

    public static final int port = 7;
    public static final int bufSize = 4096;
    private DatagramSocket socket;

    public DataServer() {
        try {
            socket = new DatagramSocket(port);
            System.out.println("Server aktif pada port : " + socket.getLocalPort());
        } catch (Exception e) {
            System.err.println("Gagal membuka port");
        }
    }

    void layananClient() {
        byte[] buffer = new byte[bufSize];
        for (;;) {
            try {
                DatagramPacket packet = new DatagramPacket(buffer, bufSize);
                socket.receive(packet);
                System.out.println("Packet received from " + packet.getAddress() + " : " + packet.getPort() + " of lenght " + packet.getLength());
                
                byte[] data = packet.getData();
//                ByteArrayOutputStream o = new ByteArrayOutputStream();
                ByteArrayInputStream bout = new ByteArrayInputStream(data);
                ObjectInputStream ois = new ObjectInputStream(bout);
                
                FileOutputStream fileOutput = new FileOutputStream("DataMahasiswa2.out");
                ObjectOutputStream objekOutput = new ObjectOutputStream(fileOutput);
                objekOutput.writeObject(ois);
                fileOutput.close();
                
                String balasan = "Data Tersimpan\nTerima kasih!!!";
                byte[] balasanByte = balasan.getBytes();
                DatagramPacket balasanPaket = new DatagramPacket(balasanByte, balasanByte.length, port);
                socket.send(balasanPaket);
                try {
                    Thread.sleep(2000);
                    System.exit(0);
                } catch (InterruptedException e) {
                }
                
            } catch (IOException e) {
                System.out.println("Error : " + e);
            }
        }
    }

    public static void main(String[] args) {
        DataServer server = new DataServer();
        server.layananClient();
    }
}
