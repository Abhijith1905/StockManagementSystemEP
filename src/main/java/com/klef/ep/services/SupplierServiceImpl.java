package com.klef.ep.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.klef.ep.models.Stock;
import com.klef.ep.models.Supplier;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class SupplierServiceImpl implements SupplierService
{

	@Override
	public Supplier checksupplierlogin(String email, String password) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	    EntityManager em = emf.createEntityManager();
	    
	    
	    Query qry = em.createQuery("select s from Supplier s where s.email=? and s.password=?  ");
	    qry.setParameter(1, email);
	    qry.setParameter(2, password);
	    
	        Supplier supplier = null;
	        
	        if(qry.getResultList().size()>0)
	        {
	          supplier = (Supplier) qry.getSingleResult();
	        }
	    em.close();
	    emf.close();
	    
	    return supplier;
	}

	@Override
	public String addstock(Stock stock) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(stock); 
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return "Stock Added Successfully";
	}

	 @Override
	  public List<Stock> viewallstock(String addedBy) {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	    EntityManager em = emf.createEntityManager();
	    
	    Query qry = em.createQuery("select s from Stock s where s.addedBy=?1");
	    qry.setParameter(1, addedBy);
	    List<Stock> stocklist = qry.getResultList();
	    
	    em.close();
	    emf.close();
	    
	    return stocklist;
	  }

	@Override
	public String deletestock(String sid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Stock e = em.find(Stock.class, sid);
		em.remove(e);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return "Supplier Deleted Successfully";
	}

	@Override
	public Stock viewstockbyid(String itemCode) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		Stock s = em.find(Stock.class, itemCode);
		
		if(s==null)
		{
			em.close();
			emf.close();
			return null;
		}
		
		
		em.close();
		emf.close();
		
		return s;
	}

	@Override
	public Supplier viewsupbyid(int sid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		Supplier s = em.find(Supplier.class, sid);
		
		if(s==null)
		{
			em.close();
			emf.close();
			
			return null;
		}
		
		em.close();
		emf.close();
		
		return s;
	}

	@Override
	public String updatesupplier(Supplier supplier) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Supplier s = em.find(Supplier.class, supplier.getId());
		
		s.setName(supplier.getName());
		s.setContactno(supplier.getContactno());
		s.setPassword(supplier.getPassword());
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return "Supplier Updated Successfully";
	}

	@Override
	public String dispatch(Stock stock) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Stock s = em.find(Stock.class, stock.getItemCode());
		
		s.setQuantity(stock.getQuantity());
	
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return "Quantity Dispatched Successfully";
	}

	@Override
	public long stockcount(String addedBy) {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	    EntityManager em = emf.createEntityManager();
	    
	    Query qry = em.createQuery("select count(s) from Stock s where s.addedBy = :addedBy");
	    qry.setParameter("addedBy", addedBy);
	    long count = (long) qry.getSingleResult();
	    
	    em.close();
	    emf.close();
	    
	    return count;
	}

	@Override
	public String updatestock(Stock stock) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Stock s = em.find(Stock.class, stock.getItemCode());
		s.setQuantity(stock.getQuantity());
		s.setUnitPrice(stock.getUnitPrice());
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return "Stock Updated Successfully";
	}

}
