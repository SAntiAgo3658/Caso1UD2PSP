package modelo;

import java.util.Random;

public class Buscador extends Thread {

    private static final int totalTemp = 3650;
    private static int[] temperaturas = new int[totalTemp];
    private int[] tempAsig;
    private static int cont = 0;
    private static boolean relleno = false;
    private static int posicion = 0;
    private String nombre;

    public Buscador() {

        if ((cont < 5) && relleno) {
            tempAsig = new int[730];
            cont++;
            nombre = "el " + cont;

        } else if (!relleno) {
            System.out.println("Temperaturas no introducidas");

        } else {
            System.out.println("Máximo número de buscadores alcanzado");

        }

    }

    @Override
    public void run() {

        for (int i = 0; i < tempAsig.length; i++) {
            tempAsig[i] = temperaturas[posicion];
            posicion++;

        }

        System.out.println(nombre + " " + tempMax(tempAsig));

    }

    public static boolean rellenarTemp() {

        if (!relleno) {
            Random aleatorio = new Random();

            for (int i = 0; i < totalTemp; i++) {
                temperaturas[i] = aleatorio.nextInt(-30, 50);

            }

            relleno = true;
            return true;

        } else {
            return false;
        }

    }

    public int tempMax(int[] tempAsig) {
        int numeroMayor = -100;
        for (int i = 0; i < tempAsig.length; i++) {
            if (numeroMayor < tempAsig[i]) {
                numeroMayor = tempAsig[i];

            }
        }

        return numeroMayor;
    }

}
