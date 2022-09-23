package com.example.vendingmachinewithspring;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.controller.Controller;
import com.example.dao.PersistenceException;
import com.example.service.DataValidationException;
import com.example.service.NoMerchInventoryException;
import com.example.service.NoSuchMerchException;
import com.example.service.NotEnoughMoneyException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class VendingmachinewithspringApplication {

	public static void main(String[] args) throws PersistenceException, NoMerchInventoryException, DataValidationException, NoSuchMerchException, NotEnoughMoneyException {
		//SpringApplication.run(VendingmachinewithspringApplication.class, args);
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Controller controller = ctx.getBean("controller", Controller.class);
        controller.run();
	}

}
