package br.com.amil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.amil.bo.Partida;
import br.com.amil.entity.Jogador;

public class LoadLog {

	private static final Pattern START = Pattern
			.compile("- New match (\\d*) has started");
	private static final Pattern END = Pattern
			.compile("- Match (\\d*) has ended");
	private static final Pattern MORTE = Pattern
			.compile("- (\\w*) killed (\\w*) using (\\w*)");
	private static final Pattern MUNDO = Pattern
			.compile("- <WORLD> killed (\\w*) (\\w*) (\\w*)");
	private static final SimpleDateFormat SDF = new SimpleDateFormat(
			"dd/MM/yyyy HH:mm:ss");

	/**
	 * Methodo principal do sistema, le arquivo .txt passado por parametro
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Por favor passe uma url de um arquivo de log por parametro");
		} else {			
			final List<Partida> partidas = new ArrayList<Partida>();
			Partida partida = null;
			try {
				// Lendo o arquivo				
				FileReader arq = new FileReader(args[0]);
//				FileReader arq = new FileReader("log.txt");
				BufferedReader lerArq = new BufferedReader(arq);
				String linha = lerArq.readLine();

				while (linha != null) {
					if (!linha.isEmpty()) {

						// Caso queira salvar a data:
						Calendar cal = Calendar.getInstance();
						cal.setTime(SDF.parse(linha.substring(0, 19)));

						Matcher matcherStart = START.matcher(linha
								.substring(20));
						Matcher matcherEnd = END.matcher(linha.substring(20));
						Matcher matcherMorte = MORTE.matcher(linha
								.substring(20));
						Matcher matcherMundo = MUNDO.matcher(linha
								.substring(20));

						// If de morte em primeiro pois provavelmente sera o
						// mais chamado
						if (matcherMorte.find()) {
							partida.adicionaKill(matcherMorte.group(1),
									matcherMorte.group(3));
							partida.adicionaDeath(matcherMorte.group(2));
						} else if (matcherMundo.find()) {
							partida.adicionaDeath(matcherMundo.group(1));
						} else if (matcherStart.find()) {
							partida = new Partida();
							partida.setId(Long.valueOf(matcherStart.group(1)));
						} else if (matcherEnd.find()) {
							partidas.add(partida);
						}
					}
					linha = lerArq.readLine();
				}
				arq.close();
				LoadLog log = new LoadLog();
				log.gerarRanking(partidas);
			} catch (IOException e) {
				System.err.printf("Erro na abertura do arquivo: %s.\n",
						e.getMessage());
			} catch (ParseException e) {
				System.err.printf("Data invalida!");
				e.printStackTrace();
			}
		}
	}

	/**
	 * Joga no console um ranking de jogadores com as armas preferidas de cada
	 * 
	 * @param partidas
	 */
	public void gerarRanking(List<Partida> partidas) {
		for (Partida partida : partidas) {
			System.out.println("Partida de numero: " + partida.getId());
			System.out
					.println("Nome                | Kills| Deaths | Arma Preferida");
			ArrayList<Jogador> b = partida.getJogadores1();
			Collections.sort(b);
			for (Jogador jogador : b) {
				System.out
						.println(jogador.getNome()
								+ "               "
								+ jogador.getRanking().getKills()
								+ "     "
								+ jogador.getRanking().getDeaths()
								+ "    "
								+ (jogador.getArmaMaisUsada() == null ? "Não matou ninguem"
										: jogador.getArmaMaisUsada()));
			}
			System.out.println("");
		}
	}
}
