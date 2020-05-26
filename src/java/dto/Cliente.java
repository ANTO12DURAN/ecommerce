
package dto;

public class Cliente {
    private int idCliente; //autoincrementable
    private String nombre;
    private String apellido;
    private String correo; //unique
    private String clave;
    private String status;
    private String telefono;
    private String direccion;

    public Cliente() {
    }
    
    public Cliente(String nombre, String apellido, String correo, String clave, String status, String telefono, String direccion) {
       
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.clave = clave;
        this.status = status;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    public Cliente( String correo, String clave) {
        this.correo = correo;
        this.clave = clave;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    

}
