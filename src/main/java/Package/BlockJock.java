package Package;

import java.util.Scanner;

public class BlockJock {

    public void Jugar() {
        Scanner keyb = new Scanner(System.in);
        System.out.println("Elige el nombre del Dealer:");
        String nombre = keyb.nextLine();

        Dealer dealer = new Dealer(nombre);
        dealer.setPlayers();
        dealer.mezclarMazo();
        dealer.darCartas();
        dealer.calcularPuntaje();
    }
}

