package com.klef.ep.services;

import java.util.List;

import javax.ejb.Remote;

import com.klef.ep.models.Stock;
import com.klef.ep.models.Supplier;

@Remote
public interface SupplierService 
{

	public Supplier checksupplierlogin(String email,String password);
	
	public Supplier viewsupbyid(int sid);
	public String updatesupplier(Supplier supplier);
	public String dispatch(Stock stock);
	public String addstock(Stock stock);
	public List<Stock> viewallstock(String name);
	public String deletestock(String sid);
	public Stock viewstockbyid(String itemCode);
	public long stockcount(String name);
	public String updatestock(Stock stock);
	
}
