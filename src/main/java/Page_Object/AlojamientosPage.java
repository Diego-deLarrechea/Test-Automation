package Page_Object;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui. WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import java.time.Duration;
import java.util.List;

public class AlojamientosPage {
	@FindBy (css =".login-incentive--header .login-incentive--close.shifu-3-icon-close.-eva-3-mr-md")
	WebElement CerrarIngresoGmail;
	@FindBy (css=".lgpd-banner .btn-text")
	WebElement Banner;
	@FindBy(linkText="Alojamientos")
    WebElement Alojamientos;
	@FindBy(css = ".sbox5-box-places-ovr input")
	WebElement Destino;
	@FindBy(css = ".sbox5-box-dates-checkbox-container .sbox5-dates-input1-container")
	WebElement FechaDeEntrada;
	@FindBy(xpath = "//*[@class=\"sbox5-floating-tooltip sbox5-floating-tooltip-opened\"]//*[@class=\"sbox5-monthgrid\" and "
    + "@data-month=\"2022-09\"]//*[@class=\"sbox5-monthgrid-dates sbox5-monthgrid-dates-30\"]/child::div[30]")
	WebElement DiaDeEntrada;
	@FindBy(css = ".sbox5-box-dates-checkbox-container .sbox5-dates-input2-container")
	WebElement FechaDeSalida;
	@FindBy(xpath = "//*[@class=\"sbox5-floating-tooltip sbox5-floating-tooltip-opened\"]//*[@class=\"sbox5-monthgrid\" and "
    + "@data-month=\"2022-10\"]//*[@class=\"sbox5-monthgrid-dates sbox5-monthgrid-dates-31\"]/child::div[18]")
	WebElement DiaDeSalida;
	@FindBy(css = ".sbox5-floating-tooltip.sbox5-floating-tooltip-opened .calendar-footer .btn-text")
	WebElement BotonAplicar;
	@FindBy(css = ".sbox5-3-double-input")
	WebElement Habitaciones;
	@FindBy(css = ".stepper__room .stepper__room__row:nth-child(1) .steppers-icon-right")
	WebElement CantidadAdultos;
	@FindBy(css = ".stepper__room .stepper__room__row:nth-child(2) .steppers-icon-right")
	WebElement Menores;
	@FindBy (css = ".select-container .select")
	WebElement EdadMenor;
	@FindBy(xpath="//*[@class=\"select-option\" and @value=\"4\"]")
	WebElement eMenor;
	@FindBy(css = ".distribution__container.distribution__type__rooms .sbox5-3-btn.-md.-primary")
	WebElement AplicarHab;
	@FindBy (css = ".sbox5-box-button-ovr,sbox5-3-btn sbox5 -button -secondary -icon -lg .btn-text")
	WebElement Buscar;
	@FindBy (css = ".tooltip-container.-eva-3-shadow-1 .tooltip-close.eva-3-icon-close")
	WebElement Banner3;
	@FindBy (css = ".results-cluster-container")
	WebElement SeleccionarHotel;
	
	
private WebDriver driver=null;
private WebDriverWait wait;

	
    public AlojamientosPage (WebDriver driver) {
    	this.driver=driver;
    	this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	PageFactory.initElements(driver, this);
    	
}

    public ResultadosPage searchText(String text) throws InterruptedException {
    	CerrarIngresoGmail.click();
    	Banner.click();
    	Alojamientos.click();
    	Destino.click();  
    	System.out.println("Ingresa el destino");
    	this.Destino.sendKeys(text);
    	Thread.sleep(2000);
    	Destino.sendKeys(Keys.CONTROL);
    	Thread.sleep(2000);
    	Destino.sendKeys(Keys.ENTER);
    	Thread.sleep(2000);
    	
    	
    	System.out.println("ClickFechaDeEntrada");
    	wait.until(ExpectedConditions.visibilityOf(FechaDeEntrada));
    	FechaDeEntrada.click();  
    	  	 	
	    System.out.println("ClickDiaDeEntrada 30/09/2022");
	    wait.until(ExpectedConditions.visibilityOf(DiaDeEntrada));
	    DiaDeEntrada.click();
	      
	    System.out.println("ClickFechaDeSalida");
	    wait.until(ExpectedConditions.visibilityOf(FechaDeSalida));
	    FechaDeSalida.click();  
	    
	    System.out.println("FechaDeSalida 18/10/2022");
	    wait.until(ExpectedConditions.visibilityOf(DiaDeSalida));
	    DiaDeSalida.click();
	         
	    System.out.println("Click en aplicar");
	    wait.until(ExpectedConditions.visibilityOf(BotonAplicar));
	    BotonAplicar.click();
	         
	    System.out.println("Despliega para buscar habitaciones");
	    wait.until(ExpectedConditions.visibilityOf(Habitaciones));
	    Habitaciones.click();
	        
	    System.out.println("Selecciona 3 adultos");
	    wait.until(ExpectedConditions.visibilityOf(CantidadAdultos));
	    CantidadAdultos.click();
	    
		System.out.println("Selecciona 1 menor");
		wait.until(ExpectedConditions.visibilityOf(Menores));
		Menores.click();   
			
		System.out.println("Despliega Edad del menor");
		wait.until(ExpectedConditions.visibilityOf(EdadMenor));
		EdadMenor.click();
				
		System.out.println("Selecciona la edad");
		wait.until(ExpectedConditions.visibilityOf(eMenor));
		eMenor.click();  
				
		System.out.println("Aplicar Habitaciones");
		wait.until(ExpectedConditions.visibilityOf(AplicarHab));
		AplicarHab.click(); 

		
		System.out.println("Clickea en Buscar");
		wait.until(ExpectedConditions.visibilityOf(Buscar));
		Buscar.click();
		Thread.sleep(3000);
		
		
		System.out.println("Selecciona el Hotel");
		wait.until(ExpectedConditions.visibilityOf(SeleccionarHotel));
		Thread.sleep(2000);
		SeleccionarHotel.click();
		Thread.sleep(3000);
		
		List<WebElement> lista = driver.findElements(By.xpath ("//ul[@class=\"header-autogestion\"]"));
		for (int i = 0; i < lista.size(); i++) {
			WebElement elementoPromo = lista.get(i);
			WebElement ValidarAyuda=elementoPromo.findElement(By.xpath("//*[@class=\"header-autogestion-item \"]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ValidarAyuda);
			Thread.sleep(3000);
			ValidarAyuda.click();
			Thread.sleep(3000);
			System.out.println("Selecciona la pestaña Ayuda");
			Assert.assertTrue(ValidarAyuda.isDisplayed(), "El elemento no es visible");
		
		}
		
    	return new ResultadosPage (this.driver);
    }

}


    
    
    
    
    
    
