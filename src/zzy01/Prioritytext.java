package zzy01;

public class Prioritytext {
	public static void main(String[] args) {
		//System.out.println(Thread.currentThread().getPriority());
		text t =new text();
		
		Thread thread1 = new Thread(t,"max1");
		Thread thread2 = new Thread(t,"max2");
		Thread thread3 = new Thread(t,"max3");
		Thread thread4 = new Thread(t,"min4");
		Thread thread5 = new Thread(t,"min5");
		Thread thread6 = new Thread(t,"min6");
		
		//设置优先级，必须在启动之前
		thread1.setPriority(Thread.MAX_PRIORITY);
		thread2.setPriority(Thread.MAX_PRIORITY);
		thread3.setPriority(Thread.MAX_PRIORITY);
		
		thread4.setPriority(Thread.NORM_PRIORITY);
		thread5.setPriority(Thread.NORM_PRIORITY);
		thread6.setPriority(Thread.NORM_PRIORITY);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();
		
	}
}
class text implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
		
	}
	
}
