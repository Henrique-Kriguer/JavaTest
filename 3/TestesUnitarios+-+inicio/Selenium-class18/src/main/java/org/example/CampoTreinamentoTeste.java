
package org.example;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.function.BooleanSupplier;

public class CampoTreinamentoTeste {

    private static WebDriver driver = new EdgeDriver();
    private static DSL dsl;

    private static CampoTreinamentoPage page;

    @BeforeAll
    public static void inicializa(){
        dsl = new DSL(driver);
        System.setProperty("web-driver.msedgedriver","C:/Learning/Selenium-Java/edgedriver_win64/msedgedriver.exe");
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        page = new CampoTreinamentoPage(driver);
    }
    @AfterAll
    public static void finaliza(){
        driver.quit();
    }
      @Test
    public void testeTextField() {
        page.setNome( "Teste de escrita");
        Assertions.assertEquals("Teste de escrita", page.obterValorCampoNome());
    }

    @Test
    public void testeTextArea() {
       page.setsugestoes("Teste de escrita 2");
       Assertions.assertEquals("Teste de escrita 2", page.obterValorCampoSugestoes());
    }

    @Test
    public void testeRadioButtonn() {
        page.setSexoMasculino();
        Assertions.assertTrue(page.RadioBtnSexoMasculinoSelecionado());
    }

    @Test
    public void testeCheckBox() {
        page.setComidaPizza();
        Assertions.assertEquals(true, page.RadioBtnComidaPizzaSelecionada());
    }

    @Test
    public void testeComboBox() {
        page.setEscolaridade("Superior");
        Assertions.assertEquals("Superior", page.ObterValorComboEscolaridade());
    }

    @Test
    public void testeComboBoxMultiplo() {
        page.setEsportes("Natacao","Corrida","Futebol");
        WebElement element = driver.findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element);
        List<WebElement> allSellectedOptions = combo.getAllSelectedOptions();
        Assertions.assertEquals(3, allSellectedOptions.size());
        combo.deselectAll(); // esta opção desmarcados itens marcados anteriormente.
    }

    @Test
    public void testeBtnObrigado() {

        WebElement botao = driver.findElement(By.id("buttonSimple"));
        Assertions.assertEquals("Clique Me!",botao.getAttribute("value"));
        page.cadastrar();
        botao = driver.findElement(By.id("buttonSimple"));
        Assertions.assertEquals("Obrigado!",botao.getAttribute("value"));
    }

    @Test
    //@Ignore // esta anotação não funciona, permite pular o teste em uma bateria de testes, mostrando a msg skipped
    public void testeLink() {
        dsl.clicarLink("Voltar");
        Assertions.assertEquals("Voltou!", dsl.obterTexto("resultado"));
    }
    @Test
    public void testeTextoPagina() {
        //Assertions.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
        // Este metodo acima é ineficaz pois o java tem que varrer todo body para encontrar o elemento.
        // Caso a tag h3 tivesse mais de uma ocorrencia, o teste daria erro pois ele vai no primeiro tag que encontrar.
        Assertions.assertTrue(dsl.obterTextoTag("h3").contains("Campo de Treinamento"));
        Assertions.assertTrue(dsl.obterTextoClass("facilAchar").contains("Cuidado onde clica, muitas armadilhas..."));
    }
}

