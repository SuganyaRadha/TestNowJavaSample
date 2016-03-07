package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestConfig {

	public static void main(String[] args) throws IOException {
		Properties Config = new Properties();
		FileInputStream ip = new FileInputStream (System.getProperty("user.dir")+"//src//test//java//com//testnowjavasample//config//config.properties");
		Config.load(ip);
		System.out.println(Config.get("testURL"));
		
		Properties OR = new Properties();
		ip = new FileInputStream (System.getProperty("user.dir")+"//src//test//java//com//testnowjavasample//config//OR.properties");
		OR.load(ip);
		System.out.println(OR.get("magento_homepage"));
	}

}
