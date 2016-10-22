/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikum;

/**
 *
 * @author cynux
 */
public class counter {
    private int countValue;
    public counter(){
        countValue =0;
    }
    public counter(int start){
        countValue = start;
    }
    
    public synchronized void increaseCount(){
        int count = countValue;
        try{
            Thread.sleep(5);
            
        }catch(InterruptedException ie) {
            
        }
        count = count +1;
        countValue =count;
    }
    public synchronized  int getCount(){
        return countValue;
    }
            
    
}
