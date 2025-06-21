/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gymboots;

/**
 *
 * @author Cloud
 */
import models.interfaces.Payment;
import models.Person;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class GymManagementGUI extends javax.swing.JFrame {
    private List<Person> personList;
    private DefaultTableModel tableModel;
    private int anggotaCounter = 1;
    private int pelatihCounter = 1;
    private javax.swing.JButton infoButton;

    public GymManagementGUI() {
        initComponents();
        personList = new ArrayList<>();
        initializeTable();
        initButtonActions();
        infoButton = new javax.swing.JButton();
        infoButton.setText("Info");
        infoButton.addActionListener(e -> showMemberInfo());
    }
    
    private void showMemberInfo() {
        try {
            int selectedRow = tabel_data_anggota.getSelectedRow();
            if (selectedRow < 0 || selectedRow >= personList.size()) {
                throw new DataTidakDitemukanException("Pilih data terlebih dahulu!");
            }

            Person person = personList.get(selectedRow);
            StringBuilder info = new StringBuilder();

            info.append("Informasi Detail:\n");
            info.append(person.toString()).append("\n\n");

            if (person instanceof Membership) {
                Membership member = (Membership) person;
                info.append("Status Membership: ")
                        .append(member.isMembershipActive() ? "Aktif" : "Non-Aktif")
                        .append("\n");
            }

            if (person instanceof Payment) {
                Payment payment = (Payment) person;
                info.append(payment.getPaymentInfo()).append("\n");
            }

            if (person instanceof Training) {
                Training training = (Training) person;
                info.append(training.getTrainingSchedule()).append("\n");
            }

            JOptionPane.showMessageDialog(this, info.toString(),
                    "Informasi Lengkap", JOptionPane.INFORMATION_MESSAGE);

        } catch (DataTidakDitemukanException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initializeTable() {
        tableModel = new DefaultTableModel(
            new Object[]{"Nama", "Role", "Detail", "Durasi"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Membuat tabel tidak bisa di-edit
            }
        };
        tabel_data_anggota.setModel(tableModel);
    }
    

    private void initButtonActions() {
        // Simpan Button
        simpanButton.addActionListener(e -> {
            try {
                String nama = namaText.getText().trim();
                if (nama.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong!", 
                        "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String program = (String) programCombo.getSelectedItem();
                int durasi = (int) durasiSpinner.getValue();

                if (pelatihRadio.isSelected()) {
                    Pelatih pelatih = new Pelatih(
                        nama, 
                        "TRN" + String.format("%03d", pelatihCounter++), 
                        program, 
                        150000
                    );
                    pelatih.setDurasi(durasi);
                    personList.add(pelatih);
                } else {
                    AnggotaBiasa anggota = new AnggotaBiasa(
                        nama,
                        "GYM" + String.format("%03d", anggotaCounter++),
                        program,
                        durasi,
                        "Pemula"
                    );
                    personList.add(anggota);
                }

                refreshTable();
                clearForm();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });

        // Submit Button
        submitButton.addActionListener(e -> simpanButton.doClick());

        // Hapus Button
        hapusButton.addActionListener(e -> {
            int selectedRow = tabel_data_anggota.getSelectedRow();
            if (selectedRow >= 0 && selectedRow < personList.size()) {
                personList.remove(selectedRow);
                refreshTable();
            } else {
                JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus!", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Batal Button
        batalButton.addActionListener(e -> clearForm());

        // Close Button
        closeButton.addActionListener(e -> System.exit(0));

        // Radio Button untuk jenis anggota
        anggotaRadio.addActionListener(e -> {
            if (anggotaRadio.isSelected()) {
                programCombo.setModel(new DefaultComboBoxModel<>(
                    new String[]{"Kardio", "Angkat Beban", "Kekuatan", "Peregangan"}));
            }
        });

        pelatihRadio.addActionListener(e -> {
            if (pelatihRadio.isSelected()) {
                programCombo.setModel(new DefaultComboBoxModel<>(
                    new String[]{"Personal Training", "Group Training", "Specialized Training"}));
            }
        });
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Person person : personList) {
            String role = person.getRole();
            String detail = person.toString();
            String durasi = "";
            
            if (person instanceof AnggotaGym) {
                durasi = ((AnggotaGym) person).getDurasi() + " bulan";
            }
            
            tableModel.addRow(new Object[]{
                person.getNama(),
                role,
                detail,
                durasi
            });
        }
    }

    private void clearForm() {
        namaText.setText("");
        programCombo.setSelectedIndex(0);
        durasiSpinner.setValue(1);
        anggotaRadio.setSelected(true);
        namaText.requestFocus();
    }
    
    // Custom Exception Classes
    class InputTidakValidException extends Exception {

        public InputTidakValidException(String message) {
            super(message);
        }
    }

    class DataTidakDitemukanException extends Exception {

        public DataTidakDitemukanException(String message) {
            super(message);
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

        jLabel1 = new javax.swing.JLabel();
        namaText = new javax.swing.JTextField();
        anggotaRadio = new javax.swing.JRadioButton();
        pelatihRadio = new javax.swing.JRadioButton();
        programCombo = new javax.swing.JComboBox<>();
        durasiSpinner = new javax.swing.JSpinner();
        simpanButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_data_anggota = new javax.swing.JTable();
        hapusButton = new javax.swing.JButton();
        batalButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nama");

        namaText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaTextActionPerformed(evt);
            }
        });

        anggotaRadio.setText("Anggota Biasa");

        pelatihRadio.setText("Pelatih");

        programCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kardio", "Angkat Beban", "Kekuatan", "Peregangan" }));

        simpanButton.setText("Simpan");
        simpanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Data Gym Management");

        tabel_data_anggota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nama", "Keterangan", "Jenis latihan", "Langganan"
            }
        ));
        jScrollPane2.setViewportView(tabel_data_anggota);

        hapusButton.setText("Hapus");
        hapusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusButtonActionPerformed(evt);
            }
        });

        batalButton.setText("Batal");
        batalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalButtonActionPerformed(evt);
            }
        });

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(programCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pelatihRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(anggotaRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(durasiSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(104, 104, 104))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(namaText, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(241, 241, 241))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(simpanButton)
                        .addGap(39, 39, 39)
                        .addComponent(hapusButton)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(batalButton)
                                .addGap(31, 31, 31)
                                .addComponent(closeButton)))
                        .addGap(34, 34, 34))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(namaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(anggotaRadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pelatihRadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(programCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(durasiSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(simpanButton)
                    .addComponent(hapusButton)
                    .addComponent(batalButton)
                    .addComponent(closeButton))
                .addGap(18, 18, 18)
                .addComponent(submitButton)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void namaTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaTextActionPerformed

    private void simpanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanButtonActionPerformed

    }//GEN-LAST:event_simpanButtonActionPerformed

    private void hapusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hapusButtonActionPerformed

    private void batalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_batalButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_closeButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_submitButtonActionPerformed

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
            java.util.logging.Logger.getLogger(GymManagementGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GymManagementGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GymManagementGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GymManagementGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GymManagementGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton anggotaRadio;
    private javax.swing.JButton batalButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JSpinner durasiSpinner;
    private javax.swing.JButton hapusButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField namaText;
    private javax.swing.JRadioButton pelatihRadio;
    private javax.swing.JComboBox<String> programCombo;
    private javax.swing.JButton simpanButton;
    private javax.swing.JButton submitButton;
    private javax.swing.JTable tabel_data_anggota;
    // End of variables declaration//GEN-END:variables
}
