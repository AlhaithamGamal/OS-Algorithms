/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandctask;

/**
 *
 * @author HaithamGamal
 */
public class PAndCTask {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        //first we need two threads one for producer and other for consumer;
        final ProduceAndConsume pc=new ProduceAndConsume();
        //creating object of producer 
        Thread t1=new Thread(new Runnable(){
            //open anonymous object and begin execcuting thread for producing
            @Override
            public void run() {
                try{
                     pc.produce(); //begin producing
                
                
                }
                catch(Exception e){
                    System.out.println("exception:"+e);
                
                }
            }
        
        
        });
        Thread t2=new Thread(new Runnable(){
            //open another object from thread 2 and open anonymous object to begin 
            @Override
            public void run() {
                
                try{
                  pc.consume();//begin consuming after other thread producing
                
                }
                catch(Exception e){
                    System.out.println("exception2:"+e);
                
                }
            }
        
        
        
        });
        t1.start();//staritng thread one
        t2.start();//startin thread 2
        t1.join();//waiting for thread 2 to die and print result
        t2.join();//waitnig for thread one to die and print result
        
        
        
        
        
    }
    
}
