package br.com.amil.bo;

import java.util.HashMap;
import java.util.Map.Entry;

public class Ranking{

	private int kills;
	private int deaths;
	private HashMap<String,Integer> armas;
	
	
	public Ranking() {
		super();
		armas = new HashMap<String, Integer>();
	}

	public void adicionaKill(String arma) {
		this.kills++;
		if (armas == null) {
			armas = new HashMap<String, Integer>();
		}
		Integer a = armas.get(arma);
		if (a == null) {
			armas.put(arma, 1);
		}else {
			armas.put(arma, a+1);
		}
	}

	public void adicionaDeath() {
		this.deaths++;
	}

	public int getKills() {
		return kills;
	}

	public int getDeaths() {
		return deaths;
	}

	public HashMap<String, Integer> getArmas() {
		return armas;
	}
	public Integer getNumeroDeKills(String arma){
		if (this.armas.get(arma) == null) {
			return 0;
		}
		return this.armas.get(arma);
	}

	public Entry<String, Integer> getArmaMaisUsada() {
		Entry<String,Integer> maxEntry = null;
		for(Entry<String,Integer> entry : armas.entrySet()) {
			if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
		        maxEntry = entry;
		    }
		}
		return maxEntry;
	}

}
