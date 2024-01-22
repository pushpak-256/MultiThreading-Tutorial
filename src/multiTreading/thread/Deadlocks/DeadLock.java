package multiTreading.thread.Deadlocks;

public class DeadLock {

    // following locks will be required by a thread to finish task
    private static String lock1 = "lock1";
    private static String lock2 = "lock2";

    public static void main(String[] args) {

        Thread t1 = new Thread("Thread1") {
            public void run() {
                synchronized (lock1) {
                    System.out.println(lock1 + " aquired " + Thread.currentThread().getName());
                    synchronized (lock2) {
                        System.out.println(lock2 + " aquired by " + Thread.currentThread().getName());
                        System.out.println(Thread.currentThread().getName() + " finished Excecution");
                    }
                }
            };
        };

        Thread t2 = new Thread("Thread2") {
            public void run() {
                synchronized (lock2) {
                    System.out.println(lock2 + " aquired by " + Thread.currentThread().getName());
                    synchronized (lock1) {
                        System.out.println(lock1 + " aquired " + Thread.currentThread().getName());
                        System.out.println(Thread.currentThread().getName() + " finished Excecution");
                    }
                }
            };
        };

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main method finished exceution");

    }
}
