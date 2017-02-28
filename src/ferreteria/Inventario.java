package ferreteria;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
/**
 *
 * @author Alan Yoset García C
 */
public class Inventario {
  Calendar fecha = new GregorianCalendar();
  Archivo archivo = new Archivo("Inventario.txt"); //Objeto de clase archivo, permite guardar y obtener el arraylist serializado
  ArrayList<Producto> lista; //Para guardar la arraylist obtenida del archivo
  int clave; //permite asignar una clave a cada producto 
  
  Archivo archivoVentas = new Archivo("Ventas.txt");
  ArrayList<Venta> listaVentas; 
  int claveVenta; 
  
  Archivo archivoDetalles = new Archivo("DetalleVenta.txt");
  ArrayList<DetalleVenta> listaDetalles; 
  
  Teclado teclado = new Teclado(); //permite la lectura de entradas por teclado
  
  public Inventario() {
    revalidarLectura();
  }
  
  public void agregar() {
    Producto producto = new Producto();
    producto.setClave("S150" + clave);
    System.out.printf("Nombre: ");
    producto.setNombre(teclado.leerCadena());
    System.out.printf("Descripción: ");
    producto.setDescripcion(teclado.leerCadena());
    System.out.printf("Precio de compra: ");
    producto.setPrecioCompra(teclado.leerDoble());
    System.out.printf("Existencias: ");
    producto.setExistencia(teclado.leerEnteros());
    System.out.printf("Tipo de unidad: ");
    producto.setTipoUnidad(teclado.leerCadena());

    int revision = revisar(producto);
    /*
    *Revisamos si el producto que queremos insertar se encuentra ya registrado
    *si es así entonces tenemos que aumentar las existencias y aplicar la formula
    *para definir el precio de compra
    */
    if (revision != -1) {
      lista.get(revision).setExistencia(lista.get(revision).getExistencia() + producto.getExistencia());
      double formula = lista.get(revision).getExistencia() * lista.get(revision).getPrecioCompra();
      formula += producto.getExistencia() * producto.getPrecioCompra();
      formula = formula / (lista.get(revision).getExistencia());
      lista.get(revision).setPrecioCompra(formula);
      archivo.salida(lista);
      System.out.println("Guardado exitosamente\nSe actualizaron datos del producto existente");
      revalidarLectura();
    } else {
      lista.add(producto);
      archivo.salida(lista);
      System.out.println("Guardado exitosamente \n Clave: S150" + clave);
      revalidarLectura();
    }
  }
  
  public void consultarNombre(){
    if (lista.size() > 0) {
      boolean encontrado = false; 
      
      System.out.println("Ingresa el nombre del producto: ");
      String nombre = teclado.leerCadena();
      
      for (int i = 0; i < lista.size(); i++) {
        if (lista.get(i).getNombre().equals(nombre)) {
          System.out.println(lista.get(i).toString());
          encontrado = true; 
        } 
      }
      if (encontrado != true) {
        System.out.println("No se han encontrado coincidencias");
      }
    } else {
      System.out.println("No hay productos en el inventario");
    }
  }
  
  public void consultarClave(){
    revalidarLectura();
    if (lista.size() > 0) {
      boolean encontrado = false; 

      System.out.println("Ingresa la clave del producto: ");
      String claves = teclado.leerCadena();
      for (int i = 0; i < lista.size(); i++) {
        if (lista.get(i).getClave().equals(claves)) {
          System.out.println(lista.get(i).toString());
          encontrado = true; 
        } 
      }
      if (encontrado != true) {
        System.out.println("No se han encontrado coincidencias");
      }
    } else {
      System.out.println("No hay productos en el inventario");
    }
  }
  
