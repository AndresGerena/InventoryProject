package main;

public class Client {

    public int IdClient;
    public String NameC;
    public String LastNameC;
    public String UserNameC;
    public int PhoneNumberC;
    public String EmailC;

    public Client() {

    }

    public Client(int IdClient, String NameC, String LastNameC, String UserNameC, int PhoneNumberC, String EmailC) {

        this.IdClient = IdClient;
        this.NameC = NameC;
        this.LastNameC = LastNameC;
        this.UserNameC = UserNameC;
        this.PhoneNumberC = PhoneNumberC;
        this.EmailC = EmailC;
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
