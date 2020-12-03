package FrontEnd;

import Model.Vehicle;
import java.awt.HeadlessException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class VehicleSignUp extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public VehicleSignUp() {
        initComponents();
        combobox();
        show_parts();
    }

    public ArrayList<Vehicle> userList() {
        ArrayList<Vehicle> userList = new ArrayList<>();
        try {
            String sq1 = "SELECT * FROM vehicle";

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_rustrepair", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sq1);

            Vehicle vehicle;
            while (rs.next()) {
                vehicle = new Vehicle(rs.getString("vehicleNo"), rs.getString("ModelName"), rs.getString("Engine_Details"), rs.getInt("Cus_ID"), rs.getString("ManufactureDate"));
                userList.add(vehicle);
            }

        } catch (SQLException Ex) {
            JOptionPane.showMessageDialog(null, Ex);
        }
        return userList;
    }

    public void show_parts() {
        ArrayList<Vehicle> list = userList();
        DefaultTableModel model = (DefaultTableModel) VETable.getModel();
        Object[] row = new Object[5];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getVehicleNo();
            row[1] = list.get(i).getModel();
            row[2] = list.get(i).getEngineData();
            row[3] = list.get(i).getCus_ID();
            row[4] = list.get(i).getManufactureDate();

            model.addRow(row);
        }
    }

    private void combobox() {
          
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_rustrepair", "root", "");
            String sql1 = "SELECT * FROM customer";
            pst = con.prepareStatement(sql1);
            rs = pst.executeQuery();
            while (rs.next()) {
                String CID = rs.getString("Cus_ID");
                txtCIDbox1.addItem(CID);
            }

        } catch (SQLException Ex) {
            JOptionPane.showMessageDialog(null, Ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCIDbox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtVNo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtVModelName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtVEngineDa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        VETable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtCIDbox1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        MDate1 = new com.toedter.calendar.JDateChooser();
        Add = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Close = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel3.setText("Customer ID               :");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(209, 250, 250));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel4.setText("Vehical No                  :");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel5.setText("Vehicle Model name    :");

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel7.setText("Vehicle Engine details :");

        VETable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vehicle No", "Model Name", "Engine Details", "Customer ID", "Manufacture Date"
            }
        ));
        VETable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VETableMouseClicked(evt);
            }
        });
        VETable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                VETableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(VETable);

        jLabel2.setFont(new java.awt.Font("Vani", 0, 18)); // NOI18N
        jLabel2.setText("Vehicle Records");

        txtCIDbox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Item" }));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel8.setText("Customer ID               :");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel6.setText("Vehicle Manufacture date :");

        Add.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        Add.setText("Add");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        Update.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        Delete.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        Close.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        Close.setText("Close");
        Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCIDbox1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtVModelName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                        .addComponent(txtVNo, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtVEngineDa, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(89, 89, 89)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(MDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Close, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtVNo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtVModelName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtVEngineDa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCIDbox1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(MDate1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 3, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Close, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            //Vehicale table
            String sql1 = "INSERT INTO vehicle"
                    + "(vehicleNo, ModelName, Engine_Details, Cus_ID, ManufactureDate)"
                    + "VALUES(?,?,?,?,?)";

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_rustrepair", "root", "");
            pst = con.prepareStatement(sql1);

            pst.setString(1, txtVNo.getText());
            pst.setString(2, txtVModelName.getText());
            pst.setString(3, txtVEngineDa.getText());
            String value4 = txtCIDbox1.getSelectedItem().toString();
            pst.setInt(4, Integer.parseInt(value4));
            String mdate = sdf.format(MDate1.getDate());
            pst.setString(5, mdate);
            pst.executeUpdate();
            
            DefaultTableModel model = (DefaultTableModel) VETable.getModel();
            model.setRowCount(0);
            show_parts();

            JOptionPane.showMessageDialog(rootPane, "Vehicle Details are Sucesfully Insterted");

        } catch (HeadlessException | NumberFormatException | SQLException Ex) {
            JOptionPane.showMessageDialog(null, Ex);
        }
    }//GEN-LAST:event_AddActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            //Vehicale table
            String sql1 = "UPDATE vehicle SET vehicleNo=?,ModelName=?,Engine_Details=?,Cus_ID=?,ManufactureDate=? WHERE vehicleNo=?";

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_rustrepair", "root", "");
            pst = con.prepareStatement(sql1);

            pst.setString(1, txtVNo.getText());
            pst.setString(2, txtVModelName.getText());
            pst.setString(3, txtVEngineDa.getText());
            String value5 = txtCIDbox1.getSelectedItem().toString();
            pst.setInt(4, Integer.parseInt(value5));
            String mdate = sdf.format(MDate1.getDate());
            pst.setString(5, mdate);
            pst.setString(6, txtVNo.getText());
            pst.executeUpdate();
            
            DefaultTableModel model = (DefaultTableModel) VETable.getModel();
            model.setRowCount(0);
            show_parts();

            JOptionPane.showMessageDialog(rootPane, "Vehicle Details are Sucesfully updated");

        } catch (HeadlessException | NumberFormatException | SQLException Ex) {
            JOptionPane.showMessageDialog(null, Ex);
        }
    }//GEN-LAST:event_UpdateActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        try {
            String sql = "DELETE FROM vehicle WHERE vehicleNo = ?";

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_rustrepair", "root", "");
            pst = con.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(txtVNo.getText()));
            pst.executeUpdate();

            DefaultTableModel model = (DefaultTableModel) VETable.getModel();
            model.setRowCount(0);
            show_parts();

            JOptionPane.showMessageDialog(rootPane, "Vehicle Details are Sucesfully Deleted");

        } catch (SQLException Ex) {
            JOptionPane.showMessageDialog(null, Ex);
        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void VETableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VETableMouseClicked
        int Row = VETable.getSelectedRow();
        TableModel model = VETable.getModel();
        String selection = VETable.getModel().getValueAt(Row, 0).toString();
        String sl = "SELECT * FROM vehicle WHERE vehicleNo=" + selection;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_rustrepair", "root", "");
            pst = con.prepareStatement(sl);
            rs = pst.executeQuery();
            if (rs.next()) {

                txtVNo.setText(rs.getString("vehicleNo"));
                txtVModelName.setText(rs.getString("ModelName"));
                txtVEngineDa.setText(rs.getString("Engine_Details"));
                Date sdf1 = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(Row, 4));
                MDate1.setDate(sdf1);
            }

        } catch (Exception Ex) {
            JOptionPane.showMessageDialog(null, Ex);
        }
    }//GEN-LAST:event_VETableMouseClicked

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
        new ReceptionistInterface().setVisible(true);
        dispose();
    }//GEN-LAST:event_CloseActionPerformed

    private void VETableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VETableKeyReleased
        int Row = VETable.getSelectedRow();
        TableModel model = VETable.getModel();
        String selection = VETable.getModel().getValueAt(Row, 0).toString();
        String sl = "SELECT * FROM vehicle WHERE vehicleNo=" + selection;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_rustrepair", "root", "");
            pst = con.prepareStatement(sl);
            rs = pst.executeQuery();
            if (rs.next()) {

                txtVNo.setText(rs.getString("vehicleNo"));
                txtVModelName.setText(rs.getString("ModelName"));
                txtVEngineDa.setText(rs.getString("Engine_Details"));
                Date sdf1 = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(Row, 4));
                MDate1.setDate(sdf1);
            }

        } catch (Exception Ex) {
            JOptionPane.showMessageDialog(null, Ex);
        }
    }//GEN-LAST:event_VETableKeyReleased

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
            java.util.logging.Logger.getLogger(VehicleSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VehicleSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VehicleSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VehicleSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VehicleSignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton Close;
    private javax.swing.JButton Delete;
    private com.toedter.calendar.JDateChooser MDate1;
    private javax.swing.JButton Update;
    private javax.swing.JTable VETable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> txtCIDbox;
    private javax.swing.JComboBox<String> txtCIDbox1;
    private javax.swing.JTextField txtVEngineDa;
    private javax.swing.JTextField txtVModelName;
    private javax.swing.JTextField txtVNo;
    // End of variables declaration//GEN-END:variables
}
