
package petersonalgo;

/**
 *
 * @author HaithamGamal
 */
public class PetersonAlgo {
static int a=0,b=1,counter,turn;//counting 100 times  process a and b
static boolean []interested=new boolean[2];//carry states of process
static int cin=14; //print value let it be data

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Thread t1=new Thread(new Runnable() {//open object of thread and then opening anonuymous object runnable
            @Override
            public void run() {
                try{
                do{
                interested[a]=true;//while stat of process  a is true
                turn=a;
                while(turn==a&&interested[b]);//
                //enter critical section
                    System.out.println("thread 1:"+cin); //printing data
                    cin++;//increment data to see changes
                    counter++;//counting turns of total threads
                    
                
                
                
                
                interested[a]=false;//leaving critical section and set flag of process a or interested a to be false
                
                }
                while(counter<=100);
                
             
            }
                catch(Exception e){
                    System.out.println("exception 1:"+e);
                    
                    
                }}
        });
        Thread  t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                   do{
                interested[b]=true; //seting flafg of process b is true
                turn=b;//turn of proces b
                while(turn==b&&interested[a]); //while its turn of b and state of process a true looping
                //enter critical section
                    System.out.println("thread 2:"+cin++);//increment global data
                  System.out.println("counter for thread2:"+counter++); //increment the counter counts times of threads accessing
                interested[b]=false;
                //leaving critical section and set interested of b to false as it is not interested
                
                }
                while(counter<=100);
                
                }
                catch(Exception e){System.out.println("exception2:"+e);}
            }
        });
        t1.start(); //starting and beginnig of 2 threads
        t2.start();
        
    }
    
    
    
}
