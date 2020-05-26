
package dto;

import java.util.List;

public class Compra {
    private int idCompra;
    private int idCliente;
    private int idPago;
    private int idEstado;
    private double montoTotal;
    private String fechaCompra;
    private String nroSerie;
    
    private List<Carrito> detalle;

    public Compra() {
    }

    public Compra( int idCliente, int idPago, int idEstado, double montoTotal, String fechaCompra, String nroSerie, List<Carrito> detallecompras) {
        this.idCliente = idCliente;
        this.idPago = idPago;
        this.idEstado = idEstado;
        this.montoTotal = montoTotal;
        this.fechaCompra = fechaCompra;
        this.nroSerie = nroSerie;
        this.detalle = detalle;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getNroSerie() {
        return nroSerie;
    }

    public void setNroSerie(String nroSerie) {
        this.nroSerie = nroSerie;
    }
    
    public List<Carrito> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<Carrito> detalle) {
        this.detalle = detalle;
    }
    
}
