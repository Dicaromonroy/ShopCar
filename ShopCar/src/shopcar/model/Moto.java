/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.model;

import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Vitor Freitas
 */
@Entity
public class Moto extends Veiculo
{
    @Column(name = "nomealgo")
    private String nomealgo;

    /**
     * @return the nomealgo
     */
    public String getNomealgo()
    {
        return nomealgo;
    }

    /**
     * @param nomealgo the nomealgo to set
     */
    public void setNomealgo(String nomealgo)
    {
        this.nomealgo = nomealgo;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.nomealgo);
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
        final Moto other = (Moto) obj;
        if (!Objects.equals(this.nomealgo, other.nomealgo))
        {
            return false;
        }
        return true;
    }
    
    
}
