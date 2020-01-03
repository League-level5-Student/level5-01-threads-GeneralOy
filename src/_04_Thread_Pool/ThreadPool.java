package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadPool {
	ConcurrentLinkedQueue<Task> taskQueue;
	Thread[] threads;
	public ThreadPool(int totalThreads) {
		threads = new Thread[totalThreads];
		// TODO Auto-generated constructor stub
		for(int i = 0; i < totalThreads; i++) {
			threads[i] = new Thread(()-> {Worker worker = new Worker(taskQueue);});
		}
		taskQueue = new ConcurrentLinkedQueue<Task>();
	}
	public void addTask(Task Task) {
		taskQueue.add(Task);
	}

	public void start() {
		for(Thread t : threads) {
			t.run();
		}
		try {
			threads[0].join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
