package FactoryPattern;

public final class PaymentService {

    private static PaymentService instancia;

    //aplico patrón singleton
    private PaymentService() {
    }

    public static PaymentService getServicioPagoIntancia() {
        instancia = Objects.isNull(instancia) ? new PaymentService() : instancia;
        return instancia;
    }
    public OnlinePayment elejirPago(PaymentType tipoPago) {
        return tipoPago.pago;
    }
}
