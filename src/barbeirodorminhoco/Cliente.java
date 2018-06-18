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
public class Cliente extends Thread {
    public int id;
    
    public Cliente(int id){
        this.id = id;
    }
    
    private void cortCabelo()
    {
        System.out.println("Cliente >-- "+ this.id +" --< cortando o cabelo");
    }
    
    public void run()
    {
        System.out.println("Cliente >--("+ this.id + ")--< Chegou na barbearia \n");
        Principal.mutex.P();
        if(Principal.waiting < Principal.MaxClientes)
        {
            Principal.waiting++;
            Principal.clientes.V();
            Principal.mutex.V();
            Principal.barbeiros.P();
            cortCabelo();
                    
        }else{
            System.out.println("Barbearia Cheia!!! Cliente de numero >--" + this.id + "--< indo embora \n");
            Principal.mutex.V();
        }
    }
    
    
    
    
}
