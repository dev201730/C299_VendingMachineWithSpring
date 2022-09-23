/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ui;

import com.example.dto.Merch;
import com.example.service.DataValidationException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;


public class View {

    private UserIO io;
    BigDecimal money = new BigDecimal("0");

    public View(UserIO io) {
        this.io = io;
    }

    public void displayAllMerch(List<Merch> merchList) {
        for (Merch currentMerch : merchList) {
            io.print(currentMerch.getMerchId() + ": "
                    + currentMerch.getMerchName() + " - "
                    + "$" + currentMerch.getMerchPrice());
        }
    }

    public BigDecimal getMoney() throws NumberFormatException {
        io.print("Please deposit a non-zero, non-negative amount of money (as $0.00):");
        String moneyInserted = io.readString("$ ");
        BigDecimal zero = new BigDecimal("0");
        boolean isNotValid = true;
        while (isNotValid) {
            try {
                money = new BigDecimal(moneyInserted).setScale(2, RoundingMode.HALF_UP);
                if ((money.compareTo(zero)) > 0) {
                    isNotValid = false;
                }
            } catch (NumberFormatException e) {
                displayErrorMessage("error");
                io.print("Please deposit a non-zero, non-negative amount of money (as $0.00):");
                moneyInserted = io.readString("$ ");
            }

        }
        return money;
    }

    public void displayExitMessage() {
        io.print("Thanks for playing");
    }

    public void displayErrorMessage(String message) {
        io.print(message);
    }

    public String getResponse() {
        return io.readString("Enter '0' to exit, or press ENTER to continue...");
    }

    public String getMerchSelection() {
        return io.readString("Enter your selection (A-F, or whichever letter corresponds to available, in-stock merchandise): ");
    }

    public void displayNotEnoughCash(String name, BigDecimal price, BigDecimal money) {
        io.print(name.trim() + " cost $" + price + ", but you only have $" + money + ".");
    }

    public void displayThankYouNoChange(String name) {
        io.print("You have no change coming, so enjoy your " + name.trim() + ". Good-bye.");
    }

    public void displayChange(String coins) {
        io.print(coins);
    }

    public void displayChangeNotEnoughMoney(String coins) {
        io.print(coins);
        io.print("Maybe bring more ca$h with you next time...");
    }

    public void displayOutOfStock(String name) {
        io.print(name + "are out of stock...");
    }

    public void displayPurchaseAndChange(String coins, String name) {
        io.print(coins);
        io.print("Enjoy your " + name.trim() + ". Good-bye.");
    }
}
