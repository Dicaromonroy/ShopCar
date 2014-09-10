/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;


/**
 *
 * @author Mandy Grimm
 */
@Entity
public class Carro extends VeiculoPassageiro implements Serializable
{
    private String carroceria;
    private Integer numeroPortas;

    //<editor-fold defaultstate="collapsed" desc="Gets and Sets">
    public String getCarroceria() {
        return carroceria;
    }
    
    public void setCarroceria(String carroceria) {
        this.carroceria = carroceria;
    }
    
    public Integer getNumeroPortas() {
        return numeroPortas;
    }
    
    public void setNumeroPortas(Integer numeroPortas) {
        this.numeroPortas = numeroPortas;
    }

//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Hash and Equals">
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.carroceria);
        hash = 17 * hash + Objects.hashCode(this.numeroPortas);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carro other = (Carro) obj;
        if (!Objects.equals(this.carroceria, other.carroceria)) {
            return false;
        }
        if (!Objects.equals(this.numeroPortas, other.numeroPortas)) {
            return false;
        }
        return true;
    }
//</editor-fold>
    
    
}
