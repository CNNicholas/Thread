package zzy01;
/**
 * ���̷߳�ʽ������ʵ�ֽӿ�Runnable
 * @author ������1999
 *
 */

public class Runnablestudy implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0;i<10;i++) {
			System.out.println("����");
		}
		
	}
	public static void main(String[] args) {
		Runnablestudy ts = new Runnablestudy();
		new Thread(ts).start();
		for(int i = 0;i<10;i++) {
			System.out.println("����Ϸ");
		}
	}

}
