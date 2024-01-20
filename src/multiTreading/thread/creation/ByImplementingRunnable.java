package multiTreading.thread.creation;

class MultiThreading implements Runnable { //1 implement Runnable interface, (keeps space for extending other class)
	 private static int objCount = 1;
	
	 MultiThreading(){
		System.out.println("object no "+(objCount++)
				+ " is created for Thread " + Thread.currentThread().getId()+"\n");
	}
	 
	//2 override run() method
	@Override
	public void run(){
		System.out.println( "Thread " + Thread.currentThread().getId()  + " is running");
		
		for(int i =1 ;i < 6; i++ )
			System.out.println("Thread " + Thread.currentThread().getId()  + " no "+ i);
	}
}

public class ByImplementingRunnable {

	public static void main(String[] args) {
		MultiThreading x = new MultiThreading();
		x.run();
//        x.start(); // cannot use thread related methods here unlike in Extending we can
		
		for (int i = 0; i < 3; i++) {
			Thread thread = new Thread(x);
			thread.start();   // only here we can call thread related fuctions
		}
	}
}
