/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import org.jboss.weld.environment.se.events.ContainerInitialized;
import shopcar.view.Principal;


/**
 *
 * @author Vitor Freitas
 */
public class ShopCar
{
    @Inject private Principal newShopCar;
    public void execute(@Observes ContainerInitialized init)
    {
        this.newShopCar.MenuPrincipal();
    }
}
