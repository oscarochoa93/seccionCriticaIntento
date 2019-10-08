/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorconsumidor;

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
    Interfaz ventana;


    /**
     * Constructor de la clase
     * @param contenedor Contenedor común a los consumidores y el productor
     * @param idconsumidor Identificador del consumidor
     * @param totalConsumidores
     */
    public Consumidor(Contenedor contenedor, int idconsumidor, int totalConsumidores, Interfaz ven) 
    {
        super(idconsumidor+"");
        this.contenedor = contenedor;
        this.idconsumidor = idconsumidor;
        this.totalConsumidores = totalConsumidores;
        this.ventana=ven;
        
    }

    @Override
    /**
     * Implementación de la hebra
     */
    public void run() 
    {
        
        ventana.esperar[idconsumidor]="1";
        ventana.zona[idconsumidor]="0";
        ventana.muerto[idconsumidor]="0";
        System.out.println("hilo no."+idconsumidor);
        System.out.println("esp "+ventana.esperar[idconsumidor]);
        System.out.println("sc "+ventana.zona[idconsumidor]);
        System.out.println("dead "+ventana.muerto[idconsumidor]);
        System.out.println("------------------------------");
        
        while(Boolean.TRUE)
        {         
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            contenedor.get();
            ventana.repintar();

        }
        
        ventana.esperar[idconsumidor]="0";
        ventana.zona[idconsumidor]="0";
        ventana.muerto[idconsumidor]="1";
      
    }
}

//    public void escribirProduciendo() {
//        label.setText("Productor: Produciendo!!");
//    }