package tankes;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;

public class DibujaTanke extends JPanel{
    private Agua agua;
    
    public ArrayList<Rectangle2D> getAgua() {
        return agua.getAgua();
    }

    public void setAgua(ArrayList<Rectangle2D> agua) {
        this.agua.setAgua(agua);
    }
   
    public DibujaTanke(Agua a){
        this.agua = a;        
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.BLACK);
        g2.draw(new Rectangle2D.Double(50,50,100,200));     
        g2.setColor(Color.BLUE);
        for(int i=0;i<this.agua.getAgua().size();i++){
            g2.fill((Rectangle2D)getAgua().get(i));
        }
    }
}
