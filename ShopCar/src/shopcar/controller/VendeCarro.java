/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.controller;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import shopcar.model.Veiculo;

/**
 *
 * @author info1
 */
public class VendeCarro
{
    @Inject private Event<VendaMovimento> eventVenda;
    
    public void Vender(Veiculo veiculo)
    {
        veiculo.setVendido(true);
        eventVenda.fire(new VendaMovimento(veiculo));
    }
    
}
