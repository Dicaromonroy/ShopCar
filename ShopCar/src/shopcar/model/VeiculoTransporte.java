/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package veiculo;

import java.math.BigDecimal;
import javax.persistence.Entity;

/**
 *
 * @author Aluno
 */
@Entity
public class VeiculoTransporte extends Veiculo
{
     private BigDecimal capcMaxCarga;    
}
