package tankes;

public class SemaforoGen extends SemaforoBin{
    
    public SemaforoGen(int valorinicial){
        super(valorinicial);}
        synchronized public void SIGNAL(){
        contador++;
        notify();
    }
}
