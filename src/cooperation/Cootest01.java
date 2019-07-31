package cooperation;

/**
 * 管程法     生产者 消费者    加入缓冲区
 * @author 朱致宇1999
 *
 */

public class Cootest01 {
	public static void main(String[] args) {
		SynContainer container = new SynContainer();
		new Productor(container).start();
		new Consumer(container).start();
	}
}
//生产者
class Productor extends Thread{
	SynContainer container;
	
	
	public Productor(SynContainer container) {
		super();
		this.container = container;
	}


	@Override
	public void run() {
		for(int i = 0;i<100;i++) {
			System.out.println("生产了第"+i+"个馒头");
			container.push(new Steamdbun(i));
		}
		
	}
	
}
//消费者
class Consumer extends Thread{
	SynContainer container;
	
	public Consumer(SynContainer container) {
		super();
		this.container = container;
	}

	@Override
	public void run() {
		
		for(int i = 0;i<100;i++) {
			System.out.println("购买了"+container.pop().id+"个馒头");
		}
		
	}
}
//缓冲区
class SynContainer{
	Steamdbun[] buns = new Steamdbun[10];
	int count = 0;
	//生产
	public synchronized void push(Steamdbun bun){
		//何时可以生产
		if(count == buns.length) {
			try {
				this.wait(); //线程阻塞，消费者通知生产
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		buns[count] = bun;
		count++;
		this.notifyAll();
	}
	//取出
	public synchronized Steamdbun pop() {
		//容器没有数据，暂停取出
		if(count == 0) {
			try {
				this.wait(); //线程阻塞， 生产者通知解除
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		count--;
		Steamdbun bun = buns[count];
		this.notifyAll();//存在空间，唤醒生产者
		return bun;
		
	}
}
//馒头
class Steamdbun{
	int id;

	public Steamdbun(int id) {
		super();
		this.id = id;
	}
	
}
