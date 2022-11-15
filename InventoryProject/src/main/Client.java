package main;

public class Client {

    public String nombre;
    public Integer edad;
    public String correo;
    public Integer nit;

    public Client() {

    }

    public Client(String nombre, Integer edad, String correo, Integer nit) {

        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setcorreo(String correo) {
        this.correo = correo;
    }

    public Integer getNit() {
        return nit;
    }

    public void setNit(Integer nit) {
        this.nit = nit;
    }
    
    //Métodos: Ver lista de productos, agregar al carrito, comprar
    public void listaProductos() {
    }

    public void comprarProducto() {
    }

    public void comprar() {
    }
}
