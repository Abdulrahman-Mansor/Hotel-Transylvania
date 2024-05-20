
package MainPanels;

import Bill.BillPanel;
import Employee.EmployeeRec;
import java.awt.CardLayout;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import services.ServicesPanel;

public class CenterPanel extends javax.swing.JPanel {

    public CenterPanel() {
        initComponents();
        this.setFocusable(true);
        init();
    }

    public CardLayout card;

    private void init() {
        card = new CardLayout();
        this.setLayout(card);
//        this.add(new CenterPanelChildForm(),"1");
        this.add(new Check_IN.CheckIn(), "0");
        try {
            this.add(new EmployeeRec(), "1");
        } catch (SQLException ex) {
            Logger.getLogger(CenterPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.add(new ServicesPanel(), "2");
        this.add(new BillPanel(), "3");
        card.show(this, "0");

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
