package zzy01;

public class DownloadDicture extends Thread{
	private String url;
	private String name;
	
	public DownloadDicture(String url, String name) {
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
		DownloadDicture dp = new DownloadDicture("", "");  //网络地址  文件名
		DownloadDicture dp2 = new DownloadDicture("", "");
		DownloadDicture dp3 = new DownloadDicture("", "");
		
		dp.start();
		dp2.start();
		dp3.start();
	}

	
	

}
