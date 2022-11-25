package Controller;

import java.sql.Date;

public class Products {

    public int IdP;
    public String NameP;
    public double WheightP;
    public int StockP;
    public Date DatePurchaseP; //Pasar a String
    public Date ExpirationDateP;
    public double PriceP;

    public Products() {

    }

    public Products(int IdP, String NameP, double WheightP, int StockP, Date DatePurchaseP, Date ExpirationDateP, double PriceP) {
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

    public Date getDatePurchaseP() {
        return DatePurchaseP;
    }

    public void setDatePurchaseP(Date DatePurchaseP) {
        this.DatePurchaseP = DatePurchaseP;
    }

    public Date getExpirationDateP() {
        return ExpirationDateP;
    }

    public void setExpirationDateP(Date ExpirationDateP) {
        this.ExpirationDateP = ExpirationDateP;
    }

    public double getPriceP() {
        return PriceP;
    }

    public void setPriceP(double PriceP) {
        this.PriceP = PriceP;
    }
}
