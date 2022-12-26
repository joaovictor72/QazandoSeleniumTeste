package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.Utils;

public class HomePage extends Utils {

    WebDriver driver;

    By email = By.id("email");
    By botaoCupom = By.id("button");
    By textoDesconto = By.cssSelector("#cupom > h2 > span");

    By botaoVerCursos = By.id("btn-ver-cursos");
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void acessarAplicacao(){
        driver.manage().window().maximize();
        driver.get("https://qazando.com.br/curso.html");
        esperarElementoEstarPresente(botaoVerCursos, 10);
        Assert.assertEquals("Não acessou a aplicação",true, driver.findElement(botaoVerCursos).isDisplayed());
    }

    public void preenchoEmail() {
        driver.findElement(email).sendKeys("superteste735@gmail.com");;
    }

    public void botaoGerarCupom(){
        driver.findElement(botaoCupom).click();
    }

    public void verificarCupomDesconto(){
        String texto_cupom = driver.findElement(textoDesconto).getText();
        Assert.assertEquals("O cupom está errado!", "QAZANDO15OFF", texto_cupom);
    }
}
