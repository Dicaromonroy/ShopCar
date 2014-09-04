/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.repository;

import java.lang.reflect.ParameterizedType;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import shopcar.util.MyDatabase;



/**
 *
 * @author info1
 * @param <T>
 */
public class DAOFactory<T>
{
    @Inject @MyDatabase private EntityManager em;
    
    @SuppressWarnings({ "rawtypes", "unchecked" })    
    @Produces
    public JpaDAO<T> createJpaDAO(InjectionPoint injectionPoint) throws ClassNotFoundException 
    {    
        ParameterizedType type = (ParameterizedType) injectionPoint.getType();    
        Class classe = (Class) type.getActualTypeArguments()[0];   
        if(em.isOpen()) System.out.println("Continua Aberta!!! - entitymanager daofactory");
        return new JpaDAO<>(classe,em);    
    }    
}