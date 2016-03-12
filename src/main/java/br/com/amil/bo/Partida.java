package br.com.amil.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.amil.entity.Jogador;
import br.com.amil.entity.Registro;

public class Partida {

	private long id;

	/**
	 * Nao foi usado, apenas se for fazer o bonus
	 */
	private List<Registro> registros;	
	private ArrayList<Jogador> jogadores;

	public Partida() {
		super();
		jogadores = new ArrayList<Jogador>();
	}

	public void addRegistro(Registro registro) {
		if (registros == null) {
			registros = new ArrayList<Registro>();
		}
		registros.add(registro);
	};

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Registro> getRegistros() {
		return registros;
	}

	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}
	
	public ArrayList<Jogador> getJogadores1() {
		return jogadores;
	}

	public void setJogadores1(ArrayList<Jogador> jogadores1) {
		this.jogadores = jogadores1;
	}

	/**
	 * Adiciona um assassinato ao jogador junto com a arma usada para isso
	 * @param jogador
	 * @param arma
	 */
	public void adicionaKill(String jogador, String arma) {
		Jogador encontrado = null;
		for (Jogador jogador2 : jogadores) {
			if (jogador2.getNome().equals(jogador)) {
				encontrado = jogador2;
			}
		}
		
		if (encontrado != null) {
			encontrado.adicionaKill(arma);
		} else {
			encontrado = new Jogador(jogador);
			encontrado.adicionaKill(arma);
			jogadores.add(encontrado);
		}
	}

	public void adicionaDeath(String jogador) {
		Jogador encontrado = null;
		for (Jogador jogador2 : jogadores) {
			if (jogador2.getNome().equals(jogador)) {
				encontrado = jogador2;
			}
		}
		
		if (encontrado != null) {
			encontrado.adicionaDeath();
		} else {
			encontrado = new Jogador(jogador);
			encontrado.adicionaDeath();
			jogadores.add(encontrado);
		}
	}
}
