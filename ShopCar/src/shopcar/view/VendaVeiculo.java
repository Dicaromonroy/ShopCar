/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.view;

import shopcar.entities.Cliente;
import shopcar.entities.Veiculo;
import javax.inject.Inject;
import shopcar.controller.VendeCarro;
import shopcar.repository.JpaDAO;

/**
 *
 * @author info1
 */
public class VendaVeiculo
{
    @Inject private JpaDAO<Veiculo> daoVeiculo;
    @Inject private JpaDAO<Cliente> daoCliente;
    @Inject private VendeCarro vendeCarro;
    
    public void Vender(String placa)
    {
        try
        {
            Veiculo v;
            v = daoVeiculo.getById(placa);
            
            Cliente c = daoCliente.getById(Long.valueOf("1"));
            vendeCarro.Vender(v, c);
        } 
        catch (Exception e)
        {
            System.out.println("Erro ao chamar o vende veiculo" + e.getMessage());
        }
    }
}
