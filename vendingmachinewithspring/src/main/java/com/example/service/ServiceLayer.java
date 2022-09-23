package com.example.service;

import com.example.dao.PersistenceException;
import com.example.dto.Merch;
import java.math.BigDecimal;
import java.util.List;

public interface ServiceLayer {

    List<Merch> getAllMerch() throws PersistenceException;

    Merch getMerch(String merchId, BigDecimal money) throws
    PersistenceException, NoMerchInventoryException, NotEnoughMoneyException, NoSuchMerchException;

    String makeChange(int change) throws PersistenceException;

    public void updateInventory(Merch purchase) throws PersistenceException;

    List<Merch> getAllMerchForDisplay() throws PersistenceException;

    public Merch getRealMerch(String selection) throws PersistenceException;

}
