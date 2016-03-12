package br.com.amil.entity;

import java.util.Map.Entry;

import br.com.amil.bo.Ranking;

/**
 * Guarda informacoes sobre o Jogador, nome e ranking
 * @author jorge
 *
 */
public class Jogador implements Comparable<Jogador>{

	private String nome;
	private Ranking ranking = new Ranking();

	public Jogador(String nome) {
		super();
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogador other = (Jogador) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Ranking getRanking() {
		return ranking;
	}

	public void setRanking(Ranking ranking) {
		this.ranking = ranking;
	}
	
	public void adicionaKill(String arma){
		ranking.adicionaKill(arma);
	}
	public void adicionaDeath(){
		ranking.adicionaDeath();
	}

	public int compareTo(Jogador other) {
		
		if (this.ranking.getKills() < other.getRanking().getKills()) {
			return 1;
		}
		if (this.ranking.getKills() > other.getRanking().getKills()) {
			return -1;
		}
		if (this.ranking.getKills() == other.getRanking().getKills()) {
			return this.ranking.getDeaths() < other.getRanking().getDeaths()? -1 : 1; 
		}
		return 0;
	}
	public String getArmaMaisUsada(){
		Entry<String, Integer> arma = this.ranking.getArmaMaisUsada();
		if (arma != null) {
			return arma.getKey();
		}
		return null;
	}
}
