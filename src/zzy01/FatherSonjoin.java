package zzy01;

public class FatherSonjoin {
	
	public static void main(String[] args) {
		System.out.println("《爸爸和儿子买烟的故事》");
		Thread father = new Father();
		father.start();
		}
	}
class Father extends Thread{
	public void run(){
		System.out.println("爸爸想抽烟，可是烟吃光了~~");
		System.out.println("让儿子去买烟");
		Thread son = new Son();
		son.start();
		try {
			son.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

class Son extends Thread{
	public void run(){
		System.out.println("儿子接过钱，从家出发");
		System.out.println("路过游戏厅，晚了10个小时");
		try {
			for(int i = 1;i<=10;i++) {
			Thread.sleep(1000);
			System.out.println("过去了"+i+"小时");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("想起要去买烟，从游戏厅出发");
		System.out.println("安全到家！");
	}
}
