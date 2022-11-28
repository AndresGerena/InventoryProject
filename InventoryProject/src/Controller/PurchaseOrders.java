package Controller;

import DataBase.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.Date;

public class PurchaseOrders {

    public int IdPO;
    public String CompanyNameC;
    public String NameA;
    public double TotalN;

    ConnectionDB cc = new ConnectionDB();
    Connection con = cc.connection();
}
