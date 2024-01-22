package multiTreading.thread.lifeCycle_ThreadStates.Join;

public class WithoutJoin {
    
    public static void main(String[] args) {
        
        System.out.println("### main started");
        
        Thread t1 = new Thread("userThread"){
            public void run() {
              System.err.println(Thread.currentThread().getName()+" printing - "+(1+5));
            };
        };
        t1.start();  // main thread might not wait for its child threads to complete exceution
        
        System.out.println("### main Ended");
    }
}
