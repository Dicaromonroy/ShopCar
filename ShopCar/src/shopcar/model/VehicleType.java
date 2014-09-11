/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Vitor Freitas
 */
public enum VehicleType 
{
    CARRO("Carro", Carro.class),
    CAMINHAO("Caminhao", Caminhao.class);

    private static Map<String, VehicleType> types = new HashMap<>();

    static 
    {
        types.put(CARRO.asString(), CARRO);
        types.put(CAMINHAO.asString(), CAMINHAO);
    }

    private String str;
    private Class<? extends Veiculo> clazz;

    VehicleType(String str, Class<? extends Veiculo> clazz) 
    {
        this.str = str;
        this.clazz = clazz;
    }

    static VehicleType of(String str)
    {
        return types.get(str);
    }

    @SuppressWarnings("unchecked")
    <T extends Veiculo> T createInstance()
    {
        try 
        {
            return (T) this.clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) 
        {
            // there's no default constructor.
            return null;
        }
    }

    String asString() {
        return this.str;
    }
}
