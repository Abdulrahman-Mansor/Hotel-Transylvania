
package LogIn;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class LogInFrame extends javax.swing.JFrame {
//    Color theme = new Color(190,104,255);
    Color theme = new Color(90, 174, 69);
    public LogInFrame() {
        initComponents();
        init();
    }
    
    private void init(){
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.white);
        usernameText.setText("");
        passwordText.setText("");
        usernameText.setLabelText("Username");
        passwordText.setLabelText("Password");
        usernameText.setLineColor(theme);
        passwordText.setLineColor(theme);
        loginButton.setBackground(theme);
        loginButton.setOpaque(false);
        loginButton.setRound(30);
        loginButton.setRippleColor(Color.white);
        loginButton.setShadowColor(Color.gray);
        loginButton.setForeground(new Color(255, 239, 241));
        loginButton.setFocusable(false);
        rightPanel1.setTheme(theme);
    }


    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginButton = new button.Button();
        usernameText = new textfield.TextField();
        passwordText = new textfield.PasswordField();
        rightPanel1 = new LogIn.RightPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setOpacity(0.989F);

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        usernameText.setText("textField1");

        passwordText.setText("passwordField1");

        javax.swing.GroupLayout rightPanel1Layout = new javax.swing.GroupLayout(rightPanel1);
        rightPanel1.setLayout(rightPanel1Layout);
        rightPanel1Layout.setHorizontalGroup(
            rightPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 335, Short.MAX_VALUE)
        );
        rightPanel1Layout.setVerticalGroup(
            rightPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(usernameText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(rightPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
            .addComponent(rightPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        String username = usernameText.getText();
        String password = String.valueOf(passwordText.getPassword());
        String sqlQuery = "SELECT * FROM Admin where UserName ='" + username +"' AND Password ='" + password + "'";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Hotel;encrypt=true;trustServerCertificate=true", "Admin", "1234");
            PreparedStatement pst = conn.prepareStatement(sqlQuery);
            ResultSet result = pst.executeQuery();
            if(!result.next()){
//                JOptionPane.showMessageDialog(null,"Username and Password is incrorrect");
                new MessageDialog("Username and Password is incorrect!", this).setVisible(true);
            }
            else{
                new main.Main().setVisible(true);
                this.setVisible(false);
            }
        }catch (Exception ex) {
            System.out.println("Class sql server not found");
            JOptionPane.showMessageDialog(null, ex);
        }

    }//GEN-LAST:event_loginButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogInFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.Button loginButton;
    private textfield.PasswordField passwordText;
    private LogIn.RightPanel rightPanel1;
    private textfield.TextField usernameText;
    // End of variables declaration//GEN-END:variables
}
