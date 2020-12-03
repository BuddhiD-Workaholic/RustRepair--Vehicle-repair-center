package FrontEnd;

import java.sql.*;
import javax.swing.JOptionPane;

public class LoginPage extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String JobType = "Restoration Job/Repir Job";
    float Servicecost = 30000;

    public LoginPage() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        EIDFileld = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ELoginButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        PasswordField = new javax.swing.JPasswordField();
        CheckBoxShow = new javax.swing.JCheckBox();
        NewEmployee = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(209, 250, 250));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Employee ID  :");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Password      : ");

        jLabel3.setFont(new java.awt.Font("Traditional Arabic", 0, 28)); // NOI18N
        jLabel3.setText("RustRepair - Vehicle repair center");

        ELoginButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ELoginButton.setText("Login");
        ELoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ELoginButtonActionPerformed(evt);
            }
        });

        CancelButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        CheckBoxShow.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CheckBoxShow.setText("Show Password");
        CheckBoxShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxShowActionPerformed(evt);
            }
        });

        NewEmployee.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        NewEmployee.setText("New Employee?  Click here to create a new Employee account");
        NewEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NewEmployeeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(ELoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(236, 236, 236))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NewEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PasswordField)
                            .addComponent(EIDFileld))
                        .addGap(22, 22, 22)
                        .addComponent(CheckBoxShow)
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(174, 174, 174))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EIDFileld, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CheckBoxShow, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ELoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(NewEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void ELoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ELoginButtonActionPerformed
        String EmployeeID = EIDFileld.getText();
        int x = 1;

        int IDlength = EmployeeID.length();
        String SubID = EmployeeID.substring(0, 2);
        if (IDlength == 5) {
            x = 1;
        } else {
            JOptionPane.showMessageDialog(rootPane, "Invalied EmployeeID! Employee ID should contain 5 Chracters! 1st two Chracters should contain: \n RE(Receptionist) \n ME(Mechanic) \n MG(Manager)");
            x = 0;
        }

        String EmpPassword = PasswordField.getText();
        int PLength = EmpPassword.length();
        if (PLength == 8) {
        } else {
            JOptionPane.showMessageDialog(rootPane, "Invalied Password!  Password lngth must be 8 charcters");
            x = 0;
        }

        if (x == 1) {

            try {
                String sql = "SELECT * FROM employee WHERE EmployeeID=?";

                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_rustrepair", "root", "");
                pst = con.prepareStatement(sql);
                pst.setString(1, EmployeeID);
                rs = pst.executeQuery();
                if (rs.next()) {
                    String password = rs.getString("Password");
                    if (EmpPassword.equals(password)) {
                        if (SubID.equals("RE")) {
                            new ReceptionistInterface().setVisible(true);
                            dispose();
                        } else if (SubID.equals("ME")) {
                            new MechanicInterface().setVisible(true);
                            dispose();
                        } else if (SubID.equals("MG")) {
                            new ManagerInterface().setVisible(true);
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Invalied EmployeeID! Employee ID should contain 5 Chracters! 1st two Chracters should contain: \n RE(Receptionist) \n ME(Mechanic) \n MG(Manager)");
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Password not found!" + "/n" + "Login Error!");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Username not found!" + "/n" + "Login Error!");
                }

            } catch (SQLException Ex) {
                JOptionPane.showMessageDialog(null, Ex);
            }

        }
    }//GEN-LAST:event_ELoginButtonActionPerformed

    private void CheckBoxShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxShowActionPerformed
        if (CheckBoxShow.isSelected()) {
            PasswordField.setEchoChar((char) 0);
        } else {
            PasswordField.setEchoChar('*');
        }
    }//GEN-LAST:event_CheckBoxShowActionPerformed

    private void NewEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewEmployeeMouseClicked
        new NewEmployeeSignup().setVisible(true);
        dispose();
    }//GEN-LAST:event_NewEmployeeMouseClicked

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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JCheckBox CheckBoxShow;
    private javax.swing.JTextField EIDFileld;
    private javax.swing.JButton ELoginButton;
    private javax.swing.JLabel NewEmployee;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
