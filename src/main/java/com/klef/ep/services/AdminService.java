package com.klef.ep.services;

import java.util.List;

import javax.ejb.Remote;

import com.klef.ep.models.Admin;
import com.klef.ep.models.Stock;
import com.klef.ep.models.Supplier;

@Remote
public interface AdminService 
{
  public Admin checkadminlogin(String username,String password);
  
  public String addadmin(Admin admin);
  public String addsupplier(Supplier supplier); 
  public List<Supplier> viewallsuppliers();
  public long suppliercount();
  public String deletesupplier(int sid);
  public Supplier viewsupplierbyid(int sid);
  public String updatesupplier(Supplier supplier);
  
  public String addstock(Stock stock);
  public long stockcount();
  public List<Stock> viewallstock();
  public String deletestock(String sid);
  public Stock viewstockbyid(int sid);
  public String updatestock(Stock stock);
  
  public List<Stock> ViewAllStocks();
  public Stock ViewStockById(String itemCode); 
}
