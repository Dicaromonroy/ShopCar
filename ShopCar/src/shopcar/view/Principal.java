/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.view;

import static javafx.application.Platform.exit;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.*;
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
    @Inject private CadastroVeiculo cadastroVeiculo;
    @Inject private VendeCarro vendeCarro;
    @Inject private VeiculoController veiculoController;
    @Inject private ListagemVeiculo listagem;
    @Inject private Validator<Veiculo> valida; 
    @Inject private JpaDAO<Veiculo> dao;

    public Principal() { }
    
    //<editor-fold defaultstate="collapsed" desc="Menu Principal">
    public void MenuPrincipal()
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
            nextMenu("menuprincipal",util.testInput("[1-5]"));
        }
        catch (Exception e)
        {
            util.clear();
            System.out.println(e.getMessage());
        }
    }
    
    public void nextMenu(String from,int escolha)
    {
        if(from.equalsIgnoreCase("menuprincipal"))
        {
            switch(escolha)
            {
                case 1:
                  cadastroVeiculo.saveVeiculo();
                 break;
                case 2:
                    MenuDeListagem();
                    break;
                case 3:
                    listagem.pegarPlaca();
                    break;
            }
        }
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Menu de Listagem">
    public void MenuDeListagem()
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
            nextMenuListagem("listarVeiculo",util.testInput("[1-6]"));
            
        }
        catch (Exception e)
        {
            util.clear();
            System.out.println("Caiu aquêêêêh" + e.getMessage());
        }
    }
    public void nextMenuListagem(String from,int escolha)
    {
        if(from.equalsIgnoreCase("listarVeiculo"))
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
                    exit();
            }
        }
    }
//</editor-fold>
}
