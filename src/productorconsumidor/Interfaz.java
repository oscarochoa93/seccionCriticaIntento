/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorconsumidor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author oscar
 */
public class Interfaz extends JFrame implements ActionListener{
    
//    JLabel[] fuera;
//    hilo consumidores
    JLabel lHilo,lEsp,lEjc,lDead,lBtn;
    
    JLabel jlabel1,jesp1,jejc1,jdead1;
    JButton btnkill1;
    String nombreHilo,esperando,ejecucion,murio,boton;
    
    
    int f=10;
    
    public int[] nomHilo=new int[f];
    public String[] esperar=new String[f];
    public String[] zona= new String[f];
    public String[] muerto= new String[f];
    Consumidor[] hilos;
    //----------------------------
    
    JLabel[] jlabel,jesp,jejc,jdead;
    JButton[] btnkill;
  
    public Interfaz(){
        this.setBounds(300, 300, 600, 600);
        
        //BorderLayout border = new BorderLayout();
        GridLayout grid=new GridLayout(f+1,5);
        JPanel panel = new JPanel();
        
        setLayout(grid);
        
        //panel.setLayout(grid);
        
        //add(panel, BorderLayout.NORTH);
        
        JLabel text1 = new JLabel("hola");
        panel.add(text1);
        
        // row 1
        lHilo = new JLabel("HILO");
        lEsp = new JLabel("ESPERA");
        lEjc = new JLabel("EJECUTANDO");
        lDead = new JLabel("DEAD");
        lBtn = new JLabel("Kill");
        
        add(lHilo);
        add(lEsp);
        add(lEjc);
        add(lDead);
        add(lBtn);
        


        jlabel = new JLabel[f];
        jesp= new JLabel[f];
        jejc= new JLabel[f];
        jdead= new JLabel[f];
        btnkill=new JButton[f];
        
       
        // row 2
        for(int b=0; b<f; b++){
            System.out.println("--en la primera vez");
            System.out.println("--nombre hilo--"+nomHilo[b]+" "+esperar[b]+" "+zona[b]+" "+muerto[b]);
            jlabel[b] = new JLabel(Integer.toString(nomHilo[b]));
            jesp[b] = new JLabel(esperar[b]);
            jejc[b] = new JLabel(zona[b]);
            jdead[b] = new JLabel(muerto[b]);
            btnkill[b] = new JButton(boton);
            
            btnkill[b].addActionListener(this);

            add(jlabel[b]);
            add(jesp[b]);
            add(jejc[b]);
            add(jdead[b]);
            add(btnkill[b]);
        }
        
        
        
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        
    }
    
    public void repintar(){
        repaint();
    }
    
    void recibe(int hilo){
        System.out.println("");
        System.out.println("Llega");
        System.out.println("esta llegando--"+hilo);
        nomHilo[hilo]=hilo;
        
        System.out.println("Dentro");
        for(int i =0; i<nomHilo.length;i++){
            System.out.println("todo lo que hay dentro- "+nomHilo[i]);
        }
        
        System.out.println("-----------");
    }
    
    public void actionPerformed(ActionEvent e){
        
        for(int d=0;d<f;d++){
            
            if(e.getSource()==btnkill[d]){
                 hilos[d].matar();
                 System.out.println("action");
            }
        }
        
      
    }

    void setFriend(Consumidor[] consumidores) {
        hilos=consumidores;
    }
    
}
