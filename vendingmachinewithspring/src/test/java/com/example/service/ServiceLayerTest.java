package com.example.service;

import com.example.dao.AuditDao;
import com.example.dao.AuditDaoStubImpl;
import com.example.dao.VendingMachineDao;
import com.example.dao.VendingMachineDaoStubImpl;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ServiceLayerTest {

    private ServiceLayer service;

    public ServiceLayerTest() {
        VendingMachineDao dao = new VendingMachineDaoStubImpl();
        AuditDao auditDao = new AuditDaoStubImpl();
        service = new ServiceLayerImpl(dao, auditDao);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

  
    @Test
    public void testGetAllMerch() throws Exception {
        assertEquals(1, service.getAllMerch().size());
    }

   
    @Test
    public void testGetMerch() throws Exception {
    }

 
    @Test
    public void testMakeChange() throws Exception {
    }

    @Test
    public void testUpdateInventory() throws Exception {
    }

    @Test
    public void testGetAllMerchForDisplay() throws Exception {
    }

    
}
