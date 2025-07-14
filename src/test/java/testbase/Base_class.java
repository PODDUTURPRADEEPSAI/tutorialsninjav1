package testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Base_class {
	
	public   WebDriver driver;
	public Logger logger;
	public Properties p;
	public FileInputStream f;
	
	
	@BeforeClass(groups={"Master"})
	@Parameters({"OS","Browser"})
	public void setup(String OS,String Br) throws IOException {
		logger=LogManager.getLogger(this.getClass());
		f =new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Config.properties");
		p=new Properties();
		p.load(f);	
		
		
		if(p.getProperty("environment").equals("Remote")) {
			
			DesiredCapabilities cap=new DesiredCapabilities();
			
			if (OS.equalsIgnoreCase("windows")){
				cap.setPlatform(Platform.WIN11);
			}
			else if(OS.equalsIgnoreCase("Mac")){
				cap.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("please check the OS name");
			}
			
			
			switch(Br.toUpperCase()) {
			
			case "CHROME":cap.setBrowserName("chrome");break;
			case "EDGE":cap.setBrowserName("MicrosoftEdge");break;
			default :System.out.println("please check the browser name");return;
			
			}
			
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		}
		
		
		if(p.getProperty("environment").equals("Local")) {
			
			switch(Br.toUpperCase()){
			case "CHROME":driver=new ChromeDriver();break;
			case "EDGE"  : driver=new EdgeDriver();break;
			case "firefox":driver=new FirefoxDriver();break;
			default : System.out.println("check the browser name");	
			}
			
			
		}
		
		
		
		driver.get(p.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass(groups={"Master"})
	public void flush() {
			driver.quit();	
	}
	

	public String randomAlphabit() {
		
		return RandomStringUtils.randomAlphabetic(5);
	}
	public String randomNumeric() {
		
		return RandomStringUtils.randomNumeric(7);
	}
	public String RandomAlphanumberic() {
		
		String Alpha =RandomStringUtils.randomAlphabetic(5);
		
		String numeric =RandomStringUtils.randomNumeric(10);
		return Alpha+numeric;
		
	}
	public String captureScreen(String tname) throws IOException {
		
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File Destination =new File(targetFilePath);
		sourceFile.renameTo(Destination);
		
		return targetFilePath;
		
		
	}

}
