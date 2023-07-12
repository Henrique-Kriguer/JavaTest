package br.ce.wcaquino.servicos;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.UsuarioVazioException;
import br.ce.wcaquino.servicos.locacaoService;
import br.ce.wcaquino.utils.DataUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class locacaoServiceTeste {

    @Test
    public void test() throws Exception {
        //cenario
        locacaoService service = new locacaoService();
        Usuario usuario = new Usuario(null);
        Filme filme = new Filme("filmeLocado1",0,4.0);


        //ação
        Locacao locacao= service.alugarFilme(usuario, filme);
            //Verificação
            Assert.assertTrue(locacao.getValor()== 4.0);
            Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(),new Date()));
            Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));


    }

    @Test
    public void testeLocacaoUsuarioVazio() throws FilmeSemEstoqueException{
        //cenario
        locacaoService service = new locacaoService();
        Filme filme = new Filme("filmeLocado1",1,4.0);


        //ação
        try {
            service.alugarFilme(null, filme);
        }catch (UsuarioVazioException e){
               e.printStackTrace();
        }
        //Verificação

    }
}
