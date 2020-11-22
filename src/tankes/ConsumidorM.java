package tankes;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class ConsumidorM extends Thread{
    private Y rc;
    private DibujaTanke panel;
    private Lock mutex;
    
    public ConsumidorM(DibujaTanke panel, Y rc){
        this.panel=panel;
        this.rc=rc;
        this.mutex = new ReentrantLock();
    }

    @Override
    public void run(){
        while(true){
            if(!panel.getAgua().isEmpty()){
                if(mutex.tryLock()){
                    mutex.lock();
                    panel.getAgua().remove(panel.getAgua().size()-1);
                    rc.setY(rc.getY()+5);
                    //System.out.println("consume");                    
                    mutex.unlock();
                }
                panel.repaint();
            }else
                //System.out.println("Tanque vacío");
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){}
        }
    }
}
