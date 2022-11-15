package FactoryPattern;

public class FactoryPattern {

    private OnlinePayment pago;
    private final PaymentService servicio;

    public FactoryPattern() {
        servicio = PaymentService.getServicioPagoIntancia();

        pago = servicio.elejirPago(PaymentType.BANK);
        pago.configurarPago("355515250616", 500000);
        if (pago.generarPago()) {
            pago.getTicket();
        }

        // pago = servicio.elejirPago(TipoPago.DAVIPLATA);
        // pago.configurarPago("S55C-GG55-", 15000);
        // if (pago.generarPago()) pago.getTicket();
    }

    public static void main(String[] args) {
        new FactoryPattern();
    }
}
