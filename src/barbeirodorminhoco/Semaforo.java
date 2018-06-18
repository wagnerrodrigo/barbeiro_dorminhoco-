/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbeirodorminhoco;

/**
 *
 * @author alunoces
 */
public class Semaforo {
    private int valor = 0;
    
    public Semaforo(int v)
    {
        valor = v;
    }
    
    public synchronized void P()
    {
        while (valor <= 0)
        {
            try {
                wait();
            } catch (Exception e) {
                System.out.println("erro no semaforo!!");
            }
        }
        valor--;
    }
    
    public synchronized void V()
    {
        valor++;
        notify();
    }
    
    
}
