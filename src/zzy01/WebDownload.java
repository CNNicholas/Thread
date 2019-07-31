package zzy01;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class WebDownload {
	public void download(String url,String name) {
		try {
			FileUtils.copyURLToFile(new URL(url),new File(name));
		} catch (MalformedURLException e) {
			System.out.println("URL����");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("����ʧ��");
			e.printStackTrace();
		}	
		}
	

}
