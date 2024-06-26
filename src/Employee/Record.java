
package Employee;

import MainPanels.CenterPanelChildForm;
import javax.swing.JPanel;

/**
 *
 * @author AhmedMagedMohamedHas
 */
public class Record extends JPanel {

    private int id,Dep;
    private String Fname,Lname,Phonee,Namee;
    private float Salary;
    private boolean gender;
    private String DName;
    private String s[] ={ "Maintance","Hous Keeping","Restaurant","Department 4" };
    public Record(int ID,String Fname,String Lname,int Dep,String Phone,float Salary,boolean gender,String DName) {
        this.id=ID; this.Dep=Dep; this.Phonee=Phone; this.Salary=Salary; this.Fname=Fname; this.Lname=Lname; this.gender=gender;
        this.Namee=Fname+" "+Lname; this.DName=DName;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Name = new javax.swing.JLabel();
        ID = new javax.swing.JLabel();
        Department = new javax.swing.JLabel();
        Phone = new javax.swing.JLabel();
        Gender = new javax.swing.JLabel();
        edit = new javax.swing.JLabel();
        delete = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(780, 63));
        setMinimumSize(new java.awt.Dimension(780, 63));
        setPreferredSize(new java.awt.Dimension(780, 63));

        Name.setText(Namee);

        ID.setText(Integer.toString(id));

        Department.setText(DName);

        Phone.setText(Phonee);

        if(!gender){
            Gender.setText("Male");
        }
        else{Gender.setText("Female");}

        edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Employee/edit1.png"))); // NOI18N
        edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editMouseExited(evt);
            }
        });

        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Employee/delete1.png"))); // NOI18N
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteMouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(Department, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Phone)
                .addGap(58, 58, 58)
                .addComponent(Gender)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(edit)
                .addGap(39, 39, 39)
                .addComponent(delete)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ID)
                        .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Department)
                        .addComponent(Phone)
                        .addComponent(Gender)))
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseEntered
        // TODO add your handling code here:
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Employee/delete2.png"))); // NOI18N
    }//GEN-LAST:event_deleteMouseEntered

    private void deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseExited
        // TODO add your handling code here:
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Employee/delete1.png"))); // NOI18N
    }//GEN-LAST:event_deleteMouseExited

    private void editMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMouseEntered
        // TODO add your handling code here:
        edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Employee/edit2.png"))); // NOI18N
    }//GEN-LAST:event_editMouseEntered

    private void editMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMouseExited
        // TODO add your handling code here:
        edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Employee/edit1.png"))); // NOI18N
    }//GEN-LAST:event_editMouseExited

    private void editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMouseClicked
        // TODO add your handling code here:
        new E_edit(id,Fname,Lname,Salary,Phonee,gender,Dep).setVisible(true);
    }//GEN-LAST:event_editMouseClicked

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        // TODO add your handling code here:
        new Delete_E(id,Namee).setVisible(true);
    }//GEN-LAST:event_deleteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Department;
    private javax.swing.JLabel Gender;
    private javax.swing.JLabel ID;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel Phone;
    private javax.swing.JLabel delete;
    private javax.swing.JLabel edit;
    // End of variables declaration//GEN-END:variables
}
