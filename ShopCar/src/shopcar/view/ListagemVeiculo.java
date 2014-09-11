/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.view;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import shopcar.model.*;
import shopcar.repository.JpaDAO;

/**
 *
 * @author Aluno
 */
public class ListagemVeiculo
{
    @Inject private JpaDAO<Veiculo> daoListagem;
    private String idVeiculo;
    
    public ListagemVeiculo(String id)
    {
        this.idVeiculo = id;
    }
    
    public void Teste()
    {
        System.out.println(idVeiculo);
        System.out.println(daoListagem.getClasse());
        //System.out.println(daoListagem.getEntityManager().isOpen());
        //try {
            //this.daoListagem.getById(this.idVeiculo);
           // System.out.println(this.idVeiculo);
        //} 
        //catch (Exception e) {
//            System.err.println(e.getMessage());
//            System.err.println(e.getLocalizedMessage());
//            System.err.println(e.getCause());
//            for(StackTraceElement e2 : e.getStackTrace()) System.err.println(e2);
        //}
        
    }
}
