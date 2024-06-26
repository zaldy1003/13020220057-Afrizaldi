/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package perpustakaan;

import perpustakaan.koneksi;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author GF63
 */
public class PerpustakaanMenu extends javax.swing.JInternalFrame {
    private java.sql.Connection con = koneksi.DBConnection();
    private PreparedStatement stm;
    static int idPeminjaman;

    public PerpustakaanMenu() {
        initComponents();
    }

    public void tambahPeminjaman() {
        try {
            String namaBuku = NamaBuku.getText();
            String sql = "SELECT COUNT(*) FROM buku where judul = ? AND Status_Peminjaman= Tersedia";
            stm = (PreparedStatement) con.prepareStatement(sql);
            stm.setString(1, namaBuku);
            ResultSet result = stm.executeQuery();
            result.next();
            int count = result.getInt(1);
            boolean cek = (count > 0);

            sql = "SELECT kode_buku FROM BUKU WHERE judul = ?";
            stm = (PreparedStatement) con.prepareStatement(sql);
            stm.setString(1, namaBuku);
            result = stm.executeQuery();
            result.next();
            int kode = result.getInt(sql);

            sql = "SELECT id_member FROM BUKU WHERE judul = ?";
            stm = (PreparedStatement) con.prepareStatement(sql);
            stm.setString(1, namaBuku);
            result = stm.executeQuery();
            result.next();
            int idMember = result.getInt(sql);

            if (cek) {
                System.out.println("Data Buku Dengan Judul " + namaBuku + "Tersedia dan bisa dipinjam");
                sql = "INSERT INTO PEMINJAMAN VALUES(0, ?, ?, ?, ?)";
                stm = (PreparedStatement) con.prepareStatement(sql);
                stm.setInt(1, idPeminjaman);
                stm.setInt(2, kode);
                stm.setInt(3, kode);
//            stm.setInt(4, );
                idPeminjaman++;

                sql = "SELECT id_member FROM member WHERE nama = ?";
                stm = (PreparedStatement) con.prepareStatement(sql);
                stm.setString(1, namaBuku);

                stm.setInt(2, count);
            } else {
                System.out.println("Data Buku Dengan Judul " + namaBuku + "Tidak tersedia atau dipinjam");
            }
            String namaPeminjam = JOptionPane.showInputDialog("Masukkan Nama Peminjam");
        } catch (SQLException exc) {
            System.out.println("gagal mencari data" + exc.getMessage());
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

        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        NamaBuku = new javax.swing.JTextField();
        peminjamanaBuku = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        PengembalianBuku = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        cariBuku = new javax.swing.JButton();
        NamaBuku2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePerpustakaan1 = new javax.swing.JTable();

        setTitle("Perpustakaan");
        setPreferredSize(new java.awt.Dimension(787, 310));

        jLabel3.setText("Masukkan Nama Buku:");

        NamaBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaBukuActionPerformed(evt);
            }
        });

        peminjamanaBuku.setText("Tambah Peminjaman");
        peminjamanaBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peminjamanaBukuActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setText("Manajemen Peminjaman");

        PengembalianBuku.setText("Pengembalian Buku");
        PengembalianBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PengembalianBukuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NamaBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(peminjamanaBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(PengembalianBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NamaBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(peminjamanaBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PengembalianBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        cariBuku.setText("Cari Buku");
        cariBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariBukuActionPerformed(evt);
            }
        });

        jLabel5.setText("Cari Buku Berdasarkan Nama:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel2.setText("Manajemen Buku");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(110, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(NamaBuku2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(118, 118, 118))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(cariBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NamaBuku2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cariBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(10, 10, 10))
        );

        tablePerpustakaan1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode Buku", "Judul Buku", "Penulis", "Status"
            }
        ));
        jScrollPane2.setViewportView(tablePerpustakaan1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void peminjamanaBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peminjamanaBukuActionPerformed
//        try {
//            String namaBuku = NamaBuku.getText();
//            String sql = "SELECT COUNT(*) FROM buku where judul = ? AND Status_Peminjaman= Tersedia";
//            stm = (PreparedStatement) con.prepareStatement(sql);
//            stm.setString(1, namaBuku);
//            ResultSet result = stm.executeQuery();
//            result.next();
//            int count = result.getInt(1);
//            boolean cek = (count > 0);
//
//            if (cek) {
//                JOptionPane.showMessageDialog(null, "Buku tersedia", "Information", JOptionPane.INFORMATION_MESSAGE);
//                sql = "INSERT INTO PEMINJAMAN VALUES(0, ?, ?, ?, ?)";
//                stm = (PreparedStatement) con.prepareStatement(sql);
//                stm.setInt(1, );
//                stm.setInt(2, );
//                stm.setInt(3, );
//                idPeminjaman++;
//
//                JOptionPane.showMessageDialog(null, "Buku Berhasil dicari", "Information", JOptionPane.INFORMATION_MESSAGE);
//            }
//        }catch(Exception exc){
//            JOptionPane.showMessageDialog(null, "Buku gagal dicari", "Information", JOptionPane.INFORMATION_MESSAGE);
//        }
    }//GEN-LAST:event_peminjamanaBukuActionPerformed

    private void cariBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cariBukuActionPerformed

    private void NamaBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaBukuActionPerformed

    private void PengembalianBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PengembalianBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PengembalianBukuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NamaBuku;
    private javax.swing.JTextField NamaBuku2;
    private javax.swing.JButton PengembalianBuku;
    private javax.swing.JButton cariBuku;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton peminjamanaBuku;
    private javax.swing.JTable tablePerpustakaan1;
    // End of variables declaration//GEN-END:variables
}
