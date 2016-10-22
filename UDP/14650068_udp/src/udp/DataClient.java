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
import java.util.Enumeration;
import java.util.Vector;

public class DataClient {

    public static final int Port = 7;
    public static final int BUFZISE = 256;

    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
        String hostname = "localhost";
        InetAddress add = InetAddress.getByName(hostname);
        DatagramSocket socket = new DatagramSocket();
        socket.setSoTimeout(2000);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Vector list;

        try {
            try {
                FileInputStream fileInput = new FileInputStream("DataMahasiswa2.out");
                ObjectInputStream objekInput = new ObjectInputStream(fileInput);
                try {
                    Object objek = objekInput.readObject();
                    list = (Vector) objek;
                } catch (ClassCastException | ClassNotFoundException e) {
                    list = new Vector();
                }
            } catch (FileNotFoundException e) {
                list = new Vector();
            }
            for (;;) {
                String Menu = "\n- Menu - \n1.Tambah Data \n2. List Data \n3. Simpan dan Keluar \n4. Keluar tanpa Simpan\n";
                System.out.print(Menu + "\nAnda Pilih Nomer : ");
                String pilihan = reader.readLine();
                if (pilihan.equalsIgnoreCase("1")) {
                    System.out.print("Masukkan Nama : ");
                    String nama = reader.readLine();
                    System.out.print("Masukkan NIM : ");
                    String nim = reader.readLine();
                    System.out.print("Masukkan Jurusan : ");
                    String jurusan = reader.readLine();
                    System.out.print("Masukkan Alamat : ");
                    String alamat = reader.readLine();

                    list.addElement("Nama : " + nama + "\nNIM : " + nim + "\nJurusan : " + jurusan + "\nAlamat : " + alamat + "\n");
                } else if (pilihan.equalsIgnoreCase("2")) {
                    for (Enumeration e = list.elements(); e.hasMoreElements();) {
                        System.out.println(e.nextElement());
                    }
                } else if (pilihan.equalsIgnoreCase("3")) {
                    ByteArrayOutputStream bout = new ByteArrayOutputStream();
                    PrintStream print = new PrintStream(bout);
                    print.print(list);
                    byte[] barray = bout.toByteArray();
                    DatagramPacket packet = new DatagramPacket(barray, barray.length, add, Port);
                    socket.send(packet);
                    byte[] reebuf = new byte[BUFZISE];
                    DatagramPacket receivePacket = new DatagramPacket(reebuf, BUFZISE);

                    boolean timeout = false;
                    try {
                        socket.receive(receivePacket);
                    } catch (InterruptedIOException e) {
                        timeout = true;
                    }
                    if (!timeout) {
                        System.out.println("Details : " + receivePacket.getAddress() + receivePacket.getAddress());
                        ByteArrayInputStream bin = new ByteArrayInputStream(receivePacket.getData(), 0, receivePacket.getLength());
                    } else {
                        System.out.println("Packet Lost!");
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                    }
//                    System.out.println("Data Tersimpan!\nTerimakasih!!!");
                    break;
                } else if (pilihan.equalsIgnoreCase("4")) {
                    System.out.println("Keluar ...\nTerima kasih !");
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Error : " + e);
        }
    }
}
