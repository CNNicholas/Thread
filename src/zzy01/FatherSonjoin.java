package zzy01;

public class FatherSonjoin {
	
	public static void main(String[] args) {
		System.out.println("���ְֺͶ������̵Ĺ��¡�");
		Thread father = new Father();
		father.start();
		}
	}
class Father extends Thread{
	public void run(){
		System.out.println("�ְ�����̣������̳Թ���~~");
		System.out.println("�ö���ȥ����");
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
		System.out.println("���ӽӹ�Ǯ���Ӽҳ���");
		System.out.println("·����Ϸ��������10��Сʱ");
		try {
			for(int i = 1;i<=10;i++) {
			Thread.sleep(1000);
			System.out.println("��ȥ��"+i+"Сʱ");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("����Ҫȥ���̣�����Ϸ������");
		System.out.println("��ȫ���ң�");
	}
}
