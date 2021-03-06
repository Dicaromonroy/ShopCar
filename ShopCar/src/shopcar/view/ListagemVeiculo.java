/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.view;

import java.util.List;
import javax.inject.Inject;
import shopcar.entities.*;
import shopcar.qualifiers.MyArrayList;
import shopcar.qualifiers.VeiculosType;
import shopcar.repository.JpaDAO;
import shopcar.repository.VeiculoDAO;
import shopcar.util.Util;

/**
 *
 * @author Aluno
 */
public class ListagemVeiculo
{
    @Inject private JpaDAO<Veiculo> daoListagem;
    private String idVeiculo;
    @Inject private VeiculoDAO vdao;
    @Inject private Util util;
    @Inject @MyArrayList private List<Veiculo> listados;
    @Inject @VeiculosType(VeiculoTypes.VEICULO) private Veiculo v;
    
    //<editor-fold defaultstate="collapsed" desc="Listar por Modelo">
    public void listagemModelo()
    {
        String nomeModelo;
        System.out.println("         *** ShopCar ***");
        System.out.println("-------------------------------");
        System.out.println("Entre com o modelo desejado: ");
        try
        {
            nomeModelo = util.testInputString("[a-z-A-Z]");
            listados = vdao.listVeiculoByModelo(nomeModelo);
            
            System.out.println("         *** ShopCar ***");
            System.out.println("-------------------------------");
            System.out.println("");
            System.out.println("Veículos com o Modelo informado");
            System.out.println("-------------------------------");
            for(Veiculo v : listados)
            {
                System.out.println("Placa: " + v.getPlaca());
            }
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            for(StackTraceElement t : e.getStackTrace()) System.err.println(t);
        }
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Listar por Marca">
    public void listagemMarca()
    {
        String nomeMarca;
        System.out.println("         *** ShopCar ***");
        System.out.println("-------------------------------");
        System.out.println("Entre com a Marca desejado: ");
        try
        {
            nomeMarca = util.testInputString("[a-z-A-Z]");
            listados = vdao.listVeiculoByMarca(nomeMarca);
            
            System.out.println("         *** ShopCar ***");
            System.out.println("-------------------------------");
            System.out.println("");
            System.out.println("Veículos com a Marca informado");
            System.out.println("-------------------------------");
            for(Veiculo v : listados)
            {
                System.out.println("Placa: " + v.getPlaca());
            }
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            for(StackTraceElement t : e.getStackTrace()) System.err.println(t);
        }
    }

    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Listar por Ano">
    public void listagemAno()
    {
        Integer anoFabricacao;
        System.out.println("         *** ShopCar ***");
        System.out.println("-------------------------------");
        System.out.println("Entre com o Ano de Fabricação desejado: ");
        try
        {
            anoFabricacao = util.testInput("[0-9]{4}", "Ano errado!");
            listados = vdao.listVeiculoByAno(anoFabricacao);
            
            System.out.println("         *** ShopCar ***");
            System.out.println("-------------------------------");
            System.out.println("");
            System.out.println("Veículos com o Ano de Fabricação informado");
            System.out.println("-------------------------------");
            for(Veiculo v : listados)
            {
                System.out.println("Placa: " + v.getPlaca());
            }
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            for(StackTraceElement t : e.getStackTrace()) System.err.println(t);
        }
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Listar por KM">
    public void listagemKM()
    {
        Integer km;
        System.out.println("         *** ShopCar ***");
        System.out.println("-------------------------------");
        System.out.println("Entre com a Quilometragem desejada: ");
        try
        {
            km = util.testInput("[0-9]{5}|[0-9]{4}|[0]{1}", "Quilometragem errada!");
            listados = vdao.listVeiculoByKm(km);
            
            System.out.println("         *** ShopCar ***");
            System.out.println("-------------------------------");
            System.out.println("");
            System.out.println("Veículos com a Quilometragem informada");
            System.out.println("-------------------------------");
            for(Veiculo v : listados)
            {
                System.out.println("Placa: " + v.getPlaca());
            }
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            for(StackTraceElement t : e.getStackTrace()) System.err.println(t);
        }
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Listar por Vendidos">
    public void listagemVendidos()
    {
        try
        {
            listados = vdao.listVeiculoByVendido();
            System.out.println("         *** ShopCar ***");
            System.out.println("-------------------------------");
            System.out.println("");
            System.out.println("     Veículos Vendidos         ");
            System.out.println("-------------------------------");
            for(Veiculo v : listados)
            {
                System.out.println("Placa: " + v.getPlaca());
            }
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            for(StackTraceElement t : e.getStackTrace()) System.err.println(t);
        }
    }
//</editor-fold>
            
    //<editor-fold defaultstate="collapsed" desc="Pega a placa digitada pelo usuário">
    public void pegarPlaca()
    {
        String placa;
        System.out.println("         *** ShopCar ***");
        System.out.println("-------------------------------");
        System.out.println("Entre com a placa desejada: ");
        try
        {
            placa = util.testInputString("[A-Z]{3}-\\[0-9]{3}");
            fichaVeiculo(placa);
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Ficha do Veículo">
      public void fichaVeiculo(String placa)
    {
        try
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
            
            if(v instanceof VeiculoPassageiro)
            {
                System.out.println("| Número de Assentos: " + ((VeiculoPassageiro)v).getNumAssentos());
            }
            
            if(v instanceof VeiculoTransporte)
            {
                System.out.println("| Capacidade Máxima de Carga: " + ((VeiculoTransporte)v).getCapcMaxCarga());
            }
            
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
//</editor-fold>
}

