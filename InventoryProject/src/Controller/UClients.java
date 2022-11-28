package Controller;

import DataBase.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class UClients {

    public int IdUC;
    public String NameUC;
    public String LastNameUC;
    public String UserNameUC;
    public String PasswordUC;
    public int PhoneNumberUC;
    public String EmailUC;

    public UClients() {

    }

    public UClients(int IdUC, String NameUC, String LastNameUC, String UserNameUC, String PasswordUC, int PhoneNumberUC, String EmailUC) {
        this.IdUC = IdUC;
        this.NameUC = NameUC;
        this.LastNameUC = LastNameUC;
        this.UserNameUC = UserNameUC;
        this.PasswordUC = PasswordUC;
        this.PhoneNumberUC = PhoneNumberUC;
        this.EmailUC = EmailUC;
    }

    public int getIdUC() {
        return IdUC;
    }

    public void setIdUC(int IdUC) {
        this.IdUC = IdUC;
    }

    public String getNameUC() {
        return NameUC;
    }

    public void setNameUC(String NameUC) {
        this.NameUC = NameUC;
    }

    public String getLastNameUC() {
        return LastNameUC;
    }

    public void setLastNameUC(String LastNameUC) {
        this.LastNameUC = LastNameUC;
    }

    public String getUserNameUC() {
        return UserNameUC;
    }

    public void setUserNameUC(String UserNameUC) {
        this.UserNameUC = UserNameUC;
    }

    public String getPasswordUC() {
        return PasswordUC;
    }

    public void setPasswordUC(String PasswordUC) {
        this.PasswordUC = PasswordUC;
    }

    public int getPhoneNumberUC() {
        return PhoneNumberUC;
    }

    public void setPhoneNumberUC(int PhoneNumberUC) {
        this.PhoneNumberUC = PhoneNumberUC;
    }

    public String getEmailUC() {
        return EmailUC;
    }

    public void setEmailUC(String EmailUC) {
        this.EmailUC = EmailUC;
    }
}
