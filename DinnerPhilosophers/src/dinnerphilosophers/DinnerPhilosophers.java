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
public class DinnerPhilosophers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Philosopher[] phsps=new Philosopher[5];
        // create array of 5 philosophers
        Object [] forks=new Object[phsps.length];
        //create array of forks its isze equals size of philosophers
        //with datatype object carry any datatype
        for (int i = 0; i < forks.length; i++) {
            forks[i]=new Object();
            //assign every object in each iterator
            
        }
        for (int i = 0; i < phsps.length; i++) {
            Object forkLeft=forks[i];
            //each process have left and right fork
            //left fork represent left resource
            Object forkRight=forks[(i+1)%phsps.length];
            //right fork represent right resource
            if(i==phsps.length-1){
            phsps[i]=new Philosopher(forkRight,forkLeft);}
            //condition if if i equals end length of array 
            //then let process carry right first then left to break the cycle of dead lock
            //2 process will access same resource one will access right fork and othet process will access left fork
            //that appeared to be left but right to beside process
            else
            {phsps[i]=new Philosopher(forkLeft,forkRight);}
            //else any process will access left first
            Thread pthd=new Thread(phsps[i],"Philosopher-"+(i+1));
            //creating thread every iteration that carry the philosopher obj that contains forks
            // and name of thread with counter
            pthd.start();
            
            
        }
    }
    
}
