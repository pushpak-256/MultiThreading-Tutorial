package multiTreading.thread.multiThreadingIn_blockingQueue;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
    
    int head = -1;
    Queue q ;
    private int size;

    public BlockingQueue(int size){
      this.size = size;
      q = new LinkedList<Integer>(); 
    }


    public synchronized boolean add(int x){
      
       /*
        * if synchronized is added in method signature it will take lock on object
          similary we can write it as
          
          public boolean add(int x) {
           synchronized (this) {
           }
        * }
        * 
        */

     // condition where queue is full; and Thread trying to add element
     while (head>=size){
         try {

            System.err.println(Thread.currentThread().getName()+ " waiting for Other Threads to remove");
             wait(); //wait until queue is not full; wait() will release lock and let other Thread continue
            // internally wait() will put Thread in WAITING state and put the thread in a set;
            // once other Thread call notify, Waiting Threads are moved in BLOCK for LOCK state
          } catch (InterruptedException e) {  e.printStackTrace();  }
     }
     System.err.println(q.toString());
     
    q.add(x);

     notifyAll();
     
      return true;
    }

    public synchronized int remove(){

     //condition where queue is empty and has no elemets in it
     while(head<0){
        try {
            
            System.err.println(Thread.currentThread().getName()+ " waiting for Other Threads to add");
         wait(); //wait until queue is not full; wait() will release lock and let other Thread continue
        } catch (InterruptedException e) {   e.printStackTrace(); }
      }
       notifyAll();
      System.err.println(q.toString());
      return (int)q.poll();
    }


    @Override
    public String toString() {
        return q.toString();
    }

    public static void main(String[] args) {
       
        BlockingQueue q = new BlockingQueue(4);

        Thread putter = new Thread("PUTTER"){
         @Override
         public void run() {
            for(int i =0; i<4 ; i++)
            q.add(i+1);
         }
        };

        Thread popper = new Thread("POPPER"){
            @Override
            public void run() {
               for(int i =0; i<4 ; i++)
               q.remove();
            }
           };

           Thread putter1 = new Thread("PUTTER1"){
            @Override
            public void run() {
               for(int i =0; i<4 ; i++)
               q.add(i+1);
            }
           };
   
           Thread popper1 = new Thread("POPPER1"){
               @Override
               public void run() {
                  for(int i =0; i<4 ; i++)
                  q.remove();
               }
              };

        putter.start();
        popper.start();
        putter1.start();
        popper1.start(); 
        
    }
}
