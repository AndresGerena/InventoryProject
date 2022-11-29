package Controller;

import DataBase.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Clients {

    public int NitC;
    public String CompanyNameC;
    public String EmailC;
    public int PhoneNumberC;
    public String CityC;
    public String AdressC;

    ConnectionDB cc = new ConnectionDB();
    Connection con = cc.connection();

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
    
    public void createClient(int nitC, String cnameC, String emailC, long phoneC, String cityC, String adressC) {
        try {
            String SQL = "insert into clients (NitC,CompanyNameC,EmailC,PhoneNumberC,CityC,AdressC) values (?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setInt(1, nitC);
            pst.setString(2, cnameC);
            pst.setString(3, emailC);
            pst.setLong(4, phoneC);
            pst.setString(5, cityC);
            pst.setString(6, adressC);
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Registration Error: " + e.getMessage() + "\nNit " + nitC + " Already Exists");
        }
    }

    public void uploadClient(int nitC, String cnameC, String emailC, long phoneC, String cityC, String adressC) {
        try {
            String SQL = "update clients set CompanyNameC=?,EmailC=?,PhoneNumberC=?,CityC=?,AdressC=? where NitC=?";
            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setString(1, cnameC);
            pst.setString(2, emailC);
            pst.setLong(3, phoneC);
            pst.setString(4, cityC);
            pst.setString(5, adressC);
            pst.setInt(6, nitC);
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Registration Error: " + e.getMessage() + "\nNit " + nitC + " Doesn't Exists");
        }
    }

    public void deleteClient(int nitC) {
        try {
            String SQL = "Delete from clients where NitC=?";
            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setInt(1, nitC);
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Registration Error: " + e.getMessage() + "\nNit " + nitC + " Doesn't Exists");
        }
    }

    public boolean checkTableDataClients(int nitC) {
        try {
            PreparedStatement pst = con.prepareStatement("Select * from clients Where NitC=?");
            pst.setInt(1, nitC);
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
