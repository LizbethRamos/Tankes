package tankes;
import java.awt.geom.*;

public class Productor extends Thread{

    private Y rc;
    private DibujaTanke panel;

    public Productor(DibujaTanke panel, Y rc){
        this.panel=panel;
        this.rc=rc;
    }

    public void run(){
        while(true){
            if(panel.getAgua().size() < 40){
                panel.getAgua().add(new Rectangle2D.Double(50,rc.getY(), 100, 5));
                panel.repaint();
                rc.setY(rc.getY()-5);
                //System.out.println("produce" );
            }
            try{
                sleep(1000);
            }catch(Exception e){}
        }
    }
}
