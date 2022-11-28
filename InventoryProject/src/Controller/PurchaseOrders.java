package Controller;

import DataBase.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.Date;

public class PurchaseOrders {

    public int IdO;
    public String CompanyNameC;
    public String NameA;
    public double TotalO;

    ConnectionDB cc = new ConnectionDB();
    Connection con = cc.connection();
}
