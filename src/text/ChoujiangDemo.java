package text;

public class ChoujiangDemo {
	public static void main(String[] args) {
		human p =new human();
		
		new Thread(p,"朱").start();
		new Thread(p,"王").start();
		new Thread(p,"赵").start();
	}
}
class human implements Runnable{
	
	int []var= {200,500,600,100,300};
	int num = 0;
	boolean flag = true;
	@Override
	public void run() {


		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while(flag) {
			if(num==var.length-2) {
				flag = false;
				return;
			}
			synchronized(this) {
				System.out.println(Thread.currentThread().getName()+"-->抽中了"+var[num++]+"元");
		
			}
		}
	}
}
