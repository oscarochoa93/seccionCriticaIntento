/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorconsumidor;

/**
 *
 * @author oscar
 */
public class ProductorConsumidor 
{
    private static Contenedor contenedor;
    private static Thread productor;
    private static Thread [] consumidores;
    private static final int CANTIDADCONSUMIDORES = 2;
    private static Interfaz win;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        win = new Interfaz();
        contenedor = new Contenedor(win);
        productor = new Thread(new Productor(contenedor, 1));
        consumidores = new Thread[CANTIDADCONSUMIDORES];
      
        

        for(int i = 0; i < CANTIDADCONSUMIDORES; i++)
        {
            
            consumidores[i] = new Consumidor(contenedor, i, CANTIDADCONSUMIDORES,win);
            consumidores[i].start();
            win.recibe(i);
            
            //System.out.println("hilo "+i+" en espera");
        }
        
        productor.start();
    }
    
}
