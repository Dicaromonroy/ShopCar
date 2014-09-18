/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.entities;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Entity;

/**
 *
 * @author Aluno
 */
@Entity
public class VeiculoTransporte extends Veiculo
{
     private BigDecimal capcMaxCarga;    

    /**
     * @return the capcMaxCarga
     */
    public BigDecimal getCapcMaxCarga()
    {
        return capcMaxCarga;
    }

    /**
     * @param capcMaxCarga the capcMaxCarga to set
     */
    public void setCapcMaxCarga(BigDecimal capcMaxCarga)
    {
        this.capcMaxCarga = capcMaxCarga;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.capcMaxCarga);
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
        final VeiculoTransporte other = (VeiculoTransporte) obj;
        if (!Objects.equals(this.capcMaxCarga, other.capcMaxCarga))
        {
            return false;
        }
        return true;
    }
    
    
}
