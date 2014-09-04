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
 */
public interface DAO<T>
{
    public void save(T entity);
    
    public void update(T entity);
    
    public void remove(T entity);
    
    public T getById(Object pk);
    
    public List<T> getAll();
    
    public T getByRestriction(String attribute, String filter);
}
