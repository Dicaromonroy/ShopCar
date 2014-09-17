/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.repository;

import java.util.List;
import javax.inject.Inject;
import shopcar.model.Veiculo;
import shopcar.repository.JpaDAO;

/**
 *
 * @author Mandy Grimm
 */
public class VeiculoDAO
{
    @Inject private JpaDAO<Veiculo> daoListagem;
    @Inject private List<String> placas;
    
    //<editor-fold defaultstate="collapsed" desc="Selects de Listagens">
    public List<Veiculo> listVeiculoByVendido()
    {
       List<Veiculo> resultList = daoListagem.getByRestriction
        ("Veiculo.listVeiculoByVendido", "vendido", true);
        return resultList;
    }
    
    public List<Veiculo> listVeiculoByModelo(String modelo)
    {
        List<Veiculo> resultList = daoListagem.getByRestriction
        ("Veiculo.listVeiculoByModelo", "mod", modelo);
        return resultList;
    }
    
    public List<Veiculo> listVeiculoByMarca(String marca)
    {
        List<Veiculo> resultList = daoListagem.getByRestriction
        ("Veiculo.listVeiculoByMarca", "marc", marca);
        return resultList;
    }
    
    public List<Veiculo> listVeiculoByKm(Integer km)
    {
        List<Veiculo> resultList = daoListagem.getByRestriction
        ("Veiculo.listVeiculoByKm", "km", km);
        return resultList;
    }
    
    public List<Veiculo> listVeiculoByAno(Integer ano)
    {
        List<Veiculo> resultList = daoListagem.getByRestriction
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
        placas = daoListagem.getEntityManager()
                .createNamedQuery("Veiculo.listAllVeiculosPlacas")
                .getResultList();
        
        for(String s : placas) 
        {
            if(s.equals(placa)) return true;
        }
        return false;
    }
//</editor-fold>
}