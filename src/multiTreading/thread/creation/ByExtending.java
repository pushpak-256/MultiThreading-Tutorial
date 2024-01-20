package multiTreading.thread.creation;

class MultiThreadingDemo extends Thread { //1 extend thread
	 private static int objCount = 1;
	
	 MultiThreadingDemo(){
		System.out.println("object no "+(objCount++)
				+ " is created for Thread " + Thread.currentThread().getId());
	}
    
	//2 override run() method
	@Override
	public void run(){
		System.out.println( "Thread " + Thread.currentThread().getId()  + " is running");
		
		for(int i =1 ;i < 6; i++ )
			System.out.println("Thread " + Thread.currentThread().getId()  + " no "+ i);
	}
}

public class ByExtending {

	public static void main(String[] args) {
	
		// run() does not create new thread and behaves as normal method in class
		for (int i = 0; i < 3; i++) {
			MultiThreadingDemo obj = new MultiThreadingDemo();
			obj.run();
		}
		
		System.out.println();
		
		//start() method create new thread each time and multi-threading is achieved 
		for (int i = 0; i < 3; i++) {
			MultiThreadingDemo obj = new MultiThreadingDemo();
			obj.start();
		}
	}
}
