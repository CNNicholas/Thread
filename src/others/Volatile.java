package others;
/**
 * volatile
 **轻量级 Synchronized  保证线程之间变量的可见性,保证数据同步
 * @author 朱致宇1999
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
