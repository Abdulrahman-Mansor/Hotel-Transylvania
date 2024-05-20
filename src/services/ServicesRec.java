
package services;

import MainPanels.CenterPanelChildForm;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Mansour
 */
public class ServicesRec extends JPanel {

    /**
     * Creates new form ServicesRec
     */
    JPanel innerPanel;
    JScrollPane scroll;
    Connection conn;
    PreparedStatement pst;
    ResultSet result;
    public ServicesRec() {
        initComponents();
        init();
    }
    public void init(){
        innerPanel = new JPanel();
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
        scroll = new raven.scroll.win11.ScrollPaneWin11();
        scroll.setPreferredSize(new Dimension(500,291));
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Hotel;encrypt=true;trustServerCertificate=true", "Admin", "1234");
            pst = conn.prepareStatement("SELECT * FROM askFor");
            result = pst.executeQuery();
            while (result.next()) {
                int serviceId = result.getInt("AskForID");
                int clientId = result.getInt("ClientID");
                String service = result.getString("ServiceType");
                service += " " + result.getString("SName");
                String sDate = result.getString("ServiceDate");
                String sTime = result.getString("ServiceTime");
                SRecord record = new SRecord(Integer.toString(serviceId),Integer.toString(clientId), service,sDate, sTime);
                record.setPreferredSize(new Dimension(500, 36));
                record.setMaximumSize(new Dimension(500, 36));
                record.setMinimumSize(new Dimension(500, 36));
                record.setBackground(Color.white);
                innerPanel.add(record);
                JPanel subPanel = new JPanel();
                subPanel.setPreferredSize(new Dimension(500, 5));
                subPanel.setMaximumSize(new Dimension(500, 5));
                subPanel.setMinimumSize(new Dimension(500, 5));
                subPanel.setBackground(new Color(135, 135, 135));
                innerPanel.add(subPanel);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } 
        innerPanel.setBackground(Color.white);
        scroll.setViewportView(innerPanel);
        this.add(scroll, BorderLayout.CENTER);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
