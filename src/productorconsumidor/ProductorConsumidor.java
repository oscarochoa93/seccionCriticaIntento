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
    private static Consumidor [] consumidores;
    private static final int CANTIDADCONSUMIDORES = 10;
    private static Interfaz win;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        win = new Interfaz();
        contenedor = new Contenedor(win);
        productor = new Thread(new Productor(contenedor, 1));
        consumidores = new Consumidor[CANTIDADCONSUMIDORES];
      
        

        for(int i = 0; i < CANTIDADCONSUMIDORES; i++)
        {
            
            consumidores[i] = new Consumidor(contenedor, i, CANTIDADCONSUMIDORES,win);
            consumidores[i].start();
            win.setFriend(consumidores);
            win.recibe(i);
            
            //System.out.println("hilo "+i+" en espera");
        }
        
        productor.start();
    }
    
}
