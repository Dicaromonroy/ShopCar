/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package veiculo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Mandy Grimm
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Veiculo.listAllVeiculosTypes",
            query= "SELECT DISTINCT v.class FROM Veiculo v"),
    @NamedQuery(name = "Veiculo.listAllVeiculoModelos",
            query = "SELECT v.modelo FROM Veiculo v"),
//    @NamedQuery(name = "Veiculo.listAllVeiculoMarcas",
//            query = "SELECT v.marca FROM Veiculo v"),
//    @NamedQuery(name = "Veiculo.listAllVeiculoCores",
//            query = "SELECT v.cor FROM Veiculo v")
})

@Inheritance
@DiscriminatorColumn(name = "tipoVeiculo")
public class Veiculo implements Serializable
{
    @Id
    //@Pattern(regexp = "[A-Z]{3}-\\d{4}", message = 
            //"A Placa deve obedecer o formato ABC-1234!")
    private String placa;
    private String chassi;
    @Temporal(TemporalType.DATE)
    private Date anoFabricacao;
    private Integer quilometragem;
    private BigDecimal valorVeiculo; 
    private Integer potenciaCV;
    private Integer cilindradas;
    private Integer numeroEixos;
    private Integer numeroMarchas;
    @OneToOne
    private Cor cor;
    @OneToOne
    private Marca marca;
    @OneToOne
    private Modelo modelo;

    //<editor-fold defaultstate="collapsed" desc="Hash and Equals">
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.placa);
        hash = 53 * hash + Objects.hashCode(this.chassi);
        hash = 53 * hash + Objects.hashCode(this.anoFabricacao);
        hash = 53 * hash + Objects.hashCode(this.quilometragem);
        hash = 53 * hash + Objects.hashCode(this.valorVeiculo);
        hash = 53 * hash + Objects.hashCode(this.potenciaCV);
        hash = 53 * hash + Objects.hashCode(this.cilindradas);
        hash = 53 * hash + Objects.hashCode(this.numeroEixos);
        hash = 53 * hash + Objects.hashCode(this.numeroMarchas);
        hash = 53 * hash + Objects.hashCode(this.cor);
        hash = 53 * hash + Objects.hashCode(this.marca);
        hash = 53 * hash + Objects.hashCode(this.modelo);
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
        final Veiculo other = (Veiculo) obj;
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        if (!Objects.equals(this.chassi, other.chassi)) {
            return false;
        }
        if (!Objects.equals(this.anoFabricacao, other.anoFabricacao)) {
            return false;
        }
        if (!Objects.equals(this.quilometragem, other.quilometragem)) {
            return false;
        }
        if (!Objects.equals(this.valorVeiculo, other.valorVeiculo)) {
            return false;
        }
        if (!Objects.equals(this.potenciaCV, other.potenciaCV)) {
            return false;
        }
        if (!Objects.equals(this.cilindradas, other.cilindradas)) {
            return false;
        }
        if (!Objects.equals(this.numeroEixos, other.numeroEixos)) {
            return false;
        }
        if (!Objects.equals(this.numeroMarchas, other.numeroMarchas)) {
            return false;
        }
        if (!Objects.equals(this.cor, other.cor)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        return true;
    }
//</editor-fold>
   
    //<editor-fold defaultstate="collapsed" desc="Gets and Sets">
    public Cor getCor() {
        return cor;
    }
    public void setCor(Cor cor) {
        this.cor = cor;
    }
    public Marca getMarca() {
        return marca;
    }
    
    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    public Modelo getModelo() {
        return modelo;
    }
    
    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
    public String getPlaca() {
        return placa;
    }
    
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    public String getChassi() {
        return chassi;
    }
    
    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public Date getAnoFabricacao() {
        return anoFabricacao;
    }
    
    public void setAnoFabricacao(Date anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }
    
    public Integer getQuilometragem() {
        return quilometragem;
    }
    
    public void setQuilometragem(Integer quilometragem) {
        this.quilometragem = quilometragem;
    }
    
    public BigDecimal getValorVeiculo() {
        return valorVeiculo;
    }
    
    public void setValorVeiculo(BigDecimal valorVeiculo) {
        this.valorVeiculo = valorVeiculo;
    }
    
    public Integer getPotenciaCV() {
        return potenciaCV;
    }
    
    public void setPotenciaCV(Integer potenciaCV) {
        this.potenciaCV = potenciaCV;
    }
    
    public Integer getCilindradas() {
        return cilindradas;
    }
    
    public void setCilindradas(Integer cilindradas) {
        this.cilindradas = cilindradas;
    }
    
    public Integer getNumeroEixos() {
        return numeroEixos;
    }
    
    public void setNumeroEixos(Integer numeroEixos) {
        this.numeroEixos = numeroEixos;
    }
    
    public Integer getNumeroMarchas() {
        return numeroMarchas;
    }
    
    public void setNumeroMarchas(Integer numeroMarchas) {
        this.numeroMarchas = numeroMarchas;
    }
//</editor-fold>
    
}
