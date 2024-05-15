/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Employee;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
/**
 *
 * @author AhmedMagedMohamedHas
 */
public class E_Scroll extends javax.swing.JPanel {

    /**
     * Creates new form E_Scroll
     */
    ResultSet rs;
    private JPanel innerPanel;
    private JScrollPane jScrollPane1;
    
    public void change(int index) {
        this.removeAll();
        initComponents();
        //System.out.println(index);
//        this.remove(innerPanel);
        this.revalidate();
        this.repaint();
        this.setPreferredSize(new Dimension(830, 500));
        jScrollPane1 = new raven.scroll.win11.ScrollPaneWin11();
        String sqlqurey;
        if (index == 0) {
            sqlqurey = "SELECT Employee.*, Department.DName\n" +
                        "FROM Employee\n" +
                        "JOIN Department ON Employee.DID = Department.DID";
        } else {
            sqlqurey = "SELECT Employee.*, Department.DName\n" +
                        "FROM Employee\n" +
                        "JOIN Department ON Employee.DID = Department.DID\n" +
                        " WHERE Employee.DID = " + index+" ";
        }
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Hotel;encrypt=true;trustServerCertificate=true", "Admin", "1234");
            PreparedStatement pst = con.prepareStatement(sqlqurey);
            rs = pst.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        innerPanel = new JPanel();
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
        int cnt = 0;
        try {
            while (rs.next()) {
                cnt++;
                String FName = rs.getString("FirstName");
                String SName = rs.getString("LastName");
                String Phone = rs.getString("Phone");
                String Name = FName + " " + SName;
                int ID = rs.getInt("ID");
                boolean gen = rs.getBoolean("Gender");
                float Salary = rs.getFloat("Salary");
                int Dep = rs.getInt("DID");
                String deName = rs.getString("DName");
                //System.out.println(Dep);
                //System.out.println(Name);
                Record r = new Record(ID, FName, SName, Dep, Phone, Salary, gen,deName);
                r.setPreferredSize(new Dimension(830, 50));
                innerPanel.add(r);
                JPanel subPanel = new JPanel();
                subPanel.setPreferredSize(new Dimension(750, 5));
                subPanel.setMaximumSize(new Dimension(750, 5));
                subPanel.setMinimumSize(new Dimension(750, 5));
                subPanel.setBackground(new Color(135,135,135));
                innerPanel.add(subPanel);
            }
        } catch (SQLException ex) {
            Logger.getLogger(E_Scroll.class.getName()).log(Level.SEVERE, null, ex);
        }
        innerPanel.setBackground(new Color(255,255,255));
        jScrollPane1.setViewportView(innerPanel);
        add(jScrollPane1, BorderLayout.CENTER);
        System.out.println(cnt);

    }
    
    public E_Scroll() throws SQLException {
        initComponents();
        change(0);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(850, 600));
        setMinimumSize(new java.awt.Dimension(850, 600));
        setPreferredSize(new java.awt.Dimension(850, 600));
        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
