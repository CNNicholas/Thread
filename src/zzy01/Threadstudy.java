package zzy01;
/**
 * ���̷߳�ʽһ�����̳�thread
 * @author ������1999
 *
 */

public class Threadstudy extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0;i<10;i++) {
			System.out.println("����");
		}
		super.run();
	}
	public static void main(String[] args) {
		Threadstudy ts = new Threadstudy();
		ts.start();
		for(int i = 0;i<10;i++) {
			System.out.println("����Ϸ");
		}
	}

}
