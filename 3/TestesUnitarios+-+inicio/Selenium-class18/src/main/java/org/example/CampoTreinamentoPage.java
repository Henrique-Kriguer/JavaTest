package org.example;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CampoTreinamentoPage {
    private DSL dsl;
    public CampoTreinamentoPage(WebDriver driver) {
        dsl = new DSL(driver);
    }



    public void setNome(String nome){
        dsl.escreve("elementosForm:nome",nome);
    }

    public void setsugestoes(String sugestao){
        dsl.escreve("elementosForm:sugestoes",sugestao);
    }

    public void setSexoMasculino(){
        dsl.clicarRadio("elementosForm:sexo:0");
    }

    public void setComidaPizza(){
        dsl.clicarRadio("elementosForm:comidaFavorita:0");
    }

    public void setEscolaridade(String valor){
        dsl.selecionaCombo("elementosForm:escolaridade", valor);
    }

    public void setEsportes(String... valores){
        for(String valor: valores)
        dsl.selecionaCombo("elementosForm:esportes", valor);
    }

    public void cadastrar(){
        dsl.clicarBtn("buttonSimple");
    }

    public String obterValorCampoNome(){
        return dsl.obterValor("elementosForm:nome");
       }

    public String obterValorCampoSugestoes(){
        return dsl.obterValor("elementosForm:sugestoes");
    }

    public Boolean RadioBtnSexoMasculinoSelecionado(){
        return dsl.isRadioSelected("elementosForm:sexo:0");
    }

    public Boolean RadioBtnComidaPizzaSelecionada(){
        return dsl.isRadioSelected("elementosForm:comidaFavorita:0");
    }

    public String ObterValorComboEscolaridade(){
        return dsl.obterValorCombo("elementosForm:escolaridade");
    }

}
