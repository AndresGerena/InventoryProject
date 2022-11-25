package Controller;

public class Clients {

    public int NitC;
    public String CompanyNameC;
    public String EmailC;
    public int PhoneNumberC;
    public String CityC;
    public String AdressC;

    public Clients() {

    }

    public Clients(int NitC, String CompanyNameC, String EmailC, int PhoneNumberC, String CityC, String AdressC) {
        this.NitC = NitC;
        this.CompanyNameC = CompanyNameC;
        this.EmailC = EmailC;
        this.PhoneNumberC = PhoneNumberC;
        this.CityC = CityC;
        this.AdressC = AdressC;
    }

    public int getNitC() {
        return NitC;
    }

    public void setNitC(int NitC) {
        this.NitC = NitC;
    }

    public String getCompanyNameC() {
        return CompanyNameC;
    }

    public void setCompanyNameC(String CompanyNameC) {
        this.CompanyNameC = CompanyNameC;
    }

    public String getEmailC() {
        return EmailC;
    }

    public void setEmailC(String EmailC) {
        this.EmailC = EmailC;
    }

    public int getPhoneNumberC() {
        return PhoneNumberC;
    }

    public void setPhoneNumberC(int PhoneNumberC) {
        this.PhoneNumberC = PhoneNumberC;
    }

    public String getCityC() {
        return CityC;
    }

    public void setCityC(String CityC) {
        this.CityC = CityC;
    }

    public String getAdressC() {
        return AdressC;
    }

    public void setAdressC(String AdressC) {
        this.AdressC = AdressC;
    }
}
