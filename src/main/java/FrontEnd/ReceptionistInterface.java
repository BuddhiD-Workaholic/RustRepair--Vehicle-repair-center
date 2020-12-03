package FrontEnd;

import Model.FrontUI;
import java.awt.HeadlessException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ReceptionistInterface extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String JobType = "Restoration Job/Repir Job";
    float Servicecost = 30000;

    public ReceptionistInterface() {
        initComponents();
        combobox1();
        combobox2();
        show_parts();
    }

//ArrayList
    public ArrayList<FrontUI> userList() {
        ArrayList<FrontUI> userList = new ArrayList<>();
        try {
            String sq1 = "select v.vehicleNo , v.ModelName , v.Engine_Details, v.Cus_ID,v.ManufactureDate,j.JobID,j.StartDate,j.DueDate,j.JobType,j.Details,j.MechanicID,j.ServiceCharger from job j, vehicle v where j.vehicleNo = v.vehicleNo";

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_rustrepair", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sq1);

            FrontUI parts;
            while (rs.next()) {
                parts = new FrontUI(rs.getString("vehicleNo"), rs.getString("ModelName"), rs.getString("Engine_Details"), rs.getInt("Cus_ID"), rs.getString("ManufactureDate"), rs.getInt("JobID"), rs.getString("StartDate"), rs.getString("DueDate"), rs.getString("JobType"), rs.getString("Details"), rs.getInt("MechanicID"), rs.getFloat("ServiceCharger"));
                userList.add(parts);
            }

        } catch (SQLException Ex) {
            JOptionPane.showMessageDialog(null, Ex);
        }
        return userList;
    }

    public void show_parts() {
        ArrayList<FrontUI> list = userList();
        DefaultTableModel model = (DefaultTableModel) RETable.getModel();
        Object[] row = new Object[12];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getJobID();
            row[1] = list.get(i).getVehicleNo();
            row[2] = list.get(i).getModelName();
            row[3] = list.get(i).getEngine_Details();
            row[4] = list.get(i).getManufactureDate();
            row[5] = list.get(i).getCus_ID();
            row[6] = list.get(i).getStartDate();
            row[7] = list.get(i).getDueDate();
            row[8] = list.get(i).getJobType();
            row[9] = list.get(i).getDetails();
            row[10] = list.get(i).getMechanicID();
            row[11] = list.get(i).getServiceCharger();

            model.addRow(row);
        }
    }

    private void combobox1() {

        //Mechanic ID       
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_rustrepair", "root", "");
            String sql1 = "SELECT * FROM mechanic";
            pst = con.prepareStatement(sql1);
            rs = pst.executeQuery();
            while (rs.next()) {
                String MID = rs.getString("MechanicID");
                txtMIDbox.addItem(MID);
            }

        } catch (SQLException Ex) {
            JOptionPane.showMessageDialog(null, Ex);
        }
    }

    private void combobox2() {

        //VehivleNo
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_rustrepair", "root", "");
            String sql2 = "SELECT * FROM vehicle";
            pst = con.prepareStatement(sql2);
            rs = pst.executeQuery();
            while (rs.next()) {
                String VID = rs.getString("vehicleNo");
                txtVnobox.addItem(VID);
            }

        } catch (SQLException Ex) {
            JOptionPane.showMessageDialog(null, Ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Delete = new javax.swing.JButton();
        Add = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        NewCustomer = new javax.swing.JLabel();
        txtJobID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtjobdetails = new javax.swing.JTextField();
        RestorationButton = new javax.swing.JRadioButton();
        RepairButton = new javax.swing.JRadioButton();
        Close1 = new javax.swing.JButton();
        SDate = new com.toedter.calendar.JDateChooser();
        DDate = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        RETable = new javax.swing.JTable();
        txtMIDbox = new javax.swing.JComboBox<>();
        NewVehicle = new javax.swing.JLabel();
        txtVnobox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(209, 250, 250));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel1.setText("Mechanic ID         :");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel4.setText("Vehical No           :");

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

        NewCustomer.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        NewCustomer.setText("New Customer?  Click here to create a new Customer profile");
        NewCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NewCustomerMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel8.setText("Job ID                :");

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel9.setText("Start  Date         :");

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel10.setText("Due Date            :");

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel11.setText("Job type              :");

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel12.setText("Repair Details      :");

        txtjobdetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjobdetailsActionPerformed(evt);
            }
        });

        RestorationButton.setText("Restoration Jobs");
        RestorationButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RestorationButtonMouseClicked(evt);
            }
        });
        RestorationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RestorationButtonActionPerformed(evt);
            }
        });

        RepairButton.setText("Repir Jobs");
        RepairButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RepairButtonMouseClicked(evt);
            }
        });
        RepairButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepairButtonActionPerformed(evt);
            }
        });

        Close1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Close1.setText("Close");
        Close1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Close1ActionPerformed(evt);
            }
        });

        RETable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job ID", "Vehicle No", " Model Name", "Engine Details ", "Manufacture date", "Customer ID", "Start Date", "Due Date", "Job Type", "Job Details", "Mechanic ID", "Service charge"
            }
        ));
        RETable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RETableMouseClicked(evt);
            }
        });
        RETable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RETableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(RETable);

        txtMIDbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Item" }));

        NewVehicle.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        NewVehicle.setText("New Vehicle?  Click here to goto Vehicle inventory");
        NewVehicle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NewVehicleMouseClicked(evt);
            }
        });

        txtVnobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Item" }));
        txtVnobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVnoboxActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Vani", 0, 18)); // NOI18N
        jLabel6.setText("Receptionist Interface");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NewCustomer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(NewVehicle)
                                .addGap(55, 55, 55)))
                        .addGap(151, 151, 151)
                        .addComponent(Close1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtjobdetails, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtMIDbox, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(10, 10, 10))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(RestorationButton)
                                .addGap(18, 18, 18)
                                .addComponent(RepairButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(DDate, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(SDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtJobID, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(25, 25, 25)
                                        .addComponent(txtVnobox, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(4, 4, 4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 951, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 62, 62))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtVnobox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtJobID, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SDate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DDate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RestorationButton)
                            .addComponent(RepairButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtjobdetails, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMIDbox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(NewCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NewVehicle, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Close1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RepairButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepairButtonActionPerformed
        if (RepairButton.isSelected()) {
            JobType = "Repir Job";
        }
    }//GEN-LAST:event_RepairButtonActionPerformed

    private void RestorationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RestorationButtonActionPerformed
        if (RestorationButton.isSelected()) {
            JobType = "Restoration Job";
        }
    }//GEN-LAST:event_RestorationButtonActionPerformed

    private void NewCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewCustomerMouseClicked
        new NewCustomerSignup().setVisible(true);
        dispose();
    }//GEN-LAST:event_NewCustomerMouseClicked

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

//Job table 
            String sql1 = "UPDATE job SET JobID=?,StartDate=?,DueDate=?,JobType=?,Details=?,MechanicID=?,vehicleNo=?,ServiceCharger=? WHERE JobID = ?";

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_rustrepair", "root", "");
            pst = con.prepareStatement(sql1);

            pst.setInt(1, Integer.parseInt(txtJobID.getText()));
            String sdate = sdf.format(SDate.getDate());
            pst.setString(2, sdate);
            String ddate = sdf.format(DDate.getDate());
            pst.setString(3, ddate);
            if (RestorationButton.isSelected()) {
                JobType = "Restoration Job";
                Servicecost = 20000;
            }
            if (RepairButton.isSelected()) {
                JobType = "Repir Job";
                Servicecost = 10000;

            }
            if (RestorationButton.isSelected() && RepairButton.isSelected()) {
                JobType = "Restoration Job/Repir Job";
                Servicecost = 30000;
            }
            pst.setString(4, JobType);
            pst.setString(5, txtjobdetails.getText());
            String value1 = txtMIDbox.getSelectedItem().toString();
            pst.setInt(6, Integer.parseInt(value1));
            String value2 = txtVnobox.getSelectedItem().toString();
            pst.setString(7, value2);
            pst.setFloat(8, Servicecost);
            pst.setInt(9, Integer.parseInt(txtJobID.getText()));
            pst.executeUpdate();

//WorksIn table
            String sql3 = "UPDATE worksin SET MechanicID=?,JobID=?,Status=?,Extraservice_charges=? WHERE JobID=?";

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_rustrepair", "root", "");
            pst = con.prepareStatement(sql3);

            String value3 = txtMIDbox.getSelectedItem().toString();
            pst.setInt(1, Integer.parseInt(value3));
            pst.setInt(2, Integer.parseInt(txtJobID.getText()));
            String Defa = "Not completed";
            pst.setString(3, Defa);
            float EXserviceC = 0;
            pst.setFloat(4, EXserviceC);
            pst.setInt(5, Integer.parseInt(txtJobID.getText()));

            DefaultTableModel model = (DefaultTableModel) RETable.getModel();
            model.setRowCount(0);
            show_parts();

            JOptionPane.showMessageDialog(rootPane, "Job Details are Sucesfully updated");

        } catch (HeadlessException | NumberFormatException | SQLException Ex) {
            JOptionPane.showMessageDialog(null, Ex);
        }
    }//GEN-LAST:event_UpdateActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

