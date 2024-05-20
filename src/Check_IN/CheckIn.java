/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package Check_IN;

import LogIn.MessageDialog;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import combo_suggestion.ComboBoxSuggestion;
import combobox.Combobox;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import textfield.TextField;

/**
 *
 * @author ZBOOK
 */
public class CheckIn extends MainPanels.CenterPanelChildForm {

    /** Creates new form CheckIn */
    public CheckIn() {
        initComponents();
        this.setBackground(Color.white);
        init();
        
    }
    java.sql.Connection con;
    private void init() {
        NameTextField.setLabelText("Name");
        PhoneTextField.setLabelText("Phone Number");
        CheckInTextField.setLabelText("Check In date");
        NumOfBedsCombo.setLabeText("Number Of Beds");
        ClassComboBox.setLabeText("Class");
        RoomNumComboBox.setLabeText("Room Number");
        
        
        
        
        
        SaveButton.setFocusable(false);
        SaveButton.setBackground(new Color(215, 209, 209));
        CancelButton.setFocusable(false);
        CancelButton.setBackground(new Color(215, 209, 209));        
        ButtonGroup buttonGroup = new ButtonGroup();
        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup.add(MaleRadioButton);
        buttonGroup.add(FemaleRadioButton);
        buttonGroup2.add(NoCompanionRadioButton);
        buttonGroup2.add(YesCompanionRadioButton);
    
        ResultSet rs;
        String sqlqurey = "SELECT * FROM dbo.Room WHERE Status = " + 0 + " ";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Hotel;encrypt=true;trustServerCertificate=true", "Admin", "1234");
            java.sql.PreparedStatement pst = con.prepareStatement(sqlqurey);
            rs = pst.executeQuery();
            while (rs.next()) {
                RoomNumComboBox.addItem(rs.getString("Room_Number"));
                NumOfBedsCombo.addItem(String.valueOf(rs.getFloat("Price_per_day")));
                ClassComboBox.addItem(rs.getString("Class"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        String[] countries = Locale.getISOCountries();
        comboBoxSuggestion1.addItem("Nationality");
        for (int i = 0; i < countries.length; i++) {
            Locale locale = new Locale("", countries[i]);
            comboBoxSuggestion1.addItem(locale.getDisplayCountry());
        }
        ClassComboBox.setSelectedIndex(-1);
        RoomNumComboBox.setSelectedIndex(-1);
        NumOfBedsCombo.setSelectedIndex(-1);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboSuggestionUI1 = new combo_suggestion.ComboSuggestionUI();
        NameTextField = new textfield.TextField();
        PhoneTextField = new textfield.TextField();
        MaleRadioButton = new radio_button.RadioButtonCustom();
        FemaleRadioButton = new radio_button.RadioButtonCustom();
        NumOfBedsCombo = new combobox.Combobox();
        ClassComboBox = new combobox.Combobox();
        SaveButton = new javax.swing.JButton();
        CheckInTextField = new textfield.TextField();
        jLabel1 = new javax.swing.JLabel();
        NoCompanionRadioButton = new radio_button.RadioButtonCustom();
        YesCompanionRadioButton = new radio_button.RadioButtonCustom();
        RoomNumComboBox = new combobox.Combobox();
        comboBoxSuggestion1 = new combo_suggestion.ComboBoxSuggestion();
        CancelButton = new javax.swing.JButton();

        NameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameTextFieldActionPerformed(evt);
            }
        });

        PhoneTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhoneTextFieldActionPerformed(evt);
            }
        });

        MaleRadioButton.setText("Male");
        MaleRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaleRadioButtonActionPerformed(evt);
            }
        });

        FemaleRadioButton.setText("Female");
        FemaleRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FemaleRadioButtonActionPerformed(evt);
            }
        });

        NumOfBedsCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumOfBedsComboActionPerformed(evt);
            }
        });

        SaveButton.setText("Save");
        SaveButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                SaveButtonFocusLost(evt);
            }
        });
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Do you have Companions ?");

        NoCompanionRadioButton.setText("No");

        YesCompanionRadioButton.setText("Yes");
        YesCompanionRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YesCompanionRadioButtonActionPerformed(evt);
            }
        });

        RoomNumComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomNumComboBoxActionPerformed(evt);
            }
        });

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(CheckInTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NumOfBedsCombo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RoomNumComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PhoneTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(ClassComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(comboBoxSuggestion1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MaleRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(FemaleRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NoCompanionRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(YesCompanionRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(203, 203, 203))
            .addGroup(layout.createSequentialGroup()
                .addGap(375, 375, 375)
                .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(CancelButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RoomNumComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxSuggestion1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CheckInTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClassComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NumOfBedsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MaleRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FemaleRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(YesCompanionRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NoCompanionRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveButton)
                    .addComponent(CancelButton))
                .addContainerGap(148, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void NameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameTextFieldActionPerformed

    private void MaleRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaleRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaleRadioButtonActionPerformed

    private void FemaleRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FemaleRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FemaleRadioButtonActionPerformed

    private void PhoneTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhoneTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PhoneTextFieldActionPerformed

    private void NumOfBedsComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumOfBedsComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NumOfBedsComboActionPerformed

    private void SaveButtonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SaveButtonFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_SaveButtonFocusLost

    private void YesCompanionRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YesCompanionRadioButtonActionPerformed
        // TODO add your handling code here:
        String check[] = {NameTextField.getText(), PhoneTextField.getText(), CheckInTextField.getText()};
        TextField ch [] = {NameTextField, PhoneTextField, CheckInTextField};
        Combobox comb[] = {RoomNumComboBox, NumOfBedsCombo, ClassComboBox};
        ComboBoxSuggestion combSug[] = {comboBoxSuggestion1};
        int i = 0;
        for(; i < check.length; i++) {
            if(check[i].isEmpty()) {
                if(i == 3) {
                    continue;
                }
                JOptionPane.showMessageDialog(this, "Fill in Information", "Error", JOptionPane.ERROR_MESSAGE);  
                ch[i].setLineColor(Color.red);
                ch[i].requestFocus();
                break;
            }
            else {
                ch[i].setLineColor(new Color(3, 155, 216));
                if(i == 2 || i == 3) {
                String format = "yyyy-MM-dd";
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                try {
                    // Parse the date string
                    Date date = sdf.parse(check[i]);
                    if(i == 3) {
                        Date startDate = sdf.parse(check[2]);
                        Date endDate = sdf.parse(check[3]);
                            
                        if(endDate.before(startDate)) {
                            JOptionPane.showMessageDialog(this, "Review the Date", "Error", JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                    }
                    // If parsing successful, the date string is valid
                        
                } catch (ParseException e) {
                        // Parsing failed, date string is not valid
                        JOptionPane.showMessageDialog(this, "Wrong in the Date", "Error", JOptionPane.ERROR_MESSAGE);  
                        ch[i].setLineColor(Color.red);
                        ch[i].requestFocus();
                        break;                        
                    }                    
                }
            }
                if(i == check.length - 1) {
                    if(!(MaleRadioButton.isSelected() || FemaleRadioButton.isSelected())) {
                        JOptionPane.showMessageDialog(this, "Fill in Information", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }                     
                }                      
            }
            int j = 0;
            if(i == check.length){
                for(j = 0; j < comb.length; j++) {
                    if(comb[j].getSelectedItem() == "") {
                        JOptionPane.showMessageDialog(this, "Fill in Information", "Error", JOptionPane.ERROR_MESSAGE);  
                        comb[j].setLineColor(Color.red);
                        comb[j].requestFocus();  
                        break;
                    }
                    else {
                        comb[j].setLineColor(new Color(3, 155, 216));
                    }      
                    if(j == comb.length - 1) {
                        if(combSug[0].getSelectedItem() == "Nationality") {
                            JOptionPane.showMessageDialog(this, "Fill in Nationality", "Error", JOptionPane.ERROR_MESSAGE); 
                            break;
                        }                
                    }
                }
            }
        
        ///////////////////////////////////////////////////////////////////////////////////////
            if(j == comb.length) {
                try{
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Hotel;encrypt=true;trustServerCertificate=true", "Admin", "1234");
                        // insert into client table
                        PreparedStatement pstClient = conn.prepareStatement("INSERT INTO Client (Nationality, Phone, Name, Gender) VALUES (?, ?, ?, ?)");
                        pstClient.setString(1, (String) comboBoxSuggestion1.getSelectedItem());
                        pstClient.setString(2, PhoneTextField.getText());
                        pstClient.setString(3, NameTextField.getText());
                        if(MaleRadioButton.isSelected())
                            pstClient.setBoolean(4, true);
                        else if(FemaleRadioButton.isSelected())
                            pstClient.setBoolean(4, false);
            
            
                        pstClient.executeUpdate();
            
            
            
                        // Get ClientID From Client table
                        PreparedStatement pst = conn.prepareStatement("SELECT MAX(ClientID) AS LastClientID FROM Client");

                        ResultSet rs = pst.executeQuery();
                        int clientId = 0;
                        if(rs.next()) {
                           clientId = rs.getInt("LastClientID");
                        }
            
                        // insert into check in out table
                        PreparedStatement pstCheckInOut = conn.prepareStatement("insert into Check_In_Out (clientID, Room_N, StartDate, EndDate) VALUES (?, ?, ?, ?)");
            
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        pstCheckInOut.setInt(1, clientId);
                        pstCheckInOut.setInt(2, Integer.parseInt((String) RoomNumComboBox.getSelectedItem()));
                        // Convert java.util.Date to java.sql.Date
                        java.util.Date checkInDate = sdf.parse(CheckInTextField.getText());
                        java.sql.Date sqlCheckInDate = new java.sql.Date(checkInDate.getTime());
                        pstCheckInOut.setDate(3, sqlCheckInDate);

                        
            
                        pstCheckInOut.executeUpdate();
                        NameTextField.setText("");
                        PhoneTextField.setText("");
                        comboBoxSuggestion1.setSelectedIndex(0);
                        MaleRadioButton.setSelected(false);
                        FemaleRadioButton.setSelected(false);   
                        NoCompanionRadioButton.setSelected(false);
                        YesCompanionRadioButton.setSelected(false);  
                        CheckInTextField.setText("");
                        ClassComboBox.setSelectedIndex(0);
                        RoomNumComboBox.setSelectedIndex(0);
                        NumOfBedsCombo.setSelectedIndex(0);
                        j++;
                            
                    }
                    catch(Exception e) {
                          e.printStackTrace();
                    }
                }        
            if(j > comb.length) {
                String input = JOptionPane.showInputDialog(this, "How many Companions do you have ?");
                if(input != null) {
                    
                    try{
                          
                        int number = Integer.parseInt(input);
                        if(number > 0) {
                            NewJFrame1 frame = new NewJFrame1(number);
                            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            frame.setLocationRelativeTo(this);
                            frame.setTitle("Companion");
                            frame.setVisible(true);
                    
                        }
                        else if(number == 0) {
                            NoCompanionRadioButton.setSelected(true);
                        }
                    }
                    catch (NumberFormatException ex) { // If the input cannot be parsed into an integer, this catch block handles the NumberFormatException by displaying an error message using a JOptionPane.
                        JOptionPane.showMessageDialog(this, "Invalid input. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                
                }
                        
         }
    }//GEN-LAST:event_YesCompanionRadioButtonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        // TODO add your handling code here:
        String check[] = {NameTextField.getText(), PhoneTextField.getText(), CheckInTextField.getText()};
        TextField ch [] = {NameTextField, PhoneTextField, CheckInTextField};
        Combobox comb[] = {RoomNumComboBox, NumOfBedsCombo, ClassComboBox};
        ComboBoxSuggestion combSug[] = {comboBoxSuggestion1};
        int i = 0;
        for(; i < check.length; i++) {
            if(check[i].isEmpty()) {
                if(i == 3) {
                    continue;
                }
               JOptionPane.showMessageDialog(this, "Fill in Information", "Error", JOptionPane.ERROR_MESSAGE);  
               ch[i].setLineColor(Color.red);
               ch[i].requestFocus();
               break;
            }
            else {
                ch[i].setLineColor(new Color(3, 155, 216));
                if(i == 2 || i == 3) {
                    String format = "yyyy-MM-dd";
                    SimpleDateFormat sdf = new SimpleDateFormat(format);
                    try {
                        // Parse the date string
                        Date date = sdf.parse(check[i]);
                        if(i == 3) {
                            Date startDate = sdf.parse(check[2]);
                            Date endDate = sdf.parse(check[3]);
                            
                            if(endDate.before(startDate)) {
                                JOptionPane.showMessageDialog(this, "Review the Date", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                            }
                        }
                        // If parsing successful, the date string is valid
                        
                    } catch (ParseException e) {
                        // Parsing failed, date string is not valid
                        JOptionPane.showMessageDialog(this, "Wrong in the Date", "Error", JOptionPane.ERROR_MESSAGE);  
                        ch[i].setLineColor(Color.red);
                        ch[i].requestFocus();
                        break;                        
                    }                    
                }
            }
            if(i == check.length - 1) {
                if(!(MaleRadioButton.isSelected() || FemaleRadioButton.isSelected())) {
                    JOptionPane.showMessageDialog(this, "Fill in Information", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                }
                    if(!(YesCompanionRadioButton.isSelected() || NoCompanionRadioButton.isSelected())) {
                        JOptionPane.showMessageDialog(this, "Fill in Information", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }                 
        }                      
        }
        int j = 0;
        if(i == check.length){
            for(j = 0; j < comb.length; j++) {
                if(comb[j].getSelectedItem() == "") {
                    JOptionPane.showMessageDialog(this, "Fill in Information", "Error", JOptionPane.ERROR_MESSAGE);  
                    comb[j].setLineColor(Color.red);
                    comb[j].requestFocus();  
                    break;
                }
                else {
                    comb[j].setLineColor(new Color(3, 155, 216));
                }      
                 if(j == comb.length - 1) {
                    if(combSug[0].getSelectedItem() == "Nationality") {
                        JOptionPane.showMessageDialog(this, "Fill in Nationality", "Error", JOptionPane.ERROR_MESSAGE); 
                        break;
                    }                
            }
            }
        }
        
        ///////////////////////////////////////////////////////////////////////////////////////
       if(j == comb.length) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Hotel;encrypt=true;trustServerCertificate=true", "Admin", "1234");
            // insert into client table
            PreparedStatement pstClient = conn.prepareStatement("INSERT INTO Client (Nationality, Phone, Name, Gender) VALUES (?, ?, ?, ?)");
            pstClient.setString(1, (String) comboBoxSuggestion1.getSelectedItem());
            pstClient.setString(2, PhoneTextField.getText());
            pstClient.setString(3, NameTextField.getText());
            if(MaleRadioButton.isSelected())
                pstClient.setBoolean(4, true);
            else if(FemaleRadioButton.isSelected())
                pstClient.setBoolean(4, false);
            
            
            pstClient.executeUpdate();
            
            // insert into room table
            PreparedStatement pstRoom = conn.prepareStatement("INSERT INTO Room (Class, Beds_No, Price_per_day, Status, Room_Number) VALUES (?, ?, ?, ?, ?)");
            pstRoom.setString(1, (String) ClassComboBox.getSelectedItem());
            pstRoom.setInt(2,  Integer.parseInt((String) NumOfBedsCombo.getSelectedItem())); //getSelectedItem() method returns an Object
            pstRoom.setBoolean(4, true); // Full
            pstRoom.setInt(5,  Integer.parseInt((String) RoomNumComboBox.getSelectedItem()));
            
            pstRoom.executeUpdate();
            
            
            // Get ClientID From Client table
            PreparedStatement pst = conn.prepareStatement("SELECT MAX(ClientID) AS LastClientID FROM Client");

            ResultSet rs = pst.executeQuery();
            int clientId = 0;
            if(rs.next()) {
                clientId = rs.getInt("LastClientID");
            }
            
            // insert into check in out table
            PreparedStatement pstCheckInOut = conn.prepareStatement("insert into Check_In_Out (clientID, Room_N, StartDate, EndDate) VALUES (?, ?, ?, ?)");
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            pstCheckInOut.setInt(1, clientId);
            pstCheckInOut.setInt(2, Integer.parseInt((String) RoomNumComboBox.getSelectedItem()));
            // Convert java.util.Date to java.sql.Date
            java.util.Date checkInDate = sdf.parse(CheckInTextField.getText());
            java.sql.Date sqlCheckInDate = new java.sql.Date(checkInDate.getTime());
            pstCheckInOut.setDate(3, sqlCheckInDate);


            pstCheckInOut.executeUpdate();
            
            new MessageDialog("Saved", this).setVisible(true);
            NameTextField.setText("");
            PhoneTextField.setText("");
            comboBoxSuggestion1.setSelectedIndex(0);
            MaleRadioButton.setSelected(false);
            FemaleRadioButton.setSelected(false);   
            NoCompanionRadioButton.setSelected(false);
            YesCompanionRadioButton.setSelected(false);  
            CheckInTextField.setText("");
            ClassComboBox.setSelectedIndex(0);
            RoomNumComboBox.setSelectedIndex(0);
            NumOfBedsCombo.setSelectedIndex(0);
            
        }
        catch (Exception e) {
            e.printStackTrace();
            
            new MessageDialog("Room is Full", this).setVisible(true);
        }           
       }
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void RoomNumComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomNumComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RoomNumComboBoxActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        // TODO add your handling code here:
            NameTextField.setText("");
            PhoneTextField.setText("");
            comboBoxSuggestion1.setSelectedIndex(0);
            MaleRadioButton.setSelected(false);
            FemaleRadioButton.setSelected(false);   
            NoCompanionRadioButton.setSelected(false);
            YesCompanionRadioButton.setSelected(false);  
            CheckInTextField.setText("");
            ClassComboBox.setSelectedIndex(0);
            RoomNumComboBox.setSelectedIndex(0);
            NumOfBedsCombo.setSelectedIndex(0);
    }//GEN-LAST:event_CancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private textfield.TextField CheckInTextField;
    private combobox.Combobox ClassComboBox;
    private radio_button.RadioButtonCustom FemaleRadioButton;
    private radio_button.RadioButtonCustom MaleRadioButton;
    private textfield.TextField NameTextField;
    private radio_button.RadioButtonCustom NoCompanionRadioButton;
    private combobox.Combobox NumOfBedsCombo;
    private textfield.TextField PhoneTextField;
    private combobox.Combobox RoomNumComboBox;
    private javax.swing.JButton SaveButton;
    private radio_button.RadioButtonCustom YesCompanionRadioButton;
    private combo_suggestion.ComboBoxSuggestion comboBoxSuggestion1;
    private combo_suggestion.ComboSuggestionUI comboSuggestionUI1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
