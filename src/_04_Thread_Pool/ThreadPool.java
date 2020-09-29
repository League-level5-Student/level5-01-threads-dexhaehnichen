package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadPool {

	Thread[] threads;
	ConcurrentLinkedQueue<Task> queue;
	
	ThreadPool(int totalThreads){
		threads = new Thread[totalThreads];
		
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new Worker(queue));
		}
		
		queue = new ConcurrentLinkedQueue();
	}
	
	public void addTask(Task task) {
		queue.add(task);
	}
	
	public void start() {
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
