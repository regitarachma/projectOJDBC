package views;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.File;
import java.io.IOException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import tools.DBConnection;

/**
 *
 * @author RR17
 */
public class JIReport extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIReport
     */
    //koneksi ke database
    DBConnection connection = new DBConnection();
    
    public JIReport(String Table) {
        initComponents();
//        report(R);
        report(Table);
    }
    
    //pemanggilan method untuk iReport
    public void report(String Table) {
        String ReportSource = null;
        
        //untuk mengambil file report ke dalam program u/ dapat dilakukan proses selanjutnya
        ReportSource = System.getProperty("user.dir")+ "/src/report/report"+Table+".jrxml";
        //ReportSource = System.getProperty("user.dir")+ "/reportRegion.jrxml";
        
        //menampilkan iReport
        try {
            //untuk proses kompilasi dari .jrxml ke .jasper
            JasperReport jasperReport = JasperCompileManager.compileReport(ReportSource);
            
            //untuk proses setting dan tampilan report dari file .jasper
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null, connection.getConnection());
            
            //menampilkan tabel report
            JRViewer viewer = new JRViewer(jasperPrint);   
            
                   
                   Container container = getContentPane();
                   container.setLayout(new BorderLayout());
                   container.add(viewer);
        } catch (JRException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
//    public void report() {
//        String ReportSource = null;
//        
//        //untuk mengambil file report ke dalam program u/ dapat dilakukan proses selanjutnya
////        ReportSource = System.getProperty("user.dir")+ "/report"+R+".jrxml";
//        ReportSource = System.getProperty("user.dir")+ "/reportEmployees.jrxml";
//        
//        //menampilkan iReport
//        try {
//            //untuk proses kompilasi dari .jrxml ke .jasper
//            JasperReport jasperReport = JasperCompileManager.compileReport(ReportSource);
//            
//            //untuk proses setting dan tampilan report dari file .jasper
//            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null, connection.getConnection());
//            
//            //menampilkan tabel report
//            JRViewer viewer = new JRViewer(jasperPrint);   
//            
//                   
//                   Container container = getContentPane();
//                   container.setLayout(new BorderLayout());
//                   container.add(viewer);
//        } catch (JRException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane2 = new javax.swing.JDesktopPane();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("LocationReport");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 511, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formInternalFrameActivated


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane2;
    // End of variables declaration//GEN-END:variables
}
