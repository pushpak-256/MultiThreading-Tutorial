package multiTreading.thread.lifeCycle_ThreadStates;
public class ThreadLifecycleExample {

    public static void main(String[] args) {
        
        Thread t = new Thread("Thread1"){
            @Override
            public void run() {
                try {
                    Thread.sleep(1);
                    for(int i =0;i<100000;i++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
            
        while (true) {
            System.err.println(t.getState());
            if(t.getState()==Thread.State.TERMINATED) break;
        }
       
    }
}
