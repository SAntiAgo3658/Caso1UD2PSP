import modelo.Buscador;

public class App {
    public static void main(String[] args) {
        Buscador.rellenarTemp();
        Buscador primero = new Buscador();
        Buscador segundo = new Buscador();
        Buscador tercero = new Buscador();
        Buscador cuarto = new Buscador();
        Buscador quinto = new Buscador();

        primero.start();
        segundo.start();
        tercero.start();
        cuarto.start();
        quinto.start();

        try {
            primero.join();
            segundo.join();
            tercero.join();
            cuarto.join();
            quinto.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());

        }

    }

}
