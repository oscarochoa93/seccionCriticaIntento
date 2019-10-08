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
public class Contenedor 
{
    private int contenido;
    private String texto;
    private boolean contenedorlleno = Boolean.FALSE;
    Interfaz ventana;

    Contenedor(Interfaz win) {
        ventana=win;
    }
    


    /**
     * Obtiene de forma concurrente o síncrona el elemento que hay en el contenedor
     * @return Contenido el contenedor
     */
    public synchronized String get()
    {
        while (!contenedorlleno)
        {
            try 
            {
                wait();
            } 
            catch (InterruptedException e) 
            {
                System.err.println("Contenedor: Error en get -> " + e.getMessage());
            }
        }
        contenedorlleno = Boolean.FALSE;
        notify();
        int x=Integer.parseInt(Thread.currentThread().getName());
        
        ventana.esperar[x]="0";
        ventana.zona[x]="1";
        ventana.muerto[x]="0";
        System.out.println("hilo no."+x);
        System.out.println("esp "+ventana.esperar[x]);
        System.out.println("sc "+ventana.zona[x]);
        System.out.println("dead "+ventana.muerto[x]);
        System.out.println("------------------------------"); 
        texto="1";
        return texto;
        //return contenido;
    }

    /**
     * Introduce de forma concurrente o síncrona un elemento en el contenedor
     * @param value Elemento a introducir en el contenedor
     */
    public synchronized void put(int value) 
    {
        while (contenedorlleno) 
        {
            try 
            {
                wait();
            } 
            catch (InterruptedException e) 
            {
                System.err.println("Contenedor: Error en put -> " + e.getMessage());
            }
        }
        contenido = value;
        contenedorlleno = Boolean.TRUE;
        notify();
    }
    
    
    public void escribirContenedorVacio() {
        //label.setText("El contenedor esta vacio");
        
    }
}