  public void consultarDescripcion(){
    if (lista.size() > 0) {
      boolean encontrado = false; 
      
      System.out.println("Ingresa una caracteristica del articulo: ");
      String descripcion = teclado.leerCadena();
      
      for (int i = 0; i < lista.size(); i++) {
        int contenido = lista.get(i).getDescripcion().indexOf(descripcion);
        if (contenido != -1) {
          System.out.println(lista.get(i).toString());
          encontrado = true; 
        } 
      }
      if (encontrado != true) {
        System.out.println("No se han encontrado coincidencias");
      }
    } else {
      System.out.println("No hay productos en el inventario");
    }
  }
  
  public void editar(){
    if (lista.size() > 0) {
      boolean encontrado = false; 

      System.out.println("Ingresa la clave del producto: ");
      String claves = teclado.leerCadena();
      
      for (int i = 0; i < lista.size(); i++) {
        if (lista.get(i).getNombre().equals(claves)) {
          System.out.println("\tIngresa los datos nuevos");
          System.out.printf("Nombre: ");
          lista.get(i).setNombre(teclado.leerCadena());
          System.out.printf("Descripción: ");
          lista.get(i).setDescripcion(teclado.leerCadena());
          System.out.printf("Precio de compra: ");
          lista.get(i).setPrecioCompra(teclado.leerDoble());
          System.out.printf("Existencias: ");
          lista.get(i).setExistencia(teclado.leerEnteros());
          System.out.printf("Tipo de unidad: ");
          lista.get(i).setTipoUnidad(teclado.leerCadena());
          
          archivo.salida(lista);
          System.out.println("\tActualizado exitosamente");
          encontrado = true; 
          revalidarLectura();
        } 
      }
      if (encontrado != true) {
        System.out.println("No se han encontrado coincidencias");
      }
    } else {
      System.out.println("No hay productos en el inventario");
    }
  }
  
  public void eliminar(){
    if (lista.size() > 0) {
      boolean encontrado = false; 
      
      System.out.println("Ingresa la clave del producto: ");
        String claves = teclado.leerCadena();
      
      for (int i = 0; i < lista.size(); i++) {
        if (lista.get(i).getClave().equals(claves)) {
          lista.remove(i);
          archivo.salida(lista);
          System.out.println("Eliminado con exito");
          encontrado = true; 
          revalidarLectura();
        } 
      }
      if (encontrado != true) {
        System.out.println("No se han encontrado coincidencias");
      }
    } else {
      System.out.println("No hay productos en el inventario");
    }
  }
  /**
   * Hace usa del metodo sort de la clase Collections para ordenar los elementos de la lista en descendente
   * respecto al nombre del articulo, luego recorre la lista e imprime los datos en pantalla
   */
  public void mostrarNombre(){
    Collections.sort(lista, new Comparator<Producto>() {
      @Override
      public int compare(Producto o1, Producto o2) {
        return o1.getNombre().compareTo(o2.getNombre());
      }
    });
    System.out.println("");
    for (int i = 0; i < lista.size(); i++) {
      System.out.printf(lista.get(i).toString());
      System.out.println("");
    }
    
  }
  
  public void mostrarClave(){
    Collections.sort(lista, new Comparator<Producto>() {
      @Override
      public int compare(Producto o1, Producto o2) {
        return o1.getClave().compareTo(o2.getClave());
      }
    });
    System.out.println("");
    for (int i = 0; i < lista.size(); i++) {
      System.out.printf(lista.get(i).toString());
      System.out.println("");
    }
    
  }
  /**
   * Recorre la lista y acumula la multiplicacion del numero de piezas de cada producto por su costo unitario
   */
  public void activosTotales(){
    double activos = 0; 
    if (lista.size() > 0) {
      for (int i = 0; i < lista.size(); i++) {
        activos += (lista.get(i).getPrecioCompra() * lista.get(i).getExistencia());
      }
      System.out.println("Los activos totales son: $"+activos);
    } else {
      System.out.println("No hay productos en el inventario");
    }
  }
  