//Job table 
            String sql1 = "INSERT INTO job"
                    + "(JobID, StartDate, DueDate, JobType, Details, MechanicID, vehicleNo, ServiceCharger)"
                    + "VALUES(?,?,?,?,?,?,?,?)";

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_rustrepair", "root", "");
            pst = con.prepareStatement(sql1);

            pst.setInt(1, Integer.parseInt(txtJobID.getText()));
            String sdate = sdf.format(SDate.getDate());
            pst.setString(2, sdate);
            String ddate = sdf.format(DDate.getDate());
            pst.setString(3, ddate);
            if (RestorationButton.isSelected()) {
                JobType = "Restoration Job";
                Servicecost = 20000;
            }
            if (RepairButton.isSelected()) {
                JobType = "Repir Job";
                Servicecost = 10000;

            }
            if (RestorationButton.isSelected() && RepairButton.isSelected()) {
                JobType = "Restoration Job/Repir Job";
                Servicecost = 30000;
            }
            pst.setString(4, JobType);
            pst.setString(5, txtjobdetails.getText());
            String value1 = txtMIDbox.getSelectedItem().toString();
            pst.setInt(6, Integer.parseInt(value1));
            String value2 = txtVnobox.getSelectedItem().toString();
            pst.setString(7, value2);
            pst.setFloat(8, Servicecost);
            pst.executeUpdate();

