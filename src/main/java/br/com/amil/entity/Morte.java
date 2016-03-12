package br.com.amil.entity;

public class Morte extends Registro{

	private Jogador assasino;
	private Jogador vitima;
	private String arma;
	
	public Morte(Jogador assasino, Jogador vitima, String arma) {
		super();
		this.assasino = assasino;
		this.vitima = vitima;
		this.arma = arma;
	}
	public Jogador getAssasino() {
		return assasino;
	}
	public void setAssasino(Jogador assasino) {
		this.assasino = assasino;
	}
	public Jogador getVitima() {
		return vitima;
	}
	public void setVitima(Jogador vitima) {
		this.vitima = vitima;
	}
	public String getArma() {
		return arma;
	}
	public void setArma(String arma) {
		this.arma = arma;
	}
}
