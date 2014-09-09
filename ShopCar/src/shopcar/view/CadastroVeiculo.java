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
import javax.inject.Inject;
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
            //inputMaker(moto, "Entre com a Placa do Veiculo: ", "Placa");
            inputPlaca();
            inputModelo();
            
        } 
        catch(Exception ex)
        {
            System.err.println(ex.getCause());
            System.err.println(ex.getMessage());
            for(StackTraceElement e : ex.getStackTrace()) System.err.println(e);
            System.err.println(ex.getLocalizedMessage());
            for(Throwable t : ex.getSuppressed()) System.err.println(t);
        }
    }

    public void inputMaker(Veiculo obj, String string, String property) throws NoSuchMethodException, IllegalAccessException, 
            IllegalArgumentException, InvocationTargetException
    {
        String err;
        System.out.println(string);
        String test = "sadasdads";
        Method method = obj.getClass().getSuperclass().getMethod("set" + property, Object.class);
        method.invoke(obj, test);
        if(!testSaveInput(obj, property)) inputMaker(obj, string, property);
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
    
    public void inputPlaca()
    {
        System.out.println("Entre com a Placa do Veiculo: ");
        //String test = testIfNeedToListVeiculos();
        //if(test == null) inputPlaca();
        moto.setPlaca(sCad.nextLine());// substituir sCad.nextLine() por test
        if(!testSaveInput(moto, "placa")) inputPlaca();
    }
    
    public void inputModelo()
    {
        System.out.println("Entre com o Modelo do Veiculo: ");
        moto.setModelo(sCad.nextLine());
        if(!testSaveInput(moto, "modelo")) inputModelo();
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
        return null;
    }
    
}
