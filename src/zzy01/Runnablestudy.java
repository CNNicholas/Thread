package zzy01;
/**
 * 多线程方式二，，实现接口Runnable
 * @author 朱致宇1999
 *
 */

public class Runnablestudy implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0;i<10;i++) {
			System.out.println("聊天");
		}
		
	}
	public static void main(String[] args) {
		Runnablestudy ts = new Runnablestudy();
		new Thread(ts).start();
		for(int i = 0;i<10;i++) {
			System.out.println("玩游戏");
		}
	}

}
