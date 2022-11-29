package Controller;

import DataBase.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Products {

    public int IdP;
    public String NameP;
    public double WheightP;
    public int StockP;
    public String DatePurchaseP;
    public String ExpirationDateP;
    public double PriceP;

    ConnectionDB cc = new ConnectionDB();
    Connection con = cc.connection();

    public Products() {

    }

    public Products(int IdP, String NameP, double WheightP, int StockP, String DatePurchaseP, String ExpirationDateP, double PriceP) {
        this.IdP = IdP;
        this.NameP = NameP;
        this.WheightP = WheightP;
        this.StockP = StockP;
        this.DatePurchaseP = DatePurchaseP;
        this.ExpirationDateP = ExpirationDateP;
        this.PriceP = PriceP;
    }

    public int getIdP() {
        return IdP;
    }

    public void setIdP(int IdP) {
        this.IdP = IdP;
    }

    public String getNameP() {
        return NameP;
    }

    public void setNameP(String NameP) {
        this.NameP = NameP;
    }

    public double getWheightP() {
        return WheightP;
    }

    public void setWheightP(double WheightP) {
        this.WheightP = WheightP;
    }

    public int getStockP() {
        return StockP;
    }

    public void setStockP(int StockP) {
        this.StockP = StockP;
    }

    public String getDatePurchaseP() {
        return DatePurchaseP;
    }

    public void setDatePurchaseP(String DatePurchaseP) {
        this.DatePurchaseP = DatePurchaseP;
    }

    public String getExpirationDateP() {
        return ExpirationDateP;
    }

    public void setExpirationDateP(String ExpirationDateP) {
        this.ExpirationDateP = ExpirationDateP;
    }

    public double getPriceP() {
        return PriceP;
    }

    public void setPriceP(double PriceP) {
        this.PriceP = PriceP;
    }
    
    public void createProduct(int idP, String nameP, double wheightP, int stockP, String purchaseP, String expirationP, double priceP) {
        try {
            String SQL = "insert into products (IdP,NameP,WheightP,StockP,DatePurchaseP,ExpirationDateP,PriceP) values (?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setInt(1, idP);
            pst.setString(2, nameP);
            pst.setDouble(3, wheightP);
            pst.setInt(4, stockP);
            pst.setString(5, purchaseP);
            pst.setString(6, expirationP);
            pst.setDouble(7, priceP);
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Registration Error: " + e.getMessage() + "\nId " + idP + " Already Exists");
        }
    }

    public void uploadProduct(int idP, String nameP, double wheightP, int stockP, String purchaseP, String expirationP, double priceP) {
        try {
            String SQL = "update products set NameP=?,WheightP=?,StockP=?,DatePurchaseP=?,ExpirationDateP=?,PriceP=? where IdP=?";
            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setString(1, nameP);
            pst.setDouble(2, wheightP);
            pst.setInt(3, stockP);
            pst.setString(4, purchaseP);
            pst.setString(5, expirationP);
            pst.setDouble(6, priceP);
            pst.setInt(7, idP);
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Registration Error: " + e.getMessage() + "\nId " + idP + " Doesn't Exists");
        }
    }

    public void deleteProduct(int idP) {
        try {
            String SQL = "Delete from products where IdP=?";
            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setInt(1, idP);
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Registration Error: " + e.getMessage() + "\nId " + idP + " Doesn't Exists");
        }
    }

    public boolean checkTableDataProducts(int idP) {
        try {
            PreparedStatement pst = con.prepareStatement("Select * from products Where IdP=?");
            pst.setInt(1, idP);
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
