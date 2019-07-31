package zzy01;
/**
 * 多线程方式一，，继承thread
 * @author 朱致宇1999
 *
 */

public class Threadstudy extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0;i<10;i++) {
			System.out.println("聊天");
		}
		super.run();
	}
	public static void main(String[] args) {
		Threadstudy ts = new Threadstudy();
		ts.start();
		for(int i = 0;i<10;i++) {
			System.out.println("玩游戏");
		}
	}

}
