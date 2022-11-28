package Controller;

import DataBase.ConnectionDB;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Prueba extends javax.swing.JFrame {

    ConnectionDB cc = new ConnectionDB();
    Connection con = cc.connection();

    //---Suppliers---//
    Suppliers s = new Suppliers();
    int nitS = 0;
    long phoneS = 0;
    String cnameS = "", emailS = "", cityS = "", adressS = "";

    //---Clients---//
    Clients c = new Clients();
    int nitC = 0;
    long phoneC = 0;
    String cnameC = "", emailC = "", cityC = "", adressC = "";

    //---Products---//
    Products p = new Products();
    int idP = 0, stockP = 0;
    double wheightP = 0, priceP = 0;
    String nameP = "";
    Date purchaseP, expirationP;

    //---NewOrder---//
    NewOrder n = new NewOrder();
    int IdP = 0;
    String NameP = "";
    public double QuantityPO = 0, PriceP = 0, TotalPO = 0;

    //---PurchaseOrders---//
    PurchaseOrders po = new PurchaseOrders();
    int IdO = 0;
    String CompanyNameC = "", NameA = "";
    double TotalO = 0;

    public Prueba() {
        initComponents();
        this.setLocationRelativeTo(null); //Al ejecutar, centrar en la pantalla
        showJTableSuppliers();
        showJTableClients();
        showJTableProducts();
        showJTableNewOrder();
        showJTablePurchaseOrders();
    }

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

            String SQL = "select * from purchaseorders where CodeO like '%" + value + "%'";
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtNitS = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCompanyNameS = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEmailS = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPhoneNumberS = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCityS = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtAdressS = new javax.swing.JTextField();
        btnClean = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpload = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSuppliers = new javax.swing.JTable();
        txtSearchSuppliers = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Nit: ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 50, 30));

        txtNitS.setBackground(new java.awt.Color(255, 255, 255));
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
        jPanel1.add(txtNitS, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 180, 30));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Company Name:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 20));

        txtCompanyNameS.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtCompanyNameS, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 180, 30));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Email:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        txtEmailS.setBackground(new java.awt.Color(255, 255, 255));
        txtEmailS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailSActionPerformed(evt);
            }
        });
        jPanel1.add(txtEmailS, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 180, 30));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Phone number:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, 20));

        txtPhoneNumberS.setBackground(new java.awt.Color(255, 255, 255));
        txtPhoneNumberS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhoneNumberSKeyTyped(evt);
            }
        });
        jPanel1.add(txtPhoneNumberS, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 180, 30));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("City:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, 20));

        txtCityS.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtCityS, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 180, 30));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Adress:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, 20));

        txtAdressS.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtAdressS, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 180, 30));

        btnClean.setText("Clean");
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });
        jPanel1.add(btnClean, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 370, -1, -1));

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        jPanel1.add(btnCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, -1, -1));

        btnUpload.setText("Upload");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpload, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, -1, -1));

        jTableSuppliers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSuppliersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableSuppliers);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 380, 220));

        txtSearchSuppliers.setBackground(new java.awt.Color(255, 255, 255));
        txtSearchSuppliers.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchSuppliersKeyReleased(evt);
            }
        });
        jPanel1.add(txtSearchSuppliers, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 260, -1));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Search by name:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 100, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNitSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNitSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNitSActionPerformed

    private void txtEmailSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailSActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
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
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        cleanSuppliers();
    }//GEN-LAST:event_btnCleanActionPerformed

    private void jTableSuppliersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSuppliersMouseClicked

    }//GEN-LAST:event_jTableSuppliersMouseClicked

    private void jTableSuppliersMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSuppliersMousePressed
        int selectedRow = jTableSuppliers.rowAtPoint(evt.getPoint());

        txtNitS.setText(jTableSuppliers.getValueAt(selectedRow, 0).toString());
        txtCompanyNameS.setText(jTableSuppliers.getValueAt(selectedRow, 1).toString());
        txtEmailS.setText(jTableSuppliers.getValueAt(selectedRow, 2).toString());
        txtPhoneNumberS.setText(jTableSuppliers.getValueAt(selectedRow, 3).toString());
        txtCityS.setText(jTableSuppliers.getValueAt(selectedRow, 4).toString());
        txtAdressS.setText(jTableSuppliers.getValueAt(selectedRow, 5).toString());
    }//GEN-LAST:event_jTableSuppliersMousePressed

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
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
    }//GEN-LAST:event_btnUploadActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
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
    }//GEN-LAST:event_btnDeleteActionPerformed

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

    private void txtPhoneNumberSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneNumberSKeyTyped
        char validar = evt.getKeyChar(); //Validar que sea solo número
        if (Character.isLetter(validar)) {
            getToolkit();
            evt.consume();
        }
    }//GEN-LAST:event_txtPhoneNumberSKeyTyped

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
            java.util.logging.Logger.getLogger(Prueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Prueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Prueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Prueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Prueba().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpload;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSuppliers;
    private javax.swing.JTextField txtAdressS;
    private javax.swing.JTextField txtCityS;
    private javax.swing.JTextField txtCompanyNameS;
    private javax.swing.JTextField txtEmailS;
    private javax.swing.JTextField txtNitS;
    private javax.swing.JTextField txtPhoneNumberS;
    private javax.swing.JTextField txtSearchSuppliers;
    // End of variables declaration//GEN-END:variables
}
