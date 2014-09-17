/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.model;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import shopcar.controller.VendaMovimento;
import shopcar.repository.JpaDAO;

/**
 *
 * @author info1
 */
public class VendaDAO
{
    @Inject private JpaDAO<Venda> daoVenda;
    @Inject private Venda v;
    
    public void recebeVenda(@Observes VendaMovimento eventVenda)
    {
        try
        {
            v.setCliente(eventVenda.getCliente());
            daoVenda.save(v);
        } 
        catch (Exception e)
        {
            System.err.println("Venda deu errado!" + e.getMessage());
        }
    }
}
