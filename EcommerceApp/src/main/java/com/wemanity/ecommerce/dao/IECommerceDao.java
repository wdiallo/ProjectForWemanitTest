package com.wemanity.ecommerce.dao;

import java.util.List;

import com.wemanity.ecommerce.entites.Brand;
import com.wemanity.ecommerce.entites.Category;
import com.wemanity.ecommerce.entites.Customer;
import com.wemanity.ecommerce.entites.Item;
import com.wemanity.ecommerce.entites.OrderCustomer;
import com.wemanity.ecommerce.entites.OrderItem;

public interface IECommerceDao {
	
	public Category addCategory(Category c);
	public Customer addCustomer(Customer c);
	public Item addItem(Item it, Long codeCat, Long codeBrand);
	public Brand addBrand(Brand b);
	public OrderCustomer addOrder(OrderCustomer o, Long codeCust);
	public OrderItem addOrderItem(OrderItem oi, Long codeOrderCust, Long codeItem);
	
	public Category consultCategory(Long codeCat);
	public Customer consultCustomer(Long codeCust);
	public Item consultItem(Long codeItem);
	public Brand consultBrand(Long codeBrand);
	public OrderCustomer consultOrderCustomer(Long codeOrderCust);
	public OrderItem consultOrderItem(Long codeOrderItem);
	public OrderItem consultOrderItemByOrderCustAndItemOrder(Long codeOrderdItem, Long codeOrderCust);
	
	public List<Category> consultCategoryByKeyWord(String keyWord);
	public List<Customer> consultCustomerByKeyWord(String keyWord);
	public List<Brand> consultBrandByKeyWord(String keyWord);
	public List<Category> getCategories();
	public List<Customer> getCustomers();
	public List<Item> getItems();
	public List<Brand> getBrands();
	public List<OrderCustomer> getOrderCustomers();
	public List<OrderItem> getOrderItems();
	
	public List<Item> getItemByCategory(Long codeCat);
	public List<Item> getItemByBrand(Long codeBrand);
	public List<OrderCustomer> consultOrderByCustomer(Long codeCust);
}
