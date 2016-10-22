package OS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import sun.security.util.PendingException;

/**
 *
 * @author Cynux
 */
public class Proses implements Serializable {

    private String nama, jurusan, asal;
    private int nim;

    public Proses(int nim, String nama, String jurusan, String asal) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
        this.asal = asal;
    }

    public int getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public String getJurusan() {
        return jurusan;
    }

    public String getAsal() {
        return asal;
    }

    public void printData() throws ClassNotFoundException {
        JOptionPane.showMessageDialog(null, "NIM : " + nim + "\nNAMA : " + nama + "\nJURUSAN : " + jurusan + "\nASAL : " + asal);
    }

    public void saveObject(Proses obj) throws IOException {
        try { 
            FileOutputStream fos = new FileOutputStream("tulisan.txt");
        ObjectOutputStream out = new ObjectOutputStream(fos);
        out.writeObject(obj);
        out.flush();
        fos.close();
        }catch (IOException e){
            System.out.println("Erro di "+e.getMessage());
        }
    }

    public void readObject(Proses inp) throws IOException, ClassNotFoundException {
        try {
            FileInputStream cetak = new FileInputStream("tulisan.txt");
        ObjectInputStream ois = new ObjectInputStream(cetak);
        inp = (Proses) ois.readObject();
        inp.printData();
        cetak.close();

        }catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error di "+ ex.getMessage());
            System.exit(1);
        }
    }

    public void Remove(int Nim) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream("tulisan.txt");
        ObjectOutputStream out = new ObjectOutputStream(fos);
        out.reset();
        
    }

}
