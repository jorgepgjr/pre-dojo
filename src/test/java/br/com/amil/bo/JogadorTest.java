package br.com.amil.bo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.amil.entity.Jogador;


/**
 * Classe de Teste da Classe {@link Jogador}
 * @author jorge
 *
 */
public class JogadorTest{
	
	private static final String PIOR_JOGADOR = "Erika";
	private static final String MELHOR_JOGADOR = "Jorge";
	private List<Jogador> jogadores = new ArrayList<Jogador>();

	@Before
	public void carregaDados(){
		Jogador jorge = new Jogador(MELHOR_JOGADOR);
		Jogador erika = new Jogador(PIOR_JOGADOR);
		Jogador buddy = new Jogador("Buddy");
		
		jorge.adicionaKill("MP3");
		jorge.adicionaKill("Faca");
		jorge.adicionaKill("MP3");
		jorge.adicionaDeath();
		jorge.adicionaDeath();
		
		erika.adicionaKill("Faca");
		erika.adicionaKill("MP3");
		erika.adicionaDeath();
		
		buddy.adicionaKill("Faca");
		buddy.adicionaKill("Faca");
		buddy.adicionaKill("MP5");
		buddy.adicionaDeath();
		buddy.adicionaDeath();
		buddy.adicionaDeath();
		
		jogadores.add(buddy);
		jogadores.add(erika);
		jogadores.add(jorge);
	}
	
	/**
	 * Testa se o sort de jogadores esta correto
	 */
	@Test
	public void sortTest(){
		Collections.sort(jogadores);
		Assert.assertTrue(MELHOR_JOGADOR.equals(jogadores.get(0).getNome()));
		Assert.assertTrue(PIOR_JOGADOR.equals(jogadores.get(jogadores.size()-1).getNome()));
		
	}
}
