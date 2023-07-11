package br.ce.wcaquino.servicos;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.servicos.locacaoService;
import br.ce.wcaquino.utils.DataUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class locacaoServiceTeste {

    @Test
    public void test() {
        //cenario
        locacaoService service = new locacaoService();
        Usuario usuario = new Usuario("Usuário 1");
        Filme filme = new Filme("filmeLocado1",2,4.5);


        //ação
        Locacao locacao = service.alugarFilme(usuario, filme);

        //Verificação
        Assert.assertTrue(locacao.getValor()== 4.5);
        Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(),new Date()));
        Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));


    }
}
