
package services;

import LogIn.MessageDialog;
import MainPanels.CenterPanelChildForm;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Date;
import java.time.LocalDateTime;
/**
 *
 * @author Mansour
 */
public class ServicesPanel extends CenterPanelChildForm {

    public ServicesPanel() {
        initComponents();
        init();
    }
    Connection conn;
    PreparedStatement pst;
    ResultSet result;
    String roomNumber = null, clientId = null;
    boolean key = false, rnColor = true, stColor = true, snColor = true;
    private void init(){
        serviceNameCombo.setLabeText("Service Name");
        serviceTypeCombo.setLabeText("Service Type");
        roomNumberCombo.setLabeText("Room Number");
        try{
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Hotel;encrypt=true;trustServerCertificate=true", "Admin", "1234");
            pst = conn.prepareStatement("SELECT DISTINCT ServiceType FROM Service");
            result = pst.executeQuery();
            while(result.next()){
                String s = result.getString("ServiceType");
                serviceTypeCombo.addItem(s);
            }
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        try {
            result = conn.prepareStatement("SELECT Room_Number FROM Room").executeQuery();
            while (result.next()) {
                String s = result.getString("Room_Number");
                roomNumberCombo.addItem(s);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        serviceNameCombo.setSelectedIndex(-1);
        serviceTypeCombo.setSelectedIndex(-1);
        roomNumberCombo.setSelectedIndex(-1);
        key = true;

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        serviceTypeCombo = new combobox.Combobox();
        serviceNameCombo = new combobox.Combobox();
        roomNumberCombo = new combobox.Combobox();
        roomInfo = new services.RoomInfo();
        clientInfo = new services.ClientInfo();
        cancelButton = new button.Button();
        applyButton = new button.Button();
        jSeparator1 = new javax.swing.JSeparator();
        servicesRec2 = new services.ServicesRec();
        columnsNames1 = new services.ColumnsNames();

        serviceTypeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serviceTypeComboActionPerformed(evt);
            }
        });

        serviceNameCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serviceNameComboActionPerformed(evt);
            }
        });

        roomNumberCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomNumberComboActionPerformed(evt);
            }
        });

        cancelButton.setBackground(new java.awt.Color(212, 72, 58));
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        applyButton.setBackground(new java.awt.Color(46, 163, 146));
        applyButton.setText("Apply");
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addGap(639, 639, 639))
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(servicesRec2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(columnsNames1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(serviceTypeCombo, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                .addComponent(serviceNameCombo, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                .addComponent(roomNumberCombo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(applyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24)
                        .addComponent(clientInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(roomInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(serviceTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(serviceNameCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(roomNumberCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(applyButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(roomInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                            .addComponent(clientInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(columnsNames1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(servicesRec2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void serviceTypeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serviceTypeComboActionPerformed
        if(key){
            if (stColor) {
                serviceTypeCombo.setLineColor(new Color(46, 163, 146));
            } else {
                serviceTypeCombo.setLineColor(new Color(212, 72, 58));
            }
            stColor = !stColor;
            try {
                serviceNameCombo.removeAllItems();
                String selType = (String)serviceTypeCombo.getSelectedItem();
                result = conn.prepareStatement("SELECT DISTINCT SName FROM Service WHERE ServiceType = '" + selType + "'").executeQuery();
                while (result.next()) {
                    String s = result.getString("SName");
                    serviceNameCombo.addItem(s);
                }
                serviceNameCombo.setSelectedIndex(-1);
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }//GEN-LAST:event_serviceTypeComboActionPerformed

    private void roomNumberComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomNumberComboActionPerformed
        if(key){
            if (rnColor) {
                roomNumberCombo.setLineColor(new Color(46, 163, 146));
            } else {
                roomNumberCombo.setLineColor(new Color(212, 72, 58));
            }
            rnColor = !rnColor;
            String selRoom = (String)roomNumberCombo.getSelectedItem();
            try{
                result = conn.prepareStatement("SELECT Client.*, Room.*\n"
                        + "FROM Client\n"
                        + "JOIN Check_In_Out ON Client.ClientID = Check_In_Out.clientID\n"
                        + "JOIN Room ON Check_In_Out.Room_N = Room.Room_Number\n"
                        + "WHERE Room.Room_Number = " + selRoom +"\n"
                        + "ORDER BY Check_In_Out.StartDate DESC").executeQuery();
                while(result.next()){
                    String gen = "Male";
                    if(result.getString("Gender").equals("0"))
                        gen = "Female";
                    this.clientId = result.getString("ClientID");
                    this.roomNumber = result.getString("Room_Number");
                    roomInfo.setInfo(result.getString("Class"), this.roomNumber, result.getString("Beds_No"), result.getString("Status"), result.getString("Price_per_day"));
                    clientInfo.setInfo(this.clientId, result.getString("Name"), result.getString("Nationality"), result.getString("Phone"), gen);
                    break;
                }
            }
            catch(SQLException ex){
                System.out.println(ex);
            }
            revalidate();
        }
    }//GEN-LAST:event_roomNumberComboActionPerformed

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed
        String selName = (String)serviceNameCombo.getSelectedItem();
        String selType = (String)serviceTypeCombo.getSelectedItem();
        LocalDateTime dateTime = LocalDateTime.now();
        try{
            selName.length();
            selType.length();
            this.clientId.length();
            this.roomNumber.length();
            
//            pst = conn.prepareStatement("INSERT INTO askFor (ClientID, serviceType, SName, ServiceDate, ServiceTime) VALUES\n"
//                                         + "(" + clientId + ", '" + selType + "', '" + selName + "', '" + date +"', '" + time + "')");
            pst = conn.prepareStatement("INSERT INTO askFor ( ClientID, serviceType, SName, ServiceDate, ServiceTime) VALUES (?, ?, ?, ?, ?)");
            pst.setInt(1, Integer.parseInt(clientId));
            pst.setString(2, selType);
            pst.setString(3, selName);
            pst.setDate(4,Date.valueOf(dateTime.toLocalDate()));   
            pst.setTime(5, Time.valueOf(dateTime.toLocalTime()));
            int rowsAffected = pst.executeUpdate();
            pst.close();
            System.out.println(rowsAffected);
        }
        catch(Exception ex){
            System.out.println(ex);
            new MessageDialog("WrongInput", this).setVisible(true);
        }
        new MessageDialog("Service Applied", this).setVisible(true);
        cancelButton.doClick();
               
    }//GEN-LAST:event_applyButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        clientInfo.setInfo("", "", "", "", "");
        roomInfo.setInfo("", "", "", "", "");
        this.clientId = this.roomNumber = null;
        roomNumberCombo.setSelectedIndex(-1);
        serviceNameCombo.setSelectedIndex(-1);
        serviceTypeCombo.setSelectedIndex(-1);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void serviceNameComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serviceNameComboActionPerformed
        if(key){
            if(snColor){
                serviceNameCombo.setLineColor(new Color(46, 163, 146));
            }
            else{
                serviceNameCombo.setLineColor(new Color(212, 72, 58));
            }
            snColor = !snColor;
        }
    }//GEN-LAST:event_serviceNameComboActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.Button applyButton;
    private button.Button cancelButton;
    private services.ClientInfo clientInfo;
    private services.ColumnsNames columnsNames1;
    private javax.swing.JSeparator jSeparator1;
    private services.RoomInfo roomInfo;
    private combobox.Combobox roomNumberCombo;
    private combobox.Combobox serviceNameCombo;
    private combobox.Combobox serviceTypeCombo;
    private services.ServicesRec servicesRec2;
    // End of variables declaration//GEN-END:variables
}
