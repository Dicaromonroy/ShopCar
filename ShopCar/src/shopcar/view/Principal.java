/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.view;

import java.util.Scanner;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.*;
import shopcar.controller.*;
import shopcar.repository.VeiculoDAO;
import shopcar.util.*;

/**
 *
 * @author info1
 */
public class Principal
{
    @Inject private Util util;
    @Inject private CadastroVeiculo cadastroVeiculo;
    @Inject private VendaVeiculo vendaVeiculo;
    @Inject private VendeCarro vendeCarro;
    @Inject private VeiculoVendaController veiculoController;
    @Inject private VeiculoDAO veiculoDAO;
    @Inject private Scanner s;
    @Inject private ListagemVeiculo listagem;
    private String veiculoPlaca;
    

    public Principal() { }
    
    public int MenuPrincipal()
    {
        for (int i = 0; i < 40; ++i) System.out.println();
        System.out.println("         *** ShopCar ***");
        System.out.println("-------------------------------");
        System.out.println("1 - Cadastrar Veiculos");
        System.out.println("2 - Listar Veiculos");
        System.out.println("3 - Ficha Veiculo");
        System.out.println("4 - Vender Veiculo");
        System.out.println("5- Sair");
        System.out.println("");
        System.out.println("Escolha a opção desejada: ");
        
        try
        {
            nextMenu("menuprincipal",util.testInput("[1-5]", "Opção inválida!"));
        } 
        catch (Exception e)
        {
            util.clear();
            return MenuPrincipal();
        }
        return 0;
    }
    
    public void nextMenu(String from,int escolha)
    {
        if(from.equalsIgnoreCase("menuprincipal"))
        {
            switch(escolha)
            {
                case 1: 
                    if(!testPlaca())
                        cadastroVeiculo.saveVeiculo(veiculoPlaca);
                    else
                    {
                        System.out.println("Esta placa já está cadastrada! "
                                + "Deseja ver a ficha deste Veiculo? [s/n]");
                        String test = s.nextLine();
                        if(test.equalsIgnoreCase("s"))
                            listagem.fichaVeiculo(veiculoPlaca);
                        else
                            MenuPrincipal();
                    }
                    break;
                    
                case 2:
                    MenuDeListagem();
                    break;
                    
                case 3:
                    if(testPlaca())
                        listagem.fichaVeiculo(veiculoPlaca);
                    else
                    {
                        System.out.println("Esse Veiculo ainda não foi cadastrado! "
                                + "Deseja cadastrar um veiculo com a Placa digitada? [s/n]");
                        String test = s.nextLine();
                        if(test.equalsIgnoreCase("s"))
                            cadastroVeiculo.saveVeiculo(veiculoPlaca);
                        else
                            MenuPrincipal();
                    }
                    break;
                    
                case 4:
                    if(testPlaca())
                        vendaVeiculo.Vender(veiculoPlaca);
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
    
    private boolean testPlaca()
    {
        System.out.println("-------------------------------");
        System.out.println("Entre com a placa do Veiculo[FORMATO: ABC-1234]: ");
        if(s.hasNext("[A-Z]{3}-\\d{4}"))
        {
            veiculoPlaca = s.nextLine();
            if(veiculoDAO.testPlaca(veiculoPlaca))
                return true;
            else
                return false;
        }
        else
        {
            System.out.println("Formato de placa errado! ");
            s.next();
            util.clear();
            return testPlaca();
        }
    }
    
    public int MenuDeListagem()
    {
        for (int i = 0; i < 40; ++i) System.out.println();
        System.out.println("         *** ShopCar ***");
        System.out.println("-------------------------------");
        System.out.println("1 - Listar Veículos por Marca.");
        System.out.println("2 - Listar Veículos por Modelo.");
        System.out.println("3 - Listar Veículos por Ano de Fabricação.");
        System.out.println("4 - Listar Veículos por Quilometragem.");
        System.out.println("5 - Listar Veículos não Vendidos");
        System.out.println("6 - Sair");
        System.out.println("");
        System.out.println("Escolha a opção desejada: ");
        try
        {
            nextMenuListagem(util.testInput("[1-6]", "Opção errada!"));
            
        }
        catch (Exception e)
        {
            util.clear();
            return MenuDeListagem();
        }
        return 0;
    }
    public void nextMenuListagem(int escolha)
    {
        switch(escolha)
        {
            case 1:
                listagem.listagemMarca();
                break;
            case 2:
                listagem.listagemModelo();
                break;
            case 3:
                listagem.listagemAno();
                break;
            case 4:
                listagem.listagemKM();
                break;
            case 5:
                listagem.listagemVendidos();
                break;
            case 6:
                System.exit(0);
        }
    }
}
