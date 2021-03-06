package shopcar.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 *
 * @author Mandy Grimm
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Veiculo.listAllVeiculosTypes",
            query= "SELECT DISTINCT v.class FROM Veiculo v"),
    @NamedQuery(name = "Veiculo.listVeiculoByModelo",
            query = "SELECT v FROM Veiculo v WHERE v.modelo.modelo = :mod"),
    @NamedQuery(name = "Veiculo.listVeiculoByMarca",
            query = "SELECT v FROM Veiculo v WHERE v.marca.marca = :marc"),
    @NamedQuery(name = "Veiculo.listVeiculoByAno",
            query = "SELECT v FROM Veiculo v WHERE v.anoFabricacao = :ano"),
    @NamedQuery(name = "Veiculo.listVeiculoByKm",
            query = "SELECT v FROM Veiculo v WHERE v.quilometragem = :km"),
    @NamedQuery(name = "Veiculo.listVeiculoByVendido",
            query = "SELECT v FROM Veiculo v WHERE v.vendido = :vendido"),
    @NamedQuery(name = "Veiculo.listAllVeiculosPlacas",
            query = "SELECT v.placa FROM Veiculo v")
})
@Inheritance
@DiscriminatorColumn(name = "tipoVeiculo")
public class Veiculo implements Serializable
{
    private static final Long serialVersionUID = 1L;
    
    public static final String ALL_VEICULOS_TYPES = "Veiculo.listAllVeiculosTypes";
    public static final String VEICULO_BY_MODELO = "Veiculo.listVeiculoByModelo";
    public static final String VEICULO_BY_MARCA = "Veiculo.listVeiculoByMarca";
    public static final String VEICULO_BY_ANO = "Veiculo.listVeiculoByAno";
    public static final String VEICULO_BY_KM = "Veiculo.listVeiculoByKm";
    public static final String VEICULO_BY_VENDIDO = "Veiculo.listVeiculoByVendido";
    public static final String ALL_VEICULOS_PLACAS = "Veiculo.listAllVeiculosPlacas";
    
    @Id
    @Pattern(regexp = "[A-Z]{3}-\\d{4}$", message = 
            "A Placa deve obedecer o formato ABC-1234!")
    private String placa;
    @Pattern(regexp = "[A-Z0-9]{11}[0-9]{6}", message = "O Número de Chassi"
            + " deve possuir 17 dígitos/letras, sendo os últimos 6 o número de"
            + " série!")
    @NotNull
    private String chassi;
    @Digits(integer = 4,  fraction = 3, message = "Não pode ter do que 4 dígitos!")
    @NotNull
    private Integer anoFabricacao;
    @NotNull
    private Integer quilometragem;
    @NotNull
    private BigDecimal valorVeiculo; 
    @NotNull
    private Integer potenciaCV;
    @NotNull
    private String cilindradas;
    @Min(1)
    @Max(10)
    @NotNull
    private Integer numeroEixos;
    @Min(2)
    @Max(20)
    @NotNull
    private Integer numeroMarchas;
    @NotNull
    private boolean vendido;
    @OneToOne
    private Cor cor;
    @OneToOne
    private Marca marca;
    @OneToOne
    private Modelo modelo;
    @OneToMany(mappedBy = "veiculo")
    private Set<ItemPedido> itemPedido;

