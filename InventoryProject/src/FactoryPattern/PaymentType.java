package FactoryPattern;

public enum PaymentType {

    BANK(new Bank()),
    DAVIPLATA(new Daviplata());

    protected OnlinePayment pago;

    PaymentType(OnlinePayment pago) {
        this.pago = pago;
    }
}
