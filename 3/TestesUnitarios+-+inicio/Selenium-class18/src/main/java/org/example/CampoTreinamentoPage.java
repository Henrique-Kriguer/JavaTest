package org.example;

import org.openqa.selenium.WebDriver;

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

    public void setEsportes(String valor){
        dsl.selecionaCombo("elementosForm:esportes", valor);
    }

    public void cadastrar(){
        dsl.clicarBtn("buttonSimple");
    }
}
