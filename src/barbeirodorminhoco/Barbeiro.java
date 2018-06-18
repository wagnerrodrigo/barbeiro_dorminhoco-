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
public class Barbeiro extends Thread {
    private int id;
    
    public Barbeiro(int id){
    this.id = id;
    }
    
    private void cortCabelo()
    {
        System.out.println("###### Barbeiro cortando o cabelo #######");
        try {
            sleep((int) (Math.random() * 10));
        } catch (Exception e) {
            System.out.println("errro barbeiro");
        }
        System.out.println("\n Barbeiro terminado $$$$$$$ ");
    }
    
    public void run()
    {
        System.out.println("BARBEIRO CHEGOU A BARBEARIA !!!");
        while(true)
        {
            Principal.clientes.P();
            Principal.mutex.P();
            Principal.waiting = Principal.waiting +1;
            Principal.barbeiros.V();
            Principal.mutex.V();
            cortCabelo();
                 
        }
    }
    
    
}
