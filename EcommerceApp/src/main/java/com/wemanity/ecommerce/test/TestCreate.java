package com.wemanity.ecommerce.test;

import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wemanity.ecommerce.entites.Brand;
import com.wemanity.ecommerce.entites.Category;
import com.wemanity.ecommerce.entites.Customer;
import com.wemanity.ecommerce.entites.Item;
import com.wemanity.ecommerce.entites.OrderCustomer;
import com.wemanity.ecommerce.entites.OrderItem;
import com.wemanity.ecommerce.metier.IECommerceMetier;

public class TestCreate {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
		IECommerceMetier metier = (IECommerceMetier) context.getBean("metier");
		
		metier.addCategory(new Category("Vêtements"));
		metier.addCategory(new Category("Chaussures"));
		metier.addCategory(new Category("Accessoires"));
		
		metier.addCustomer(new Customer("Jean Petit", "Rue grande 25, 1000 Bruxelles", "+32489523560"));
		metier.addCustomer(new Customer("Marie Dupont", "Rue Henri 10, 5500 Dinant", "+32477359612"));
		metier.addCustomer(new Customer("Manon Jacob", "Avenue Louise 10, 1000 Bruxelles", "+32488235475"));
		metier.addCustomer(new Customer("Sofie Marso", "Rue Henri 10, 75114 Paris", "+336895897500"));
		
		metier.addBrand(new Brand("Zara"));
		metier.addBrand(new Brand("New Look"));
		metier.addBrand(new Brand("H&M"));
		
		metier.addItem(new Item("Pull Laine", 44.99), 1L, 2L);
		metier.addItem(new Item("Patalon slim", 25), 1L, 1L);
		metier.addItem(new Item("Chemisier", 17.45), 1L, 3L);
		metier.addItem(new Item("Escarpin rouge", 30), 2L, 2L);
		metier.addItem(new Item("Talon aiguille", 25), 2L, 2L);
		metier.addItem(new Item("Bottine Marron", 35.49), 2L, 3L);
		metier.addItem(new Item("Sandale été", 14.99), 2L, 3L);
		metier.addItem(new Item("Ballerine", 15), 2L, 1L);
		metier.addItem(new Item("Mocassin", 24.45), 2L, 1L);
		
		metier.addOrderCustomer(new OrderCustomer(new Date(), false), 1L);
		metier.addOrderCustomer(new OrderCustomer((new GregorianCalendar(2017, 11, 10)).getTime(), true), 2L);
		metier.addOrderCustomer(new OrderCustomer(new Date(), false), 3L);
		metier.addOrderCustomer(new OrderCustomer((new GregorianCalendar(2017, 07, 15)).getTime(), true), 2L);
		metier.addOrderCustomer(new OrderCustomer((new GregorianCalendar(2017, 10, 17)).getTime(), true), 4L);
		
		metier.addOrderItem(new OrderItem(2, 25), 1L, 2L);
		metier.addOrderItem(new OrderItem(1, 29), 1L, 4L);
		metier.addOrderItem(new OrderItem(3, 20), 1L, 9L);
		metier.addOrderItem(new OrderItem(2, 35.49), 2L, 6L);
		metier.addOrderItem(new OrderItem(3, 25), 2L, 5L);
		metier.addOrderItem(new OrderItem(2, 15), 3L, 3L);
		metier.addOrderItem(new OrderItem(1, 44.99), 4L, 1L);
		metier.addOrderItem(new OrderItem(1, 15), 4L, 8L);
		metier.addOrderItem(new OrderItem(2, 17.45), 5L, 3L);
		metier.addOrderItem(new OrderItem(1, 14.99), 5L, 7L);
		metier.addOrderItem(new OrderItem(1, 30), 5L, 4L);

	}

}
