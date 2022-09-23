package com.example.dao;

import com.example.dto.Merch;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class VendingMachineDaoTest {
    
    private VendingMachineDao dao = new VendingMachineDaoFileImpl();
    
    public VendingMachineDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        List<Merch> merchList = (dao.getAllMerch());
    }
    
    @After
    public void tearDown() {
    }

   
    @Test
    public void testGetAllMerch() throws Exception {   
        assertEquals(6, dao.getAllMerch().size());
    }

  
    @Test
    public void testGetMerch() throws Exception {
        assertEquals("Wasabi Oreos", dao.getMerch("A").getMerchName().trim());
    }

   
    @Test
    public void testMakeChange() throws Exception {
        int change = 99;
        assertEquals("3 quarter(s) 2 dime(s) 4 pennies is your change.", dao.makeChange(change));  
    }

 
    @Test
    public void testUpdateInventory() throws Exception {
        int inventory = (dao.getMerch("C")).getMerchInventory();
        Merch testMerch = dao.getMerch("C");
        dao.updateInventory(testMerch);
        assertEquals(inventory-1, (dao.getMerch("C")).getMerchInventory());
    }

  
    @Test
    public void testGetAllMerchForDisplay() throws Exception {
        assertEquals(5, dao.getAllMerchForDisplay().size());
    }

    
    
}
