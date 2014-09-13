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
        FichaVeiculo(placa);
    }
    
    public void FichaVeiculo(String placa)
    {
        Veiculo v;
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
}
