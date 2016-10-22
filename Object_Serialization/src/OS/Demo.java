/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OS;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Cynux
 */
public class Demo {

    public void serialize(List<Proses> pList, String filename) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(pList);
        } catch (IOException e) {
            System.out.println("a problem accured during  serialization \n" + e.getMessage());

        }
    }

    public List<Proses> deserialize(String filename) throws ClassNotFoundException {
        List<Proses> plist = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            plist = (List<Proses>) in.readObject();
        } catch (IOException e) {
            System.out.printf("a problem accured deserializatin %s%n", filename);
            System.out.println(e.getMessage());
        }
        return plist;
    }

    
}
