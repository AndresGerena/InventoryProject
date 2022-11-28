package Interfaces;
import Images.Escala;
import java.awt.Color;

public class Login extends javax.swing.JFrame {
   
    
    Escala escala = new Escala();

    public Login() {   
        initComponents();
        this.setLocationRelativeTo(null);
        escala.escalarLabel(jLabel5, "/Images/Fondo - 2.jpg");
        escala.escalarLabel(jLabel4, "/Images/LOGO-ETITC.png");
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new Images.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        buttonSignIn = new Images.PanelRound();
        TxtSignIn = new javax.swing.JLabel();
        panelRound2 = new Images.PanelRound();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setBackground(new java.awt.Color(84, 11, 14));
        panelRound1.setRoundBottomLeft(30);
        panelRound1.setRoundBottomRight(30);
        panelRound1.setRoundTopLeft(30);
        panelRound1.setRoundTopRight(30);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("USER");
        panelRound1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 50, 20));

        jLabel2.setBackground(new java.awt.Color(240, 68, 209));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/perrologin-2.png"))); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 100));
        panelRound1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 150, 140));
        panelRound1.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 210, 20));

        jLabel3.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PASSWORD");
        panelRound1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 100, 20));
        panelRound1.add(txtuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 210, -1));

        buttonSignIn.setBackground(new java.awt.Color(224, 159, 62));
        buttonSignIn.setRoundBottomLeft(10);
        buttonSignIn.setRoundBottomRight(10);
        buttonSignIn.setRoundTopLeft(10);
        buttonSignIn.setRoundTopRight(10);
        buttonSignIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSignInMouseClicked(evt);
            }
        });
        buttonSignIn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TxtSignIn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TxtSignIn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TxtSignIn.setText("SIGN IN");
        TxtSignIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TxtSignIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TxtSignInMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TxtSignInMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TxtSignInMouseExited(evt);
            }
        });
        buttonSignIn.add(TxtSignIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        panelRound1.add(buttonSignIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, -1, -1));

        getContentPane().add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 290, 360));

        panelRound2.setBackground(new java.awt.Color(0, 0, 0));
        panelRound2.setRoundBottomLeft(30);
        panelRound2.setRoundBottomRight(30);
        panelRound2.setRoundTopLeft(30);
        panelRound2.setRoundTopRight(30);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 45, 290, 360));

        jLabel4.setBackground(new java.awt.Color(255, 0, 204));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LOGO-ETITC.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 110, 110));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Fondo - 2.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtSignInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtSignInMouseClicked
        new Home().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_TxtSignInMouseClicked

    private void TxtSignInMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtSignInMouseEntered
        buttonSignIn.setBackground(Color.decode("#FFF3B0"));
    }//GEN-LAST:event_TxtSignInMouseEntered

    private void buttonSignInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSignInMouseClicked
        buttonSignIn.setBackground(Color.decode("#FFF3B0"));
    }//GEN-LAST:event_buttonSignInMouseClicked

    private void TxtSignInMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtSignInMouseExited
        buttonSignIn.setBackground(Color.decode("#E09F3E"));
    }//GEN-LAST:event_TxtSignInMouseExited

    /**
     * @param args the command line arguments
     */
    public static void login(String args[]) {
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
     
        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TxtSignIn;
    private Images.PanelRound buttonSignIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private Images.PanelRound panelRound1;
    private Images.PanelRound panelRound2;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}