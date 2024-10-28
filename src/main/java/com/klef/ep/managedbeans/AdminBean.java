package com.klef.ep.managedbeans;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.klef.ep.models.Admin;
import com.klef.ep.models.Stock;
import com.klef.ep.models.Supplier;
import com.klef.ep.services.AdminService;

@ManagedBean(name="adminbean", eager=true)
public class AdminBean {

  @EJB(lookup="java:global/StockManagementSystem/AdminServiceImpl!com.klef.ep.services.AdminService")
  AdminService adminService;
  
//  @ManagedProperty(value="#{supplierbean}")
//  private SupplierBean supplierBean;
  
  
  private String username;
  private String password;
  
  private Supplier supplier = new Supplier();
  private List<Supplier> supplierlist;
  private Supplier suppliercount;

  private Stock stock = new Stock();
  private List<Stock> stocklist;
 
public List<Stock> getStocklist() {
	return adminService.viewallstock();
}

public void setStocklist(List<Stock> stocklist) {
	this.stocklist = stocklist;
}

public Stock getStock() {
	return stock;
}

public void setStock(Stock stock) {
	this.stock = stock;
}

public List<Supplier> getSupplierlist() {
	return adminService.viewallsuppliers();
}

public void setSupplierlist(List<Supplier> supplierlist) {
	this.supplierlist = supplierlist;
}

public Supplier getSupplier() {
	return supplier;
}

public void setSupplier(Supplier supplier) {
	this.supplier = supplier;
}

public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }




  public void validateadminlogin() throws IOException {
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
    HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
  
    Admin admin = adminService.checkadminlogin(username, password);
   
    if (admin != null) {
      HttpSession session = request.getSession();
      session.setAttribute("admin", admin);
      response.sendRedirect("adminhome.jsp");
    }
//    } else {
//      return null;
//    }
  }
  
  public String addadmin() {
    Admin admin = new Admin();
    admin.setUsername(username);
    admin.setPassword(password);
    adminService.addadmin(admin);
    return "addadmin.jsf?faces-redirect=true";
}
  public String add() {
  
    adminService.addsupplier(supplier);
    return "supplierreg.jsf?faces-redirect=true";
  }

public long getSuppliercount() {
	return adminService.suppliercount();
}

public String delete(int sid)
{
	adminService.deletesupplier(sid);
	
	return "viewallsuppliers.jsf";
}
  
public String update()
{
	  adminService.updatesupplier(supplier);
	
	return "updatesupplierbyadmin1.jsf?faces-redirect=true";
	
	
	
}
  

public String addstock() {
	  
    adminService.addstock(stock);
    return "addstock.jsf?faces-redirect=true"; // query param
  }

public String deletestock(String sid)
{
	adminService.deletestock(sid);
	
	return "viewallstock.jsf";
}

public String updatestock()
{
	  adminService.updatestock(stock);
	
	return "updatestock.jsf?faces-redirect=true";
	
	
	
}

}