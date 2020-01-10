package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker implements Runnable {
	ConcurrentLinkedQueue<Task> taskQueue;
	Worker(ConcurrentLinkedQueue<Task> taskQueueIn) {
		taskQueue = taskQueueIn;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//System.out.println(taskQueue.isEmpty());
		//System.out.println("hekk");
		while(!taskQueue.isEmpty()) {
			taskQueue.remove().perform();
			
		}
	}

}
