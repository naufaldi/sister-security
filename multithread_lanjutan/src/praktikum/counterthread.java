/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikum;

import sun.swing.text.CountingPrintable;

/**
 *
 * @author cynux
 */
public class counterthread  implements Runnable{
    counter mycounter;
    int countAmount;
    public counterthread(counter counter,  int amount){
        mycounter = counter;
        countAmount = amount;
    }
    public void run(){
        for (int i=1 ; i <= countAmount ; i++){
            mycounter.increaseCount();
            System.out.println(" "+mycounter.getCount());
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        counter c = new counter();
        Runnable runner = new counterthread(c,10);
        System.out.println("Starting counting threads");
        Thread t1 = new Thread(runner);
        Thread t2 = new Thread(runner);
        Thread t3 = new Thread(runner);
        t1.start(); t2.start(); t3.start();
        t1.join(); t2.join(); t3.join();
        System.out.println("Counter value is "+ c.getCount());
        
        
    }
}
