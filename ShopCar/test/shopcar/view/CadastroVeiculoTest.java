/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.view;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import shopcar.model.Veiculo;

/**
 *
 * @author info1
 */
public class CadastroVeiculoTest
{
    
    public CadastroVeiculoTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of saveVeiculo method, of class CadastroVeiculo.
     */
    @Test
    public void testSaveVeiculo()
    {
        System.out.println("saveVeiculo");
        CadastroVeiculo instance = new CadastroVeiculo();
        instance.saveVeiculo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inputMaker method, of class CadastroVeiculo.
     */
    @Test
    public void testInputMaker() throws Exception
    {
        System.out.println("inputMaker");
        Veiculo obj = null;
        String string = "Entra ai com a placa";
        String property = "Placa";
        CadastroVeiculo instance = new CadastroVeiculo();
        instance.inputMaker(obj, string, property);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of testSaveInput method, of class CadastroVeiculo.
     */
    @Test
    public void testTestSaveInput()
    {
        System.out.println("testSaveInput");
        Veiculo obj = null;
        String property = "";
        CadastroVeiculo instance = new CadastroVeiculo();
        boolean expResult = false;
        boolean result = instance.testSaveInput(obj, property);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of testIfNeedToListVeiculos method, of class CadastroVeiculo.
     */
    @Test
    public void testTestIfNeedToListVeiculos()
    {
        System.out.println("testIfNeedToListVeiculos");
        CadastroVeiculo instance = new CadastroVeiculo();
        String expResult = "";
        String result = instance.testIfNeedToListVeiculos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
