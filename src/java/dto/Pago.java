
package dto;

public class Pago {
    private int idPago;
    private String descripcion;

    public Pago() {
    }

    public Pago(int idPago, String descripcion) {
        this.idPago = idPago;
        this.descripcion = descripcion;
    }
    

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
