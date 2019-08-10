package text;

public class trafficlight {

	public static void main(String[] args) {
		Tv tv = new Tv();
		new Thread(new Player(tv)).start();
		new Thread(new Watcher(tv)).start();

	}

}

class Player implements Runnable{
	Tv tv;
	
	public Player(Tv tv) {
		this.tv = tv;
	}
	@Override
	public void run() {
		for(int i = 0;i<100;i++) {
			if(i%2==0) {
				this.tv.play("���ֶӵ����죡��");
			}else {
				this.tv.play("���ɶ�Ĺ�棡");
			}
		}
		
	}
}

class Watcher implements Runnable{
	Tv  tv;
	
	public Watcher(Tv tv) {
		super();
		this.tv = tv;
	}

	public void run() {
		for(int i=0;i<100;i++) {
			tv.watch();
		}
	}
}

class Tv{
	String voice;
	
	boolean flag = true;
	public synchronized void play(String voice) {
		if(!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("������"+voice);
		this.voice = voice;
		this.notifyAll();
		this.flag = !this.flag;
	}
	
	public synchronized void watch() {
		if(flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("�ۿ���"+voice);
		this.notifyAll();
		this.flag = !this.flag;
	}
}
