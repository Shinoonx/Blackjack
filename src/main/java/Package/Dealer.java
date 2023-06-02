package Package;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Dealer {

	private String nombre;
	private ArrayList<Jugador> players = new ArrayList<Jugador>();
	private ArrayList<Carta> mazo = new ArrayList<Carta>();
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
	}

	public void CrearMazito() {
		Mazo mazito = new Mazo();
		mazito.Mazo();
		mazo = mazito.getCarta();
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
			players.get(i).setMano(mazo.get(0));
			mazo.remove(0);

			players.get(i).setPuntaje();
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
				System.out.println("El jugador: " + players.get(i).getNombre() + " Perdio, hermano aprenda a contar");
			} else if ((puntaje > 21) && (players.get(i).getPuntaje() <= 21)) {
				System.out.println("El jugador: " + players.get(i).getNombre() + " Gano, HERMANO FELICIDADES PUEDES DEJAR LA CARRERA");
			} else if (puntaje < 21 && players.get(i).getPuntaje() < 21 && puntaje > players.get(i).getPuntaje()) {
				System.out.println("El jugador: " + players.get(i).getNombre() + " Perdio, hermano como te gana el dealer wn ta to v0la0 y con cuea sabe contar");
			} else if (puntaje < 21 && players.get(i).getPuntaje() < 21 && puntaje < players.get(i).getPuntaje()) {
				System.out.println("El jugador: " + players.get(i).getNombre() + " Gano, HERMANO FELICIDADES PUEDES DEJAR LA CARRERA");
			}else  if (puntaje < 21 && players.get(i).getPuntaje() < 21 && puntaje == players.get(i).getPuntaje()) {
				System.out.println("El jugador: " + players.get(i).getNombre() + "Empate, Los 2 igual de gile");
			}

		}
	}
	public void imprimirMano() {
		System.out.println("Mano del Dealer:");
		for (Carta carta : mano) {
			System.out.println( carta.getvalor()+ " de " + carta.getsymb());
		}
	}
	public void imprimirManoJugador() {
		for (Jugador jugador : players) {
			jugador.imprimirMano();
		}
	}
}
