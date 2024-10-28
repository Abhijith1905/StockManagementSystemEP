package com.klef.ep.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.klef.ep.models.Admin;
import com.klef.ep.models.Stock;
import com.klef.ep.models.Supplier;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class AdminServiceImpl implements AdminService
{

	@Override
	public Admin checkadminlogin(String username, String password) 
	{
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	    EntityManager em = emf.createEntityManager();
	    
	    // a is an alias of Admin Class
	    Query qry = em.createQuery("select a from Admin a where a.username=? and a.password=?  ");
	    qry.setParameter(1, username);
	    qry.setParameter(2, password);
	    
	        Admin admin = null;
	        
	        if(qry.getResultList().size()>0)
	        {
	          admin = (Admin) qry.getSingleResult();
	        }
	    em.close();
	    emf.close();
	    
	    return admin;
	}

	@Override
    public String addadmin(Admin admin) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	    EntityManager em = emf.createEntityManager();
	    
        em.getTransaction().begin();
        em.persist(admin);
        em.getTransaction().commit();
        em.close();
        return "Admin Added Successfully";
    }
	@Override
	public String addsupplier(Supplier supplier)
	{
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(supplier); 
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return "Supplier Registered Successfully";
	}

	@Override
	public List<Supplier> viewallsuppliers() {
		
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	    EntityManager em = emf.createEntityManager();
	    
	    Query qry = em.createQuery("select s from Supplier s");
	    
	    List<Supplier> supplierlist = qry.getResultList();
	    
	      em.close();
	      emf.close();
	      
	      return supplierlist;
	}

	@Override
	public long suppliercount() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	    EntityManager em = emf.createEntityManager();
	    
	    Query qry =  em.createQuery("select count(*) from Supplier");
	    List list = qry.getResultList();
	    
	    long count = (long) list.get(0);       //only one element
	    
	    
		return count;
	}

	@Override
	public String deletesupplier(int sid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Supplier e = em.find(Supplier.class, sid);
		em.remove(e);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return "Supplier Deleted Successfully";
	}

	@Override
	public String updatesupplier(Supplier supplier) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Supplier s = em.find(Supplier.class, supplier.getId());
		s.setContactno(supplier.getContactno());
		s.setName(supplier.getName());
		s.setPassword(supplier.getPassword());
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return "Supplier Updated Successfully";
	}

	@Override
	public Supplier viewsupplierbyid(int sid) {
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
	public List<Stock> viewallstock() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	    EntityManager em = emf.createEntityManager();
	    
	    Query qry = em.createQuery("select s from Stock s");
	    
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
	public Stock viewstockbyid(int sid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		Stock s = em.find(Stock.class, sid);
		
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
	
	@Override
	public long stockcount() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	    EntityManager em = emf.createEntityManager();
	    
	    Query qry =  em.createQuery("select count(*) from Stock");
	    List list = qry.getResultList();
	    
	    long count = (long) list.get(0);      
	    
	    
		return count;
	}

	public List<Stock> ViewAllStocks() 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	 	 EntityManager em = emf.createEntityManager();
	 	  
	    em.getTransaction().begin();
	    
	    Query qry = em.createQuery("   select s from Stock s "); 
	    List<Stock> stocklist = qry.getResultList();
	 
	    em.close();
		    emf.close();
		    
		    return stocklist;
	}

	public Stock ViewStockById(String itemCode) 
	{
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	  	 EntityManager em = emf.createEntityManager();
	  	  
	     em.getTransaction().begin();
	     
	     Query qry = em.createQuery("  select s from Stock s where itemCode=?  "); 
	     qry.setParameter(1, itemCode);
	     
	     Stock s = null;
	     
	     if(qry.getResultList().size() > 0) 
	     {
	    	    s = (Stock) qry.getSingleResult();
	     }
	     
	     em.close();
	     emf.close();
	   
	     return s;
	}
}
