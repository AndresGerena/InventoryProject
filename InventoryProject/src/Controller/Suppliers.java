package Controller;

import DataBase.ConnectionDB;
import java.sql.ResultSet;
import java.sql.Statement;

public class Suppliers {

    public int NitS;
    public String CompanyNameS;
    public String EmailS;
    public int PhoneNumberS;
    public String CityS;
    public String AdressS;

    public Suppliers() {

    }

    public Suppliers(int NitS, String CompanyNameS, String EmailS, int PhoneNumberS, String CityS, String AdressS) {
        this.NitS = NitS;
        this.CompanyNameS = CompanyNameS;
        this.EmailS = EmailS;
        this.PhoneNumberS = PhoneNumberS;
        this.CityS = CityS;
        this.AdressS = AdressS;
    }

    public int getNitS() {
        return NitS;
    }

    public void setNitS(int NitS) {
        this.NitS = NitS;
    }

    public String getCompanyNameS() {
        return CompanyNameS;
    }

    public void setCompanyNameS(String CompanyNameS) {
        this.CompanyNameS = CompanyNameS;
    }

    public String getEmailS() {
        return EmailS;
    }

    public void setEmailS(String EmailS) {
        this.EmailS = EmailS;
    }

    public int getPhoneNumberS() {
        return PhoneNumberS;
    }

    public void setPhoneNumberS(int PhoneNumberS) {
        this.PhoneNumberS = PhoneNumberS;
    }

    public String getCityS() {
        return CityS;
    }

    public void setCityS(String CityS) {
        this.CityS = CityS;
    }

    public String getAdressS() {
        return AdressS;
    }

    public void setAdressS(String AdressS) {
        this.AdressS = AdressS;
    }

    public void createSupplier() {

    }

    public void readSupplier() { //Intentar conectar a la DB
//        ConnectionDB cn=new ConnectionDB();
//        Statement st;
//        ResultSet rs;
//        try {
//            st=cn.con.createStatement();
//            rs=st.executeQuery("select * from client");
//            while (rs.next()) {                
//                System.out.println(rs.getInt("IdClient"));
//            }
//            cn.con.close();
//        } catch (Exception e) {
//            System.out.println("Error: "+e);
//        }

    }

    public void uploadSupplier() {

    }

    public void deleteSupplier() {

    }
}
