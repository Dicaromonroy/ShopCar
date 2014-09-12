/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.view;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import shopcar.model.Veiculo;
import shopcar.repository.JpaDAO;

/**
 *
 * @author Aluno
 */
@ApplicationScoped
public class Listagem
{
   @Inject private JpaDAO<Veiculo> dao;
    
    public void teste()
    {
        try 
        {
            Veiculo v;
            v = dao.getById("ABC-1234");
        } 
        catch (Exception e) 
        {
            System.out.println(e.getClass());
            System.out.println(e.getLocalizedMessage());
            for(StackTraceElement s : e.getStackTrace()) System.out.println(s);
            for(Throwable t : e.getSuppressed()) System.out.println(t);
        }
        
        
    }
}
