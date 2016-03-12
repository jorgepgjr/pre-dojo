package br.com.amil.entity;

import java.util.Calendar;

/**
 * Cada linha do log e um registro. Tipos de registros podem ser:
 * <li>Inico ou Fim de jogo</li>
 * <li>Jogador mata outro jogador</li>
 * <li>O "Mundo" "mata" um jogador</li>
 * 
 * @author jorge
 *
 */
public abstract class Registro {

	private Calendar time;

	public Calendar getTime() {
		return time;
	}

	public void setTime(Calendar time) {
		this.time = time;
	}
}
