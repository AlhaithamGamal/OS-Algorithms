/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandctask;

import java.util.LinkedList;

/**
 *
 * @author HaithamGamal
 */
class ProduceAndConsume {
    LinkedList<Integer> buffer =new LinkedList<Integer>(); //where list represents buffer
    int capacity=2; //where capacity is the maximum size buffer can reach
    void produce() throws InterruptedException {
        int value=0;
        while(true){//poooling running forever doing an action
            synchronized(this){ //synchronized to allow lock of one thread
                while(buffer.size()==capacity)
                    wait(); //waits while the buffer is full
                System.out.println("Producer Produces:"+value);
                buffer.add(value+=1); //if it is not full adding increment values
                notify(); //notify consumer that a value is added
                Thread.sleep(1000);//sleeping thread sec to show difference between thread and other
                    }
        
        
        } 
            
    }

    void consume() throws InterruptedException {
        int val; //carry removed item
        
        while(true){
            synchronized(this){
                while(buffer.size()==0)
                    wait(); //if buffer is empty thread waits until it filled
                val=buffer.removeFirst();//remove first item added to buffer
                System.out.println(" item consumedd:"+val);
                notify();//nottify producer that finish consuming
               Thread. sleep(1000);
            
            }
        
        
        
        }
    }
    
}
