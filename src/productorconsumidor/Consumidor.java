/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorconsumidor;

import static java.lang.Boolean.TRUE;
import static java.lang.Thread.sleep;

/**
 *
 * @author oscar
 */
public class Consumidor extends Thread
{
    private final Contenedor contenedor;
    private final int idconsumidor;
    private final int totalConsumidores;
    Boolean go = TRUE;
    Interfaz ventana;
    boolean a=true;
    //Boolean miBooleano = new Boolean(go);
    //boolean go = true;
    int o;


    /**
     * Constructor de la clase
     * @param contenedor Contenedor común a los consumidores y el productor
     * @param idconsumidor Identificador del consumidor
     * @param totalConsumidores noumero total de hilos
     */
    public Consumidor(Contenedor contenedor, int idconsumidor, int totalConsumidores, Interfaz ven) 
    {
        super(idconsumidor+"");
        this.contenedor = contenedor;
        this.idconsumidor = idconsumidor;
        this.totalConsumidores = totalConsumidores;
        this.ventana=ven;
        ventana.jlabel[idconsumidor].setText("hilo: "+idconsumidor );
        ventana.jesp[idconsumidor].setText("1");
        ventana.jejc[idconsumidor].setText("0");
        ventana.jdead[idconsumidor].setText("0");
        
        
    }

    @Override
    /**
     * Implementación de la hebra
     */
    public void run() 
    {
        
        ventana.jesp[idconsumidor].setText("1");
        ventana.jejc[idconsumidor].setText("0");
        ventana.jdead[idconsumidor].setText("0");
                
                
        System.out.println("hilo no."+idconsumidor);
        System.out.println("esp "+ventana.esperar[idconsumidor]);
        System.out.println("sc "+ventana.zona[idconsumidor]);
        System.out.println("dead "+ventana.muerto[idconsumidor]);
        System.out.println("------------------------------");
        
        
        /*Boolean.TRUE*/
        
        //for(o=0;o<9999;o++)
        while(this.a)
        {         
            try {
                sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            contenedor.get();
            try {
                sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            
            ventana.jesp[idconsumidor].setText("1");
            ventana.jejc[idconsumidor].setText("0");
            ventana.jdead[idconsumidor].setText("0");
            
        }
        
        System.out.println("sdfghj");
        ventana.esperar[idconsumidor]="0";
        ventana.zona[idconsumidor]="0";
        ventana.muerto[idconsumidor]="1";
            try {
                sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        
      
    }
    
    void matar(){
        a=false;
        System.out.println(a);
        
        //go=false;
    }
}

//    public void escribirProduciendo() {
//        label.setText("Productor: Produciendo!!");
//    }