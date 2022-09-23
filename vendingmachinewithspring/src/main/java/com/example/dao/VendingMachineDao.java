package com.example.dao;

import com.example.dto.Merch;
import java.util.ArrayList;
import java.util.List;

public interface VendingMachineDao {
    
    List<Merch> getAllMerch() throws PersistenceException;
    
    Merch getMerch(String merchId) throws PersistenceException;
    
    String makeChange(int change) throws PersistenceException;
    
    public void updateInventory(Merch purchase) throws PersistenceException;
    
    List<Merch> getAllMerchForDisplay() throws PersistenceException;
}
