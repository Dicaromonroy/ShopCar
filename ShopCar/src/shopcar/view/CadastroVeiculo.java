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
import shopcar.util.*;

/**
 *
 * @author info1
 */
public class CadastroVeiculo
{
    @Inject private JpaDAO<Veiculo> daoCadastro;
    @Inject private Map<Veiculo, String> veiculosMap;
    @Inject private Scanner sCad;
    @Inject @VeiculosType(VeiculoTypes.MOTO) private Veiculo moto;
    @Inject @VeiculosType(VeiculoTypes.CARRO) private Veiculo carro;
    @Inject @VeiculosType(VeiculoTypes.ONIBUS) private Veiculo onibus;
    @Inject @VeiculosType(VeiculoTypes.CAMINHAO) private Veiculo caminhao;
    @Inject @VeiculosType(VeiculoTypes.CAMINHONETE) private Veiculo caminhonete;
    @Inject @MyArrayList private List<String> tipoVeiculos;
    @Inject private Validator<Veiculo> validaVeiculo;
    
    public CadastroVeiculo() { }
    
    public void load()
    {
        veiculosMap.put(moto,"Moto");
        veiculosMap.put(carro,"Carro");
        veiculosMap.put(onibus, "Onibus");
        veiculosMap.put(caminhao,"Caminhao" );
        veiculosMap.put(caminhonete, "Caminhonete");
    }
    
    public void saveVeiculo()
    {
        System.out.println("         *** ShopCar ***");
        System.out.println("-------------------------------");
        System.out.println(" **Cadastro de um novo Veiculo**");
        System.out.println("");
        load();
        testIfNeedToListVeiculos();
        
        try
        {
            inputMaker(moto, "Entre com a Placa do Veiculo: ", "Placa");  
        } 
        catch(Throwable ex)
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
        String test = sCad.nextLine();
        Method method = obj.getClass().getSuperclass().getDeclaredMethod("set" + property, String.class);
        method.invoke(obj, test);
        if(!testSaveInput(obj, property.toLowerCase())) inputMaker(obj, string, property);
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
    
//    public void inputPlaca()
//    {
//        System.out.println("Entre com a Placa do Veiculo: ");
//        //String test = testIfNeedToListVeiculos();
//        //if(test == null) inputPlaca();
//        moto.setPlaca(sCad.nextLine());// substituir sCad.nextLine() por test
//        if(!testSaveInput(moto, "placa")) inputPlaca();
//    }
    
    
    public Veiculo testIfNeedToListVeiculos()
    {
        System.out.println("Entre com o Tipo de Veiculo(-l[ENTER] para listar todos) : ");
        String test = sCad.nextLine();
        if(test.equalsIgnoreCase("-l"))
        {
            System.out.println("-------------------------------");
            for(String s : veiculosMap.values())
            {
                System.out.print(s);
            }
            System.out.println("-------------------------------");
            testIfNeedToListVeiculos();
        }
        return null;
    }
    
}
