package FactoryPattern;

public class Daviplata extends PetShop {

    private static final String TICKET_MENSAJE = "Ha realizado la transacción con éxito";

    protected Daviplata() {
        super();
        setMensajeTicket(TICKET_MENSAJE);
    }

    @Override
    protected boolean verifBDatos() {
        switch (tipo) {
            case "3555-1525-0616":
                mensaje = "exitoso";
                return true;
            case "S55C-GG55-G65S":
                mensaje = "exitoso";
                return true;
            default:
                mensaje = "error";
                return false;
        }
    }
}
