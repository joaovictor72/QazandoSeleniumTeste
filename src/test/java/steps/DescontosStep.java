package steps;


import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import runner.RunCucumberTest;

public class DescontosStep extends RunCucumberTest {

    HomePage homePage = new HomePage(driver);

    @Dado("^que estou na site da qazando$")
    public void que_estou_na_site_da_qazando(){
        homePage.acessarAplicacao();
    }

    @Quando("^eu preencho meu e-mail$")
    public void eu_preencho_meu_e_mail(){
        homePage.preenchoEmail();

    }

    @Quando("^clico em ganhar cupom$")
    public void clico_em_ganhar_cupom(){
        homePage.botaoGerarCupom();
    }

    @Então("^eu vejo o código de desconto$")
    public void eu_vejo_o_código_de_desconto(){
        homePage.verificarCupomDesconto();
    }

    @Dado("^que tenho o cupom gerado$")
    public void gerar_cupom(){
        homePage.acessarAplicacao();
        homePage.preenchoEmail();
        homePage.botaoGerarCupom();
        homePage.verificarCupomDesconto();
    }
}
