package FactoryPattern;

public class Bank extends PetShop {

    private static final String TICKET_MENSAJE = "Ha realizado la transacción con éxito";

    protected Bank() {
        super();
        setMensajeTicket(TICKET_MENSAJE);
    }

    @Override
    protected boolean verifBDatos() {
        switch (tipo) {
            case "355515250616":
                mensaje = "exitoso";
                return true;
            case "S55CGG55G65S":
                mensaje = "exitoso";
                return true;
            default:
                mensaje = "error";
                return false;
        }
        //hola//
    }
}
