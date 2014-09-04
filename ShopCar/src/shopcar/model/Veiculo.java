/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.model;


import java.io.Serializable;
import java.math.BigDecimal;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.*;
import javax.validation.constraints.*;
/**
 *
 * @author info1
 */
@Entity
public class Veiculo implements Serializable 
{
    @Id
    @NotNull(message = "Placa não pode estar em branco!")
    @Pattern(regexp = "[A-Z]{3}-\\d{4}", message = "A Placa deve obedecer o formato ABC-1234!")
    private String placa;
    @NotNull(message = "Modelo não pode estar em branco!")
    @Size(min = 4, message = "O tamanho minimo é de 4 caracteres!")
    private String modelo;
    private boolean vendido;

    /**
     * @return the placa
     */
    public String getPlaca()
    {
        return placa;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa)
    {
        this.placa = placa;
    }

    /**
     * @return the modelo
     */
    public String getModelo()
    {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo)
    {
        this.modelo = modelo;
    }

    /**
     * @return the vendido
     */
    public boolean isVendido()
    {
        return vendido;
    }

    /**
     * @param vendido the vendido to set
     */
    public void setVendido(boolean vendido)
    {
        this.vendido = vendido;
    }
}
