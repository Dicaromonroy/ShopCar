/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.view;

import java.io.Console;
import java.util.List;
import java.util.Scanner;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;

import javax.inject.*;
import org.jboss.weld.environment.se.events.ContainerInitialized; 
import shopcar.repository.JpaDAO;



/**
 *
 * @author info1
 */
@ApplicationScoped
public class Principal
{

    @Inject private Scanner s;
    
    @Inject private Veiculo v;
    @Inject private VendeCarro vendeCarro;
    @Inject private VeiculoController veiculoController;
    
    
    @Inject private JpaDAO<Veiculo> dao;
    
    public void executar(@Observes ContainerInitialized init) 
    {
        //salva();
        this.testeEvento();
    }
    
    public boolean salva()
    {
        System.out.println("Nome do funcionario: ");
        f.setNome(s.nextLine());
        System.out.println("----------------------");
        System.out.println("CPF do funcionario: ");
        f.setCpf(s.nextLine());
        System.out.println("----------------------");
        System.out.println("Salvar?(s/n)");
        if(s.nextLine().equalsIgnoreCase("s"))
        {
            try
            {
                 daoF.save(f);
            } 
            catch (Throwable e)
            {
                e.printStackTrace();
                System.out.println("Ocorreu um erro: " + e.getLocalizedMessage() );
            }
        }
        
        return true;
    }
    
    
    public void testeEvento()
    {
        String err;
        System.out.println("Placa do Veiculo: ");
        v.setPlaca(s.nextLine());
        err = this.valida.Validate(v, "placa");
        if(err != null) System.out.println(err);
        System.out.println("Modelo do Veiculo: ");
        v.setModelo(s.nextLine());
        err = this.valida.Validate(v, "modelo");
        if(err != null) System.out.println(err);
        
        System.out.println("Vender?(s/n)");
        if(s.nextLine().equalsIgnoreCase("s"))
        {
            vendeCarro.Vender(v);
            try
            {
                System.out.println(dao.getClasse().toString());
                System.out.println(dao.getEntityManager().getEntityManagerFactory().getPersistenceUnitUtil());
                dao.save(v);
                
            } 
            catch (Exception e)
            {
                e.printStackTrace();
                System.out.println("erro: " + e.getLocalizedMessage());
                System.out.println("erro: " + e.getStackTrace());
            }
        }
     
        
    } 
}
