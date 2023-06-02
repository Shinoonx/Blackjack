package Package;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Dealer {

	private String nombre;
	private ArrayList<Jugador> players = new ArrayList<Jugador>();
	private ArrayList<Carta> mazo;
	private ArrayList<Carta> mano = new ArrayList<Carta>();

	public void setPlayers() {
		Scanner keyb = new Scanner(System.in);
		System.out.println("Nombre de Jugador");
		nombre = keyb.nextLine();
		Jugador player = new Jugador(nombre);
		players.add(player);
	}

	public Dealer(String nombre) {
		this.nombre = nombre;
		this.mazo = mazo;
	}

	public void mezclarMazo() {
		Collections.shuffle(mazo);
	}

	public void darCartas() {
		for (int i = 0; i < players.size(); i++) {
			players.get(i).setMano(mazo.get(0));
			mazo.remove(0);
			players.get(i).setMano(mazo.get(0));
			mazo.remove(0);

			players.get(i).setPuntaje();
		}

		Scanner scanner = new Scanner(System.in);
		String respuesta;

		System.out.println("¿Deseas una tercera carta? (s/n)");
		respuesta = scanner.nextLine();

		if (respuesta.equalsIgnoreCase("s")) {
			for (int i = 0; i < players.size(); i++) {
				players.get(i).setMano(mazo.get(0));
				mazo.remove(0);

				players.get(i).setPuntaje();
			}
		}

		mano.add(mazo.get(0));
		mazo.remove(0);
		mano.add(mazo.get(0));
		mazo.remove(0);
		mano.add(mazo.get(0));
		mazo.remove(0);
	}

	public void calcularPuntaje() {
		int puntaje = mano.get(0).getvalor() + mano.get(1).getvalor() + mano.get(2).getvalor();

		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getPuntaje() > 21) {
				System.out.println("El jugador: " + players.get(i).getNombre() + " perdio");
			} else if ((puntaje > 21) && (players.get(i).getPuntaje() <= 21)) {
				System.out.println("El jugador: " + players.get(i).getNombre() + " gano");
			} else if (puntaje < 21 && players.get(i).getPuntaje() < 21 && puntaje > players.get(i).getPuntaje()) {
				System.out.println("El jugador: " + players.get(i).getNombre() + " Perdio");
			} else if (puntaje < 21 && players.get(i).getPuntaje() < 21 && puntaje < players.get(i).getPuntaje()) {
				System.out.println("El jugador: " + players.get(i).getNombre() + " Gano");
			}
		}
	}
}
