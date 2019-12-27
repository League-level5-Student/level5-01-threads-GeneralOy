package _03_Threaded_Reverse_Greeting;

public class ThreadedReverseGreeting {
	int numThreads = 1;
	public static void main(String[] args) {
		ThreadedReverseGreeting main = new ThreadedReverseGreeting();
	} 
	
	public ThreadedReverseGreeting() {
		Thread starter = new Thread(()->threader());
		starter.start();
		//System.out.println("test");
		// TODO Auto-generated constructor stub
	}
	
	public void threader(/*Thread threadee*/) {
		//System.out.println(numThreads);
		
		if(numThreads < 50) {
			Thread nextThread = new Thread(() -> threader());
			nextThread.start();
		}

		System.out.println("Hello from thread " + numThreads);
		numThreads++;
	}
  //Write a program that creates a thread (Thread 1) that creates another thread (Thread 2); 
  //Thread 2 creates Thread 3; and so on, up to Thread 50. 
  //Each thread should print "Hello from Thread <num>!", 
  //but you should structure your program such that the threads print their greetings in reverse order.
	
	/* HINT: You will most likely need to do this with recursion */
}
