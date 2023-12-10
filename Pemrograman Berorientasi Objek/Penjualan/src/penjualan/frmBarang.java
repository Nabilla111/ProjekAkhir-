/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package penjualan;


import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author dell
 */
public class frmBarang extends javax.swing.JFrame{

    Connection Con;
    ResultSet RsBrg;
    Statement stm;
    Boolean ada = false;
    String sSatuan;
    Boolean edit = false;
    private Object[][]dataTable = null;
    private String[] header = {"Kode", "Nama Barang","Satuan","Harga","Harga_Beli","Stok","Stok Min"};
    
    public frmBarang() {
        initComponents();
        open_db();
        baca_data();
        aktif(false);
        setTitle("Data Barang || A11.2021.13256");
        setTombol(true);
    }
             
    /**
     * Creates new form frmBarang
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbSatuan = new javax.swing.JComboBox<>();
        txtHarga = new javax.swing.JTextField();
        txtStok = new javax.swing.JTextField();
        txtStokMin = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBrg = new javax.swing.JTable();
        cmdTambah = new javax.swing.JButton();
        cmdSimpan = new javax.swing.JButton();
        cmdKoreksi = new javax.swing.JButton();
        cmdHapus = new javax.swing.JButton();
        cmdBatal = new javax.swing.JButton();
        cmdKeluar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtHarga_Beli = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Data Barang");

        jLabel2.setText("Kode Barang");

        txtKode.setToolTipText("");
        txtKode.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtKode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKodeActionPerformed(evt);
            }
        });

        jLabel3.setText("Nama Barang");

        txtNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaActionPerformed(evt);
            }
        });

        jLabel4.setText("Satuan");

        jLabel5.setText("Harga_Jual");

        jLabel6.setText("Stok");

        jLabel7.setText("Stok Minimal");

        cmbSatuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buah", "Unit", "Kg", "Liter", "Pcs" }));
        cmbSatuan.setEnabled(false);
        cmbSatuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSatuanActionPerformed(evt);
            }
        });

        txtHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHargaActionPerformed(evt);
            }
        });

        txtStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStokActionPerformed(evt);
            }
        });

        txtStokMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStokMinActionPerformed(evt);
            }
        });

        tblBrg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"00001", "Durian", "Buah", "10000", "8000", "10", "5"},
                {"00002", "Buku", "Buah", "2000", "1000", "20", "3"},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Kode", "Nama Barang", "Satuan", "Harga_Jual", "Harga_Beli", "Stok", "Stok Minimal"
            }
        ));
        tblBrg.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                tblBrgComponentAdded(evt);
            }
        });
        jScrollPane1.setViewportView(tblBrg);

        cmdTambah.setText("Tambah");
        cmdTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTambahActionPerformed(evt);
            }
        });

        cmdSimpan.setText("Simpan");
        cmdSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSimpanActionPerformed(evt);
            }
        });

        cmdKoreksi.setText("Koreksi");
        cmdKoreksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdKoreksiActionPerformed(evt);
            }
        });

        cmdHapus.setText("Hapus");
        cmdHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdHapusActionPerformed(evt);
            }
        });

        cmdBatal.setText("Batal");
        cmdBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBatalActionPerformed(evt);
            }
        });

        cmdKeluar.setText("Keluar");
        cmdKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdKeluarActionPerformed(evt);
            }
        });

        jLabel8.setText("Harga_Beli");

        txtHarga_Beli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHarga_BeliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(cmdTambah)
                .addGap(27, 27, 27)
                .addComponent(cmdSimpan)
                .addGap(30, 30, 30)
                .addComponent(cmdKoreksi)
                .addGap(29, 29, 29)
                .addComponent(cmdHapus)
                .addGap(35, 35, 35)
                .addComponent(cmdBatal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(cmdKeluar)
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(99, 99, 99)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(cmbSatuan, 0, 431, Short.MAX_VALUE)
                                                .addComponent(txtHarga)
                                                .addComponent(txtHarga_Beli)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtStok, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtStokMin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(97, 97, 97)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtKode)
                                    .addComponent(txtNama))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtHarga_Beli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtStokMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdTambah)
                    .addComponent(cmdSimpan)
                    .addComponent(cmdKoreksi)
                    .addComponent(cmdHapus)
                    .addComponent(cmdBatal)
                    .addComponent(cmdKeluar))
                .addContainerGap(96, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtKodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKodeActionPerformed

    private void cmdTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdTambahActionPerformed
        //tombol tambah
        aktif(true);
        setTombol(false);
        kosong();       
    }//GEN-LAST:event_cmdTambahActionPerformed

    private void cmdSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSimpanActionPerformed
    //tombol simpan
    String tKode=txtKode.getText();
    String tNama=txtNama.getText();
    double hrg_jual=Double.parseDouble(txtHarga.getText());
    double hrg_beli=Double.parseDouble(txtHarga_Beli.getText());
    int stk=Integer.parseInt(txtStok.getText());
    int stkMin=Integer.parseInt(txtStokMin.getText());


    try{
        if (edit==true)
        {
            stm.executeUpdate("update barang set nm_brg='"+tNama+"',satuan='"+sSatuan+"',"
    + "harga='"+hrg_jual+"', harga_beli='"+hrg_beli+"', hargabeli="+hrg_beli+", stok="+stk+", stok_min="+stkMin+" where kd_brg='" + tKode + "'"
);

        }else
        {
            stm.executeUpdate(
                    "INSERT into barang(kd_brg, nm_brg, satuan, harga, harga_beli, stok, stok_min) "
                    + "VALUES('"+tKode+"','"+tNama+"','"+sSatuan+"',"+hrg_jual+","+hrg_beli+","+stk+","+stkMin+")"
            );
        }

        tblBrg.setModel(new DefaultTableModel(dataTable,header));
        baca_data();
        aktif(false);
        setTombol(true);
    }catch(SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }        // TODO add your handling code here:
    }//GEN-LAST:event_cmdSimpanActionPerformed

    private void cmdKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdKeluarActionPerformed
    //tombol keluar
        //System.exit(0);        // TODO add your handling code here:
        new frmMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cmdKeluarActionPerformed

    private void cmbSatuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSatuanActionPerformed
    JComboBox cSatuan = (javax.swing.JComboBox)evt.getSource();
    //Membaca Item Yang Terpilih — > String
    sSatuan = (String)cSatuan.getSelectedItem();        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSatuanActionPerformed

    private void cmdBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBatalActionPerformed
    //tombol batal
    aktif(false);
    setTombol(true);        // TODO add your handling code here:
    }//GEN-LAST:event_cmdBatalActionPerformed

    private void cmdKoreksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdKoreksiActionPerformed
    //tombol koreksi
    edit=true;
    aktif(true);
    setTombol(false);
    txtKode.setEditable(false);        // TODO add your handling code here:
    }//GEN-LAST:event_cmdKoreksiActionPerformed

    private void cmdHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdHapusActionPerformed
    //tombol hapus
     try{
        String sql="delete from barang where kd_brg='" + txtKode.getText()+ "'";
        stm.executeUpdate(sql);
        baca_data();
        
        edit=false; //set ulang edit agar form tidak masuk ke mode edit
    }
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(null, e);
    }        // TODO add your handling code here:
    }//GEN-LAST:event_cmdHapusActionPerformed

    private void tblBrgComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tblBrgComponentAdded
    //tabel barang
        setField();        
// TODO add your handling code here:
    }//GEN-LAST:event_tblBrgComponentAdded

    private void txtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaActionPerformed

    private void txtHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaActionPerformed

    private void txtStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStokActionPerformed

    private void txtStokMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStokMinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStokMinActionPerformed

    private void txtHarga_BeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHarga_BeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHarga_BeliActionPerformed

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
            java.util.logging.Logger.getLogger(frmBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbSatuan;
    private javax.swing.JButton cmdBatal;
    private javax.swing.JButton cmdHapus;
    private javax.swing.JButton cmdKeluar;
    private javax.swing.JButton cmdKoreksi;
    private javax.swing.JButton cmdSimpan;
    private javax.swing.JButton cmdTambah;
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
    private javax.swing.JTable tblBrg;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtHarga_Beli;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtStok;
    private javax.swing.JTextField txtStokMin;
    // End of variables declaration//GEN-END:variables

    //method membuka database server, user, pass, database disesuaikan
private void open_db()
{ 
    try{
        KoneksiMysql kon = new KoneksiMysql("localhost:3308","root","","pbo");
        Con = kon.getConnection();
        //System.out.println("Berhasil ");
    }catch (Exception e) {
        System.out.println("Error : "+e);
    }
}

//method baca data dari Mysql dimasukkan ke table pada form
private void baca_data()
{
    try{
        stm = Con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            stm = Con.createStatement();
        RsBrg = stm.executeQuery("select * from barang");
        var meta = RsBrg.getMetaData();
        int col = meta.getColumnCount();
        int baris = 0;
        while(RsBrg.next()) {
            baris = RsBrg.getRow();
        }
        
        dataTable = new Object[baris][col];
        int x = 0;
        RsBrg.beforeFirst();

        while(RsBrg.next()) {
            dataTable[x][0] = RsBrg.getString("kd_brg");
            dataTable[x][1] = RsBrg.getString("nm_brg");
            dataTable[x][2] = RsBrg.getString("satuan");
            dataTable[x][3] = RsBrg.getDouble("harga");
            dataTable[x][4] = RsBrg.getDouble("harga_beli");
            dataTable[x][5] = RsBrg.getInt("stok");
            dataTable[x][6] = RsBrg.getInt("stok_min");
            x++;
        }

        tblBrg.setModel(new DefaultTableModel(dataTable,header));
         //  DefaultTableModel model = (DefaultTableModel) tblBrg.getModel();
          // model.setDataVector(dataTable, header);
    }
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(null, e);
    }
}

    //untuk mengkosongkan isian data
    private void kosong()
    {
        txtKode.setText("");
        txtNama.setText("");
        cmbSatuan.setSelectedIndex(0);
        txtHarga.setText("");
        txtHarga_Beli.setText("");
        txtStok.setText("");
        txtStokMin.setText("");
    }

    //mengset aktif tidak isian data
    private void aktif(boolean x)
    {
        txtKode.setEditable(x);
        txtNama.setEditable(x);
        //cmbSatuan.setEditable(x);
        cmbSatuan.setEnabled(x);
        txtHarga.setEditable(x);
        txtHarga_Beli.setEditable(x);
        txtStok.setEditable(x);
        txtStokMin.setEditable(x);
    }

    //mengset tombol on/off
    private void setTombol(boolean t)
    {
        cmdTambah.setEnabled(t);
        cmdKoreksi.setEnabled(t);
        cmdHapus.setEnabled(t);
        cmdSimpan.setEnabled(!t);
        cmdBatal.setEnabled(!t);
        cmdKeluar.setEnabled(t);
    }
    //method untuk memindahkan data dr table ke form
private void setField()
{
   
    int row = tblBrg.getSelectedRow();
    txtKode.setText((String)tblBrg.getValueAt(row,0));
    txtNama.setText((String)tblBrg.getValueAt(row,1));
    cmbSatuan.setSelectedItem((String)tblBrg.getValueAt(row,2));
    String harga = Double.toString((Double)tblBrg.getValueAt(row,3));
    txtHarga.setText(harga);
    txtHarga_Beli.setText(harga);
    String stok=Integer.toString((Integer)tblBrg.getValueAt(row,4));
    txtStok.setText(stok);
    String stokmin=Integer.toString((Integer)tblBrg.getValueAt(row,5));
    txtStokMin.setText(stokmin);
    
    }
}
