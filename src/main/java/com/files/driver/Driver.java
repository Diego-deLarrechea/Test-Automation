package com.files.driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;


	public class Driver {
		public static void PaginaDespegar(WebDriver driver) {
			driver.manage().window().maximize();
			driver.get("https://www.despegar.com");	
			
			}
			public static WebDriver iniciodeDriver(String browserName) {
				WebDriver driver=null;
				
				switch(browserName) {
				case "CHROME":{
					System.setProperty("webdriver.chrome.driver", "C:/Users/diego/Downloads/Nueva carpeta/ChromeDriver/chromedriver.exe");
					System.out.println("Abre Chrome");
					driver=new ChromeDriver();
					break;
			
				}
				case "EDGE":{
					System.setProperty("webdriver.edge.driver", "C:/Users/diego/Downloads/Nueva carpeta/Driver_Notes/msedgedriver.exe");
					System.out.println("Abre Edge");
					driver=new EdgeDriver();
					break;
				}
				default:
					Reporter.log("No selecciona browser, se asigna chrome");
					System.setProperty("webdriver.chrome.driver", "src/test/driver/chromedriver.exe");
					Reporter.log("Abre browser");
					driver=new ChromeDriver();
					
				}
				return driver;
			}
				
			
	}
