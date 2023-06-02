package Package;
import java.util.ArrayList;
public class Jugador {

	private int puntaje;
	private ArrayList<Carta> mano = new ArrayList<Carta>();
	private String nombre;


	public void setMano(Carta carta) {
		mano.add(carta);
	}

	public Jugador(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setPuntaje() {
		for (int i = 0; i < mano.size(); i++) {
			puntaje = puntaje + mano.get(1).getvalor();

		}
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void imprimirMano() {
		System.out.println("Mano de " + nombre + ":");
		for (Carta carta : mano) {
			System.out.println(carta.getvalor() + " de " + carta.getsymb());
		}
	}
}

