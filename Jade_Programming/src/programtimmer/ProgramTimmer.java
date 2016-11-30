package programtimmer;

import jade.core.Agent;
import javax.swing.JOptionPane;

public class ProgramTimmer extends Agent {

    String detik = JOptionPane.showInputDialog("Masukkan jumlah detik");
    int d = Integer.parseInt(detik);
    int timer = 1000;

//timer dengan satuan second/ detik
//contoh timer saya adalah 10 detik
//int waktu=10;
    public void setup() {
        addBehaviour(new ticker(this, timer, d));
    }

}
