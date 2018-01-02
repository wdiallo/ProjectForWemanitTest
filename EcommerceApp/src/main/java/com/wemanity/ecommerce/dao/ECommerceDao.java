package com.wemanity.ecommerce.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.wemanity.ecommerce.entites.Brand;
import com.wemanity.ecommerce.entites.Category;
import com.wemanity.ecommerce.entites.Customer;
import com.wemanity.ecommerce.entites.Item;
import com.wemanity.ecommerce.entites.OrderCustomer;
import com.wemanity.ecommerce.entites.OrderItem;

@Transactional
public class ECommerceDao implements IECommerceDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Category addCategory(Category c) {
		em.persist(c);
		return c;
	}

	@Override
	public Customer addCustomer(Customer c) {
		em.persist(c);
		return c;
	}

	@Override
	public Item addItem(Item it, Long codeCat, Long codeBrand) {
		if(codeCat != null) {
			Category cat = consultCategory(codeCat);
			Brand b = consultBrand(codeBrand);
			it.setCodeCategory(cat);
			it.setBrandItem(b);
		}
		em.persist(it);
		return it;
	}

	@Override
	public Brand addBrand(Brand b) {
		em.persist(b);
		return b;
	}

	@Override
	public OrderCustomer addOrderCustomer(OrderCustomer o, Long codeCust) {
		if(codeCust != null) {
			Customer cust = consultCustomer(codeCust);
			o.setCustomerOrder(cust);
		}
		em.persist(o);
		return o;
	}

	@Override
	public OrderItem addOrderItem(OrderItem oi, Long codeOrderCust, Long codeItem) {
		if(codeOrderCust != null) {
			OrderCustomer ord = consultOrderCustomer(codeOrderCust);
			Item it = consultItem(codeItem);
			oi.setOrderCustomer(ord);
			oi.setItemOrder(it);
		}
		em.persist(oi);
		return oi;
	}

	@Override
	public Category consultCategory(Long codeCat) {
		Category cat = em.find(Category.class, codeCat);
		if(cat == null) throw new RuntimeException("Category not found!");
		return cat;
	}

	@Override
	public Customer consultCustomer(Long codeCust) {
		Customer cust = em.find(Customer.class, codeCust);
		if(cust == null) throw new RuntimeException("Customer not found!");
		return cust;
	}

	@Override
	public Item consultItem(Long codeItem) {
		Item it = em.find(Item.class, codeItem);
		if(it == null) throw new RuntimeException("Item not found!");
		return it;
	}

	@Override
	public Brand consultBrand(Long codeBrand) {
		Brand b = em.find(Brand.class, codeBrand);
		if(b == null) throw new RuntimeException("Brand not found!");
		return b;
	}

	@Override
	public OrderCustomer consultOrderCustomer(Long codeOrderCust) {
		OrderCustomer o = em.find(OrderCustomer.class, codeOrderCust);
		if(o == null) throw new RuntimeException("Customer Order not found!");
		return o;
	}

	@Override
	public OrderItem consultOrderItem(Long codeOrderItem) {
		OrderItem oi = em.find(OrderItem.class, codeOrderItem);
		if(oi == null) throw new RuntimeException("Item Order not found!");
		return oi;
	}

	@Override
	public OrderItem consultOrderItemByOrderCustAndItemOrder(Long codeOrderdItem, Long codeOrderCust) {
		Query req = em.createQuery("select o from OrderItem o where o.itemOrder.codeOrdItem = :x and o.customerOrder.codeOrder = :y");
		req.setParameter("x", codeOrderdItem);
		req.setParameter("y", codeOrderCust); 
		return (OrderItem) req.getSingleResult();
	}

	@Override
	public List<Category> consultCategoryByKeyWord(String keyWord) {
		Query req = em.createQuery("select c from Category c where c.nameCat like :x");
		req.setParameter("x", "%"+keyWord+"%");
		return req.getResultList();
	}

	@Override
	public List<Customer> consultCustomerByKeyWord(String keyWord) {
		Query req = em.createQuery("select c from Customer c where c.nameCustomer like :x");
		req.setParameter("x", "%"+keyWord+"%");
		return req.getResultList();
	}

	@Override
	public List<Brand> consultBrandByKeyWord(String keyWord) {
		Query req = em.createQuery("select b from Brand b where b.nameBrand like :x");
		req.setParameter("x", "%"+keyWord+"%");
		return req.getResultList();
	}

	@Override
	public List<Category> getCategories() {
		Query req = em.createQuery("select c from Category c");
		return req.getResultList();
	}

	@Override
	public List<Customer> getCustomers() {
		Query req = em.createQuery("select c from Customer c");
		return req.getResultList();
	}

	@Override
	public List<Item> getItems() {
		Query req = em.createQuery("select i from Item i");
		return req.getResultList();
	}

	@Override
	public List<Brand> getBrands() {
		Query req = em.createQuery("select b from Brand b");
		return req.getResultList();
	}

	@Override
	public List<OrderCustomer> getOrderCustomers() {
		Query req = em.createQuery("select co from OrderCustomer co");
		return req.getResultList();
	}

	@Override
	public List<OrderItem> getOrderItems() {
		Query req = em.createQuery("select ot from OrderItem ot");
		return req.getResultList();
	}

	@Override
	public List<Item> getItemByCategory(Long codeCat) {
		Query req = em.createQuery("select i from Item i where i.categoryItem.codeCat = :x");
		req.setParameter("x", codeCat);
		return req.getResultList();
	}

	@Override
	public List<Item> getItemByBrand(Long codeBrand) {
		Query req = em.createQuery("select i from Item i where i.brandItem.codeBrand = :x");
		req.setParameter("x", codeBrand);
		return req.getResultList();
	}

	@Override
	public List<OrderCustomer> consultOrderByCustomer(Long codeCust) {
		Query req = em.createQuery("select o from OrderCustomer o where o.customerOrder.codeCustomer = :x");
		req.setParameter("x", codeCust);
		return req.getResultList();
	}

}
