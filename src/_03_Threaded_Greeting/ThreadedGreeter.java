package _03_Threaded_Greeting;

public class ThreadedGreeter implements Runnable {

	int level;
	public ThreadedGreeter(int level) {
		this.level = level;
	}
	
	@Override
	public void run() {
		System.out.println("Hello from thread " + level);
		if(level < 50) {
			Thread t = new Thread(new ThreadedGreeter(level+1));
			
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
