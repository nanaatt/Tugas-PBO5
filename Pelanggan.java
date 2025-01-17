/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pertemuankelima;

import java.sql.Connection;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Careen Emilza
 */
public class Pelanggan extends javax.swing.JFrame {

    Connection conn;
    Statement stmt;
    PreparedStatement pstmt = null;

    String driver = "org.postgresql.Driver";
    String koneksi = "jdbc:postgresql://localhost:5432/pbo";
    String user = "postgres";
    String password = "189066";
    InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    BufferedReader input = new BufferedReader(inputStreamReader);

    DefaultTableModel model;
    private String id_pelanggan;

    /**
     * Creates new form Frame
     */
    public Pelanggan() {
        initComponents();
        model = (DefaultTableModel) tblPELANGGAN.getModel();
        tampil();
    }

    public void tampil() {
        try {
            // TODO code application logi
            Class.forName(driver);
            String sql = "SELECT * FROM pelanggan";
            conn = DriverManager.getConnection(koneksi, user, password);
            stmt = conn.createStatement();

            while (!conn.isClosed()) {

                ResultSet rs = stmt.executeQuery(sql);
                tblPELANGGAN.setModel(DbUtils.resultSetToTableModel(rs));
                while (rs.next()) {
                    System.out.println(String.valueOf(rs.getObject(1)) + " " + String.valueOf(rs.getObject(2)) + " " + String.valueOf(rs.getObject(3)) + " " + String.valueOf(rs.getObject(4)));
                }
                conn.close();

            }
            stmt.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Pelanggan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Pelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadData() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nama");
        model.addColumn("Email");
        model.addColumn("Alamat");

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(koneksi, user, password);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM Pelanggan";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_pelanggan"),
                    rs.getString("nama_pelanggan"),
                    rs.getString("email"),
                    rs.getString("alamat")
                });
            }

            tblPELANGGAN.setModel(model);  // Set model to the table

            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Pelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblID = new javax.swing.JLabel();
        lblNAMA = new javax.swing.JLabel();
        lblALAMAT = new javax.swing.JLabel();
        txtNAMA = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        txtALAMAT = new javax.swing.JTextField();
        btnTAMBAH = new javax.swing.JButton();
        btnUPDATE = new javax.swing.JButton();
        btnDELETE = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPELANGGAN = new javax.swing.JTable();
        lblEMAIL = new javax.swing.JLabel();
        txtEMAIL = new javax.swing.JTextField();
        lblDATA = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblID.setText("ID");

        lblNAMA.setText("Nama");

        lblALAMAT.setText("Alamat");

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        txtALAMAT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtALAMATActionPerformed(evt);
            }
        });

        btnTAMBAH.setText("Tambah");
        btnTAMBAH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTAMBAHActionPerformed(evt);
            }
        });

        btnUPDATE.setText("Update");
        btnUPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUPDATEActionPerformed(evt);
            }
        });

        btnDELETE.setText("Delete");
        btnDELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDELETEActionPerformed(evt);
            }
        });

        tblPELANGGAN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblPELANGGAN);

        lblEMAIL.setText("Email");

        lblDATA.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDATA.setText("DATA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTAMBAH)
                                .addGap(18, 18, 18)
                                .addComponent(btnUPDATE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDELETE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblNAMA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblALAMAT, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                    .addComponent(lblEMAIL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtID)
                                    .addComponent(txtNAMA)
                                    .addComponent(txtALAMAT, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(txtEMAIL)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(lblDATA)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDATA)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNAMA)
                    .addComponent(txtNAMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEMAIL)
                    .addComponent(txtEMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblALAMAT)
                    .addComponent(txtALAMAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTAMBAH)
                    .addComponent(btnUPDATE)
                    .addComponent(btnDELETE))
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void btnTAMBAHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTAMBAHActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(koneksi, user, password);
            conn.setAutoCommit(false);
            String sql = "INSERT INTO pelanggan (id_pelanggan,nama_pelanggan, email, alamat) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            String id_pelanggan, nama_pelanggan, email, alamat;
            id_pelanggan = txtID.getText();
            nama_pelanggan = txtNAMA.getText();
            email = txtEMAIL.getText();
            alamat = txtALAMAT.getText();
            pstmt.setInt(1, Integer.parseInt(id_pelanggan));
            pstmt.setString(2, nama_pelanggan);
            pstmt.setString(3, email);
            pstmt.setString(4, alamat);

            int k = pstmt.executeUpdate();

            if (k > 0) {
                conn.commit();
                JOptionPane.showMessageDialog(null, "Berhasil");
            } else {
                JOptionPane.showMessageDialog(null, "Gagal");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Input Data Gagal: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver tidak ditemukan: " + ex.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException closeEx) {
                JOptionPane.showMessageDialog(null, "Close Gagal: " + closeEx.getMessage());
            }
        }
            tampil();
            clear();
    }//GEN-LAST:event_btnTAMBAHActionPerformed

    private void btnDELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDELETEActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(koneksi, user, password);
            conn.setAutoCommit(false);

            String sql = "DELETE FROM Pelanggan WHERE id_pelanggan = ?";
            pstmt = conn.prepareStatement(sql);
            id_pelanggan = txtID.getText();
            pstmt.setInt(1, Integer.parseInt(id_pelanggan));

            int k = pstmt.executeUpdate();

            if (k > 0) {
                conn.commit();
                JOptionPane.showMessageDialog(null, "Delete Berhasil");
            } else {
                JOptionPane.showMessageDialog(null, "Delete Gagal");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Penghapusan Data Gagal: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver tidak ditemukan: " + ex.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException closeEx) {
                JOptionPane.showMessageDialog(null, "Close Gagal: " + closeEx.getMessage());
            }
        }
        tampil();
        clear();
    }//GEN-LAST:event_btnDELETEActionPerformed

    private void btnUPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUPDATEActionPerformed
        // TODO add your handling code here:
        String id_pelanggan, nama_pelanggan, email, alamat;
        if (txtID.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Data harus terisi");
        } else if (txtNAMA.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Data harus terisi");
        } else if (txtEMAIL.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Data harus terisi");
        } else if (txtALAMAT.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Data harus terisi");
        } else {
            try {
                Class.forName(driver);
                String sql = "UPDATE Pelanggan SET nama_pelanggan = ?, email = ?, alamat = ? WHERE id_pelanggan = ?";
                conn = DriverManager.getConnection(koneksi, user, password);
                pstmt = conn.prepareStatement(sql);

                id_pelanggan = txtID.getText();
                nama_pelanggan = txtNAMA.getText();
                email = txtEMAIL.getText();
                alamat = txtALAMAT.getText();

                pstmt.setString(1, nama_pelanggan);
                pstmt.setString(2, email);
                pstmt.setString(3, alamat);
                pstmt.setInt(4, Integer.parseInt(id_pelanggan));

                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Success to update");
                    clear();
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to Update");
                }
            } catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Id_pesanan harus berupa angka");
            } finally {
                try {
                    if (pstmt != null) {
                        pstmt.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error closing resources: " + e.getMessage());
                }
            }
        }
        tampil();
        clear();
    }//GEN-LAST:event_btnUPDATEActionPerformed

    private void txtALAMATActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtALAMATActionPerformed
        // TODO add your handling code here:                                         

    }//GEN-LAST:event_txtALAMATActionPerformed

    
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
            java.util.logging.Logger.getLogger(Pelanggan.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pelanggan.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pelanggan.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pelanggan.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pelanggan().setVisible(true);
            }
        });
    }

    public void clear() {
        txtID.setText("");
        txtNAMA.setText("");
        txtEMAIL.setText("");
        txtALAMAT.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDELETE;
    private javax.swing.JButton btnTAMBAH;
    private javax.swing.JButton btnUPDATE;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblALAMAT;
    private javax.swing.JLabel lblDATA;
    private javax.swing.JLabel lblEMAIL;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNAMA;
    private javax.swing.JTable tblPELANGGAN;
    private javax.swing.JTextField txtALAMAT;
    private javax.swing.JTextField txtEMAIL;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNAMA;
    // End of variables declaration//GEN-END:variables
}
