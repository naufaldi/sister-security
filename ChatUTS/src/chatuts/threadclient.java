/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatuts;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author cynux
 */
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
               Masukinput = new ObjectOutputStream(socket.getOutputStream());
               Keluaroutput = new ObjectInputStream(socket.getInputStream());
               String message = (String) Masukinput.readObject();
               username = message.split("~")[1];
               System.out.print(username + " telah masuk");
           }catch(IOException e){
               System.out.println("Error "+e);
           } catch(ClassNotFoundException e){
               
           }
       
   }
       
   }
  
