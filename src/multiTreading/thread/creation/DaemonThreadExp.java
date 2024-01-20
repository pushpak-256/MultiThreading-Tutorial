package multiTreading.thread.creation;

public class DaemonThreadExp {
    
    public static void main(String[] args) {
        
        System.out.println("Main Thread started excecution");
        // this does not call run method as Runnable obj of Thread class is null i.e. target is null
         (new Thread("ThreadName")).start();
         
        Thread target = new Thread("ThreadName") {
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {  e.printStackTrace();  }
                System.out.println("***"+ Thread.currentThread() +" says Hello world");
            }
        };
        // always mark thread as Daemon before starting the Thread;
        //Daemon thread waits for user threads to finish their execution before shutting down program excecution
        // when two or more Daemon thread are still running but all user threads are done excecution application will shutdown will not wait for daemon thread excecution
        target.setDaemon(true);
        target.start();       

        
        System.out.println("Main Thread finished excecution");
    }
}