    //<editor-fold defaultstate="collapsed" desc="Hash and Equals">
    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.placa);
        hash = 67 * hash + Objects.hashCode(this.chassi);
        hash = 67 * hash + Objects.hashCode(this.anoFabricacao);
        hash = 67 * hash + Objects.hashCode(this.quilometragem);
        hash = 67 * hash + Objects.hashCode(this.valorVeiculo);
        hash = 67 * hash + Objects.hashCode(this.potenciaCV);
        hash = 67 * hash + Objects.hashCode(this.cilindradas);
        hash = 67 * hash + Objects.hashCode(this.numeroEixos);
        hash = 67 * hash + Objects.hashCode(this.numeroMarchas);
        hash = 67 * hash + (this.vendido ? 1 : 0);
        hash = 67 * hash + Objects.hashCode(this.cor);
        hash = 67 * hash + Objects.hashCode(this.marca);
        hash = 67 * hash + Objects.hashCode(this.modelo);
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
        final Veiculo other = (Veiculo) obj;
        if (!Objects.equals(this.placa, other.placa))
        {
            return false;
        }
        if (!Objects.equals(this.chassi, other.chassi))
        {
            return false;
        }
        if (!Objects.equals(this.anoFabricacao, other.anoFabricacao))
        {
            return false;
        }
        if (!Objects.equals(this.quilometragem, other.quilometragem))
        {
            return false;
        }
        if (!Objects.equals(this.valorVeiculo, other.valorVeiculo))
        {
            return false;
        }
        if (!Objects.equals(this.potenciaCV, other.potenciaCV))
        {
            return false;
        }
        if (!Objects.equals(this.cilindradas, other.cilindradas))
        {
            return false;
        }
        if (!Objects.equals(this.numeroEixos, other.numeroEixos))
        {
            return false;
        }
        if (!Objects.equals(this.numeroMarchas, other.numeroMarchas))
        {
            return false;
        }
        if (this.vendido != other.vendido)
        {
            return false;
        }
        if (!Objects.equals(this.cor, other.cor))
        {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca))
        {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo))
        {
            return false;
        }
        return true;
    }
    
    
//</editor-fold>
   
    //<editor-fold defaultstate="collapsed" desc="Gets and Sets">
    public Cor getCor() 
    {
        return cor;
    }
    public void setCor(Cor cor) 
    {
        this.cor = cor;
    }
    public Marca getMarca() {
        return marca;
    }
    
    public void setMarca(Marca marca) 
    {
        this.marca = marca;
    }
    public Modelo getModelo()
    {
        return modelo;
    }
    
    public void setModelo(Modelo modelo) 
    {
        this.modelo = modelo;
    }
    public String getPlaca() 
    {
        return placa;
    }
    
    public void setPlaca(String placa) 
    {
        this.placa = placa;
    }
    
    public String getChassi() 
    {
        return chassi;
    }
    
    public void setChassi(String chassi) 
    {
        this.chassi = chassi;
    }

    public Integer getAnoFabricacao() 
    {
        return anoFabricacao;
    }
    
    public void setAnoFabricacao(Integer anoFabricacao) 
    {
        this.anoFabricacao = anoFabricacao;
    }
    
    public Integer getQuilometragem() 
    {
        return quilometragem;
    }
    
    public void setQuilometragem(Integer quilometragem) 
    {
        this.quilometragem = quilometragem;
    }
    
    public BigDecimal getValorVeiculo() 
    {
        return valorVeiculo;
    }
    
    public void setValorVeiculo(BigDecimal valorVeiculo) 
    {
        this.valorVeiculo = valorVeiculo;
    }
    
    public Integer getPotenciaCV()
    {
        return potenciaCV;
    }
    
    public void setPotenciaCV(Integer potenciaCV)
    {
        this.potenciaCV = potenciaCV;
    }
    
    public String getCilindradas() 
    {
        return cilindradas;
    }
    
    public void setCilindradas(String cilindradas) 
    {
        this.cilindradas = cilindradas;
    }
    
    public Integer getNumeroEixos() 
    {
        return numeroEixos;
    }
    
    public void setNumeroEixos(Integer numeroEixos) 
    {
        this.numeroEixos = numeroEixos;
    }
    
    public Integer getNumeroMarchas() 
    {
        return numeroMarchas;
    }
    
    public void setNumeroMarchas(Integer numeroMarchas) 
    {
        this.numeroMarchas = numeroMarchas;
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
    
//</editor-fold>
}
