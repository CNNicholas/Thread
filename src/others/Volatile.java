package others;
/**
 * volatile
 **������ Synchronized  ��֤�߳�֮������Ŀɼ���,��֤����ͬ��
 * @author ������1999
 *
 */
public class Volatile {
	private volatile static int num = 0;  
	public static void main(String[] args) throws InterruptedException {
		new Thread(()->{
			while(num==0) {
				
			}
		}).start();
		
		Thread.sleep(1000);
		num = 1;
	}

}
