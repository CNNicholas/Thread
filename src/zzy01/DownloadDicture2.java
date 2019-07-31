package zzy01;
/**
 * 多线程方式二，，实现接口Runnable
 * @author 朱致宇1999
 *
 */

public class DownloadDicture2 implements Runnable{
	private String url;
	private String name;
	
	public DownloadDicture2(String url, String name) {
		super();
		this.url = url;
		this.name = name;
	}
	@Override
	public void run() {
		WebDownload wd = new WebDownload();
		wd.download(url, name);
	}
	
	public static void main(String[] args) {
		DownloadDicture2 dp = new DownloadDicture2("", "");  //网络地址  文件名
		DownloadDicture2 dp2 = new DownloadDicture2("", "");
		DownloadDicture2 dp3 = new DownloadDicture2("", "");
		
		new Thread(dp).start();
		new Thread(dp2).start();
		new Thread(dp3).start();
	}

	
	

}
