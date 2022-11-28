package Controller;

import DataBase.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Suppliers {

    public int NitS;
    public String CompanyNameS;
    public String EmailS;
    public long PhoneNumberS;
    public String CityS;
    public String AdressS;

    ConnectionDB cc = new ConnectionDB();
    Connection con = cc.connection();

    public Suppliers() {

    }

    public Suppliers(int NitS, String CompanyNameS, String EmailS, long PhoneNumberS, String CityS, String AdressS) {
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

    public long getPhoneNumberS() {
        return PhoneNumberS;
    }

    public void setPhoneNumberS(long PhoneNumberS) {
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

    public void createSupplier(int nitS, String cnameS, String emailS, long phoneS, String cityS, String adressS) {
        try {
            String SQL = "insert into suppliers (NitS,CompanyNameS,EmailS,PhoneNumberS,CityS,AdressS) values (?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setInt(1, nitS);
            pst.setString(2, cnameS);
            pst.setString(3, emailS);
            pst.setLong(4, phoneS);
            pst.setString(5, cityS);
            pst.setString(6, adressS);
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Registration Error: " + e.getMessage() + "\nNit " + nitS + " Already Exists");
        }
    }

    public void uploadSupplier(int nitS, String cnameS, String emailS, long phoneS, String cityS, String adressS) {
        try {
            String SQL = "update suppliers set CompanyNameS=?,EmailS=?,PhoneNumberS=?,CityS=?,AdressS=? where NitS=?";
            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setString(1, cnameS);
            pst.setString(2, emailS);
            pst.setLong(3, phoneS);
            pst.setString(4, cityS);
            pst.setString(5, adressS);
            pst.setInt(6, nitS);
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Registration Error: " + e.getMessage() + "\nNit " + nitS + " Doesn't Exists");
        }
    }

    public void deleteSupplier(int nitS) {
        try {
            String SQL = "Delete from suppliers where NitS=?";
            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setInt(1, nitS);
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Registration Error: " + e.getMessage() + "\nNit " + nitS + " Doesn't Exists");
        }
    }

    public boolean checkTableDataSuppliers(int nitS) {
        try {
            PreparedStatement pst = con.prepareStatement("Select * from suppliers Where NitS=?");
            pst.setInt(1, nitS);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
}