//WorksIn table
            String sql3 = "INSERT INTO worksin"
                    + "(MechanicID, JobID, Status,Extraservice_charges)"
                    + "VALUES (?,?,?,?)";

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_rustrepair", "root", "");
            pst = con.prepareStatement(sql3);

            String value3 = txtMIDbox.getSelectedItem().toString();
            pst.setInt(1, Integer.parseInt(value3));
            pst.setInt(2, Integer.parseInt(txtJobID.getText()));
            String Defa = "Not completed";
            pst.setString(3, Defa);
            float EXserviceC = 0;
            pst.setFloat(4, EXserviceC);
            pst.executeUpdate();

            DefaultTableModel model = (DefaultTableModel) RETable.getModel();
            model.setRowCount(0);
            show_parts();

            JOptionPane.showMessageDialog(rootPane, "Job Details are Sucesfully Insterted");

        } catch (HeadlessException | NumberFormatException | SQLException Ex) {
            JOptionPane.showMessageDialog(null, Ex);
        }
    }//GEN-LAST:event_AddActionPerformed

    private void RestorationButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RestorationButtonMouseClicked
        if (RestorationButton.isSelected()) {
            JobType = "Restoration Job";
        }
    }//GEN-LAST:event_RestorationButtonMouseClicked

    private void RepairButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RepairButtonMouseClicked
        if (RepairButton.isSelected()) {
            JobType = "Repir Job";
        }
    }//GEN-LAST:event_RepairButtonMouseClicked

    private void Close1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Close1ActionPerformed
        new LoginPage().setVisible(true);
        dispose();
    }//GEN-LAST:event_Close1ActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        try {
            String sql = "DELETE FROM job WHERE JobID = ?";

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_rustrepair", "root", "");
            pst = con.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(txtJobID.getText()));
            pst.executeUpdate();

            DefaultTableModel model = (DefaultTableModel) RETable.getModel();
            model.setRowCount(0);
            show_parts();

            JOptionPane.showMessageDialog(rootPane, "Job Details are Sucesfully Deleted");

        } catch (HeadlessException | SQLException Ex) {
            JOptionPane.showMessageDialog(null, Ex);
        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void txtjobdetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjobdetailsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjobdetailsActionPerformed

    private void RETableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RETableMouseClicked

        int Row = RETable.getSelectedRow();
        TableModel model = RETable.getModel();
        String selection = RETable.getModel().getValueAt(Row, 0).toString();
        String sl = "select v.vehicleNo , v.ModelName , v.Engine_Details, v.Cus_ID,v.ManufactureDate,j.JobID,j.StartDate,j.DueDate,j.JobType,j.Details,j.MechanicID,j.ServiceCharger from job j, vehicle v where j.vehicleNo = v.vehicleNo and j.JobID = " + selection;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_rustrepair", "root", "");
            pst = con.prepareStatement(sl);
            rs = pst.executeQuery();
            if (rs.next()) {

                RestorationButton.setSelected(false);
                RepairButton.setSelected(false);

                txtJobID.setText(rs.getString("JobID"));

                Date sdf2 = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(Row, 6)); //
                SDate.setDate(sdf2);

                Date sdf3 = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(Row, 7));
                DDate.setDate(sdf3);

                String type = rs.getString("JobType");
                if (type.equals("Restoration Job")) {
                    RestorationButton.setSelected(true);

                } else if (type.equals("Repir Job")) {
                    RepairButton.setSelected(true);

                } else if (type.equals("Restoration Job") && type.equals("Repir Job")) {
                    RestorationButton.setSelected(true);
                    RepairButton.setSelected(true);

                }
                txtjobdetails.setText(rs.getString("Details"));
            }

        } catch (Exception Ex) {
            JOptionPane.showMessageDialog(null, Ex);
        }
    }//GEN-LAST:event_RETableMouseClicked

    private void NewVehicleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewVehicleMouseClicked
        new VehicleSignUp().setVisible(true);
        dispose();
    }//GEN-LAST:event_NewVehicleMouseClicked

    private void RETableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RETableKeyReleased

        int Row = RETable.getSelectedRow();
        TableModel model = RETable.getModel();
        String selection = RETable.getModel().getValueAt(Row, 0).toString();
        String sl = "select v.vehicleNo , v.ModelName , v.Engine_Details, v.Cus_ID,v.ManufactureDate,j.JobID,j.StartDate,j.DueDate,j.JobType,j.Details,j.MechanicID,j.ServiceCharger from job j, vehicle v where j.vehicleNo = v.vehicleNo and j.JobID = " + selection;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_rustrepair", "root", "");
            pst = con.prepareStatement(sl);
            rs = pst.executeQuery();
            if (rs.next()) {

                RestorationButton.setSelected(false);
                RepairButton.setSelected(false);

                txtJobID.setText(rs.getString("JobID"));

                Date sdf2 = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(Row, 6)); //
                SDate.setDate(sdf2);

                Date sdf3 = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(Row, 7));
                DDate.setDate(sdf3);

                String type = rs.getString("JobType");
                if (type.equals("Restoration Job")) {
                    RestorationButton.setSelected(true);

                } else if (type.equals("Repir Job")) {
                    RepairButton.setSelected(true);

                } else if (type.equals("Restoration Job") && type.equals("Repir Job")) {
                    RestorationButton.setSelected(true);
                    RepairButton.setSelected(true);

                }
                txtjobdetails.setText(rs.getString("Details"));
            }

        } catch (Exception Ex) {
            JOptionPane.showMessageDialog(null, Ex);
        }
    }//GEN-LAST:event_RETableKeyReleased

    private void txtVnoboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVnoboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVnoboxActionPerformed

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
            java.util.logging.Logger.getLogger(ReceptionistInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReceptionistInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReceptionistInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReceptionistInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReceptionistInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton Close1;
    private com.toedter.calendar.JDateChooser DDate;
    private javax.swing.JButton Delete;
    private javax.swing.JLabel NewCustomer;
    private javax.swing.JLabel NewVehicle;
    private javax.swing.JTable RETable;
    private javax.swing.JRadioButton RepairButton;
    private javax.swing.JRadioButton RestorationButton;
    private com.toedter.calendar.JDateChooser SDate;
    private javax.swing.JButton Update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtJobID;
    private javax.swing.JComboBox<String> txtMIDbox;
    private javax.swing.JComboBox<String> txtVnobox;
    private javax.swing.JTextField txtjobdetails;
    // End of variables declaration//GEN-END:variables
}
