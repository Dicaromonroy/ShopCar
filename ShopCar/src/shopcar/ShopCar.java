/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.jboss.weld.environment.se.events.ContainerInitialized;
import shopcar.view.Listagem;
import shopcar.view.Principal;

/**
 *
 * @author Vitor Freitas
 */
public class ShopCar
{
    @Inject private Principal newShopCar;
//    public void execute(@Observes ContainerInitialized init)
//    {
//        Listagem l = new Listagem();
//        l.teste();
//        //this.newShopCar.teste();
//    }
    public void teste()
    {
        //Listagem l = new Listagem();
        //l.teste();
        this.newShopCar.teste();
    }
    
    public static void main(String args[])
    {
        Weld weld = new Weld(); 
        WeldContainer container = weld.initialize(); 

        ShopCar bs = container.instance().select(ShopCar.class).get(); 
        bs.teste(); 
        weld.shutdown();
    }
}
