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
    System.out.println("1) Gestionar inventario\n2) Gestionar ventas\n3) Salir");
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
    System.out.println("1) Nueva venta\n2) Consultar venta\n3) Listar notas de venta\n4) Listar detalle de ventas"
        + "\n5) Filtrar ventas por dia\n6) Filtrar ventas por periodo\n7) Obtener ganancia global\n8) Salir");
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
            crud.mostrarClave();
            break;
          case 2:
            crud.mostrarNombre();
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
        Ferreteria.menu();
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
        crud.listarVentas();
        break;
      case 4:
        crud.listarDetallesVenta();
        break;
      case 5:
        crud.filtroVentasDia();
        break;
      case 6:
        System.out.println("Filtrar por:\n1) Mes\n2) Año");
        int opcion = teclado.leerEnteros();
        if (opcion == 1) {
          crud.filtroVentasMes();
        } else if (opcion == 2){
          crud.filtroVentasAnio();
        } else {
          System.out.println("No valido");
        }
        break;
      case 7:
        crud.gananciaGlobal();
        break;
      case 8:
        Ferreteria.menu();
        break;
      default:
        System.out.println("No establecido");
        break;
    }
  }
  
}
