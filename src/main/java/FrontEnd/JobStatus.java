package FrontEnd;

import Model.JStatus;
import Utility.JavaMailCustomer;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JobStatus extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public JobStatus() {
        initComponents();
        show_parts();
    }

    public ArrayList<JStatus> userList() {
        ArrayList<JStatus> userList = new ArrayList<>();
        try {
            String sq = "SELECT * FROM worksin";

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_rustrepair", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sq);

            JStatus JobSt;
            while (rs.next()) {
                JobSt = new JStatus(rs.getInt("MechanicID"), rs.getInt("JobID"), rs.getString("Status"), rs.getFloat("Extraservice_charges"));
                userList.add(JobSt);
            }

        } catch (SQLException Ex) {
            JOptionPane.showMessageDialog(null, Ex);
        }
        return userList;
    }

    public void show_parts() {
        ArrayList<JStatus> list = userList();
        DefaultTableModel model = (DefaultTableModel) JobMETable.getModel();
        Object[] row = new Object[4];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getJobID();
            row[1] = list.get(i).getMechanicID();
            row[2] = list.get(i).getStatus();
            row[3] = list.get(i).getExtraservice_charges();
            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtStatus = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JobMETable = new javax.swing.JTable();
        Close2 = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtESC = new javax.swing.JTextField();
        txtJobID = new javax.swing.JTextField();
        txtMEID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setText("Customer SignUp ");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(209, 250, 250));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel1.setText("Job ID         :");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel2.setText("Mechanic ID :");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel3.setText("Status         :");

        JobMETable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job ID", "Mechanic ID", "Status", "Extra service charges"
            }
        ));
        JobMETable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JobMETableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JobMETable);

        Close2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Close2.setText("Close");
        Close2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Close2ActionPerformed(evt);
            }
        });

        UpdateButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        UpdateButton.setText("Update");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel4.setText("Extra Service Charges :");

        txtJobID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJobIDActionPerformed(evt);
            }
        });

        txtMEID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMEIDActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Vani", 0, 18)); // NOI18N
        jLabel6.setText("Job Status");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(UpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtStatus)
                                    .addComponent(txtJobID)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtESC))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMEID)))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Close2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtJobID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMEID, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtESC, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(UpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Close2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Close2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Close2ActionPerformed
        new MechanicInterface().setVisible(true);
        dispose();
    }//GEN-LAST:event_Close2ActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        try {
            //WorksIn table
            String sql3 = "UPDATE worksin SET MechanicID=?,JobID=?,Status=?,Extraservice_charges=? WHERE JobID=?";

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_rustrepair", "root", "");
            pst = con.prepareStatement(sql3);

            pst.setInt(1, Integer.parseInt(txtMEID.getText()));
            pst.setInt(2, Integer.parseInt(txtJobID.getText()));
            pst.setString(3, txtStatus.getText());
            pst.setFloat(4, Float.parseFloat(txtESC.getText()));
            pst.setInt(5, Integer.parseInt(txtJobID.getText()));
            pst.executeUpdate();

            if (txtStatus.getText().equalsIgnoreCase("Completed")) {
                try {
                    
                    String sql1 = "Select C.EMail from customer c, Job j,Vehicle v, worksin w where w.JobID = j.JobID and j.vehicleNo=v.vehicleNo and v.Cus_ID = c.Cus_ID and w.JobID ="+Integer.parseInt(txtMEID.getText());
                    
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_rustrepair", "root", "");
                    pst = con.prepareStatement(sql1);
                    rs = pst.executeQuery();
                    
                    while (rs.next()) {
                        String Email = rs.getString("C.EMail");
                        JavaMailCustomer.sendMail(Email);
                    }
                } catch (SQLException Ex) {
                    JOptionPane.showMessageDialog(null, Ex);
                } catch (Exception ex) {
                    Logger.getLogger(JobStatus.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            DefaultTableModel model = (DefaultTableModel) JobMETable.getModel();
            model.setRowCount(0);
            show_parts();

            JOptionPane.showMessageDialog(rootPane, "Details are Sucesfully updated");

        } catch (HeadlessException | NumberFormatException | SQLException Ex) {
            JOptionPane.showMessageDialog(null, Ex);
        }
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void JobMETableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JobMETableMouseClicked
        int Row = JobMETable.getSelectedRow();
        String selection = JobMETable.getModel().getValueAt(Row, 0).toString();

        String sl = "SELECT * FROM worksin WHERE JobID = " + selection;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_rustrepair", "root", "");
            pst = con.prepareStatement(sl);
            rs = pst.executeQuery();
            if (rs.next()) {
                txtJobID.setText(rs.getString("JobID"));
                txtMEID.setText(rs.getString("MechanicID"));
                txtStatus.setText(rs.getString("Status"));
                txtESC.setText(rs.getString("Extraservice_charges"));
            }

        } catch (SQLException Ex) {
            JOptionPane.showMessageDialog(null, Ex);
        }
    }//GEN-LAST:event_JobMETableMouseClicked

    private void txtJobIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJobIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJobIDActionPerformed

    private void txtMEIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMEIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMEIDActionPerformed

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
            java.util.logging.Logger.getLogger(JobStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JobStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JobStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JobStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JobStatus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Close2;
    private javax.swing.JTable JobMETable;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtESC;
    private javax.swing.JTextField txtJobID;
    private javax.swing.JTextField txtMEID;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
}
