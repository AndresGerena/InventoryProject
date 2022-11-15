package main;

public abstract class Brant {

    public String nombmarca; //nombre
    public String caracmarca; //caracteristica
    public Integer cantmarca; // cantidad

    public Brant() {

    }

    public Brant(String nombmarca, String caracmarca, Integer cantmarca) {

        this.nombmarca = nombmarca;
        this.caracmarca = caracmarca;
        this.cantmarca = cantmarca;

    }

    public String getNombreMarca() {
        return nombmarca;
    }

    public void setNombreMarca(String nombmarca) {
        this.nombmarca = nombmarca;
    }

    public String getCaracMarca() {
        return caracmarca;
    }

    public void setCaracMarca(String caracmarca) {
        this.caracmarca = caracmarca;
    }

    public Integer getCantidadMarca() {
        return cantmarca;
    }

    public void setCantidadMarca(Integer cantmarca) {
        this.cantmarca = cantmarca;
    }
}