package FactoryPattern;

public abstract class PetShop implements OnlinePayment {

    // Agregar metodo de pago (Factory Method)
    protected String tipo, mensaje, ticketmensaje;
    protected Integer cantidad;

    public PetShop() {

    }

    //configuración de metodo de pago y cantidad (Factory Method)
    @Override
    public void configurarPago(String tipo, Integer cantidad) {
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    // Verificaría en una "base de datos" si los datos son correctos y arroja un mensaje (Factory Method)
    @Override
    public boolean generarPago() {
        var recibido = verifBDatos();
        System.out.println(mensaje);
        return recibido;
    }

    @Override
    public void getTicket() {
    }

    protected abstract boolean verifBDatos(); //metodo abstracto que chequea la variable 

    public void setMensajeTicket(String ticketMensaje) {
        this.ticketmensaje = ticketmensaje;
    }

}
