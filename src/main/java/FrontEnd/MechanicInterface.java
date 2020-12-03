package FrontEnd;

import Model.Parts;
import Utility.JavaMailSupplier;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MechanicInterface extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public MechanicInterface() {
        initComponents();
        combobox();
        show_parts();
    }
//ComboBox  

    private void combobox() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_rustrepair", "root", "");
            String sql1 = "SELECT * FROM supplier";
            pst = con.prepareStatement(sql1);
            rs = pst.executeQuery();
            while (rs.next()) {
                String SID = rs.getString("SupplierID");
                txtSIDbox1.addItem(SID);
            }

        } catch (SQLException Ex) {
            JOptionPane.showMessageDialog(null, Ex);
        }
    }

//ArrayList
    public ArrayList<Parts> userList() {
        ArrayList<Parts> userList = new ArrayList<>();
        try {
            String sq1 = "SELECT * FROM parts";

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_rustrepair", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sq1);

            Parts parts;
            while (rs.next()) {
                parts = new Parts(rs.getInt("PartsID"), rs.getString("PName"), rs.getInt("Quantity"), rs.getInt("SupplierID"), rs.getFloat("Price"));
                userList.add(parts);
            }

        } catch (SQLException Ex) {
            JOptionPane.showMessageDialog(null, Ex);
        }
        return userList;
    }

    public void show_parts() {
        ArrayList<Parts> list = userList();
        DefaultTableModel model = (DefaultTableModel) METable.getModel();
        Object[] row = new Object[5];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getPartsID();
            row[1] = list.get(i).getPartName();
            row[2] = list.get(i).getQuantity();
            row[3] = list.get(i).getSupplierID();
            row[4] = list.get(i).getPrice();
            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Delete = new javax.swing.JButton();
        Add = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        txtPartID = new javax.swing.JTextField();
        txtPartName = new javax.swing.JTextField();
        txtQuatity = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        Close1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        METable = new javax.swing.JTable();
        StatusPage = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtSIDbox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(209, 250, 250));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel2.setText("Part ID                :");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel3.setText("Part Name          :");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel4.setText("Quantity             :");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel5.setText("Price                  :");

        Delete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        Add.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Add.setText("Add");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        Update.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        txtPartID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPartIDActionPerformed(evt);
            }
        });

        txtPartName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPartNameActionPerformed(evt);
            }
        });

        Close1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Close1.setText("Close");
        Close1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Close1ActionPerformed(evt);
            }
        });

        METable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Part ID", "Part Name", "Supplier ID", "Quantity", "Price"
            }
        ));
        METable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                METableMouseClicked(evt);
            }
        });
        METable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                METableKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(METable);

        StatusPage.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        StatusPage.setText("Job Status");
        StatusPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatusPageActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel6.setText("Supplier ID         :");

        txtSIDbox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Item" }));

        jLabel7.setFont(new java.awt.Font("Vani", 0, 18)); // NOI18N
        jLabel7.setText("Mechanic Interface");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(2, 2, 2)
                                            .addComponent(jLabel3)))
                                    .addGap(16, 16, 16)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtPartID)
                                        .addComponent(txtPartName, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtSIDbox1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel5))
                                            .addGap(16, 16, 16)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtPrice)
                                                .addComponent(txtQuatity, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(StatusPage, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Close1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPartID, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPartName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSIDbox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQuatity, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StatusPage, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Close1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        try {
            String sql = "INSERT INTO parts"
                    + "(PartsID, PName, Quantity, SupplierID, Price)"
                    + "VALUES (?,?,?,?,?)";

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_rustrepair", "root", "");
            pst = con.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(txtPartID.getText()));
            pst.setString(2, txtPartName.getText());
            pst.setInt(3, Integer.parseInt(txtQuatity.getText()));
            String value1 = txtSIDbox1.getSelectedItem().toString();
            pst.setInt(4, Integer.parseInt(value1));
            pst.setFloat(5, Float.parseFloat(txtPrice.getText()));
            pst.executeUpdate();

            DefaultTableModel model = (DefaultTableModel) METable.getModel();
            model.setRowCount(0);
            show_parts();

            JOptionPane.showMessageDialog(rootPane, "Part Details are Sucesfully Insterted");

        } catch (HeadlessException | NumberFormatException | SQLException Ex) {
            JOptionPane.showMessageDialog(null, Ex);
        }

    }//GEN-LAST:event_AddActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        try {
            String sql = "UPDATE parts SET PartsID=?,PName=?,Quantity=?,SupplierID=?,Price=? WHERE PartsID=?";

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_rustrepair", "root", "");
            pst = con.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(txtPartID.getText()));
            pst.setString(2, txtPartName.getText());
            pst.setInt(3, Integer.parseInt(txtQuatity.getText()));
            String value1 = txtSIDbox1.getSelectedItem().toString();
            pst.setInt(4, Integer.parseInt(value1));
            pst.setFloat(5, Float.parseFloat(txtPrice.getText()));
            pst.setInt(6, Integer.parseInt(txtPartID.getText()));
            pst.executeUpdate();

            if (Integer.parseInt(txtQuatity.getText()) == 0) {
                try {

                     String PName = txtPartName.getText();
                    
                    String sql5 = "Select S.Email from supplier s,parts p where s.supplierID = p.supplierID and p.PartsID =" + Integer.parseInt(txtPartID.getText());
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_rustrepair", "root", "");
                    pst = con.prepareStatement(sql5);
                    rs = pst.executeQuery();

                    while (rs.next()) {
                        String Email = rs.getString("S.Email");
                         
                        JavaMailSupplier.sendMail(Email, PName);
                    }
                } catch (SQLException Ex) {
                    JOptionPane.showMessageDialog(null, Ex);
                } catch (Exception ex) {
                    Logger.getLogger(JobStatus.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            DefaultTableModel model = (DefaultTableModel) METable.getModel();
            model.setRowCount(0);
            show_parts();

            JOptionPane.showMessageDialog(rootPane, "Part Details are Sucesfully Updated");

        } catch (HeadlessException | NumberFormatException | SQLException Ex) {
            JOptionPane.showMessageDialog(null, Ex);
        }

    }//GEN-LAST:event_UpdateActionPerformed

    private void txtPartIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPartIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPartIDActionPerformed

    private void txtPartNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPartNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPartNameActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        try {
            String sql = "DELETE FROM parts WHERE PartsID = ?";

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_rustrepair", "root", "");
            pst = con.prepareStatement(sql);
            pst.setString(1, txtPartID.getText());
            pst.executeUpdate();

            DefaultTableModel model = (DefaultTableModel) METable.getModel();
            model.setRowCount(0);
            show_parts();

            JOptionPane.showMessageDialog(rootPane, "Part Details are Sucesfully Deleted");

        } catch (HeadlessException | NumberFormatException | SQLException Ex) {
            JOptionPane.showMessageDialog(null, Ex);
        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void Close1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Close1ActionPerformed
        new LoginPage().setVisible(true);
        dispose();
    }//GEN-LAST:event_Close1ActionPerformed

    private void METableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_METableMouseClicked
        int Row = METable.getSelectedRow();
        String selection = METable.getModel().getValueAt(Row, 0).toString();
        String sl = "SELECT * FROM parts WHERE PartsID = " + selection;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_rustrepair", "root", "");
            pst = con.prepareStatement(sl);
            rs = pst.executeQuery();
            if (rs.next()) {
                txtPartID.setText(rs.getString("PartsID"));
                txtPartName.setText(rs.getString("PName"));
                txtQuatity.setText(rs.getString("Quantity"));
                txtPrice.setText(rs.getString("Price"));
            }

        } catch (Exception Ex) {
            JOptionPane.showMessageDialog(null, Ex);
        }
    }//GEN-LAST:event_METableMouseClicked

    private void METableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_METableKeyReleased
        int Row = METable.getSelectedRow();
        String selection = METable.getModel().getValueAt(Row, 0).toString();
        String sl = "SELECT * FROM parts WHERE PartsID = " + selection;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_rustrepair", "root", "");
            pst = con.prepareStatement(sl);
            rs = pst.executeQuery();
            if (rs.next()) {
                txtPartID.setText(rs.getString("PartsID"));
                txtPartName.setText(rs.getString("PName"));
                txtQuatity.setText(rs.getString("Quantity"));
                txtPrice.setText(rs.getString("Price"));
            }

        } catch (Exception Ex) {
            JOptionPane.showMessageDialog(null, Ex);
        }
    }//GEN-LAST:event_METableKeyReleased

    private void StatusPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StatusPageActionPerformed
        new JobStatus().setVisible(true);
        dispose();
    }//GEN-LAST:event_StatusPageActionPerformed

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
            java.util.logging.Logger.getLogger(MechanicInterface.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MechanicInterface.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MechanicInterface.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MechanicInterface.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MechanicInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton Close1;
    private javax.swing.JButton Delete;
    private javax.swing.JTable METable;
    private javax.swing.JButton StatusPage;
    private javax.swing.JButton Update;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtPartID;
    private javax.swing.JTextField txtPartName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuatity;
    private javax.swing.JComboBox<String> txtSIDbox1;
    // End of variables declaration//GEN-END:variables
}
