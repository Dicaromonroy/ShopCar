/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.repository;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author info1
 * @param <T>
 */
public class JpaDAO<T> implements DAO<T>, Serializable
{
    private EntityManager em;
    private final Class<T> classe;
    
    public JpaDAO(Class<T> classe, EntityManager em)
    {
        this.classe = classe;
        this.em = em;
    }
    
    public Class<T> getClasse()
    {
        return this.classe;
    }
    
    public EntityManager getEntityManager()
    {
        return this.em;
    }
    
    @Override
    public void save(T entity)
    {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        System.out.println("Cheguei aqui!");
        if(!em.isOpen()) System.out.println("Ta fechado!");
    }

    @Override
    public void update(T entity)
    {
        
    }

    @Override
    public void remove(T entity)
    {
        //em.remove(entity);
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public T getById(Class<T> classe, Long pk)
    {
        //return em.find(classe, pk);
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<T> getAll(Class<T> classe)
    {
        //List<T> resultList = (List<T>) em.createQuery("select e from " + classe.getSimpleName() + " e").getResultList();
        //return resultList;
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public T getByRestriction(Class<T> classe, String attribute, String filter)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
