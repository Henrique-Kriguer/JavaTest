package br.ce.wcaquino.servicos;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class LocacaoServiceTest2 {

    @Test
    public void test() {
        //cenario
        locacaoService service = new locacaoService();
        Usuario usuario = new Usuario("Usuário 1");
        Filme filme = new Filme("filmeLocado1",2,4.5);


        //ação
        Locacao locacao = service.alugarFilme(usuario, filme);

        //Verificação
        Assert.assertThat(locacao.getValor(), CoreMatchers.<Double>is(4.5));
        Assert.assertThat(DataUtils.isMesmaData(locacao.getDataLocacao(),new Date()),CoreMatchers.is(true));
        Assert.assertThat(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)),CoreMatchers.is(true));

        // os codigos acima podem ser simplificados usando o comando de add import estatico ( add import)
        // não consegui fazer isto funcionar no intellij
    }

}
