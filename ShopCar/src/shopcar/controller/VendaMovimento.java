/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.controller;

import shopcar.model.Veiculo;

/**
 *
 * @author info1
 */
public class VendaMovimento
{
    private Veiculo veiculo;
    
    public VendaMovimento(Veiculo veiculo)
    {
        this.veiculo = veiculo;
    }
    
    public Veiculo getVeiculo()
    {
        return this.veiculo;
    }
}
