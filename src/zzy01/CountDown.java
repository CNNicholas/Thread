package zzy01;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CountDown implements Runnable{
	
	private static Date startTime = new Date(System.currentTimeMillis());
	private static boolean flag = true; 
	private int i = 0;
	public void run(){
		while(flag) {
		System.out.println(new SimpleDateFormat("mm:ss").format(startTime));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		startTime =new Date(startTime.getTime()-1000);
		i++;
		if(i == 3) {  		//µ¹¼ÆÊ±
			flag =false;
		}
		}
	}
	public static void main(String[] args){
		CountDown cd = new CountDown();
		new Thread(cd).start();


	}

}
