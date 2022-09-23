package com.example.service;

import com.example.dao.AuditDao;
import com.example.dao.VendingMachineDao;
import com.example.dao.PersistenceException;
import com.example.dto.Merch;
import java.math.BigDecimal;
import java.util.List;

public class ServiceLayerImpl implements ServiceLayer {

    VendingMachineDao dao;

    public ServiceLayerImpl(VendingMachineDao dao, AuditDao auditDao) {
        this.dao = dao;
    }

    @Override
    public List<Merch> getAllMerch() throws PersistenceException {
        return dao.getAllMerch();
    }

    @Override
    public Merch getMerch(String merchId, BigDecimal money) throws PersistenceException, NoMerchInventoryException, 
    NotEnoughMoneyException, NoSuchMerchException {

        checkInventory(merchId, money);
        return dao.getMerch(merchId);
    }

    @Override
    public Merch getRealMerch(String merchID) throws PersistenceException {
        return dao.getMerch(merchID);
    }

    @Override
    public void updateInventory(Merch purchase) throws PersistenceException {
        dao.updateInventory(purchase);
    }

    @Override
    public String makeChange(int change) throws PersistenceException {
        String coins = dao.makeChange(change);
        return coins;
    }

    @Override
    public List<Merch> getAllMerchForDisplay() throws PersistenceException {
        return dao.getAllMerchForDisplay();
    }

    private void checkInventory(String merchId, BigDecimal money) throws NoMerchInventoryException, PersistenceException,
            NoSuchMerchException, NotEnoughMoneyException {

        if (dao.getMerch(merchId) == null) {
            throw new NoSuchMerchException("\nError: Product does not exit.");
        } else if (dao.getMerch(merchId).getMerchInventory() < 1) {
            throw new NoMerchInventoryException(
                    "\nError: " + dao.getMerch(merchId).getMerchName().trim()+ " are Out of Stock.");
        }

        if ((money.compareTo(dao.getMerch(merchId).getMerchPrice())) < 0) {
            throw new NotEnoughMoneyException(
                    "\nError: " + dao.getMerch(merchId).getMerchName().trim()
                    + " cost $" + dao.getMerch(merchId).getMerchPrice()+ " and you only have $" + money);
        }
    }
}
