package views;

import controllers.CountryController;
import controllers.LocationController;
import controllers.RegionController;
import icontrollers.ILocationController;
import icontrollers.IRegionController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Country;
import models.Location;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
import tools.DBConnection;


/**
 *
 * @author RR17
 */
public final class JILocationView extends javax.swing.JInternalFrame {

    DBConnection connection = new DBConnection();
    ILocationController ilc = new LocationController(connection.getConnection());
    
    public JILocationView() {
        initComponents();
        showTableLocation("");
        getDataComboCountryID();
    }
    
    public void resetTextLocation(){
        txtLocationID.setText("");
        txtStreetAddress.setText("");
        txtPostalCode.setText("");
        txtCity.setText("");
        txtStateProvince.setText("");
//        cmbCountryID.setText("");
        txtLocationID.setEditable(true);
        btnSaveLocation.setEnabled(true);
        getDataComboCountryID();
        cmbCountryID.setSelectedIndex(0);
    }
    
    public void showTableLocation(String key){
        DefaultTableModel model = (DefaultTableModel)tableLocation.getModel();
        Object[] row = new Object[7];
        List<Location> locations = ilc.search(key);
        if (key.isEmpty()) {
            locations = ilc.getAll();
        }
        for (int i = 0; i < locations.size(); i++) {
            row[0]=i+1;
            row[1]=locations.get(i).getId();
            row[2]=locations.get(i).getStreet();
            row[3]=locations.get(i).getPostal();
            row[4]=locations.get(i).getCity();
            row[5]=locations.get(i).getState();
            row[6]=locations.get(i).getCountry_id();
            model.addRow(row);
        }
    }
    
//    public void showTableLocation(String s){
//        DefaultTableModel model = (DefaultTableModel)tableLocation.getModel();
//        Object[] row = new Object[6];
//        for (int i = 0; i < ilc.getAll().size(); i++) {
//            row[0]=ilc.getAll().get(i).getId();
//            row[1]=ilc.getAll().get(i).getStreet();
//            row[2]=ilc.getAll().get(i).getPostal();
//            row[3]=ilc.getAll().get(i).getCity();
//            row[4]=ilc.getAll().get(i).getState();
//            row[5]=ilc.getAll().get(i).getCountry_id();
//            model.addRow(row);
//        }
//    }
    
//    public void updateTableLocation(){
//        DefaultTableModel model = (DefaultTableModel)tableLocation.getModel();
//        model.setRowCount(0);
//        showTableLocation();
//    }
    
