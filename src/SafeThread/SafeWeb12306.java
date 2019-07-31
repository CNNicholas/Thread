package SafeThread;
/**
 * Ä£Äâ12306»ÆÅ£ÇÀÆ±
 * @author ÖìÖÂÓî1999
 *
 */
public class SafeWeb12306 implements Runnable{
	private int ticketnums = 10;
	private boolean flag = true;
	@Override
	public void run() {
		while(flag) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			test();
		}
	}
	public synchronized void test() {  //Ê¹ÓÃsynchronized,Ëø·½·¨
		if(ticketnums <= 0) {
			flag = false;
			return ;
		}
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+ticketnums--);
	}
	public static void main(String[] args) {
		SafeWeb12306 web = new SafeWeb12306();
		new Thread(web,"»ÆÅ£Ò»ºÅ").start();
		new Thread(web,"»ÆÅ£¶şºÅ").start();
		new Thread(web,"»ÆÅ£ÈıºÅ").start();
	}
}
