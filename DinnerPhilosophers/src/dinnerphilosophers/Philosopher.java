/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dinnerphilosophers;

/**
 *
 * @author HaithamGamal
 */
public class Philosopher implements Runnable {
    Object leftFork; //left philosopher fork defined by object parent java class where
    //it stores any data
    Object rightFork;//right philosopher fork
    Philosopher(Object leftFork,Object rightFork){
    //assigning left and right fork top passed parameters
    this.leftFork=leftFork;
    this.rightFork=rightFork;
    }
    public void doAction(String act) throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+"  "+act);//get thread name and its action
        Thread.sleep((int)Math.random()*100); 
        //get thread name action and set random time for each thread in order to not define specefic time
        //to know diffeence between thread and another
      

    }

    @Override
    public void run() {
        try{
            while(true){
                doAction(System.nanoTime()+"Thinking!");
                //begin with initial stae thinking
                synchronized(leftFork){
                doAction(System.nanoTime()+"pick up left fork");
                //picking left fork finish left then enter right
                synchronized(rightFork){
                doAction(System.nanoTime()+"pick up right fork-eating");
                //picking right then eating 
                doAction(System.nanoTime()+"eating!");
                    doAction(System.nanoTime()+"put down right fork");
                    //finish eating put down right fork
                
                
                }
                //put down left fork and finish 
                doAction(System.nanoTime()+"put down left bact to thinking");
                
                
                
                
                
                }
            
            
            
            }
        
        
        
        }catch(InterruptedException e){Thread.currentThread().interrupt(); return;}
            
    }
    
    
}
