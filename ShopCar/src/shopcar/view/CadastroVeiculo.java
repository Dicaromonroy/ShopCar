/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.view;

import java.lang.reflect.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
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
    @Inject private JpaDAO<Modelo> daoModelos;
    @Inject private JpaDAO<Cor> daoCores;
    @Inject private JpaDAO<Marca> daoMarcas;
    @Inject private Map<String,Veiculo> veiculoMap;
    @Inject private Scanner sCad;
    @Inject private Util util;
    @Inject @MyArrayList private List<String> tipoVeiculos;
    @Inject @MyArrayList private List<Modelo> modelos;
    @Inject @MyArrayList private List<Cor> cores;
    @Inject @MyArrayList private List<Marca> marcas;
    @Inject private Validator<Veiculo> validaVeiculo;
    
    
    public CadastroVeiculo() { }
    
    public void load()
    {
        try
        {
            modelos = daoModelos.getAll();
            cores = daoCores.getAll();
            marcas = daoMarcas.getAll();
            tipoVeiculos.add("Carro");
            tipoVeiculos.add("Moto");
            tipoVeiculos.add("Onibus");
            tipoVeiculos.add("Caminhao");
            tipoVeiculos.add("Caminhonete");
        } 
        catch (Exception e)
        {
            System.err.println("Houve um erro ao carregar os Modelos, Cores e Marcas!" + e.getMessage());
        }
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
            inputMaker(veiculo, "Entre com a Placa do Veiculo: ", "Placa", "placa" 
                    , String.class, 2); 
            System.out.println("-------------------------------");
            inputMaker(veiculo, "Entre com o Número de Chassi do Veiculo: ", 
                    "Chassi", "chassi" , String.class, 2);
            System.out.println("-------------------------------");
            Marca marca = testNewMarca();
            veiculo.setMarca(marca);
            System.out.println("-------------------------------");
            inputMaker(veiculo, "Entre com a Quilometragem do Veiculo: ", 
                    "Quilometragem" , "quilometragem" ,Integer.class, 2);
            System.out.println("-------------------------------");
            inputMaker(veiculo, "Entre com a Potência em CV do Veiculo: ", 
                    "PotenciaCV" , "potenciaCV" ,Integer.class, 2);
            System.out.println("-------------------------------");
            inputMaker(veiculo, "Entre com a Cilindradas do Veiculo: ", 
                    "Cilindradas" , "cilindradas" ,Integer.class, 2);
            System.out.println("-------------------------------");
            inputMaker(veiculo, "Entre com a Número de Eixos do Veiculo: ", 
                    "NumeroEixos" , "numeroEixos" ,Integer.class, 2);
            System.out.println("-------------------------------");
            inputMaker(veiculo, "Entre com a Número de Marchas do Veiculo: ", 
                    "NumeroMarchas" , "numeroMarchas" ,Integer.class, 2);
             System.out.println("-------------------------------");
            inputMaker(veiculo, "Entre com o Ano de Fabricação do Veiculo: ", 
                    "AnoFabricacao" , "anoFabricacao" ,Integer.class, 2);
            System.out.println("-------------------------------");
            inputMaker(veiculo, "Entre com o Valor de Venda do Veiculo[0.000]: ",
                    "ValorVeiculo" , "valorVeiculo" ,BigDecimal.class, 2);
            System.out.println("-------------------------------");
            inputMaker(veiculo, "Entre com o Número de Assetos no Veiculo se "
                    + "houver[Ônibus,Carro,Moto]: ", "NumAssentos" , "numAssentos" 
                    ,Integer.class, 1);
            System.out.println("-------------------------------");
            inputMaker(veiculo, "Entre com a Capacidade Máxima de Carga do Veiculo "
                    + "se houver[Caminhão, Caminhonete]: ", "CapcMaxCarga" , "capcMaxCarga"
                    ,BigDecimal.class, 1);
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
        Object b = getPropertyClassInput(propertyClass);
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
            return;
        }
        
        if(!testSaveInput(obj, porpertyName)) 
            inputMaker(obj, question, methodName, porpertyName, propertyClass, methodInheritanceHierarchy);
    }
    
    public Object getPropertyClassInput(Class propertyClass)
    {
        Object obj = null;
        if(propertyClass.equals(Integer.class)) 
        {

        }
            
        else if(propertyClass.equals(String.class)) 
            obj = sCad.nextLine();
        else if(propertyClass.equals(BigDecimal.class)) 
            obj = sCad.nextBigDecimal(); 
        
        return obj;
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
    
    public Modelo testNewModelo()
    {
       System.out.println("Entre com o nome do Modelo(-l[ENTER] para listar os modelos cadastrados) : ");
        String test = sCad.nextLine();
        if(test.equalsIgnoreCase("-l"))
        {
            System.out.println("-------------------------------");
            for(Modelo m : modelos)
                System.out.println(m.getModelo());
            System.out.println("-------------------------------");
            return testNewModelo();
        }
        else
        {
            for(Modelo m : modelos) 
            {
                if(test.equals(m.getModelo())) return m;
            }
            return new Modelo();
        }
    }
    
    public Marca testNewMarca()
    {
        System.out.println("Entre com o nome da Marca(-l[ENTER] para listar as Marcas cadastradas) : ");
        String test = sCad.nextLine();
        if(test.equalsIgnoreCase("-l"))
        {
            System.out.println("-------------------------------");
            for(Marca m : marcas)
                System.out.println(m.getMarca());
            System.out.println("-------------------------------");
            return testNewMarca();
        }
        else
        {
            for(Marca m : marcas) 
            {
                if(test.equalsIgnoreCase(m.getMarca())) return m;
            }
            
            System.out.println("Deseja Cadastrar a Marca: " + test + " ?[s/n]");
            if(sCad.nextLine().equalsIgnoreCase("s")) 
            {
                try
                {
                    Marca marca = new Marca();
                    marca.setMarca(test);
                    daoMarcas.save(marca);
                    System.out.println("Marca incluida!");
                    return marca;
                } 
                catch (Exception e)
                {
                    System.err.println("Houve um erro ao inserir a marca! " + e.getMessage());
                    testNewMarca();
                }
            }
        }
        return null;
    }
}
