/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;


/**
 *
 * @author Mandy Grimm
 */
@Entity
public class Cor implements Serializable
{
    @Id
    @GeneratedValue
    private Integer corId;
    private String cor;
    @OneToMany(mappedBy = "placa")
    private Set<Veiculo> veiculo;

    //<editor-fold defaultstate="collapsed" desc="Hash and Equals">
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.corId);
        hash = 29 * hash + Objects.hashCode(this.cor);
        hash = 29 * hash + Objects.hashCode(this.veiculo);
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
        final Cor other = (Cor) obj;
        if (!Objects.equals(this.corId, other.corId)) {
            return false;
        }
        if (!Objects.equals(this.cor, other.cor)) {
            return false;
        }
        if (!Objects.equals(this.veiculo, other.veiculo)) {
            return false;
        }
        return true;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Gets and Sets">
   
    public Integer getCorId() {
        return corId;
    }
    
    public void setCorId(Integer corId) {
        this.corId = corId;
    }
    
    public String getCor() {
        return cor;
    }
    
    public void setCor(String cor) {
        this.cor = cor;
    }
    public Set<Veiculo> getVeiculo() {
        return veiculo;
    }
    
    public void setVeiculo(Set<Veiculo> veiculo) {
        this.veiculo = veiculo;
    }
//</editor-fold>
    
    
}
