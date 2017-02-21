package ferreteria;

public class Ferreteria {

  public static void main(String[] args) {
    MensajesUsuario mu = new MensajesUsuario();
    Teclado teclado = new Teclado();
    int op;

    mu.menuInicial();
    op = teclado.leerEnteros();

    while (op != 1 || op != 2) {
      if (op == 1) {
        do {
          mu.menuInventario();
          op = mu.leerOpcion();
          mu.realizarOpcionInventario(op);
        } while (op != 7);
      } else if (op == 2) {
        do {
          mu.menuVentas();
          op = mu.leerOpcion();
          mu.realizarOpcionVentas(op);
        } while (op != 3);
      } else {
        System.out.println("Saliendo ...");
        break; 
      }
    }
  }
}
