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
			puntaje = mano.get(1).getvalor() + puntaje;

		}
	}

	public int getPuntaje() {
		return puntaje;
	}
}

