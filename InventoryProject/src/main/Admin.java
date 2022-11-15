package main;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class Admin {

    public String nombre;
    public String correo;
    public String contraseña;
    public Integer id;
    public String cargo;

    public Admin() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void listarProductos(File archivo) {
        try {
            //Creamos un archivo FileReader que obtiene lo que tenga el archivo
            FileReader lector = new FileReader("Productos.txt");

            //El contenido de lector se guarda en un BufferedReader
            BufferedReader contenido = new BufferedReader(lector);

            //Con el siguiente ciclo extraemos todo el contenido del objeto "contenido" y lo mostramos
            System.out.println("\n-----\n");
            int n = 1;
            while ((nombre = contenido.readLine()) != null) {
                if (n == 1) {
                    System.out.print("Código: ");
                    n = n + 1;
                    System.out.println(nombre);
                } else if (n == 2) {
                    System.out.print("Nombre: ");
                    n = n + 1;
                    System.out.println(nombre);
                } else if (n == 3) {
                    System.out.print("Precio: ");
                    n = n + 1;
                    System.out.println(nombre);
                } else if (n == 4) {
                    System.out.print("Stock: ");
                    n = n + 1;
                    System.out.println(nombre);
                } else {
                    System.out.print("Fecha de vencimiento: ");
                    n = 1;
                    System.out.println(nombre);
                    System.out.println("\n-----\n");
                }
            }
        } //Si se causa un error al leer cae aqui
        catch (Exception e) {
            System.out.println("Error al leer");
        }
    }

    public void agregarProducto(File archivo, int codigo, String nombre, String precio, int stock, String vencimiento) {
        try {
            //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            FileWriter escribir = new FileWriter(archivo, true);

            //Escribimos en el archivo con el metodo write
            escribir.write(codigo + "\n");
            escribir.write(nombre + "\n");
            escribir.write(precio + "\n");
            escribir.write(stock + "\n");
            escribir.write(vencimiento + "\n");

            //Cerramos la conexion
            escribir.close();
        } //Si se causa un error al leer cae aqui
        catch (Exception e) {
            System.out.println("Error al leer");
        }

    }
}
