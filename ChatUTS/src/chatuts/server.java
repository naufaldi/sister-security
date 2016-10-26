/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatuts;

/**
 *
 * @author cynux
 */
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class server {
      private class threadclient extends Thread {
       private Socket socket;
       private ObjectInputStream Masukinput;
       private ObjectOutputStream Keluaroutput;
       private int identitas;
       private String username;
       
       public threadclient(Socket socket){
       identitas = ++identitas2;
       this.socket = socket;
           System.out.println("Membuat Object Input / Output Streams");
           try {
               Keluaroutput = new ObjectOutputStream(socket.getOutputStream());
               Masukinput = new ObjectInputStream(socket.getInputStream());
               String message = (String) Masukinput.readObject();
               username = message.split("~")[1];
               System.out.print(username + " telah masuk");
           }catch(IOException e){
               System.out.println("Error "+e);
           } catch(ClassNotFoundException e){
               
           }
       
   }
       @Override
       public void run(){
           boolean pilihan = true;
           while(pilihan){
               String message;
               try{
                   message = Masukinput.readObject().toString();
               } catch(IOException e){
                   System.out.println( username + " Exception reading Streams: "+ e);
                   break;
               } catch(ClassNotFoundException ee){
                   break;
               }
               String type = message.split("~")[0];
               String pengirim = message.split("~")[1];
               String text = message.split("~")[2];
               String kepada = message.split("~")[3];
               String response;
               
               //pemilihan
               switch(type){
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
                    case "logout":
                        response = "logout~" + pengirim + "~" + text + "~" + kepada + "~\n";
                        send(response);
                        break;
                    case "list":
                        response = "list~server~" + getClient() + "~ ~ ~ ~ ~\n";
                        send(response);
                        break;
               }
               
           }
           remove (identitas);
       close();
       
       }
        private void close(){
         try {
             if(Keluaroutput != null){
                 Keluaroutput.close();
             } else if (Masukinput != null){
                 Masukinput.close();
             } else if (socket != null){
                 socket.close();
             }
         }catch(Exception e) {
             
         }
       
         }
        
        private boolean writeMessage (String message2){
             if (!socket.isConnected()){
                 close();
                 return false;
             }
             try {
                 Keluaroutput.writeObject(message2);
                 
             } catch(IOException e){
                 System.out.println("Error Send message to "+ username);
                 System.out.println(e.toString());
                 
             }
        return true;
      }
      
   }
  
     
      
 private static int identitas2;
 
 private ArrayList<server.threadclient> client;
 private int port;
 private boolean running;
 
 public server (){
    
     this.port = 2222;
     client = new ArrayList<>();
 }
 
 public void start(){
     running = true;
     try {
         ServerSocket server2 = new ServerSocket(port);
         while(running){
             System.out.println("Server Rady");
             Socket soket = server2.accept();
             if (!running){
                System.out.println("Sudah Saatnya break");
                 break;

             }
             server.threadclient ss = new server.threadclient(soket);
             client.add(ss);
             ss.start();
             send("login~"+ss.username +"~"+ss.username+" sedang login .. \n");
         }
         try {
             server2.close();
             for (int i = 0; i< client.size();i++){
                 server.threadclient gh = client.get(i);
                 try {
                     gh.Masukinput.close();
                     gh.Keluaroutput.close();
                     gh.socket.close();
                 } catch(IOException ioe){
                     
                 }
             }
         }catch (Exception e){
             System.out.println("Tutup server dan client : "+ e);
         }
     }catch(IOException ie){
             String pesan = "Exception di server " + ie + "\n";
             System.out.println(pesan);
         }
 }
 
 private synchronized  void send(String message){
     for (int i = client.size(); --i >= 0;){
         server.threadclient ct = client.get(i);
         if (!ct.writeMessage(message)){
             client.remove(i);
             System.out.println("Disconnect Client "+ ct.username + " hapus dari lsit ");
         }
     }
 }
 
 private String getClient(){
     String s = " ";
     for (threadclient clientThread : client){
         s += clientThread.username + " : ";
     }
     s += "----";
     System.out.println(s);
     return s;
 }
 
 private synchronized void remove (int identitas){
     for (int i = 0 ; i <client.size(); ++i){
         server.threadclient tc = client.get(i);
         if (tc.identitas == identitas){
             client.remove(i);
             return;
         }
     }
 }
    public static void main(String[] args) {
        server serverku = new server();
        serverku.start();
    }
}
