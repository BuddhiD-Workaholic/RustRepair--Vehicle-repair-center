package FrontEnd;

import Model.Customer;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CustomerSignUp_Manager extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public CustomerSignUp_Manager() {
        initComponents();
        show_parts();
    }

    public ArrayList<Customer> userList() {
        ArrayList<Customer> userList = new ArrayList<>();
        try {
            String sq = "SELECT * FROM customer";

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_rustrepair", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sq);

            Customer customer;
            while (rs.next()) {
                customer = new Customer(rs.getInt("Cus_ID"), rs.getString("Name"), rs.getString("NIC"), rs.getString("Email"), rs.getString("Address"));
                userList.add(customer);
            }

        } catch (Exception Ex) {
            JOptionPane.showMessageDialog(null, Ex);
        }
        return userList;
    }

    public void show_parts() {
        ArrayList<Customer> list = userList();
        DefaultTableModel model = (DefaultTableModel) CuMGTable.getModel();
        Object[] row = new Object[5];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getCustomerID();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getNIC();
            row[3] = list.get(i).getEmail();
            row[4] = list.get(i).getAddress();
            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        CIDFileld = new javax.swing.JTextField();
        txtCNAme = new javax.swing.JTextField();
        txtCAddress = new javax.swing.JTextField();
        txtCEMail = new javax.swing.JTextField();
        txtNIC = new javax.swing.JTextField();
        Close = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        CuMGTable = new javax.swing.JTable();
        Update = new javax.swing.JButton();
        Delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(209, 250, 250));

        jLabel1.setText("Customer ID");

        jLabel2.setFont(new java.awt.Font("Vani", 0, 18)); // NOI18N
        jLabel2.setText("Customer Details");

        jLabel3.setText("Customer Name");

        jLabel4.setText("Address");

        jLabel6.setText("E-Mail");

        jLabel7.setText("NIC");

        Close.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Close.setText("Close");
        Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });

        CuMGTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer ID", "Name", "NIC", "E-Mail", "Address"
            }
        ));
        CuMGTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CuMGTableMouseClicked(evt);
            }
        });
        CuMGTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CuMGTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(CuMGTable);

        Update.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        Delete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CIDFileld, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtNIC))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtCEMail))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtCAddress))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCNAme, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Close, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Close, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CIDFileld, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCNAme, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCEMail, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNIC, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
        new ManagerInterface().setVisible(true);
        dispose();
    }//GEN-LAST:event_CloseActionPerformed

    private void CuMGTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CuMGTableMouseClicked
        int Row = CuMGTable.getSelectedRow();
        String selection = CuMGTable.getModel().getValueAt(Row, 0).toString();
        String sl = "SELECT * FROM customer WHERE Cus_ID = " + selection;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_rustrepair", "root", "");
            pst = con.prepareStatement(sl);
            rs = pst.executeQuery();
            if (rs.next()) {
                CIDFileld.setText(rs.getString("Cus_ID"));
                txtCNAme.setText(rs.getString("Name"));
                txtNIC.setText(rs.getString("NIC"));
                txtCEMail.setText(rs.getString("Email"));
                txtCAddress.setText(rs.getString("Address"));
            }

        } catch (Exception Ex) {
            JOptionPane.showMessageDialog(null, Ex);
        }
    }//GEN-LAST:event_CuMGTableMouseClicked

    private void CuMGTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CuMGTableKeyReleased
        int Row = CuMGTable.getSelectedRow();
        String selection = CuMGTable.getModel().getValueAt(Row, 0).toString();
        String sl = "SELECT * FROM customer WHERE Cus_ID = " + selection;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_rustrepair", "root", "");
            pst = con.prepareStatement(sl);
            rs = pst.executeQuery();
            if (rs.next()) {
                CIDFileld.setText(rs.getString("Cus_ID"));
                txtCNAme.setText(rs.getString("Name"));
                txtNIC.setText(rs.getString("NIC"));
                txtCEMail.setText(rs.getString("Email"));
                txtCAddress.setText(rs.getString("Address"));
            }

        } catch (Exception Ex) {
            JOptionPane.showMessageDialog(null, Ex);
        }
    }//GEN-LAST:event_CuMGTableKeyReleased

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        try {
            String sql = "UPDATE customer SET Cus_ID=?,Name=?,NIC=?,EMail=?,Address=? WHERE Cus_ID=?";

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_rustrepair", "root", "");
            pst = con.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(CIDFileld.getText()));
            pst.setString(2, txtCNAme.getText());
            pst.setString(3, txtNIC.getText());
            pst.setString(4, txtCEMail.getText());
            pst.setString(5, txtCAddress.getText());
            pst.setInt(6, Integer.parseInt(CIDFileld.getText()));
            pst.executeUpdate();

            DefaultTableModel model = (DefaultTableModel) CuMGTable.getModel();
            model.setRowCount(0);
            show_parts();

            JOptionPane.showMessageDialog(rootPane, "Customer Details are Sucesfully Updated");

        } catch (HeadlessException | SQLException Ex) {
            JOptionPane.showMessageDialog(null, Ex);
        }
    }//GEN-LAST:event_UpdateActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        try {
            String sql = "DELETE FROM customer WHERE Cus_ID= ?";

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_rustrepair", "root", "");
            pst = con.prepareStatement(sql);
            pst.setString(1, CIDFileld.getText());
            pst.executeUpdate();

            DefaultTableModel model = (DefaultTableModel) CuMGTable.getModel();
            model.setRowCount(0);
            show_parts();

            JOptionPane.showMessageDialog(rootPane, "Customer Details are Sucesfully Deleted");

        } catch (HeadlessException | NumberFormatException | SQLException Ex) {
            JOptionPane.showMessageDialog(null, Ex);
        }
    }//GEN-LAST:event_DeleteActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerSignUp_Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerSignUp_Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerSignUp_Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerSignUp_Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerSignUp_Manager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CIDFileld;
    private javax.swing.JButton Close;
    private javax.swing.JTable CuMGTable;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCAddress;
    private javax.swing.JTextField txtCEMail;
    private javax.swing.JTextField txtCNAme;
    private javax.swing.JTextField txtNIC;
    // End of variables declaration//GEN-END:variables
}
