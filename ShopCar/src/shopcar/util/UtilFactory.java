/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import shopcar.view.CadastroVeiculo;

/**
 *
 * @author info1
 * @param <T>
 */
public class UtilFactory<T,I>
{  
    @Produces
    public static Scanner createScaner()
    {
        return new Scanner(System.in);
    }
    
    @Produces
    @MyArrayList
    public ArrayList<T> createArrayString()
    {
        return new ArrayList<>();
    }
    
    @Produces
    public StringBuilder createStringBuilder()
    {
        return new StringBuilder();
    }
    
    @Produces
    public HashMap createHash()
    {
        return new HashMap<>();
    }
}
