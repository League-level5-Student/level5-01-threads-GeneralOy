package _04_Thread_Pool;

import static org.junit.Assert.*;

import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.junit.Test;

//   import thread_pool.ThreadPool;
//   A Thread Pool is a way of managing multiple threads with multiple workloads.
//   It works by collecting a list of tasks to be performed by a thread.
//   A pool of threads is then created, and each thread takes a task from the list and does that work.
//   This continues until all the tasks are done.
//   When all the tasks are complete, the thread pool has finished its job.
//   This test will use a Thread pool to convert a large amount of lower case characters to upper case

//1. Fill in the ThreadPool and Worker classes and the Task interface according to the Thread Pool UML Diagram.

public class ThreadPoolTest {

	@Test
	public void test() {
		int total = 10000;

		ThreadPool tp = new ThreadPool(total);
		char[] chars = new char[total];

		for (int i = 0; i < total; i++) {
			chars[i] = (char) (new Random().nextInt(25) + 97);
		}

		int count = (int) Math.sqrt(total);
		//System.out.println(total);
		//System.out.println((int)Math.sqrt(total));
		//System.out.println(count);
		for (int i = 0; i < count; i++) {
			int x = i * count;
			System.out.println(count);
			//System.out.println(i + "," + x);
			tp.addTask(() -> {
				for (int j = 0; j < count; j++) {
					chars[x + j] = Character.toUpperCase(chars[x + j]);
					//System.out.println(x+j);
				}
				
			});
			//System.out.println(tp.taskQueue.size());
			//System.out.println(tp.threads.length);
		}

		long start = System.currentTimeMillis();
		//System.out.println(chars);
		tp.start();

		long end = System.currentTimeMillis() - start;
		System.out.println(chars);
		System.out.println("Total time: " + end);
		for (char c : chars) {
			assertTrue(Character.isUpperCase(c));
			
		}
	}
}
