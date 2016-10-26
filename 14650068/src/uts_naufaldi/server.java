/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts_naufaldi;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author cynux
 */
public class server {
    private class thritclient extends Thread {

        private Socket socket;
        private ObjectInputStream sInput;
        private ObjectOutputStream sOutput;
        private int id;
        private String username;

        public thritclient(Socket socket) {
            id = ++id2;
            this.socket = socket;
            System.out.println("Menciptakan Object Input/Output Streams");
            try {
                sOutput = new ObjectOutputStream(socket.getOutputStream());
                sInput = new ObjectInputStream(socket.getInputStream());
                String message = (String) sInput.readObject();
                username = message.split("~")[1];
                System.out.println(username + " masuk.");
            } catch (IOException e) {
                System.out.println("Exception creating new Input/output Streams: " + e);
            } catch (ClassNotFoundException e) {
            }
        }

        @Override
        public void run() {
            boolean keepGoing = true;
            while (keepGoing) {

                String message;
                try {
                    message = sInput.readObject().toString();
                } catch (IOException e) {
                    System.out.println(username + " Exception reading Streams: " + e);
                    break;
                } catch (ClassNotFoundException e2) {
                    break;
                }

                String type = message.split("~")[0];
                String pengirim = message.split("~")[1];
                String text = message.split("~")[2];
                String kepada = message.split("~")[3];
                String response;

                switch (type) {
                    case "postText":
                        response = "recieveText~" + pengirim + "~" + text + "~" + kepada + "~\n";
                        send(response);
                        break;
                    case "postPrivateText":
                        response = "recievePrivateText~" + pengirim + "~" + text + "~" + kepada + "~\n";
                        send(response);
                        break;
                    case "login":
                        response = "login~" + pengirim + "~" + text + "~" + kepada + "~\n";
                        send(response);
                        break;
//                    case "logout":
//                        response = "logout~" + pengirim + "~" + text + "~" + kepada + "~\n";
//                        send(response);
//                        break;
                    case "list":
                        response = "list~server~" + getClients() + "~ ~ ~ ~ ~\n";
                        send(response);
                        break;
                }
            }
            remove(id);
            close();
        }

        private void close() {
            try {
                if (sOutput != null) {
                    sOutput.close();
                }
            } catch (Exception e) {
            }
            try {
                if (sInput != null) {
                    sInput.close();
                }
            } catch (Exception e) {
            }
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (Exception e) {
            }
        }

        private boolean writeMsg(String msg) {
            if (!socket.isConnected()) {
                close();
                return false;
            }
            try {
                sOutput.writeObject(msg);
            } catch (IOException e) {
                System.out.println("Error sending message to " + username);
                System.out.println(e.toString());
            }
            return true;
        }
    }

    private static int id2;
    private ArrayList<server.thritclient> client;
    private int port;
    private boolean lari;

    public server() {
        this.port = 1111;
        client = new ArrayList<>();
    }

    public void start() {
        lari = true;
        try {
            ServerSocket server2 = new ServerSocket(port);
            while (lari) {
                System.out.println("OK Server Sudah Redy Menunggu Client Port ~ " + port + " . ");
                Socket soket = server2.accept();
                if (!lari) {
                    break;
                }
                server.thritclient ss = new server.thritclient(soket);
                client.add(ss);
                 ss.start();
                send("login~" + ss.username + "~" + ss.username + " sedang login...~Server~\n");
            }
            try {
                server2.close();
                for (int i = 0; i < client.size(); i++) {
                    server.thritclient gh = client.get(i);
                    try {
                        gh.sInput.close();
                        gh.sOutput.close();
                        gh.socket.close();
                    } catch (IOException ioe) {

                    }
                }
            } catch (Exception e) {
                System.out.println("Tutup Server dan Client : " + e);
            }
        } catch (IOException ioe) {
            String pesan = "Exception di server baru " + ioe + "\n";
            System.out.println(pesan);
        }

    }

    private synchronized void send(String message) {
        for (int i = client.size(); --i >= 0;) {
            server.thritclient ct = client.get(i);
            if (!ct.writeMsg(message)) {
                client.remove(i);
                System.out.println("Disconnec Client " + ct.username + " hapus dari list");
            }
        }
    }
    //dapatkan client / bsa multi
    private String getClients() {
        String s = "";
        for (thritclient clientThread : client) {
            s += clientThread.username + ":";
        }
        s += "---";
        System.out.println(s);
        return s;
    }
 
    private synchronized void remove(int id) {
        for (int i = 0; i < client.size(); ++i) {
            server.thritclient ct = client.get(i);
            if (ct.id == id) {
                client.remove(i);
                return;
            }
        }
    }

    public static void main(String[] args) {
        server server = new server();
        server.start();
    }

    
}
