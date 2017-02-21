package ferreteria;

import java.util.Scanner;

/**
 *
 * @author Alan Yoset García C
 * @version 0.1
 */
public class Teclado {

  /**
   * Inicializa nuestro objeto Scanner con la entrada estándar
   */
  Teclado() {
    
  }
  /**
   * Regresa un entero leido desde teclado
   *
   * @return valor de tipo entero
   */
  public int leerEnteros() {
    Scanner sc = new Scanner(System.in);
    return sc.nextInt();
  }

  /**
   * Regresa un doble leído desde teclado
   *
   * @return valor de tipo double
   */
  public double leerDoble() {
    Scanner sc = new Scanner(System.in);
    return sc.nextDouble();
  }

  /**
   * lee una cadena de texto
   * @return string, cadena leída
   */
  public String leerCadena(){
    Scanner sc = new Scanner(System.in);
    return sc.nextLine(); 
  }
}
