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
		//timer.schedule(new MyTask(), 1000);  //等待1秒，执行一次
		//timer.schedule(new MyTask(), 1000,1000);  //等待1秒，执行无数次，间隔为1秒
		Date time = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
		System.out.println(dateFormat.format(time));
		Calendar cal =  new GregorianCalendar(2019,8,2,11,19,30);
		timer.schedule(new MyTask(),cal.getTime(),200); 
		//开始时间  和  间隔
	}
}

class MyTask extends TimerTask{  //执行必须继承TimerTask ， 重写run
	
	@Override
	public void run() {
		for(int i = 0;i<5;i++) {
			System.out.println("hello world!!");
		}
		System.out.println("----------end----------");
		
	}
}