    public void updateTableLocation(String s){
        DefaultTableModel model = (DefaultTableModel)tableLocation.getModel();
        model.setRowCount(0);
        showTableLocation(s);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        txtRegionId = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtRegionName = new javax.swing.JTextField();
        btnInsertRegion = new javax.swing.JButton();
        btnUpdateRegion = new javax.swing.JButton();
        btnDeleteRegion = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtRegionSearch = new javax.swing.JTextField();
        cmbRegionSearch = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRegion = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtLocationID = new javax.swing.JTextField();
        txtStreetAddress = new javax.swing.JTextField();
        txtPostalCode = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        txtStateProvince = new javax.swing.JTextField();
        txtSearchLocation = new javax.swing.JTextField();
        btnSaveLocation = new javax.swing.JButton();
        cmbSearch = new javax.swing.JComboBox<>();
        btnDeleteLocation = new javax.swing.JButton();
        btnResetLocation = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableLocation = new javax.swing.JTable();
        cmbCountryID = new javax.swing.JComboBox<>();
        btnPrint = new javax.swing.JButton();

        jLabel3.setText("ID");

        txtRegionId.setName(""); // NOI18N

        btnClear.setText("clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel4.setText("Name");

        btnInsertRegion.setText("insert");
        btnInsertRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertRegionActionPerformed(evt);
            }
        });

        btnUpdateRegion.setText("update");
        btnUpdateRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateRegionActionPerformed(evt);
            }
        });

        btnDeleteRegion.setText("delete");
        btnDeleteRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteRegionActionPerformed(evt);
            }
        });

        jLabel2.setText("Search");

        txtRegionSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRegionSearchKeyTyped(evt);
            }
        });

        cmbRegionSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL", "ID", "NAME" }));

        tableRegion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableRegion.getTableHeader().setReorderingAllowed(false);
        tableRegion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableRegionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableRegion);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("LOCATION");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Location Info");

        jLabel5.setText("Location ID");

        jLabel6.setText("Street Address");

        jLabel7.setText("Search");

        jLabel8.setText("Postal Code");

        jLabel9.setText("City");

        jLabel10.setText("State Province");

        jLabel11.setText("Country ID");

        txtSearchLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchLocationActionPerformed(evt);
            }
        });
        txtSearchLocation.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchLocationKeyTyped(evt);
            }
        });

        btnSaveLocation.setText("Save");
        btnSaveLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveLocationActionPerformed(evt);
            }
        });

        cmbSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL", "LocationID", "StreetAddress", "PostalCode", "City", "StateProvince", "CountryID" }));
        cmbSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSearchActionPerformed(evt);
            }
        });

        btnDeleteLocation.setText("Delete");
        btnDeleteLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteLocationActionPerformed(evt);
            }
        });

        btnResetLocation.setText("Reset");
        btnResetLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetLocationActionPerformed(evt);
            }
        });

        tableLocation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "LocationID", "StreetAddress", "PostalCode", "City", "StateProvince", "CountryID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableLocation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableLocationMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableLocation);
        if (tableLocation.getColumnModel().getColumnCount() > 0) {
            tableLocation.getColumnModel().getColumn(0).setResizable(false);
            tableLocation.getColumnModel().getColumn(1).setResizable(false);
            tableLocation.getColumnModel().getColumn(2).setResizable(false);
            tableLocation.getColumnModel().getColumn(3).setResizable(false);
            tableLocation.getColumnModel().getColumn(4).setResizable(false);
            tableLocation.getColumnModel().getColumn(5).setResizable(false);
            tableLocation.getColumnModel().getColumn(6).setResizable(false);
        }

        cmbCountryID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CountryID" }));
        cmbCountryID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCountryIDActionPerformed(evt);
            }
        });

        btnPrint.setText("Print");
        btnPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrintMouseClicked(evt);
            }
        });
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtSearchLocation)
                                .addGap(18, 18, 18)
                                .addComponent(cmbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel8))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtLocationID, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                                            .addComponent(txtPostalCode, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtStreetAddress, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(195, 195, 195)
                                        .addComponent(jLabel1))
                                    .addComponent(txtCity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11)
                                            .addComponent(btnPrint))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(btnSaveLocation)
                                                .addGap(37, 37, 37)
                                                .addComponent(btnDeleteLocation)
                                                .addGap(30, 30, 30)
                                                .addComponent(btnResetLocation)
                                                .addGap(10, 10, 10))
                                            .addComponent(cmbCountryID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtStateProvince))))
                                .addGap(29, 29, 29)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtLocationID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtStreetAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtStateProvince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cmbCountryID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveLocation)
                    .addComponent(btnDeleteLocation)
                    .addComponent(btnResetLocation)
                    .addComponent(btnPrint))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnInsertRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertRegionActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnInsertRegionActionPerformed

    private void btnUpdateRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateRegionActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnUpdateRegionActionPerformed

    private void btnDeleteRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteRegionActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnDeleteRegionActionPerformed

    private void txtRegionSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRegionSearchKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtRegionSearchKeyTyped

    private void tableRegionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableRegionMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tableRegionMouseClicked

    private void btnSaveLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveLocationActionPerformed
        String countryID = cmbCountryID.getSelectedItem().toString();
        String ctr = countryID.substring(0, countryID.indexOf("-")-1);
                
        
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin untuk melakukan insert?", "Confirm Insert", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(confirm==JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, ilc.save(txtLocationID.getText(), txtStreetAddress.getText(), txtPostalCode.getText(), txtCity.getText(), txtStateProvince.getText(), ctr));
            updateTableLocation("");
            resetTextLocation();
        }
    }//GEN-LAST:event_btnSaveLocationActionPerformed

    private void getDataComboCountryID(){
        for(Country country : new CountryController(connection.getConnection()).getAll()){
            cmbCountryID.addItem(country.getId()+ " - " + country.getName());
        }
    }
    
    private void btnDeleteLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteLocationActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin untuk melakukan delete?", "Confirm Update", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(confirm==JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, ilc.delete(txtLocationID.getText()));
            updateTableLocation("");
            resetTextLocation();
        }
    }//GEN-LAST:event_btnDeleteLocationActionPerformed

    private void tableLocationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableLocationMouseClicked
        DefaultTableModel model = (DefaultTableModel)tableLocation.getModel();
        int SelectedRowIndex = tableLocation.getSelectedRow();
        
        txtLocationID.setEditable(false);
        
        txtLocationID.setText(model.getValueAt(SelectedRowIndex, 1).toString());
        txtStreetAddress.setText(model.getValueAt(SelectedRowIndex, 2).toString());
        txtPostalCode.setText(model.getValueAt(SelectedRowIndex, 3).toString());
        txtCity.setText(model.getValueAt(SelectedRowIndex, 4).toString());
        txtStateProvince.setText(model.getValueAt(SelectedRowIndex, 5).toString());
        cmbCountryID.setSelectedItem(model.getValueAt(SelectedRowIndex, 6).toString());
    }//GEN-LAST:event_tableLocationMouseClicked

    private void btnResetLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetLocationActionPerformed
        resetTextLocation();
    }//GEN-LAST:event_btnResetLocationActionPerformed

    private void txtSearchLocationKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchLocationKeyTyped
        updateTableLocation(txtSearchLocation.getText());
    }//GEN-LAST:event_txtSearchLocationKeyTyped

    private void txtSearchLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchLocationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchLocationActionPerformed

    private void cmbSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSearchActionPerformed
        
    }//GEN-LAST:event_cmbSearchActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        //getParent untuk direktori yang ditempatinya
        JIReport jir = new JIReport("Location");
        this.getParent().add(jir);
        jir.setVisible(true);
        
    }//GEN-LAST:event_btnPrintActionPerformed

    private void cmbCountryIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCountryIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCountryIDActionPerformed

    private void btnPrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrintMouseClicked
        // TODO add your handling code here:
//        JIReport loReport = new JIReport();
//        this.cmbPrint.add(loReport);
//        loReport.show();
        
    }//GEN-LAST:event_btnPrintMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDeleteLocation;
    private javax.swing.JButton btnDeleteRegion;
    private javax.swing.JButton btnInsertRegion;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnResetLocation;
    private javax.swing.JButton btnSaveLocation;
    private javax.swing.JButton btnUpdateRegion;
    private javax.swing.JComboBox<String> cmbCountryID;
    private javax.swing.JComboBox<String> cmbRegionSearch;
    private javax.swing.JComboBox<String> cmbSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableLocation;
    private javax.swing.JTable tableRegion;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtLocationID;
    private javax.swing.JTextField txtPostalCode;
    private javax.swing.JTextField txtRegionId;
    private javax.swing.JTextField txtRegionName;
    private javax.swing.JTextField txtRegionSearch;
    private javax.swing.JTextField txtSearchLocation;
    private javax.swing.JTextField txtStateProvince;
    private javax.swing.JTextField txtStreetAddress;
    // End of variables declaration//GEN-END:variables
}
