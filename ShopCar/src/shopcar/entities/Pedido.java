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
public class Pedido implements Serializable
{
    private static final Long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private Long pedidoId;
    
    @ManyToOne
    private Cliente cliente;
    @Transient
    private ItemPedido itemPedido;

    //<editor-fold defaultstate="collapsed" desc="Getters e Setters">
    /**
     * @return the id
     */
    public Long getId()
    {
        return pedidoId;
    }
    
    /**
     * @param id the id to set
     */
    public void setId(Long id)
    {
        this.pedidoId = id;
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
    public ItemPedido getItemVenda()
    {
        return itemPedido;
    }
    
    /**
     * @param itemVenda the itemVenda to set
     */
    public void setItemVenda(ItemPedido itemVenda)
    {
        this.itemPedido = itemVenda;
    }

//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="hashCode e equals">
    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.pedidoId);
        hash = 23 * hash + Objects.hashCode(this.cliente);
        hash = 23 * hash + Objects.hashCode(this.itemPedido);
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
        final Pedido other = (Pedido) obj;
        if (!Objects.equals(this.pedidoId, other.pedidoId))
        {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente))
        {
            return false;
        }
        if (!Objects.equals(this.itemPedido, other.itemPedido))
        {
            return false;
        }
        return true;
    }
//</editor-fold>
}
