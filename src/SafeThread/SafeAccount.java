package SafeThread;
/**
 * �̰߳�ȫ: �ڲ���ʱ��֤���ݵ���ȷ�ԡ�Ч�ʾ����ܸ�
 * synchronized
 * 1��ͬ������
 * 2��ͬ���� ,Ŀ�����ȷ
 * @author
 *  
 */
public class SafeAccount {
	public static void main(String[] args) {		
		//�˻�
		Account account =new Account(1000,"������");
		SynDrawing you = new SynDrawing(account,80,"�ɱ�����");
		SynDrawing wife = new SynDrawing(account,90,"happy����");
		you.start();
		wife.start();
	}
} 
 //ģ��ȡ�� �̰߳�ȫ
class SynDrawing extends Thread{
	Account account ; //ȡǮ���˻�
	int drawingMoney; //ȡ��Ǯ��
	int packetTotal ; //�ڴ�������	
	
	public SynDrawing(Account account, int drawingMoney,String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}

	@Override
	public void run() {
		test() ;
	}
	//Ŀ������account
	public  void test() {
		//�������
		if(account.money<=0) {
			return ;
		}
		//ͬ����
		synchronized(account) {
			if(account.money -drawingMoney<0) {
				return; 
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			account.money -=drawingMoney;
			packetTotal +=drawingMoney;
			System.out.println(this.getName()+"-->�˻����Ϊ:"+account.money);
			System.out.println(this.getName()+"-->�ڴ���ǮΪ:"+packetTotal);
		}
	}
}
