/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.view;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.inject.Inject;
import javax.persistence.RollbackException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import shopcar.controller.Validator;
import shopcar.model.*;
import shopcar.repository.JpaDAO;
import shopcar.util.MyArrayList;
import shopcar.util.MyTuple;

/**
 *
 * @author info1
 */
public class CadastroVeiculo
{
    @Inject private JpaDAO<Veiculo> daoCadastro;
    @Inject private Map<Integer,MyTuple<String, Veiculo>> veiculosMap;
    @Inject private Scanner sCad;
    @Inject private Moto moto;
    @Inject @MyArrayList private List<String> tipoVeiculos;
    @Inject private Validator<Veiculo> validaVeiculo;
    
    public CadastroVeiculo() { }
    
    public void saveVeiculo()
    {
        System.out.println("         *** ShopCar ***");
        System.out.println("-------------------------------");
        System.out.println(" **Cadastro de um novo Veiculo**");
        System.out.println("");
        System.out.println("Entre com o Tipo de Veiculo(-l[ENTER] para listar todos) : ");
        System.out.println("-------------------------------");
        testIfNeedToListVeiculos();
        
        try
        {
            System.out.println("Entre com a placa do Veiculo: ");
            moto.setPlaca(sCad.nextLine());
            moto.setModelo("aaaa");
            moto.setNomealgo("sasad");
            daoCadastro.save(moto);
        } 
        catch(Exception ex)
        {
            if(ex.getCause() instanceof ConstraintViolationException)
            {
                System.out.println(validaVeiculo.Validate(moto));
            }
        }
    }
    
    public String testIfNeedToListVeiculos()
    {
        StringBuilder sb = new StringBuilder();
        String test = sCad.nextLine();
        if(test.equalsIgnoreCase("-l"))
        {
            tipoVeiculos = daoCadastro.getEntityManager().createNamedQuery("Veiculo.listAllVeiculosTypes", String.class)
                    .getResultList();
            for(String s : tipoVeiculos)
                sb.append(s).append("\t");
            return sb.toString();
        }
        else
        {
            for(String s : tipoVeiculos)
            {
                if(s.equalsIgnoreCase(test))
                {
                    System.out.println("Deseja incluir um novo Tipo de Veiculo?[s/n]");
                    if(!sCad.nextLine().equalsIgnoreCase("s"))
                    {
                        System.out.println("Entre com o Tipo de Veiculo(-l[ENTER] para listar todos) : ");
                        testIfNeedToListVeiculos();
                    }
                }
            }
            return test;
        }  
    }
    
}
