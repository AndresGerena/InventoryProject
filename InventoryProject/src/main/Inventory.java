package main;

public class Inventory extends Brant {

    public int codigo;
    public String nombre;
    public String precio;
    public Integer stock;
    public String vencimiento;

    //public String fechaCompra;
//////////////////////////////////////////
    public Inventory() {
        super();
    }

    public Inventory(int codigo, String nombre, String precio, Integer stock, String vencimiento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.vencimiento = vencimiento;

    }
///////////////////////////////////////////////////

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
    // //

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
// //

    public String getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
    }
}
