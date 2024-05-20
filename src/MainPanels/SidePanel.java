
package MainPanels;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import main.Main;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.Interpolator;

public class SidePanel extends javax.swing.JPanel {
    public TimingTarget logoTarget,selectorTarget;
    Animator selAnimator;
    int startSel, endSel, locSel;
    public int fWidth;
    public boolean b = false;
    public boolean[] selectedItem;
    int[] destY;
    private CardLayout card;
    private CenterPanel centerPanel;
    private Main main;
    public SidePanel() {
        initComponents();
        fWidth = this.getWidth();
        this.setOpaque(false);
        int logoX = logo_label.getLocation().x + 5;
        selectorTarget = new TimingTargetAdapter(){
            @Override
            public void timingEvent(float f) {
                locSel =(int) ((1 - f) *startSel + f * endSel);
                repaint();
            }

            @Override
            public void end() {
                startSel = locSel = endSel;
            }
        };
        logoTarget = new TimingTargetAdapter(){
            @Override
            public void timingEvent(float f) {
                if(!b)
                    f = 1 - f;
                int x = (int)(logoX + f * 60);
                logo_label.setLocation(x, logo_label.getLocation().y);
                repaint();
            }
            
        };
       selectedItem = new boolean[6];
       selectedItem[0] = true;
       for(boolean i : selectedItem){
           i = false;
       }
       selAnimator = new Animator(200, selectorTarget);
       selAnimator.setResolution(0);
       selAnimator.setInterpolator(new Interpolator(){
            @Override
            public float interpolate(float f) {
                return (float)( f );
            }
       });
    }
    
