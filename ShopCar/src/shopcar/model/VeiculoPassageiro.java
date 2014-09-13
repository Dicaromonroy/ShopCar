/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.model;

import java.util.Objects;
import javax.persistence.Entity;

/**
 *
 * @author Aluno
 */
@Entity
public class VeiculoPassageiro extends Veiculo
{
    private Integer numAssentos;

    /**
     * @return the numAssentos
     */
    public Integer getNumAssentos()
    {
        return numAssentos;
    }

    /**
     * @param numAssentos the numAssentos to set
     */
    public void setNumAssentos(Integer numAssentos)
    {
        this.numAssentos = numAssentos;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.numAssentos);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final VeiculoPassageiro other = (VeiculoPassageiro) obj;
        if (!Objects.equals(this.numAssentos, other.numAssentos))
        {
            return false;
        }
        return true;
    }
    
    
}
