package others;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

public class Timerytest {
	public static void main(String[] args) {
		Timer timer = new Timer();
		//timer.schedule(new MyTask(), 1000);  //�ȴ�1�룬ִ��һ��
		//timer.schedule(new MyTask(), 1000,1000);  //�ȴ�1�룬ִ�������Σ����Ϊ1��
		Date time = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
		System.out.println(dateFormat.format(time));
		Calendar cal =  new GregorianCalendar(2019,8,2,11,19,30);
		timer.schedule(new MyTask(),cal.getTime(),200); 
		//��ʼʱ��  ��  ���
	}
}

class MyTask extends TimerTask{  //ִ�б���̳�TimerTask �� ��дrun
	
	@Override
	public void run() {
		for(int i = 0;i<5;i++) {
			System.out.println("hello world!!");
		}
		System.out.println("----------end----------");
		
	}
}