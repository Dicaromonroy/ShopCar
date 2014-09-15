/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.view;

import java.lang.reflect.*;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
    @Inject @MyArrayList private List<Modelo> modelos;
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
        
        try
        {
            inputMaker(veiculo, "Entre com a Placa do Veiculo: ", "Placa", "placa" , String.class, 2); 
            System.out.println("-------------------------------");
            inputMaker(veiculo, "Entre com o Número de Chassi do Veiculo: ", "Chassi", "chassi" , String.class, 2);
            System.out.println("-------------------------------");
            inputMaker(veiculo, "Entre com a Quilometragem do Veiculo: ", "Quilometragem" , "quilometragem" ,Integer.class, 2);
            System.out.println("-------------------------------");
            inputMaker(veiculo, "Entre com a Potência em CV do Veiculo: ", "PotenciaCV" , "potenciaCV" ,Integer.class, 2);
            System.out.println("-------------------------------");
            inputMaker(veiculo, "Entre com a Cilindradas do Veiculo: ", "Cilindradas" , "cilindradas" ,Integer.class, 2);
            System.out.println("-------------------------------");
            inputMaker(veiculo, "Entre com a Número de Eixos do Veiculo: ", "NumeroEixos" , "numeroEixos" ,Integer.class, 2);
            System.out.println("-------------------------------");
            inputMaker(veiculo, "Entre com a Número de Marchas do Veiculo: ", "NumeroMarchas" , "numeroMarchas" ,Integer.class, 2);
            System.out.println("-------------------------------");
            inputMaker(veiculo, "Entre com a Data de Fabricação do Veiculo: ", "AnoFabricacao" , "anoFabricacao" ,Date.class, 2);
//            System.out.println("-------------------------------");
//            inputMaker(veiculo, "Entre com a Número de Marchas do Veiculo: ", "NumeroMarchas" , "numeroMarchas" ,Integer.class, 2);
//            System.out.println("-------------------------------");
//            inputMaker(veiculo, "Entre com a Número de Marchas do Veiculo: ", "NumeroMarchas" , "numeroMarchas" ,Integer.class, 2);
//            System.out.println("-------------------------------");
//            inputMaker(veiculo, "Entre com a Número de Marchas do Veiculo: ", "NumeroMarchas" , "numeroMarchas" ,Integer.class, 2);
            
            daoCadastro.save(veiculo);
            System.out.println("@@@Salvo");
        } 
        catch(Exception ex)
        {
            System.err.println(ex.getCause());
            System.err.println(ex.getMessage());
            for(StackTraceElement s : ex.getStackTrace()) System.err.println(s);
            System.err.println("To no save");
        }
    }

    public void inputMaker(Veiculo obj, String question, String methodName, 
            String porpertyName ,Class propertyClass, Integer methodInheritanceHierarchy) throws  
            IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        String err;
        System.out.println(question);
        Object b = null;
        if(propertyClass.equals(Integer.class)) 
            b = sCad.nextInt();
        else if(propertyClass.equals(String.class)) 
            b = sCad.nextLine();
        else if(propertyClass.equals(BigDecimal.class)) 
            b = sCad.nextBigDecimal();
        else if(propertyClass.equals(Date.class)) 
        {
            String test = sCad.nextLine();
            b = convertStringToDate(test);
        }
            
            
        Class clazz = obj.getClass();
        for(int i = 1; i <= methodInheritanceHierarchy; i++) 
            clazz = clazz.getSuperclass();
        try
        {
            Method method = clazz.getMethod("set" + methodName, propertyClass);
            method.invoke(obj, b);
        } 
        catch (NoSuchMethodException e)
        {
            System.out.println("deu erro");
            System.err.println(e.getMessage());
        }
        
        if(!testSaveInput(obj, porpertyName)) 
            inputMaker(obj, question, methodName, porpertyName, propertyClass, methodInheritanceHierarchy);
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
                {
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
        System.err.println("Não existe esse Tipo de Veiculo!");
        return testIfNeedToListVeiculos();
    }
    
    public Date convertStringToDate(String date) 
    {
        Date d = null;
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd");
            
        }
        catch (ParseException e)
        {
            System.err.println("Não foi possivel converter a Data!");
        }
        return d;
    }
}
