/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.model;

import javax.enterprise.inject.Produces;
import shopcar.util.VeiculosType;

/**
 *
 * @author info1
 */
public class VeiculoFactory
{
    private VeiculoTypes veiculoType;
    
    @Produces
    @VeiculosType(VeiculoTypes.MOTO)
    public Veiculo createMoto()
    {
        return new Moto();
    }
    
    @Produces
    @VeiculosType(VeiculoTypes.CARRO)
    public Veiculo createCarro()
    {
        return new Carro();
    }
    
    @Produces
    @VeiculosType(VeiculoTypes.ONIBUS)
    public Veiculo createOnibus()
    {
        return new Onibus();
    }
    
    @Produces
    @VeiculosType(VeiculoTypes.CAMINHAO)
    public Veiculo createCaminhao()
    {
        return new Caminhao();
    }
    
    @Produces
    @VeiculosType(VeiculoTypes.CAMINHONETE)
    public Veiculo createCaminhonete()
    {
        return new Caminhonete();
    }
}