  public int revisar(Producto p){
    if (lista.size() > 0) {
      for (int i = 0; i < lista.size(); i++) {
        if (p.getNombre() == lista.get(i).getNombre() && p.getDescripcion() == lista.get(i).getDescripcion() 
            && p.getTipoUnidad() == lista.get(i).getTipoUnidad()) {
          return i;
        } 
      }
    } 
    return -1; 
  }
  
  public boolean verificarExistencia(String claves){
    if (lista.size() > 0) {
      for (int i = 0; i < lista.size(); i++) {
        if (lista.get(i).getClave().equals(claves)) {
          return true; 
        } 
      }
      return false; 
    } else {
      return false;
    }
  }
  
  public int devolverPosicion(String clave){
    int pos = 0; 
    for (int i = 0; i < lista.size(); i++) {
      if (lista.get(i).getClave().equals(clave)) {
        pos = i; 
      }
    }
    return pos;
  }
  
  public void venta(){
    Venta venta = new Venta();
    DetalleVenta detalle = new DetalleVenta();
    Producto productoTemp; 
    int salir = 0; 
    String clave;
    int cantidad = 0; 
    double precioVenta; 
    double ivaAcumulado = 0; 
    double totalAcumulado = 0; 
    do{
      precioVenta = 0; 
      System.out.printf("Ingresa clave de producto: ");
      clave = teclado.leerCadena();
      if (verificarExistencia(clave)) {
        productoTemp = (Producto) lista.get(devolverPosicion(clave));
        detalle.setNombreProducto(productoTemp.getNombre());
        System.out.println("Ingresa cantidad: ");
        cantidad = teclado.leerEnteros();
        if (cantidad <= productoTemp.getExistencia()) {
          detalle.setCantidadProducto(cantidad);
          lista.get(devolverPosicion(clave)).setExistencia(lista.get(devolverPosicion(clave)).getExistencia() - cantidad);
          archivo.salida(lista); //ESCRIBIMOS EN EL ARCHIVO LA LISTA CON LA NUEVA CANTIDAD
          productoTemp.setExistencia(cantidad);
          precioVenta = productoTemp.getPrecioCompra(); 
          precioVenta += (precioVenta * .5);
          detalle.setGanancia(precioVenta - productoTemp.getPrecioCompra());
          productoTemp.setPrecioCompra(precioVenta);
          ivaAcumulado += (precioVenta * .16);
          precioVenta = precioVenta * cantidad; //Reciclando esta variable
          totalAcumulado += precioVenta; 
          System.out.println("Subtotal de este articulo: " + precioVenta);
          detalle.setSubtotal(precioVenta);
          detalle.setAnio(fecha.get(Calendar.YEAR));
          detalle.setMes(fecha.get(Calendar.MONTH));
          detalle.setDia(fecha.get(Calendar.DAY_OF_MONTH));
          listaDetalles.add(detalle);
          archivoDetalles.salida(listaDetalles);
          venta.addProducto(productoTemp);
        } else {
          System.out.println("\tExistencias insuficientes");
        }
      } else {
        System.out.println("Producto no registrado");
      }
      System.out.println("Opciones:\n1) agregar otro\n2) Finalizar compra");
      salir = teclado.leerEnteros();
      revalidarLectura();
    } while(salir == 1);
    
    venta.setClave("zVENTA"+claveVenta);
    venta.setIva(ivaAcumulado);
    venta.setSubtotal(totalAcumulado);
    venta.setTotal(totalAcumulado+ivaAcumulado);
    venta.mostrarDetalle();
    
    listaVentas.add(venta);
    archivoVentas.salida(listaVentas);
    
    System.out.println("Venta realizada exitosamente \n Clave: " + venta.getClave());
  }
  
