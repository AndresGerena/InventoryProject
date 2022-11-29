package Interfaces;

import Controller.Clients;
import Controller.NewOrder;
import Controller.Products;
import Controller.PurchaseOrders;
import Controller.Suppliers;
import Images.Escala;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


import java.sql.Date;

import DataBase.ConnectionDB;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Home extends javax.swing.JFrame {
    
    
    public Home() {
        initComponents();
        this.setLocationRelativeTo(null);
        //chk();
        escala.escalarLabel(logo, "/Images/perrologin-2.png");
        escala.escalarLabel(UserIcon, "/Images/usuario-icon.png");
        escala.escalarLabel(ExitIcon, "/Images/cerrarsesion.png");
        escala.escalarLabel(LoupeClients, "/Images/lupita.png");
        escala.escalarLabel(LoupeS, "/Images/lupita.png");
        escala.escalarLabel(LoupeP, "/Images/lupita.png");
        escala.escalarLabel(LoupeN, "/Images/lupita.png");
        escala.escalarLabel(CartN, "/Images/carritocompras.png");
        escala.escalarLabel(LoupePo, "/Images/lupita.png");
        
        showJTableSuppliers();
        showJTableClients();
        showJTableProducts();
        showJTableNewOrder();
        showJTablePurchaseOrders();
    }
    
    Escala escala = new Escala();
    
    Timer t;
    
    ConnectionDB cc = new ConnectionDB();
    Connection con = cc.connection();

    //---Clients---//
    Clients c = new Clients();
    int nitC = 0;
    long phoneC = 0;
    String cnameC = "", emailC = "", cityC = "", adressC = "";

    //---Suppliers---//
    Suppliers s = new Suppliers();
    int nitS = 0;
    long phoneS = 0;
    String cnameS = "", emailS = "", cityS = "", adressS = "";

    //---Products---//
    Products p = new Products();
    int idP = 0, stockP = 0;
    double wheightP = 0, priceP = 0;
    String nameP = "", purchaseP="", expirationP="";

    //---NewOrder---//
    NewOrder n = new NewOrder();
    int IdPN = 0;
    String NamePN = "";
    public double QuantityN = 0, PricePN = 0, TotalN = 0;

    //---PurchaseOrders---//
    PurchaseOrders po = new PurchaseOrders();
    int CodePO = 0;
    String CompanyNameCPO = "", NameAPO = "";
    double TotalNPO = 0;

    public void showJTableClients() {
        try {
            DefaultTableModel mod = new DefaultTableModel();
            jTableClients.setModel(mod);

            String SQL = "select * from clients";
            PreparedStatement pst = con.prepareStatement(SQL);

            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            int cantColums = rsmd.getColumnCount();

            mod.addColumn("NIT");
            mod.addColumn("COMPANY");
            mod.addColumn("EMAIL");
            mod.addColumn("PHONE");
            mod.addColumn("CITY");
            mod.addColumn("ADRESS");

            while (rs.next()) {
                Object[] filas = new Object[cantColums];
                for (int i = 0; i < cantColums; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                mod.addRow(filas);
            }
            pst.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void showJTableClientsFiltered(String value) {
        try {
            DefaultTableModel mod = new DefaultTableModel();
            jTableClients.setModel(mod);

            String SQL = "select * from clients where CompanyNameC like '%" + value + "%'";
            PreparedStatement pst = con.prepareStatement(SQL);

            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            int cantColums = rsmd.getColumnCount();

            mod.addColumn("NIT");
            mod.addColumn("COMPANY");
            mod.addColumn("EMAIL");
            mod.addColumn("PHONE");
            mod.addColumn("CITY");
            mod.addColumn("ADRESS");

            while (rs.next()) {
                Object[] filas = new Object[cantColums];
                for (int i = 0; i < cantColums; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                mod.addRow(filas);
            }
            pst.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void cleanClients() {
        txtNitC.setText("");
        txtCompanyNameC.setText("");
        txtEmailC.setText("");
        txtPhoneNumberC.setText("");
        txtCityC.setText("");
        txtAdressC.setText("");
        txtNitC.requestFocus();
    }

    public void showJTableSuppliers() {
        try {
            DefaultTableModel mod = new DefaultTableModel();
            jTableSuppliers.setModel(mod);

            String SQL = "select * from suppliers";
            PreparedStatement pst = con.prepareStatement(SQL);

            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            int cantColums = rsmd.getColumnCount();

            mod.addColumn("NIT");
            mod.addColumn("COMPANY");
            mod.addColumn("EMAIL");
            mod.addColumn("PHONE");
            mod.addColumn("CITY");
            mod.addColumn("ADRESS");

            while (rs.next()) {
                Object[] filas = new Object[cantColums];
                for (int i = 0; i < cantColums; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                mod.addRow(filas);
            }
            pst.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void showJTableSuppliersFiltered(String value) {
        try {
            DefaultTableModel mod = new DefaultTableModel();
            jTableSuppliers.setModel(mod);

            String SQL = "select * from suppliers where CompanyNameS like '%" + value + "%'";
            PreparedStatement pst = con.prepareStatement(SQL);

            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            int cantColums = rsmd.getColumnCount();

            mod.addColumn("NIT");
            mod.addColumn("COMPANY");
            mod.addColumn("EMAIL");
            mod.addColumn("PHONE");
            mod.addColumn("CITY");
            mod.addColumn("ADRESS");

            while (rs.next()) {
                Object[] filas = new Object[cantColums];
                for (int i = 0; i < cantColums; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                mod.addRow(filas);
            }
            pst.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void cleanSuppliers() {
        txtNitS.setText("");
        txtCompanyNameS.setText("");
        txtEmailS.setText("");
        txtPhoneNumberS.setText("");
        txtCityS.setText("");
        txtAdressS.setText("");
        txtNitS.requestFocus();
    }

    public void showJTableProducts() {
        try {
            DefaultTableModel mod = new DefaultTableModel();
            jTableProducts.setModel(mod);

            String SQL = "select * from products";
            PreparedStatement pst = con.prepareStatement(SQL);

            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            int cantColums = rsmd.getColumnCount();

            mod.addColumn("ID");
            mod.addColumn("NAME");
            mod.addColumn("WHEIGHT");
            mod.addColumn("STOCK");
            mod.addColumn("DATE PURCHASE");
            mod.addColumn("EXPIRATION DATE");
            mod.addColumn("PRICE");

            while (rs.next()) {
                Object[] filas = new Object[cantColums];
                for (int i = 0; i < cantColums; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                mod.addRow(filas);
            }
            pst.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void showJTableProductsFiltered(String value) {
        try {
            DefaultTableModel mod = new DefaultTableModel();
            jTableProducts.setModel(mod);

            String SQL = "select * from products where NameP like '%" + value + "%'";
            PreparedStatement pst = con.prepareStatement(SQL);

            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            int cantColums = rsmd.getColumnCount();

            mod.addColumn("ID");
            mod.addColumn("NAME");
            mod.addColumn("WHEIGHT");
            mod.addColumn("STOCK");
            mod.addColumn("DATE PURCHASE");
            mod.addColumn("EXPIRATION DATE");
            mod.addColumn("PRICE");

            while (rs.next()) {
                Object[] filas = new Object[cantColums];
                for (int i = 0; i < cantColums; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                mod.addRow(filas);
            }
            pst.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void cleanProducts() {
        txtIdP.setText("");
        txtNameP.setText("");
        txtWheightP.setText("");
        txtStockP.setText("");
        txtDatePurchaseP.setText("");
        txtExpirationDateP.setText("");
        txtPriceP.setText("");
        txtIdP.requestFocus();
    }

    public void showJTableNewOrder() {
        try {
            DefaultTableModel mod = new DefaultTableModel();
            jTableNewOrder.setModel(mod);

            String SQL = "select * from neworder";
            PreparedStatement pst = con.prepareStatement(SQL);

            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            int cantColums = rsmd.getColumnCount();

            mod.addColumn("ID");
            mod.addColumn("NAME");
            mod.addColumn("QUANTITY");
            mod.addColumn("PRICE");
            mod.addColumn("TOTAL");

            while (rs.next()) {
                Object[] filas = new Object[cantColums];
                for (int i = 0; i < cantColums; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                mod.addRow(filas);
            }
            pst.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void showJTablePurchaseOrders() {
        try {
            DefaultTableModel mod = new DefaultTableModel();
            jTablePurchaseOrders.setModel(mod);

            String SQL = "select * from purchaseorders";
            PreparedStatement pst = con.prepareStatement(SQL);

            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            int cantColums = rsmd.getColumnCount();

            mod.addColumn("CODE");
            mod.addColumn("CLIENT");
            mod.addColumn("SELLER");
            mod.addColumn("TOTAL");

            while (rs.next()) {
                Object[] filas = new Object[cantColums];
                for (int i = 0; i < cantColums; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                mod.addRow(filas);
            }
            pst.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void showJTablePurchaseOrdersFiltered(String value) {
        try {
            DefaultTableModel mod = new DefaultTableModel();
            jTablePurchaseOrders.setModel(mod);

            String SQL = "select * from purchaseorders where CodePO like '%" + value + "%'";
            PreparedStatement pst = con.prepareStatement(SQL);

            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            int cantColums = rsmd.getColumnCount();

            mod.addColumn("CODE");
            mod.addColumn("CLIENT");
            mod.addColumn("SELLER");
            mod.addColumn("TOTAL");

            while (rs.next()) {
                Object[] filas = new Object[cantColums];
                for (int i = 0; i < cantColums; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                mod.addRow(filas);
            }
            pst.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    
    
//    Login lg = new Login();
//        private void chk(){
//            lbl_name.setText(lg.name);
//            lbl_type.setText(lg.type);
//            
//        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Header = new Images.PanelRound();
        nUsuario = new javax.swing.JTextField();
        nRol = new javax.swing.JTextField();
        UserIcon = new javax.swing.JLabel();
        ExitIcon = new javax.swing.JLabel();
        sidebar = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        buttonNewPurchaseOrder = new Images.PanelRound();
        TxtButtNewPurcharseOrder = new javax.swing.JLabel();
        buttonClients = new Images.PanelRound();
        TxtButtClients = new javax.swing.JLabel();
        buttonSuppliers = new Images.PanelRound();
        TxtSuppliers = new javax.swing.JLabel();
        buttonProducts = new Images.PanelRound();
        TxtButtProducts = new javax.swing.JLabel();
        buttonPurchaseOrders = new Images.PanelRound();
        TxtButtPurchaseOrders = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Welcome = new javax.swing.JPanel();
        panelRound1 = new Images.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelRound2 = new Images.PanelRound();
        NewPurchaseOrderInterface = new javax.swing.JPanel();
        JScrollPaneN = new javax.swing.JScrollPane();
        jTableNewOrder = new javax.swing.JTable();
        NameTableN = new javax.swing.JLabel();
        txtIdPN = new javax.swing.JTextField();
        txtProductPN = new javax.swing.JTextField();
        txtQuantityN = new javax.swing.JTextField();
        txtAvailableStockN = new javax.swing.JTextField();
        txtPricePN = new javax.swing.JTextField();
        txtNameN = new javax.swing.JTextField();
        txtTotalPriceN = new javax.swing.JTextField();
        txtClientN = new javax.swing.JTextField();
        IdN = new javax.swing.JLabel();
        ProductN = new javax.swing.JLabel();
        QuantityNsus = new javax.swing.JLabel();
        AvailableStockN = new javax.swing.JLabel();
        PriceN = new javax.swing.JLabel();
        ClientN = new javax.swing.JLabel();
        CompanyNameClients4 = new javax.swing.JLabel();
        TotalPriceN = new javax.swing.JLabel();
        LoupeN = new javax.swing.JLabel();
        btnAddToCartN = new Images.PanelRound();
        AddToCartN = new javax.swing.JLabel();
        CartN = new javax.swing.JLabel();
        btnPlaceOrderN = new Images.PanelRound();
        PlaceOrderN = new javax.swing.JLabel();
        ClientsInterface = new javax.swing.JPanel();
        ButtonCreateC = new Images.PanelRound();
        CreateC = new javax.swing.JLabel();
        ButtonUploadC = new Images.PanelRound();
        UploadC = new javax.swing.JLabel();
        ButtonCleanC = new Images.PanelRound();
        CleanC = new javax.swing.JLabel();
        ButtonDeleteC = new Images.PanelRound();
        DeleteC = new javax.swing.JLabel();
        jScrollPaneC = new javax.swing.JScrollPane();
        jTableClients = new javax.swing.JTable();
        txtNitC = new javax.swing.JTextField();
        txtPhoneNumberC = new javax.swing.JTextField();
        txtCompanyNameC = new javax.swing.JTextField();
        txtCityC = new javax.swing.JTextField();
        txtAdressC = new javax.swing.JTextField();
        txtEmailC = new javax.swing.JTextField();
        txtSearchClients = new javax.swing.JTextField();
        NitClients = new javax.swing.JLabel();
        CompanyNameClients = new javax.swing.JLabel();
        EmailClients = new javax.swing.JLabel();
        PhoneNumber = new javax.swing.JLabel();
        CityClients = new javax.swing.JLabel();
        AddressClients = new javax.swing.JLabel();
        LoupeClients = new javax.swing.JLabel();
        NameTableClients = new javax.swing.JLabel();
        SuppliersInterface = new javax.swing.JPanel();
        ButtonCreateS = new Images.PanelRound();
        CreateS = new javax.swing.JLabel();
        ButtonUploadS = new Images.PanelRound();
        UploadS = new javax.swing.JLabel();
        ButtonCleanS = new Images.PanelRound();
        CleanS = new javax.swing.JLabel();
        ButtonDeleteS = new Images.PanelRound();
        DeleteS = new javax.swing.JLabel();
        jScrollPaneS = new javax.swing.JScrollPane();
        jTableSuppliers = new javax.swing.JTable();
        txtNitS = new javax.swing.JTextField();
        txtPhoneNumberS = new javax.swing.JTextField();
        txtCompanyNameS = new javax.swing.JTextField();
        txtCityS = new javax.swing.JTextField();
        txtAdressS = new javax.swing.JTextField();
        txtEmailS = new javax.swing.JTextField();
        txtSearchSuppliers = new javax.swing.JTextField();
        NitS = new javax.swing.JLabel();
        CompanyNameS = new javax.swing.JLabel();
        EmailS = new javax.swing.JLabel();
        PhoneNumberS = new javax.swing.JLabel();
        CityS = new javax.swing.JLabel();
        AddressS = new javax.swing.JLabel();
        LoupeS = new javax.swing.JLabel();
        NameTableSuppliers = new javax.swing.JLabel();
        ProductsInterface = new javax.swing.JPanel();
        ButtonCreateP = new Images.PanelRound();
        CreateP = new javax.swing.JLabel();
        ButtonUploadP = new Images.PanelRound();
        UploadP = new javax.swing.JLabel();
        ButtonCleanP = new Images.PanelRound();
        CleanP = new javax.swing.JLabel();
        ButtonDeleteP = new Images.PanelRound();
        DeleteP = new javax.swing.JLabel();
        jScrollPaneP = new javax.swing.JScrollPane();
        jTableProducts = new javax.swing.JTable();
        txtIdP = new javax.swing.JTextField();
        txtNameP = new javax.swing.JTextField();
        txtWheightP = new javax.swing.JTextField();
        txtStockP = new javax.swing.JTextField();
        txtDatePurchaseP = new javax.swing.JTextField();
        txtExpirationDateP = new javax.swing.JTextField();
        txtPriceP = new javax.swing.JTextField();
        txtSearchProducts = new javax.swing.JTextField();
        IdP = new javax.swing.JLabel();
        NameProductP = new javax.swing.JLabel();
        WheightP = new javax.swing.JLabel();
        StockP = new javax.swing.JLabel();
        DatePurchase = new javax.swing.JLabel();
        ExpirationDate = new javax.swing.JLabel();
        PriceP = new javax.swing.JLabel();
        LoupeP = new javax.swing.JLabel();
        NameTableP = new javax.swing.JLabel();
        PurchaseOrdersInterface = new javax.swing.JPanel();
        btnPrintPo = new Images.PanelRound();
        PrintPo = new javax.swing.JLabel();
        jScrollPaneP1 = new javax.swing.JScrollPane();
        jTablePurchaseOrders = new javax.swing.JTable();
        txtSearchP1 = new javax.swing.JTextField();
        LoupePo = new javax.swing.JLabel();
        NameTableP1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setBackground(new java.awt.Color(224, 159, 62));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nUsuario.setEditable(false);
        nUsuario.setText("UserName");
        Header.add(nUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 90, -1));

        nRol.setEditable(false);
        nRol.setText("UserRol");
        nRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nRolActionPerformed(evt);
            }
        });
        Header.add(nRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 80, -1));
        Header.add(UserIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 30, 30));

        ExitIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cerrarsesion.png"))); // NOI18N
        ExitIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ExitIcon.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ExitIconMouseMoved(evt);
            }
        });
        ExitIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitIconMouseClicked(evt);
            }
        });
        Header.add(ExitIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 30, 30));

        getContentPane().add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 660, 50));

        sidebar.setBackground(new java.awt.Color(84, 11, 14));
        sidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/perrologin-2.png"))); // NOI18N
        sidebar.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 100, 100));

        buttonNewPurchaseOrder.setBackground(new java.awt.Color(224, 159, 62));
        buttonNewPurchaseOrder.setToolTipText("");
        buttonNewPurchaseOrder.setRoundBottomLeft(10);
        buttonNewPurchaseOrder.setRoundBottomRight(10);
        buttonNewPurchaseOrder.setRoundTopLeft(10);
        buttonNewPurchaseOrder.setRoundTopRight(10);
        buttonNewPurchaseOrder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TxtButtNewPurcharseOrder.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TxtButtNewPurcharseOrder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TxtButtNewPurcharseOrder.setText("New Purchase Order");
        TxtButtNewPurcharseOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TxtButtNewPurcharseOrder.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                TxtButtNewPurcharseOrderAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        TxtButtNewPurcharseOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TxtButtNewPurcharseOrderMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TxtButtNewPurcharseOrderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TxtButtNewPurcharseOrderMouseExited(evt);
            }
        });
        buttonNewPurchaseOrder.add(TxtButtNewPurcharseOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 30));

        sidebar.add(buttonNewPurchaseOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 170, 150, 30));

        buttonClients.setBackground(new java.awt.Color(224, 159, 62));
        buttonClients.setToolTipText("");
        buttonClients.setRoundBottomLeft(10);
        buttonClients.setRoundBottomRight(10);
        buttonClients.setRoundTopLeft(10);
        buttonClients.setRoundTopRight(10);
        buttonClients.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TxtButtClients.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TxtButtClients.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TxtButtClients.setText("Clients");
        TxtButtClients.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TxtButtClients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TxtButtClientsMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TxtButtClientsMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TxtButtClientsMouseEntered(evt);
            }
        });
        buttonClients.add(TxtButtClients, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 30));

        sidebar.add(buttonClients, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 230, 150, 30));

        buttonSuppliers.setBackground(new java.awt.Color(224, 159, 62));
        buttonSuppliers.setToolTipText("");
        buttonSuppliers.setRoundBottomLeft(10);
        buttonSuppliers.setRoundBottomRight(10);
        buttonSuppliers.setRoundTopLeft(10);
        buttonSuppliers.setRoundTopRight(10);
        buttonSuppliers.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TxtSuppliers.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TxtSuppliers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TxtSuppliers.setText("Suppliers");
        TxtSuppliers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TxtSuppliers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TxtSuppliersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TxtSuppliersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TxtSuppliersMouseExited(evt);
            }
        });
        buttonSuppliers.add(TxtSuppliers, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 30));

        sidebar.add(buttonSuppliers, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 290, 150, 30));

        buttonProducts.setBackground(new java.awt.Color(224, 159, 62));
        buttonProducts.setToolTipText("");
        buttonProducts.setRoundBottomLeft(10);
        buttonProducts.setRoundBottomRight(10);
        buttonProducts.setRoundTopLeft(10);
        buttonProducts.setRoundTopRight(10);
        buttonProducts.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TxtButtProducts.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TxtButtProducts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TxtButtProducts.setText("Products");
        TxtButtProducts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TxtButtProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TxtButtProductsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TxtButtProductsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TxtButtProductsMouseExited(evt);
            }
        });
        buttonProducts.add(TxtButtProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 30));

        sidebar.add(buttonProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 350, 150, 30));

        buttonPurchaseOrders.setBackground(new java.awt.Color(224, 159, 62));
        buttonPurchaseOrders.setToolTipText("");
        buttonPurchaseOrders.setRoundBottomLeft(10);
        buttonPurchaseOrders.setRoundBottomRight(10);
        buttonPurchaseOrders.setRoundTopLeft(10);
        buttonPurchaseOrders.setRoundTopRight(10);
        buttonPurchaseOrders.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TxtButtPurchaseOrders.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TxtButtPurchaseOrders.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TxtButtPurchaseOrders.setText("Purchase Orders");
        TxtButtPurchaseOrders.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TxtButtPurchaseOrders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TxtButtPurchaseOrdersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TxtButtPurchaseOrdersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TxtButtPurchaseOrdersMouseExited(evt);
            }
        });
        buttonPurchaseOrders.add(TxtButtPurchaseOrders, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 30));

        sidebar.add(buttonPurchaseOrders, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 410, 150, 30));

        getContentPane().add(sidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 480));

        Welcome.setBackground(new java.awt.Color(255, 243, 176));
        Welcome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setBackground(new java.awt.Color(84, 11, 14));
        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopLeft(50);
        panelRound1.setRoundTopRight(50);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PROJECT INVENTORY APPLICATION");
        panelRound1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 560, 60));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("WELCOME TO THE");
        panelRound1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 500, 60));

        Welcome.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 570, 160));

        panelRound2.setBackground(new java.awt.Color(0, 0, 0));
        panelRound2.setRoundBottomLeft(50);
        panelRound2.setRoundBottomRight(50);
        panelRound2.setRoundTopLeft(50);
        panelRound2.setRoundTopRight(50);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Welcome.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 125, 570, 160));

        jTabbedPane1.addTab("tab5", Welcome);

        NewPurchaseOrderInterface.setBackground(new java.awt.Color(255, 243, 176));
        NewPurchaseOrderInterface.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableNewOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JScrollPaneN.setViewportView(jTableNewOrder);

        NewPurchaseOrderInterface.add(JScrollPaneN, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 620, 170));

        NameTableN.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        NameTableN.setForeground(new java.awt.Color(158, 42, 43));
        NameTableN.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NameTableN.setText("NEW PURCHASE ORDER");
        NewPurchaseOrderInterface.add(NameTableN, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 118, 230, -1));

        txtIdPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdPNActionPerformed(evt);
            }
        });
        NewPurchaseOrderInterface.add(txtIdPN, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 95, 26));
        NewPurchaseOrderInterface.add(txtProductPN, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 265, 26));

        txtQuantityN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityNActionPerformed(evt);
            }
        });
        NewPurchaseOrderInterface.add(txtQuantityN, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 95, 26));

        txtAvailableStockN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAvailableStockNActionPerformed(evt);
            }
        });
        NewPurchaseOrderInterface.add(txtAvailableStockN, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 95, 26));

        txtPricePN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPricePNActionPerformed(evt);
            }
        });
        NewPurchaseOrderInterface.add(txtPricePN, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 95, 26));
        NewPurchaseOrderInterface.add(txtNameN, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 120, 26));

        txtTotalPriceN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalPriceNActionPerformed(evt);
            }
        });
        NewPurchaseOrderInterface.add(txtTotalPriceN, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, 90, 26));
        NewPurchaseOrderInterface.add(txtClientN, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 120, 26));

        IdN.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        IdN.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        IdN.setText("ID:");
        NewPurchaseOrderInterface.add(IdN, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 50, 20));

        ProductN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ProductN.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ProductN.setText("Product:");
        NewPurchaseOrderInterface.add(ProductN, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 70, 20));

        QuantityNsus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        QuantityNsus.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        QuantityNsus.setText("Quantity:");
        NewPurchaseOrderInterface.add(QuantityNsus, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 90, 20));

        AvailableStockN.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        AvailableStockN.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        AvailableStockN.setText("Available Stock:");
        NewPurchaseOrderInterface.add(AvailableStockN, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 120, 20));

        PriceN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PriceN.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        PriceN.setText("Price:");
        NewPurchaseOrderInterface.add(PriceN, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 110, 20));

        ClientN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ClientN.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ClientN.setText("Client:");
        NewPurchaseOrderInterface.add(ClientN, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 70, 20));

        CompanyNameClients4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CompanyNameClients4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CompanyNameClients4.setText("Name:");
        NewPurchaseOrderInterface.add(CompanyNameClients4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 70, 20));

        TotalPriceN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TotalPriceN.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        TotalPriceN.setText("TOTAL PRICE:");
        NewPurchaseOrderInterface.add(TotalPriceN, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, 100, 20));

        LoupeN.setBackground(new java.awt.Color(204, 204, 0));
        LoupeN.setForeground(new java.awt.Color(51, 255, 51));
        LoupeN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/lupita.png"))); // NOI18N
        NewPurchaseOrderInterface.add(LoupeN, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 20, 20));

        btnAddToCartN.setBackground(new java.awt.Color(158, 42, 43));
        btnAddToCartN.setRoundBottomLeft(15);
        btnAddToCartN.setRoundBottomRight(15);
        btnAddToCartN.setRoundTopLeft(15);
        btnAddToCartN.setRoundTopRight(15);
        btnAddToCartN.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AddToCartN.setBackground(new java.awt.Color(255, 255, 255));
        AddToCartN.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AddToCartN.setForeground(new java.awt.Color(255, 255, 255));
        AddToCartN.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        AddToCartN.setText("ADD TO CART");
        AddToCartN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddToCartN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddToCartNMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddToCartNMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddToCartNMouseExited(evt);
            }
        });
        btnAddToCartN.add(AddToCartN, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 30));

        CartN.setBackground(new java.awt.Color(204, 204, 0));
        CartN.setForeground(new java.awt.Color(51, 255, 51));
        CartN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/lupita.png"))); // NOI18N
        CartN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddToCartN.add(CartN, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, 20, 20));

        NewPurchaseOrderInterface.add(btnAddToCartN, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 160, 30));

        btnPlaceOrderN.setBackground(new java.awt.Color(51, 92, 103));
        btnPlaceOrderN.setRoundBottomLeft(15);
        btnPlaceOrderN.setRoundBottomRight(15);
        btnPlaceOrderN.setRoundTopLeft(15);
        btnPlaceOrderN.setRoundTopRight(15);
        btnPlaceOrderN.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PlaceOrderN.setBackground(new java.awt.Color(255, 255, 255));
        PlaceOrderN.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PlaceOrderN.setForeground(new java.awt.Color(255, 255, 255));
        PlaceOrderN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PlaceOrderN.setText("PLACE ORDER");
        PlaceOrderN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PlaceOrderN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PlaceOrderNMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PlaceOrderNMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PlaceOrderNMouseExited(evt);
            }
        });
        btnPlaceOrderN.add(PlaceOrderN, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        NewPurchaseOrderInterface.add(btnPlaceOrderN, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, 120, 40));

        jTabbedPane1.addTab("tab2", NewPurchaseOrderInterface);

        ClientsInterface.setBackground(new java.awt.Color(255, 243, 176));
        ClientsInterface.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonCreateC.setBackground(new java.awt.Color(51, 92, 103));
        ButtonCreateC.setRoundBottomLeft(10);
        ButtonCreateC.setRoundBottomRight(10);
        ButtonCreateC.setRoundTopLeft(10);
        ButtonCreateC.setRoundTopRight(10);
        ButtonCreateC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CreateC.setForeground(new java.awt.Color(255, 255, 255));
        CreateC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CreateC.setText("Create");
        CreateC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CreateC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CreateCMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CreateCMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CreateCMouseEntered(evt);
            }
        });
        ButtonCreateC.add(CreateC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        ClientsInterface.add(ButtonCreateC, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 30));

        ButtonUploadC.setBackground(new java.awt.Color(51, 92, 103));
        ButtonUploadC.setForeground(new java.awt.Color(255, 255, 255));
        ButtonUploadC.setRoundBottomLeft(10);
        ButtonUploadC.setRoundBottomRight(10);
        ButtonUploadC.setRoundTopLeft(10);
        ButtonUploadC.setRoundTopRight(10);
        ButtonUploadC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UploadC.setForeground(new java.awt.Color(255, 255, 255));
        UploadC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UploadC.setText("Upload");
        UploadC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UploadC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UploadCMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UploadCMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UploadCMouseEntered(evt);
            }
        });
        ButtonUploadC.add(UploadC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        ClientsInterface.add(ButtonUploadC, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, 30));

        ButtonCleanC.setBackground(new java.awt.Color(51, 92, 103));
        ButtonCleanC.setRoundBottomLeft(10);
        ButtonCleanC.setRoundBottomRight(10);
        ButtonCleanC.setRoundTopLeft(10);
        ButtonCleanC.setRoundTopRight(10);
        ButtonCleanC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CleanC.setForeground(new java.awt.Color(255, 255, 255));
        CleanC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CleanC.setText("Clean");
        CleanC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CleanC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CleanCMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CleanCMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CleanCMouseEntered(evt);
            }
        });
        ButtonCleanC.add(CleanC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        ClientsInterface.add(ButtonCleanC, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, 30));

        ButtonDeleteC.setBackground(new java.awt.Color(158, 42, 43));
        ButtonDeleteC.setRoundBottomLeft(10);
        ButtonDeleteC.setRoundBottomRight(10);
        ButtonDeleteC.setRoundTopLeft(10);
        ButtonDeleteC.setRoundTopRight(10);
        ButtonDeleteC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DeleteC.setForeground(new java.awt.Color(255, 255, 255));
        DeleteC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DeleteC.setText("Delete");
        DeleteC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DeleteC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteCMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DeleteCMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DeleteCMouseEntered(evt);
            }
        });
        ButtonDeleteC.add(DeleteC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        ClientsInterface.add(ButtonDeleteC, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 80, 30));

        jTableClients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableClients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClientsMouseClicked(evt);
            }
        });
        jScrollPaneC.setViewportView(jTableClients);

        ClientsInterface.add(jScrollPaneC, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 620, 200));

        txtNitC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNitCActionPerformed(evt);
            }
        });
        txtNitC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNitCKeyTyped(evt);
            }
        });
        ClientsInterface.add(txtNitC, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 95, 26));

        txtPhoneNumberC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneNumberCActionPerformed(evt);
            }
        });
        txtPhoneNumberC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhoneNumberCKeyTyped(evt);
            }
        });
        ClientsInterface.add(txtPhoneNumberC, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 95, 26));
        ClientsInterface.add(txtCompanyNameC, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 95, 26));

        txtCityC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCityCActionPerformed(evt);
            }
        });
        ClientsInterface.add(txtCityC, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 95, 26));

        txtAdressC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdressCActionPerformed(evt);
            }
        });
        ClientsInterface.add(txtAdressC, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 95, 26));

        txtEmailC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailCActionPerformed(evt);
            }
        });
        ClientsInterface.add(txtEmailC, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 95, 26));

        txtSearchClients.setText("Search");
        txtSearchClients.setToolTipText("Search");
        txtSearchClients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtSearchClientsMousePressed(evt);
            }
        });
        txtSearchClients.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchClientsKeyTyped(evt);
            }
        });
        ClientsInterface.add(txtSearchClients, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 160, 30));

        NitClients.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        NitClients.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        NitClients.setText("NIT:");
        ClientsInterface.add(NitClients, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 90, 20));

        CompanyNameClients.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CompanyNameClients.setText("Company Name:");
        ClientsInterface.add(CompanyNameClients, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 100, 20));

        EmailClients.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        EmailClients.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        EmailClients.setText("E-Mail:");
        ClientsInterface.add(EmailClients, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 90, 20));

        PhoneNumber.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PhoneNumber.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        PhoneNumber.setText("Phone Number:");
        ClientsInterface.add(PhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 110, 20));

        CityClients.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CityClients.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        CityClients.setText("City:");
        ClientsInterface.add(CityClients, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 90, 20));

        AddressClients.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        AddressClients.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        AddressClients.setText("Address:");
        ClientsInterface.add(AddressClients, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 90, 20));
        ClientsInterface.add(LoupeClients, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 30, 30));

        NameTableClients.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        NameTableClients.setForeground(new java.awt.Color(158, 42, 43));
        NameTableClients.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        NameTableClients.setText("CLIENTS");
        ClientsInterface.add(NameTableClients, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, 90, 30));

        jTabbedPane1.addTab("tab2", ClientsInterface);

        SuppliersInterface.setBackground(new java.awt.Color(255, 243, 176));
        SuppliersInterface.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonCreateS.setBackground(new java.awt.Color(51, 92, 103));
        ButtonCreateS.setRoundBottomLeft(10);
        ButtonCreateS.setRoundBottomRight(10);
        ButtonCreateS.setRoundTopLeft(10);
        ButtonCreateS.setRoundTopRight(10);
        ButtonCreateS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CreateS.setForeground(new java.awt.Color(255, 255, 255));
        CreateS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CreateS.setText("Create");
        CreateS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CreateS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CreateSMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CreateSMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CreateSMouseEntered(evt);
            }
        });
        ButtonCreateS.add(CreateS, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        SuppliersInterface.add(ButtonCreateS, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 30));

        ButtonUploadS.setBackground(new java.awt.Color(51, 92, 103));
        ButtonUploadS.setForeground(new java.awt.Color(255, 255, 255));
        ButtonUploadS.setRoundBottomLeft(10);
        ButtonUploadS.setRoundBottomRight(10);
        ButtonUploadS.setRoundTopLeft(10);
        ButtonUploadS.setRoundTopRight(10);
        ButtonUploadS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UploadS.setForeground(new java.awt.Color(255, 255, 255));
        UploadS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UploadS.setText("Upload");
        UploadS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UploadS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UploadSMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UploadSMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UploadSMouseEntered(evt);
            }
        });
        ButtonUploadS.add(UploadS, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        SuppliersInterface.add(ButtonUploadS, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, 30));

        ButtonCleanS.setBackground(new java.awt.Color(51, 92, 103));
        ButtonCleanS.setRoundBottomLeft(10);
        ButtonCleanS.setRoundBottomRight(10);
        ButtonCleanS.setRoundTopLeft(10);
        ButtonCleanS.setRoundTopRight(10);
        ButtonCleanS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CleanS.setForeground(new java.awt.Color(255, 255, 255));
        CleanS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CleanS.setText("Clean");
        CleanS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CleanS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CleanSMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CleanSMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CleanSMouseEntered(evt);
            }
        });
        ButtonCleanS.add(CleanS, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        SuppliersInterface.add(ButtonCleanS, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, 30));

        ButtonDeleteS.setBackground(new java.awt.Color(158, 42, 43));
        ButtonDeleteS.setRoundBottomLeft(10);
        ButtonDeleteS.setRoundBottomRight(10);
        ButtonDeleteS.setRoundTopLeft(10);
        ButtonDeleteS.setRoundTopRight(10);
        ButtonDeleteS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DeleteS.setForeground(new java.awt.Color(255, 255, 255));
        DeleteS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DeleteS.setText("Delete");
        DeleteS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DeleteS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteSMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DeleteSMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DeleteSMouseEntered(evt);
            }
        });
        ButtonDeleteS.add(DeleteS, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        SuppliersInterface.add(ButtonDeleteS, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 80, 30));

        jTableSuppliers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableSuppliers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableSuppliersMousePressed(evt);
            }
        });
        jScrollPaneS.setViewportView(jTableSuppliers);

        SuppliersInterface.add(jScrollPaneS, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 620, 200));

        txtNitS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNitSActionPerformed(evt);
            }
        });
        txtNitS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNitSKeyTyped(evt);
            }
        });
        SuppliersInterface.add(txtNitS, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 95, 26));

        txtPhoneNumberS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneNumberSActionPerformed(evt);
            }
        });
        txtPhoneNumberS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhoneNumberSKeyTyped(evt);
            }
        });
        SuppliersInterface.add(txtPhoneNumberS, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 95, 26));
        SuppliersInterface.add(txtCompanyNameS, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 95, 26));

        txtCityS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCitySActionPerformed(evt);
            }
        });
        SuppliersInterface.add(txtCityS, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 95, 26));

        txtAdressS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdressSActionPerformed(evt);
            }
        });
        txtAdressS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAdressSKeyTyped(evt);
            }
        });
        SuppliersInterface.add(txtAdressS, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 95, 26));

        txtEmailS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailSActionPerformed(evt);
            }
        });
        SuppliersInterface.add(txtEmailS, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 95, 26));

        txtSearchSuppliers.setToolTipText("Search");
        txtSearchSuppliers.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchSuppliersKeyReleased(evt);
            }
        });
        SuppliersInterface.add(txtSearchSuppliers, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 160, 30));

        NitS.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        NitS.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        NitS.setText("NIT:");
        SuppliersInterface.add(NitS, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 90, 20));

        CompanyNameS.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CompanyNameS.setText("Company Name:");
        SuppliersInterface.add(CompanyNameS, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 100, 20));

        EmailS.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        EmailS.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        EmailS.setText("E-Mail:");
        SuppliersInterface.add(EmailS, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 90, 20));

        PhoneNumberS.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PhoneNumberS.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        PhoneNumberS.setText("Phone Number:");
        SuppliersInterface.add(PhoneNumberS, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 110, 20));

        CityS.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CityS.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        CityS.setText("City:");
        SuppliersInterface.add(CityS, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 90, 20));

        AddressS.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        AddressS.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        AddressS.setText("Address:");
        SuppliersInterface.add(AddressS, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 90, 20));
        SuppliersInterface.add(LoupeS, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 30, 30));

        NameTableSuppliers.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        NameTableSuppliers.setForeground(new java.awt.Color(158, 42, 43));
        NameTableSuppliers.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        NameTableSuppliers.setText("SUPPLIERS");
        SuppliersInterface.add(NameTableSuppliers, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, 120, 30));

        jTabbedPane1.addTab("tab2", SuppliersInterface);

        ProductsInterface.setBackground(new java.awt.Color(255, 243, 176));
        ProductsInterface.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonCreateP.setBackground(new java.awt.Color(51, 92, 103));
        ButtonCreateP.setRoundBottomLeft(10);
        ButtonCreateP.setRoundBottomRight(10);
        ButtonCreateP.setRoundTopLeft(10);
        ButtonCreateP.setRoundTopRight(10);
        ButtonCreateP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CreateP.setForeground(new java.awt.Color(255, 255, 255));
        CreateP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CreateP.setText("Create");
        CreateP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CreateP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CreatePMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CreatePMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CreatePMouseEntered(evt);
            }
        });
        ButtonCreateP.add(CreateP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        ProductsInterface.add(ButtonCreateP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 30));

        ButtonUploadP.setBackground(new java.awt.Color(51, 92, 103));
        ButtonUploadP.setForeground(new java.awt.Color(255, 255, 255));
        ButtonUploadP.setRoundBottomLeft(10);
        ButtonUploadP.setRoundBottomRight(10);
        ButtonUploadP.setRoundTopLeft(10);
        ButtonUploadP.setRoundTopRight(10);
        ButtonUploadP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UploadP.setForeground(new java.awt.Color(255, 255, 255));
        UploadP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UploadP.setText("Upload");
        UploadP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UploadP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UploadPMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UploadPMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UploadPMouseEntered(evt);
            }
        });
        ButtonUploadP.add(UploadP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        ProductsInterface.add(ButtonUploadP, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, 30));

        ButtonCleanP.setBackground(new java.awt.Color(51, 92, 103));
        ButtonCleanP.setRoundBottomLeft(10);
        ButtonCleanP.setRoundBottomRight(10);
        ButtonCleanP.setRoundTopLeft(10);
        ButtonCleanP.setRoundTopRight(10);
        ButtonCleanP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CleanP.setForeground(new java.awt.Color(255, 255, 255));
        CleanP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CleanP.setText("Clean");
        CleanP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CleanP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CleanPMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CleanPMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CleanPMouseEntered(evt);
            }
        });
        ButtonCleanP.add(CleanP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        ProductsInterface.add(ButtonCleanP, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, 30));

        ButtonDeleteP.setBackground(new java.awt.Color(158, 42, 43));
        ButtonDeleteP.setRoundBottomLeft(10);
        ButtonDeleteP.setRoundBottomRight(10);
        ButtonDeleteP.setRoundTopLeft(10);
        ButtonDeleteP.setRoundTopRight(10);
        ButtonDeleteP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DeleteP.setForeground(new java.awt.Color(255, 255, 255));
        DeleteP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DeleteP.setText("Delete");
        DeleteP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DeleteP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeletePMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DeletePMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DeletePMouseEntered(evt);
            }
        });
        ButtonDeleteP.add(DeleteP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        ProductsInterface.add(ButtonDeleteP, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 80, 30));

        jTableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductsMouseClicked(evt);
            }
        });
        jScrollPaneP.setViewportView(jTableProducts);

        ProductsInterface.add(jScrollPaneP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 620, 200));

        txtIdP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdPActionPerformed(evt);
            }
        });
        txtIdP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdPKeyTyped(evt);
            }
        });
        ProductsInterface.add(txtIdP, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 95, 26));
        ProductsInterface.add(txtNameP, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 95, 26));

        txtWheightP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWheightPActionPerformed(evt);
            }
        });
        txtWheightP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtWheightPKeyTyped(evt);
            }
        });
        ProductsInterface.add(txtWheightP, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 95, 26));

        txtStockP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockPActionPerformed(evt);
            }
        });
        txtStockP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockPKeyTyped(evt);
            }
        });
        ProductsInterface.add(txtStockP, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 95, 26));

        txtDatePurchaseP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDatePurchasePActionPerformed(evt);
            }
        });
        ProductsInterface.add(txtDatePurchaseP, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 95, 26));

        txtExpirationDateP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtExpirationDatePActionPerformed(evt);
            }
        });
        ProductsInterface.add(txtExpirationDateP, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 95, 26));

        txtPriceP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPricePActionPerformed(evt);
            }
        });
        txtPriceP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPricePKeyTyped(evt);
            }
        });
        ProductsInterface.add(txtPriceP, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 95, 26));

        txtSearchProducts.setToolTipText("Search");
        txtSearchProducts.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchProductsKeyTyped(evt);
            }
        });
        ProductsInterface.add(txtSearchProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 160, 30));

        IdP.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        IdP.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        IdP.setText("ID:");
        ProductsInterface.add(IdP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 90, 20));

        NameProductP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        NameProductP.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        NameProductP.setText("Name Product:");
        ProductsInterface.add(NameProductP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 100, 20));

        WheightP.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        WheightP.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        WheightP.setText("Wheight:");
        ProductsInterface.add(WheightP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 90, 20));

        StockP.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        StockP.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        StockP.setText("Stock:");
        ProductsInterface.add(StockP, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 90, 20));

        DatePurchase.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DatePurchase.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        DatePurchase.setText("Date Purchase:");
        ProductsInterface.add(DatePurchase, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 110, 20));

        ExpirationDate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ExpirationDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ExpirationDate.setText("Expiration Date:");
        ProductsInterface.add(ExpirationDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 90, 20));

        PriceP.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        PriceP.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        PriceP.setText("Price:");
        ProductsInterface.add(PriceP, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 90, 20));
        ProductsInterface.add(LoupeP, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 30, 30));

        NameTableP.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        NameTableP.setForeground(new java.awt.Color(158, 42, 43));
        NameTableP.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        NameTableP.setText("PRODUCTS");
        ProductsInterface.add(NameTableP, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, 120, 30));

        jTabbedPane1.addTab("tab2", ProductsInterface);

        PurchaseOrdersInterface.setBackground(new java.awt.Color(255, 243, 176));
        PurchaseOrdersInterface.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPrintPo.setBackground(new java.awt.Color(51, 92, 103));
        btnPrintPo.setRoundBottomLeft(10);
        btnPrintPo.setRoundBottomRight(10);
        btnPrintPo.setRoundTopLeft(10);
        btnPrintPo.setRoundTopRight(10);
        btnPrintPo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PrintPo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PrintPo.setForeground(new java.awt.Color(255, 255, 255));
        PrintPo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PrintPo.setText("PRINT");
        PrintPo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PrintPo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PrintPoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PrintPoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PrintPoMouseExited(evt);
            }
        });
        btnPrintPo.add(PrintPo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 50));

        PurchaseOrdersInterface.add(btnPrintPo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 80, 50));

        jTablePurchaseOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPaneP1.setViewportView(jTablePurchaseOrders);

        PurchaseOrdersInterface.add(jScrollPaneP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 620, 320));

        txtSearchP1.setText("Buscar");
        PurchaseOrdersInterface.add(txtSearchP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 210, 30));
        PurchaseOrdersInterface.add(LoupePo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 30, 30));

        NameTableP1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        NameTableP1.setForeground(new java.awt.Color(158, 42, 43));
        NameTableP1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        NameTableP1.setText("PURCHASE ORDERS");
        PurchaseOrdersInterface.add(NameTableP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 180, 20));

        jTabbedPane1.addTab("tab2", PurchaseOrdersInterface);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 660, 460));

        jLabel1.setBackground(new java.awt.Color(88, 129, 87));
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitIconMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitIconMouseMoved
        
    }//GEN-LAST:event_ExitIconMouseMoved

    private void ExitIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitIconMouseClicked
        userInteraction();
    }//GEN-LAST:event_ExitIconMouseClicked

    private void nRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nRolActionPerformed
        
    }//GEN-LAST:event_nRolActionPerformed

    private void TxtButtNewPurcharseOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtButtNewPurcharseOrderMouseClicked
        ListarCliente();
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_TxtButtNewPurcharseOrderMouseClicked

    private void TxtButtNewPurcharseOrderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtButtNewPurcharseOrderMouseEntered
        buttonNewPurchaseOrder.setBackground(Color.decode("#FFF3B0"));
    }//GEN-LAST:event_TxtButtNewPurcharseOrderMouseEntered

    private void TxtButtNewPurcharseOrderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtButtNewPurcharseOrderMouseExited
        buttonNewPurchaseOrder.setBackground(Color.decode("#E09F3E"));
    }//GEN-LAST:event_TxtButtNewPurcharseOrderMouseExited

    private void TxtButtClientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtButtClientsMouseClicked
        ListarCliente();
        jTabbedPane1.setSelectedIndex(2);
        buttonClients.setBackground(Color.decode("#FFF3B0"));
    }//GEN-LAST:event_TxtButtClientsMouseClicked

    private void TxtButtClientsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtButtClientsMouseEntered
        buttonClients.setBackground(Color.decode("#FFF3B0"));
    }//GEN-LAST:event_TxtButtClientsMouseEntered

    private void TxtButtClientsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtButtClientsMouseExited
        buttonClients.setBackground(Color.decode("#E09F3E"));
    }//GEN-LAST:event_TxtButtClientsMouseExited

    private void TxtSuppliersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtSuppliersMouseClicked
        ListarCliente();
        jTabbedPane1.setSelectedIndex(3);
        buttonSuppliers.setBackground(Color.decode("#FFF3B0"));
    }//GEN-LAST:event_TxtSuppliersMouseClicked

    private void TxtSuppliersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtSuppliersMouseEntered
        buttonSuppliers.setBackground(Color.decode("#FFF3B0"));
    }//GEN-LAST:event_TxtSuppliersMouseEntered

    private void TxtSuppliersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtSuppliersMouseExited
        buttonSuppliers.setBackground(Color.decode("#E09F3E"));
    }//GEN-LAST:event_TxtSuppliersMouseExited

    private void TxtButtProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtButtProductsMouseClicked
        ListarCliente();
        jTabbedPane1.setSelectedIndex(4);
        buttonProducts.setBackground(Color.decode("#FFF3B0"));
    }//GEN-LAST:event_TxtButtProductsMouseClicked

    private void TxtButtProductsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtButtProductsMouseEntered
        buttonProducts.setBackground(Color.decode("#FFF3B0"));
    }//GEN-LAST:event_TxtButtProductsMouseEntered

    private void TxtButtProductsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtButtProductsMouseExited
        buttonProducts.setBackground(Color.decode("#E09F3E"));
    }//GEN-LAST:event_TxtButtProductsMouseExited

    private void TxtButtPurchaseOrdersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtButtPurchaseOrdersMouseClicked
        ListarCliente();
        jTabbedPane1.setSelectedIndex(5);
        buttonPurchaseOrders.setBackground(Color.decode("#FFF3B0"));
    }//GEN-LAST:event_TxtButtPurchaseOrdersMouseClicked

    private void TxtButtPurchaseOrdersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtButtPurchaseOrdersMouseEntered
       buttonPurchaseOrders.setBackground(Color.decode("#FFF3B0"));
    }//GEN-LAST:event_TxtButtPurchaseOrdersMouseEntered

    private void TxtButtPurchaseOrdersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtButtPurchaseOrdersMouseExited
        buttonPurchaseOrders.setBackground(Color.decode("#E09F3E"));
    }//GEN-LAST:event_TxtButtPurchaseOrdersMouseExited

    private void txtPhoneNumberCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneNumberCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneNumberCActionPerformed

    private void txtCityCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCityCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCityCActionPerformed

    private void txtAdressCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdressCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdressCActionPerformed

    private void txtNitCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNitCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNitCActionPerformed

    private void txtEmailCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailCActionPerformed

    private void CreateCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateCMouseClicked
        if (!txtNitC.getText().isEmpty() && !txtCompanyNameC.getText().isEmpty() && !txtEmailC.getText().isEmpty() && !txtPhoneNumberC.getText().isEmpty() && !txtCityC.getText().isEmpty() && !txtAdressC.getText().isEmpty()) {
            nitC = Integer.parseInt(txtNitC.getText());
            if (!c.checkTableDataClients(nitC)) {
                cnameC = txtCompanyNameC.getText();
                emailC = txtEmailC.getText();
                phoneC = Long.parseLong(txtPhoneNumberC.getText());
                cityC = txtCityC.getText();
                adressC = txtAdressC.getText();
                c.createClient(nitC, cnameC, emailC, phoneC, cityC, adressC);
                JOptionPane.showMessageDialog(null, "The Client Was Successfully Recorded", "CLIENTS", JOptionPane.INFORMATION_MESSAGE);
                showJTableClients();
                cleanClients();
            } else {
                JOptionPane.showMessageDialog(null, "Nit " + nitC + " Already Exists", "CLIENTS", JOptionPane.ERROR_MESSAGE);
                txtNitC.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Missing Data to be Filled in", "CLIENTS", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_CreateCMouseClicked

    private void CreateCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateCMouseEntered
        ButtonCreateC.setBackground(Color.decode("#2e879f"));
    }//GEN-LAST:event_CreateCMouseEntered

    private void CreateCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateCMouseExited
        ButtonCreateC.setBackground(Color.decode("#335c67"));
    }//GEN-LAST:event_CreateCMouseExited

    private void UploadCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UploadCMouseClicked
        if (!txtNitC.getText().isEmpty() && !txtCompanyNameC.getText().isEmpty() && !txtEmailC.getText().isEmpty() && !txtPhoneNumberC.getText().isEmpty() && !txtCityC.getText().isEmpty() && !txtAdressC.getText().isEmpty()) {
            nitC = Integer.parseInt(txtNitC.getText());
            if (c.checkTableDataClients(nitC)) {
                cnameC = txtCompanyNameC.getText();
                emailC = txtEmailC.getText();
                phoneC = Long.parseLong(txtPhoneNumberC.getText());
                cityC = txtCityC.getText();
                adressC = txtAdressC.getText();
                c.uploadClient(nitC, cnameC, emailC, phoneC, cityC, adressC);
                JOptionPane.showMessageDialog(null, "The Client Was Successfully Updated", "CLIENTS", JOptionPane.INFORMATION_MESSAGE);
                showJTableClients();
                cleanClients();
            } else {
                JOptionPane.showMessageDialog(null, "Nit " + nitC + " Doesn't Exists", "CLIENTS", JOptionPane.ERROR_MESSAGE);
                txtNitC.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Missing Data to be Filled in", "CLIENTS", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_UploadCMouseClicked

    private void UploadCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UploadCMouseEntered
        ButtonUploadC.setBackground(Color.decode("#2e879f"));
    }//GEN-LAST:event_UploadCMouseEntered

    private void UploadCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UploadCMouseExited
        ButtonUploadC.setBackground(Color.decode("#335c67"));
    }//GEN-LAST:event_UploadCMouseExited

    private void CleanCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanCMouseClicked
        cleanClients();
    }//GEN-LAST:event_CleanCMouseClicked

    private void CleanCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanCMouseEntered
        ButtonCleanC.setBackground(Color.decode("#2e879f"));
    }//GEN-LAST:event_CleanCMouseEntered

    private void CleanCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanCMouseExited
        ButtonCleanC.setBackground(Color.decode("#335c67"));
    }//GEN-LAST:event_CleanCMouseExited

    private void DeleteCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteCMouseClicked
        if (!txtNitC.getText().isEmpty()) {
            nitC = Integer.parseInt(txtNitC.getText());
            if (c.checkTableDataClients(nitC)) {
                int res=0;
                res=JOptionPane.showConfirmDialog(null, "Are You Sure You Want to Delete The Client?", "CLIENTS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (res==JOptionPane.YES_OPTION) {
                    c.deleteClient(nitC);
                    JOptionPane.showMessageDialog(null, "The Client Was Successfully Deleted", "CLIENTS", JOptionPane.INFORMATION_MESSAGE);
                    showJTableClients();
                    cleanClients();
                }    
            }else{
                JOptionPane.showMessageDialog(null, "Nit " + nitC + " Doesn't Exists", "CLIENTS", JOptionPane.ERROR_MESSAGE);
                txtNitC.requestFocus();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Missing Data to be Filled in", "CLIENTS", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_DeleteCMouseClicked

    private void DeleteCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteCMouseEntered
        ButtonDeleteC.setBackground(Color.decode("#ba3233"));
    }//GEN-LAST:event_DeleteCMouseEntered

    private void DeleteCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteCMouseExited
        ButtonDeleteC.setBackground(Color.decode("#9E2A2B"));
    }//GEN-LAST:event_DeleteCMouseExited

    private void CreateSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateSMouseClicked
        if (!txtNitS.getText().isEmpty() && !txtCompanyNameS.getText().isEmpty() && !txtEmailS.getText().isEmpty() && !txtPhoneNumberS.getText().isEmpty() && !txtCityS.getText().isEmpty() && !txtAdressS.getText().isEmpty()) {
            nitS = Integer.parseInt(txtNitS.getText());
            if (!s.checkTableDataSuppliers(nitS)) {
                cnameS = txtCompanyNameS.getText();
                emailS = txtEmailS.getText();
                phoneS = Long.parseLong(txtPhoneNumberS.getText());
                cityS = txtCityS.getText();
                adressS = txtAdressS.getText();
                s.createSupplier(nitS, cnameS, emailS, phoneS, cityS, adressS);
                JOptionPane.showMessageDialog(null, "The Supplier Was Successfully Recorded", "SUPPLIERS", JOptionPane.INFORMATION_MESSAGE);
                showJTableSuppliers();
                cleanSuppliers();
            } else {
                JOptionPane.showMessageDialog(null, "Nit " + nitS + " Already Exists", "SUPPLIERS", JOptionPane.ERROR_MESSAGE);
                txtNitS.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Missing Data to be Filled in", "SUPPLIERS", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_CreateSMouseClicked

    private void CreateSMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateSMouseEntered
        ButtonCreateS.setBackground(Color.decode("#2e879f"));
    }//GEN-LAST:event_CreateSMouseEntered

    private void CreateSMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateSMouseExited
        ButtonCreateS.setBackground(Color.decode("#335c67"));
    }//GEN-LAST:event_CreateSMouseExited

    private void UploadSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UploadSMouseClicked
        if (!txtNitS.getText().isEmpty() && !txtCompanyNameS.getText().isEmpty() && !txtEmailS.getText().isEmpty() && !txtPhoneNumberS.getText().isEmpty() && !txtCityS.getText().isEmpty() && !txtAdressS.getText().isEmpty()) {
            nitS = Integer.parseInt(txtNitS.getText());
            if (s.checkTableDataSuppliers(nitS)) {
                cnameS = txtCompanyNameS.getText();
                emailS = txtEmailS.getText();
                phoneS = Long.parseLong(txtPhoneNumberS.getText());
                cityS = txtCityS.getText();
                adressS = txtAdressS.getText();
                s.uploadSupplier(nitS, cnameS, emailS, phoneS, cityS, adressS);
                JOptionPane.showMessageDialog(null, "The Supplier Was Successfully Updated", "SUPPLIERS", JOptionPane.INFORMATION_MESSAGE);
                showJTableSuppliers();
                cleanSuppliers();
            } else {
                JOptionPane.showMessageDialog(null, "Nit " + nitS + " Doesn't Exists", "SUPPLIERS", JOptionPane.ERROR_MESSAGE);
                txtNitS.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Missing Data to be Filled in", "SUPPLIERS", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_UploadSMouseClicked

    private void UploadSMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UploadSMouseEntered
        ButtonUploadS.setBackground(Color.decode("#2e879f"));
    }//GEN-LAST:event_UploadSMouseEntered

    private void UploadSMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UploadSMouseExited
        ButtonUploadS.setBackground(Color.decode("#335c67"));
    }//GEN-LAST:event_UploadSMouseExited

    private void CleanSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanSMouseClicked
        cleanSuppliers();
    }//GEN-LAST:event_CleanSMouseClicked

    private void CleanSMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanSMouseEntered
        ButtonCleanS.setBackground(Color.decode("#2e879f"));
    }//GEN-LAST:event_CleanSMouseEntered

    private void CleanSMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanSMouseExited
        ButtonCleanS.setBackground(Color.decode("#335c67"));
    }//GEN-LAST:event_CleanSMouseExited

    private void DeleteSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteSMouseClicked
        if (!txtNitS.getText().isEmpty()) {
            nitS = Integer.parseInt(txtNitS.getText());
            if (s.checkTableDataSuppliers(nitS)) {
                int res = 0;
                res = JOptionPane.showConfirmDialog(null, "Are You Sure You Want to Delete The Supplier?", "SUPPLIERS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (res == JOptionPane.YES_OPTION) {
                    s.deleteSupplier(nitS);
                    JOptionPane.showMessageDialog(null, "The Supplier Was Successfully Deleted", "SUPPLIERS", JOptionPane.INFORMATION_MESSAGE);
                    showJTableSuppliers();
                    cleanSuppliers();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nit " + nitS + " Doesn't Exists", "SUPPLIERS", JOptionPane.ERROR_MESSAGE);
                txtNitS.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Missing Data to be Filled in", "SUPPLIERS", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_DeleteSMouseClicked

    private void DeleteSMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteSMouseEntered
        ButtonDeleteS.setBackground(Color.decode("#ba3233"));
    }//GEN-LAST:event_DeleteSMouseEntered

    private void DeleteSMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteSMouseExited
        ButtonDeleteS.setBackground(Color.decode("#9E2A2B"));
    }//GEN-LAST:event_DeleteSMouseExited

    private void txtNitSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNitSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNitSActionPerformed

    private void txtPhoneNumberSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneNumberSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneNumberSActionPerformed

    private void txtCitySActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCitySActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCitySActionPerformed

    private void txtAdressSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdressSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdressSActionPerformed

    private void txtEmailSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailSActionPerformed

    private void CreatePMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreatePMouseClicked
        if (!txtIdP.getText().isEmpty() && !txtNameP.getText().isEmpty() && !txtWheightP.getText().isEmpty() && !txtStockP.getText().isEmpty() && !txtDatePurchaseP.getText().isEmpty() && !txtExpirationDateP.getText().isEmpty() && !txtPriceP.getText().isEmpty()) {
            idP = Integer.parseInt(txtIdP.getText());
            if (!p.checkTableDataProducts(idP)) {
                nameP = txtNameP.getText();
                wheightP = Double.parseDouble(txtWheightP.getText());
                stockP = Integer.parseInt(txtStockP.getText());
                purchaseP = txtDatePurchaseP.getText();
                expirationP = txtExpirationDateP.getText();
                priceP = Double.parseDouble(txtPriceP.getText());
                p.createProduct(idP, nameP, wheightP, stockP, purchaseP, expirationP, priceP);
                JOptionPane.showMessageDialog(null, "The Product Was Successfully Recorded", "PRODUCTS", JOptionPane.INFORMATION_MESSAGE);
                showJTableProducts();
                cleanProducts();
            } else {
                JOptionPane.showMessageDialog(null, "Id " + idP + " Already Exists", "PRODUCTS", JOptionPane.ERROR_MESSAGE);
                txtIdP.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Missing Data to be Filled in", "PRODUCTS", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_CreatePMouseClicked

    private void CreatePMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreatePMouseEntered
        ButtonCreateP.setBackground(Color.decode("#2e879f"));
    }//GEN-LAST:event_CreatePMouseEntered

    private void CreatePMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreatePMouseExited
       ButtonCreateP.setBackground(Color.decode("#335c67"));
    }//GEN-LAST:event_CreatePMouseExited

    private void UploadPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UploadPMouseClicked
        if (!txtIdP.getText().isEmpty() && !txtNameP.getText().isEmpty() && !txtWheightP.getText().isEmpty() && !txtStockP.getText().isEmpty() && !txtDatePurchaseP.getText().isEmpty() && !txtExpirationDateP.getText().isEmpty() && !txtPriceP.getText().isEmpty()) {
            idP = Integer.parseInt(txtIdP.getText());
            if (p.checkTableDataProducts(idP)) {
                nameP = txtNameP.getText();
                wheightP = Double.parseDouble(txtWheightP.getText());
                stockP = Integer.parseInt(txtStockP.getText());
                purchaseP = txtDatePurchaseP.getText();
                expirationP = txtExpirationDateP.getText();
                priceP = Double.parseDouble(txtPriceP.getText());
                p.uploadProduct(idP, nameP, wheightP, stockP, purchaseP, expirationP, priceP);
                JOptionPane.showMessageDialog(null, "The Product Was Successfully Updated", "PRODUCTS", JOptionPane.INFORMATION_MESSAGE);
                showJTableProducts();
                cleanProducts();
            } else {
                JOptionPane.showMessageDialog(null, "Id " + idP + " Doesn't Exists", "PRODUCTS", JOptionPane.ERROR_MESSAGE);
                txtIdP.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Missing Data to be Filled in", "PRODUCTS", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_UploadPMouseClicked

    private void UploadPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UploadPMouseEntered
        ButtonUploadP.setBackground(Color.decode("#2e879f"));
    }//GEN-LAST:event_UploadPMouseEntered

    private void UploadPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UploadPMouseExited
        ButtonUploadP.setBackground(Color.decode("#335c67"));
    }//GEN-LAST:event_UploadPMouseExited

    private void CleanPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanPMouseClicked
        cleanProducts();
    }//GEN-LAST:event_CleanPMouseClicked

    private void CleanPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanPMouseEntered
        ButtonCleanP.setBackground(Color.decode("#2e879f"));
    }//GEN-LAST:event_CleanPMouseEntered

    private void CleanPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanPMouseExited
        ButtonCleanP.setBackground(Color.decode("#335c67"));
    }//GEN-LAST:event_CleanPMouseExited

    private void DeletePMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeletePMouseClicked
        if (!txtIdP.getText().isEmpty()) {
            idP = Integer.parseInt(txtIdP.getText());
            if (p.checkTableDataProducts(idP)) {
                int res=0;
                res=JOptionPane.showConfirmDialog(null, "Are You Sure You Want to Delete The Product?", "PRODUCTS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (res==JOptionPane.YES_OPTION) {
                    p.deleteProduct(idP);
                    JOptionPane.showMessageDialog(null, "The Product Was Successfully Deleted", "PRODUCTS", JOptionPane.INFORMATION_MESSAGE);
                    showJTableProducts();
                    cleanProducts();
                }    
            }else{
                JOptionPane.showMessageDialog(null, "Id " + idP + " Doesn't Exists", "PRODUCTS", JOptionPane.ERROR_MESSAGE);
                txtIdP.requestFocus();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Missing Data to be Filled in", "PRODUCTS", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_DeletePMouseClicked

    private void DeletePMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeletePMouseEntered
        ButtonDeleteP.setBackground(Color.decode("#ba3233"));
    }//GEN-LAST:event_DeletePMouseEntered

    private void DeletePMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeletePMouseExited
        ButtonDeleteP.setBackground(Color.decode("#9E2A2B"));
    }//GEN-LAST:event_DeletePMouseExited

    private void txtIdPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdPActionPerformed

    private void txtStockPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockPActionPerformed

    private void txtDatePurchasePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDatePurchasePActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDatePurchasePActionPerformed

    private void txtExpirationDatePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtExpirationDatePActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtExpirationDatePActionPerformed

    private void txtWheightPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWheightPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWheightPActionPerformed

    private void txtPricePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPricePActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPricePActionPerformed

    private void txtIdPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdPNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdPNActionPerformed

    private void txtTotalPriceNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalPriceNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalPriceNActionPerformed

    private void txtAvailableStockNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAvailableStockNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAvailableStockNActionPerformed

    private void txtQuantityNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityNActionPerformed

    private void txtPricePNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPricePNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPricePNActionPerformed

    private void AddToCartNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddToCartNMouseClicked
        btnAddToCartN.setBackground(Color.decode("#ba3233"));
    }//GEN-LAST:event_AddToCartNMouseClicked

    private void AddToCartNMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddToCartNMouseEntered
        btnAddToCartN.setBackground(Color.decode("#ba3233"));
    }//GEN-LAST:event_AddToCartNMouseEntered

    private void AddToCartNMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddToCartNMouseExited
        btnAddToCartN.setBackground(Color.decode("#9E2A2B"));
    }//GEN-LAST:event_AddToCartNMouseExited

    private void TxtButtNewPurcharseOrderAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_TxtButtNewPurcharseOrderAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtButtNewPurcharseOrderAncestorAdded

    private void PrintPoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintPoMouseClicked
        btnPrintPo.setBackground(Color.decode("#2e879f"));
    }//GEN-LAST:event_PrintPoMouseClicked

    private void PrintPoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintPoMouseEntered
        btnPrintPo.setBackground(Color.decode("#2e879f"));
    }//GEN-LAST:event_PrintPoMouseEntered

    private void PrintPoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintPoMouseExited
        btnPrintPo.setBackground(Color.decode("#335c67"));
    }//GEN-LAST:event_PrintPoMouseExited

    private void PlaceOrderNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlaceOrderNMouseClicked
        btnPlaceOrderN.setBackground(Color.decode("#2e879f"));
    }//GEN-LAST:event_PlaceOrderNMouseClicked

    private void PlaceOrderNMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlaceOrderNMouseEntered
        btnPlaceOrderN.setBackground(Color.decode("#2e879f"));
    }//GEN-LAST:event_PlaceOrderNMouseEntered

    private void PlaceOrderNMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlaceOrderNMouseExited
        btnPlaceOrderN.setBackground(Color.decode("#335c67"));
    }//GEN-LAST:event_PlaceOrderNMouseExited

    private void jTableSuppliersMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSuppliersMousePressed
        int selectedRow = jTableSuppliers.rowAtPoint(evt.getPoint());

        txtNitS.setText(jTableSuppliers.getValueAt(selectedRow, 0).toString());
        txtCompanyNameS.setText(jTableSuppliers.getValueAt(selectedRow, 1).toString());
        txtEmailS.setText(jTableSuppliers.getValueAt(selectedRow, 2).toString());
        txtPhoneNumberS.setText(jTableSuppliers.getValueAt(selectedRow, 3).toString());
        txtCityS.setText(jTableSuppliers.getValueAt(selectedRow, 4).toString());
        txtAdressS.setText(jTableSuppliers.getValueAt(selectedRow, 5).toString());
    }//GEN-LAST:event_jTableSuppliersMousePressed

    private void txtSearchSuppliersKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchSuppliersKeyReleased
        showJTableSuppliersFiltered(txtSearchSuppliers.getText());
    }//GEN-LAST:event_txtSearchSuppliersKeyReleased

    private void txtNitSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNitSKeyTyped
        char validar = evt.getKeyChar(); //Validar que sea solo número
        if (Character.isLetter(validar)) {
            getToolkit();
            evt.consume();
        }
    }//GEN-LAST:event_txtNitSKeyTyped

    private void txtAdressSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdressSKeyTyped
        
    }//GEN-LAST:event_txtAdressSKeyTyped

    private void txtPhoneNumberSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneNumberSKeyTyped
        char validar = evt.getKeyChar(); //Validar que sea solo número
        if (Character.isLetter(validar)) {
            getToolkit();
            evt.consume();
        }
    }//GEN-LAST:event_txtPhoneNumberSKeyTyped

    private void jTableProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductsMouseClicked
        int selectedRow = jTableProducts.rowAtPoint(evt.getPoint());

        txtIdP.setText(jTableProducts.getValueAt(selectedRow, 0).toString());
        txtNameP.setText(jTableProducts.getValueAt(selectedRow, 1).toString());
        txtWheightP.setText(jTableProducts.getValueAt(selectedRow, 2).toString());
        txtStockP.setText(jTableProducts.getValueAt(selectedRow, 3).toString());
        txtDatePurchaseP.setText(jTableProducts.getValueAt(selectedRow, 4).toString());
        txtExpirationDateP.setText(jTableProducts.getValueAt(selectedRow, 5).toString());
        txtPriceP.setText(jTableProducts.getValueAt(selectedRow, 6).toString());
    }//GEN-LAST:event_jTableProductsMouseClicked

    private void jTableClientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClientsMouseClicked
        int selectedRow = jTableClients.rowAtPoint(evt.getPoint());

        txtNitC.setText(jTableClients.getValueAt(selectedRow, 0).toString());
        txtCompanyNameC.setText(jTableClients.getValueAt(selectedRow, 1).toString());
        txtEmailC.setText(jTableClients.getValueAt(selectedRow, 2).toString());
        txtPhoneNumberC.setText(jTableClients.getValueAt(selectedRow, 3).toString());
        txtCityC.setText(jTableClients.getValueAt(selectedRow, 4).toString());
        txtAdressC.setText(jTableClients.getValueAt(selectedRow, 5).toString());
    }//GEN-LAST:event_jTableClientsMouseClicked

    private void txtSearchClientsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchClientsKeyTyped
        showJTableClientsFiltered(txtSearchClients.getText());
    }//GEN-LAST:event_txtSearchClientsKeyTyped

    private void txtSearchProductsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchProductsKeyTyped
        showJTableProductsFiltered(txtSearchProducts.getText());
    }//GEN-LAST:event_txtSearchProductsKeyTyped

    private void txtNitCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNitCKeyTyped
        char validar = evt.getKeyChar(); //Validar que sea solo número
        if (Character.isLetter(validar)) {
            getToolkit();
            evt.consume();
        }
    }//GEN-LAST:event_txtNitCKeyTyped

    private void txtPhoneNumberCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneNumberCKeyTyped
        char validar = evt.getKeyChar(); //Validar que sea solo número
        if (Character.isLetter(validar)) {
            getToolkit();
            evt.consume();
        }
    }//GEN-LAST:event_txtPhoneNumberCKeyTyped

    private void txtIdPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdPKeyTyped
        char validar = evt.getKeyChar(); //Validar que sea solo número
        if (Character.isLetter(validar)) {
            getToolkit();
            evt.consume();
        }
    }//GEN-LAST:event_txtIdPKeyTyped

    private void txtStockPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockPKeyTyped
        char validar = evt.getKeyChar(); //Validar que sea solo número
        if (Character.isLetter(validar)) {
            getToolkit();
            evt.consume();
        }
    }//GEN-LAST:event_txtStockPKeyTyped

    private void txtPricePKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPricePKeyTyped
        char validar = evt.getKeyChar(); //Validar que sea solo número
        if (Character.isLetter(validar)) {
            getToolkit();
            evt.consume();
        }
    }//GEN-LAST:event_txtPricePKeyTyped

    private void txtWheightPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtWheightPKeyTyped
        char validar = evt.getKeyChar(); //Validar que sea solo número
        if (Character.isLetter(validar)) {
            getToolkit();
            evt.consume();
        }
    }//GEN-LAST:event_txtWheightPKeyTyped

    private void txtSearchClientsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchClientsMousePressed
        txtSearchClients.setText("");
    }//GEN-LAST:event_txtSearchClientsMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }
    
    public void logout(){
        this.setVisible(false);
        new Login().setVisible(true);
        stopTimer();
    } 
    
    public void session(){
        stopTimer();
        t = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logout();
            }
        });
        t.start();
    }
    
    public void stopTimer(){
        if(t != null){
            t.stop();
        }
    }
    
    public void userInteraction(){
        session();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddToCartN;
    private javax.swing.JLabel AddressClients;
    private javax.swing.JLabel AddressS;
    private javax.swing.JLabel AvailableStockN;
    private Images.PanelRound ButtonCleanC;
    private Images.PanelRound ButtonCleanP;
    private Images.PanelRound ButtonCleanS;
    private Images.PanelRound ButtonCreateC;
    private Images.PanelRound ButtonCreateP;
    private Images.PanelRound ButtonCreateS;
    private Images.PanelRound ButtonDeleteC;
    private Images.PanelRound ButtonDeleteP;
    private Images.PanelRound ButtonDeleteS;
    private Images.PanelRound ButtonUploadC;
    private Images.PanelRound ButtonUploadP;
    private Images.PanelRound ButtonUploadS;
    private javax.swing.JLabel CartN;
    private javax.swing.JLabel CityClients;
    private javax.swing.JLabel CityS;
    private javax.swing.JLabel CleanC;
    private javax.swing.JLabel CleanP;
    private javax.swing.JLabel CleanS;
    private javax.swing.JLabel ClientN;
    private javax.swing.JPanel ClientsInterface;
    private javax.swing.JLabel CompanyNameClients;
    private javax.swing.JLabel CompanyNameClients4;
    private javax.swing.JLabel CompanyNameS;
    private javax.swing.JLabel CreateC;
    private javax.swing.JLabel CreateP;
    private javax.swing.JLabel CreateS;
    private javax.swing.JLabel DatePurchase;
    private javax.swing.JLabel DeleteC;
    private javax.swing.JLabel DeleteP;
    private javax.swing.JLabel DeleteS;
    private javax.swing.JLabel EmailClients;
    private javax.swing.JLabel EmailS;
    private javax.swing.JLabel ExitIcon;
    private javax.swing.JLabel ExpirationDate;
    private Images.PanelRound Header;
    private javax.swing.JLabel IdN;
    private javax.swing.JLabel IdP;
    private javax.swing.JScrollPane JScrollPaneN;
    private javax.swing.JLabel LoupeClients;
    private javax.swing.JLabel LoupeN;
    private javax.swing.JLabel LoupeP;
    private javax.swing.JLabel LoupePo;
    private javax.swing.JLabel LoupeS;
    private javax.swing.JLabel NameProductP;
    private javax.swing.JLabel NameTableClients;
    private javax.swing.JLabel NameTableN;
    private javax.swing.JLabel NameTableP;
    private javax.swing.JLabel NameTableP1;
    private javax.swing.JLabel NameTableSuppliers;
    private javax.swing.JPanel NewPurchaseOrderInterface;
    private javax.swing.JLabel NitClients;
    private javax.swing.JLabel NitS;
    private javax.swing.JLabel PhoneNumber;
    private javax.swing.JLabel PhoneNumberS;
    private javax.swing.JLabel PlaceOrderN;
    private javax.swing.JLabel PriceN;
    private javax.swing.JLabel PriceP;
    private javax.swing.JLabel PrintPo;
    private javax.swing.JLabel ProductN;
    private javax.swing.JPanel ProductsInterface;
    private javax.swing.JPanel PurchaseOrdersInterface;
    private javax.swing.JLabel QuantityNsus;
    private javax.swing.JLabel StockP;
    private javax.swing.JPanel SuppliersInterface;
    private javax.swing.JLabel TotalPriceN;
    private javax.swing.JLabel TxtButtClients;
    private javax.swing.JLabel TxtButtNewPurcharseOrder;
    private javax.swing.JLabel TxtButtProducts;
    private javax.swing.JLabel TxtButtPurchaseOrders;
    private javax.swing.JLabel TxtSuppliers;
    private javax.swing.JLabel UploadC;
    private javax.swing.JLabel UploadP;
    private javax.swing.JLabel UploadS;
    private javax.swing.JLabel UserIcon;
    private javax.swing.JPanel Welcome;
    private javax.swing.JLabel WheightP;
    private Images.PanelRound btnAddToCartN;
    private Images.PanelRound btnPlaceOrderN;
    private Images.PanelRound btnPrintPo;
    private Images.PanelRound buttonClients;
    private Images.PanelRound buttonNewPurchaseOrder;
    private Images.PanelRound buttonProducts;
    private Images.PanelRound buttonPurchaseOrders;
    private Images.PanelRound buttonSuppliers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPaneC;
    private javax.swing.JScrollPane jScrollPaneP;
    private javax.swing.JScrollPane jScrollPaneP1;
    private javax.swing.JScrollPane jScrollPaneS;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableClients;
    private javax.swing.JTable jTableNewOrder;
    private javax.swing.JTable jTableProducts;
    private javax.swing.JTable jTablePurchaseOrders;
    private javax.swing.JTable jTableSuppliers;
    private javax.swing.JLabel logo;
    private javax.swing.JTextField nRol;
    private javax.swing.JTextField nUsuario;
    private Images.PanelRound panelRound1;
    private Images.PanelRound panelRound2;
    private javax.swing.JPanel sidebar;
    private javax.swing.JTextField txtAdressC;
    private javax.swing.JTextField txtAdressS;
    private javax.swing.JTextField txtAvailableStockN;
    private javax.swing.JTextField txtCityC;
    private javax.swing.JTextField txtCityS;
    private javax.swing.JTextField txtClientN;
    private javax.swing.JTextField txtCompanyNameC;
    private javax.swing.JTextField txtCompanyNameS;
    private javax.swing.JTextField txtDatePurchaseP;
    private javax.swing.JTextField txtEmailC;
    private javax.swing.JTextField txtEmailS;
    private javax.swing.JTextField txtExpirationDateP;
    private javax.swing.JTextField txtIdP;
    private javax.swing.JTextField txtIdPN;
    private javax.swing.JTextField txtNameN;
    private javax.swing.JTextField txtNameP;
    private javax.swing.JTextField txtNitC;
    private javax.swing.JTextField txtNitS;
    private javax.swing.JTextField txtPhoneNumberC;
    private javax.swing.JTextField txtPhoneNumberS;
    private javax.swing.JTextField txtPriceP;
    private javax.swing.JTextField txtPricePN;
    private javax.swing.JTextField txtProductPN;
    private javax.swing.JTextField txtQuantityN;
    private javax.swing.JTextField txtSearchClients;
    private javax.swing.JTextField txtSearchP1;
    private javax.swing.JTextField txtSearchProducts;
    private javax.swing.JTextField txtSearchSuppliers;
    private javax.swing.JTextField txtStockP;
    private javax.swing.JTextField txtTotalPriceN;
    private javax.swing.JTextField txtWheightP;
    // End of variables declaration//GEN-END:variables

    private void ListarCliente() {
        
    }
}
