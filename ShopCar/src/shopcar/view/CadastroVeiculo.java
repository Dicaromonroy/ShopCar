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
    //@Inject private Map<Veiculo, String> veiculosMap;
    //@Inject private Map<Integer, MyTuple<String,Veiculo>> veiculosMap;
    @Inject private Scanner sCad;
    @Inject @VeiculosType(VeiculoTypes.MOTO) private Veiculo moto;
    @Inject @VeiculosType(VeiculoTypes.CARRO) private Veiculo carro;
//    @Inject @VeiculosType(VeiculoTypes.ONIBUS) private Veiculo onibus;
//    @Inject @VeiculosType(VeiculoTypes.CAMINHAO) private Veiculo caminhao;
//    @Inject @VeiculosType(VeiculoTypes.CAMINHONETE) private Veiculo caminhonete;
    @Inject @MyArrayList private List<String> tipoVeiculos;
    @Inject private Validator<Veiculo> validaVeiculo;
    
    
    public CadastroVeiculo() { }
    
    public void load()
    {
        veiculoMap.put("Moto", new Moto());
        veiculoMap.put("Carro", new Carro());
        veiculoMap.put("Onibus", new Onibus());
        veiculoMap.put("Caminhao", new Caminhao());
        veiculoMap.put("Caminhonete", new Caminhonete());
//        veiculosMap.put(moto,"Moto");
//        veiculosMap.put(carro,"Carro");
//        veiculosMap.put(onibus, "Onibus");
//        veiculosMap.put(caminhao,"Caminhao" );
//        veiculosMap.put(caminhonete, "Caminhonete");
//        veiculosMap.put(1, new MyTuple<>("Carro", carro));
//        veiculosMap.put(2, new MyTuple<>("Moto", moto));
//        veiculosMap.put(3, new MyTuple<>("Onibus", onibus));
//        veiculosMap.put(4, new MyTuple<>("Caminhao", caminhao));
//        veiculosMap.put(5, new MyTuple<>("Caminhonete", caminhonete));
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
            inputMaker(veiculo, "Entre com a Placa do Veiculo: ", "Placa", String.class, 1); 
            System.out.println(veiculo.getPlaca());
        } 
        catch(Exception ex)
        {
            System.err.println(ex.getCause());
            System.err.println(ex.getMessage());
            System.err.println(ex.getLocalizedMessage());
        }
    }

    public void inputMaker(Veiculo obj, String question, String property, 
            Class propertyClass, Integer methodInheritanceHierarchy) throws  
            IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        String err;
        System.out.println(question);
        String test = sCad.nextLine();
        Veiculo clazz = obj;
        System.out.println(clazz.getClass().getSimpleName());
        for(int i = 1; i <= methodInheritanceHierarchy; i++) 
        {
            
        }
        try
        {
            Method method = obj.getClass().getSuperclass().getSuperclass().getDeclaredMethod("set" + property, propertyClass);
            method.invoke(obj, test);
        } 
        catch (NoSuchMethodException e)
        {
            System.err.println(e.getCause());
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
    
    public Object getSuperClass(Object obj)
    {
        return obj.getClass().getSuperclass();
    }
    
    public Veiculo testIfNeedToListVeiculos()
    {
        System.out.println("Entre com o Tipo de Veiculo(-l[ENTER] para listar todos) : ");
        String test = sCad.nextLine();
        if(test.equalsIgnoreCase("-l"))
        {
            System.out.println("-------------------------------");
            for(String s : veiculoMap.keySet())
                System.out.println(s);
            System.out.println("-------------------------------");
            testIfNeedToListVeiculos();
        }
        else
        {
            for(String s : veiculoMap.keySet())
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
                        System.err.println(e.getCause());
                    }
                }
                    
            }
        }
        return null;
    }
    
}
