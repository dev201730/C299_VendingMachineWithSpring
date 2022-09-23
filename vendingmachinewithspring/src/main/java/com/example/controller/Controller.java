package com.example.controller;

import com.example.dao.PersistenceException;
import com.example.dto.Merch;
import com.example.service.DataValidationException;
import com.example.service.NoMerchInventoryException;
import com.example.service.NoSuchMerchException;
import com.example.service.NotEnoughMoneyException;
import com.example.service.ServiceLayer;
import com.example.ui.UserIO;
import com.example.ui.UserIOConsoleImpl;
import com.example.ui.View;
import java.math.BigDecimal;
import java.util.List;


public class Controller {

	View view;

    private ServiceLayer service;

    private UserIO io = new UserIOConsoleImpl();

    public Controller(ServiceLayer service, View view) {
        this.service = service;
        this.view = view;
    }

    public void run() throws PersistenceException, NoMerchInventoryException, DataValidationException, NoSuchMerchException, NotEnoughMoneyException {
        String continueResponse;
        boolean keepGoing = true;
        boolean isFirstTime = true;
        String selection;
        Merch purchase = null;
        BigDecimal money = new BigDecimal("0");
        BigDecimal zero = new BigDecimal("0");
        BigDecimal hundred = new BigDecimal("100");

        listMerch();
        continueResponse = view.getResponse();
        while (keepGoing) {
            if (continueResponse.equals("0")) {
                keepGoing = false;
                view.displayExitMessage();
            }
            if (isFirstTime) {
                money = view.getMoney();
                isFirstTime = false;
            }
            selection = view.getMerchSelection().toUpperCase();
            try {
                purchase = service.getMerch(selection, money);
                service.updateInventory(purchase);
                if (money.compareTo(purchase.getMerchPrice()) == 0) {
                    view.displayThankYouNoChange(purchase.getMerchName().trim());
                    keepGoing = false;
                } else if (money.compareTo(purchase.getMerchPrice()) > 0) {
                    int change = (money.subtract(purchase.getMerchPrice()).multiply(hundred)).intValue();
                    String coins = service.makeChange(change);
                    view.displayPurchaseAndChange(coins, purchase.getMerchName().trim());
                    keepGoing = false;
                }

            } catch (NoSuchMerchException ex) {
                view.displayErrorMessage(ex.getMessage());
            } catch (NotEnoughMoneyException ex) {
                int change = (money.multiply(hundred)).intValue();
                String coins = service.makeChange(change);
                view.displayErrorMessage(ex.getMessage());
                view.displayChange(coins);
                keepGoing = false;
                view.displayExitMessage();
            } catch (NoMerchInventoryException ex) {
                int change = (money.multiply(hundred)).intValue();
                String coins = service.makeChange(change);
                view.displayErrorMessage(ex.getMessage());
                view.displayChange(coins);
                keepGoing = false;
                view.displayExitMessage();
            }

        }
        keepGoing = false;

    }

    public void listMerch() throws PersistenceException {
        List<Merch> merchList = service.getAllMerchForDisplay();
        view.displayAllMerch(merchList);
    }
}
