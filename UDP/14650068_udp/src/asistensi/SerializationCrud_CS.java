/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asistensi;

import asistensi.olah_app_crud_CS;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @author cynux
 */
public class SerializationCrud_CS {
    File f=new File("src/modul4/crud_db.ser");
    public void serialize(List<olah_app_crud_CS>lList){
        try{
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(lList);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public List<olah_app_crud_CS>deserialize(){
        List<olah_app_crud_CS>lList=null;
        try{
            ObjectInputStream ois=new ObjectInputStream(new FileInputStream(f));
            lList=(List<olah_app_crud_CS>) ois.readObject();
        }catch(Exception e){
            System.out.println(e);
        }
        return lList;
    }
    
}
