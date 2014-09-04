/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import javax.enterprise.inject.Produces;

/**
 *
 * @author info1
 * @param <T>
 */
public class UtilFactory<T>
{
    @Produces
    public Set<T> createSet()
    {
        return new HashSet<>();
    }
    
    @Produces
    public static Scanner createScaner()
    {
        return new Scanner(System.in);
    }
    
    @Produces
    public ArrayList<T> createArrayString()
    {
        return new ArrayList<>();
    }
    
    @Produces
    public StringBuilder createStringBuilder()
    {
        return new StringBuilder();
    }
}
