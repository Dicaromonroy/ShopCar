/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.repository;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import shopcar.util.MyDatabase;
import shopcar.util.Transacional;


/**
 *
 * @author info1
 * @param <T> The type T 
 */
public class JpaDAO<T> implements DAO<T>, Serializable
{
	/* Here I inject the EntityManager, and get a new instance from EMFactory Producer method */
    @Inject @MyDatabase private EntityManager em;
	/* The class to be persist */
    private final Class<T> classe;
    
	/* Builder */
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
    @Transacional
    public void save(T entity)
    {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
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
    public T getById(Object pk)
    {
        return em.find(this.classe, pk);
    }

    @Override
    public List<T> getAll()
    {
        List<T> resultList = (List<T>) em.createQuery("select e from " + classe.getSimpleName() + " e").getResultList();
        return resultList;
    }

    @Override
    public T getByRestriction(String attribute, String filter)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
