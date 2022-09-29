package Page_Object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;

public class TestBaseDespegar {
    public static void goToMainPage (WebDriver driver) {
    driver.get("https://www.despegar.com");
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
}

public static WebDriver iniciodeDriver (String browserName) {
    WebDriver driver=null;
    switch(browserName) {
	case "CHROME": {
		System.setProperty("webdriver.chrome.driver", "C:/Users/diego/Downloads/Nueva carpeta/ChromeDriver/chromedriver.exe");
		System.out.println("Abre Chrome");
		driver=new ChromeDriver();
		break;

	}
	case "EDGE":{
		System.setProperty("webdriver.msedge.driver", "C:/Users/diego/Downloads/Nueva carpeta/Driver_Notes/msedgedriver.exe");
		System.out.println("Abre Edge");
		driver=new EdgeDriver();
		break;
	}


    default:
        Reporter.log("No selecciona ningun browser correcto, se asigna chrome");
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        Reporter.log("Abre browser");
        driver=new ChromeDriver();

    }
    return driver;
}




}




