/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.util;

import java.util.ArrayList;
import java.util.Scanner;
import javax.enterprise.inject.Produces;

/**
 *
 * @author info1
 */
public class UtilFactory
{
    @Produces
    public static Scanner createScaner()
    {
        return new Scanner(System.in);
    }
    
    @Produces
    public ArrayList<String> createArrayString()
    {
        return new ArrayList<>();
    }
    
    @Produces
    public StringBuilder createStringBuilder()
    {
        return new StringBuilder();
    }
}
