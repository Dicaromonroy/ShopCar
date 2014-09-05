/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.view;

import javax.inject.Inject;
import shopcar.model.Veiculo;
import shopcar.repository.JpaDAO;

/**
 *
 * @author info1
 */
public class CadastroVeiculo
{
    @Inject private JpaDAO<Veiculo> daoCadastro;
    
    public void saveVeiculo()
    {
        System.out.println("         *** ShopCar ***");
        System.out.println("-------------------------------");
        System.out.println(" **Cadastro de um novo Veiculo**");
        System.out.println("");
        System.out.println("Tipo de Veiculo(l[ENTER] para listar todos) : ");
    }
    
    
    
}
