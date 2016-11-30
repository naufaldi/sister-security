package programtimmer;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class ticker extends TickerBehaviour {

    int waktu;

    public ticker(Agent a, long period, int waktu) {
        super(a, period);
        this.waktu = waktu;
    }

    protected void onTick() {

        if (waktu == 0) {
            System.out.println("Time is up");
            myAgent.doDelete(); // memberhentikan
        } else {
            System.out.println(waktu);
            waktu--;
        }
    }
}
