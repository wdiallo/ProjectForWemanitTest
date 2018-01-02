package com.wemanity.ecommerce.metier;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.wemanity.ecommerce.dao.IECommerceDao;
import com.wemanity.ecommerce.entites.Brand;
import com.wemanity.ecommerce.entites.Category;
import com.wemanity.ecommerce.entites.Customer;
import com.wemanity.ecommerce.entites.Item;
import com.wemanity.ecommerce.entites.OrderCustomer;
import com.wemanity.ecommerce.entites.OrderItem;

@Transactional
public class ECommerceMetier implements IECommerceMetier{

	private IECommerceDao dao;
	
	public void setDao(IECommerceDao dao) {
		this.dao = dao;
	}
	
	@Override
	public Category addCategory(Category c) {
		return dao.addCategory(c);
	}

	@Override
	public Customer addCustomer(Customer c) {
		return dao.addCustomer(c);
	}

	@Override
	public Item addItem(Item it, Long codeCat, Long codeBrand) {
		return dao.addItem(it, codeCat, codeBrand);
	}

	@Override
	public Brand addBrand(Brand b) {
		return dao.addBrand(b);
	}

	@Override
	public OrderCustomer addOrder(OrderCustomer o, Long codeCust) {
		return dao.addOrder(o, codeCust);
	}

	@Override
	public OrderItem addOrderItem(OrderItem oi, Long codeOrderCust, Long codeItem) {
		return dao.addOrderItem(oi, codeOrderCust, codeItem);
	}

	@Override
	public Category consultCategory(Long codeCat) {
		return dao.consultCategory(codeCat);
	}

	@Override
	public Customer consultCustomer(Long codeCust) {
		return dao.consultCustomer(codeCust);
	}

	@Override
	public Item consultItem(Long codeItem) {
		return dao.consultItem(codeItem);
	}

	@Override
	public Brand consultBrand(Long codeBrand) {
		return dao.consultBrand(codeBrand);
	}

	@Override
	public OrderCustomer consultOrderCustomer(Long codeOrderCust) {
		return dao.consultOrderCustomer(codeOrderCust);
	}

	@Override
	public OrderItem consultOrderItem(Long codeOrderItem) {
		return dao.consultOrderItem(codeOrderItem);
	}

	@Override
	public OrderItem consultOrderItemByOrderCustAndItemOrder(Long codeOrderdItem, Long codeOrderCust) {
		return dao.consultOrderItemByOrderCustAndItemOrder(codeOrderdItem, codeOrderCust);
	}

	@Override
	public List<Category> consultCategoryByKeyWord(String keyWord) {
		return dao.consultCategoryByKeyWord(keyWord);
	}

	@Override
	public List<Customer> consultCustomerByKeyWord(String keyWord) {
		return dao.consultCustomerByKeyWord(keyWord);
	}

	@Override
	public List<Brand> consultBrandByKeyWord(String keyWord) {
		return dao.consultBrandByKeyWord(keyWord);
	}

	@Override
	public List<Category> getCategories() {
		return dao.getCategories();
	}

	@Override
	public List<Customer> getCustomers() {
		return dao.getCustomers();
	}

	@Override
	public List<Item> getItems() {
		return dao.getItems();
	}

	@Override
	public List<Brand> getBrands() {
		return dao.getBrands();
	}

	@Override
	public List<OrderCustomer> getOrderCustomers() {
		return dao.getOrderCustomers();
	}

	@Override
	public List<OrderItem> getOrderItems() {
		return dao.getOrderItems();
	}

}
