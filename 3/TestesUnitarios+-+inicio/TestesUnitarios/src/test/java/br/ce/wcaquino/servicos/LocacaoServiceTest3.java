package br.ce.wcaquino.servicos;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import java.util.Date;

public class LocacaoServiceTest3 {

    @Rule
    public ErrorCollector error = new ErrorCollector();
    @Test
    public void test() {
        //cenario
        locacaoService service = new locacaoService();
        Usuario usuario = new Usuario("Usuário 1");
        Filme filme = new Filme("filmeLocado1",2,4.5);


        //ação
    //    Locacao locacao = service.alugarFilme(usuario, filme);

        //Verificação
   //    error.checkThat(locacao.getValor(), CoreMatchers.is( 4.0));
   //    error.checkThat(DataUtils.isMesmaData(locacao.getDataLocacao(),new Date()),CoreMatchers.is(true));
   //    error.checkThat(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)),CoreMatchers.is(false));


    }

}