   public void consultarVenta(){
    if (listaVentas.size() > 0) {
      boolean encontrado = false; 

      System.out.println("Ingresa la clave del producto: ");
      String claves = teclado.leerCadena();
      for (int i = 0; i < listaVentas.size(); i++) {
        if (listaVentas.get(i).getClave().equals(claves)) {
          listaVentas.get(i).mostrarDetalle();
          encontrado = true; 
        } 
      }
      if (encontrado != true) {
        System.out.println("No se han encontrado coincidencias");
      }
    } else {
      System.out.println("No hay ventas registradas");
    }
  }
   
  public void revalidarLectura(){
    if (archivo.existencia()) {
      lista = archivo.entrada();
      clave = lista.size();
    } else {
      lista = new ArrayList();
    }
    
    if (archivoVentas.existencia()) {
      listaVentas = archivoVentas.entradaVentas();
      claveVenta = listaVentas.size();
    } else {
      listaVentas = new ArrayList<>();
    }
    
    if (archivoDetalles.existencia()) {
      listaDetalles = archivoDetalles.entradaDetalles();
    } else {
      listaDetalles = new ArrayList<>();
    }
  }
  
  public void listarVentas(){
    Collections.sort(listaVentas, new Comparator<Venta>() {
      @Override
      public int compare(Venta o1, Venta o2) {
        return o1.getClave().compareTo(o2.getClave());
      }
    });
    System.out.println("");
    for (int i = 0; i < listaVentas.size(); i++) {
      System.out.printf(listaVentas.get(i).toString());
      System.out.println("");
    }
    
  }
  
  public void listarDetallesVenta(){
    revalidarLectura();
    System.out.println("");
    for (int i = 0; i < listaDetalles.size(); i++) {
      System.out.printf(listaDetalles.get(i).toString());
      System.out.println("");
    }
  }
  
  public void filtroVentasDia(){
    revalidarLectura();
    System.out.println("Dame la fecha que quieres consultar dd/mm/aaaa");
    String consulta = teclado.leerCadena();
    String fechas; 
    System.out.println("");
    boolean encontrado = false; 
    for (int i = 0; i < listaDetalles.size(); i++) {
      fechas = listaDetalles.get(i).getDia() + "/"+ listaDetalles.get(i).getMes() + "/" + listaDetalles.get(i).getAnio();
      if (fechas.equals(consulta)) {
        System.out.printf(listaDetalles.get(i).toString());
        System.out.println("");
        encontrado = true;
      }
    }
    if (!encontrado) {
      System.out.println("No se encontro registro de ventas en esa fecha");
    }
  }
  
  public void filtroVentasMes(){
    revalidarLectura();
    System.out.println("\t Filtro por mes ");
    System.out.printf("Dame el numero del mes: ");
    int mes = teclado.leerEnteros();
    boolean encontrado = false; 
    
    for (int i = 0; i < listaDetalles.size(); i++) {
      if (listaDetalles.get(i).getMes() == mes) {
        System.out.printf(listaDetalles.get(i).toString());
        System.out.println("");
        encontrado = true;
      }
    }
    if (!encontrado) {
      System.out.println("No se encontro registro de ventas en ese mes");
    }
  }
  
  public void filtroVentasAnio(){
    revalidarLectura();
    System.out.println("\t Filtro anual ");
    System.out.printf("Dame el numero del año: ");
    int anio = teclado.leerEnteros();
    boolean encontrado = false; 
    
    for (int i = 0; i < listaDetalles.size(); i++) {
      if (listaDetalles.get(i).getAnio()== anio) {
        System.out.printf(listaDetalles.get(i).toString());
        System.out.println("");
        encontrado = true;
      }
    }
    if (!encontrado) {
      System.out.println("No se encontro registro de ventas en ese año");
    }
  }
  
  public void gananciaGlobal(){
    revalidarLectura();
    double gananciaGlobal = 0; 
    for (int i = 0; i < listaDetalles.size(); i++) {
      gananciaGlobal += listaDetalles.get(i).getGanancia(); 
    }
    
    System.out.println("La ganancia global a la fecha es: "+gananciaGlobal);
  }
}
