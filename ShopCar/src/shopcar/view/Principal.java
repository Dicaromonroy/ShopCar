/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.view;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import javax.inject.*;
import org.jboss.weld.environment.se.events.ContainerInitialized; 
import shopcar.controller.*;
import shopcar.model.*;
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
    @Inject private Veiculo vi;
    @Inject private List<Veiculo> veiculos;
    @Inject private VendeCarro vendeCarro;
    @Inject private VeiculoController veiculoController;
    
    @Inject private Validator<Veiculo> valida; 
    
    @Inject private JpaDAO<Veiculo> dao;
    
    public int MenuPrincipal()
    {
        System.out.println("*** ShopCar ***");
        System.out.println("-------------------------------");
        System.out.println("1 - Cadastrar Veiculos");
        System.out.println("2 - Listar Veiculos");
        System.out.println("3 - Ficha Veiculo");
        System.out.println("4- Vender Veiculo");
        System.out.println("5- Sair");
        System.out.println("");
        System.out.println("Escolha a opção desejada: ");
        
        
        return s.nextInt();
    }
    
    public int MenuDeListagem()
    {
        return 0;
    }
    
    public boolean testaEntrada()
    {
        if(!s.hasNext("[1-5]"))
        {
            System.out.println("Opção errada!");
            clear();
            MenuPrincipal();
            return true;
        }
        else
            return false;
            
    }
    
    public void clear() 
    {
        try
        {
            Runtime.getRuntime().exec("cls");
        } catch (IOException ex)
        {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
