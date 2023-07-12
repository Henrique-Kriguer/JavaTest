package br.ce.wcaquino.servicos;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.UsuarioVazioException;

import java.util.Date;

import static br.ce.wcaquino.utils.DataUtils.adicionarDias;

public class locacaoService {


	public Locacao alugarFilme(Usuario usuario, Filme filme) throws FilmeSemEstoqueException, UsuarioVazioException {
		if(filme.getEstoque()==0){
			throw new FilmeSemEstoqueException("Filme sem estoque");
		}
		if(usuario==null){
			throw new UsuarioVazioException("Usuário não foi preenchido");

			}
		Locacao locacao = new Locacao();
		locacao.setFilme(filme);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		locacao.setValor(filme.getPrecoLocacao());

		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		locacao.setDataRetorno(dataEntrega);
		
		//Salvando a locacao...	
		//TODO adicionar método para salvar
		
		return locacao;
	}

}