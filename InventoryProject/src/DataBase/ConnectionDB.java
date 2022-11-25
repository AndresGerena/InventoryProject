package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class ConnectionDB {

    public Connection con;

    public ConnectionDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/InventoryProject", "root", "");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void pruebaDB() {
        ConnectionDB cn = new ConnectionDB();
        Statement st;
        ResultSet rs;
        try {
            st = cn.con.createStatement();
            rs = st.executeQuery("select * from products");
            while (rs.next()) {
                System.out.println(rs.getDate("DatePurchaseP"));
            }
            cn.con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
