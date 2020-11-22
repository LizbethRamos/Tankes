package tankes;

import java.awt.geom.Rectangle2D;
import static java.lang.Thread.sleep;

public class ProductorS extends Thread{

    private Y rc;
    private DibujaTanke panel;
    SemaforoGen sg;
    SemaforoBin sb;    

    public ProductorS(DibujaTanke panel, Y rc, SemaforoGen s, SemaforoBin b){
        this.panel=panel;
        this.rc=rc;
        this.sg=s;
        this.sb=b;
    }

    public void run(){
        while(true){
            if(panel.getAgua().size() < 40){
                sg.WAIT();
                panel.getAgua().add(new Rectangle2D.Double(50,rc.getY(), 100, 5));
                rc.setY(rc.getY()-5);
                //System.out.println("produce" );
                if(sg.contador == 0)
                    sg.SIGNAL();
                panel.repaint();
            }
            try{
                sleep(1000);
            }catch(Exception e){}
        }
    }    
}
