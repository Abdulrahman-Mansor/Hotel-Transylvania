
package LogIn;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JTextField;

public class LoginTextField extends JTextField {
    private int arcSize = 20;
    
    public LoginTextField(){
//        this.setOpaque(false);
        this.setBorder(null);
       
    }
    
    public int getArcSize(){
        return this.arcSize;
    }
    public void setArcSize(int arcSize){
        this.arcSize = arcSize;
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.drawRoundRect(0, 0, getWidth() - 2, getHeight() - 2, arcSize, arcSize);
    }
   
    
}
