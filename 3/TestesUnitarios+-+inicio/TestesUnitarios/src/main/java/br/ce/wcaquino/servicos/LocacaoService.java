package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.utils.DataUtils.adicionarDias;


import java.util.Date;
import java.util.Scanner;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoService {
	
	public Locacao alugarFilme(Usuario usuario, Filme filme) {
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

	public static void main(String[] args) {
	//cenario
		Scanner sc = new Scanner(System.in);
		System.out.print("Usuário: ");
		String nome = sc.nextLine();
		Usuario usuario = new Usuario();
		System.out.print("Filme: ");
		String filmeLocado = sc.nextLine();
		System.out.print("estoque: ");
		Integer qtd = sc.nextInt();
		System.out.println("Preço:");
		Double preco = sc.nextDouble();
		Filme filme = new Filme(filmeLocado,qtd,preco);

		LocacaoService service = new LocacaoService();
	//ação
		Locacao locacao = service.alugarFilme(usuario, filme);

	//Verificação
		System.out.println(locacao.getValor()== 5.0);
		System.out.println(DataUtils.isMesmaData(locacao.getDataLocacao(),new Date()));
		System.out.println(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));

		sc.close();
	}
}