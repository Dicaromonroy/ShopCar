/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.view;

import java.util.Scanner;
import javax.inject.Inject;
import shopcar.model.*;
import shopcar.repository.JpaDAO;
import shopcar.util.Util;

/**
 *
 * @author Aluno
 */
public class ListagemVeiculo
{
    @Inject private JpaDAO<Veiculo> daoListagem;
    private String idVeiculo;
    private Util util;
    
    public ListagemVeiculo()
    {
        
    }
    
    public void Teste()
    {        
        for (int i = 0; i < 40; ++i) System.out.println();
        System.out.println("         *** ShopCar ***");
        System.out.println("-------------------------------");
        System.out.println("1 - Listar Veículos por Placa.");
        System.out.println("2 - Listar Veículos por Marca.");
        System.out.println("3 - Listar Veículos por Modelo.");
        System.out.println("4 - Listar Veículos por Tipo.");
        System.out.println("5 - Sair");
        System.out.println("");
        System.out.println("Escolha a opção desejada: ");
//        try
//        {
//            nextMenu("Teste",util.testInput(1,5));
//        } 
//        catch (Exception e)
//        {
//            util.clear();
//            System.out.println(e.getMessage());
//        }
//        
    }
    
    public void nextMenu(String from,int escolha)
    {
        if(from.equalsIgnoreCase("Teste"))
        {
            switch(escolha)
            {
                case 1: 
                    pegarPlaca();
            }
        }
    }
    
    public void pegarPlaca()
    {
        String placa;
        System.out.println("         *** ShopCar ***");
        System.out.println("-------------------------------");
        System.out.println("Entre com a placa desejada: ");
        placa = util.testaPlaca();
        ListagemPlaca(placa);
    }
    
    public void ListagemPlaca(String placa)
    {
        Veiculo v = new Veiculo();
        daoListagem.getById(placa);
        System.out.println("Placa do veículo desejado: " + v.getPlaca());
        System.out.println("Marca do veículo desejado: " + v.getMarca());
        
    }
}
