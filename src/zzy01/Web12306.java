package zzy01;
/**
 * ģ��12306��ţ��Ʊ
 * @author ������1999
 *
 */
public class Web12306 implements Runnable{
	private int ticketnums = 99;
	@Override
	public void run() {
		while(true) {
			if(ticketnums < 0) {
				break;
			}
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+ticketnums--);
		}
	}
	public static void main(String[] args) {
		Web12306 web = new Web12306();
		new Thread(web,"��ţһ��").start();
		new Thread(web,"��ţ����").start();
		new Thread(web,"��ţ����").start();
	}
}
