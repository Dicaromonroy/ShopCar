/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.controller;

import javax.enterprise.event.Observes;

/**
 *
 * @author info1
 */
public class VeiculoController
{
    
            
    
    public void recebeVenda(@Observes VendaMovimento eventVenda)
    {
        System.out.println(eventVenda.getVeiculo().isVendido());
    }
}
