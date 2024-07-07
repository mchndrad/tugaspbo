
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.math.BigDecimal;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class barangmasuk extends javax.swing.JFrame {

    /**
     * Creates new form barangmasuk
     */
    public barangmasuk() {
        initComponents();
        initializeTable1();
        initializeTable2();
        loadDataToTable1();
    }
    
    private void initializeTable1() {
    DefaultTableModel model = new DefaultTableModel();
    barangTable.setModel(model);
    model.addColumn("ID Barang");
    model.addColumn("Nama Barang");
    model.addColumn("Harga Barang");
    model.addColumn("jumlah yang dipesan");
    model.addColumn("jumlah yang diterima");
    model.addColumn("ID Penerima Barang");
    model.addColumn("Nama Penerima Barang");
    model.addColumn("Tanggal/Waktu penerimaan barang");
    model.addColumn("ID Supplier");
   
}
     
private void loadDataToTable1(){
    try {
        Connection connection = DatabaseConnection.getConnection();
        try {
            String query = "SELECT * FROM barang_masuk";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            DefaultTableModel model = (DefaultTableModel) barangTable.getModel();
            model.setRowCount(0);
            while (resultSet.next()) {
                Object[] row = {
                    resultSet.getInt("id_barang"),
                    resultSet.getString("nama_barang"),
                    resultSet.getBigDecimal("harga_barang"),
                    resultSet.getInt("jumlah_dipesan"),
                    resultSet.getInt("jumlah_diterima"),
                    resultSet.getInt("id_penerima"),
                    resultSet.getString("nama_penerima"),
                    resultSet.getString("tanggal_penerimaan"),
                    resultSet.getInt("id_supplier"),
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } catch (SQLException ex) {
            Logger.getLogger(barangmasuk.class.getName()).log(Level.SEVERE, null, ex);
    }
}

private void initializeTable2() {
    DefaultTableModel model = new DefaultTableModel();
    stock_barang.setModel(model);
    model.addColumn("ID Barang");
    model.addColumn("Nama Barang");
    model.addColumn("Stock Barang");
}

private void loadDataToTable2(){
    try {
        Connection connection = DatabaseConnection.getConnection();
        try {
            String query = "SELECT * FROM barang_masuk";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            DefaultTableModel model = (DefaultTableModel) stock_barang.getModel();
            model.setRowCount(0);
            while (resultSet.next()) {
                Object[] row = {
                    resultSet.getInt("id_barang"),
                    resultSet.getString("nama_barang"),
                    resultSet.getInt("jumlah_diterima"),
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } catch (SQLException ex) {
            Logger.getLogger(barangmasuk.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        idBarangTextField = new javax.swing.JTextField();
        createButton = new javax.swing.JButton();
        readButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        barangTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        stock_barang = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        namaBarangTextField = new javax.swing.JTextField();
        hargaBarangTextField = new javax.swing.JTextField();
        jumlahDipesanTextField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jumlahDiterimaTextField = new javax.swing.JTextField();
        idPenerimaBarangTextField = new javax.swing.JTextField();
        tanggalWaktuPenerimaanTextField = new javax.swing.JTextField();
        namaPenerimaBarangTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        idsupplierTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bg2.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("PENDATAAN BARANG MASUK");

        jLabel3.setText("ID Barang");

        idBarangTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idBarangTextFieldActionPerformed(evt);
            }
        });

        createButton.setText("CREATE");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        readButton.setText("READ");
        readButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readButtonActionPerformed(evt);
            }
        });

        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        barangTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Barang", "Nama Barang", "Harga Barang", "Jumlah yang dipesan", "Jumlah yang diterima", "ID Penerima Barang", "Nama Penerima Barang", "Tanggal/Waktu penerimaan barang"
            }
        ));
        jScrollPane1.setViewportView(barangTable);

        stock_barang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Barang", "Nama Barang", "Stock Barang"
            }
        ));
        jScrollPane3.setViewportView(stock_barang);

        jButton7.setText("Stock Barang");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Ingin Melihat Stock Barang Yang Tersedia?");

        jLabel13.setText("Nama Barang");

        jLabel14.setText("Harga Barang");

        jLabel15.setText("Jumlah yang dipesan");

        jLabel16.setText("Jumlah yang diterima");

        jLabel17.setText("ID Penerima Barang");

        jLabel18.setText("Nama Penerima Barang");

        jLabel19.setText("Tanggal/Waktu penerimaan barang");

        jumlahDiterimaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahDiterimaTextFieldActionPerformed(evt);
            }
        });

        namaPenerimaBarangTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaPenerimaBarangTextFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("ID Supplier");

        idsupplierTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idsupplierTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(455, 455, 455)
                                    .addComponent(jLabel2))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(56, 56, 56)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel15)
                                            .addGap(18, 18, 18)
                                            .addComponent(jumlahDipesanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel19))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel13)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel14)
                                                .addComponent(jLabel4))
                                            .addGap(57, 57, 57)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(idBarangTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jLabel16))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(namaBarangTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jLabel17))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(hargaBarangTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jLabel18))
                                                .addComponent(idsupplierTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jumlahDiterimaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(namaPenerimaBarangTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(tanggalWaktuPenerimaanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(idPenerimaBarangTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(0, 0, Short.MAX_VALUE)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addComponent(createButton, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(readButton, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton7))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(356, 356, 356)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(idsupplierTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(idBarangTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(jumlahDiterimaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(namaBarangTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(idPenerimaBarangTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(hargaBarangTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(namaPenerimaBarangTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jumlahDipesanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel15)
                            .addComponent(tanggalWaktuPenerimaanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(readButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jButton7))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 922, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jumlahDiterimaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlahDiterimaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jumlahDiterimaTextFieldActionPerformed

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        // TODO add your handling code here:
    try {
    // Validasi dan konversi input harga_barang dan total_harga
    BigDecimal hargaBarang = null;
    

    try {
        // Mengganti koma dengan string kosong dan mengganti titik sebagai pemisah desimal
        String hargaBarangStr = hargaBarangTextField.getText().replace(",", "").trim();
        

        hargaBarang = new BigDecimal(hargaBarangStr);
        
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Format harga tidak valid. Gunakan format angka desimal.");
        return;
    }

    Connection con = DatabaseConnection.getConnection();
    String query = "INSERT INTO `barang_masuk`(`id_barang`, `nama_barang`, `harga_barang`, `jumlah_dipesan`, `jumlah_diterima`, `id_penerima`, `nama_penerima`, `tanggal_penerimaan`, id_supplier) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    PreparedStatement pst = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

    pst.setInt(1, Integer.parseInt(idBarangTextField.getText()));
    pst.setString(2, namaBarangTextField.getText());
    pst.setBigDecimal(3, hargaBarang);
    pst.setInt(4, Integer.parseInt(jumlahDipesanTextField.getText()));
    pst.setInt(5, Integer.parseInt(jumlahDiterimaTextField.getText()));
    pst.setInt(6, Integer.parseInt(idPenerimaBarangTextField.getText()));
    pst.setString(7, namaPenerimaBarangTextField.getText());
    pst.setDate(8, java.sql.Date.valueOf(tanggalWaktuPenerimaanTextField.getText()));
    pst.setInt(10, Integer.parseInt(idsupplierTextField.getText()));
    

    pst.executeUpdate();

    // Mendapatkan id_barang yang dihasilkan
    ResultSet rs = pst.getGeneratedKeys();
    if (rs.next()) {
        int generatedId = rs.getInt(1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan dengan ID: " + generatedId);
    } else {
        JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
    }

} catch (Exception e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
}
    loadDataToTable1();
    loadDataToTable2();
        
    }//GEN-LAST:event_createButtonActionPerformed

    private void readButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readButtonActionPerformed
        // TODO add your handling code here:
        loadDataToTable1();
    }//GEN-LAST:event_readButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
    try {
    // Validasi dan konversi input harga_barang dan total_harga
    BigDecimal hargaBarang = null;
    

    try {
        // Mengganti koma dengan string kosong dan mengganti titik sebagai pemisah desimal
        String hargaBarangStr = hargaBarangTextField.getText().replace(",", "").trim();

        hargaBarang = new BigDecimal(hargaBarangStr);
        
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Format harga tidak valid. Gunakan format angka desimal.");
        return;
    }

    Connection con = DatabaseConnection.getConnection();
    String query = "UPDATE `barang_masuk` SET `nama_barang`= ? ,`harga_barang`= ? ,`jumlah_dipesan`= ? ,"
            + "`jumlah_diterima`= ? ,`id_penerima`= ? ,`nama_penerima`= ? ,`tanggal_penerimaan`= ?, `id_supplier`= ?  "
            + "WHERE id_barang = ?";
    PreparedStatement pst = con.prepareStatement(query);

    pst.setString(1, namaBarangTextField.getText());
    pst.setBigDecimal(2, hargaBarang);
    pst.setInt(3, Integer.parseInt(jumlahDipesanTextField.getText()));
    pst.setInt(4, Integer.parseInt(jumlahDiterimaTextField.getText()));
    pst.setInt(5, Integer.parseInt(idPenerimaBarangTextField.getText()));
    pst.setString(6, namaPenerimaBarangTextField.getText());
    pst.setDate(7, java.sql.Date.valueOf(tanggalWaktuPenerimaanTextField.getText()));
    pst.setInt(8, Integer.parseInt(idsupplierTextField.getText()));

    // Pastikan Anda mengambil id_barang dari input pengguna atau komponen GUI
    int idBarang = Integer.parseInt(idBarangTextField.getText());
    pst.setInt(9, idBarang);  // Set id_barang sebagai parameter terakhir

    int rowsUpdated = pst.executeUpdate();
    if (rowsUpdated > 0) {
        JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate");
    } else {
        JOptionPane.showMessageDialog(null, "Tidak ada data yang diupdate. Pastikan id_barang valid.");
    }
} catch (Exception e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(null, e.getMessage());
}
    loadDataToTable1();

    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        try {
        Connection con = DatabaseConnection.getConnection();
        String query = "DELETE FROM barang_masuk WHERE id_barang = ?";
        PreparedStatement pst = con.prepareStatement(query);

        pst.setInt(1, Integer.parseInt(idBarangTextField.getText()));

        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
    }
        loadDataToTable1();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
         loadDataToTable2();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void namaPenerimaBarangTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaPenerimaBarangTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaPenerimaBarangTextFieldActionPerformed

    private void idBarangTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idBarangTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idBarangTextFieldActionPerformed

    private void idsupplierTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idsupplierTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idsupplierTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(barangmasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(barangmasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(barangmasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(barangmasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new barangmasuk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable barangTable;
    private javax.swing.JButton createButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField hargaBarangTextField;
    private javax.swing.JTextField idBarangTextField;
    private javax.swing.JTextField idPenerimaBarangTextField;
    private javax.swing.JTextField idsupplierTextField;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jumlahDipesanTextField;
    private javax.swing.JTextField jumlahDiterimaTextField;
    private javax.swing.JTextField namaBarangTextField;
    private javax.swing.JTextField namaPenerimaBarangTextField;
    private javax.swing.JButton readButton;
    private javax.swing.JTable stock_barang;
    private javax.swing.JTextField tanggalWaktuPenerimaanTextField;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
