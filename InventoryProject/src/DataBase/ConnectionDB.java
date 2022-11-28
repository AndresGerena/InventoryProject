package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConnectionDB {

    public Connection connect=null;

    public Connection connection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/inventoryproject","root","");
            System.out.println("Successful Connection!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection Error: "+e.getMessage());
        }
        return connect;
    }
}
