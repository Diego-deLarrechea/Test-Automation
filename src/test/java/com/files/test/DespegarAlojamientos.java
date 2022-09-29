package com.files.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import Page_Object.AlojamientosPage;
import Page_Object.ResultadosPage;
import Page_Object.TestBaseDespegar;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;


public class DespegarAlojamientos {
	WebDriver driver = null;
	
		

		  
@BeforeMethod(alwaysRun = true)
 public void Setup(ITestContext context) {
    String NavegadorTestSuite = context.getCurrentXmlTest().getParameter("Navegador");
    String navegador = NavegadorTestSuite != null ? NavegadorTestSuite : "CHROME";
    driver = TestBaseDespegar.iniciodeDriver(navegador);
    TestBaseDespegar.goToMainPage(driver);

    
}
	
	@DataProvider (name= "Pagina Despegar")
	public Object [][] DespegarMethod(){
		return new Object [][] {{"Madrid, Comunidad de Madrid, España"}, {"Lima, Lima, Perú"}, {"Cancún, Quintana Roo, México"}};

}
	
@Test  (groups = {"grupo1"}, dataProvider="Pagina Despegar",description="Validar Despegar")
        public void validarBusquedaDespegar(String text) throws Exception{
	    AlojamientosPage homepage = new AlojamientosPage (driver);
	    ResultadosPage ResultadosPage = homepage.searchText(text);
	    Assert.assertTrue(ResultadosPage.tituloEsVisible(), "El titulo no esta visible");
          
    }   

@AfterMethod
   public void endSetup () {
	driver.quit();
    }

}  



