package multiTreading.thread.DeadLock_Race;

public class RaceDemo {

    public static void main(String[] args) {

        Stack stack = new Stack(3);

        while (!stack.exceptionOccured) { //keep on pushing and popping until race condition occur
         
        // putter thread
        Thread put = new Thread("PUTTER") {
            @Override
            public void run() {
                for (int i = 0; i < 11; i++) {
                    stack.push(i + 1);
                }
            }
        };

        // putter thread
        Thread put1 = new Thread("PUTTER1") {
            @Override
            public void run() {
                for (int i = 0; i < 11; i++) {
                    stack.push(i + 1);
                }
            }
        };

        // popper Thread
        Thread pop = new Thread("POPPER") {
            @Override
            public void run() {
                for (int i = 0; i < 11; i++) {
                    stack.pop();
                }
            }
        };

        // popper Thread
        Thread pop1 = new Thread("POPPER1") {
            @Override
            public void run() {
                for (int i = 0; i < 11; i++) {
                    stack.pop();
                }
            }
        };

        // start the threads here
        pop.start();
        put.start();
        pop1.start();
        put1.start();
       

        try { // wait for all Threads to complete excecution until new threads are created
            pop.join();
            pop1.join();
            put1.join();
            put.join();
        } catch (Exception e) {
            e.printStackTrace();
        } 

        // Check if the exception occurred during the operations
        if (stack.exceptionOccured) {
            System.out.println("Exception occurred. Stopping the loop.");
            break;
        }

    }
    }
}