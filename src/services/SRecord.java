
package services;

/**
 *
 * @author Mansour
 */
public class SRecord extends javax.swing.JPanel {

 
    public SRecord(String serviceId, String clientId, String serviceName, String serviceDate, String serviceTime) {
        initComponents();
        serviceIdLabel.setText(serviceId);
        clientIdLabel.setText(clientId);
        serviceNameLabel.setText(serviceName);
        serviceDateLabel.setText(serviceDate);
        serviceTimeLabel.setText(serviceTime);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        serviceIdLabel = new javax.swing.JLabel();
        clientIdLabel = new javax.swing.JLabel();
        serviceNameLabel = new javax.swing.JLabel();
        serviceDateLabel = new javax.swing.JLabel();
        serviceTimeLabel = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(449, 36));
        setMinimumSize(new java.awt.Dimension(449, 36));

        serviceIdLabel.setText("jLabel1");

        clientIdLabel.setText("jLabel2");

        serviceNameLabel.setText("jLabel3");

        serviceDateLabel.setText("jLabel4");

        serviceTimeLabel.setText("jLabel5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(serviceIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(clientIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(serviceNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(serviceDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(serviceTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(serviceTimeLabel)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(serviceIdLabel)
                        .addComponent(clientIdLabel)
                        .addComponent(serviceNameLabel)
                        .addComponent(serviceDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel clientIdLabel;
    private javax.swing.JLabel serviceDateLabel;
    private javax.swing.JLabel serviceIdLabel;
    private javax.swing.JLabel serviceNameLabel;
    private javax.swing.JLabel serviceTimeLabel;
    // End of variables declaration//GEN-END:variables
}
