/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.model;

import javax.persistence.EntityManager;
import shopcar.repository.JpaDAO;

/**
 *
 * @author info1
 */
public class VeiculoDAO extends JpaDAO<Veiculo>
{

    public VeiculoDAO(Class<Veiculo> classe, EntityManager em)
    {
        super(classe, em);
    }
    
    
    
}
