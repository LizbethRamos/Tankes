package tankes;
import javax.swing.*;
import java.awt.*;

public class Tankes extends JFrame{

    private DibujaTanke panelNormal, panelMutex, panelSemaforo;
    private Y rcNormal, rcMutex, rcSemaforo;
    private Productor p;
    private Consumidor c;
    private ProductorM pM;
    private ConsumidorM cM;
    private ProductorS pS;
    private ConsumidorS cS;
    private Agua aNormal, aMutex, aSemaforo;
    protected static final SemaforoGen m=new SemaforoGen(2);
    protected static final SemaforoBin s=new SemaforoBin(0);    

    public Tankes(){
        setSize(600,400);
        //de Algoritmo normal
        rcNormal = new Y();
        rcNormal.setY(245);
        aNormal = new Agua();
        panelNormal = new DibujaTanke(aNormal);
        p = new Productor(panelNormal,rcNormal);
        c = new Consumidor(panelNormal, rcNormal);
        //Utilizando Mutex
        rcMutex = new Y();
        rcMutex.setY(245);
        aMutex = new Agua();
        panelMutex = new DibujaTanke(aMutex);
        pM = new ProductorM(panelMutex,rcMutex );
        cM = new ConsumidorM(panelMutex, rcMutex);        
        //Utilizando Semaforos
        rcSemaforo = new Y();
        rcSemaforo.setY(245);
        aSemaforo = new Agua();
        panelSemaforo = new DibujaTanke(aSemaforo);
        pS = new ProductorS(panelSemaforo,rcSemaforo,m,s);
        cS = new ConsumidorS(panelSemaforo, rcSemaforo,m,s);
        getContentPane().setLayout(new GridLayout());
        getContentPane().add(panelNormal);
        getContentPane().add(panelMutex);
        getContentPane().add(panelSemaforo);
        p.start();
        c.start();
        pM.start();
        cM.start();
        pS.start();
        cS.start();
    }

    public static void main(String[] args) {
        Tankes fr = new Tankes();
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }    
}
