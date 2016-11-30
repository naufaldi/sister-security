/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jade_lanjutan;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;


/**
 *
 * @author cynux
 */
public class sender extends Agent{
    @Override
    protected void setup() {
            addBehaviour(new TickerBehaviour(this, 1000) {
                
                @Override
                protected void onTick() {
                    System.out.println(myAgent.getLocalName()+" mengirim pesan");
                    ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                    msg.addReceiver(new AID("Agent Penerima ", AID.ISLOCALNAME));
                    msg.setContent("ini pesan dari "+ myAgent.getLocalName());
                    send(msg);
                }
            });
}
}
