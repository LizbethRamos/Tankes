package tankes;

public class Consumidor extends Thread{

    private Y rc;
    private DibujaTanke panel;
    
    public Consumidor(DibujaTanke panel, Y rc){
        this.panel=panel;
        this.rc=rc;
    }

    @Override
    public void run(){
        while(true){
            if(!panel.getAgua().isEmpty()){
                    panel.getAgua().remove(panel.getAgua().size()-1);
                    panel.repaint();
                    rc.setY(rc.getY()+5);
                    //System.out.println("consume");
            }else
                //System.out.println("Tanque vacío");
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){}
        }
    }
}
