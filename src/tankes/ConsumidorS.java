package tankes;

public class ConsumidorS extends Thread{
    private Y rc;
    private DibujaTanke panel;
    SemaforoGen sg;
    SemaforoBin sb;

    public ConsumidorS(DibujaTanke panel, Y rc, SemaforoGen s, SemaforoBin b){
        this.panel=panel;
        this.rc=rc;
        this.sg=s;
        this.sb=b;
    }

    @Override
    public void run(){
        while(true){
            if(!panel.getAgua().isEmpty()){
                sg.WAIT();
                panel.getAgua().remove(panel.getAgua().size()-1);
                rc.setY(rc.getY()+5);
                if(sg.contador == 0)
                    sg.SIGNAL();
                panel.repaint();
            }else
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){}
        }
    }
}
