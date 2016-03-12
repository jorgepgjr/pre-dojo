package br.com.amil.bo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Classe de Teste da Classe {@link Ranking}
 * @author jorge
 *
 */
public class RankingTest{
	
	private Ranking ranking = new Ranking();
	
	@Before
	public void carregaDados(){
		ranking.adicionaKill("MP1");
		ranking.adicionaKill("MP1");
		ranking.adicionaKill("MP1");
		ranking.adicionaKill("MP1");
		ranking.adicionaKill("MP3");
		ranking.adicionaKill("MP3");
		ranking.adicionaKill("MP3");
		ranking.adicionaKill("MP3");
		ranking.adicionaKill("MP3");
		ranking.adicionaDeath();
		ranking.adicionaDeath();
		ranking.adicionaDeath();
	}
	
	@Test
	public void countKillArmaTest(){
		Assert.assertTrue(ranking.getNumeroDeKills("MP3") == 5);
	}
	
	@Test
	public void countKillTest(){
		Assert.assertTrue(ranking.getKills() == 9);
	}
	
	@Test
	public void countDeathTest(){
		Assert.assertTrue(ranking.getDeaths() == 3);
	}
	
	@Test
	public void armaMaisUsadaTest(){
		Assert.assertTrue(ranking.getArmaMaisUsada().getKey().equals("MP3"));
	}
	
	
}
