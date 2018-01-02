package com.wemanity.ecommerce.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wemanity.ecommerce.entites.Category;
import com.wemanity.ecommerce.entites.Item;
import com.wemanity.ecommerce.entites.OrderCustomer;
import com.wemanity.ecommerce.entites.OrderItem;
import com.wemanity.ecommerce.metier.IECommerceMetier;

public class TestConsult {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
		IECommerceMetier metier = (IECommerceMetier) context.getBean("metier");

		List<Category> cats = metier.getCategories();
		List<Item> items = metier.getItems();
		System.out.println("\n************Liste des catégories *************\n");
		for(Category cat : cats) {
			System.out.println("\t\t"+cat.getNameCat()+"\t\t");
			
			System.out.println("Libellé\t\tPrix\tMarque");
			for(Item item : items) {
				if(item.getCategoryItem().getCodeCat() == cat.getCodeCat()) {
					System.out.println(item.getNameItem()+"\t"+item.getPriceItem()+"€\t"+item.getBrandItem().getNameBrand());
				}
			}
			System.out.println("\n");
		}
		
		System.out.println("\n\n************Liste des commandes *************\n");
		List<OrderCustomer> odCusts = metier.getOrderCustomers();
		List<OrderItem> itemsO = metier.getOrderItems();
		for(OrderCustomer o : odCusts) {
			System.out.println("\t\tCommande n°"+o.getCodeOrder()+"\t\t");
			System.out.println("Client: "+o.getCustomerOrder().getNameCustomer()+" domicilié à "+o.getCustomerOrder().getAddressCustomer()+". GSM: "+o.getCustomerOrder().getPhoneNumber());
			for(OrderItem ito : itemsO) 
				if(ito.getOrderCustomer().getCodeOrder() == o.getCodeOrder()) {
					System.out.println(ito.getItemOrder().getNameItem()+"\t"+ito.getItemOrder().getBrandItem().getNameBrand()+"\t"+ito.getPriceUnit()+"€\t"+ito.getQuantity());
			}
			if(o.isStateOrder())
				System.out.println("Commande traité");
			else
				System.out.println("Commande en cours de traitement\n");
		}


	}

}
