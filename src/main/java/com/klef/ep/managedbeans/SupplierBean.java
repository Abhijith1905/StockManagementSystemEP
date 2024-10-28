package com.klef.ep.managedbeans;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.klef.ep.models.Admin;
import com.klef.ep.models.Stock;
import com.klef.ep.models.Supplier;
import com.klef.ep.services.AdminService;
import com.klef.ep.services.SupplierService;

@ManagedBean(name="supplierbean",eager = true)
public class SupplierBean 
{
	@EJB(lookup="java:global/StockManagementSystem/SupplierServiceImpl!com.klef.ep.services.SupplierService")
	  SupplierService supplierService;
	
    private int id;
	private String name;
	private double age;
	private String gender;
	private String category;
	private String contactno;
	private String email;
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		 this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAge() {
		return age;
	}
	public void setAge(double age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	private Stock stock = new Stock();
	 private List<Stock> stocklist;
	
	
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	 public List<Stock> getStocklist() {
		    FacesContext facesContext = FacesContext.getCurrentInstance();
		    ExternalContext externalContext = facesContext.getExternalContext();
		    HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		    HttpSession session = request.getSession();
		    Supplier supplier = (Supplier) session.getAttribute("supplier");
		    return supplierService.viewallstock(supplier.getName());
		  }

		  public void setStocklist(List<Stock> stocklist) {
		    this.stocklist = stocklist;
		  }
	
	
	public void validatesupplierlogin() throws IOException {
	    FacesContext facesContext = FacesContext.getCurrentInstance();
	    ExternalContext externalContext = facesContext.getExternalContext();
	    HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
	    HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
	  
	    Supplier supplier = supplierService.checksupplierlogin(email, password);
	   
	    if (supplier != null) {
	      HttpSession session = request.getSession();
	      session.setAttribute("supplier", supplier);
	      response.sendRedirect("supplierhome.jsp");
	      
	    } 
//	    else {
//	      return "redirect:Login?error";
//	    }
	  }
	
	
	public String addstock() {
		  
	    supplierService.addstock(stock);
	    return "addstockbysupplier.jsf?faces-redirect=true"; // query param
	  }

	public String deletestock(String sid)
	{
		supplierService.deletestock(sid);
		
		return "viewallstock.jsf";
	}
	

	public String updatestock()
	{
		  supplierService.updatestock(stock);
		
		return "updatestockbysupplier1.jsf?faces-redirect=true";
		
		
		
	}
	  
}
