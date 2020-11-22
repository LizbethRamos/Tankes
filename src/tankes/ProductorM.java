package tankes;

import java.awt.geom.Rectangle2D;
import static java.lang.Thread.sleep;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProductorM extends Thread{
    
    private Y rc;
    private DibujaTanke panel;
    private Lock mutex;
    
    public ProductorM(DibujaTanke panel, Y rc){
        this.panel = panel;
        this.rc = rc;
        this.mutex = new ReentrantLock();
    }

    public void run(){
        while(true){
            if(panel.getAgua().size() < 40){
                if(mutex.tryLock()){
                    mutex.lock();
                    panel.getAgua().add(new Rectangle2D.Double(50,rc.getY(), 100, 5));
                    rc.setY(rc.getY()-5);
                    //System.out.println("produce" );
                    mutex.unlock();
                }
            panel.repaint();
            }
            try{
                sleep(1000);
            }catch(Exception e){}
        }
    }
}
