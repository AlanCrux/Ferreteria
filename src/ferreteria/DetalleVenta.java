package ferreteria;

import java.io.Serializable;

/**
 *
 * @author Alan Yoset García C
 */
public class DetalleVenta implements Serializable{
  String nombreProducto;
  int cantidadProducto;
  double subtotal;
  double ganancia; 
  int anio;
  int mes;
  int dia; 

  public double getGanancia() {
    return ganancia;
  }

  public void setGanancia(double ganancia) {
    this.ganancia = ganancia;
  }

  @Override
  public String toString() {
    return " " + nombreProducto + " | " + cantidadProducto + " | " + subtotal + " | " + ganancia + " | " + dia + "/" + mes + "/" + anio;
  }

  public int getAnio() {
    return anio;
  }

  public void setAnio(int anio) {
    this.anio = anio;
  }

  public int getMes() {
    return mes;
  }

  public void setMes(int mes) {
    this.mes = mes+1;
  }

  public int getDia() {
    return dia;
  }

  public void setDia(int dia) {
    this.dia = dia;
  }

  public String getNombreProducto() {
    return nombreProducto;
  }

  public void setNombreProducto(String nombreProducto) {
    this.nombreProducto = nombreProducto;
  }

  public int getCantidadProducto() {
    return cantidadProducto;
  }

  public void setCantidadProducto(int cantidadProducto) {
    this.cantidadProducto = cantidadProducto;
  }

  public double getSubtotal() {
    return subtotal;
  }

  public void setSubtotal(double subtotal) {
    this.subtotal = subtotal;
  }
  

}
