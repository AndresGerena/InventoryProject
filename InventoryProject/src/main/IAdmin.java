package main;

public class IAdmin {

    public int IAdmin;
    public String IUsuario;
    public double saldoInicial;

    public IAdmin(int IAdminu, String IUsuariou, double saldoInicialu) {
        this.IAdmin = IAdminu;
        this.IUsuario = IUsuariou;
        this.saldoInicial = saldoInicialu;
    }

    public int getIAdmin() {
        return IAdmin;
    }

    public void setIAdmin(int IAdminm) {
        this.IAdmin = IAdminm;
    }

    public String getIUsuario() {
        return IUsuario;
    }

    public void setIUsuario(String IUsuariom) {
        this.IUsuario = IUsuariom;
    }

    public double getsaldoInicial() {
        return saldoInicial;
    }

    public void setsaldoInicial(double saldoInicialm) {
        this.saldoInicial = saldoInicialm;
    }
}