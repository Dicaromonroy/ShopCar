package shopcar.util;

import java.io.Serializable;
import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import shopcar.qualifiers.MyDatabase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Interceptor
@Transacional
public class TransacionalInterceptor 
{
    
    @Inject @MyDatabase
    private EntityManager manager;
    
    @Inject private ThreadLocal<EntityManager> threadLocal;
    
    Logger logger = LoggerFactory.getLogger(TransacionalInterceptor.class);

    @AroundInvoke
    public Object invoke(InvocationContext context) throws Exception 
    {
        manager = threadLocal.get();
        //EntityTransaction trx = manager.getTransaction();
        if(!manager.getTransaction().isActive())
        {
            manager.getTransaction().begin();
            System.out.println("Starting transaction");
            Object result = context.proceed();
            manager.getTransaction().commit();
            System.out.println("Committing transaction");
            return result;
        }
        return null;
//        boolean criador = false;
//        
//        try
//        {
//            if (!trx.isActive()) 
//            {
//                // truque para fazer rollback no que já passou
//                // (senão, um futuro commit confirmaria até mesmo operações sem transação)
//                trx.begin();
//                trx.rollback();
//
//                // agora sim inicia a transação
//                trx.begin();
//
//                criador = true;
//            }
//
//            return context.proceed();
//        } 
//        catch (Exception e) 
//        {
//            if (trx != null && criador) 
//            {
//                trx.rollback();
//            }
//
//            throw e;
//        } 
//        finally 
//        {
//            if (trx != null && trx.isActive() && criador) 
//            {
//                trx.commit();
//            }
//        }
    }
}