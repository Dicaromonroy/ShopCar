/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.repository;

import java.util.List;
import javax.inject.Inject;
import shopcar.entities.Veiculo;
import shopcar.util.MyArrayList;

/**
 *
 * @author Mandy Grimm
 */
public class VeiculoDAO
{
    @Inject private JpaDAO<Veiculo> daoVeiculo;
    @Inject @MyArrayList private List<String> placas;
    
    //<editor-fold defaultstate="collapsed" desc="Selects de Listagens">
    public List<Veiculo> listVeiculoByVendido()
    {
       List<Veiculo> resultList = daoVeiculo.getByRestriction
        ("Veiculo.listVeiculoByVendido", "vendido", true);
        return resultList;
    }
    
    public List<Veiculo> listVeiculoByModelo(String modelo)
    {
        List<Veiculo> resultList = daoVeiculo.getByRestriction
        ("Veiculo.listVeiculoByModelo", "mod", modelo);
        return resultList;
    }
    
    public List<Veiculo> listVeiculoByMarca(String marca)
    {
        List<Veiculo> resultList = daoVeiculo.getByRestriction
        ("Veiculo.listVeiculoByMarca", "marc", marca);
        return resultList;
    }
    
    public List<Veiculo> listVeiculoByKm(Integer km)
    {
        List<Veiculo> resultList = daoVeiculo.getByRestriction
        ("Veiculo.listVeiculoByKm", "km", km);
        return resultList;
    }
    
    public List<Veiculo> listVeiculoByAno(Integer ano)
    {
        List<Veiculo> resultList = daoVeiculo.getByRestriction
        ("Veiculo.listVeiculoByAno", "ano", ano);
        return resultList;
    }
    
   /* public List<Veiculo> listVeiculoByTipo(String placa)
    {
        List<Veiculo> resultList = daoListagem.getByRestriction
        ("Veiculo.listVeiculoByTipo", "placa", placa);
        return resultList;
    }*/
    
    public boolean testPlaca(String placa)
    {
        try
        {
            placas = daoVeiculo.getEntityManager()
                .createNamedQuery("Veiculo.listAllVeiculosPlacas")
                .getResultList();
        } 
        catch (Exception e)
        {
            System.err.println("Houve erro ao listar a placas! " + e.getMessage());
        }
        
        for(String s : placas) 
            if(s.equals(placa)) return true;
        return false;
    }
//</editor-fold>
}