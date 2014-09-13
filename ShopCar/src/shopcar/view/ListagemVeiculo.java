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
    private String idVeiculo, modelo;
    private Util util;
    private Veiculo v = new Veiculo();
    
    public void ListarVeiculo()
    {        
        for (int i = 0; i < 40; ++i) System.out.println();
        System.out.println("         *** ShopCar ***");
        System.out.println("-------------------------------");
        System.out.println("1 - Listar Veículos por Marca.");
        System.out.println("2 - Listar Veículos por Modelo.");
        System.out.println("3 - Listar Veículos por Cor.");
        System.out.println("4 - Listar Veículos por Versão.");
        System.out.println("5 - Listar Veículos por Ano deFabricação.");
        System.out.println("6 - Listar Veículos por Quilometragem.");
        System.out.println("7 - Listar Veículos por Valor do Veículo.");
        System.out.println("8 - Listar Veículos por Cilindradas.");
        System.out.println("9 - Listar Veículos por Número de Eixos.");
        System.out.println("10 - Listar Veículos por Número de Marchas");
        System.out.println("11 - Listar Veículos por Potência CV.");
        System.out.println("12 - Listar Veículos por Número de Assentos.");
        System.out.println("13 - Listar Veículos por Número de Portas.");
        System.out.println("0 - Sair");
        System.out.println("");
        System.out.println("Escolha a opção desejada: ");
        try
        {
            nextMenu("ListarVeiculo",util.testInput(0,13));
        } 
        catch (Exception e)
        {
            util.clear();
            System.out.println(e.getMessage());
        }
        
    }
    
    public void nextMenu(String from,int escolha)
    {
        modelo = v.getModelo().getModelo();
        v = daoListagem.getById(modelo);
        
        if(from.equalsIgnoreCase("ListarVeiculo"))
        {
            switch(escolha)
            {
                case 1:
                    daoListagem.getByRestriction("Veiculo.listVeiculoByModelo",
                            "mod", v);
            }
        }
    }
    
//    public void pegarPlaca()
//    {
//        String placa;
//        System.out.println("         *** ShopCar ***");
//        System.out.println("-------------------------------");
//        System.out.println("Entre com a placa desejada: ");
//        placa = util.testaPlaca();
//        FichaVeiculo(placa);
//    }
    
    //<editor-fold defaultstate="collapsed" desc="Ficha do Veículo">
    public void FichaVeiculo(String placa)
    {
        v = daoListagem.getById(placa);
        
        System.out.println("     *** Ficha do Veículo ***    ");
        System.out.println("---------------------------------");
        System.out.println("| Placa do veículo: " + v.getPlaca());
        System.out.println("| Marca: " + v.getMarca().getMarca());
        System.out.println("| Modelo: " + v.getModelo().getModelo());
        System.out.println("| Versão do modelo: " + v.getModelo().getVersao());
        System.out.println("---------------------------------");
        System.out.println("| Cor: " + v.getCor().getCor());
        System.out.println("| Ano de Fabricação: " + v.getAnoFabricacao());
        System.out.println("| Valor: " + v.getValorVeiculo());
        System.out.println("---------------------------------");
        System.out.println("| Chassi: " + v.getChassi());
        System.out.println("| Cilindradas: " + v.getCilindradas());
        System.out.println("| Número de Eixos: " + v.getNumeroEixos());
        System.out.println("| Número de Marchas: " + v.getNumeroMarchas());
        System.out.println("| Potência em CV: " + v.getPotenciaCV());
        System.out.println("| Quilometragemo: " + v.getQuilometragem());
    }
//</editor-fold>
}
