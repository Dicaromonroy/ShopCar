/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.entities;

/**
 *
 * @author info1
 */
public enum VeiculoTypes
{
    MOTO("Moto"),
    CARRO("Carro"),
    CAMINHAO("Caminhão"),
    CAMINHONETE("Caminhonete"),
    ONIBUS("Ônibus"),
    VEICULO("Veiculo");
    
    private final String descricao;
    
    VeiculoTypes(String descricao)
    {
        this.descricao = descricao;
    }

}
