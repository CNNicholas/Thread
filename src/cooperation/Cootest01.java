package cooperation;

/**
 * �̷ܳ�     ������ ������    ���뻺����
 * @author ������1999
 *
 */

public class Cootest01 {
	public static void main(String[] args) {
		SynContainer container = new SynContainer();
		new Productor(container).start();
		new Consumer(container).start();
	}
}
//������
class Productor extends Thread{
	SynContainer container;
	
	
	public Productor(SynContainer container) {
		super();
		this.container = container;
	}


	@Override
	public void run() {
		for(int i = 0;i<100;i++) {
			System.out.println("�����˵�"+i+"����ͷ");
			container.push(new Steamdbun(i));
		}
		
	}
	
}
//������
class Consumer extends Thread{
	SynContainer container;
	
	public Consumer(SynContainer container) {
		super();
		this.container = container;
	}

	@Override
	public void run() {
		
		for(int i = 0;i<100;i++) {
			System.out.println("������"+container.pop().id+"����ͷ");
		}
		
	}
}
//������
class SynContainer{
	Steamdbun[] buns = new Steamdbun[10];
	int count = 0;
	//����
	public synchronized void push(Steamdbun bun){
		//��ʱ��������
		if(count == buns.length) {
			try {
				this.wait(); //�߳�������������֪ͨ����
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		buns[count] = bun;
		count++;
		this.notifyAll();
	}
	//ȡ��
	public synchronized Steamdbun pop() {
		//����û�����ݣ���ͣȡ��
		if(count == 0) {
			try {
				this.wait(); //�߳������� ������֪ͨ���
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		count--;
		Steamdbun bun = buns[count];
		this.notifyAll();//���ڿռ䣬����������
		return bun;
		
	}
}
//��ͷ
class Steamdbun{
	int id;

	public Steamdbun(int id) {
		super();
		this.id = id;
	}
	
}
