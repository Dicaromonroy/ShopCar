/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.view;

import java.lang.reflect.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import shopcar.controller.Validator;
import shopcar.model.*;
import shopcar.repository.JpaDAO;
import shopcar.util.*;

/**
 *
 * @author info1
 */
public class CadastroVeiculo
{
    @Inject private JpaDAO<Veiculo> daoCadastro;
    @Inject private Map<String,Veiculo> veiculoMap;

    @Inject private Scanner sCad;
    @Inject @MyArrayList private List<String> tipoVeiculos;
    @Inject private Validator<Veiculo> validaVeiculo;
    
    
    public CadastroVeiculo() { }
    
    public void load()
    {
        tipoVeiculos.add("Carro");
        tipoVeiculos.add("Moto");
        tipoVeiculos.add("Onibus");
        tipoVeiculos.add("Caminhao");
        tipoVeiculos.add("Caminhonete");
    }
    
    public void saveVeiculo()
    {
        Veiculo veiculo;
        System.out.println("         *** ShopCar ***");
        System.out.println("-------------------------------");
        System.out.println(" **Cadastro de um novo Veiculo**");
        System.out.println("");
        load();
        veiculo = testIfNeedToListVeiculos();
        if(veiculo == null) 
        {
            System.err.println("Não existe esse Tipo de Veiculo!");
            testIfNeedToListVeiculos();
        }
        
        try
        {
            inputMaker(veiculo, "Entre com a Placa do Veiculo: ", "Placa", String.class, 2); 
            System.out.println("-------------------------------");
            inputMaker(veiculo, "Entre com o Número de Chassi do Veiculo: ", "Chassi", String.class, 2);
            System.out.println("-------------------------------");
            inputMaker(veiculo, "Entre com a Quilometragem do Veiculo: ", "NumAssentos", Integer.class, 1);
            
            daoCadastro.save(veiculo);
            System.out.println("@@@Salvo");
        } 
        catch(Exception ex)
        {
            System.err.println(ex.getCause());
            System.err.println(ex.getMessage());
            System.err.println(ex.getLocalizedMessage());
            System.err.println("To no save");
        }
    }

    public void inputMaker(Veiculo obj, String question, String property, 
            Class propertyClass, Integer methodInheritanceHierarchy) throws  
            IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        String err;
        System.out.println(question);
        String test = sCad.nextLine();
        Class clazz = obj.getClass();
        for(int i = 1; i <= methodInheritanceHierarchy; i++) 
            clazz = clazz.getSuperclass();
        try
        {
            Method method = clazz.getMethod("set" + property, propertyClass);
            method.invoke(obj, new Object[] {test});
        } 
        catch (NoSuchMethodException e)
        {
            System.err.println(e.getMessage());
        }
        
        if(!testSaveInput(obj, property.toLowerCase())) 
            inputMaker(obj, question, property, propertyClass, methodInheritanceHierarchy);
    }
    
    public boolean testSaveInput(Veiculo obj, String property)
    {
        String err = validaVeiculo.Validate(obj , property);
        if(err != null) 
        {
            System.err.println(err);
            return false;
        }
        else
            return true;
    }
    
    public Veiculo testIfNeedToListVeiculos()
    {
        System.out.println("Entre com o Tipo de Veiculo(-l[ENTER] para listar todos) : ");
        String test = sCad.nextLine();
        if(test.equalsIgnoreCase("-l"))
        {
            System.out.println("-------------------------------");
            for(String s : tipoVeiculos)
                System.out.println(s);
            System.out.println("-------------------------------");
            return testIfNeedToListVeiculos();
        }
        else
        {
            for(String s : tipoVeiculos)
            {
                if(test.equalsIgnoreCase(s))
                {System.out.println("Estou aqui!" + test);
                    try
                    {
                        Object c = Class.forName("shopcar.model." + s)
                                .newInstance();
                        return (Veiculo) c;
                    } 
                    catch (Exception e)
                    {
                        System.err.println(e.getMessage());
                    }
                }  
            }
        }
        return null;
    }
    
}
