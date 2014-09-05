/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.view;

import java.util.List;
import java.util.Scanner;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import javax.inject.*;
import org.jboss.weld.environment.se.events.ContainerInitialized;
import shopcar.controller.*;
import shopcar.model.*;
import shopcar.repository.JpaDAO;
import shopcar.util.*;



/**
 *
 * @author info1
 */
@ApplicationScoped
public class Principal
{
    @Inject private Util util;
    
    @Inject private Moto m;
    @Inject private List<Veiculo> veiculos;
    @Inject private VendeCarro vendeCarro;
    @Inject private VeiculoController veiculoController;
    
    @Inject private Validator<Veiculo> valida; 
    
    @Inject private JpaDAO<Veiculo> dao;
    
    public Principal() { }
    
    public void MenuPrincipal()
    {
        for (int i = 0; i < 40; ++i) System.out.println();
        System.out.println("         *** ShopCar ***");
        System.out.println("-------------------------------");
        System.out.println("1 - Cadastrar Veiculos");
        System.out.println("2 - Listar Veiculos");
        System.out.println("3 - Ficha Veiculo");
        System.out.println("4- Vender Veiculo");
        System.out.println("5- Sair");
        System.out.println("");
        System.out.println("Escolha a opção desejada: ");
        
        try
        {
            if(util.testInput(1,5) == 1) MenuPrincipal();
        } 
        catch (Exception e)
        {
            util.clear();
            System.out.println(e.getMessage());
        }
        
    }
    
    public void nextMenu(String from,int escolha)
    {
        
    }
    
    public int MenuDeListagem()
    {
        return 0;
    }
    
    private boolean testId(Object id)
    {
        return true;
    }
    
    public void teste()
    {
        try
        {
            m.setPlaca("CBC-1243");
            m.setModelo("aaaaaa");
            m.setNomealgo("BLABVLA");
            dao.save(m);
        } 
        catch (Exception e)
        {
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
        }
        
    }
}
