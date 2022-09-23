package com.example.dao;

import com.example.dto.Merch;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VendingMachineDaoStubImpl implements VendingMachineDao {
    
    private Merch merch;
    private List<Merch> merchList = new ArrayList<>();
    
    public VendingMachineDaoStubImpl() {
        merch = new Merch("A");
        merch.setMerchName("Cookie");
        merch.setMerchPrice(new BigDecimal("0.50"));
        merch.setMerchInventory(100);
        
        merchList.add(merch);
        
    }
    
    @Override
    public List<Merch> getAllMerch() throws PersistenceException {
        return merchList;
    }
    
    @Override
    public Merch getMerch(String merchId) throws PersistenceException {
        if (merchId.equals(merch.getMerchId())) {
            return merch;
        } else {
            return null;
        }
    }
    
    @Override
    public String makeChange(int change) throws PersistenceException {
        return "Hello";
    }
    
    @Override
    public void updateInventory(Merch purchase) throws PersistenceException {
        merch.setMerchInventory(merch.getMerchInventory() - 1);
    }
    
    @Override
    public List<Merch> getAllMerchForDisplay() throws PersistenceException {
        return merchList;
    }
    
}
