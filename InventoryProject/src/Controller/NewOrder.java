package Controller;

import DataBase.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.Date;

public class NewOrder {

    public int IdPN;
    public String NamePN;
    public double QuantityN;
    public double PricePN;
    public double TotalN;

    ConnectionDB cc = new ConnectionDB();
    Connection con = cc.connection();
    
    public void createNewOrder(int idP, String nameP, double quantityPO, double priceP, double totalPO) {
        try {
            String SQL = "insert into neworder (IdP,NameP,QuantityPO,PriceP,TotalPO) values (?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setInt(1, idP);
            pst.setString(2, nameP);
            pst.setDouble(3, quantityPO);
            pst.setDouble(4, priceP);
            pst.setDouble(5, totalPO);
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Registration Error: " + e.getMessage());
        }
    }
}
