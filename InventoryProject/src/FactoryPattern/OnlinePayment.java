package FactoryPattern;

public interface OnlinePayment {

    String exitoso = "Pago exitoso";
    String error = "Error en pago, comuniquese con un asesor";

    void configurarPago(String tipo, Integer cantidad);

    boolean generarPago();

    void getTicket();
}