    public void setCardAndCenterPanel(CardLayout card , CenterPanel centerPanel, Main main) {
        this.card = card;
        this.centerPanel = centerPanel;
        this.main = main;
    }
    public int[] getDestY() {
        destY = new int[6];
        destY[0] = homeItemPanel.getLocation().y;
        destY[1] = lessonsItemPanel.getLocation().y;
        destY[2] = statisticsItemPanel.getLocation().y;
        destY[3] = profileItemPanel.getLocation().y;
        destY[4] = suppliesItemPanel.getLocation().y;
        destY[5] = logoutItemPanel.getLocation().y;
        startSel = destY[0];
        locSel = startSel;
        return destY;
    }
    void setSelectedItem(int idx){
        int ii = 0;
        for(boolean i : selectedItem){
            if(i == true){
                selectedItem[ii] = false;
                break;
            }
            ii++;      
        }
        card.show(centerPanel, Integer.toString(idx));
        endSel = destY[idx];
        if(!selAnimator.isRunning())
            selAnimator.start();
        selectedItem[idx] = true;
        switch(ii){
            case 0:
                homeLabel.setIcon(new ImageIcon(getClass().getResource("/icons/check-in (1).png")));
                homeLabel.setForeground(Color.decode("#636363"));
                break;
            case 1:
                lessonsLabel.setIcon(new ImageIcon(getClass().getResource("/icons/editing (1).png")));
                lessonsLabel.setForeground(Color.decode("#636363"));
                break;
            case 2:
                statisticsLabel.setIcon(new ImageIcon(getClass().getResource("/icons/room-service (1).png")));
                statisticsLabel.setForeground(Color.decode("#636363"));
                break;
            case 3:
                profileLabel.setIcon(new ImageIcon(getClass().getResource("/icons/bill (1).png")));
                profileLabel.setForeground(Color.decode("#636363"));
                break;
            case 4:
                suppliesLabel.setIcon(new ImageIcon(getClass().getResource("/icons/supplies (1).png")));
                suppliesLabel.setForeground(Color.decode("#636363"));
                break;
            case 5:
                logoutLabel.setIcon(new ImageIcon(getClass().getResource("/icons/logout (2).png")));
                logoutLabel.setForeground(Color.decode("#636363"));
                break;
        }
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logo_label = new javax.swing.JLabel();
        homeItemPanel = new javax.swing.JPanel();
        homeLabel = new javax.swing.JLabel();
        homeLabel1 = new javax.swing.JLabel();
        lessonsItemPanel = new javax.swing.JPanel();
        lessonsLabel = new javax.swing.JLabel();
        statisticsItemPanel = new javax.swing.JPanel();
        statisticsLabel = new javax.swing.JLabel();
        profileItemPanel = new javax.swing.JPanel();
        profileLabel = new javax.swing.JLabel();
        logoutItemPanel = new javax.swing.JPanel();
        logoutLabel = new javax.swing.JLabel();
        Selector = new javax.swing.JPanel();
        suppliesItemPanel = new javax.swing.JPanel();
        suppliesLabel = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setPreferredSize(new java.awt.Dimension(120, 856));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });

        logo_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/_ff29b138-3f99-4b8d-877d-82403159f1a8-removebg-preview.png"))); // NOI18N

        homeItemPanel.setOpaque(false);
        homeItemPanel.setPreferredSize(new java.awt.Dimension(120, 36));
        homeItemPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homeItemPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homeItemPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                homeItemPanelMousePressed(evt);
            }
        });

        homeLabel.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 24)); // NOI18N
        homeLabel.setForeground(new java.awt.Color(255, 255, 255));
        homeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/check-in.png"))); // NOI18N
        homeLabel.setFocusable(false);
        homeLabel.setIconTextGap(25);

        homeLabel1.setForeground(new java.awt.Color(255, 255, 255));
        homeLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/keyboard (1).png"))); // NOI18N
        homeLabel1.setText("Type");
        homeLabel1.setFocusable(false);
        homeLabel1.setIconTextGap(25);

        javax.swing.GroupLayout homeItemPanelLayout = new javax.swing.GroupLayout(homeItemPanel);
        homeItemPanel.setLayout(homeItemPanelLayout);
        homeItemPanelLayout.setHorizontalGroup(
            homeItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeItemPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(homeItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homeLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(homeLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        homeItemPanelLayout.setVerticalGroup(
            homeItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeItemPanelLayout.createSequentialGroup()
                .addComponent(homeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(homeLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lessonsItemPanel.setOpaque(false);
        lessonsItemPanel.setPreferredSize(new java.awt.Dimension(120, 36));
        lessonsItemPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lessonsItemPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lessonsItemPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lessonsItemPanelMousePressed(evt);
            }
        });

        lessonsLabel.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 24)); // NOI18N
        lessonsLabel.setForeground(new java.awt.Color(99, 99, 99));
        lessonsLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/editing (1).png"))); // NOI18N
        lessonsLabel.setIconTextGap(25);

        javax.swing.GroupLayout lessonsItemPanelLayout = new javax.swing.GroupLayout(lessonsItemPanel);
        lessonsItemPanel.setLayout(lessonsItemPanelLayout);
        lessonsItemPanelLayout.setHorizontalGroup(
            lessonsItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lessonsItemPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lessonsLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        lessonsItemPanelLayout.setVerticalGroup(
            lessonsItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lessonsLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        statisticsItemPanel.setOpaque(false);
        statisticsItemPanel.setPreferredSize(new java.awt.Dimension(120, 36));
        statisticsItemPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                statisticsItemPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                statisticsItemPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                statisticsItemPanelMousePressed(evt);
            }
        });

        statisticsLabel.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 24)); // NOI18N
        statisticsLabel.setForeground(new java.awt.Color(99, 99, 99));
        statisticsLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/room-service (1).png"))); // NOI18N
        statisticsLabel.setIconTextGap(25);

        javax.swing.GroupLayout statisticsItemPanelLayout = new javax.swing.GroupLayout(statisticsItemPanel);
        statisticsItemPanel.setLayout(statisticsItemPanelLayout);
        statisticsItemPanelLayout.setHorizontalGroup(
            statisticsItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statisticsItemPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statisticsLabel)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        statisticsItemPanelLayout.setVerticalGroup(
            statisticsItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, statisticsItemPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(statisticsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        profileItemPanel.setOpaque(false);
        profileItemPanel.setPreferredSize(new java.awt.Dimension(120, 36));
        profileItemPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profileItemPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profileItemPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                profileItemPanelMousePressed(evt);
            }
        });

        profileLabel.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 24)); // NOI18N
        profileLabel.setForeground(new java.awt.Color(99, 99, 99));
        profileLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bill (1).png"))); // NOI18N
        profileLabel.setIconTextGap(25);
        profileLabel.setInheritsPopupMenu(false);

        javax.swing.GroupLayout profileItemPanelLayout = new javax.swing.GroupLayout(profileItemPanel);
        profileItemPanel.setLayout(profileItemPanelLayout);
        profileItemPanelLayout.setHorizontalGroup(
            profileItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileItemPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(profileLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        profileItemPanelLayout.setVerticalGroup(
            profileItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profileItemPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(profileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        logoutItemPanel.setOpaque(false);
        logoutItemPanel.setPreferredSize(new java.awt.Dimension(120, 36));
        logoutItemPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutItemPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutItemPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logoutItemPanelMousePressed(evt);
            }
        });

        logoutLabel.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 24)); // NOI18N
        logoutLabel.setForeground(new java.awt.Color(99, 99, 99));
        logoutLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout (2).png"))); // NOI18N
        logoutLabel.setIconTextGap(25);

        javax.swing.GroupLayout logoutItemPanelLayout = new javax.swing.GroupLayout(logoutItemPanel);
        logoutItemPanel.setLayout(logoutItemPanelLayout);
        logoutItemPanelLayout.setHorizontalGroup(
            logoutItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoutItemPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoutLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        logoutItemPanelLayout.setVerticalGroup(
            logoutItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoutItemPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(logoutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Selector.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout SelectorLayout = new javax.swing.GroupLayout(Selector);
        Selector.setLayout(SelectorLayout);
        SelectorLayout.setHorizontalGroup(
            SelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );
        SelectorLayout.setVerticalGroup(
            SelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        suppliesItemPanel.setOpaque(false);
        suppliesItemPanel.setPreferredSize(new java.awt.Dimension(120, 36));
        suppliesItemPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                suppliesItemPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                suppliesItemPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                suppliesItemPanelMousePressed(evt);
            }
        });

        suppliesLabel.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 24)); // NOI18N
        suppliesLabel.setForeground(new java.awt.Color(99, 99, 99));
        suppliesLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/supplies (1).png"))); // NOI18N
        suppliesLabel.setIconTextGap(25);
        suppliesLabel.setInheritsPopupMenu(false);

        javax.swing.GroupLayout suppliesItemPanelLayout = new javax.swing.GroupLayout(suppliesItemPanel);
        suppliesItemPanel.setLayout(suppliesItemPanelLayout);
        suppliesItemPanelLayout.setHorizontalGroup(
            suppliesItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(suppliesItemPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(suppliesLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        suppliesItemPanelLayout.setVerticalGroup(
            suppliesItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, suppliesItemPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(suppliesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(homeItemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Selector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(statisticsItemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logo_label)
                    .addComponent(logoutItemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profileItemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lessonsItemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suppliesItemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(logo_label, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(homeItemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Selector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(lessonsItemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statisticsItemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(profileItemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(suppliesItemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 407, Short.MAX_VALUE)
                .addComponent(logoutItemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        System.out.println("Mouse Enterd The side panel");
    }//GEN-LAST:event_formMouseEntered

    private void profileItemPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileItemPanelMouseEntered
        if (!selectedItem[3]) {
            profileLabel.setIcon(new ImageIcon(getClass().getResource("/icons/bill.png")));
            profileLabel.setForeground(Color.white);
        }

    }//GEN-LAST:event_profileItemPanelMouseEntered

    private void statisticsItemPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_statisticsItemPanelMouseEntered
        if (!selectedItem[2]) {
            statisticsLabel.setIcon(new ImageIcon(getClass().getResource("/icons/room-service.png")));
            statisticsLabel.setForeground(Color.white);
        }
    }//GEN-LAST:event_statisticsItemPanelMouseEntered

    private void homeItemPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeItemPanelMouseEntered
        if (!selectedItem[0]) {
            homeLabel.setIcon(new ImageIcon(getClass().getResource("/icons/check-in.png")));
            homeLabel.setForeground(Color.white);
        }
    }//GEN-LAST:event_homeItemPanelMouseEntered

    private void lessonsItemPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lessonsItemPanelMouseEntered
        if (!selectedItem[1]) {
            lessonsLabel.setIcon(new ImageIcon(getClass().getResource("/icons/editing.png")));
            lessonsLabel.setForeground(Color.white);
        }
    }//GEN-LAST:event_lessonsItemPanelMouseEntered

    private void logoutItemPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutItemPanelMouseEntered
        if (!selectedItem[5]) {
            logoutLabel.setIcon(new ImageIcon(getClass().getResource("/icons/logout (1).png")));
            logoutLabel.setForeground(Color.white);
        }
    }//GEN-LAST:event_logoutItemPanelMouseEntered

    private void homeItemPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeItemPanelMouseExited
        if (!selectedItem[0]) {
            homeLabel.setIcon(new ImageIcon(getClass().getResource("/icons/check-in (1).png")));
            homeLabel.setForeground(Color.decode("#636363"));
        }
    }//GEN-LAST:event_homeItemPanelMouseExited

    private void lessonsItemPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lessonsItemPanelMouseExited
        if (!selectedItem[1]) {
            lessonsLabel.setIcon(new ImageIcon(getClass().getResource("/icons/editing (1).png")));
            lessonsLabel.setForeground(Color.decode("#636363"));
        }
    }//GEN-LAST:event_lessonsItemPanelMouseExited

    private void statisticsItemPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_statisticsItemPanelMouseExited
        if (!selectedItem[2]) {
            statisticsLabel.setIcon(new ImageIcon(getClass().getResource("/icons/room-service (1).png")));
            statisticsLabel.setForeground(Color.decode("#636363"));
        }
    }//GEN-LAST:event_statisticsItemPanelMouseExited

    private void profileItemPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileItemPanelMouseExited
        if (!selectedItem[3]) {
            profileLabel.setIcon(new ImageIcon(getClass().getResource("/icons/bill (1).png")));
            profileLabel.setForeground(Color.decode("#636363"));
        }
    }//GEN-LAST:event_profileItemPanelMouseExited

    private void logoutItemPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutItemPanelMouseExited
        if (!selectedItem[5]) {
            logoutLabel.setIcon(new ImageIcon(getClass().getResource("/icons/logout (2).png")));
            logoutLabel.setForeground(Color.decode("#636363"));
        }
    }//GEN-LAST:event_logoutItemPanelMouseExited

    private void homeItemPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeItemPanelMousePressed
        if(!selectedItem[0]){
            setSelectedItem(0);
            homeLabel.setIcon(new ImageIcon(getClass().getResource("/icons/check-in.png")));
        }
    }//GEN-LAST:event_homeItemPanelMousePressed

    private void lessonsItemPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lessonsItemPanelMousePressed
        if (!selectedItem[1]) {
            setSelectedItem(1);
            lessonsLabel.setIcon(new ImageIcon(getClass().getResource("/icons/editing.png")));
//            centerPanel.lessonsForm.lossFocus();
        }
    }//GEN-LAST:event_lessonsItemPanelMousePressed

    private void statisticsItemPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_statisticsItemPanelMousePressed
        if (!selectedItem[2]) {
            setSelectedItem(2);
            statisticsLabel.setIcon(new ImageIcon(getClass().getResource("/icons/room-service.png")));
        }
    }//GEN-LAST:event_statisticsItemPanelMousePressed

    private void profileItemPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileItemPanelMousePressed
        if (!selectedItem[3]) {
            setSelectedItem(3);
            profileLabel.setIcon(new ImageIcon(getClass().getResource("/icons/bill.png")));
        }
    }//GEN-LAST:event_profileItemPanelMousePressed

    private void logoutItemPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutItemPanelMousePressed
        if (!selectedItem[5]) {
            setSelectedItem(5);
            logoutLabel.setIcon(new ImageIcon(getClass().getResource("/icons/logout (1).png")));
            main.setVisible(false);
            new LogIn.LogInFrame().setVisible(true);
        }
   
    }//GEN-LAST:event_logoutItemPanelMousePressed

    private void suppliesItemPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suppliesItemPanelMouseEntered
        if (!selectedItem[4]) {
            suppliesLabel.setIcon(new ImageIcon(getClass().getResource("/icons/supplies.png")));
            suppliesLabel.setForeground(Color.white);
        }
    }//GEN-LAST:event_suppliesItemPanelMouseEntered

    private void suppliesItemPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suppliesItemPanelMouseExited
        if (!selectedItem[4]) {
            suppliesLabel.setIcon(new ImageIcon(getClass().getResource("/icons/supplies (1).png")));
            suppliesLabel.setForeground(Color.decode("#636363"));
        }
    }//GEN-LAST:event_suppliesItemPanelMouseExited

    private void suppliesItemPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suppliesItemPanelMousePressed
        if (!selectedItem[4]) {
            setSelectedItem(4);
            suppliesLabel.setIcon(new ImageIcon(getClass().getResource("/icons/supplies.png")));
        }
    }//GEN-LAST:event_suppliesItemPanelMousePressed

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        GradientPaint gd = new GradientPaint(0,0, Color.red, getWidth(),getHeight(), Color.blue);
        g2.setColor(Color.decode("#1B1B1B"));
//        g2.setPaint(gd);
        g2.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), fWidth - 20, fWidth - 20);
        Selector.setLocation(Selector.getLocation().x, locSel);
        super.paint(g);

    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Selector;
    public javax.swing.JPanel homeItemPanel;
    private javax.swing.JLabel homeLabel;
    private javax.swing.JLabel homeLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel lessonsItemPanel;
    private javax.swing.JLabel lessonsLabel;
    private javax.swing.JLabel logo_label;
    private javax.swing.JPanel logoutItemPanel;
    private javax.swing.JLabel logoutLabel;
    private javax.swing.JPanel profileItemPanel;
    private javax.swing.JPanel profileItemPanel1;
    private javax.swing.JPanel profileItemPanel2;
    private javax.swing.JLabel profileLabel;
    private javax.swing.JLabel profileLabel1;
    private javax.swing.JLabel profileLabel2;
    private javax.swing.JPanel statisticsItemPanel;
    private javax.swing.JLabel statisticsLabel;
    private javax.swing.JPanel suppliesItemPanel;
    private javax.swing.JLabel suppliesLabel;
    // End of variables declaration//GEN-END:variables
}
