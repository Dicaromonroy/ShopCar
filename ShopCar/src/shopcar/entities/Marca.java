/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;


/**
 *
 * @author Mandy Grimm
 */
@Entity
public class Marca implements Serializable
{
    @Id
    @GeneratedValue
    private Integer marcaId;
    private String marca;
    @OneToMany(mappedBy = "placa")
    private Set<Veiculo> veiculos;
    @OneToMany(mappedBy = "marca")
    private Set<Modelo> modelos;

    //<editor-fold defaultstate="collapsed" desc="Hash and Equals">
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.marcaId);
        hash = 41 * hash + Objects.hashCode(this.marca);
        hash = 41 * hash + Objects.hashCode(this.veiculos);
        hash = 41 * hash + Objects.hashCode(this.modelos);
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
        final Marca other = (Marca) obj;
        if (!Objects.equals(this.marcaId, other.marcaId)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.veiculos, other.veiculos)) {
            return false;
        }
        if (!Objects.equals(this.modelos, other.modelos)) {
            return false;
        }
        return true;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Gets and Sets">
    
    public Integer getMarcaId() {
        return marcaId;
    }
    
    public void setMarcaId(Integer marcaId) {
        this.marcaId = marcaId;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
  
    public Set<Veiculo> getVeiculo() {
        return veiculos;
    }
    
    public void setVeiculo(Set<Veiculo> veiculo) {
        this.veiculos = veiculo;
    }
   
    public Set<Modelo> getModelo() {
        return modelos;
    }
    
    public void setModelo(Set<Modelo> modelo) {
        this.modelos = modelo;
    }
//</editor-fold>
    
    
}
