/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.enterprise.event.Observes;
import javax.persistence.*;
import shopcar.controller.VendaMovimento;

/**
 *
 * @author info1
 */
@Entity
public class Venda implements Serializable
{
    private static final Long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    private Cliente cliente;
    @Transient
    private ItemVenda itemVenda;

    //<editor-fold defaultstate="collapsed" desc="Getters e Setters">
    /**
     * @return the id
     */
    public Long getId()
    {
        return id;
    }
    
    /**
     * @param id the id to set
     */
    public void setId(Long id)
    {
        this.id = id;
    }
    
    /**
     * @return the cliente
     */
    public Cliente getCliente()
    {
        return cliente;
    }
    
    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente)
    {
        this.cliente = cliente;
    }
    
    /**
     * @return the itemVenda
     */
    public ItemVenda getItemVenda()
    {
        return itemVenda;
    }
    
    /**
     * @param itemVenda the itemVenda to set
     */
    public void setItemVenda(ItemVenda itemVenda)
    {
        this.itemVenda = itemVenda;
    }

//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="hashCode e equals">
    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.cliente);
        hash = 23 * hash + Objects.hashCode(this.itemVenda);
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
        final Venda other = (Venda) obj;
        if (!Objects.equals(this.id, other.id))
        {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente))
        {
            return false;
        }
        if (!Objects.equals(this.itemVenda, other.itemVenda))
        {
            return false;
        }
        return true;
    }
//</editor-fold>
}
