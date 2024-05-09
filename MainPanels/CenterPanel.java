/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package MainPanels;

import java.awt.CardLayout;
import javax.swing.JPanel;

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
        this.add(new CenterPanelChildForm(), "0");
        this.add(new CenterPanelChildForm(), "1");
        this.add(new CenterPanelChildForm(), "2");
        this.add(new CenterPanelChildForm(), "3");
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
