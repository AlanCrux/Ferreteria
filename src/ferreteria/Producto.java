package ferreteria;
import java.io.Serializable;

/**
 *Se implementa la interfaz serializable para poder serializar objetos de este tipo en archivos
 * @author Alan Yoset García C
 */
public class Producto implements Serializable {
  private String clave; 
  private String nombre;
  private String descripcion; 
  private double precioCompra;
  private int existencia;
  private String tipoUnidad; 

  @Override
  public String toString() {
    return "Clave: "+clave+" | Nombre: "+nombre+" | Desc: "+descripcion+" | $: "+precioCompra+" | exist: "
        +existencia+" | Unidad: "+tipoUnidad;
  }
  
  public void setClave(String clave) {
    this.clave = clave;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public void setPrecioCompra(double precioCompra) {
    this.precioCompra = precioCompra;
  }

  public void setExistencia(int existencia) {
    this.existencia = existencia;
  }

  public void setTipoUnidad(String tipoUnidad) {
    this.tipoUnidad = tipoUnidad;
  }

  public String getClave() {
    return clave;
  }

  public String getNombre() {
    return nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public double getPrecioCompra() {
    return precioCompra;
  }

  public int getExistencia() {
    return existencia;
  }

  public String getTipoUnidad() {
    return tipoUnidad;
  }
  
  public boolean disminuir(int cantidad){
    if (existencia-cantidad >= 0) {
      existencia -= cantidad;
      return true;
    } else {
      return false; 
    }
  }
 
}
