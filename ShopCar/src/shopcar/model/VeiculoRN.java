/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.model;

import java.util.List;
import javax.inject.Inject;
import shopcar.repository.JpaDAO;
import shopcar.util.MyArrayList;

/**
 *
 * @author Mandy Grimm
 */
public class VeiculoRN
{
    @Inject @MyArrayList private List<Veiculo> lista;
    @Inject private JpaDAO<Veiculo> daoListagem;
    
    //<editor-fold defaultstate="collapsed" desc="Selects de Listagens">
    public List selectListagemVendido()
    {
        return lista = daoListagem.getByRestriction("Veiculo.listVeiculoByVendido",
                "vendido", true);
    }
    
    public List selectListagemModelo(String modelo)
    {
        return lista = daoListagem.getByRestriction("Veiculo.listVeiculoByModelo",
                "mod", modelo);
    }
    
    public List selectListagemMarca(String marca)
    {
        return lista = daoListagem.getByRestriction
                                       ("Veiculo.listVeiculoByMarca", "marc", marca);
    }
    
    public List selectListagemKM(Integer km)
    {
        return lista = daoListagem.getByRestriction("Veiculo.listVeiculoByKm",
                "km", km);
    }
    
    public List selectListagemAno(Integer ano)
    {
        return lista = daoListagem.getByRestriction("Veiculo.listVeiculoByAno",
                "ano", ano);
    }
//</editor-fold>
}
