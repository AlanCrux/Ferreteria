package ferreteria;
/**
 *
 * @author Alan Yoset García C
 */
public class MensajesUsuario {
  Inventario crud = new Inventario();
  Teclado teclado = new Teclado();
  int seleccionador = 0; 
  
  public void menuInicial(){
    System.out.println("");
    System.out.println("\tFerreteria de la UV");
    System.out.println("1) Gestionar inventario\n2) Gestionar ventas\nTeclea cualquier otro para salir ...");
  }

  /**
   * Muestra el menu al usuario
   */
  public void menuInventario() {
    System.out.println("");
    System.out.println("\tGestión de inventario");
    System.out.println("1) Agregar producto\n2) Consultar producto\n3) Modificar producto\n4) Eliminar producto\n"
        + "5) Mostrar productos\n6) Suma de activos\n7) Salir");
  }
  
  public void menuVentas(){
    System.out.println("");
    System.out.println("\tGestión de ventas");
    System.out.println("1) Nueva venta\n2) Consultar venta\n3) Salir");
  }

  /**
   * Retorna la opción elegida por el usuario
   *
   * @return entero de la opcion elegida
   */
  public int leerOpcion() {
    System.out.println("¿Cual es tu opción?");
    return teclado.leerEnteros();
  }

  /**
   *
   */
  public void realizarOpcionInventario(int op) {
    switch (op) {
      case 1:
        crud.agregar();
        break;
      case 2:
        System.out.println("Consultar por: \n1. Clave\n2. Nombre\n3. Descripcion");
        seleccionador = teclado.leerEnteros();
        switch (seleccionador) {
          case 1:
            crud.consultarClave();
            break;
          case 2:
            crud.consultarNombre();
            break;
          case 3:
            crud.consultarDescripcion();
            break;
          default:
            System.out.println("No es una opción válida");
            break;
        }
        break;
      case 3:
        crud.editar();
        break;
      case 4:
        crud.eliminar();
        break;
      case 5:
        System.out.println("Ordenar por: \n1. Clave\n2. Nombre");
        seleccionador = teclado.leerEnteros();
        switch (seleccionador) {
          case 1:
            crud.mostrarNombre();
            break;
          case 2:
            crud.mostrarClave();
            break;
          default:
            System.out.println("Opcion no válida");
            break;
        }
        break;
      case 6:
        crud.activosTotales();
        break;
      case 7:
        System.out.println("Gracias por participar");
        break;
      default:
        System.out.println("No establecido");
        break;
    }
  }
  
  public void realizarOpcionVentas(int op){
    switch(op){
      case 1:
        crud.venta();
        break;
      case 2:
        crud.consultarVenta();
        break;
      case 3:
        System.out.println("Gracias por participar");
        break;
      default:
        System.out.println("No establecido");
        break;
    }
  }
  
}
