/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.model;

import javax.persistence.Entity;

/**
 *
 * @author Aluno
 */
@Entity
public class VeiculoPassageiro extends Veiculo
{
    private Integer numAssentos;
}
