package Page_Object;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ResultadosPage {
	@FindBy (linkText="Alojamientos")
	WebElement Alojamientos;
    @FindBy(css=".sbox5-box-places-ovr input")
    WebElement Destino;
    WebDriverWait wait = null;

    public ResultadosPage (WebDriver driver) {
        PageFactory.initElements(driver, this);

    }
    
	public boolean tituloEsVisible() {
        return this.Destino.isDisplayed();

    }

}

	
