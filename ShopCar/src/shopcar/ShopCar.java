/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar;

import javax.inject.Inject;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import shopcar.view.Principal;

/**
 *
 * @author Vitor Freitas
 */
public class ShopCar
{
    @Inject private Principal newShopCar;

    public void execute()
    {
        this.newShopCar.MenuPrincipal();
    }
    
    public static void main(String args[])
    {
        Weld weld = new Weld(); 
        WeldContainer container = weld.initialize(); 

        ShopCar sc = container.instance().select(ShopCar.class).get(); 
        sc.execute();
        weld.shutdown();
    }
}
