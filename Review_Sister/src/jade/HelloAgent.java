/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jade;

import jade.core.Agent;
import java.util.Iterator;

/**
 *
 * @author cynux
 */
public class HelloAgent extends Agent {
    protected void setup(){
        System.out.println("Hello World I'm Agent ");
        System.out.println("mylocal name : "+getAID().getLocalName());
        System.out.println("My GUID is "+getAID().getName());
        System.out.println("My Adresses are " );
        Iterator it = getAID().getAllAddresses();
        while(it.hasNext()){
            System.out.println("-- "+ it.next());
            
        }
    }
}
